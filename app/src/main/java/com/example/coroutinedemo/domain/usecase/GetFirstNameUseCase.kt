package com.example.coroutinedemo.domain.usecase

import com.example.coroutinedemo.domain.repository.UserRepository
import javax.inject.Inject

interface GetFirstNameUseCase {
    suspend fun getFirstName(id: String): String
}

class GetFirstNameUseCaseImpl @Inject constructor(
    private val userRepository: UserRepository
)
    : GetFirstNameUseCase {
    override suspend fun getFirstName(id: String): String {
        return userRepository.getFirstName(id)
    }
}