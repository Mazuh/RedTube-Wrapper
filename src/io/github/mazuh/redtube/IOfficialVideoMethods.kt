package io.github.mazuh.redtube

import io.github.mazuh.redtube.resources.Video
import io.github.mazuh.redtube.resources.Category
import io.github.mazuh.redtube.resources.Star
import io.github.mazuh.redtube.resources.Tag
import io.github.mazuh.redtube.resources.util.ThumbSize
import io.github.mazuh.redtube.resources.util.Ordering
import io.github.mazuh.redtube.resources.util.Period


/**
 * Official methods already low level documented by the official RedTube API.
 *
 * Therefore, all of these don't actually need a significant local implementation,
 * since they're are available through simple HTTP requests.
 *
 * @author mazuh
 * @see originaldocs https://api.redtube.com/docs/
 */ 
interface IOfficialVideoMethods {
    
    
    
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
     * @param ordering  (Optional) If set, the returned list is ordered according the selected value.
     * @param period    (Optional - needs 'ordering' param!) If set, the videos will come from a certain period.
     */
    fun searchVideo(category: Category?, page: Int?, search: String?, tags: Array<Tag>?,
                    stars: Array<Star>?, thumbsize: ThumbSize?, ordering: Ordering?,
                    period: Period?): Set<Video>
    
    /**
     * Retrieves additional information about a specific video.
     *
     * @param videoId   (Required) Integer
     * @param thumbsize (Optional) If set, provides additional thumbnails in different formats.
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
    fun getDeletedVideos(page: Int): Set<Video>
    
    
    
    // ADDITIONAL METHODS ------------------------------
    
    
    /**
     * Retrieves all available categories.
     */
    fun getCategoriesList(): Set<Category>
    
    /**
     * Retrieves all tags available.
     */
    fun getTagList(): Set<Tag>
    
    /**
     * Retrieves all pornstars names available.
     */
    fun getStarList(): Set<String>
    
    /**
     * Retrieves all pornstars available with details.
     */
    fun getStarDetailedList(): Set<Star>

}