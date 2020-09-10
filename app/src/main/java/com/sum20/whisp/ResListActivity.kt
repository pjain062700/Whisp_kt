package com.sum20.whisp

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.text.method.LinkMovementMethod
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.preference.PreferenceManager

//TODO: make back button work

class ResListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(getCurrentTheme())
        setContentView(R.layout.activity_res_list)
        val backButton = findViewById<Button>(R.id.button)
        backButton.setOnClickListener {
            backButton()
        }

        val header = intent.getStringExtra("com.sum20.whisp.ui.resources.HEADER")
        val linkID = intent.getIntExtra("com.sum20.whisp.ui.resources.LINKS", -1)
        if (linkID < 0)
            return
        val links = resources.getStringArray(linkID)
        supportActionBar?.hide()

        val headerText = findViewById<TextView>(R.id.cat_header).apply {
            text = header
        }

        val layout = findViewById<LinearLayout>(R.id.links)
        for (i in links) {
            val custom = TextView(this)
            custom.isClickable = true
            custom.movementMethod = LinkMovementMethod.getInstance()
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                custom.text = Html.fromHtml(i, Html.FROM_HTML_MODE_COMPACT)
            } else {
                custom.text = Html.fromHtml(i)
            }
            custom.layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            layout.addView(custom)
        }


    }

    private fun getCurrentTheme(): Int {
        val prefs =
            PreferenceManager.getDefaultSharedPreferences(this)
        return prefs.getInt(getString(R.string.theme_pref_key), R.style.LightTheme)
    }

    private fun backButton() {
        finish()
    }
}