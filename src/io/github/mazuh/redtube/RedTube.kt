package io.github.mazuh.redtube

import kotlin.collections.Map

fun main(args: Array<String>) {
    
    val client = HTTPClient()
    
    val parameters = hashMapOf(
        "data" to "redtube.Videos.searchVideos",
        "output" to "xml",
        "search" to "hard",
        "thumbsize" to "all",
        "tags[]" to "Teen"
    )
    
    val oe = client.query(parameters);
    println(oe);
}