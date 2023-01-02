package com.c16.flywithme_admin.presentation.ui.start

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.ViewModelProvider
import com.c16.flywithme_admin.databinding.ActivitySplashScreenBinding
import com.c16.flywithme_admin.presentation.ui.home.MainActivity
import com.c16.flywithme_admin.presentation.ui.login.LoginActivity
import com.c16.flywithme_admin.viewmodel.ViewModelFactory

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

@SuppressLint("CustomSplashScreen")
class SplashScreenActivity : AppCompatActivity() {
    private lateinit var _binding: ActivitySplashScreenBinding
    private lateinit var splashViewModel: SplashViewModel

    private var isLogin = false
    private var splashTime = 2500L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(_binding.root)

        supportActionBar?.hide()

        setViewModel()

        Handler(Looper.getMainLooper()).postDelayed({
            if (isLogin) toMain() else toLogin()
        }, splashTime)

    }

    private fun toLogin() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun toMain() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }


    private fun setViewModel() {
        val factory = ViewModelFactory.getInstance(this, dataStore)
        splashViewModel = ViewModelProvider(this, factory)[SplashViewModel::class.java]
        splashViewModel.getIsLogin().observe(this) {
            isLogin = it
        }
    }
}