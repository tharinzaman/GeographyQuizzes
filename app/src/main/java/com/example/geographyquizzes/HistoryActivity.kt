package com.example.geographyquizzes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.geographyquizzes.ROOM.QuizDao
import com.example.geographyquizzes.ROOM.QuizEntity
import com.example.geographyquizzes.ROOM.RoomApp
import com.example.geographyquizzes.databinding.ActivityHistoryBinding
import kotlinx.coroutines.launch

class HistoryActivity : AppCompatActivity() {

    private var binding : ActivityHistoryBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHistoryBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        val dao = (application as RoomApp).db.quizDao()
        getAllCompletedAttempts(dao)
    }

    private fun getAllCompletedAttempts(quizDao: QuizDao) {
        lifecycleScope.launch {
            quizDao.fetchAllTries().collect {
                allCompletedAttemptsList ->
                if (allCompletedAttemptsList.isNotEmpty()){
                    binding?.tvAttempts?.visibility = View.VISIBLE
                    binding?.llHeadings?.visibility = View.VISIBLE
                    binding?.rvHistory?.visibility = View.VISIBLE
                    binding?.tvNoDataAvailable?.visibility = View.INVISIBLE

                    binding?.rvHistory?.layoutManager = LinearLayoutManager(this@HistoryActivity)

                    val attempts = ArrayList<QuizEntity>()
                    for(attempt in allCompletedAttemptsList){
                        attempts.add(attempt)
                    }
                    val attemptsAdapter = AttemptsAdapter(attempts)
                    binding?.rvHistory?.adapter = attemptsAdapter

                } else {
                    binding?.tvAttempts?.visibility = View.GONE
                    binding?.llHeadings?.visibility = View.GONE
                    binding?.rvHistory?.visibility = View.GONE
                    binding?.tvNoDataAvailable?.visibility = View.VISIBLE
                }
            }
        }

    }

    override fun onDestroy() {
        binding = null
        super.onDestroy()
    }


}