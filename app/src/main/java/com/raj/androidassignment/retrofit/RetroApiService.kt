package com.mythio.retrofitsample.network


import com.raj.androidassignment.model.NewsModel
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://dl.dropboxusercontent.com/"
private const val PATH_PREFIX = "s/2iodh4vg0eortkl/facts.json"

/// Create Retrofit builder object
private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

/// Interface for GET POST Call
interface CanadaDataApiService {
    @GET(PATH_PREFIX)
    fun getUserData():
            Call<NewsModel>
}

/// Interface for Retrofit Object
object CanadaDataApi {
    val retrofitService: CanadaDataApiService by lazy {
        retrofit.create(CanadaDataApiService::class.java)
    }
}