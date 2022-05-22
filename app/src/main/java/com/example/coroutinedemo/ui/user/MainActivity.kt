package com.example.coroutinedemo.ui.user

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.coroutinedemo.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //viewModel.makeApiCallSequentially()
        //viewModel.makeApiCallSequentiallyWithNoDependency()
        //viewModel.apiCallParallel()
        //viewModel.getListOfUserDetailsSequentially()
        viewModel.getListOfUserDetailsInParallel()
    }
}