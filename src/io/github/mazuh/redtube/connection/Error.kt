package io.github.mazuh.redtube.connection

/** Represents all documented RedTube error messages.
 * TODO: will it be turned into exceptions classes?
 *
 * @author mazuh
 */
enum class Error(val code: Int){
    NO_SUCH_METHOD(1001),
    NO_SUCH_DATA_PROVIDER(1002),
    NO_INPUT_PARAMETERS_SPECIFIED(1003),
    NO_VIDEOS_FOUND(2001),
    NO_VIDEO_WITH_THIS_ID(2002),
    NO_CATEGORIES_FOUND(3001),
    NO_TAGS_FOUND(3002),
    NO_STARS_FOUND(3003),
}