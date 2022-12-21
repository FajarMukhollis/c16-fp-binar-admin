package com.c16.flywithme_admin.presentation.ui.listcustomer

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.c16.flywithme_admin.data.remote.ApiConfig
import com.c16.flywithme_admin.data.response.CustomerResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListCustomerViewModel : ViewModel() {

    var recyclerListCustomer: MutableLiveData<CustomerResponse> = MutableLiveData()


    fun getListCustomerObserverable(): MutableLiveData<CustomerResponse> {
        return recyclerListCustomer
    }

    fun getListCustomer() {
        val retroInstance = ApiConfig.getApiService()
        val call = retroInstance.getlistCustomer()
        call.enqueue(object : Callback<CustomerResponse> {
            override fun onResponse(
                call: Call<CustomerResponse>,
                response: Response<CustomerResponse>
            ) {
                if (response.isSuccessful) {
                    recyclerListCustomer.postValue(response.body())
                } else {
                    recyclerListCustomer.value = null
                }

            }

            override fun onFailure(call: Call<CustomerResponse>, t: Throwable) {
                recyclerListCustomer.postValue(null)
            }

        })
    }
}