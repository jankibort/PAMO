package com.example.tipper.activities

import com.example.tipper.activities.CannonView
import com.example.tipper.activities.GameElement
import android.os.Bundle
import com.example.tipper.R
import android.text.TextWatcher
import android.text.Editable
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
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.tipper.activities.RecipeActivity
import com.example.tipper.activities.CalorieActivity
import com.example.tipper.activities.Bmi_Activity
import com.example.tipper.activities.QuizActivity
import com.example.tipper.activities.CannonActivity
import com.example.tipper.activities.QuizController
import com.example.tipper.activities.QuizQuestion

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState) // call superclass onCreate
        setContentView(R.layout.activity_home) // inflate the GUI
        val bmiButton: Button
        val kcalButton: Button
        val recipesButton: Button
        val quizButton: Button
        val gameButton: Button
        bmiButton = findViewById<View>(R.id.bmiButton) as Button
        kcalButton = findViewById<View>(R.id.kcalButton) as Button
        recipesButton = findViewById<View>(R.id.recipesButton) as Button
        quizButton = findViewById<View>(R.id.quizButton) as Button
        gameButton = findViewById<View>(R.id.gameButton) as Button
        bmiButton.setOnClickListener { launchBMIActivity() }
        kcalButton.setOnClickListener { launchCalorieActivity() }
        recipesButton.setOnClickListener { launchRecipeActivity() }
        quizButton.setOnClickListener { launchQuizActivity() }
        gameButton.setOnClickListener { launchGameActivity() }
    }

    private fun launchRecipeActivity() {
        val intent = Intent(this, RecipeActivity::class.java)
        startActivity(intent)
    }

    private fun launchCalorieActivity() {
        val intent = Intent(this, CalorieActivity::class.java)
        startActivity(intent)
    }

    private fun launchBMIActivity() {
        val intent = Intent(this, Bmi_Activity::class.java)
        startActivity(intent)
    }

    private fun launchQuizActivity() {
        val intent = Intent(this, QuizActivity::class.java)
        startActivity(intent)
    }

    private fun launchGameActivity() {
        val intent = Intent(this, CannonActivity::class.java)
        startActivity(intent)
    }
}