package com.angonurse.anapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.angonurse.anapp.databinding.ActivityAboutBinding
import com.angonurse.anapp.util.SoundManager

class AboutActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAboutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        SoundManager.init(this)

        binding.btnBack.setOnClickListener {
            SoundManager.playClick()
            finish()
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
    }
}
