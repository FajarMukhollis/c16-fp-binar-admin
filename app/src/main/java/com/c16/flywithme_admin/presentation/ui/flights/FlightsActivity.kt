package com.c16.flywithme_admin.presentation.ui.flights

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.c16.flywithme_admin.data.model.flights.DataFlights
import com.c16.flywithme_admin.databinding.ActivityFlightsBinding
import com.c16.flywithme_admin.presentation.adapter.flights.FlightsAdapter
import com.c16.flywithme_admin.presentation.ui.flights.create.AddFlightsActivity
import com.c16.flywithme_admin.presentation.ui.flights.detail.DetailActivity

class FlightsActivity : AppCompatActivity(), FlightsAdapter.OnItemClickListener {

    private lateinit var flightsAdapter: FlightsAdapter
    private lateinit var flightsViewModel: FlightsViewModel
    private lateinit var _binding: ActivityFlightsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityFlightsBinding.inflate(layoutInflater)
        setContentView(_binding.root)
        supportActionBar!!.title = "List of Flights"

        initRecyclerViewFlights()
        initViewModel()
        floatingButtonAdd()
    }

    private fun initRecyclerViewFlights() {
        _binding.recyclerViewFlights.apply {
            layoutManager = LinearLayoutManager(this@FlightsActivity)
            val decoration = DividerItemDecoration(this@FlightsActivity, DividerItemDecoration.VERTICAL)
            addItemDecoration(decoration)
            flightsAdapter = FlightsAdapter(this@FlightsActivity)
            adapter = flightsAdapter
        }
    }

    private fun initViewModel() {
        showLoading(true)
        flightsViewModel = ViewModelProvider(this).get(FlightsViewModel::class.java)
        flightsViewModel.getFlightsObserver().observe(this) {
            if (it != null) {
                showLoading(false)
                flightsAdapter.flightList = it.data.toMutableList()
                flightsAdapter.notifyDataSetChanged()

            } else {
                showLoading(false)
                Toast.makeText(this@FlightsActivity, "no result found...", Toast.LENGTH_LONG).show()
            }
        }
        flightsViewModel.getFlights()
    }

    private fun showLoading(loading: Boolean) {
        when(loading) {
            true -> _binding.progressBar.visibility = View.VISIBLE
            false -> _binding.progressBar.visibility = View.GONE
        }
    }

    private fun floatingButtonAdd(){
        val btnAdd = _binding.btnAdd
        btnAdd.setOnClickListener {
            val intent = Intent(this, AddFlightsActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onItemDetailCLick(flight: DataFlights) {
        val intent = Intent(this@FlightsActivity, DetailActivity::class.java)
        intent.putExtra("id", flight.id)
        startActivity(intent)
    }

}