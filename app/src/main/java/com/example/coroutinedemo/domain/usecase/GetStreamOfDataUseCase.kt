package com.example.coroutinedemo.domain.usecase

import com.example.coroutinedemo.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface GetStreamOfDataUseCase {
    suspend fun getStreamOfData(): Flow<Int>
}

class GetStreamOfDataUseCaseImpl @Inject constructor(
    private val userRepository: UserRepository
)
    : GetStreamOfDataUseCase {
    override suspend fun getStreamOfData(): Flow<Int> {
        return userRepository.getStreamOfData()
    }
}