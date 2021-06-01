package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputBinding
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

       // findViewById<Button>(R.id.button).setOnClickListener {
         //   addFeelings(it)
        binding.button.setOnClickListener {
            addFeelings(it)
        }

    }

    private fun addFeelings(view: View){
        // val editText = findViewById<EditText>(R.id.feelings)
        // val display = findViewById<TextView>(R.id.textDisplay)

        // display.text = editText.text
        //editText.visibility = View.GONE
        //view.visibility = View.GONE
        // display.visibility = View.VISIBLE

        binding.apply {
            textDisplay.text = feelings.text
            invalidateAll()
            feelings.visibility = View.GONE
            button.visibility = View.GONE
            textDisplay.visibility = View.VISIBLE

        }

        // hide the keyboard
        val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)

    }
}