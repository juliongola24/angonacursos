package com.angonurse.anapp

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.angonurse.anapp.databinding.ActivityDonativosBinding
import com.angonurse.anapp.util.SoundManager

class DonativosActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDonativosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDonativosBinding.inflate(layoutInflater)
        setContentView(binding.root)
        SoundManager.init(this)

        binding.btnBack.setOnClickListener {
            SoundManager.playClick()
            finish()
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
        }

        binding.btnCopyPaypay.setOnClickListener { SoundManager.playClick(); copyToClipboard("923 456 789") }
        binding.btnCopyEntidade.setOnClickListener { SoundManager.playClick(); copyToClipboard("10116") }
        binding.btnCopyReferencia.setOnClickListener { SoundManager.playClick(); copyToClipboard("943693959") }
        binding.btnCopyKwik.setOnClickListener { SoundManager.playClick(); copyToClipboard("AO06042000000000061156412") }
        binding.btnCopyEmail.setOnClickListener { SoundManager.playClick(); copyToClipboard("angonurse@gmail.com") }

        binding.btnOpenEmail.setOnClickListener {
            SoundManager.playClick()
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:angonurse@gmail.com?subject=Comprovativo de Donativo - Teste Online")
            }
            try { startActivity(intent) } catch (e: Exception) {
                Toast.makeText(this, "Nenhum app de e-mail encontrado", Toast.LENGTH_SHORT).show()
            }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
    }

    private fun copyToClipboard(text: String) {
        val clipboard = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        clipboard.setPrimaryClip(ClipData.newPlainText("", text))
        Toast.makeText(this, getString(R.string.copied), Toast.LENGTH_SHORT).show()
    }
}
