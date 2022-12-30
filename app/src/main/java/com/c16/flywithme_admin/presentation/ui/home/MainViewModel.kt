package com.c16.flywithme_admin.presentation.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.c16.flywithme_admin.preference.AdminPrefrence
import kotlinx.coroutines.launch

class MainViewModel(
    private val adminPreference: AdminPrefrence
) : ViewModel() {

    fun signOut() {
        viewModelScope.launch {
            adminPreference.logout()
        }
    }


}