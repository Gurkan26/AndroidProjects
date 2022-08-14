package com.example.retrofitdeneme.api

import com.example.retrofitdeneme.ServiceConstans.Companion.BASE_URL
import com.example.retrofitdeneme.WebService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private val retrofit by lazy{

        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val api: WebService by lazy {
        retrofit.create(WebService::class.java)
    }
}