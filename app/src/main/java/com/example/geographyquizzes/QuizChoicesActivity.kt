package com.example.geographyquizzes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.geographyquizzes.databinding.ActivityQuizChoicesBinding

class QuizChoicesActivity : AppCompatActivity() {

    private var binding: ActivityQuizChoicesBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizChoicesBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        val userName = intent.getStringExtra(Constants.USER_NAME)

        binding?.tvQuestion?.text = "$userName, which quiz would you like to take?"

        binding?.btnFlagQuiz?.setOnClickListener {
            val intent = Intent(this, FlagQuiz::class.java)
            intent.putExtra(Constants.USER_NAME, userName)
            startActivity(intent)
        }
        binding?.btnCapitalCitiesQuiz?.setOnClickListener {
            val intent = Intent(this, CapitalCitiesQuiz::class.java)
            intent.putExtra(Constants.USER_NAME, userName)
            startActivity(intent)
        }
        binding?.btnCountryOutlineQuiz?.setOnClickListener {
            val intent = Intent(this, CountryOutlineQuiz::class.java)
            intent.putExtra(Constants.USER_NAME, userName)
            startActivity(intent)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}