package com.sum20.whisp.ui.resources

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import androidx.core.content.ContextCompat.getSystemService
import androidx.core.widget.NestedScrollView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.sum20.whisp.R


class ResourcesFragment : Fragment() {

    private lateinit var resourcesViewModel: ResourcesViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        resourcesViewModel =
            ViewModelProvider(this).get(ResourcesViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_resources, container, false)
//        val textView: TextView = root.findViewById(R.id.textView2)
//        resourcesViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })

        val parent = root.findViewById<LinearLayout>(R.id.cat_lin)
        val resCatList = resources.getStringArray(R.array.resource_cats)


        for (i in 0..2) {
            val custom: View = inflater.inflate(R.layout.resources_categories, null)
            val tv = custom.findViewById<View>(R.id.text) as TextView
            tv.text = resCatList[i]
            parent.addView(custom)
//            parent.s
        }

        return root
    }
}