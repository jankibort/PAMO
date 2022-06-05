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
import android.view.LayoutInflater
import android.view.ViewGroup
import android.media.AudioManager
import android.view.SurfaceView
import android.view.SurfaceHolder
import com.example.tipper.activities.CannonView.CannonThread
import android.app.Activity
import com.example.tipper.activities.Cannon
import com.example.tipper.activities.Blocker
import android.media.SoundPool
import android.util.SparseIntArray
import android.view.MotionEvent
import android.os.Build
import android.media.AudioAttributes
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import com.example.tipper.activities.RecipeActivity
import com.example.tipper.activities.CalorieActivity
import com.example.tipper.activities.Bmi_Activity
import com.example.tipper.activities.QuizActivity
import com.example.tipper.activities.CannonActivity
import com.example.tipper.activities.QuizController
import com.example.tipper.activities.QuizQuestion

class RecipeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe)
    }
}