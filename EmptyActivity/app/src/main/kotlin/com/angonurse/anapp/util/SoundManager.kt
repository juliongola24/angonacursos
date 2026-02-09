package com.angonurse.anapp.util

import android.content.Context
import android.media.AudioAttributes
import android.media.MediaPlayer
import android.media.SoundPool
import com.angonurse.anapp.R

object SoundManager {
    private var soundPool: SoundPool? = null
    private var clickSoundId: Int = 0
    private var mediaPlayer: MediaPlayer? = null
    private var soundEffectsEnabled = false
    private var backgroundMusicEnabled = false
    private var isPrepared = false

    fun init(context: Context) {
        if (soundPool != null) return
        val audioAttr = AudioAttributes.Builder()
            .setUsage(AudioAttributes.USAGE_GAME)
            .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
            .build()
        soundPool = SoundPool.Builder()
            .setMaxStreams(4)
            .setAudioAttributes(audioAttr)
            .build()
        clickSoundId = soundPool!!.load(context, R.raw.snd_click, 1)

        val prefs = context.getSharedPreferences("app_settings", Context.MODE_PRIVATE)
        soundEffectsEnabled = prefs.getBoolean("sound_effects", false)
        backgroundMusicEnabled = prefs.getBoolean("background_music", false)
    }

    fun playClick() {
        if (!soundEffectsEnabled) return
        soundPool?.play(clickSoundId, 1f, 1f, 1, 0, 1f)
    }

    fun setSoundEffects(context: Context, enabled: Boolean) {
        soundEffectsEnabled = enabled
        context.getSharedPreferences("app_settings", Context.MODE_PRIVATE)
            .edit().putBoolean("sound_effects", enabled).apply()
    }

    fun setBackgroundMusic(context: Context, enabled: Boolean) {
        backgroundMusicEnabled = enabled
        context.getSharedPreferences("app_settings", Context.MODE_PRIVATE)
            .edit().putBoolean("background_music", enabled).apply()
    }

    fun isSoundEffectsEnabled() = soundEffectsEnabled
    fun isBackgroundMusicEnabled() = backgroundMusicEnabled

    fun startBackgroundMusic(context: Context) {
        if (!backgroundMusicEnabled) return
        if (mediaPlayer == null) {
            mediaPlayer = MediaPlayer.create(context.applicationContext, R.raw.snd_background)
            mediaPlayer?.isLooping = true
            isPrepared = true
        }
        if (isPrepared) {
            try { mediaPlayer?.start() } catch (_: Exception) {}
        }
    }

    fun pauseBackgroundMusic() {
        try {
            if (mediaPlayer?.isPlaying == true) mediaPlayer?.pause()
        } catch (_: Exception) {}
    }

    fun resumeBackgroundMusic() {
        if (!backgroundMusicEnabled) return
        try {
            if (isPrepared && mediaPlayer?.isPlaying == false) mediaPlayer?.start()
        } catch (_: Exception) {}
    }

    fun stopBackgroundMusic() {
        try {
            mediaPlayer?.stop()
            mediaPlayer?.release()
            mediaPlayer = null
            isPrepared = false
        } catch (_: Exception) {}
    }

    fun release() {
        soundPool?.release()
        soundPool = null
        stopBackgroundMusic()
    }
}
