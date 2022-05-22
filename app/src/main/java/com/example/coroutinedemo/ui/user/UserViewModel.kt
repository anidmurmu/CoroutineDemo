package com.example.coroutinedemo.ui.user

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.coroutinedemo.domain.model.UserDetailsUiModel
import com.example.coroutinedemo.domain.usecase.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import javax.inject.Inject
import kotlin.system.measureTimeMillis
import kotlin.time.measureTime

@HiltViewModel
class UserViewModel @Inject constructor(
    application: Application,
    private val getFirstNameUseCase: GetFirstNameUseCase,
    private val getLastNameUseCase: GetLastNameUseCase,
    private val getEmailIdUseCase: GetEmailIdUseCase,
    private val getUserDetailsWithEmailUseCase: GetUserDetailsWithEmailUseCase,
    private val getUserDetailsWithIdUseCase: GetUserDetailsWithIdUseCase
): AndroidViewModel(application) {

    fun makeApiCallSequentially() {
        viewModelScope.launch(Dispatchers.IO) {
           val time = measureTimeMillis {
                val id = "001"
                val email = getEmailIdUseCase.getEmailId(id)
                val userDetails = getUserDetailsWithEmailUseCase.getUserDetailsWithEmail(email)
                Log.d("apple", userDetails.toString())
            }
            Log.d("apple time ", time.toString())

        }
    }

    fun makeApiCallSequentiallyWithNoDependency() {
        viewModelScope.launch(Dispatchers.IO) {
            val time = measureTimeMillis {
                val givenId = "002"
                val firstName = getFirstNameUseCase.getFirstName(givenId);
                val lastName = getLastNameUseCase.getLastName(givenId)
                Log.d("apple full name ", "$firstName $lastName")
            }
            Log.d("apple time take ", time.toString())
        }
    }

    fun apiCallParallel() {
        viewModelScope.launch(Dispatchers.IO) {
            val time = measureTimeMillis{
                val givenId = "003"
                val deferredFirstName = async {  getFirstNameUseCase.getFirstName(givenId) }
                val deferredLastName = async {  getLastNameUseCase.getLastName(givenId) }
                Log.d("apple full name ", "${deferredFirstName.await()} ${deferredLastName.await()}")
            }
            Log.d("apple time taken ", time.toString())
        }
    }

    fun getListOfUserDetailsSequentially() {
        viewModelScope.launch(Dispatchers.IO) {
            val ids = listOf("001", "002", "003", "004", "005")
            val listOfUserDetails = mutableListOf<UserDetailsUiModel>()
            val time = measureTimeMillis {
                ids.forEach {
                    val userDetails = getUserDetailsWithIdUseCase.getUserDetailsWithId(it)
                    listOfUserDetails.add(userDetails)
                }
                Log.d("apple list of user ", listOfUserDetails.toString())
            }
            Log.d("apple time taken ", time.toString())
        }
    }

    fun getListOfUserDetailsInParallel() {
        viewModelScope.launch(Dispatchers.IO) {
            val ids = listOf("001", "002", "003", "004", "005")
            val listOfUserDetails = mutableListOf<UserDetailsUiModel>()
            val deferredListOfUserDetails = mutableListOf<Deferred<UserDetailsUiModel>>()
            val time = measureTimeMillis {
                ids.forEach {
                    val deferredUserDetails = async {  getUserDetailsWithIdUseCase.getUserDetailsWithId(it) }
                    deferredListOfUserDetails.add(deferredUserDetails)
                }
                listOfUserDetails.addAll(deferredListOfUserDetails.awaitAll())
                Log.d("apple list of user ", listOfUserDetails.toString())
            }
            Log.d("apple time taken ", time.toString())
        }
    }
}