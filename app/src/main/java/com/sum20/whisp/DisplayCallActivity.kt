package com.sum20.whisp

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.view.View
import android.widget.Chronometer
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.preference.PreferenceManager
import kotlinx.android.synthetic.main.activity_main.*

class DisplayCallActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(getCurrentTheme())
        setContentView(R.layout.activity_display_call)

        val layoutthing = findViewById<ConstraintLayout>(R.id.constraintDisplayCall)

        val phoneNumber = intent.getStringExtra("com.sum20.whisp.ui.call.CALLING")
        val textView = findViewById<TextView>(R.id.phoneNumberCall).apply {
            text = phoneNumber
        }

        val bgPref = intent.getIntExtra(
            "com.sum20.whisp.ui.call.BG",
            R.drawable.person_on_a_bridge_near_a_lake_747964
        )
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            layoutthing.background = resources.getDrawable(bgPref, resources.newTheme())
        } else {
            layoutthing.background = resources.getDrawable(bgPref)
        }

        val callTime = findViewById<Chronometer>(R.id.callTime).start()
        supportActionBar?.hide()
    }

    fun callEnd(view: View) {
        finish()
    }

    private fun getCurrentTheme(): Int {
        val prefs =
            PreferenceManager.getDefaultSharedPreferences(this)
        return prefs.getInt(getString(R.string.theme_pref_key), R.style.LightTheme)
    }

    override fun onDestroy() {
        super.onDestroy()
        //TODO call to SQLDB updating history
    }
}