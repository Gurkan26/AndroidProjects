package com.example.tasarmodevradiobuttonintentkavram

import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import com.example.tasarmodevradiobuttonintentkavram.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
     lateinit var binding: ActivityMainBinding

    @ColorInt
    var selectedColor: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        textInput()
        textSize()
        textColor()
        //val newText = binding.textView //findViewById<TextView>(R.id.textView)
       // val button = binding.button //findViewById<Button>(R.id.button)
     //   val newTextSize: Float? = binding.textView.textSize

        binding.button.setOnClickListener {
            var newText2 = binding.textView.text.toString()
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("newText", binding.textView.text.toString())
            intent.putExtra("textSize", binding.textView.textSize)
            intent.putExtra("textColor", selectedColor)

            startActivity(intent)

        }

    }

    private fun textInput() {
        // val oldText = binding.editTextTextPersonName //findViewById<EditText>(R.id.editTextTextPersonName)
        // val newText = binding.textView//findViewById<TextView>(R.id.textView)
        binding.editTextTextPersonName.setOnFocusChangeListener { _, hasFocus -> // Eğer edittexte veri girişi durduysa alttaki işlemleri yap.
            if (!hasFocus) {
                binding.textView.append("${binding.editTextTextPersonName.text}")
            }
        }


    } //Edittext'i TextView'a atama metodu

    private fun textSize() {

        //  val newText = binding.textView //findViewById<TextView>(R.id.textView)
        //val rdGroup =binding.radioGroup //findViewById<RadioGroup>(R.id.radioGroup)

        binding.radioGroup.setOnCheckedChangeListener { _, checkedId ->
            if (R.id.rb14 == checkedId)
                binding.textView.textSize = 14F
            if (R.id.rb18 == checkedId)
                binding.textView.textSize = 18F

            if (R.id.rb20 == checkedId)
                binding.textView.textSize = 20F

            if (R.id.rb24 == checkedId)
                binding.textView.textSize = 24F


        }
    } // RadioButton ile textsize ayarlama metodu

    private fun textColor() {

        // val newText = binding.textView //findViewById<TextView>(R.id.textView)
        // val rdGroup = binding.radioGroup2 //findViewById<RadioGroup>(R.id.radioGroup2)

        binding.radioGroup2.setOnCheckedChangeListener { _, checkedId ->
            if (R.id.rbYesil == checkedId) {
                binding.textView.setTextColor(ContextCompat.getColor(this, R.color.green))
                selectedColor = R.color.green
            }
            if (R.id.rbMor == checkedId) {
                binding.textView.setTextColor(ContextCompat.getColor(this, R.color.purple))
                selectedColor = R.color.purple
            }

            if (R.id.rbKirmizi == checkedId) {
                binding.textView.setTextColor(ContextCompat.getColor(this, R.color.red))
                selectedColor = R.color.red
            }

            if (R.id.rbMavi == checkedId) {
                binding.textView.setTextColor(ContextCompat.getColor(this, R.color.blue))
                selectedColor = R.color.blue
            }


        }
    } // RadioButton ile textcolor ayarlama metodu

}