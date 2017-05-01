package io.github.mazuh.redtube;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mazuh
 */
public class RedTube {
    public static void main(String[] args){
        try {
            
            Map<String, String> parameters = new HashMap<>();
            parameters.put("data", "redtube.Videos.searchVideos");
            parameters.put("output", "xml");
            parameters.put("search", "hard");
            parameters.put("thumbsize", "all");
            parameters.put("tags[]", "Teen");
            
            String oe = Client.execute((HashMap) parameters);
            System.out.println(oe);
            
        } catch (IOException ex) {
            Logger.getLogger(RedTube.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
