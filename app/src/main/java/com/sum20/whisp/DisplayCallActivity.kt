package com.sum20.whisp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Chronometer
import android.widget.TextView

class DisplayCallActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_call)

        val phoneNumber = intent.getStringExtra("com.sum20.whisp.ui.call.CALLING")
        val textView = findViewById<TextView>(R.id.phoneNumberCall).apply{
            text = phoneNumber
        }
        val callTime = findViewById<Chronometer>(R.id.callTime).start()
        supportActionBar?.hide()
    }

    fun callEnd(view: View){
        finish()
    }

    override fun onDestroy() {
        super.onDestroy()
        //TODO call to SQLDB updating history
    }
}