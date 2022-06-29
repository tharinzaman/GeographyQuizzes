package com.example.geographyquizzes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.geographyquizzes.ROOM.QuizEntity
import com.example.geographyquizzes.databinding.ItemAttemptsRowBinding

class AttemptsAdapter(private val items: ArrayList<QuizEntity>) : RecyclerView.Adapter<AttemptsAdapter.ViewHolder>(){

    class ViewHolder(binding: ItemAttemptsRowBinding) : RecyclerView.ViewHolder(binding.root){
        val tvDate = binding.tvDate
        val tvUsername = binding.tvUsername
        val tvScore = binding.tvScore
        val tvQuizTaken = binding.tvQuizTaken
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemAttemptsRowBinding.inflate(LayoutInflater.from(parent.context)
            , parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvDate.text = items[position].date
        holder.tvUsername.text = items[position].username
        holder.tvScore.text = items[position].score
        holder.tvQuizTaken.text = items[position].quizTaken
    }

    override fun getItemCount(): Int {
        return items.size
    }
}
