package com.c16.flywithme_admin.presentation.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.c16.flywithme_admin.data.model.login.AdminLogin
import com.c16.flywithme_admin.data.use_case.AdminUseCase
import com.c16.flywithme_admin.preference.AdminModel
import com.c16.flywithme_admin.preference.AdminPrefrence
import kotlinx.coroutines.launch

class LoginViewModel(
    private val adminUseCase: AdminUseCase,
    private val adminPreference: AdminPrefrence
) : ViewModel() {
    fun loginAdmin(email: String, pass: String) = adminUseCase.loginAdmin(email, pass)

    fun saveAdmin(adminLogin: AdminLogin) {
        viewModelScope.launch {
            val data = AdminModel(
                adminLogin.localId,
                adminLogin.email,
                adminLogin.password,
                true
            )
            adminPreference.saveAdmin(data)
        }
    }

}