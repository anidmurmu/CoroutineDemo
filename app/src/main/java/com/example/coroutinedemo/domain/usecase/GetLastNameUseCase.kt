package com.example.coroutinedemo.domain.usecase

import com.example.coroutinedemo.domain.repository.UserRepository
import javax.inject.Inject

interface GetLastNameUseCase {
    suspend fun getLastName(id: String): String
}

class GetLastNameUseCaseImpl @Inject constructor(
    private val userRepository: UserRepository
)
    : GetLastNameUseCase {
    override suspend fun getLastName(id: String): String {
        return userRepository.getLastName(id)
    }
}