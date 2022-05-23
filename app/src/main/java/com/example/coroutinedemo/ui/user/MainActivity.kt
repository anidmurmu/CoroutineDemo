package com.example.coroutinedemo.ui.user

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.lifecycleScope
import com.example.coroutinedemo.R
import com.example.coroutinedemo.domain.usecase.GetFirstNameUseCase
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: UserViewModel by viewModels()

    @Inject
    lateinit var getFirstNameUseCase: GetFirstNameUseCase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //viewModel.makeApiCallSequentially()
        //viewModel.makeApiCallSequentiallyWithNoDependency()
        //viewModel.apiCallParallel()
        //viewModel.getListOfUserDetailsSequentially()
        //viewModel.getListOfUserDetailsInParallel()
        //viewModel.cancelCoroutineInWhileExecuting()
        //viewModel.getStreamOfData()

        /*GlobalScope.launch(Dispatchers.IO) {
            val firstName = getFirstNameUseCase.getFirstName("001")

            //Toast.makeText(this@MainActivity, firstName, Toast.LENGTH_SHORT).show()

            withContext(Dispatchers.Main) {
                Toast.makeText(this@MainActivity, firstName, Toast.LENGTH_SHORT).show()
            }
        }*/

        /*lifecycleScope.launch(Dispatchers.IO) {
            val firstName = getFirstNameUseCase.getFirstName("001")

            //Toast.makeText(this@MainActivity, firstName, Toast.LENGTH_SHORT).show()

            withContext(Dispatchers.Main) {
                Toast.makeText(this@MainActivity, firstName, Toast.LENGTH_SHORT).show()
            }
        }*/

        //viewModel.getUserDetailsWithIdCallback()
        viewModel.getUserDetailsWithIdWithoutCallback()
    }
}