package com.sum20.whisp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.sum20.whisp.ui.settings.SettingsActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        supportActionBar?.hide()

//        findViewById<ConstraintLayout>(R.id.splashContainer).setOnClickListener {
//            splashTap()
//        }

        Handler().postDelayed({
            //start main activity
            startActivity(Intent(this@SplashActivity, MainActivity::class.java))
            //finish this activity
            finish()
        },4000)
    }

    private fun splashTap(){
        startActivity(Intent(this@SplashActivity, MainActivity::class.java))
//        startActivity(intent)
        finish()
    }
}