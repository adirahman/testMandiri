package com.arc.testmandiri.api

import com.arc.testmandiri.api.NewsModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {

    @GET("top-headlines?country=id&apiKey=30c368a6b76a4a35b73010fdef953210")
    fun getHeadLines(): Call<NewsModel>

    @GET("top-headlines?country=id&apiKey=30c368a6b76a4a35b73010fdef953210")
    fun getHeadLinesByCategory(@Query("category")cat:String ): Call<NewsModel>
}