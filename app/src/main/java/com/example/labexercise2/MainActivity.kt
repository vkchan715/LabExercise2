package com.example.labexercise2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import kotlin.math.pow
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.buttonCalculate).setOnClickListener {
            calculate()
        }
        findViewById<Button>(R.id.buttonReset).setOnClickListener {
            reset()
        }
    }
    private fun calculate(){
        val weight = findViewById<EditText>(R.id.editTextWeight).text.toString().toDoubleOrNull()
        val height = findViewById<EditText>(R.id.editTextHeight).text.toString().toDoubleOrNull()

        if(weight != null && height != null) {
            val bmi = weight / ((height / 100).pow(2))

            findViewById<TextView>(R.id.textViewBMI).text = bmi.toString()

            if (bmi < 18.5) {
                findViewById<ImageView>(R.id.imageViewProfile).setImageResource(R.drawable.under)
            } else if (bmi >= 18.5 && bmi <= 24.9) {
                findViewById<ImageView>(R.id.imageViewProfile).setImageResource(R.drawable.normal)
            } else if (bmi > 24.9) {
                findViewById<ImageView>(R.id.imageViewProfile).setImageResource(R.drawable.over)
            }
        }else {
            if (weight == null) {
                findViewById<EditText>(R.id.editTextWeight).error = "Please enter a valid weight"
            }
            if (height == null) {
                findViewById<EditText>(R.id.editTextHeight).error = "Please enter a valid height"
            }
        }
    }

    private fun reset(){
        findViewById<EditText>(R.id.editTextHeight).setText("")
        findViewById<EditText>(R.id.editTextWeight).setText("")
        findViewById<ImageView>(R.id.imageViewProfile).setImageResource(R.drawable.empty)
        findViewById<TextView>(R.id.textViewBMI).text = "BMI :"
    }
}
