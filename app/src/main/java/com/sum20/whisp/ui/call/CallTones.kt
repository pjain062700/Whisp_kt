package com.sum20.whisp.ui.call

import android.media.AudioAttributes
import android.media.AudioManager
import android.media.ToneGenerator
import android.os.Build

object CallTones {
    private val audioType = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        AudioAttributes.CONTENT_TYPE_SONIFICATION
    } else {
        AudioManager.STREAM_DTMF
    }

    private val toneGenerator: ToneGenerator = ToneGenerator(audioType, 50)


    public fun playTone(digit: String) {
        val audioType = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            AudioAttributes.CONTENT_TYPE_SONIFICATION
        } else {
            AudioManager.STREAM_DTMF
        }
        when (digit) {
            "1" -> toneGenerator.startTone(ToneGenerator.TONE_DTMF_1, 150)
            "2" -> toneGenerator.startTone(ToneGenerator.TONE_DTMF_2, 150)
            "3" -> toneGenerator.startTone(ToneGenerator.TONE_DTMF_3, 150)

            "4" -> toneGenerator.startTone(ToneGenerator.TONE_DTMF_4, 150)
            "5" -> toneGenerator.startTone(ToneGenerator.TONE_DTMF_5, 150)
            "6" -> toneGenerator.startTone(ToneGenerator.TONE_DTMF_6, 150)

            "7" -> toneGenerator.startTone(ToneGenerator.TONE_DTMF_7, 150)
            "8" -> toneGenerator.startTone(ToneGenerator.TONE_DTMF_8, 150)
            "9" -> toneGenerator.startTone(ToneGenerator.TONE_DTMF_9, 150)

            "*" -> toneGenerator.startTone(ToneGenerator.TONE_DTMF_S, 150)
            "0" -> toneGenerator.startTone(ToneGenerator.TONE_DTMF_0, 150)
            "#" -> toneGenerator.startTone(ToneGenerator.TONE_DTMF_P, 150)
        }
    }
}