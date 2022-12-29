package com.c16.flywithme_admin.presentation.ui.flights.create

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.c16.flywithme_admin.data.request.AddFlightsRequest
import com.c16.flywithme_admin.data.response.flights.add.AddFlightsResponse
import com.c16.flywithme_admin.databinding.ActivityAddFlightsBinding

class AddFlightsActivity : AppCompatActivity() {
    private lateinit var _binding: ActivityAddFlightsBinding
    private lateinit var addFlightsViewModel: AddFlightsViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityAddFlightsBinding.inflate(layoutInflater)
        setContentView(_binding.root)

        initViewModel()
        createFlightsObservable()

        _binding.btnAddFlight.setOnClickListener {
            createDataFlights()
        }
    }

    private fun initViewModel() {
        addFlightsViewModel = ViewModelProvider(this@AddFlightsActivity).get(AddFlightsViewModel::class.java)
    }


    private fun createDataFlights() {
        val newDataFlights = AddFlightsRequest(
            _binding.etAddairPortId.text.toString(),
            _binding.etAddDestinationId.text.toString(),
            _binding.etAddFlightNumber.text.toString(),
            _binding.etAddAirLine.text.toString(),
            _binding.etFrom.text.toString(),
            _binding.etTo.text.toString(),
            _binding.etDepatureDate.text.toString(),
            _binding.etDepatureTime.text.toString(),
            _binding.etArrivalDate.text.toString(),
            _binding.etArrivalTime.text.toString(),
            _binding.etAddcapasity.text.toString(),
            _binding.etPriceEconomy.text.toString(),
            _binding.etPriceBusiness.text.toString(),
            _binding.etPriceFirst.text.toString(),
            _binding.etTypeOfFlight.text.toString()
        )

        addFlightsViewModel.createDataFlights(newDataFlights)
    }

    private fun createFlightsObservable() {
        addFlightsViewModel.getCreateNewDataObserver().observe(this, Observer <AddFlightsResponse?>{
            if(it == null) {
                Toast.makeText(this@AddFlightsActivity, "Failed to create Tiket...", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this@AddFlightsActivity, "Successfully created Tiket...", Toast.LENGTH_LONG).show()
                finish()
            }
        })
    }

}