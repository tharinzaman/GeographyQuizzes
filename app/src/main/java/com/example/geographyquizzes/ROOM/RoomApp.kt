package com.example.geographyquizzes.ROOM

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase

class RoomApp : Application() {

    val db by lazy {
        QuizDatabase.getInstance(this)
    }
}