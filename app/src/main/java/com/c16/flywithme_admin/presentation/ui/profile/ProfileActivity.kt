package com.c16.flywithme_admin.presentation.ui.profile

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.ViewModelProvider
import com.c16.flywithme_admin.data.model.DataAdmin
import com.c16.flywithme_admin.databinding.ActivityProfileBinding
import com.c16.flywithme_admin.presentation.ui.login.LoginActivity
import com.c16.flywithme_admin.result.Result
import com.c16.flywithme_admin.viewmodel.ViewModelFactory

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

class ProfileActivity : AppCompatActivity() {

    private lateinit var _binding : ActivityProfileBinding
    private lateinit var profileViewModel: ProfileViewModel
    private lateinit var adminDetail: DataAdmin
    private var id = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(_binding.root)

        setViewModel()

        _binding.btnLogout.setOnClickListener {
            toLogin()
        }
    }

    private fun setViewModel() {
        val factory = ViewModelFactory.getInstance(this, dataStore)
        profileViewModel = ViewModelProvider(this, factory)[ProfileViewModel::class.java]

        profileViewModel.getAdminData().observe(this@ProfileActivity) {
            id = it.localId
            if(it.isLogin) getAdminDetail()
        }
    }

    private fun getAdminDetail() {
        profileViewModel.getDetailAdmin(id).observe(this@ProfileActivity){ result ->
            when (result){
                is Result.Loading -> showLoading(true)
                is Result.Success -> {
                    adminDetail = result.data
                    loadData()
                    showLoading(false)
                }
                is Result.Error -> {
                    showLoading(false)
                    Toast.makeText(this@ProfileActivity, result.error, Toast.LENGTH_SHORT).show()
                }
                else -> {}
            }
        }
    }

    private fun toLogin() {
        profileViewModel.signOut()
        val intent = Intent(this, LoginActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
    }

    private fun showLoading(status: Boolean) {
        if (status) {
            _binding.loadingIndicator.visibility = View.VISIBLE
        } else {
            _binding.loadingIndicator.visibility = View.GONE
        }
    }

    private fun loadData(){
        _binding.tvEmail.text = adminDetail.email
        _binding.tvFirstName.text = adminDetail.firstName
        _binding.tvLastName.text = adminDetail.lastName
        _binding.tvRole.text = adminDetail.roleId
    }
}