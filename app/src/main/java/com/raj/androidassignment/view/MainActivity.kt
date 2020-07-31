package com.raj.androidassignment.view

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.raj.androidassignment.R


class MainActivity : AppCompatActivity() {


    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Load fragment if  savedInstanceState=null
        if (savedInstanceState == null)
            jumpListFragment()

    }

    /**
     * Load News List Fragment
     */
    fun jumpListFragment() {
        var mListFragment = NewsListFragment()
        var mFrgmentManager = supportFragmentManager
        mFrgmentManager.beginTransaction().replace(R.id.frameLayout, mListFragment).commit()
    }

}



