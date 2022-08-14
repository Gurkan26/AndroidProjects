package com.example.okhttpdeneme

import android.os.AsyncTask
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.IOException

class WebServis(val sonucFonk:(sonucStr: String?)->Unit): AsyncTask<Request,Void,String>() {

    override fun doInBackground(vararg p0: Request?): String? {

        try {

            val request=p0.get(0)
            val okHttpClient=OkHttpClient()
            val response=okHttpClient.newCall(request!!).execute()
            if (response!=null && response.isSuccessful){
                return response.body!!.string()
            }

        }
        catch (e:IOException){

        }

        return null
    }

    override fun onPostExecute(result: String?) {
        super.onPostExecute(result)
        sonucFonk(result)
    }

}