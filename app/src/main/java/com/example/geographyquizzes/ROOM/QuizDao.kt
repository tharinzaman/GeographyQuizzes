package com.example.geographyquizzes.ROOM

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface QuizDao {

    @Insert
    suspend fun insert(quizEntity: QuizEntity)

    @Query("SELECT * FROM `quiz-table`")
    fun fetchAllTries(): Flow<List<QuizEntity>>


}