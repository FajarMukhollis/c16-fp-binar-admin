package com.c16.flywithme_admin.presentation.listcustomer

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.c16.flywithme_admin.data.remote.ApiConfig
import com.c16.flywithme_admin.data.request.CustomerRequest
import com.c16.flywithme_admin.data.response.CustomerResponse
import com.c16.flywithme_admin.databinding.ActivityListCustomerBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListCustomerActivity : AppCompatActivity() {
    private lateinit var _binding: ActivityListCustomerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityListCustomerBinding.inflate(layoutInflater)
        setContentView(_binding.root)
    }

    private suspend fun getListUser(){
        val req = CustomerRequest(
            id = 0,
            email = "",
            password = "",
            firstName = "",
            lastName = "",
            nik = 0,
            address = "",
            phoneNumber = "",
            image = "",
            dateOfBirth = "",
            gender = "",
            roleId = ""
        )

        val retro = ApiConfig.getApiService()
        retro.listCustomer(req).enqueue(object : Callback<List<CustomerResponse>>{
            override fun onResponse(
                call: Call<List<CustomerResponse>>,
                response: Response<List<CustomerResponse>>
            ) {

            }

            override fun onFailure(call: Call<List<CustomerResponse>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }

}