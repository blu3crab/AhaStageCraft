//
// Created by MAT on 2/19/2020.
//
package com.adaptivehandyapps.ahastagecraft.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [StageKit::class], version = 1, exportSchema = false)
abstract class StageDatabase: RoomDatabase() {

    abstract val stageDatabaseDao: StageDatabaseDao

    companion object{

        @Volatile
        private var INSTANCE: StageDatabase? = null

        fun getInstance(context: Context): StageDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        StageDatabase::class.java,
                        "stage_kit_database")
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }

}

