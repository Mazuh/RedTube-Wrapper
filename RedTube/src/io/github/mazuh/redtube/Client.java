package io.github.mazuh.redtube;

import io.github.mazuh.redtube.exceptions.MalformedURLError;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 *
 * @author mazuh
 */
public class Client {
    
    
    private final static String API_ROOT = "https://api.redtube.com/";
    private final static String DEFAULT_METHOD = "GET";
    
    
    
    public static String execute(String parameters) throws IOException{
        
        HttpURLConnection openedConnection = null;
        String response = "";
        
        try{
            
            openedConnection = Client.createOpenedHttpConnection();
        
            Client.sendRequest(openedConnection, parameters);
            Client.readResponse(openedConnection);
        
        } finally{
            if (openedConnection != null)
                openedConnection.disconnect();
        }
        
        return response;
        
    }
    
    
    
    private static HttpURLConnection createOpenedHttpConnection() throws IOException{

        try{
            
            URL url = new URL(Client.API_ROOT);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        
            connection.setRequestMethod(Client.DEFAULT_METHOD);
        
            connection.setUseCaches(false);
            connection.setDoOutput(true);
            
            return connection;
        
        } catch(MalformedURLException e){
            throw new MalformedURLError("Bad root URL for API.", e);
        } catch(IOException e){
            throw new IOException("Failed to open HTTP connection.", e);
        }
        
    }
    
    
    
    private static void sendRequest(HttpURLConnection openedConnection, String parameters) throws IOException {
        
        openedConnection.setRequestProperty(
                "Content-Length",
                Integer.toString(parameters.getBytes().length)
        );
        
        try (DataOutputStream output = new DataOutputStream(openedConnection.getOutputStream())) {
            output.writeBytes(parameters);
        } catch(IOException e){
            throw  new IOException("Failed to send HTTP request.", e);
        }

    }
    
    
    
    private static String readResponse(HttpURLConnection openedConnection) throws IOException{
        
        InputStream input = openedConnection.getInputStream();
        
        try (BufferedReader bufferReader = new BufferedReader(new InputStreamReader(input))) {
            
            StringBuilder responseBuffer = new StringBuilder();
            String line;
            
            while((line = bufferReader.readLine()) != null){
                responseBuffer.append(line);
                responseBuffer.append('\r');
            }
            
            return responseBuffer.toString();
            
        } catch(IOException e){
            throw new IOException("Failed to handle HTTP response.", e);
        }
        
    }
    
    
}