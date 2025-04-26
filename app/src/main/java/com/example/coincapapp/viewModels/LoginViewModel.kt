package com.example.coincapapp.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coincapapp.services.AuthService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LoginViewModel (
    private val authService: AuthService = AuthService()
): ViewModel(){

    private val _message = MutableStateFlow("")
    val message: StateFlow<String> get() = _message

    fun login(email: String, password: String) {
        viewModelScope.launch {
            val result = authService.login(email, password)
            _message.value = result.fold(
                onSuccess = { "Login exitoso" },
                onFailure = { it.message ?: "Error desconocido" }
            )
        }
    }

}