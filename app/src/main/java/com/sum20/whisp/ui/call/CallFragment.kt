package com.sum20.whisp.ui.call

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.sum20.whisp.R

class CallFragment : Fragment() {

    private lateinit var callViewModel: CallViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        callViewModel =
                ViewModelProvider(this).get(CallViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_call, container, false)
        val textView: TextView = root.findViewById(R.id.text_dashboard)
        callViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}