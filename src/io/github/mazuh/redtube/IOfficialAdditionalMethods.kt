package io.github.mazuh.redtube

import io.github.mazuh.redtube.resources.Category
import io.github.mazuh.redtube.resources.Star
import io.github.mazuh.redtube.resources.Tag


/**
 * Official methods already low level documented by the official RedTube API.
 *
 * Therefore, all of these don't actually need a significant local implementation,
 * since they're are available through simple HTTP requests.
 *
 * @author mazuh
 * @see originaldocs https://api.redtube.com/docs/
 */ 
interface IOfficialAdditionalMethods {
    
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