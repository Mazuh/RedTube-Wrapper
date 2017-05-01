package io.github.mazuh.redtube;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

/** A HTTP client for simple access RedTube API.
 * Made to be used by some wrapper.
 *
 * @author mazuh
 */
public class HTTPClient {
    
    
    private final static String ENDPOINT = "https://api.redtube.com/";
    private final static String DEFAULT_METHOD = "GET";
    
    
    /** Assemble a HTTP request, send it and return its response.
     * It's already configured to access RedTube API only.
     *
     * @param parameters    url query params to attach before sending the request
     * @return              a string of all the retrieved response
     * @throws IOException  if the sending or receiving couldn't be done.
     */
    public static String execute(HashMap parameters) throws IOException{
        
        URL url = null;
        HttpURLConnection openedConnection = null;
        String response = "";
        int responseCode;
        
        try{
            
            // configuring requests...
            url = HTTPClient.generateURL(parameters);
            
            openedConnection = (HttpURLConnection) url.openConnection();
            openedConnection.setRequestMethod(DEFAULT_METHOD);
            openedConnection.setUseCaches(false);
            openedConnection.setDoOutput(true);
            
            // sending (and checking its response)...
            if ((responseCode = openedConnection.getResponseCode()) != 200)
                throw new IOException("Retrieved HTTP code: " + responseCode + ".");
            
            // reading...
            InputStream input = openedConnection.getInputStream();
        
            try (BufferedReader bufferReader = new BufferedReader(new InputStreamReader(input))) {

                StringBuilder responseBuffer = new StringBuilder();
                String line;

                while((line = bufferReader.readLine()) != null){
                    responseBuffer.append(line);
                    responseBuffer.append('\r');
                }

                response = responseBuffer.toString(); // ...done!
            }

        } catch (MalformedURLException e){
            throw new IOException("Failed to send HTTP request (client 400 error).", e);
        } catch (IOException e){
            if (url != null)
                System.err.println("Failed at: " + url.toString());
            throw new IOException("Failed to send HTTP request.", e);
        }finally{
            if (openedConnection != null)
                openedConnection.disconnect();
        }
        
        return response;
        
    }
    
    
    
    /** Create an URL using the given query parameters, to access RedTube API.
     * 
     * @param parameters
     * @return the formed URL for RedTube API
     * @throws MalformedURLException 
     */
    private static URL generateURL(HashMap parameters) throws MalformedURLException{
        
        StringBuilder url = new StringBuilder(HTTPClient.ENDPOINT).append('?');
        
        if (parameters != null){
            parameters.forEach((key, value) -> {
                url.append(key).append('=').append(value).append('&');
            });
        }
        
        try{
            return new URL(url.toString());
            
        } catch (MalformedURLException e){
            System.err.println("Failed to create URL instance: " + url.toString());
            throw new MalformedURLException("Bad URL while creating request: " + url.toString());
        }
        
    }

}
