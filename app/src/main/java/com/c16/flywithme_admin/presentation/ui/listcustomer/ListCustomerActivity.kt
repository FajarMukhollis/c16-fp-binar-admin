package com.c16.flywithme_admin.presentation.ui.listcustomer

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.c16.flywithme_admin.data.response.CustomerResponse
import com.c16.flywithme_admin.databinding.ActivityListCustomerBinding
import com.c16.flywithme_admin.presentation.adapter.customer.ListCustomerAdapter

class ListCustomerActivity : AppCompatActivity() {
    private lateinit var _binding: ActivityListCustomerBinding
    private lateinit var recyclerViewAdapter : ListCustomerAdapter
    private lateinit var viewModel: ListCustomerViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityListCustomerBinding.inflate(layoutInflater)
        setContentView(_binding.root)

        initRecyclerView()
        initViewModel()

    }

    private fun initRecyclerView(){
        _binding.recyclerViewCustomer.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            val decoration = DividerItemDecoration(this@ListCustomerActivity, DividerItemDecoration.VERTICAL)
            addItemDecoration(decoration)
            recyclerViewAdapter = ListCustomerAdapter()
            adapter = recyclerViewAdapter

        }
    }
    fun initViewModel() {
        viewModel = ViewModelProvider(this).get(ListCustomerViewModel::class.java)
        viewModel.getListCustomerObserverable().observe(this, Observer<CustomerResponse> {
            if(it == null) {
                Toast.makeText(this@ListCustomerActivity, "no result found...", Toast.LENGTH_LONG).show()
            } else {
                recyclerViewAdapter.listCustomer = it.data.toMutableList()
                recyclerViewAdapter.notifyDataSetChanged()
            }
        })
        viewModel.getListCustomer()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        if(requestCode == 200) {
            viewModel.getListCustomer()
        }
        super.onActivityResult(requestCode, resultCode, data)
    }


}