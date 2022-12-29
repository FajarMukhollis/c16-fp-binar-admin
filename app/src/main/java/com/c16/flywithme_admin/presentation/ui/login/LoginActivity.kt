package com.c16.flywithme_admin.presentation.ui.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.ViewModelProvider
import com.c16.flywithme_admin.R
import com.c16.flywithme_admin.databinding.ActivityLoginBinding
import com.c16.flywithme_admin.databinding.DialogLoadingBinding
import com.c16.flywithme_admin.presentation.ui.home.MainActivity
import com.c16.flywithme_admin.result.Result
import com.c16.flywithme_admin.viewmodel.ViewModelFactory

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

class LoginActivity : AppCompatActivity() {

    private lateinit var _binding: ActivityLoginBinding
    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(_binding.root)

        setViewModel()

        _binding.btnLogin.setOnClickListener{
            loginAction()
        }

        supportActionBar?.hide()
    }

    private fun setViewModel() {
        val factory = ViewModelFactory.getInstance(this, dataStore)
        viewModel = ViewModelProvider(this, factory)[LoginViewModel::class.java]
    }

    private fun loginAction() {
        val emailEditText = _binding.etEmail
        val passwordEditText = _binding.etPassword

        val email = emailEditText.text.toString()
        val password = passwordEditText.text.toString()

        when {
            email.isEmpty() -> emailEditText.error = resources.getString(R.string.empty_email)
            !checkEmailError(email) -> emailEditText.error = resources.getString(R.string.not_email)
            password.isEmpty() -> passwordEditText.error = resources.getString(R.string.empty_pass)
            else -> {
                //loading dialog
                val customBind = DialogLoadingBinding.inflate(layoutInflater)
                val loadingDialogBuilder = AlertDialog.Builder(this).apply {
                    setView(customBind.root)
                    setCancelable(false)
                }
                val loadingDialog = loadingDialogBuilder.create()

                viewModel.loginAdmin(email, password).observe(this) { result ->
                    when (result) {
                        is Result.Loading -> loadingDialog.show()
                        is Result.Success -> {
                            loadingDialog.dismiss()
                            //viewModel.saveAdmin(result.dataAdd)
                            toMain()
                        }
                        is Result.Error -> {
                            loadingDialog.dismiss()
                            errorAlert()
                        }
                    }
                }
            }

        }
    }

    private fun checkEmailError(target: CharSequence): Boolean {
        return if (TextUtils.isEmpty(target)) false else android.util.Patterns.EMAIL_ADDRESS.matcher(
            target
        ).matches()
    }

    private fun errorAlert() {
        AlertDialog.Builder(this).apply {
            setTitle(resources.getString(R.string.failed_login))
            setMessage(resources.getString(R.string.not_found))
            create()
            show()
        }
    }

    private fun toMain() {
        val intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
    }


}

