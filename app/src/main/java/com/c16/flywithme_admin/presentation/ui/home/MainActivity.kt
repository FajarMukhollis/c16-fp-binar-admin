package com.c16.flywithme_admin.presentation.ui.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.c16.flywithme_admin.databinding.ActivityMainBinding
import com.c16.flywithme_admin.presentation.ui.flights.FlightsActivity
import com.c16.flywithme_admin.presentation.ui.listcustomer.ListCustomerActivity
import com.c16.flywithme_admin.presentation.ui.profile.ProfileActivity


private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

class MainActivity : AppCompatActivity() {

    private lateinit var _binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(_binding.root)

        _binding.btnDataCustomer.setOnClickListener {
            val moveListCustomer = Intent(this, ListCustomerActivity::class.java)
            startActivity(moveListCustomer)
        }


        _binding.btnDataFlight.setOnClickListener {
            val moveListFlight = Intent(this, FlightsActivity::class.java)
            startActivity(moveListFlight)
        }

        _binding.btnHistoryPayment.setOnClickListener {

        }

        _binding.btnProfile.setOnClickListener {
            val moveProfile = Intent(this, ProfileActivity::class.java)
            startActivity(moveProfile)
        }
    }
}