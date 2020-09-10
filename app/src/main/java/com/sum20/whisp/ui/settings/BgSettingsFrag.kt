package com.sum20.whisp.ui.settings

import android.content.Context
import android.content.res.Resources
import android.os.Build
import android.os.Bundle
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.core.app.ActivityCompat.recreate
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import androidx.preference.PreferenceManager
import com.sum20.whisp.R

class BgSettingsFrag : Fragment() {

    companion object {
        fun newInstance() = BgSettingsFrag()
    }

    private lateinit var viewModel: BgSettingsViewModel
    private lateinit var currCardView: CardView
    private var currBg: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.bg_settings_fragment, container, false)

        // get current bg
        val prefs =
            PreferenceManager.getDefaultSharedPreferences(context)
        currBg = prefs.getInt(getString(R.string.bg_pref_key), R.drawable.warm_forest_path)

        // programmatically adding cardviews
        val nestedLin = root.findViewById<LinearLayout>(R.id.bg_linear_layout)
        val imageArray = resources.obtainTypedArray(R.array.BgThumbnails)
        val themeArray = resources.obtainTypedArray(R.array.Theme)

        for (index in 0..(imageArray.length()-1)) {
            val arrID = imageArray.getResourceId(index, -1)
            val themeID = themeArray.getResourceId(index, -1);
            if (arrID < 0) continue
            if (themeID < 0) continue
            val custom = inflater.inflate(R.layout.bg_settings_card_view_template, nestedLin, false)
            val IV = custom.findViewById<View>(R.id.IVBG) as ImageView
            IV.setImageResource(arrID)
            if (arrID == currBg) {
                currCardView = custom as CardView
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    currCardView.setCardBackgroundColor(resources.getColor(R.color.black, null))
                }
                else{
                    currCardView.setCardBackgroundColor(resources.getColor(R.color.black))
                }
            }

            custom.setOnClickListener {
                storeBg(arrID, themeID, custom as CardView)
                
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

    private fun storeBg(resId: Int, themeID: Int, newCustom: CardView) {
        val sharedPref = PreferenceManager.getDefaultSharedPreferences(context)
        if (resId != currBg) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                currCardView.setCardBackgroundColor(resources.getColor(R.color.colorPrimary, null))
                currCardView = newCustom
                currCardView.setCardBackgroundColor(resources.getColor(R.color.black, null))

            } else {
                currCardView.setCardBackgroundColor(resources.getColor(R.color.colorPrimary))
                currCardView = newCustom
                currCardView.setCardBackgroundColor(resources.getColor(R.color.black))
            }
            currBg = resId
            val toast = Toast.makeText(context?.applicationContext, R.string.toast_message, Toast.LENGTH_SHORT)
            toast.show()

            with (sharedPref.edit()) {
                putInt(
                    getString(R.string.bg_pref_key),
                    resId
                )
                putInt(
                    getString(R.string.theme_pref_key),
                    themeID
                )
                commit()

            }
        }

    }


}