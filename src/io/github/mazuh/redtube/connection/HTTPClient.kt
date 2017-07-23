package io.github.mazuh.redtube.connection

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URL
import kotlin.collections.Map

/** A HTTP client for simple access to RedTube API. 
 * It wraps read-only operations (since it access only the public API).
 *
 * Don't call this directly: it's recommended to use it through a wrapper domain class.
 *
 * WARNING: May be blocked in your network due to NSFW filters (ask the network admin).
 * TODO: allow config properties with some default constant vals from RedTubeTest
 * @author mazuh
 */
class HTTPClient {


    val ENDPOINT: String = "https://api.redtube.com/"
    val DEFAULT_METHOD: String = "GET"


    /** Assemble a HTTP request, send it and return its response.
     * It's already configured to access RedTube API only.
     *
     * @param parameters    url query params to attach before sending the request
     * @return              a string of all the retrieved response
     * @throws IOException  if the sending or receiving couldn't be done.
     */
    fun query(parameters: Map<String, String>): String?{
        val url: URL
        var openedConnection: HttpURLConnection? = null
        
        try{
            // configuring request...
            url = createQueryURL(parameters)
            openedConnection = url.openConnection() as HttpURLConnection?
            
            openedConnection?.setRequestMethod(DEFAULT_METHOD)
            openedConnection?.setUseCaches(false)
            openedConnection?.setDoOutput(true)
            
            // sending it
            val responseCode = openedConnection?.getResponseCode()
            if (responseCode != 200)
                throw IOException("Retrieved HTTP code: $responseCode.")
            
            // reading the response
            val reader: BufferedReader = BufferedReader(InputStreamReader(openedConnection?.getInputStream()))
            val response = StringBuilder()
            
            var line: String? = ""
            while (line != null){
                response.append(line).append('\n')
                line = reader.readLine()
            }
            
            // bye
            reader.close()
            
            return response.toString()
            
        } catch(e: Exception){
            throw IOException("Failed to send HTTP request.", e)
        } finally{
            System.out.println("finally, dude...")
            openedConnection?.disconnect()
        }
    }


    /** Create an URL using the given query parameters, to access RedTube API.
     *
     * @param parameters
     * @return the formed URL for RedTube API
     * @throws MalformedURLException
     */
    fun createQueryURL(parameters: Map<String, String>?): URL {
        var url: StringBuilder = StringBuilder(ENDPOINT)
        
        url.append('?')
        parameters?.forEach{
            key, value -> url.append(key).append('=').append(value).append('&')
        }
        
        try{
            return URL(url.toString())
        } catch(e: MalformedURLException){
            throw MalformedURLException("Bad URL: ${url.toString()}")
        }
    }

}
