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
            "1" -> toneGenerator.startTone(ToneGenerator.TONE_DTMF_1, 100)
            "2" -> toneGenerator.startTone(ToneGenerator.TONE_DTMF_2, 100)
            "3" -> toneGenerator.startTone(ToneGenerator.TONE_DTMF_3, 100)

            "4" -> toneGenerator.startTone(ToneGenerator.TONE_DTMF_4, 100)
            "5" -> toneGenerator.startTone(ToneGenerator.TONE_DTMF_5, 100)
            "6" -> toneGenerator.startTone(ToneGenerator.TONE_DTMF_6, 100)

            "7" -> toneGenerator.startTone(ToneGenerator.TONE_DTMF_7, 100)
            "8" -> toneGenerator.startTone(ToneGenerator.TONE_DTMF_8, 100)
            "9" -> toneGenerator.startTone(ToneGenerator.TONE_DTMF_9, 100)

            "*" -> toneGenerator.startTone(ToneGenerator.TONE_DTMF_S, 100)
            "0" -> toneGenerator.startTone(ToneGenerator.TONE_DTMF_0, 100)
            "#" -> toneGenerator.startTone(ToneGenerator.TONE_DTMF_P, 100)
        }
    }
}