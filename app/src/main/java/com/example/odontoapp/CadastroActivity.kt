package com.example.odontoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.odontoapp.http.HttopHelper
import com.example.odontoapp.model.Dentista
import com.google.gson.Gson
import org.jetbrains.anko.doAsync

class CadastroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        val buttonSalvar = findViewById<Button>(R.id.button_salvar)
        val edit_nome = findViewById<EditText>(R.id.edit_text_nome)
        val edit_cro = findViewById<EditText>(R.id.edit_text_cro)
        val edit_telefone = findViewById<EditText>(R.id.edit_text_telefone)
        val edit_email = findViewById<EditText>(R.id.edit_text_email)

        buttonSalvar.setOnClickListener{
            //Criar um objeto dentista
            val dentista  = Dentista()
            dentista.nome = edit_nome.text.toString()
            dentista.cro = edit_cro.text.toString()
            dentista.email = edit_email.text.toString()
            dentista.telefone = edit_telefone.text.toString()

            //Converter dentista em json
            val gson = Gson()
            val dentistaJson = gson.toJson(dentista)

            doAsync {
                val http = HttopHelper()
                http.post(dentistaJson)
            }

        }

    }
}
