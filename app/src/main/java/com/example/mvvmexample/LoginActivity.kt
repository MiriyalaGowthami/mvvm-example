package com.example.mvvmexample


import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.mvvmexample.databinding.ActivityLoginBinding
import com.example.mvvmexample.vm.LoginViewModel



class LoginActivity : AppCompatActivity() {

    // Declare binding as lateinit at the class level
    private lateinit var binding: ActivityLoginBinding

    private val viewModel: LoginViewModel? by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Set up data binding
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
    }
}

