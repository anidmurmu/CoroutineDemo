package com.example.coroutinedemo.domain.usecase

import com.example.coroutinedemo.domain.model.UserDetailsUiModel
import com.example.coroutinedemo.domain.repository.UserRepository
import javax.inject.Inject

interface GetUserDetailsWithIdUseCase {
    suspend fun getUserDetailsWithId(id: String): UserDetailsUiModel
}

class GetUserDetailsWithIdUseCaseImpl @Inject constructor(
    private val userRepository: UserRepository
) : GetUserDetailsWithIdUseCase {
    override suspend fun getUserDetailsWithId(id: String): UserDetailsUiModel {
        return userRepository.getUserDetailsWithId(id)
    }
}