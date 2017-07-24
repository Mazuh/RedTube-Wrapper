package io.github.mazuh.redtube


import io.github.mazuh.redtube.resources.*
import io.github.mazuh.redtube.resources.util.*


/** Main class for RedTube API Wrapper.
 *
 * A Kotlin idiomatic way to find videos, categories, tags and more about RedTube API!
 * 
 * @author mazuh
 * @see repository https://github.com/Mazuh/RedTube-Wrapper 
 */
class RedTube: IOfficialVideoMethods, IOfficialAdditionalMethods{

    
    private val httpOutput: String = "json"
    
    
    constructor(){
        // pass
    }
    
    
    override fun searchVideo(category: Category?, page: Int?, search: String?, tags: Array<Tag>?,
                             stars: Array<Star>?, thumbsize: ThumbSize?, ordering: Ordering?,
                             period: Period?): Set<Video>{
        val videos: Set<Video> = HashSet<Video>()
        return videos
    }
    
    
    
    override fun getVideoById(videoId: Long, thumbsize: String?): Video{
        return Video()
    }
    
    
    
    override fun isVideoActive(videoId: Long): Boolean{
        return false
    }
    
    
    
    override fun getVideoEmbedCode(videoId: Long): String{
        return ""
    }
    
    
    
    override fun getDeletedVideos(page: Int): Set<Video>{
        val videos: Set<Video> = HashSet<Video>()
        return videos
    }
    
    
    
    override fun getCategoriesList(): Set<Category>{
        val categories: Set<Category> = HashSet<Category>()
        return categories
    }
    
    
    
    override fun getTagList(): Set<Tag>{
        val tags: Set<Tag> = HashSet<Tag>()
        return tags
    }
    
    
    
    override fun getStarList(): Set<String>{
        val stars: Set<String> = HashSet<String>()
        return stars
    }
    
    
    
    override fun getStarDetailedList(): Set<Star>{
        val stars: Set<Star> = HashSet<Star>()
        return stars
    }

}