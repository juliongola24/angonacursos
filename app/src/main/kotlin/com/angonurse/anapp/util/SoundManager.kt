package com.angonurse.anapp.util

import android.content.Context
import android.media.AudioAttributes
import android.media.MediaPlayer
import android.media.SoundPool

class SoundManager(private val context: Context) {

    private var soundPool: SoundPool? = null
    private var clickSoundId: Int = 0
    private var mediaPlayer: MediaPlayer? = null
    private var soundEnabled = true

    init {
        val attrs = AudioAttributes.Builder()
            .setUsage(AudioAttributes.USAGE_GAME)
            .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
            .build()
        soundPool = SoundPool.Builder()
            .setMaxStreams(2)
            .setAudioAttributes(attrs)
            .build()

        try {
            val afd = context.assets.openFd("snd_click.mp3")
            clickSoundId = soundPool?.load(afd, 1) ?: 0
            afd.close()
        } catch (_: Exception) {
            // Sound file not found — ignore
        }
    }

    fun setSoundEnabled(enabled: Boolean) {
        soundEnabled = enabled
    }

    fun playClick() {
        if (soundEnabled && clickSoundId != 0) {
            soundPool?.play(clickSoundId, 1f, 1f, 1, 0, 1f)
        }
    }

    fun startBackgroundMusic() {
        if (mediaPlayer != null) return
        try {
            val afd = context.assets.openFd("snd_background.mp3")
            mediaPlayer = MediaPlayer().apply {
                setDataSource(afd.fileDescriptor, afd.startOffset, afd.length)
                afd.close()
                isLooping = true
                setVolume(0.3f, 0.3f)
                prepare()
                start()
            }
        } catch (_: Exception) {
            // Music file not found — ignore
        }
    }

    fun stopBackgroundMusic() {
        mediaPlayer?.apply {
            if (isPlaying) stop()
            release()
        }
        mediaPlayer = null
    }

    fun release() {
        stopBackgroundMusic()
        soundPool?.release()
        soundPool = null
    }
}
