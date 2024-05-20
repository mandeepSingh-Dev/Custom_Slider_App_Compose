package com.playmoweb.multidatepicker.utils.extensions

import android.util.Log
import java.text.SimpleDateFormat
import java.util.*

const val ISO8601 = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"
const val ISO8602 = "EEE MMM dd HH:mm:ss zzz yyyy"
const val MONTH = "MMMM"
const val SHORT_DAY = "EEE"
const val DAY_YEAR = "dd MMMM yyyy"

fun Date.toMonthYear(): String {

    Log.d("fbkfbmfbkg",this.toString())

    val cal = Calendar.getInstance()
    cal.time = this

    val monthYearDate = "${this.asString(MONTH).firstLetterUppercase()} ${cal.get(Calendar.YEAR).toString()}"

    Log.d("vlmkfbmfn",monthYearDate.toString())

    return monthYearDate
}

fun Date.toShortDay(): String {
    return this.asString(SHORT_DAY).uppercase(Locale.getDefault())
}

fun Date.asString(format: String = ISO8602): String {
    val output = SimpleDateFormat(format).format(this)
    return output
}
