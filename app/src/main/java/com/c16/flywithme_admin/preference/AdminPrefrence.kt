package com.c16.flywithme_admin.preference

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class AdminPrefrence private constructor(private val dataStore: DataStore<Preferences>) {

    fun getAdmin(): Flow<AdminModel> {
        return dataStore.data.map { preferences ->
            AdminModel(
                preferences[ID_KEY] ?: "",
                preferences[EMAIL_KEY] ?: "",
                preferences[PASS_KEY] ?: "",
                preferences[STATE_KEY] ?: false
            )
        }
    }

    suspend fun saveAdmin(admin: AdminModel){
        dataStore.edit { preferences ->
            preferences[ID_KEY] = admin.localId
            preferences[EMAIL_KEY] = admin.email
            preferences[PASS_KEY] = admin.password
            preferences[STATE_KEY] = admin.isLogin
        }
    }

    suspend fun logout(){
        dataStore.edit { preferences ->
            preferences[ID_KEY] = ""
            preferences[EMAIL_KEY] = ""
            preferences[PASS_KEY] = ""
            preferences[STATE_KEY] = false
        }
    }

    companion object{
        @Volatile
        private var INSTANCE: AdminPrefrence? = null

        private val ID_KEY = stringPreferencesKey("admin_id")
        private val EMAIL_KEY = stringPreferencesKey("email")
        private val PASS_KEY = stringPreferencesKey("password")
        private val STATE_KEY = booleanPreferencesKey("state")

        fun getInstance(dataStore: DataStore<Preferences>): AdminPrefrence{
            return INSTANCE ?: synchronized(this){
                val instance = AdminPrefrence(dataStore)
                INSTANCE = instance
                instance
            }
        }

    }
}