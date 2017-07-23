package io.github.mazuh.redtube.connection

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
    fun searchVideo(category: String?,page: Int?, search: String?, tags: Array<String>?,
                    stars: Array<String>?, thumbsize: String?, ordering: String?, period: String?)
    
    /**
     * Retrieves additional information about a specific video.
     *
     * @param videoId   (Required) Integer
     * @param thumbsize (Optional) If set, provides additional thumbnails in different formats.
     *                  Possible values are medium, small, big, all, medium1, medium2. 
     */
    fun getVideoById(videoId: Int, thumbsize: String?)
    
    /**
     * Retrieves state of a specific video.
     *
     * It is very useful to keep embedded videos up to date.
     *
     * @param videoId (Required) Integer
     */
    fun isVideoActive(videoId: Int)
    
    /**
     * Retrieves embed code (BASE64) for a specific video.
     *
     * @param videoId (Required) Integer
     */
    fun getVideoEmbedCode(videoId: Int)
    
    /**
     * Retrieves all deleted videos list.
     *
     * @param page (Required) Integer
     */
    fun getDeletedVideos(page: Int)
    
    
    
    // ADDITIONAL METHODS ------------------------------
    
    
    /**
     * Retrieves all available categories.
     */
    fun getCategoriesList()
    
    /**
     * Retrieves all tags available.
     */
    fun getTagList()
    
    /**
     * Retrieves all pornstars available.
     */
    fun getStarList()
    
    /**
     * Retrieves all pornstars available with details.
     */
    fun getStarDetailedList()

}