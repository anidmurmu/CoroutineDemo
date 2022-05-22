package com.example.coroutinedemo.domain.usecase

import com.example.coroutinedemo.domain.model.UserDetailsUiModel
import com.example.coroutinedemo.domain.repository.UserRepository
import javax.inject.Inject

interface GetUserDetailsWithEmailUseCase {
    suspend fun getUserDetailsWithEmail(email: String): UserDetailsUiModel
}

class GetUserDetailsWithEmailUseCaseImpl @Inject constructor(
    private val userRepository: UserRepository
)
    : GetUserDetailsWithEmailUseCase {
    override suspend fun getUserDetailsWithEmail(email: String): UserDetailsUiModel {
        return userRepository.getUserDetailsWithEmail(email)
    }
}