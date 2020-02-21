//
// Created by MAT on 2/19/2020.
//
package com.adaptivehandyapps.ahastagecraft.database

import android.net.Uri
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "stage_kit_table")
data class StageKit(
    @PrimaryKey(autoGenerate = true)
    var stageKitId: Long = 0L,

    @ColumnInfo(name = "create_time_milli")
    val createTimeMilli: Long = System.currentTimeMillis(),
    @ColumnInfo(name = "image_uri")
    var imageUriString: String? = null
)