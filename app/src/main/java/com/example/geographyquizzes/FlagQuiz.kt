package com.example.geographyquizzes

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import com.example.geographyquizzes.databinding.ActivityFlagQuizBinding

class FlagQuiz : AppCompatActivity(), View.OnClickListener {

    private var binding: ActivityFlagQuizBinding? = null

    // Declare the current position, questions list, selected option, number of correct answer and username
    var currentPosition: Int = 1 // Current position in questions list
    var questionsList: ArrayList<Question>? = null
    var selectedOption: Int? = null // option that they selected
    var correctAnswers = 0 // amount of correct answers
    lateinit var username: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFlagQuizBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        // Initialise in the questions list
        questionsList = Constants.getFlagQuizQuestions()
        // Initialise in the username that was passed from the previous activity
        username = intent.getStringExtra(Constants.USER_NAME).toString()

        // Set the onclick listeners for all of the options textviews and for the submit button
        binding?.tvOption1?.setOnClickListener(this)
        binding?.tvOption2?.setOnClickListener(this)
        binding?.tvOption3?.setOnClickListener(this)
        binding?.tvOption4?.setOnClickListener(this)
        binding?.btnSubmit?.setOnClickListener(this)

        // Set the first question
        setQuestion()

    }

    // To set each question
    fun setQuestion() {
        /* Make the options textview background default so that the red and green colours from the previous questions
        don't remain */
        defaultOptionsView()
        // Make selectedOption null so they have to answer the question
        selectedOption = null
        // Change the submit button to "Submit" instead of "Go to next question" from the previous question
        binding?.btnSubmit?.text = getString(R.string.submit)
        // Create a new variable of type "Question" and set it to the current position
        val question: Question = questionsList!![currentPosition]
        // Initialise all the variables according to the current position of the question
        binding?.ivCountryFlag?.setImageResource(question.flag)
        binding?.progressBar?.progress = currentPosition
        binding?.tvProgress?.text = "$currentPosition/${binding?.progressBar?.max}"
        binding?.tvOption1?.text = question.optionOne
        binding?.tvOption2?.text = question.optionTwo
        binding?.tvOption3?.text = question.optionThree
        binding?.tvOption4?.text = question.optionFour
    }

    // To show the default options view
    private fun defaultOptionsView() {
        /* Create an array to store the options, as this is quicker and fewer lines of code that setting
        each textview separately. */
        val options = ArrayList<TextView>()
        // Add all the textviews
        binding?.tvOption1?.let {
            options.add(0, it)
        }
        binding?.tvOption2?.let {
            options.add(1, it)
        }
        binding?.tvOption3?.let {
            options.add(2, it)
        }
        binding?.tvOption4?.let {
            options.add(3, it)
        }

        // Set each textview to the default colour/background
        for (option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this, R.drawable.default_option_border_bg)
        }
    }

    // To highlight the selected option
    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int) {
        // Use if statement so that options can only be selected before submission and not after
        if (binding?.btnSubmit?.text.toString() == "Submit") {
            // Call defaultOptionsView so that if the user changes their mind, multiple options won't be highlighted at once
            defaultOptionsView()
            // Set the selected option so that we can work out later if they chose the right or wrong answer
            selectedOption = selectedOptionNum
            // Set the colour/background of the selected option
            tv.setTextColor(Color.parseColor("#363A43"))
            tv.setTypeface(tv.typeface, Typeface.BOLD)
            tv.background = ContextCompat.getDrawable(this, R.drawable.selected_option_border_bg)
        }
    }

    /* To show the correct/incorrect answer
    The background has been made more flexible so we can use this method to show both correct and incorrect
    answers, as we will see later
     */
    private fun answerView(selectedOption: Int, background: Int) {
        when (selectedOption) {
            1 -> {
                binding?.tvOption1?.background = ContextCompat.getDrawable(this, background)
            }
            2 -> {
                binding?.tvOption2?.background = ContextCompat.getDrawable(this, background)
            }
            3 -> {
                binding?.tvOption3?.background = ContextCompat.getDrawable(this, background)
            }
            4 -> {
                binding?.tvOption4?.background = ContextCompat.getDrawable(this, background)
            }
        }
    }

    override fun onClick(button: View?) {
        /*
    When the textview options are clicked, then put on the selected option view and make the selected
    option the number that corresponds to the texview, i.e. if tvOption1 is chosen, then the selected
    option is 1
     */
        when (button?.id) {
            R.id.tv_option1 -> {
                binding?.tvOption1?.let {
                    selectedOptionView(it, 1)
                }
            }
            R.id.tv_option2 -> {
                binding?.tvOption2?.let {
                    selectedOptionView(it, 2)
                }
            }
            R.id.tv_option3 -> {
                binding?.tvOption3?.let {
                    selectedOptionView(it, 3)
                }
            }
            R.id.tv_option4 -> {
                binding?.tvOption4?.let {
                    selectedOptionView(it, 4)
                }
            }

            binding?.btnSubmit?.id -> {
                // Make sure an answer is selected
                if (selectedOption == null) {
                    Toast.makeText(this@FlagQuiz, "Please select an answer", Toast.LENGTH_SHORT).show()
                }
                /*
            If the button contains the string "Submit" then if the selected option is NOT equal to the
            correct answer in the questions list, then display the selected answer in red, else if it
            is the correct answer increment the correctAnswers variable by 1.
             */
                else if (binding?.btnSubmit?.text.toString() == getString(R.string.submit) && selectedOption != null) {
                    if (selectedOption != questionsList!![currentPosition].correctAnswer) {
                        answerView(selectedOption!!, R.drawable.incorrect_option_border_bg)
                    } else if (selectedOption == questionsList!![currentPosition].correctAnswer) {
                        correctAnswers++
                    }
                    answerView(
                        questionsList!![currentPosition].correctAnswer,
                        R.drawable.correct_option_border_bg
                    )
                    /*Display the correct answer in green either way, and also change the button text
                     to either "Go to next question" or "Finish" depending on how many questions are left.
                    */
                    if (currentPosition < questionsList!!.size - 1) {
                        binding?.btnSubmit?.text = getString(R.string.next_question)
                    } else {
                        binding?.btnSubmit?.text = getString(R.string.finish)
                    }
                }

                /*
                If the button contains either the string "Go to next question" then increment the
                current position by 1 and set the next question
                 */
                else if (binding?.btnSubmit?.text.toString() == getString(R.string.next_question)) {
                    currentPosition++
                    setQuestion()
                }
                /*
                If the button contains the string "Finish" then take the user to the results activity/page
                and pass the username, number of correct answers and total questions to the next activity.
                 */
                else if (binding?.btnSubmit?.text.toString() == getString(R.string.finish)) {
                    val intent = Intent(this, ResultsActivity::class.java)
                    intent.putExtra(Constants.USER_NAME, username)
                    intent.putExtra(Constants.CORRECT_ANSWERS, correctAnswers)
                    intent.putExtra(Constants.TOTAL_QUESTIONS, questionsList!!.size - 1)
                    intent.putExtra(Constants.QUIZ_TAKEN, "Flag Quiz")
                    startActivity(intent)
                    finish()
                }

            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}