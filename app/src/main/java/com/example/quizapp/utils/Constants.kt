package com.example.quizapp.utils

import com.example.quizapp.R
import com.example.quizapp.model.Question


object Constants{
    const val USER_NAME = "user_name"
    const val TOTAL_QUESTIONS = "total_questions"
    const val SCORE = "correct_answered"

    fun getQuestions() : MutableList<Question> {
        val question = mutableListOf<Question>()

        val quest1 = Question(1,"What country does this flag belong to?", R.drawable.france,
            "Italy","France","Netherlands","Russia",2)
        question.add(quest1)
        val quest2 = Question(2,"What country does this flag belong to?", R.drawable.japan,
            "China","South Korea","Japan","Vietnam",3)
        question.add(quest2)
        val quest3 = Question(3,"What country does this flag belong to?", R.drawable.brazil,
            "Argentina","Brazil","Portugal","Mexico",2)
        question.add(quest3)
        val quest4 = Question(4,"What country does this flag belong to?", R.drawable.unitedkingdom,
            "Australia","United States","United Kingdom","New Zealand",3)
        question.add(quest4)
        val quest5 = Question(5,"What country does this flag belong to?", R.drawable.india,
            "Bangladesh","India","Pakistan","Sri Lanka",2)
        question.add(quest5)
        val quest6 = Question(6,"What country does this flag belong to?", R.drawable.canada,
            "Canada","Switzerland","Austria","USA",1)
        question.add(quest6)
        val quest7 = Question(7,"What country does this flag belong to?", R.drawable.germany,
            "Germany","Belgium","Poland","Hungary",1)
        question.add(quest7)
        val quest8 = Question(8,"What country does this flag belong to?", R.drawable.southkorea,
            "China","North Korea","Japan","South Korea",4)
        question.add(quest8)
        val quest9 = Question(9,"What country does this flag belong to?", R.drawable.unitedstates,
            "United Kingdom","Canada","United States","Australia",3)
        question.add(quest9)
        val quest10 = Question(10,"What country does this flag belong to?", R.drawable.australia,
            "New Zealand","Australia","United Kingdom","South Africa",2)
        question.add(quest10)
    return question
    }
}