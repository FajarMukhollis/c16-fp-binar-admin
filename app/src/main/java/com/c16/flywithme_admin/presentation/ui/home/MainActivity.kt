package com.c16.flywithme_admin.presentation.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.c16.flywithme_admin.databinding.ActivityMainBinding
import com.c16.flywithme_admin.presentation.ui.listcustomer.ListCustomerActivity

class MainActivity : AppCompatActivity() {

    private lateinit var _binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(_binding.root)

        _binding.btnDataCustomer.setOnClickListener {
            val intent = Intent(this, ListCustomerActivity::class.java)
            startActivity(intent)
        }

        _binding.btnDataFlight.setOnClickListener {

        }

        _binding.btnHistoryPayment.setOnClickListener {

        }
    }
}