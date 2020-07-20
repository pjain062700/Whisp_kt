package com.sum20.whisp.ui.call

import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.sum20.whisp.DisplayCallActivity
import com.sum20.whisp.R
import kotlinx.android.synthetic.main.fragment_call.*

// const val CALL_SCREEN = "com.sum20.whisp.ui.call.CALLING"
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
        val textView: TextView = root.findViewById(R.id.text_call)
        callViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })

        root.findViewById<TextView>(R.id.tvOne).setOnClickListener {
            var mediaPlayer: MediaPlayer? = MediaPlayer.create(context, R.raw.zero)
            mediaPlayer?.start()
            appendNum("1", true)
        }

        root.findViewById<TextView>(R.id.tvTwo).setOnClickListener {
            appendNum("2", clear = true)
        }

        root.findViewById<TextView>(R.id.tvThree).setOnClickListener {
            appendNum("3", clear = true)
        }
        root.findViewById<TextView>(R.id.tvFour).setOnClickListener {
            appendNum("4", clear = true)
        }

        root.findViewById<TextView>(R.id.tvFive).setOnClickListener {
            appendNum("5", clear = true)
        }

        root.findViewById<TextView>(R.id.tvSix).setOnClickListener {
            appendNum("6", clear = true)
        }

        root.findViewById<TextView>(R.id.tvSeven).setOnClickListener {
            appendNum("7", clear = true)
        }

        root.findViewById<TextView>(R.id.tvEight).setOnClickListener {
            appendNum("8", clear = true)
        }

        root.findViewById<TextView>(R.id.tvNine).setOnClickListener {
            appendNum("9", clear = true)
        }

        root.findViewById<TextView>(R.id.tvZero).setOnClickListener {
            appendNum("0", clear = true)
        }

        root.findViewById<TextView>(R.id.tvPound).setOnClickListener {
            appendNum("#", clear = true)
        }

        root.findViewById<TextView>(R.id.tvAst).setOnClickListener {
            appendNum("*", clear = true)
        }

        root.findViewById<ImageView>(R.id.ivCall).setOnClickListener {
            callPress()
        }

        return root
    }

    private fun appendNum(string: String, clear: Boolean) {
        if(text_call.length() <= 15){
            val t = view?.findViewById<TextView>(R.id.text_call)
            t!!.append(string)
        }

    }

    private fun callPress() {
        val textCall = view?.findViewById<TextView>(R.id.text_call)
        val phoneNumber = textCall?.text.toString()
        val intent = Intent(activity, DisplayCallActivity::class.java).apply{
            putExtra("com.sum20.whisp.ui.call.CALLING",phoneNumber)
        }
        startActivity(intent)
    }

    override fun onStop() {
        super.onStop()
        val textCall = view?.findViewById<TextView>(R.id.text_call)
        textCall!!.text=""
    }


}