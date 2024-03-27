package com.example.notes_cm

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Locale


class MainActivity : AppCompatActivity() {

    private lateinit var btnOpenAT2: Button
    private lateinit var btnChangeLanguagePt: Button
    private lateinit var btnChangeLanguageEn: Button

    private var language = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        btnOpenAT2 = findViewById(R.id.btnOpenAT2)
        btnChangeLanguagePt = findViewById(R.id.btnChangeLanguagePt)
        btnChangeLanguageEn = findViewById(R.id.btnChangeLanguageEn)

        btnOpenAT2.setOnClickListener {
            val intent = Intent(this, AT2::class.java)
            startActivity(intent)
        }

        btnChangeLanguagePt.setOnClickListener {
            setLanguage("pt")
        }

        btnChangeLanguageEn.setOnClickListener {
            setLanguage("en")
        }
    }

    private fun setLanguage(languageCode: String) {
        language = (languageCode == "pt")
        setAppLocale(languageCode)
    }

    private fun setAppLocale(languageCode: String) {
        val locale = Locale(languageCode)
        Locale.setDefault(locale)

        val configuration = resources.configuration
        configuration.setLocale(locale)

        @Suppress("DEPRECATION")
        baseContext.resources.updateConfiguration(configuration, baseContext.resources.displayMetrics)
    }
}