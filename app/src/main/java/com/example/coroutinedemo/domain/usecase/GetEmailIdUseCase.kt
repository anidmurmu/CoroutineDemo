package com.example.coroutinedemo.domain.usecase

import com.example.coroutinedemo.domain.repository.UserRepository
import javax.inject.Inject

interface GetEmailIdUseCase {
    suspend fun getEmailId(id: String): String
}

class GetEmailIdUseCaseImpl @Inject constructor(
    private val userRepository: UserRepository
)
    : GetEmailIdUseCase {
    override suspend fun getEmailId(id: String): String {
        return userRepository.getEmailId(id)
    }
}