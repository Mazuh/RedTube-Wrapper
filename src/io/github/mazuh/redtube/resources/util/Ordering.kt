package io.github.mazuh.redtube.resources.util

/** Ordering filter for video queries.
 *
 * @author mazuh
 */
enum class Ordering(val param: String) {
    NEWEST("newest"),
    MOST_VIEWED("mostviewed"),
    RATING("rating"),
}