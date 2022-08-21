package com.example.viewmodellivedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.viewmodellivedata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: SayacViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[SayacViewModel::class.java]
        viewModel.dinlenenVeri.observe(this, Observer {
            binding.tvSayac.text = it.toString()
        })
        binding.btnAdd.setOnClickListener{
            viewModel.sayaciArtir()
        }
    }

}
