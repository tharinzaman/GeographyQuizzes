package com.example.geographyquizzes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import com.example.geographyquizzes.ROOM.QuizDao
import com.example.geographyquizzes.ROOM.QuizEntity
import com.example.geographyquizzes.ROOM.RoomApp
import com.example.geographyquizzes.databinding.ActivityResultsBinding
import com.example.quizapp.MainActivity
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class ResultsActivity : AppCompatActivity() {

    private var binding : ActivityResultsBinding? = null

    lateinit var username: String
    var score: Int? = null
    lateinit var quizTaken: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultsBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        username = intent.getStringExtra(Constants.USER_NAME).toString()
        score = intent.getIntExtra(Constants.CORRECT_ANSWERS, 0)
        quizTaken = intent.getStringExtra(Constants.QUIZ_TAKEN).toString()

        // Get the values from the previous intent
        val totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS, 0)

        // Set the textviews according to the user's name and performance
        binding?.tvCongratName?.text = "Congratulations, $username"
        binding?.tvScore?.text = "Your score is $score/$totalQuestions"

        // On click listener for the finish button, which will take them back to the main activity/start page
        binding?.btnHomePage?.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

        binding?.btnQuestionsPage?.setOnClickListener {
            val intent = Intent(this, QuizChoicesActivity::class.java)
            intent.putExtra(Constants.USER_NAME, username)
            startActivity(intent)
            finish()
        }

        val quizDao = (application as RoomApp).db.quizDao()
        addAttemptToDatabase(quizDao)

    }

    private fun addAttemptToDatabase(quizDao: QuizDao) {
        val c = Calendar.getInstance()
        val dateTime = c.time
        val sdf = SimpleDateFormat("dd.MM.yyyy HH:mm", Locale.getDefault())
        val date = sdf.format(dateTime)

        lifecycleScope.launch { quizDao.insert(QuizEntity(username = username,score = "$score/9", date = date, quizTaken = quizTaken)) }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}