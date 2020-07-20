package com.example.odontoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonAbrirCadastro = findViewById<Button>(R.id.button_abrir_cadastro)

        buttonAbrirCadastro.setOnClickListener{
            val abrirCadastron = Intent(this, CadastroActivity::class.java)
            startActivity(abrirCadastron)
        }

    }
}
