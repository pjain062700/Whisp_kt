package com.sum20.whisp.ui.settings

import android.content.Context
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.preference.PreferenceManager
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

        val nestedLin = root.findViewById<LinearLayout>(R.id.bg_linear_layout)
        val imageArray = resources.obtainTypedArray(R.array.BgThumbnails)

        for (image in 0..imageArray.length()) {
            val arrID = imageArray.getResourceId(image, -1)
            if (arrID < 0) continue
            val custom = inflater.inflate(R.layout.bg_settings_card_view_template, nestedLin, false)
            val IV = custom.findViewById<View>(R.id.IVBG) as ImageView
            IV.setImageResource(arrID)
            custom.setOnClickListener {
                storeBg(arrID)
            }
            nestedLin.addView(custom)
        }

        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(BgSettingsViewModel::class.java)
        // TODO: Use the ViewModel

//        val sharedPref = PreferenceManager.getDefaultSharedPreferences(context)
//        with (sharedPref.edit()) {
//            putInt(
//                getString(R.string.bg_pref_key),
//                R.drawable.person_on_a_bridge_near_a_lake_747964
//            )
//            commit()
//        }


    }

    fun storeBg(resId: Int){
        val sharedPref = PreferenceManager.getDefaultSharedPreferences(context)
        with (sharedPref.edit()) {
            putInt(
                getString(R.string.bg_pref_key),
                resId
            )
            commit()
        }
    }


}