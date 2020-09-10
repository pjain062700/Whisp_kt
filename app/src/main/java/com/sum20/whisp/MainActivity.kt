package com.sum20.whisp

import android.content.SharedPreferences.OnSharedPreferenceChangeListener
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.preference.PreferenceManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.NonCancellable.cancel


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {

        // Tells AS to run out code in addition to existing code in oncreate() parent class
        super.onCreate(savedInstanceState)
        // Set theme
        setTheme(getCurrentTheme())
        // Set XML file you want as main layout when app starts
        setContentView(R.layout.activity_main)

        // NAVIGATION
        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_call, R.id.navigation_resources
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
        supportActionBar?.hide()
    }


    private fun setBg(bgPref: Int) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            container?.background = resources.getDrawable(bgPref, resources.newTheme())
        } else {
            container?.background = resources.getDrawable(bgPref)
        }
    }

    private fun getCurrentTheme(): Int {
        val prefs =
            PreferenceManager.getDefaultSharedPreferences(this)
        return prefs.getInt(getString(R.string.theme_pref_key), R.style.LightTheme)
    }

    override fun onStart() {
        super.onStart()
        val prefs =
            PreferenceManager.getDefaultSharedPreferences(this)
        setBg(prefs.getInt(getString(R.string.bg_pref_key), R.drawable.person_on_a_bridge_near_a_lake_747964))

    }

    override fun onResume() {
        super.onResume()
        val prefs =
            PreferenceManager.getDefaultSharedPreferences(this)
        val spChanged =
            OnSharedPreferenceChangeListener { pref, _ ->
                val bgPrefKey =
                    pref.getInt(
                        getString(R.string.bg_pref_key),
                        R.drawable.person_on_a_bridge_near_a_lake_747964
                    )
                val themePrefKey =
                    pref.getInt(getString(R.string.theme_pref_key), R.style.LightTheme)
                setBg(bgPrefKey)
                recreate()
            }
        prefs.registerOnSharedPreferenceChangeListener(spChanged)
    }

}