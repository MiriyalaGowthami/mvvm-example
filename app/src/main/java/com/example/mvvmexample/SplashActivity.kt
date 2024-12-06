package com.example.mvvmexample

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.mvvmexample.vm.SplashViewModel

class SplashActivity : AppCompatActivity() {

    val viewModel: SplashViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        viewModel.isTimeup.observe(this, Observer { isTimeup ->
            if (isTimeup == true) {
                // Go to Main Activity
                val intent = Intent(this, RegistrationActivity::class.java)
                startActivity(intent)
                finish()  // Finish the SplashActivity
            }
        })

    }
}