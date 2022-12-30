package com.c16.flywithme_admin.presentation.ui.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.ViewModelProvider
import com.c16.flywithme_admin.databinding.ActivityMainBinding
import com.c16.flywithme_admin.presentation.ui.flights.FlightsActivity
import com.c16.flywithme_admin.presentation.ui.listcustomer.ListCustomerActivity
import com.c16.flywithme_admin.presentation.ui.login.LoginActivity
import com.c16.flywithme_admin.viewmodel.ViewModelFactory


private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

class MainActivity : AppCompatActivity() {

    private lateinit var _binding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(_binding.root)

        setViewModel()

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

        _binding.btnLogout.setOnClickListener {
            val moveLogin = Intent(this, LoginActivity::class.java)
            mainViewModel.signOut()
            startActivity(moveLogin)
        }
    }

    private fun setViewModel() {
        val factory = ViewModelFactory.getInstance(this, dataStore)
        mainViewModel = ViewModelProvider(this, factory)[MainViewModel::class.java]
    }

}