package com.c16.flywithme_admin.presentation.ui.start

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowManager
import com.c16.flywithme_admin.databinding.ActivitySplashScreenBinding
import com.c16.flywithme_admin.presentation.ui.flights.FlightsActivity
import com.c16.flywithme_admin.presentation.ui.listcustomer.ListCustomerActivity
import com.c16.flywithme_admin.presentation.ui.login.LoginActivity

@SuppressLint("CustomSplashScreen")
class SplashScreenActivity : AppCompatActivity() {
    private lateinit var _binding: ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(_binding.root)

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, FlightsActivity::class.java)
            startActivity(intent)
            finish()
        }, 2500L)

        setupView()
    }

    private fun setupView() {
        @Suppress("DEPRECATION")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.setDecorFitsSystemWindows(false)
        } else {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
            )
        }
        supportActionBar?.hide()
    }
}