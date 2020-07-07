package com.sum20.whisp

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.preference.PreferenceManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.String


class MainActivity : AppCompatActivity() {
    val bgs = Array(3) {"@drawable/person_on_a_bridge_near_a_lake_747964"; "@drawable/warm_forest_path"; "@drawable/dark_star_space" }

    override fun onCreate(savedInstanceState: Bundle?) {
        var bgPref = 1

        // Tells AS to run out code in addition to existing code in oncreate() parent class
        super.onCreate(savedInstanceState)
        // Set XML file you want as main layout when app starts
        setContentView(R.layout.activity_main)

        // NAVIGATION
        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_call, R.id.navigation_notifications
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
        supportActionBar?.hide()

        val prefs =
            PreferenceManager.getDefaultSharedPreferences(this)

        bgPref = prefs.getInt("background_images", 1)
        Toast.makeText(this, String.valueOf(bgPref), Toast.LENGTH_SHORT).show()
        setBg(bgPref)
    }

    private fun setBg(bgPref: Int) {
        container?.background = resources.getDrawable(R.drawable.dark_star_space);

    }

    private fun loadData(){
        val mainView = R.layout.activity_main
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        val backgroundImage = sharedPreferences.getString("background_images", "");
    }

}