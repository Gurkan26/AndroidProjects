package com.example.tasarmodevradiobuttonintentkavram

import android.graphics.Color
import android.graphics.ColorSpace
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import androidx.core.graphics.toColor
import androidx.core.graphics.toColorInt
import com.example.tasarmodevradiobuttonintentkavram.databinding.ActivityMain2Binding
import com.example.tasarmodevradiobuttonintentkavram.databinding.ActivityMainBinding
import com.example.tasarmodevradiobuttonintentkavram.databinding.ActivityMainBinding.*
import java.lang.String

class MainActivity2 : AppCompatActivity() {
private  lateinit var binding: ActivityMain2Binding
    @ColorInt
    var selectedColor: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMain2Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        var newText=intent.getStringExtra("newText")
        val newTextSize=intent.getFloatExtra("textSize",0F)

        selectedColor=intent.getIntExtra("textColor",0)
       // val getNewText=binding.textView2 //findViewById<TextView>(R.id.textView2)

        binding.textView2.text=newText
        binding.textView2.textSize=newTextSize
        binding.textView2.setTextColor(selectedColor)

    }
}


