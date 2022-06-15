package com.example.coroutinesapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.coroutinesapp.viewmodel.MyViewModel
import com.example.coroutinesapp.databinding.ActivityListBinding

class ListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListBinding

    //variavel para o adapter
    private lateinit var listAdapter: com.example.coroutinesapp.adapter.ListAdapter

    //variavel para a viewModel
    private lateinit var viewModel: MyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(MyViewModel::class.java)
        listAdapter = com.example.coroutinesapp.adapter.ListAdapter()
        setUpAdapter()
        onObserve()
    }

    private fun setUpAdapter() {
        binding.apply {
            recyclerViewMyActivity.apply {
                adapter = listAdapter
                layoutManager = LinearLayoutManager(context)
            }
        }
    }

    private fun onObserve() {
        viewModel.getDataFromRepository()
        viewModel.string.observe(this, Observer {
            listAdapter.addNewString(it)
        })
    }
}