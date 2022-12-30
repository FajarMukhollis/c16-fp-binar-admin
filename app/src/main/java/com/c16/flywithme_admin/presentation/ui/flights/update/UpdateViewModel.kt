package com.c16.flywithme_admin.presentation.ui.flights.update

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.c16.flywithme_admin.data.remote.ApiConfig
import com.c16.flywithme_admin.data.request.UpdateFlightsResquest
import com.c16.flywithme_admin.data.response.flights.update.UpdateFlightsResponse
import com.c16.flywithme_admin.preference.AdminPrefrence

class UpdateViewModel(private val adminPref: AdminPrefrence):ViewModel() {

    fun getToken() = adminPref.getToken().asLiveData()

    fun updateFlights(reqBody: UpdateFlightsResquest, id: Int) {
        val retro = ApiConfig.getApiService().updateFlights(id, reqBody)
        retro.enqueue(object : retrofit2.Callback<UpdateFlightsResponse> {
            override fun onResponse(
                call: retrofit2.Call<UpdateFlightsResponse>,
                response: retrofit2.Response<UpdateFlightsResponse>
            ) {
                if (response.isSuccessful) {
                    val res = response.body()
                    Log.d("Flight", "Update : ${res?.status}")
                    Log.d("Flight", "Update : ${res?.message}")
                } else {
                    val res = response.body()
                    Log.d("Flight", "Update : ${res?.status}")
                    Log.d("Flight", "Update : ${res?.message}")
                }
            }

            override fun onFailure(call: retrofit2.Call<UpdateFlightsResponse>, t: Throwable) {
                println("Update Failed")
            }
        })

    }
}