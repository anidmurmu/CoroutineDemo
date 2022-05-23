package com.example.coroutinedemo.data.repositoryimpl

import com.example.coroutinedemo.data.src.DataSrc
import com.example.coroutinedemo.domain.model.UserDetailsUiModel
import com.example.coroutinedemo.domain.repository.OnCompleteCallback
import com.example.coroutinedemo.domain.repository.UserRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class UserRepositoryImpl @Inject constructor(
    private val dataSrc: DataSrc
) : UserRepository {
    override suspend fun getFirstName(id: String): String {
        var firstName = ""
        dataSrc.userDetailsList.forEach {
            if (it.id.equals(id, true)) {
                firstName = it.firstName
                return@forEach
            }
        }
        delay(2000)
        return firstName
    }

    override suspend fun getLastName(id: String): String {
        var lastName = ""
        dataSrc.userDetailsList.forEach {
            if (it.id.equals(id, true)) {
                lastName = it.lastName
                return@forEach
            }
        }
        delay(2000)
        return lastName
    }

    override suspend fun getEmailId(id: String): String {
        var email = ""
        dataSrc.userDetailsList.forEach {
            if (it.id.equals(id, true)) {
                email = it.email
                return@forEach
            }
        }
        delay(2000)
        return email
    }

    override suspend fun getUserDetailsWithEmail(email: String): UserDetailsUiModel {
        var userDetailsUiModel: UserDetailsUiModel = UserDetailsUiModel("", "", "", -1, "")
        dataSrc.userDetailsList.forEach {
            if (it.email.equals(email, true)) {
                userDetailsUiModel = it
                return@forEach
            }
        }
        delay(2000)
        return userDetailsUiModel
    }

    override suspend fun getUserDetailsWithId(id: String): UserDetailsUiModel {
        return dataSrc.getUserDetails(id)
    }

    override suspend fun getStreamOfData(): Flow<Int> = flow {
        for (i in 1..10) {
            delay(1000)
            emit(i)
        }
    }

    override fun getUserDetailsFromCallback(
        id: String,
        onCompleteCallback: OnCompleteCallback<UserDetailsUiModel>
    ) {
        dataSrc.getUserDetailsFromCallback<UserDetailsUiModel>(id, onCompleteCallback)
    }

    override suspend fun getUserDetailsWithoutCallback(id: String): UserDetailsUiModel {
        return suspendCoroutine { continuation ->
            dataSrc.getUserDetailsFromCallback<UserDetailsUiModel>(id, object : OnCompleteCallback<UserDetailsUiModel> {
                override fun onSuccess(t: UserDetailsUiModel) {
                    continuation.resume(t)
                }

                override fun onFailure(t: UserDetailsUiModel) {
                    continuation.resume(t)
                }
            })
        }
    }
}


