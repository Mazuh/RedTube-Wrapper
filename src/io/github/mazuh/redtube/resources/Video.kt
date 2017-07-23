package io.github.mazuh.redtube.resources

import java.net.URL
import java.util.Calendar

/** Represents a domain class for any RedTube video.
 * Should be created from JSON.
 *
 * @author mazuh
 */
class Video {
    
    val id: Long = 0
    
    val title: String? = null
    var tags: Array<Tag>? = null
    
    val url: URL? = null
    val embedUrl: URL? = null
    
    val duration: Calendar? = null // deserves lambda function (search at Terminal588 for Onibus.getCalendar)
    val views: Int? = null
    val rating: Float? = null
    val ratings: Int? = null
    
    val defaultThumb: Thumb? = null
    val publishDate: Calendar? = null
    
    val thumbs: Array<Thumb>? = null

}