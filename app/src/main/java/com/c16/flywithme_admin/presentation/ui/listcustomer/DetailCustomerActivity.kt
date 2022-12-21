package com.c16.flywithme_admin.presentation.ui.listcustomer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.c16.flywithme_admin.databinding.ActivityListCustomerBinding

class DetailCustomerActivity : AppCompatActivity() {

    private lateinit var _binding: ActivityListCustomerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityListCustomerBinding.inflate(layoutInflater)
        setContentView(_binding.root)
    }
}