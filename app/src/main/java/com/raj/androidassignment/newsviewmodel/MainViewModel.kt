package com.raj.androidassignment.newsviewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mythio.retrofitsample.network.CanadaDataApi
import com.raj.androidassignment.model.NewsModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {

    private var mCanadaData = MutableLiveData<NewsModel>()
    val userData: LiveData<NewsModel>
        get() = mCanadaData

    init {
        mCanadaData.value = null
    }

    /**
     * Call for json data and update LiveData object
     */
    fun getUserData() {
        val api = CanadaDataApi.retrofitService.getUserData()

        api.enqueue(object : Callback<NewsModel> {

           override fun onResponse(call: Call<NewsModel>, response: Response<NewsModel>) {
               // Update live data object
                mCanadaData.value = response.body()
            }

            override fun onFailure(call: Call<NewsModel>, t: Throwable) {

                mCanadaData.value=NewsModel()
            }
        })
    }
}