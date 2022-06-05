// MainActivityFragment.java
// MainActivityFragment creates and manages a CannonView
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
import androidx.fragment.app.Fragment
import com.example.tipper.activities.RecipeActivity
import com.example.tipper.activities.CalorieActivity
import com.example.tipper.activities.Bmi_Activity
import com.example.tipper.activities.QuizActivity
import com.example.tipper.activities.CannonActivity
import com.example.tipper.activities.QuizController
import com.example.tipper.activities.QuizQuestion

class CannonActivityFragment : Fragment() {
    private var cannonView // custom view to display the game
            : CannonView? = null

    // called when Fragment's view needs to be created
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        // inflate the fragment_main.xml layout
        val view = inflater.inflate(R.layout.fragment_main, container, false)

        // get a reference to the CannonView
        cannonView = view.findViewById<View>(R.id.cannonView) as CannonView
        return view
    }

    // set up volume control once Activity is created
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        // allow volume buttons to set game volume
        activity!!.volumeControlStream = AudioManager.STREAM_MUSIC
    }

    // when MainActivity is paused, terminate the game
    override fun onPause() {
        super.onPause()
        cannonView!!.stopGame() // terminates the game
    }

    // when MainActivity is paused, MainActivityFragment releases resources
    override fun onDestroy() {
        super.onDestroy()
        cannonView!!.releaseResources()
    }
}