//
// Created by MAT on 2/19/2020.
//
package com.adaptivehandyapps.ahastagecraft.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface StageDatabaseDao {

    @Insert
    fun insert(stageKit: StageKit)
    @Update
    fun update(stageKit: StageKit)

    // select all
    @Query ("SELECT * from stage_kit_table WHERE stageKitId = :key")
    fun get(key: Long): StageKit?

    @Query("DELETE FROM stage_kit_table")
    fun clear()

    @Query("SELECT * FROM stage_kit_table ORDER BY stageKitId DESC LIMIT 1")
    fun getNewest(): StageKit?

    @Query("SELECT * FROM stage_kit_table ORDER BY stageKitId DESC")
    fun getAll(): LiveData<List<StageKit>>
}