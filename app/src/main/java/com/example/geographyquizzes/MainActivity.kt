package com.example.quizapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.geographyquizzes.QuizChoicesActivity
import com.example.geographyquizzes.R
import com.example.geographyquizzes.Constants
import com.example.geographyquizzes.HistoryActivity
import com.example.geographyquizzes.databinding.ActivityMainBinding

class MainActivity: AppCompatActivity() {

    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.btnStart?.setOnClickListener {
            if(binding?.etName?.text?.isEmpty() == true) {
                Toast.makeText(this, "Please enter your name", Toast.LENGTH_LONG).show()
            }
            else {
                val intent = Intent(this, QuizChoicesActivity::class.java)
                intent.putExtra(Constants.USER_NAME, binding?.etName?.text.toString())
                startActivity(intent)
                finish()
            }

        }
        binding?.flButtonHistory?.setOnClickListener {
            startActivity(Intent(this, HistoryActivity::class.java))
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}