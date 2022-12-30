package com.c16.flywithme_admin.presentation.ui.flights.create

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.ViewModelProvider
import com.c16.flywithme_admin.data.request.AddFlightsRequest
import com.c16.flywithme_admin.databinding.ActivityAddFlightsBinding
import com.c16.flywithme_admin.preference.AdminPrefrence
import com.c16.flywithme_admin.viewmodel.ViewModelFactory

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

class AddFlightsActivity(private var adminPrefrence: AdminPrefrence) : AppCompatActivity() {
    private lateinit var _binding: ActivityAddFlightsBinding
    private lateinit var addFlightsViewModel: AddFlightsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityAddFlightsBinding.inflate(layoutInflater)
        setContentView(_binding.root)

        initViewModel()
        createFlightsObservable()

        _binding.btnAddFlight.setOnClickListener {
            getToken()
            createDataFlights()
        }
    }

    private fun initViewModel() {
        val factory = ViewModelFactory.getInstance(this, dataStore)
        addFlightsViewModel =
            ViewModelProvider(this@AddFlightsActivity, factory)[AddFlightsViewModel::class.java]
    }

    private fun getToken() = adminPrefrence.getToken()

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
            _binding.etTypeofclass.text.toString(),
            _binding.etClassPrice.text.toString()
        )
        addFlightsViewModel.createDataFlights(newDataFlights)


    }

    private fun createFlightsObservable() {
        getToken()
        addFlightsViewModel.getCreateNewDataObserver().observe(this) { result ->
            if (result == null) {
                Toast.makeText(
                    this@AddFlightsActivity,
                    "Failed to create Tiket...",
                    Toast.LENGTH_LONG
                ).show()

            } else {
                Toast.makeText(
                    this@AddFlightsActivity,
                    "Successfully created Tiket...",
                    Toast.LENGTH_LONG
                ).show()
                println("message: ${result?.message}")
                finish()
            }
        }
    }


}