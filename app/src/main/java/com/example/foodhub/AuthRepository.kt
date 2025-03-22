package com.example.foodhub

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import javax.inject.Inject


class AuthRepository @Inject constructor(private val mumin: FirebaseAuth): AuthSrvice {

    override fun userRegistration(user: UserRegistr):Task<AuthResult> {

        return mumin.createUserWithEmailAndPassword(user.email,user.password )
    }

    override fun userLogin(user: UserLogin):Task<AuthResult> {

        return mumin.signInWithEmailAndPassword(user.email,user.password)
    }


}