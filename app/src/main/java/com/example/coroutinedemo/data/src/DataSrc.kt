package com.example.coroutinedemo.data.src

import com.example.coroutinedemo.domain.model.UserDetailsUiModel
import kotlinx.coroutines.delay
import javax.inject.Inject

class DataSrc @Inject constructor() {
    private val user1 = UserDetailsUiModel(
        "001",
        "Rohit",
        "Kumar",
        25,
        "rohitkumar@gmail.com"
    )

    private val user2 = UserDetailsUiModel(
        "002",
        "Amit",
        "Kumar",
        27,
        "amitkumar@gmail.com"
    )

    private val user3 = UserDetailsUiModel(
        "003",
        "Neha",
        "Agarwal",
        25,
        "sweetneha@gmail.com"
    )

    private val user4 = UserDetailsUiModel(
        "004",
        "Santosh",
        "Gowda",
        30,
        "santhosh@gmail.com"
    )

    private val user5 = UserDetailsUiModel(
        "005",
        "Manoj",
        "Murmu",
        20,
        "manojmurmu@gmail.com"
    )

    val userDetailsList = listOf<UserDetailsUiModel>(user1, user2, user3, user4, user5)

    suspend fun getUserDetails(id: String): UserDetailsUiModel {
        delay(2000)
        var userDetailsUiModel = UserDetailsUiModel("", "", "", -1, "")
        userDetailsList.forEach {
            if(id.equals(it.id, true)) {
                userDetailsUiModel = it
                return@forEach
            }
        }
        return userDetailsUiModel
    }
}