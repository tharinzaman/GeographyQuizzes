package com.example.geographyquizzes.ROOM

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [QuizEntity::class], version = 1)
@TypeConverters(UUIDConverter::class)
abstract class QuizDatabase : RoomDatabase() {

    abstract fun quizDao(): QuizDao

    companion object {

        @Volatile
        private var INSTANCE: QuizDatabase? = null

        fun getInstance(context: Context): QuizDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        QuizDatabase::class.java,
                        "quiz_database"
                    ).fallbackToDestructiveMigration().build()

                    INSTANCE = instance
                }
                return instance
            }
        }
    }

}