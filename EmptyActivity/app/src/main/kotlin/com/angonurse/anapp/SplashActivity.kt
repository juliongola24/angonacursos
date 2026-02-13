package com.angonurse.anapp

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.OvershootInterpolator
import androidx.appcompat.app.AppCompatActivity
import com.angonurse.anapp.databinding.ActivitySplashBinding
import com.angonurse.anapp.util.PrefsManager

class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        PrefsManager.applyTheme(this)
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val content = binding.splashContent

        // Fade-in + Scale animation
        val fadeIn = ObjectAnimator.ofFloat(content, "alpha", 0f, 1f).apply {
            duration = 800
        }
        val scaleX = ObjectAnimator.ofFloat(content, "scaleX", 0.7f, 1f).apply {
            duration = 800
            interpolator = OvershootInterpolator(1.2f)
        }
        val scaleY = ObjectAnimator.ofFloat(content, "scaleY", 0.7f, 1f).apply {
            duration = 800
            interpolator = OvershootInterpolator(1.2f)
        }

        AnimatorSet().apply {
            playTogether(fadeIn, scaleX, scaleY)
            startDelay = 200
            start()
        }

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
            finish()
        }, 2000)
    }
}
