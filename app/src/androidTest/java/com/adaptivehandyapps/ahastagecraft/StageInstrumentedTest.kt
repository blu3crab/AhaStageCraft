package com.adaptivehandyapps.ahastagecraft

import android.net.Uri
import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.adaptivehandyapps.ahastagecraft.database.StageDatabase
import com.adaptivehandyapps.ahastagecraft.database.StageDatabaseDao
import com.adaptivehandyapps.ahastagecraft.database.StageKit
import org.junit.After

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before
import java.io.IOException

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class StageInstrumentedTest {

    private lateinit var stageDao: StageDatabaseDao
    private lateinit var db: StageDatabase

    @Before
    fun createDb() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext

        db = Room.inMemoryDatabaseBuilder(context, StageDatabase::class.java)
            .allowMainThreadQueries()
            .build()
        stageDao = db.stageDatabaseDao
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

//    @Test
//    fun useAppContext() {
//        // Context of the app under test.
//        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
//        assertEquals("com.adaptivehandyapps.ahastagecraft", appContext.packageName)
//    }

    @Test
    @Throws(Exception::class)
    fun insertAndGetStage() {
        val stage = StageKit()
        val dummyUriString = "http://dummy.com"
//        stage.imageUri = Uri.parse(dummyUriString)
        stage.imageUriString = dummyUriString
        stageDao.insert(stage)
        val newestStage = stageDao.getNewest()
        assertEquals(newestStage?.imageUriString, dummyUriString)
    }

}
