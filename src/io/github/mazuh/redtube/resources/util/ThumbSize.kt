package io.github.mazuh.redtube.resources.util

/** An abstract definition for thumb sizes filtering.
 *
 * @author mazuh
 */
enum class ThumbSize(val param: String) {
    ALL("all"),
    SMALL("small"),
    MEDIUM("medium"),
    MEDIUM_1("medium1"),
    MEDIUM_2("medium2"),
    BIG("big"),
}