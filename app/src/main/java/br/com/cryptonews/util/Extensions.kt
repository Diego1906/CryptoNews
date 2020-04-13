package br.com.cryptonews.util

import android.content.Context
import android.net.ConnectivityManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import br.com.cryptonews.CryptoNewsApplication
import br.com.cryptonews.R
import java.text.SimpleDateFormat
import java.util.*

fun String.onShowToast(context: Context) {
    Toast.makeText(context, this, Toast.LENGTH_SHORT).show()
}

fun String.onDateFormat(): String? {
    val context = CryptoNewsApplication.getContext()

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

    val date = dateParser.parse(this)

    return date?.run {
        dateFormatter.format(this)
    }
}

fun Fragment.onIsNetworkConnected(): Boolean {
    val cm = requireContext().getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    return cm.activeNetworkInfo?.isConnectedOrConnecting == true
}

fun Fragment.setTitleActionBar(title: String) {
    (requireActivity() as AppCompatActivity).supportActionBar?.title = title
}