package io.github.mazuh.redtube;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

/** A HTTP client for simple access RedTube API.
 * Made to be used by some wrapper.
 *
 * @author mazuh
 */
public class Client {
    
    
    //private final static String ENDPOINT = "https://api.redtube.com/";
    private final static String ENDPOINT = "https://api.redtube.com/?data=redtube.Videos.searchVideos&output=xml&search=hard&tags[]=Teen&thumbsize=all&";
    private final static String DEFAULT_METHOD = "GET";
    
    /** Assemble a HTTP request, send it and return its response.
     * It's already configured to access RedTube API only.
     *
     * @param parameters    url HTTP params to attach before sending the request
     *                      (can be null if there isn't any)
     * @return              a string of all the retrieved response
     * @throws IOException  if the sending or receiving couldn't be done.
     */
    public static String execute(HashMap parameters) throws IOException{
        
        HttpURLConnection openedConnection = null;
        String response = "";
        int responseCode;
        
        try{
            
            URL url = Client.generateURL(parameters);
            
            openedConnection = (HttpURLConnection) url.openConnection();
            openedConnection.setRequestMethod(DEFAULT_METHOD);
            openedConnection.setUseCaches(false);
            openedConnection.setDoOutput(true);
            
            if ((responseCode = openedConnection.getResponseCode()) == 200)
                response = openedConnection.getResponseMessage(); // print OK
            else
                throw new IOException("Retrieved HTTP code: " + responseCode + ".");
            
        } catch (MalformedURLException e){
            throw new IOException("Failed to send HTTP request: client 400 error.", e);
        } catch (IOException e){
            throw new IOException("Failed to send HTTP request.", e);
        }finally{
            if (openedConnection != null)
                openedConnection.disconnect();
        }
        
        return response;
        
    }
    
    
    private static URL generateURL(HashMap parameters) throws MalformedURLException{
        
        StringBuilder url = new StringBuilder(Client.ENDPOINT);
        
        if (parameters != null){
            parameters.forEach((key, value) -> {
                url.append(key).append('=').append(value).append('&');
            });
        }
        
        try{
            
            return new URL(url.toString());
            
        } catch (MalformedURLException e){
            throw new MalformedURLException("Bad URL while creating request: " + url.toString());
        }
        
    }

}
