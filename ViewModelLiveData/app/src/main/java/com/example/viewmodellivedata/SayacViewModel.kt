package com.example.viewmodellivedata

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SayacViewModel:ViewModel() {

    var sayac = 0

    val dinlenenVeri: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }

    fun sayaciArtir(){
        sayac++
        dinlenenVeri.value = sayac
    }

}


