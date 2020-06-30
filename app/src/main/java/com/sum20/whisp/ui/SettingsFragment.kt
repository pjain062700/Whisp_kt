package com.sum20.whisp.ui

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import com.sum20.whisp.R

class SettingsFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey)
    }
}