package com.c16.flywithme_admin.presentation.ui.flights

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.c16.flywithme_admin.data.remote.ApiConfig
import com.c16.flywithme_admin.data.response.flights.FlightsResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FlightsViewModel : ViewModel() {

    var listFlights: MutableLiveData<FlightsResponse?> = MutableLiveData()

    fun getFlightsObserver(): MutableLiveData<FlightsResponse?> {
        return listFlights
    }

    fun getFlights(){
        val retro = ApiConfig.getApiService().getlistFlight()
        retro.enqueue(object: Callback<FlightsResponse>{
            override fun onResponse(
                call: Call<FlightsResponse>,
                response: Response<FlightsResponse>
            ) {
                if (response.isSuccessful){
                    listFlights.postValue(response.body())
                } else {
                    listFlights.postValue(null)
                }
            }

            override fun onFailure(call: Call<FlightsResponse>, t: Throwable) {
                listFlights.postValue(null)
            }
        })
    }

}