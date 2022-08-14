package com.example.checkboxtutorial

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val cbA=findViewById<CheckBox>(R.id.checkBox)
        val cbB=findViewById<CheckBox>(R.id.checkBox2)
        val cbC=findViewById<CheckBox>(R.id.checkBox3)
        val cbD=findViewById<CheckBox>(R.id.checkBox4)
        val cbE=findViewById<CheckBox>(R.id.checkBox5)
        val tview=findViewById<TextView>(R.id.textView)


        val buton =findViewById<Button>(R.id.button).setOnClickListener {

            var mesaj=""
            if(cbA.isChecked)
                mesaj+= cbA.text.toString()
            tview.text=mesaj
            if(cbB.isChecked)
                mesaj+= cbB.text.toString()
            tview.text=mesaj
            if(cbC.isChecked)
                mesaj+= cbC.text.toString()
            tview.text=mesaj
            if(cbD.isChecked)
                mesaj+= cbD.text.toString()
            tview.text=mesaj
            if(cbE.isChecked)
                mesaj+= cbE.text.toString()
            tview.text=mesaj
        }

    }
}