package com.rifara.storyappdicoding.ui.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rifara.storyappdicoding.core.data.remote.request.LoginRequest
import com.rifara.storyappdicoding.core.data.remote.request.RegisterRequest
import com.rifara.storyappdicoding.core.data.remote.response.LoginResponse
import com.rifara.storyappdicoding.core.data.remote.response.RegisterResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


// Segala sesuatu yang ada di kelas ini akan terjaga selama Activity masih dalam keadaan aktif.
class AuthViewModel : ViewModel() {

    private val _register = MutableLiveData<RegisterResponse>()
    val register: LiveData<RegisterResponse> = _register

    private val _login = MutableLiveData<LoginResponse>()
    val login: LiveData<LoginResponse> = _login

    fun registerAccount(body: RegisterRequest) {
        viewModelScope.launch(Dispatchers.IO) {
            try {


            } catch (ex: Exception) {
                Log.d("AuthViewModel", ex.message.toString())
            }
        }
    }

    fun loginAccount(body: LoginRequest) {

    }


}