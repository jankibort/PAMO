package com.example.tipper.activities

import com.example.tipper.activities.CannonView
import com.example.tipper.activities.GameElement
import android.widget.TextView
import android.os.Bundle
import com.example.tipper.R
import android.widget.EditText
import android.text.TextWatcher
import android.text.Editable
import android.widget.Spinner
import android.widget.AdapterView
import com.example.tipper.activities.Cannonball
import android.media.AudioManager
import com.example.tipper.activities.CannonView.CannonThread
import android.app.Activity
import com.example.tipper.activities.Cannon
import com.example.tipper.activities.Blocker
import android.media.SoundPool
import android.util.SparseIntArray
import android.os.Build
import android.media.AudioAttributes
import android.content.Intent
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import com.example.tipper.activities.RecipeActivity
import com.example.tipper.activities.CalorieActivity
import com.example.tipper.activities.Bmi_Activity
import com.example.tipper.activities.QuizActivity
import com.example.tipper.activities.CannonActivity
import com.example.tipper.activities.QuizController
import com.example.tipper.activities.QuizQuestion
import java.lang.NumberFormatException
import java.text.DecimalFormat

// for EditText event handling
// EditText listener
// for bill amount input
// for displaying text
class Bmi_Activity : AppCompatActivity() {
    private var weight = 0.0 // initial weight percentage
    private var height = 0.0 // initial height percentage
    private var weightTextView // shows formatted bill amount
            : TextView? = null
    private var heightTextView // shows tip percentage
            : TextView? = null
    private var bmiTextView // shows calculated total bill amount
            : TextView? = null

    // called when the activity is first created
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState) // call superclass onCreate
        setContentView(R.layout.activity_bmi) // inflate the GUI

        // get references to programmatically manipulated TextViews
        weightTextView = findViewById<View>(R.id.weightTextView) as TextView
        heightTextView = findViewById<View>(R.id.heightTextView) as TextView
        bmiTextView = findViewById<View>(R.id.bmiTextView) as TextView

        // set amountEditText's TextWatcher
        val weightEditText = findViewById<View>(R.id.weightEditText) as EditText
        weightEditText.addTextChangedListener(weightEditTextWatcher)
        val heightEditText = findViewById<View>(R.id.heightEditText) as EditText
        heightEditText.addTextChangedListener(heightEditTextWatcher)
    }

    // calculate and display tip and total amounts
    private fun calculate() {
        val df = DecimalFormat("##.##")

        // calculate the bmi
        val bmi = weight / (height * height)

        // display mbi
        if (height > 0.0 && weight > 0.0) {
            bmiTextView!!.text = df.format(bmi)
        } else {
            bmiTextView!!.text = ""
        }
    }

    // listener object for the EditText's text-changed events
    private val weightEditTextWatcher: TextWatcher = object : TextWatcher {
        // called when the user modifies the weight amount
        override fun onTextChanged(s: CharSequence, start: Int,
                                   before: Int, count: Int) {
            try { // get weight
                weight = s.toString().toDouble()
                weightTextView!!.text = s.toString()
            } catch (e: NumberFormatException) { // if s is empty or non-numeric
                weightTextView!!.text = ""
                weight = 0.0
            }
            calculate() // update the bmi TextView
        }

        override fun afterTextChanged(s: Editable) {}
        override fun beforeTextChanged(
                s: CharSequence, start: Int, count: Int, after: Int) {
        }
    }
    private val heightEditTextWatcher: TextWatcher = object : TextWatcher {
        // called when the user modifies the height amount
        override fun onTextChanged(s: CharSequence, start: Int,
                                   before: Int, count: Int) {
            try { // get height
                height = s.toString().toDouble()
                heightTextView!!.text = s.toString()
            } catch (e: NumberFormatException) { // if s is empty or non-numeric
                heightTextView!!.text = ""
                height = 0.0
            }
            calculate() // update the bmi TextView
        }

        override fun afterTextChanged(s: Editable) {}
        override fun beforeTextChanged(
                s: CharSequence, start: Int, count: Int, after: Int) {
        }
    }
}