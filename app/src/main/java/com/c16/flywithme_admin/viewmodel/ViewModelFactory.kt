package com.c16.flywithme_admin.viewmodel

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.c16.flywithme_admin.data.use_case.AdminUseCase
import com.c16.flywithme_admin.di.Injection
import com.c16.flywithme_admin.presentation.login.LoginViewModel

class ViewModelFactory (
    private val userUseCase: AdminUseCase
        ) : ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(LoginViewModel::class.java) -> LoginViewModel(
                userUseCase//, pref
            ) as T
            else -> throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
        }
    }

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context, pref: DataStore<Preferences>): ViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: ViewModelFactory(
                    Injection.provideUserUseCase(),
                    //UserPreference.getInstance(pref),
                )
            }.also { instance = it }
    }
}