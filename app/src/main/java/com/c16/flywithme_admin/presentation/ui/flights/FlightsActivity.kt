package com.c16.flywithme_admin.presentation.ui.flights

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.c16.flywithme_admin.data.response.flights.FlightsResponse
import com.c16.flywithme_admin.databinding.ActivityFlightsBinding
import com.c16.flywithme_admin.presentation.adapter.flights.FlightsAdapter

class FlightsActivity : AppCompatActivity() {

    lateinit var flightsAdapter: FlightsAdapter
    lateinit var flightsViewModel: FlightsViewModel
    private lateinit var _binding: ActivityFlightsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityFlightsBinding.inflate(layoutInflater)
        setContentView(_binding.root)
        supportActionBar!!.title = "List of Flights"

        initRecyclerViewFlights()
        initViewModel()
    }

    private fun initRecyclerViewFlights() {
        _binding.recyclerViewFlights.apply {
            layoutManager = LinearLayoutManager(this@FlightsActivity)
            addItemDecoration(
                DividerItemDecoration(
                    this@FlightsActivity,
                    DividerItemDecoration.VERTICAL
                )
            )
            flightsAdapter = FlightsAdapter()
            adapter = flightsAdapter
        }
    }

    fun initViewModel() {
        showLoading(true)
        flightsViewModel = ViewModelProvider(this).get(FlightsViewModel::class.java)
        flightsViewModel.getFlightsObserver().observe(this, Observer<FlightsResponse> {

            if (it != null) {
                showLoading(false)
                flightsAdapter.flightList = it.data.toMutableList()
                flightsAdapter.notifyDataSetChanged()

            } else {
                showLoading(false)
                Toast.makeText(this@FlightsActivity, "no result found...", Toast.LENGTH_LONG).show()
            }
        })
        flightsViewModel.getFlights()
    }

    private fun showLoading(loading: Boolean) {
        when(loading) {
            true -> _binding.progressBar.visibility = View.VISIBLE
            false -> _binding.progressBar.visibility = View.GONE
        }
    }

}