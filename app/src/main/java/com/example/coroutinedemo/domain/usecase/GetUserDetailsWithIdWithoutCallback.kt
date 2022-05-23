package com.example.coroutinedemo.domain.usecase

import com.example.coroutinedemo.domain.model.UserDetailsUiModel
import com.example.coroutinedemo.domain.repository.UserRepository
import javax.inject.Inject

interface GetUserDetailsWithIdWithoutCallback {
    suspend fun getUserDetailsWithoutCallback(id: String): UserDetailsUiModel
}

class GetUserDetailsWithIdWithoutCallbackImpl @Inject constructor(
    private val userRepository: UserRepository
): GetUserDetailsWithIdWithoutCallback {
    override suspend fun getUserDetailsWithoutCallback(id: String): UserDetailsUiModel {
        return userRepository.getUserDetailsWithoutCallback(id)
    }
}