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


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        var bgPref = ""

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

        bgPref = prefs.getString("background_images", "").toString()
        print(bgPref)

        Toast.makeText(this, bgPref, Toast.LENGTH_SHORT).show()
        setBg(bgPref)
    }

    private fun setBg(bgPref: String) {
        val bgs = Array(3) {resources.getDrawable(R.drawable.person_on_a_bridge_near_a_lake_747964); resources.getDrawable(R.drawable.warm_forest_path); resources.getDrawable(R.drawable.dark_star_space)}

        container?.background = bgs[0];

    }

    private fun loadData(){
        val mainView = R.layout.activity_main
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        val backgroundImage = sharedPreferences.getString("background_images", "");
    }

}