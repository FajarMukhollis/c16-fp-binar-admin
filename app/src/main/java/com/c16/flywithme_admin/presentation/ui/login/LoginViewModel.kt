package com.c16.flywithme_admin.presentation.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.c16.flywithme_admin.data.response.LoginResponse
import com.c16.flywithme_admin.data.use_case.AdminUseCase
import com.c16.flywithme_admin.preference.AdminModel
import com.c16.flywithme_admin.preference.AdminPrefrence
import kotlinx.coroutines.launch

class LoginViewModel(
    private val adminUseCase: AdminUseCase,
    private val adminPreference: AdminPrefrence
) : ViewModel() {
    fun loginAdmin(email: String, pass: String) = adminUseCase.loginAdmin(email, pass)

    fun saveAdmin(adminLogin: LoginResponse) {
        viewModelScope.launch {
            val data = AdminModel(
                adminLogin.data.id,
                adminLogin.data.email,
                true,
                adminLogin.token
            )
            adminPreference.saveAdmin(data)
        }
    }

    fun getToken() = adminPreference.getToken().asLiveData()

}