package com.example.mvvmexample.vm

import android.content.Context
import android.content.SharedPreferences
import  androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmexample.DataClassFolder.RegistrationData
import com.example.mvvmexample.RegistrationActivity


class RegistrationViewModel: ViewModel() {

    val registrationData=MutableLiveData(RegistrationData())
    private val _registrationResult = MutableLiveData<String>()
    val registrationResult: LiveData<String> get() = _registrationResult

    val yearsOfStudy = listOf("Select Year", "First Year", "Second Year", "Third Year", "Final Year")

    fun onYearSelected(position: Int) {
        if (position > 0) {
            // Update yearOfStudy in RegistrationData only if a valid year is selected
            registrationData.value?.yearOfStudy = yearsOfStudy[position]
        }
    }

    private fun validateInput():Boolean{
        return when {
            registrationData.value?.username.isNullOrEmpty() -> {
                _registrationResult.value = "Please enter a valid username"
                false
            }

            registrationData.value?.rollNo.isNullOrEmpty() -> {
                _registrationResult.value = "Please enter a valid Rollno"
                false
            }

            registrationData.value?.password.isNullOrEmpty() ||
                    registrationData.value?.password != registrationData.value?.confirmPassword -> {
                _registrationResult.value = "Passwords do not match or are empty"
                false
            }

            registrationData.value?.yearOfStudy.isNullOrEmpty() || registrationData.value?.yearOfStudy == "Select Year" -> {
                _registrationResult.value = "Please select a valid year of study"
                false
            }

//            registrationData.value?.gender.isNullOrEmpty() -> {
//                _registrationResult.value = "Please select a gender"
//                false
//            }

            registrationData.value?.agreeTerms != true -> {
                _registrationResult.value = "You must agree to the terms and conditions"
                false
            }

            else -> true

        }

    }
    fun saveUserData(context: Context){
        val sharedprefs:SharedPreferences=context.getSharedPreferences("myprefs",Context.MODE_PRIVATE)
        val editor = sharedprefs.edit()
        editor.putString("USERNAME", registrationData.value?.username)
        editor.putString("PASSWORD", registrationData.value?.password)
        editor.commit()

    }
    fun register() {
        if (validateInput()) {
            // Proceed with registration logic
            _registrationResult.value = "Registration successful!"
        }
    }
}