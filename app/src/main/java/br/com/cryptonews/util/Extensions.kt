package br.com.cryptonews.util

import android.content.Context
import android.widget.Toast
import androidx.annotation.IdRes
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
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

    return parser.parse(this)?.run {
        formatter.format(this)
    }
}


fun AppCompatActivity.setupToolbar(
    @IdRes id: Int,
    title: String? = null,
    upNavigation: Boolean = false
): ActionBar {
    val toolbar = findViewById<Toolbar>(id)
    setSupportActionBar(toolbar)

    if (title != null) {
        supportActionBar?.title = title
    }
    supportActionBar?.setDisplayHomeAsUpEnabled(upNavigation)

    return supportActionBar!!
}

fun Fragment.setupToolbar(
    @IdRes id: Int,
    title: String? = null,
    upNavigation: Boolean = false
): ActionBar {
    val activity = (activity as? AppCompatActivity)

    val toolbar = activity?.findViewById<Toolbar>(id)
    activity?.setSupportActionBar(toolbar)

    if (title != null) {
        activity?.supportActionBar?.title = title
    }
    activity?.supportActionBar?.setDisplayHomeAsUpEnabled(upNavigation)

    return activity?.supportActionBar!!
}