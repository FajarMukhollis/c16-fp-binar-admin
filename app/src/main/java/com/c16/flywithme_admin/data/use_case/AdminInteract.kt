package com.c16.flywithme_admin.data.use_case

import androidx.lifecycle.LiveData
import com.c16.flywithme_admin.data.model.DataAdmin
import com.c16.flywithme_admin.data.model.login.AdminLogin
import com.c16.flywithme_admin.data.repository.IAdminRepository
import com.c16.flywithme_admin.result.Result

class AdminInteract(private val AdminRepository: IAdminRepository) :
    AdminUseCase {

    override fun loginAdmin(email: String, pass: String): LiveData<Result<AdminLogin>> =
        AdminRepository.loginAdmin(email, pass)

    override fun getDetailAdmin(id: String): LiveData<Result<DataAdmin>> =
        AdminRepository.getDetailAdmin(id)

}