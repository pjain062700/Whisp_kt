package com.sum20.whisp.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
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
        val textView: TextView = root.findViewById(R.id.disclaimer_resources)
        resourcesViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}