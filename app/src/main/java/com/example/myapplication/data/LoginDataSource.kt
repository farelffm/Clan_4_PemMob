package com.example.myapplication.data

import com.example.myapplication.data.model.LoggedInUser
import java.io.IOException

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
class LoginDataSource {

    companion object {
        // In-memory user list for debugging session
        private val registeredUsers = mutableMapOf<String, String>(
            "admin@admin.co.id" to "admin123"
        )

        fun registerUser(email: String, pass: String) {
            registeredUsers[email] = pass
        }
    }

    fun login(username: String, password: String): Result<LoggedInUser> {
        try {
            val storedPassword = registeredUsers[username]
            if (storedPassword != null && storedPassword == password) {
                val user = LoggedInUser(java.util.UUID.randomUUID().toString(), username.split("@")[0])
                return Result.Success(user)
            }
            return Result.Error(IOException("Invalid email or password"))
        } catch (e: Throwable) {
            return Result.Error(IOException("Error logging in", e))
        }
    }

    fun logout() {
        // TODO: revoke authentication
    }
}