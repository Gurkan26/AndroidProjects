package com.example.fragmentretrofitexample

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager

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
            binding.progressBar.isVisible = true
            val response = try {
                RetrofitInstance.api.getTodos()
            } catch (e: IOException) {
                Log.e(TAG, "IOException, you might not have internet con")
                binding.progressBar.isVisible = false

                return@launchWhenCreated
            } catch (e: HttpException) {
                Log.e(TAG, "HTTPEXCEPTİON, unexpected response")
                binding.progressBar.isVisible = false

                return@launchWhenCreated
            }
            if (response.isSuccessful && response.body() != null) {
                todoAdapter.todos = response.body()!!
            } else {
                Log.e(TAG, "Response not successful")
            }
            binding.progressBar.isVisible = false
        }
        return inflater.inflate(R.layout.fragment1, container, false)
    }

    private fun setupRecyclerView() = binding.rvTodos.apply {
        todoAdapter = TodoAdapter()
        adapter = todoAdapter
        layoutManager = LinearLayoutManager(requireContext())
    }


}