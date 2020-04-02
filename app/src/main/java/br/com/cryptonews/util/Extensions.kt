package br.com.cryptonews.util

import android.content.Context
import android.net.ConnectivityManager
import android.widget.Toast
import androidx.fragment.app.Fragment
import java.text.SimpleDateFormat
import java.util.*

fun String.onShowToast(context: Context) {
    Toast.makeText(context, this, Toast.LENGTH_LONG).show()
}

fun String.onDateFormat(): String? {
    val parser =
        SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.ENGLISH).apply {
            this.setTimeZone(TimeZone.getTimeZone("GMT"))
        }

    val formatter = SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.getDefault())

    val date = parser.parse(this)

    return date?.run {
        formatter.format(this)
    }
}

fun Fragment.onIsNetworkConnected(): Boolean {
    val cm = requireContext().getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    return cm.activeNetworkInfo?.isConnectedOrConnecting == true
}