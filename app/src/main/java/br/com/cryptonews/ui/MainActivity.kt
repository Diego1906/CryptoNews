package br.com.cryptonews.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.cryptonews.CryptoNewsApplication
import br.com.cryptonews.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        CryptoNewsApplication.setContext(applicationContext)
    }
}
