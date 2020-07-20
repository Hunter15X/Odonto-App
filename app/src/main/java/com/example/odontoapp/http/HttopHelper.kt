package com.example.odontoapp.http

import okhttp3.MediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody

class HttopHelper {

    fun post (json: String) : String {

        //Definindo a URL do servidor
        val URL = "http://192.168.0.30:8080/odonto/dentistas"

        //Definindo o cabeçalho
        val headerHttp = MediaType.parse("application/json; charset=utf-8")

        //Criando cliente para fazer a requesição
        val client = OkHttpClient()

        //Criar o body da requesição
        val body = RequestBody.create(headerHttp, json)

        //Construir a requesição POST http para o server
        val request = Request.Builder().url(URL).post(body).build()

        //Utilizar o client para fazer a requesição e receber a resposta
        val response = client.newCall(request).execute()

        return response.body().toString()
    }

}