package io.github.mazuh.redtube.exceptions;

/**
 *
 * @author mazuh
 */
public class MalformedURLError extends Error {
    
    public MalformedURLError() { 
        super(); 
    }
    
    public MalformedURLError(String message) { 
        super(message); 
    }
    
    public MalformedURLError(String message, Throwable cause) {
        super(message, cause); 
    }
    
    public MalformedURLError(Throwable cause) {
        super(cause);
    }
}
