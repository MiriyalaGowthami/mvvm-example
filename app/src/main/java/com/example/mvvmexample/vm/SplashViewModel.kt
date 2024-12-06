package com.example.mvvmexample.vm

import android.os.Handler
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SplashViewModel : ViewModel() {
    private val _isTimeup=MutableLiveData<Boolean>()
    val isTimeup:LiveData<Boolean> get()=_isTimeup
    init{
        Handler().postDelayed({
            _isTimeup.value =true

        },3000)
    }
}