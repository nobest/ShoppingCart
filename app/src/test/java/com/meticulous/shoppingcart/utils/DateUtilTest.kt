package com.meticulous.shoppingcart.utils

import junit.framework.Assert.assertEquals
import org.junit.Test
import java.util.Date
import java.util.TimeZone

internal class DateUtilTest {

    @Test
    fun testFormatPastDate() {
        val thursdayFebruary11th2022_10am_GMT = Date(1644487200000)
        val result = DateUtil.formatCartItemDateTime(thursdayFebruary11th2022_10am_GMT, TimeZone.getTimeZone("GMT"))
        assertEquals("Thu, Feb 10 - 10:00 am", result)
    }

    @Test
    fun testFormatFutureDate() {
        val tuesdayJune20th2023_10pm_GMT = Date(1687298400000)
        val result = DateUtil.formatCartItemDateTime(tuesdayJune20th2023_10pm_GMT, TimeZone.getTimeZone("GMT"))
        assertEquals("Tue, Jun 20 - 10:00 pm", result)
    }

    @Test
    fun testFormatAMDate() {
        val wednessdayMay25th2022_9am_GMT = Date(1653469200000)
        val result = DateUtil.formatCartItemDateTime(wednessdayMay25th2022_9am_GMT, TimeZone.getTimeZone("GMT"))
        assertEquals("Wed, May 25 - 9:00 am", result)
    }

    @Test
    fun testFormatPMDate() {
        val saturdayMay20th2023_3pm_GMT = Date(1684594800000)
        val result = DateUtil.formatCartItemDateTime(saturdayMay20th2023_3pm_GMT, TimeZone.getTimeZone("GMT"))
        assertEquals("Sat, May 20 - 3:00 pm", result)
    }

}