package com.c16.flywithme_admin.data.use_case

import androidx.lifecycle.LiveData
import com.c16.flywithme_admin.data.repository.IAdminRepository
import com.c16.flywithme_admin.data.response.LoginResponse
import com.c16.flywithme_admin.result.Result

class AdminInteract(private val AdminRepository: IAdminRepository) :
    AdminUseCase {

    override fun loginAdmin(email: String, pass: String): LiveData<Result<LoginResponse>> =
        AdminRepository.loginAdmin(email, pass)

}