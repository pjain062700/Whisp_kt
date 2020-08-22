package com.sum20.whisp.ui.resources

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import androidx.core.content.ContextCompat.getSystemService
import androidx.core.view.iterator
import androidx.core.widget.NestedScrollView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.sum20.whisp.DisplayCallActivity
import com.sum20.whisp.R
import com.sum20.whisp.ResListActivity


class ResourcesFragment : Fragment() {

    private lateinit var resourcesViewModel: ResourcesViewModel

    @SuppressLint("Recycle")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        resourcesViewModel =
            ViewModelProvider(this).get(ResourcesViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_resources, container, false)

        val parent = root.findViewById<LinearLayout>(R.id.cat_lin)
        val resCatList = resources.getStringArray(R.array.resource_cats)
        val resLinks = resources.obtainTypedArray(R.array.res_links_array)

        for (i in resCatList.indices) {
            val arrID = resLinks.getResourceId(i, -1)
            if (arrID < 0) continue
            val custom = inflater.inflate(R.layout.resources_categories, parent, false)
            val tv = custom.findViewById<View>(R.id.text) as TextView
            tv.text = resCatList[i]
            custom.setOnClickListener {
                openCategory(resCatList[i], arrID)
            }
            parent.addView(custom)
        }


        return root
    }

    private fun openCategory(str: String, arr: Int) {
        val intent = Intent(activity, ResListActivity::class.java).apply {
            putExtra("com.sum20.whisp.ui.resources.HEADER", str)
            putExtra("com.sum20.whisp.ui.resources.LINKS", arr)
        }
        startActivity(intent)
    }

    private fun viewPress(string: String) {

    }
}