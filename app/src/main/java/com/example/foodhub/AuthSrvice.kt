package com.example.foodhub

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult

interface AuthSrvice {
    fun userRegistration(user: UserRegistr) : Task<AuthResult>
}