package com.c16.flywithme_admin.presentation.ui.login

import androidx.lifecycle.ViewModel
import com.c16.flywithme_admin.data.use_case.AdminUseCase

class LoginViewModel(
    private val userUseCase: AdminUseCase,
) : ViewModel() {
    fun loginAdmin(email: String, pass: String) = userUseCase.loginAdmin(email, pass)

}