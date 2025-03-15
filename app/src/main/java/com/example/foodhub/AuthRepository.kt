package com.example.foodhub

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth


class AuthRepository: AuthSrvice {
    override fun userRegistration(user: UserRegistr): Task<AuthResult> {
        val mumin= FirebaseAuth.getInstance()

        return mumin.createUserWithEmailAndPassword(user.email,user.password )
    }


}