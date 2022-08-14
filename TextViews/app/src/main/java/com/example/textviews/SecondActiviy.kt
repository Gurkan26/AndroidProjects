package com.example.textviews

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class SecondActiviy : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_activiy)
        val buton2 = findViewById<Button>(R.id.buton2)

        buton2.setOnClickListener{
            Toast.makeText(this,"1. SAYFAYA GEÇİLİYOR....", Toast.LENGTH_SHORT).show()

            val Intent = Intent(this,MainActivity::class.java)
        startActivity(Intent)
        }
    }
}