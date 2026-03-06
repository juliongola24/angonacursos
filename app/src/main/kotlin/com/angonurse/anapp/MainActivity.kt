package com.angonurse.anapp

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.angonurse.anapp.databinding.ActivityMainBinding
import com.angonurse.anapp.ui.*
import com.angonurse.anapp.util.SoundManager
import com.angonurse.anapp.util.UpdateChecker

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var soundManager: SoundManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        soundManager = SoundManager(this)
        loadSettings()
        requestPermissions()
        UpdateChecker(this).checkForUpdate()

        setupButtons()
    }

    private fun loadSettings() {
        val prefs = getSharedPreferences("settings", MODE_PRIVATE)
        val darkMode = prefs.getBoolean("dark_mode", false)
        AppCompatDelegate.setDefaultNightMode(
            if (darkMode) AppCompatDelegate.MODE_NIGHT_YES
            else AppCompatDelegate.MODE_NIGHT_NO
        )

        val musicEnabled = prefs.getBoolean("background_music", false)
        if (musicEnabled) soundManager.startBackgroundMusic()

        val soundEnabled = prefs.getBoolean("sound_effects", true)
        soundManager.setSoundEnabled(soundEnabled)
    }

    private fun setupButtons() {
        binding.btnIniciarTeste.setOnClickListener {
            soundManager.playClick()
            startActivity(Intent(this, ExamQuizActivity::class.java))
        }

        binding.btnConteudo.setOnClickListener {
            soundManager.playClick()
            startActivity(Intent(this, ConteudoActivity::class.java))
        }

        binding.btnDonativos.setOnClickListener {
            soundManager.playClick()
            startActivity(Intent(this, DonativosActivity::class.java))
        }

        binding.btnHistorico.setOnClickListener {
            soundManager.playClick()
            startActivity(Intent(this, HistoricoActivity::class.java))
        }

        binding.btnSaberMais.setOnClickListener {
            soundManager.playClick()
            startActivity(Intent(this, SobreActivity::class.java))
        }

        binding.btnCompartilhar.setOnClickListener {
            soundManager.playClick()
            shareApp()
        }

        binding.btnSettings.setOnClickListener {
            soundManager.playClick()
            showSettingsDialog()
        }
    }

    private fun shareApp() {
        val shareText = "📚 Teste Online - Plataforma de Avaliação\n\nPrepare-se com 95 questões de múltipla escolha, cronômetro e gabarito detalhado!\n\nhttps://play.google.com/store/apps/details?id=$packageName"
        val intent = Intent(Intent.ACTION_SEND).apply {
            type = "text/plain"
            putExtra(Intent.EXTRA_TEXT, shareText)
        }
        startActivity(Intent.createChooser(intent, "Compartilhar via"))
    }

    private fun showSettingsDialog() {
        val prefs = getSharedPreferences("settings", MODE_PRIVATE)
        val items = arrayOf("Modo Escuro", "Efeitos Sonoros", "Música de Fundo")
        val checked = booleanArrayOf(
            prefs.getBoolean("dark_mode", false),
            prefs.getBoolean("sound_effects", true),
            prefs.getBoolean("background_music", false)
        )

        androidx.appcompat.app.AlertDialog.Builder(this)
            .setTitle("Definições")
            .setMultiChoiceItems(items, checked) { _, which, isChecked ->
                val editor = prefs.edit()
                when (which) {
                    0 -> {
                        editor.putBoolean("dark_mode", isChecked)
                        AppCompatDelegate.setDefaultNightMode(
                            if (isChecked) AppCompatDelegate.MODE_NIGHT_YES
                            else AppCompatDelegate.MODE_NIGHT_NO
                        )
                    }
                    1 -> {
                        editor.putBoolean("sound_effects", isChecked)
                        soundManager.setSoundEnabled(isChecked)
                    }
                    2 -> {
                        editor.putBoolean("background_music", isChecked)
                        if (isChecked) soundManager.startBackgroundMusic()
                        else soundManager.stopBackgroundMusic()
                    }
                }
                editor.apply()
            }
            .setPositiveButton("Fechar", null)
            .setNeutralButton("Verificar Actualização") { _, _ ->
                UpdateChecker(this).checkForUpdate(manual = true)
            }
            .show()
    }

    private fun requestPermissions() {
        val perms = mutableListOf<String>()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.POST_NOTIFICATIONS)
                != PackageManager.PERMISSION_GRANTED
            ) {
                perms.add(Manifest.permission.POST_NOTIFICATIONS)
            }
        }
        if (perms.isNotEmpty()) {
            ActivityCompat.requestPermissions(this, perms.toTypedArray(), 1001)
        }
    }

    override fun onResume() {
        super.onResume()
        val prefs = getSharedPreferences("settings", MODE_PRIVATE)
        if (prefs.getBoolean("background_music", false)) {
            soundManager.startBackgroundMusic()
        }
    }

    override fun onPause() {
        super.onPause()
        soundManager.stopBackgroundMusic()
    }

    override fun onDestroy() {
        super.onDestroy()
        soundManager.release()
    }
}
