package com.c16.flywithme_admin.presentation.ui.flights.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.c16.flywithme_admin.data.remote.ApiConfig
import com.c16.flywithme_admin.data.response.flights.byid.FlightByIdResponse
import com.c16.flywithme_admin.data.response.flights.delete.DeleteFlightsResponse
import com.c16.flywithme_admin.preference.AdminPrefrence
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailViewModel(private val adminPreference: AdminPrefrence) : ViewModel() {

    var loadFlightsData: MutableLiveData<FlightByIdResponse?> = MutableLiveData()
    var deleteFlightData: MutableLiveData<DeleteFlightsResponse?> = MutableLiveData()


    fun getLoadFlightsDataObserver(): MutableLiveData<FlightByIdResponse?> {
        return loadFlightsData
    }

    fun getDeleteFlightDataObserver(): MutableLiveData<DeleteFlightsResponse?> {
        return deleteFlightData
    }

    fun getToken() = adminPreference.getToken().asLiveData()


    fun deleteFlights(id: Int?) {
        val tokenAuth = adminPreference.getToken().asLiveData().value.toString()
        val retro = ApiConfig.getApiService().deleteFlights(id!!, "Bearer $tokenAuth")
        retro.enqueue(object : Callback<DeleteFlightsResponse?> {
            override fun onResponse(
                call: Call<DeleteFlightsResponse?>, response: Response<DeleteFlightsResponse?>
            ) {
                if (response.isSuccessful) {
                    deleteFlightData.postValue(response.body() )
                } else {
                    deleteFlightData.postValue(response.body())
                }
            }
            override fun onFailure(call: Call<DeleteFlightsResponse?>, t: Throwable) {
                deleteFlightData.postValue(null)
            }
        })

    }

    fun getFlightsData(id: Int?) {
        val retro = ApiConfig.getApiService().getFlightsById(id!!)
        retro.enqueue(object : Callback<FlightByIdResponse> {
            override fun onResponse(
                call: Call<FlightByIdResponse>, response: Response<FlightByIdResponse>
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



}