package com.example.dsardanverialma

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val tiklanma = findViewById<Button>(R.id.button).setOnClickListener{
            PersonName(it)
            // Hide the keyboard.
            val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(it.windowToken, 0)

        }
        findViewById<TextView>(R.id.textView).setOnClickListener{
            updatePersonName(it)
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.showSoftInput(it, 0)

        }

    }

    private fun PersonName(view: View){
        val editText= findViewById<EditText>(R.id.nameEditText)
        val personNameView=findViewById<TextView>(R.id.textView)
        personNameView.text=editText.text
        view.visibility=View.GONE
        personNameView.visibility=View.VISIBLE

    }
    private fun updatePersonName(view:View){
        val editText= findViewById<EditText>(R.id.nameEditText)
        val doneButton=findViewById<Button>(R.id.button)
        editText.visibility=View.VISIBLE
        doneButton.visibility=View.VISIBLE
        view.visibility=View.GONE
        editText.requestFocus()

    }
}