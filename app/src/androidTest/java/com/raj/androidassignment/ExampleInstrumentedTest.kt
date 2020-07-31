package com.raj.androidassignment

import android.util.Log
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.mythio.retrofitsample.network.CanadaDataApi
import com.raj.androidassignment.model.NewsModel

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import retrofit2.Call
import java.io.IOException

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.raj.androidassignment", appContext.packageName)
    }


    @Test
    @Throws(IOException::class)
    fun testTitle() {
        val call: Call<NewsModel> = CanadaDataApi.retrofitService.getUserData()

        val response = call.execute()
        val resultat = response.body()
        Log.i("RETROFIT", (resultat as NewsModel).title)
        assertEquals("About Canada", (resultat as NewsModel).title)
    }

    @Test
    @Throws(IOException::class)
    fun testRowCount() {
        val call: Call<NewsModel> = CanadaDataApi.retrofitService.getUserData()
        val response = call.execute()
        val resultat = response.body()
        Log.i("RETROFIT", (resultat as NewsModel).title)
        assertEquals(14, (resultat as NewsModel).rows?.size)
    }
}