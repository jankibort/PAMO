// GameElement.java
// Represents a rectangle-bounded game element
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
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import com.example.tipper.activities.RecipeActivity
import com.example.tipper.activities.CalorieActivity
import com.example.tipper.activities.Bmi_Activity
import com.example.tipper.activities.QuizActivity
import com.example.tipper.activities.CannonActivity
import com.example.tipper.activities.QuizController
import com.example.tipper.activities.QuizQuestion

open class GameElement(// the view that contains this GameElement
        protected var view: CannonView?, color: Int, soundId: Int, x: Int,
        y: Int, width: Int, length: Int, velocityY: Float) {
    protected var paint = Paint() // Paint to draw this GameElement
    var shape // the GameElement's rectangular bounds
            : Rect
    private var velocityY // the vertical velocity of this GameElement
            : Float
    private val soundId // the sound associated with this GameElement
            : Int

    // update GameElement position and check for wall collisions
    open fun update(interval: Double) {
        // update vertical position
        shape.offset(0, (velocityY * interval).toInt())

        // if this GameElement collides with the wall, reverse direction
        if (shape.top < 0 && velocityY < 0 ||
                shape.bottom > view!!.screenHeight && velocityY > 0) velocityY *= -1f // reverse this GameElement's velocity
    }

    // draws this GameElement on the given Canvas
    open fun draw(canvas: Canvas?) {
        canvas!!.drawRect(shape, paint)
    }

    // plays the sound that corresponds to this type of GameElement
    fun playSound() {
        view!!.playSound(soundId)
    }

    // public constructor
    init {
        paint.color = color
        shape = Rect(x, y, x + width, y + length) // set bounds
        this.soundId = soundId
        this.velocityY = velocityY
    }
}