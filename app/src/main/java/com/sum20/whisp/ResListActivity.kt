package com.sum20.whisp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView

class ResListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_res_list)

        val header = intent.getStringExtra("com.sum20.whisp.ui.call.HEADER")
        val links = intent.getStringArrayExtra("com.sum20.whisp.ui.call.LINKS")

        val headerText = findViewById<TextView>(R.id.cat_header).apply {
            text = header
        }

        val layout = findViewById<LinearLayout>(R.id.links)
        for (i in links!!) {
            val custom = TextView(this)
            custom.text = Html.escapeHtml(i)
            layout.addView(custom)
        }
    }
}