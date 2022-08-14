package com.example.retrofitdeneme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ObjectGVeriGetir()
    }

    fun ObjectGVeriGetir() {
        val retrofit = Retrofit.Builder()
            .baseUrl(ServiceConstans.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val cagri = retrofit.create(WebService::class.java).getPost()
        cagri.enqueue(object : Callback<Kisi>{
            override fun onResponse(call: Call<Kisi>, response: Response<Kisi>) {
                if (response.isSuccessful){
                    response.body()?.let {
                        Log.d(it.toString(),"sonuc: ")
                    }
                }
            }

            override fun onFailure(call: Call<Kisi>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })


    }
}