package com.example.okhttpdeneme


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import okhttp3.Request

class MainActivity : AppCompatActivity() {

    val serviceUrl = "https://rickandmortyapi.com/api/character/175"
    /*Servisin cevabı mortynin babasının bilgileri olacak.
     */


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rb = Request.Builder()
        rb.url(serviceUrl)
        WebServis(this::sonucFonk).execute(rb.build())
    }

    fun sonucFonk(sonucStr:String?){
        Log.d("sonuc",sonucStr!!)
    }

}