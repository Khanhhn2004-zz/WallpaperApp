package com.hnk.wallpaper.common

/**
 * This class represents an event message that can be used to pass data between components
 * (such as fragments, activities, or view models) within an application.
 *
 * @property typeEvent An integer that specifies the type of event. Default value is -1.
 * @property longValue A long value associated with the event, which can be used to store
 *                    additional data, such as an ID or timestamp. Default value is -1.
 */
class MessageEvent(
    var typeEvent: Int = -1,
    var longValue: Long = -1,
    var intValue: Int = -1,
    var stringValue: String = "",
    var booleanValue: Boolean = false
)
