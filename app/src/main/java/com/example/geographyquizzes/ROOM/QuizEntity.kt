package com.example.geographyquizzes.ROOM

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.Instant
import java.util.*

@Entity(tableName = "quiz-table")
data class QuizEntity(

    @PrimaryKey
    val id: UUID = UUID.randomUUID(),

    @ColumnInfo(name = "username")
    val username: String,

    @ColumnInfo(name = "quiz_taken")
    val quizTaken: String,

    @ColumnInfo(name = "score_out_of_ten")
    val score: String,

    @ColumnInfo(name = "date")
    val date: String

)
