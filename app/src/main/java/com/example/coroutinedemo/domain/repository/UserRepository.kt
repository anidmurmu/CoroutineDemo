package com.example.coroutinedemo.domain.repository

import com.example.coroutinedemo.domain.model.UserDetailsUiModel
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    suspend fun getFirstName(id: String): String
    suspend fun getLastName(id: String): String
    suspend fun getEmailId(id: String): String
    suspend fun getUserDetailsWithEmail(email: String): UserDetailsUiModel
    suspend fun getUserDetailsWithId(id: String): UserDetailsUiModel
    suspend fun getStreamOfData(): Flow<Int>
    fun getUserDetailsFromCallback(id: String, onCompleteCallback: OnCompleteCallback<UserDetailsUiModel>)
    suspend fun getUserDetailsWithoutCallback(id: String): UserDetailsUiModel
}

interface OnCompleteCallback<T> {
    fun onSuccess(t: T)
    fun onFailure(t: T)
}