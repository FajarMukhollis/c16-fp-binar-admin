package com.c16.flywithme_admin.presentation.ui.flights.update

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.ViewModelProvider
import com.c16.flywithme_admin.data.request.UpdateFlightsResquest
import com.c16.flywithme_admin.databinding.ActivityUpdateFlightsBinding
import com.c16.flywithme_admin.viewmodel.ViewModelFactory

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

class UpdateFlightsActivity : AppCompatActivity() {
    private lateinit var _binding: ActivityUpdateFlightsBinding
    private lateinit var updateViewModel: UpdateViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityUpdateFlightsBinding.inflate(layoutInflater)
        setContentView(_binding.root)

        val flight_id = intent.getIntExtra("id", 0)

        initViewModel()
        _binding.btnUpdate.setOnClickListener {

        }
    }

    private fun updateFlights(flight_id : String?) {
        val updateData = UpdateFlightsResquest(
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
//        updateViewModel.updateFlights(updateData, flight_id)
    }

    private fun initViewModel() {
        val factory = ViewModelFactory.getInstance(this, dataStore)
        updateViewModel = ViewModelProvider(this, factory)[UpdateViewModel::class.java]
    }
}