package com.rumeysaozer.notdefteri

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Notlar::class), version = 1, exportSchema = false )
abstract class NotlarDatabase : RoomDatabase(){

    abstract fun getNotDao(): NotDao
    companion object{
        @Volatile
        private var INSTANCE : NotlarDatabase? = null
        fun getDatabase(context: Context): NotlarDatabase{
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    NotlarDatabase::class.java,
                    "notlar_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}