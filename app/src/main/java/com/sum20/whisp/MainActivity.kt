package com.sum20.whisp

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        // Tells AS to run out code in addition to existing code in oncreate() parent class
        super.onCreate(savedInstanceState)
        // Set XML file you want as main layout when app starts
        setContentView(R.layout.activity_main)

        // NAVIGATION
        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(setOf(
                R.id.navigation_home, R.id.navigation_call, R.id.navigation_notifications))
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
        supportActionBar?.hide()
    }

    fun appendNum(string: String, clear: Boolean) {
//        if(clear) {
//            Result.text = ""
//            Expression.append(string)
//        } else {
//            Expression.append(Result.text)
//            Expression.append(string)
//            Result.text = ""
//        }
    }
}