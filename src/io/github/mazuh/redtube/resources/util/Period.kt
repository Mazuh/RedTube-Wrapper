package io.github.mazuh.redtube.resources.util

/** Period of video publishing, a filter used only with an ordering parameter filter.
 *
 * @author mazuh
 */
enum class Period(val param: String) {
    WEEKLY("weekly"),
    MONTHLY("monthly"),
    ALLTIME("alltime"),
}