package com.angonurse.anapp

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.angonurse.anapp.databinding.ActivityMainBinding
import com.angonurse.anapp.databinding.BottomSheetSettingsBinding
import com.angonurse.anapp.util.PrefsManager
import com.angonurse.anapp.util.SoundManager
import com.angonurse.anapp.util.UpdateChecker
import com.google.android.material.bottomsheet.BottomSheetDialog

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val REQ_NOTIFICATION = 1001

    override fun onCreate(savedInstanceState: Bundle?) {
        PrefsManager.applyTheme(this)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        SoundManager.init(this)
        requestNotificationPermission()

        // Verificar actualizações
        UpdateChecker.check(this)

        binding.btnStartTest.setOnClickListener {
            SoundManager.playClick()
            startActivity(Intent(this, ExamActivity::class.java))
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }
        binding.btnContent.setOnClickListener {
            SoundManager.playClick()
            startActivity(Intent(this, ConteudoActivity::class.java))
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }
        binding.btnDonations.setOnClickListener {
            SoundManager.playClick()
            startActivity(Intent(this, DonativosActivity::class.java))
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }
        binding.btnHistory.setOnClickListener {
            SoundManager.playClick()
            startActivity(Intent(this, HistoryActivity::class.java))
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }
        binding.btnAbout.setOnClickListener {
            SoundManager.playClick()
            startActivity(Intent(this, AboutActivity::class.java))
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }
        binding.btnShare.setOnClickListener {
            SoundManager.playClick()
            shareApp()
        }
        binding.btnFeedback.setOnClickListener {
            SoundManager.playClick()
            sendFeedback()
        }
        binding.btnSettings.setOnClickListener {
            SoundManager.playClick()
            showSettings()
        }
    }

    private fun requestNotificationPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.POST_NOTIFICATIONS)
                != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this,
                    arrayOf(Manifest.permission.POST_NOTIFICATIONS), REQ_NOTIFICATION)
            }
        }
    }

    private fun sendFeedback() {
        val intent = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("mailto:")
            putExtra(Intent.EXTRA_EMAIL, arrayOf(getString(R.string.feedback_email)))
            putExtra(Intent.EXTRA_SUBJECT, getString(R.string.feedback_subject))
            putExtra(Intent.EXTRA_TEXT, getString(R.string.feedback_body))
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        } else {
            Toast.makeText(this, "Nenhum app de e-mail encontrado", Toast.LENGTH_SHORT).show()
        }
    }

    private fun shareApp() {
        val intent = Intent(Intent.ACTION_SEND).apply {
            type = "text/plain"
            putExtra(Intent.EXTRA_TEXT, getString(R.string.share_text))
        }
        startActivity(Intent.createChooser(intent, getString(R.string.share_via)))
    }

    private fun showSettings() {
        val dialog = BottomSheetDialog(this)
        val sheetBinding = BottomSheetSettingsBinding.inflate(LayoutInflater.from(this))
        dialog.setContentView(sheetBinding.root)

        sheetBinding.switchDarkMode.isChecked = PrefsManager.isDarkMode(this)
        sheetBinding.switchSoundEffects.isChecked = SoundManager.isSoundEffectsEnabled()
        sheetBinding.switchBackgroundMusic.isChecked = SoundManager.isBackgroundMusicEnabled()

        sheetBinding.switchDarkMode.setOnCheckedChangeListener { _, checked ->
            SoundManager.playClick()
            PrefsManager.setDarkMode(this, checked)
        }
        sheetBinding.switchSoundEffects.setOnCheckedChangeListener { _, checked ->
            SoundManager.setSoundEffects(this, checked)
            SoundManager.playClick()
        }
        sheetBinding.switchBackgroundMusic.setOnCheckedChangeListener { _, checked ->
            SoundManager.setBackgroundMusic(this, checked)
            SoundManager.playClick()
        }
        sheetBinding.btnFacebook.setOnClickListener {
            SoundManager.playClick()
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://facebook.com/angonurse")))
        }
        sheetBinding.btnWhatsapp.setOnClickListener {
            SoundManager.playClick()
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://whatsapp.com/channel/0029VbAkfjb0Qeamx7kuuR28")))
        }
        sheetBinding.btnTiktok.setOnClickListener {
            SoundManager.playClick()
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://tiktok.com/@angonurse")))
        sheetBinding.btnCheckUpdate.setOnClickListener {
            SoundManager.playClick()
            dialog.dismiss()
            UpdateChecker.checkManual(this)
        }
        dialog.show()
    }
}
