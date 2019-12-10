package com.example.excercise2_gohshupherng

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalculate.setOnClickListener{
            calculate() }
        buttonReset.setOnClickListener{
            reset() }
    }

    private fun calculate(){

        if(editTextWeight.text.isEmpty() && editTextHeight.text.isEmpty()) {
            editTextHeight.setError(getString(R.string.input_error))
            editTextWeight.setError(getString(R.string.input_error))
            textViewBMI.text = getString(R.string.bmi)
            imageViewProfile.setImageResource(R.drawable.empty)
        }
        else if(editTextHeight.text.isEmpty()){
            editTextHeight.setError(getString(R.string.input_error))
            textViewBMI.text = getString(R.string.bmi)
            imageViewProfile.setImageResource(R.drawable.empty)
        }
        else if(editTextWeight.text.isEmpty()){
            editTextWeight.setError(getString(R.string.input_error))
            textViewBMI.text = getString(R.string.bmi)
            imageViewProfile.setImageResource(R.drawable.empty)
        }
        else {
            val weight = editTextWeight.text.toString().toDouble()
            val height = editTextHeight.text.toString().toDouble()

            val bmi = weight / ((height / 100) * (height / 100))

            if(bmi < 18.5) {
                imageViewProfile.setImageResource(R.drawable.under)
                textViewBMI.text = String.format("%s %.2f \n%s", getString(R.string.bmi), bmi,getString(R.string.under))
            }
            else if(bmi > 18.4 && bmi < 25.0) {
                imageViewProfile.setImageResource(R.drawable.normal)
                textViewBMI.text = String.format("%s %.2f \n%s", getString(R.string.bmi), bmi,getString(R.string.normal))
            }
            else {
                imageViewProfile.setImageResource(R.drawable.over)
                textViewBMI.text = String.format("%s %.2f \n%s", getString(R.string.bmi), bmi,getString(R.string.over))
            }
        }
    }

    private fun reset(){

        editTextWeight.setText("")
        editTextHeight.setText("")
        textViewBMI.text = getString(R.string.bmi)
        imageViewProfile.setImageResource(R.drawable.empty)
    }
}
