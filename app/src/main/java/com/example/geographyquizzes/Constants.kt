package com.example.geographyquizzes

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.widget.Button

object Constants {

    const val USER_NAME : String = "user_name"
    const val TOTAL_QUESTIONS : String = "total_questions"
    const val CORRECT_ANSWERS : String = "correct_answers"
    const val QUIZ_TAKEN : String = "quiz_taken"

    fun getFlagQuizQuestions() : ArrayList<Question> {

        val questionsList = ArrayList<Question>()

        val question1 = Question(
            1, "What country does this flag belong to?",
            R.drawable.ic_flag_of_argentina, "Argentina",
            "Australia", "Armenia", "Austria",
            1
        )
        questionsList.add(question1)

        val question2 = Question(
            2, "What country does this flag belong to?",
            R.drawable.ic_flag_of_australia, "India",
            "Australia", "Japan", "Kuwait",
            2
        )
        questionsList.add(question2)

        val question3 = Question(
            3, "What country does this flag belong to?",
            R.drawable.ic_flag_of_belgium, "Bangladesh",
            "Germany", "Belgium", "South Africa",
            3
        )
        questionsList.add(question3)

        val question4 = Question(
            4, "What country does this flag belong to?",
            R.drawable.ic_flag_of_brazil, "Spain",
            "Portugal", "Pakistan", "Brazil",
            4
        )
        questionsList.add(question4)

        val question5 = Question(
            5, "What country does this flag belong to?",
            R.drawable.ic_flag_of_denmark, "Germany",
            "Denmark", "Ethiopia", "Ghana",
            2
        )
        questionsList.add(question5)

        val question6 = Question(
            6, "What country does this flag belong to?",
            R.drawable.ic_flag_of_fiji, "Australia",
            "New Zealand", "United Kingdom", "Fiji",
            4
        )
        questionsList.add(question6)

        val question7 = Question(
            7, "What country does this flag belong to?",
            R.drawable.ic_flag_of_germany, "Belgium",
            "Germany", "Armenia", "France",
            2
        )
        questionsList.add(question7)

        val question8 = Question(
            8, "What country does this flag belong to?",
            R.drawable.ic_flag_of_india, "China",
            "Hong Kong", "India", "Bangladesh",
            3
        )
        questionsList.add(question8)

        val question9 = Question(
            9, "What country does this flag belong to?",
            R.drawable.ic_flag_of_kuwait, "Kuwait",
            "Saudi Arabia", "Jordan", "Libya",
            1
        )
        questionsList.add(question9)

        val question10 = Question(
            10, "What country does this flag belong to?",
            R.drawable.ic_flag_of_new_zealand, "Australia",
            "United Kingdom", "New Zealand", "France",
            3
        )
        questionsList.add(question10)

        return questionsList
    }

    fun getCapitalCitiesQuizQuestions() : ArrayList<Question> {

        val questionsList = ArrayList<Question>()

        val question1 = Question(1, "What is the capital of Argentina?",
            R.drawable.ic_flag_of_argentina, "Santiago", "Lima", "Buenos Aires",
            "Bogota", 3
        )
        questionsList.add(question1)

        val question2 = Question(2, "What is the capital of Australia?",
            R.drawable.ic_flag_of_australia, "Canberra", "Sydney", "Melbourne",
            "Perth", 1
        )
        questionsList.add(question2)

        val question3 = Question(3, "What is the capital of Belgium?",
            R.drawable.ic_flag_of_belgium, "Antwerp", "Paris", "Amsterdam",
            "Brussels", 4
        )
        questionsList.add(question3)

        val question4 = Question(4, "What is the capital of Brazil?",
            R.drawable.ic_flag_of_brazil, "Rio de Janeiro", "Brasilia", "Sao Paulo",
            "Salvador", 2
        )
        questionsList.add(question4)

        val question5 = Question(5, "What is the capital of Denmark?",
            R.drawable.ic_flag_of_denmark, "Stockholm", "Oslo", "Dublin",
            "Copenhagen", 4
        )
        questionsList.add(question5)

        val question6 = Question(6, "What is the capital of Fiji?",
            R.drawable.ic_flag_of_fiji, "Honiara", "Suva", "Apia",
            "Port Moresby", 2
        )
        questionsList.add(question6)

        val question7 = Question(7, "What is the capital of Germany?",
            R.drawable.ic_flag_of_germany, "Munich", "Berlin", "Vienna",
            "Paris", 2
        )
        questionsList.add(question7)

        val question8 = Question(8, "What is the capital of India?",
            R.drawable.ic_flag_of_india, "Mumbai", "Kolkata", "Bengaluru",
            "New Delhi", 4
        )
        questionsList.add(question8)

        val question9 = Question(9, "What is the capital of Kuwait?",
            R.drawable.ic_flag_of_kuwait, "Kuwait City", "Dubai", "Abu Dhabi",
            "Doha", 1
        )
        questionsList.add(question9)

        val question10 = Question(10, "What is the capital of New Zealand?",
            R.drawable.ic_flag_of_new_zealand, "Auckland", "Christchurch",
            "Wellington", "Napier", 3
        )
        questionsList.add(question10)

        return questionsList
    }

    fun getCountryOutlineQuizQuestions(): ArrayList<Question> {
        val questionsList = ArrayList<Question>()

        val question1 = Question(1, "Which country is this?", R.drawable.ic_argentina_outline,
        "Brazil", "Croatia", "Argentina", "Paraguay", 3
        )
        questionsList.add(question1)

        val question2 = Question(2, "Which country is this?", R.drawable.ic_australia_outline,
            "United Kingdom", "Australia", "Russia", "Fiji", 2
        )
        questionsList.add(question2)

        val question3 = Question(3, "Which country is this?", R.drawable.ic_belgium_outline,
            "Belgium", "France", "Germany", "India", 1
        )
        questionsList.add(question3)

        val question4 = Question(4, "Which country is this?", R.drawable.ic_brazil_outline,
            "Ghana", "Croatia", "USA", "Brazil", 4
        )
        questionsList.add(question4)

        val question5 = Question(5, "Which country is this?", R.drawable.ic_denmark_outline,
            "Denmark", "Sweden", "Finland", "Portugal", 1
        )
        questionsList.add(question5)

        val question6 = Question(6, "Which country is this?", R.drawable.ic_fiji_outline,
            "Bangladesh", "Nepal", "Fiji", "Tuvalu", 3
        )
        questionsList.add(question6)

        val question7 = Question(7, "Which country is this?", R.drawable.ic_germany_outline,
            "Belgium", "Germany", "France", "Spain", 2
        )
        questionsList.add(question7)

        val question8 = Question(8, "Which country is this?", R.drawable.ic_india_outline,
            "India", "Brazil", "Pakistan", "Bangladesh", 1
        )
        questionsList.add(question8)

        val question9 = Question(9, "Which country is this?", R.drawable.ic_kuwait_outline,
            "UAE", "Lebanon", "Morocco", "Kuwait", 4
        )
        questionsList.add(question9)

        val question10 = Question(10, "Which country is this?", R.drawable.ic_new_zealand_outline,
            "Italy", "United Kingdom", "New Zealand", "Paraguay", 3
        )
        questionsList.add(question10)

        return questionsList
    }

}