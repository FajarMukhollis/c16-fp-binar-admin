package com.c16.flywithme_admin.presentation.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.c16.flywithme_admin.data.use_case.AdminUseCase
import com.c16.flywithme_admin.preference.AdminModel
import com.c16.flywithme_admin.preference.AdminPrefrence
import kotlinx.coroutines.launch

class MainViewModel(
    private val adminUseCase: AdminUseCase,
    private val adminPreference: AdminPrefrence
) : ViewModel() {

    fun getDetailAdmin(
        id: String
    ) = adminUseCase.getDetailAdmin(id)

    fun getAdminData(): LiveData<AdminModel> = adminPreference.getAdmin().asLiveData()

    fun signOut() {
        viewModelScope.launch {
            adminPreference.logout()
        }
    }


}