package com.example.tipper.activities

import android.widget.TextView
import android.os.Bundle
import com.example.tipper.R
import android.widget.EditText
import android.text.TextWatcher
import android.text.Editable
import android.widget.Spinner
import android.widget.AdapterView
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import java.lang.NumberFormatException
import java.text.DecimalFormat

class CalorieActivity : AppCompatActivity() {
    private var weight = 0.0
    private var height = 0.0
    private var age = 0
    private var result = 0.0
    private var gender: String? = null
    private var genderDropdown: Spinner? = null
    private var heightEditText: EditText? = null
    private var weightEditText: EditText? = null
    private var ageEditText: EditText? = null
    private var resultTextView: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calorie)
        genderDropdown = findViewById<View>(R.id.genderDropdown) as Spinner
        genderDropdown!!.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(adapterView: AdapterView<*>?, view: View, i: Int, l: Long) {
                calculate()
            }

            override fun onNothingSelected(adapterView: AdapterView<*>?) {}
        }
        heightEditText = findViewById<View>(R.id.heightEditText) as EditText
        heightEditText!!.addTextChangedListener(heightEditTextWatcher)
        weightEditText = findViewById<View>(R.id.weightEditText) as EditText
        weightEditText!!.addTextChangedListener(weightEditTextWatcher)
        ageEditText = findViewById<View>(R.id.ageEditText) as EditText
        ageEditText!!.addTextChangedListener(ageEditTextWatcher)
        resultTextView = findViewById<View>(R.id.resultTextView) as TextView
    }

    private fun calculate() {
        gender = genderDropdown!!.selectedItem.toString()
        val df = DecimalFormat("##.##")
        result = 0.0
        if (age > 0 && height > 0.0 && weight > 0.0) {
            result = if ("Male" == gender) {
                // Calculate for man
                66.5 + 13.75 * weight + 5.003 * height - 6.775 * age
            } else {
                // Calculate for woman
                655.1 + 9.563 * weight + 1.85 * height - 4.676 * age
            }
            resultTextView!!.text = df.format(result)
        } else {
            resultTextView!!.text = ""
        }
    }

    private val weightEditTextWatcher: TextWatcher = object : TextWatcher {
        override fun onTextChanged(s: CharSequence, start: Int,
                                   before: Int, count: Int) {
            weight = try { // get weight
                s.toString().toDouble()
            } catch (e: NumberFormatException) { // if s is empty or non-numeric
                0.0
            }
            calculate() // update the bmi TextView
        }

        override fun afterTextChanged(s: Editable) {}
        override fun beforeTextChanged(
                s: CharSequence, start: Int, count: Int, after: Int) {
        }
    }
    private val heightEditTextWatcher: TextWatcher = object : TextWatcher {
        override fun onTextChanged(s: CharSequence, start: Int,
                                   before: Int, count: Int) {
            height = try { // get weight
                s.toString().toDouble()
            } catch (e: NumberFormatException) {
                0.0
            }
            calculate() // update the bmi TextView
        }

        override fun afterTextChanged(s: Editable) {}
        override fun beforeTextChanged(
                s: CharSequence, start: Int, count: Int, after: Int) {
        }
    }
    private val ageEditTextWatcher: TextWatcher = object : TextWatcher {
        override fun onTextChanged(s: CharSequence, start: Int,
                                   before: Int, count: Int) {
            age = try { // get weight
                s.toString().toInt()
            } catch (e: NumberFormatException) {
                0
            }
            calculate() // update the bmi TextView
        }

        override fun afterTextChanged(s: Editable) {}
        override fun beforeTextChanged(
                s: CharSequence, start: Int, count: Int, after: Int) {
        }
    }
}