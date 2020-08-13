package com.sum20.whisp.ui.settings

import android.content.Context
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.sum20.whisp.R

class BgSettingsFrag : Fragment() {

    companion object {
        fun newInstance() = BgSettingsFrag()
    }

    private lateinit var viewModel: BgSettingsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.bg_settings_fragment, container, false)

        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(BgSettingsViewModel::class.java)
        // TODO: Use the ViewModel

        val sharedPref = activity?.getPreferences(Context.MODE_PRIVATE) ?: return
        with (sharedPref.edit()) {
            putInt(getString(R.string.bg_pref_key), R.drawable.dark_star_space)
            commit()
        }
    }


}