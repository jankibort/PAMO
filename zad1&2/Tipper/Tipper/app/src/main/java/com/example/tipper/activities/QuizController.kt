package com.example.tipper.activities

import android.content.Context
import android.content.res.Resources
import com.example.tipper.R
import java.util.*

class QuizController(val applicationContext: Context) {
    private val questionsAndAnswers: MutableList<QuizQuestion?> = ArrayList()
    private val questionsFromRes: MutableList<String> = ArrayList()
    private var currentQuestionIndex = 0
    private var goodAnswers = 0
    private var isFinished = false


    fun isFinished(): Boolean {
        return isFinished
    }

    fun getGoodAnswers(): Int {
        return goodAnswers
    }

    fun getQuestionsAndAnswers(): MutableList<QuizQuestion?>? {
        return questionsAndAnswers
    }

    fun GetCurrentQuestion(): String? {
        return questionsAndAnswers[currentQuestionIndex]!!.getQuestion()
    }

    fun GetCurrentAnswer1(): String? {
        return questionsAndAnswers[currentQuestionIndex]!!.getAnswer1()
    }

    fun GetCurrentAnswer2(): String? {
        return questionsAndAnswers[currentQuestionIndex]!!.getAnswer2()
    }

    fun Answer(answerIndex: Int) {
        if (questionsAndAnswers[currentQuestionIndex]!!.getGoodAnswerIndex() == answerIndex) {
            goodAnswers++
        }
        currentQuestionIndex++
        if (currentQuestionIndex >= questionsAndAnswers.size) {
            FinishQuiz()
        }
    }

    private fun FinishQuiz() {
        isFinished = true
    }

    private fun GenerateQuestions() {
        questionsFromRes.add("${applicationContext.getString(R.string.question1)};${applicationContext.getString(R.string.truth)};${applicationContext.getString(R.string.not_truth)};1")
        questionsFromRes.add("${applicationContext.getString(R.string.question2)};${applicationContext.getString(R.string.truth)};${applicationContext.getString(R.string.not_truth)};0")
        questionsFromRes.add("${applicationContext.getString(R.string.question3)};${applicationContext.getString(R.string.q3_truth)};${applicationContext.getString(R.string.q3_not_truth)};0")
        questionsFromRes.add("${applicationContext.getString(R.string.question4)};${applicationContext.getString(R.string.q4_not_truth)};${applicationContext.getString(R.string.q4_truth)};1")
        questionsFromRes.add("${applicationContext.getString(R.string.question5)};${applicationContext.getString(R.string.q5_truth)};${applicationContext.getString(R.string.q5_not_truth)};0")
        questionsFromRes.add("${applicationContext.getString(R.string.question6)};${applicationContext.getString(R.string.q6_not_truth)};${applicationContext.getString(R.string.q6_truth)};1")
        for (i in questionsFromRes.indices) {
            val question = questionsFromRes[i].split(";").toTypedArray()[0]
            val answer1 = questionsFromRes[i].split(";").toTypedArray()[1]
            val answer2 = questionsFromRes[i].split(";").toTypedArray()[2]
            val goodAnswerIndex = questionsFromRes[i].split(";").toTypedArray()[3].toInt()
            val quizQuestion = QuizQuestion(question, answer1, answer2, goodAnswerIndex)
            questionsAndAnswers.add(quizQuestion)
        }
    }

    private fun ShuffleQuestions() {
        Collections.shuffle(questionsAndAnswers)
    }

    init {
        GenerateQuestions()
        ShuffleQuestions()
    }
}