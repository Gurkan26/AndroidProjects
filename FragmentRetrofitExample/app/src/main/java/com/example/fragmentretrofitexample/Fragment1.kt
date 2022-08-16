package com.example.fragmentretrofitexample

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.fragmentretrofitexample.databinding.Fragment1Binding
import retrofit2.HttpException
import java.io.IOException

const val TAG = "Fragment1"

class Fragment1 : Fragment(R.layout.fragment1) {
    private lateinit var binding: Fragment1Binding
    private lateinit var todoAdapter: TodoAdapter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = Fragment1Binding.inflate(inflater, container, false)
        setupRecyclerView()
        lifecycleScope.launchWhenCreated() {

            val response = try {
                RetrofitInstance.api.getTodos()
            } catch (e: IOException) {
                Log.e(TAG, "IOException, you might not have internet con")


                return@launchWhenCreated
            } catch (e: HttpException) {
                Log.e(TAG, "HTTPEXCEPTİON, unexpected response")


                return@launchWhenCreated
            }
            if (response.isSuccessful && response.body() != null) {
                todoAdapter.todos = response.body()!!
                todoAdapter.notifyDataSetChanged()
            } else {
                Log.e(TAG, "Response not successful")
            }

        }

        return binding.root
    }

    private fun setupRecyclerView() = binding.rvTodos.apply {
        todoAdapter = TodoAdapter()
        adapter = todoAdapter
        layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
    }



}