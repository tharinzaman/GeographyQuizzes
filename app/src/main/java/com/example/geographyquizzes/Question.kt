package com.example.geographyquizzes

data class Question(
    val id : Int,
    val question : String,
    val flag : Int,
    val optionOne : String,
    val optionTwo : String,
    val optionThree : String,
    val optionFour : String,
    val correctAnswer : Int
)
