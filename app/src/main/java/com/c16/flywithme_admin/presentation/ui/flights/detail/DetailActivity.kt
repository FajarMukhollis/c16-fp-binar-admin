package com.c16.flywithme_admin.presentation.ui.flights.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.ViewModelProvider
import com.c16.flywithme_admin.data.response.flights.delete.DeleteFlightsResponse
import com.c16.flywithme_admin.databinding.ActivityDetailBinding
import com.c16.flywithme_admin.presentation.ui.flights.update.UpdateFlightsActivity
import com.c16.flywithme_admin.viewmodel.ViewModelFactory

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

class DetailActivity : AppCompatActivity() {

    private lateinit var _binding : ActivityDetailBinding
    private lateinit var detailViewModel: DetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(_binding.root)

        val flight_id = intent.getIntExtra("id", 0)

        initViewModel()
        if(flight_id != null){
            loadFlightsData(flight_id)
        }

        val token = detailViewModel.getToken()


        _binding.btnDelete.setOnClickListener {
            deleteFlight(flight_id)
        }

        _binding.btnUpdate.setOnClickListener {
            val moveUpdate = Intent(this, UpdateFlightsActivity::class.java)
            intent.putExtra("id", flight_id)
            startActivity(moveUpdate)
        }
    }

    private fun initViewModel() {
        showLoading(false)
        val factory = ViewModelFactory.getInstance(this, dataStore)
        detailViewModel = ViewModelProvider(this, factory)[DetailViewModel::class.java]
    }

    private fun deleteFlight(flightId: Int) {
        detailViewModel.getDeleteFlightDataObserver().observe(this) {
            if(it != null){
                DeleteFlightsResponse(it.message, it.status)
                Toast.makeText(this@DetailActivity, "Successfully deleted user...", Toast.LENGTH_LONG).show()
                finish()
            } else {
                Toast.makeText(this@DetailActivity, "Failed deleted Ticket", Toast.LENGTH_LONG).show()
            }

        }
        detailViewModel.deleteFlights(flightId)

    }

    private fun loadFlightsData(id: Int) {
        detailViewModel.getLoadFlightsDataObserver().observe(this) {
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
                _binding.tvTypeOfClass.setText(it.data?.typeOfClass.toString())
                _binding.tvClassPrice.setText(it.data?.classPrice.toString())
                _binding.tvTypeOfFlight.setText(it.data?.typeOfFlight)
            }
        }
        detailViewModel.getFlightsData(id)
    }

    private fun showLoading(loading: Boolean) {
        when(loading) {
            true -> _binding.progressBar.visibility = View.VISIBLE
            false -> _binding.progressBar.visibility = View.GONE
        }
    }

}