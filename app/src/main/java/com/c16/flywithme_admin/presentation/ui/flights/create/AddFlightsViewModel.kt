package com.c16.flywithme_admin.presentation.ui.flights.create

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.c16.flywithme_admin.data.remote.ApiConfig
import com.c16.flywithme_admin.data.request.AddFlightsRequest
import com.c16.flywithme_admin.data.response.flights.add.AddFlightsResponse
import com.c16.flywithme_admin.preference.AdminPrefrence

class AddFlightsViewModel : ViewModel() {
    var createNewData: MutableLiveData<AddFlightsResponse> = MutableLiveData()


    fun getCreateNewDataObserver(): MutableLiveData<AddFlightsResponse> {
        return createNewData
    }

    fun createDataFlights(addData: AddFlightsRequest) {
        val retro = ApiConfig.getApiService().addFlight(addData)
        retro.enqueue(object : retrofit2.Callback<AddFlightsResponse> {
            override fun onResponse(
                call: retrofit2.Call<AddFlightsResponse>,
                response: retrofit2.Response<AddFlightsResponse>
            ) {
                if (response.isSuccessful) {
                    createNewData.postValue(response.body())
                } else {
                    createNewData.postValue(null)
                }
            }

            override fun onFailure(call: retrofit2.Call<AddFlightsResponse>, t: Throwable) {
                createNewData.postValue(null)
            }
        })
    }

}