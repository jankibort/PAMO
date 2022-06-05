package com.example.tipper.activities

import android.os.Bundle
import com.example.tipper.R
import android.view.*
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class QuizActivity : AppCompatActivity() {
    var controller: QuizController? = null
    var questionTextView: TextView? = null
    var answer1btn: Button? = null
    var answer2btn: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState) // call superclass onCreate
        setContentView(R.layout.activity_quiz) // inflate the GUI
        questionTextView = findViewById<View>(R.id.questionTextView) as TextView
        answer1btn = findViewById<View>(R.id.answer1button) as Button
        answer2btn = findViewById<View>(R.id.answer2button) as Button
        controller = QuizController(this.applicationContext)
        SetUpQuestionAndAnswer()
        answer1btn!!.setOnClickListener {
            controller!!.Answer(0)
            checkContinuityOfQuiz()
        }
        answer2btn!!.setOnClickListener {
            controller!!.Answer(1)
            checkContinuityOfQuiz()
        }
    }

    private fun checkContinuityOfQuiz() {
        if (controller!!.isFinished()) {
            questionTextView!!.text = "Udzieliłeś " + controller!!.getGoodAnswers() + " poprawnych odpowiedzi z " + controller!!.getQuestionsAndAnswers()!!.size
            answer1btn!!.visibility = View.INVISIBLE
            answer2btn!!.visibility = View.INVISIBLE
        } else {
            SetUpQuestionAndAnswer()
        }
    }

    private fun SetUpQuestionAndAnswer() {
        questionTextView!!.text = controller!!.GetCurrentQuestion()
        answer1btn!!.text = controller!!.GetCurrentAnswer1()
        answer2btn!!.text = controller!!.GetCurrentAnswer2()
    }
}