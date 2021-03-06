package br.com.cryptonews.util

import android.content.Context
import android.net.ConnectivityManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import br.com.cryptonews.R
import br.com.cryptonews.application.App
import java.text.SimpleDateFormat
import java.util.*

fun String?.onNotReported(): String {
    return this ?: App.getContext().getString(R.string.not_reported)
}

fun String.onShowToast(context: Context) {
    Toast.makeText(context, this, Toast.LENGTH_SHORT).show()
}

fun String?.onDateFormat(): String? {
    val context = App.getContext()

    val dateParser = SimpleDateFormat(
        context.getString(R.string.pattern_date_api),
        Locale.ENGLISH
    ).apply {
        timeZone = TimeZone.getTimeZone(context.getString(R.string.time_zone_gmt))
    }

    val dateFormatter = SimpleDateFormat(
        context.getString(R.string.pattern_date_pt_br),
        Locale.getDefault()
    )

    val date = dateParser.parse(
        this ?: Calendar.getInstance(Locale.getDefault()).time.toString()
    )

    return date?.run {
        dateFormatter.format(this)
    }
}

fun Fragment.onIsNetworkConnected(): Boolean {
    val cm = requireContext().getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    return cm.activeNetworkInfo?.isConnectedOrConnecting == true
}

fun Fragment.setTitleActionBar(title: String) {
    (requireActivity() as? AppCompatActivity)?.supportActionBar?.title = title
}