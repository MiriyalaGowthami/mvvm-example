package com.example.mvvmexample

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.mvvmexample.databinding.ActivityRegistrationBinding


import com.example.mvvmexample.vm.RegistrationViewModel



class RegistrationActivity : AppCompatActivity() {

    private val viewModel: RegistrationViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Set up DataBinding
        val binding: ActivityRegistrationBinding = DataBindingUtil.setContentView(this, R.layout.activity_registration)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        // Set up spinner with year options
        val spinnerAdapter = ArrayAdapter(
            this, android.R.layout.simple_spinner_item, viewModel.yearsOfStudy
        )
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerYear.adapter = spinnerAdapter

        // Spinner item selection listener
        binding.spinnerYear.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                viewModel.onYearSelected(position)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Do nothing if nothing is selected
            }
        }

        // Observe registration result
        viewModel.registrationResult.observe(this, Observer { result ->
            // Display a Toast message with the registration result
            Toast.makeText(this, result, Toast.LENGTH_SHORT).show()

            // If registration is successful, navigate to the LoginActivity
            if (result == "Registration successful!") {
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish() // Close the registration activity to prevent going back
            }
        })

        // Register button click listener

    }
}
