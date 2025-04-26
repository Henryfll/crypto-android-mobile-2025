package com.example.coincapapp.services

import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.tasks.await

class AuthService(
    private val auth: FirebaseAuth = FirebaseAuth.getInstance()
) {
    suspend fun login(email: String, password: String): Result<Unit> {
        return try {
            auth.signInWithEmailAndPassword(email, password).await()
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}