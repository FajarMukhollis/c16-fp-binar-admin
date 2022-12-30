package com.c16.flywithme_admin.presentation.ui.flights.detail

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.c16.flywithme_admin.data.response.delete.DeleteFlightsResponse
import com.c16.flywithme_admin.data.response.flights.byid.FlightByIdResponse
import com.c16.flywithme_admin.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var _binding : ActivityDetailBinding
    private lateinit var detailViewModel: DetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(_binding.root)

        val flight_id = intent.getIntExtra("id", 0)
        val getToken = intent.getStringExtra("token")

        initViewModel()
        if(flight_id != null){
            loadFlightsData(flight_id)
        }

        _binding.btnDelete.setOnClickListener{
            if (getToken != null) {
                deleteFlight(flight_id, getToken)
            }
        }
    }

    private fun deleteFlight(flightId: Int, token: String) {
        detailViewModel.getDeleteFlightDataObserver().observe(this, Observer<DeleteFlightsResponse?> {
            if(it != null){
                DeleteFlightsResponse(it.message, it.status)
                Toast.makeText(this@DetailActivity, "Successfully deleted user...", Toast.LENGTH_LONG).show()
                finish()
            } else {
                Toast.makeText(this@DetailActivity, "Failed to delete user...", Toast.LENGTH_LONG).show()
            }
        })
        detailViewModel.deleteFlights(flightId, token)

    }

    private fun loadFlightsData(id: Int) {
        detailViewModel.getLoadFlightsDataObserver().observe(this, Observer <FlightByIdResponse?>{
            if(it != null) {
                _binding.tvIdFlights.setText(it.data?.id.toString())
                _binding.tvAirPortId.setText(it.data?.airPortId.toString())
                _binding.tvDestinationId.setText(it.data?.destinationId.toString())
                _binding.tvFlightNumber.setText(it.data?.flightNumber)
                _binding.tvAirLine.setText(it.data?.airLine)
                _binding.tvFrom.setText(it.data?.from)
                _binding.tvTo.setText(it.data?.to)
                _binding.tvDepatureDate.setText(it.data?.depatureDate)
                _binding.tvDepatureTime.setText(it.data?.depatureTime)
                _binding.tvArrivalDate.setText(it.data?.arrivalDate)
                _binding.tvArrivalTime.setText(it.data?.arrivalTime)
                _binding.tvCapasity.setText(it.data?.capasity.toString())
                _binding.tvEconomyPrice.setText(it.data?.classPrice.toString())
                _binding.tvBussinessPrice.setText(it.data?.classPrice.toString())
                _binding.tvFirstPrice.setText(it.data?.classPrice.toString())
                _binding.tvTypeOfFlight.setText(it.data?.typeOfFlight)
            }
        })
        detailViewModel.getFlightsData(id)
    }

    private fun initViewModel(){
        showLoading(false)
        detailViewModel = ViewModelProvider(this)[DetailViewModel::class.java]
    }

    private fun showLoading(loading: Boolean) {
        when(loading) {
            true -> _binding.progressBar.visibility = View.VISIBLE
            false -> _binding.progressBar.visibility = View.GONE
        }
    }

}