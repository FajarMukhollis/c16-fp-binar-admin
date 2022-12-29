package com.c16.flywithme_admin.presentation.ui.flights.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.c16.flywithme_admin.data.remote.ApiConfig
import com.c16.flywithme_admin.data.response.delete.DeleteFlightsResponse
import com.c16.flywithme_admin.data.response.flights.byid.FlightByIdResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailViewModel : ViewModel() {

    var loadFlightsData: MutableLiveData<FlightByIdResponse?> = MutableLiveData()
    var deleteFlightData: MutableLiveData<DeleteFlightsResponse?> = MutableLiveData()


    fun getLoadFlightsDataObserver(): MutableLiveData<FlightByIdResponse?> {
        return loadFlightsData
    }

    fun getDeleteFlightDataObserver(): MutableLiveData<DeleteFlightsResponse?> {
        return deleteFlightData
    }

    fun getFlightsData(id: Int?) {
        val retro = ApiConfig.getApiService().getFlightsById(id!!)
        retro.enqueue(object : Callback<FlightByIdResponse?> {
            override fun onResponse(
                call: Call<FlightByIdResponse?>, response: Response<FlightByIdResponse?>
            ) {
                if (response.isSuccessful) {
                    loadFlightsData.postValue(response.body())
                } else {
                    loadFlightsData.postValue(null)
                }

            }

            override fun onFailure(call: Call<FlightByIdResponse?>, t: Throwable) {
                loadFlightsData.postValue(null)
            }
        })

    }

    fun deleteFlights(id: Int?) {
        val retro = ApiConfig.getApiService().deleteFlights(id!!)
        retro.enqueue(object : Callback<DeleteFlightsResponse?> {
            override fun onResponse(
                call: Call<DeleteFlightsResponse?>, response: Response<DeleteFlightsResponse?>
            ) {
                if (response.isSuccessful) {
                    deleteFlightData.postValue(response.body())
                } else {
                    deleteFlightData.postValue(null)
                }

            }

            override fun onFailure(call: Call<DeleteFlightsResponse?>, t: Throwable) {
                deleteFlightData.postValue(null)
            }
        })

    }

}