package com.example.mvvmexample.vm


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel() : ViewModel() {
    // LiveData for username and password entered by the user
    val username: MutableLiveData<String> = MutableLiveData("")
    val password: MutableLiveData<String> = MutableLiveData("")

    // LiveData for displaying error messages
    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> = _errorMessage

    // LiveData to control the visibility of error message
    private val _errorVisible = MutableLiveData<Boolean>(false)
    val errorVisible: LiveData<Boolean> = _errorVisible

    // LiveData to control the successful login event
    private val _isLoginSuccessful = MutableLiveData<Boolean>()
    val isLoginSuccessful: LiveData<Boolean> get() = _isLoginSuccessful

    // Function to be triggered when the user clicks the login button
    fun onLoginClick() {
        // Validate input fields
        if (username.value.isNullOrEmpty() || password.value.isNullOrEmpty()) {
            _errorMessage.value = "Username or Password cannot be empty!"
            _errorVisible.value = true
        } else {
//            val sharedPreferences: SharedPreferences = context.getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
//            // Retrieve stored credentials from SharedPreferences
//            val storedUsername = sharedPreferences.getString("USERNAME", null)
//            val storedPassword = sharedPreferences.getString("PASSWORD", null)
//
//            // Check if the entered username and password match the stored credentials
//            if (username.value == storedUsername && password.value == storedPassword) {
//                _errorMessage.value = ""
//                _errorVisible.value = false
//                _isLoginSuccessful.value = true  // Login is successful
//            } else {
//                _errorMessage.value = "Invalid username or password"
//                _errorVisible.value = true
//                _isLoginSuccessful.value = false  // Login failed
//            }
        }
    }
}
