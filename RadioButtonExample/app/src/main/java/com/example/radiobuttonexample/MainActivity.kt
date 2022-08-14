package com.example.radiobuttonexample

import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.RadioGroup
import com.example.radiobuttonexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding= ActivityMainBinding.inflate(layoutInflater) // ViewBinding İşlemi
        val view=binding.root
        setContentView(view)
        binding.radioGroup.setOnCheckedChangeListener { group, checkedId ->
            if(R.id.radioButton2==checkedId)
                binding.textView2.text=binding.radioButton2.text.toString()
            if(R.id.radioButton3==checkedId)
                binding.textView2.text=binding.radioButton3.text.toString()
        }


    }
}