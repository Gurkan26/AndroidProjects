package com.example.navigationexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.navigationexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bnView = binding.bottomNavigationView
        val navController = findNavController(R.id.fragment)
        val appBarConfiguration= AppBarConfiguration(setOf(R.id.firstFragment,R.id.secondFragment,R.id.thirtFragment))
        setupActionBarWithNavController(navController,appBarConfiguration)

        bnView.setupWithNavController(navController)

    }
}