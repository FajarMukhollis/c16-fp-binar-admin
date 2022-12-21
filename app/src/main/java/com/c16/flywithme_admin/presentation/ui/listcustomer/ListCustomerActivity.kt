package com.c16.flywithme_admin.presentation.ui.listcustomer

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.c16.flywithme_admin.data.remote.ApiConfig
import com.c16.flywithme_admin.data.response.CustomerResponse
import com.c16.flywithme_admin.databinding.ActivityListCustomerBinding
import com.c16.flywithme_admin.presentation.adapter.customer.ListCustomerAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListCustomerActivity : AppCompatActivity() {
    private lateinit var _binding: ActivityListCustomerBinding
    private lateinit var listCustomerAdapter: ListCustomerAdapter
    private var TAG: String = "ListCustomerActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityListCustomerBinding.inflate(layoutInflater)
        setContentView(_binding.root)
        supportActionBar!!.title = "List of Customers"

        initRecyclerView()
        getDataFromApi()

    }

    private fun getDataFromApi() {
        showLoading(true)
        val retroInstance = ApiConfig.getApiService()
        val call = retroInstance.getlistCustomer()
        call.enqueue(object : Callback<CustomerResponse> {
            override fun onResponse(
                call: Call<CustomerResponse>,
                response: Response<CustomerResponse>
            ) {
                showLoading(false)
                if (response.isSuccessful) {
                    showData( response.body()!! )
                }
            }

            override fun onFailure(call: Call<CustomerResponse>, t: Throwable) {
                showLoading(false)
            }

        })
    }

    private fun printLog(message: String) {
        Log.d(TAG, message)
    }

    private fun showData(data: CustomerResponse) {
        val results = data.data
        listCustomerAdapter.setData(results)
    }

    private fun initRecyclerView() {
        listCustomerAdapter = ListCustomerAdapter(arrayListOf())
        _binding.recyclerViewCustomer.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            val decoration = DividerItemDecoration(this@ListCustomerActivity, DividerItemDecoration.VERTICAL)
            addItemDecoration(decoration)
            adapter = listCustomerAdapter
        }
    }

    private fun showLoading(loading: Boolean) {
        when(loading) {
            true -> _binding.progressBar.visibility = View.VISIBLE
            false -> _binding.progressBar.visibility = View.GONE
        }
    }


}