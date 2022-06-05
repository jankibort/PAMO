package com.example.tipper.activities

class QuizQuestion(private val question: String?, private val answer1: String?, private val answer2: String?, private val goodAnswerIndex: Int) {
    fun getGoodAnswerIndex(): Int {
        return goodAnswerIndex
    }

    fun getQuestion(): String? {
        return question
    }

    fun getAnswer1(): String? {
        return answer1
    }

    fun getAnswer2(): String? {
        return answer2
    }
}