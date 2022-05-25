package com.meticulous.shoppingcart.utils

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone

class DateUtil {
    companion object {
        fun formatCartItemDateTime(date: Date, timeZone: TimeZone = TimeZone.getDefault()): String {
            val formatter = SimpleDateFormat("EEE, MMM d - h:mm a", Locale.getDefault())
            formatter.timeZone = timeZone
            return formatter.format(date)
        }
    }
}