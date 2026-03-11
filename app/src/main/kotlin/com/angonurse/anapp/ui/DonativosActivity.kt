package com.angonurse.anapp.ui

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.angonurse.anapp.databinding.ActivityDonativosBinding

class DonativosActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDonativosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDonativosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener { finish() }

        binding.btnCopyPaypay.setOnClickListener { copyToClipboard("923 456 789") }
        binding.btnCopyEntidade.setOnClickListener { copyToClipboard("10116") }
        binding.btnCopyReferencia.setOnClickListener { copyToClipboard("943693959") }
        binding.btnCopyIban.setOnClickListener { copyToClipboard("AO06042000000000061156412") }
        binding.btnCopyEmail.setOnClickListener { copyToClipboard("angonurse@gmail.com") }

        binding.btnOpenEmail.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:angonurse@gmail.com?subject=Comprovativo de Donativo - Teste Online"))
            startActivity(Intent.createChooser(intent, "Enviar e-mail"))
        }
    }

    private fun copyToClipboard(text: String) {
        val cm = getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
        cm.setPrimaryClip(ClipData.newPlainText("Copiado", text))
        Toast.makeText(this, "Copiado: $text", Toast.LENGTH_SHORT).show()
    }
}
