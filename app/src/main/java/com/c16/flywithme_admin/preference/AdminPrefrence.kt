package com.c16.flywithme_admin.preference

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class AdminPrefrence private constructor(private val dataStore: DataStore<Preferences>) {

    fun getAdmin(): Flow<AdminModel> {
        return dataStore.data.map { preferences ->
            AdminModel(
                preferences[ID_KEY] ?: 0,
                preferences[EMAIL_KEY] ?: "",
                preferences[STATE_KEY] ?: false,
                preferences[STATE_TOKEN] ?: ""
            )
        }
    }

    fun getToken(): Flow<String> {
        return dataStore.data.map { preferences ->
            preferences[STATE_TOKEN] ?: ""
        }
    }

    fun getIsLogin(): Flow<Boolean> {
        return dataStore.data.map { preferences ->
            preferences[STATE_KEY] ?: false
        }
    }

    suspend fun saveAdmin(admin: AdminModel) {
        dataStore.edit { preferences ->
            preferences[ID_KEY] = admin.adminId
            preferences[EMAIL_KEY] = admin.email
            preferences[STATE_KEY] = admin.isLogin
            preferences[STATE_TOKEN] = admin.token
        }
    }

    suspend fun logout() {
        dataStore.edit { preferences ->
            preferences[ID_KEY]
            preferences[EMAIL_KEY] = ""
            preferences[STATE_KEY] = false
            preferences[STATE_TOKEN] = ""
        }
    }

    companion object {
        @Volatile
        private var INSTANCE: AdminPrefrence? = null

        private val ID_KEY = intPreferencesKey("id")
        private val EMAIL_KEY = stringPreferencesKey("email")
        private val STATE_KEY = booleanPreferencesKey("state")
        private val STATE_TOKEN = stringPreferencesKey("token")

        fun getInstance(dataStore: DataStore<Preferences>): AdminPrefrence {
            return INSTANCE ?: synchronized(this) {
                val instance = AdminPrefrence(dataStore)
                INSTANCE = instance
                instance
            }
        }

    }
}