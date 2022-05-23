package com.example.coroutinedemo.domain.usecase

import com.example.coroutinedemo.domain.model.UserDetailsUiModel
import com.example.coroutinedemo.domain.repository.OnCompleteCallback
import com.example.coroutinedemo.domain.repository.UserRepository
import javax.inject.Inject

interface GetUserDetailsWithIdCallbackUseCase {
    fun getUserDetailsFromCallback(id: String, onCompleteCallback: OnCompleteCallback<UserDetailsUiModel>)
}

class GetUserDetailsWithIdCallbackUseCaseImpl @Inject constructor(
    private val userRepository: UserRepository
): GetUserDetailsWithIdCallbackUseCase {
    override fun getUserDetailsFromCallback(
        id: String,
        onCompleteCallback: OnCompleteCallback<UserDetailsUiModel>
    ) {
        userRepository.getUserDetailsFromCallback(id, onCompleteCallback)
    }
}