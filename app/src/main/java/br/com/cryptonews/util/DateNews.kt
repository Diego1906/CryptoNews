package br.com.cryptonews.util

import android.content.Context
import br.com.cryptonews.R
import java.text.SimpleDateFormat
import java.util.*

private const val DAYS_AGO = -20

class DateNews(context: Context) {

    private val dateFormat =
        SimpleDateFormat(context.getString(R.string.pattern_date_format), Locale.ENGLISH)

    fun from(): String {
        return dateFormat.format(
            Calendar.getInstance().apply {
                add(Calendar.DATE, DAYS_AGO)
            }.time
        )
    }

    fun to(): String {
        return dateFormat.format(Date())
    }
}
