package com.c16.flywithme_admin.presentation.ui.start

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.c16.flywithme_admin.preference.AdminPrefrence

class SplashViewModel(private val pref: AdminPrefrence):ViewModel() {

    fun getIsLogin() = pref.getIsLogin().asLiveData()
}