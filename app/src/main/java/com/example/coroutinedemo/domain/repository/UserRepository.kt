package com.example.coroutinedemo.domain.repository

import com.example.coroutinedemo.domain.model.UserDetailsUiModel

interface UserRepository {
    suspend fun getFirstName(id: String): String
    suspend fun getLastName(id: String): String
    suspend fun getEmailId(id: String): String
    suspend fun getUserDetailsWithEmail(email: String): UserDetailsUiModel
    suspend fun getUserDetailsWithId(id: String): UserDetailsUiModel
}