package com.sum20.whisp.ui.call

import android.content.Context
import android.media.AudioAttributes
import android.media.AudioManager
import android.media.SoundPool
import android.os.Build
import android.util.Log
import com.sum20.whisp.R
import kotlin.IllegalArgumentException

object CallSounds {
    private lateinit var soundPool: SoundPool
    private var soundMap: HashMap<String, Int> = HashMap<String, Int>(12)


    public fun prepSounds(context: Context?): CallSounds {
        soundPool = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val audioAttributes: AudioAttributes = AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_ASSISTANCE_SONIFICATION)
                .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                .build()

            SoundPool.Builder()
                .setMaxStreams(1)
                .setAudioAttributes(audioAttributes)
                .build()

        } else {
            SoundPool(1, AudioManager.STREAM_MUSIC, 0)
        }


        soundMap["1"] = soundPool.load(context, R.raw.dtfmone, 1)
        soundMap["2"] = soundPool.load(context, R.raw.dtfmtwo, 1)
        soundMap["3"] = soundPool.load(context, R.raw.dtfmthree, 1)

        soundMap["4"] = soundPool.load(context, R.raw.dtfmfour, 1)
        soundMap["5"] = soundPool.load(context, R.raw.dtfmfive, 1)
        soundMap["6"] = soundPool.load(context, R.raw.dtfmsix, 1)

        soundMap["7"] = soundPool.load(context, R.raw.dtfmseven, 1)
        soundMap["8"] = soundPool.load(context, R.raw.dtfmeight, 1)
        soundMap["9"] = soundPool.load(context, R.raw.dtfmnine, 1)

        soundMap["*"] = soundPool.load(context, R.raw.dtfmstar, 1)
        soundMap["0"] = soundPool.load(context, R.raw.dtfmzero, 1)
        soundMap["#"] = soundPool.load(context, R.raw.dtfmoctothorpe, 1)

        return this
    }

    public fun playTone(buttonPressed: String) {
        try {
            if (!soundMap.containsKey(buttonPressed)) {
                throw Throwable("CallSounds: Invalid string for ButtonPressed")
            } else {
                val soundId: Int = soundMap[buttonPressed]!!
                soundPool.play(soundId, 1.0F, 1.0F, 1, 0, 1.0F)
            }
        } catch (e: Exception) {
            Log.d("", e.message, e.cause)
            throw IllegalArgumentException()
        }

    }


    public fun releaseSounds() {
        soundPool.release()
    }

}
