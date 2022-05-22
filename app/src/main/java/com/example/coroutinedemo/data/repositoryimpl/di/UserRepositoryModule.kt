package com.example.coroutinedemo.data.repositoryimpl.di

import com.example.coroutinedemo.data.repositoryimpl.UserRepositoryImpl
import com.example.coroutinedemo.data.src.DataSrc
import com.example.coroutinedemo.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped

@Module
@InstallIn(ActivityRetainedComponent::class)
class UserRepositoryModule {

    @Provides
    @ActivityRetainedScoped
    fun provideUserRepositoryUseCase(
        dataSrc: DataSrc
    ): UserRepository {
        return UserRepositoryImpl(dataSrc)
    }
}
