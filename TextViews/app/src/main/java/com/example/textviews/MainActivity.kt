package com.example.textviews

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val clickme=findViewById<Button>(R.id.clickMe)


        clickme.setOnClickListener {
            Toast.makeText(this,"2. SAYFAYA GEÇİLİYOR....",Toast.LENGTH_SHORT).show()

            val Intent =Intent(this,SecondActiviy::class.java)
            startActivity(Intent)
        }

    }
}