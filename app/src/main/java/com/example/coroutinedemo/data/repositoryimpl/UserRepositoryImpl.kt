package com.example.coroutinedemo.data.repositoryimpl

import com.example.coroutinedemo.data.src.DataSrc
import com.example.coroutinedemo.domain.model.UserDetailsUiModel
import com.example.coroutinedemo.domain.repository.UserRepository
import kotlinx.coroutines.delay
import javax.inject.Inject

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
}


