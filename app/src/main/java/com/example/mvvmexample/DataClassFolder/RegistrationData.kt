package com.example.mvvmexample.DataClassFolder

data class RegistrationData(var username: String = "",
                            var rollNo: String = "",
                            var password: String = "",
                            var confirmPassword: String = "",
                            var gender: String = "",
                            var agreeTerms: Boolean = false,
                            var yearOfStudy: String="")

