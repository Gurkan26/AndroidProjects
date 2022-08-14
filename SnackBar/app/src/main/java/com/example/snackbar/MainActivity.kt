package com.example.snackbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private  lateinit var timer:CountDownTimer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val butonName=findViewById<Button>(R.id.button).setOnClickListener {
           Snackbar.make(it,"Time Out",Snackbar.LENGTH_LONG).apply {
               setAction("Restart"){ Snackbar.make(it,"Okey Lets Go",Snackbar.LENGTH_SHORT).show()}


           }.show()
        }

    }
}