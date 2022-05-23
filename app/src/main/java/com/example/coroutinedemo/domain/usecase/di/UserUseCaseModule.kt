package com.example.coroutinedemo.domain.usecase.di

import com.example.coroutinedemo.domain.repository.UserRepository
import com.example.coroutinedemo.domain.usecase.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped

@Module
@InstallIn(ActivityRetainedComponent::class)
class UserUseCaseModule {

    @Provides
    @ActivityRetainedScoped
    fun provideGetEmailIdUseCase(
        userRepository: UserRepository
    ): GetEmailIdUseCase {
        return GetEmailIdUseCaseImpl(userRepository)
    }

    @Provides
    @ActivityRetainedScoped
    fun provideGetFirstNameUseCase(
        userRepository: UserRepository
    ): GetFirstNameUseCase {
        return GetFirstNameUseCaseImpl(userRepository)
    }

    @Provides
    @ActivityRetainedScoped
    fun provideGetLastNameUseCase(
        userRepository: UserRepository
    ): GetLastNameUseCase {
        return GetLastNameUseCaseImpl(userRepository)
    }

    @Provides
    @ActivityRetainedScoped
    fun provideGetUserDetailsWithEmailUseCase(
        userRepository: UserRepository
    ): GetUserDetailsWithEmailUseCase {
        return GetUserDetailsWithEmailUseCaseImpl(userRepository)
    }

    @Provides
    @ActivityRetainedScoped
    fun provideGetUserDetailsWithIdUseCase(
        userRepository: UserRepository
    ): GetUserDetailsWithIdUseCase {
        return GetUserDetailsWithIdUseCaseImpl(userRepository)
    }

    @Provides
    @ActivityRetainedScoped
    fun provideGetStreamOfDataUseCase(
        userRepository: UserRepository
    ): GetStreamOfDataUseCase {
        return GetStreamOfDataUseCaseImpl(userRepository)
    }

    @Provides
    @ActivityRetainedScoped
    fun provideGetUserDetailsWithIdCallbackUseCase(
        userRepository: UserRepository
    ): GetUserDetailsWithIdCallbackUseCase {
        return GetUserDetailsWithIdCallbackUseCaseImpl(userRepository)
    }

    @Provides
    @ActivityRetainedScoped
    fun provideGetUserDetailsWithIdWithoutCallback(
        userRepository: UserRepository
    ): GetUserDetailsWithIdWithoutCallback {
        return GetUserDetailsWithIdWithoutCallbackImpl(userRepository)
    }
}