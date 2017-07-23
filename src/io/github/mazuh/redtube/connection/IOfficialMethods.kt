package io.github.mazuh.redtube.connection

import io.github.mazuh.redtube.resources.Video
import io.github.mazuh.redtube.resources.Category
import io.github.mazuh.redtube.resources.Star
import io.github.mazuh.redtube.resources.Tag

/**
 * Official methods already low level documented by the official RedTube API.
 *
 * Therefore, all of these don't actually need a significant local implementation,
 * since they're are available through simple HTTP requests.
 *
 * @see: https://api.redtube.com/docs/
 */ 
interface IOfficialMethods {
    
    
    
    // VIDEO METHODS ------------------------------
    
    
    /**
     * Retrieves video list. Can be highly filtered.
     *
     * @param category  (Optional) String
     * @param page      (Optional) Integer / default 1
     * @param search    (Optional) String / search query string
     * @param tags      (Optional) Array
     * @param stars     (Optional) Array
     * @param thumbsize (Optional) If set, provides additional thumbnails in different formats.
     *                  Possible values are: medium, small, big, all, medium1, medium2.
     * @param ordering  (Optional) If set, the returned XML output is ordered according the selected value.
     *			Possible values are: newest, mostviewed, rating.
     * @param period    (Optional - works only when 'ordering' parameter is used!)
     *			If set, the returned XML output will deliver videos from a period, based on the
     *			selected value. Possible values are: weekly, monthly, alltime.
     */
    fun searchVideo(category: String?, page: Int?, search: String?, tags: Array<String>?,
                    stars: Array<String>?, thumbsize: String?, ordering: String?,
                    period: String?): Array<Video>
    
    /**
     * Retrieves additional information about a specific video.
     *
     * @param videoId   (Required) Integer
     * @param thumbsize (Optional) If set, provides additional thumbnails in different formats.
     *                  Possible values are medium, small, big, all, medium1, medium2. 
     */
    fun getVideoById(videoId: Long, thumbsize: String?): Video
    
    /**
     * Retrieves state of a specific video.
     *
     * It is very useful to keep embedded videos up to date.
     *
     * @param videoId (Required) Integer
     */
    fun isVideoActive(videoId: Long): Boolean
    
    /**
     * Retrieves embed code (BASE64) for a specific video.
     *
     * @param videoId (Required) Integer
     */
    fun getVideoEmbedCode(videoId: Long): String
    
    /**
     * Retrieves all deleted videos list.
     *
     * @param page (Required) Integer
     */
    fun getDeletedVideos(page: Int): Array<Video>
    
    
    
    // ADDITIONAL METHODS ------------------------------
    
    
    /**
     * Retrieves all available categories.
     */
    fun getCategoriesList(): Array<Category>
    
    /**
     * Retrieves all tags available.
     */
    fun getTagList(): Array<Tag>
    
    /**
     * Retrieves all pornstars names available.
     */
    fun getStarList(): Array<String>
    
    /**
     * Retrieves all pornstars available with details.
     */
    fun getStarDetailedList(): Array<Star>

}