package io.github.mazuh.redtube

import kotlin.collections.Map
import io.github.mazuh.redtube.connection.HTTPClient

fun main(args: Array<String>) {
    
    val client = HTTPClient()
    
    val parameters = hashMapOf<String, String>(
        "data" to "redtube.Videos.searchVideos",
        "output" to "json",
        "search" to "hard",
        "thumbsize" to "all",
        "tags[]" to "Teen"
    )
    
    val oe = client.query(parameters);
    println(oe);
}