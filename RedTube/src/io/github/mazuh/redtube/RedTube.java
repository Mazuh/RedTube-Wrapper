package io.github.mazuh.redtube;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mazuh
 */
public class RedTube {
    public static void main(String[] args){
        try {
            String oe = Client.execute(null);
            System.out.println(oe);
        } catch (IOException ex) {
            Logger.getLogger(RedTube.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
