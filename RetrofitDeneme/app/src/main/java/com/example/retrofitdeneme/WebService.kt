package com.example.retrofitdeneme

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST

interface WebService {

    //Kaç servis çağıracaksak o kadar metot yazmamız gerekiyor.

    @GET(ServiceConstans.ObjectURL)
    fun getPost(): Call<Kisi>


}