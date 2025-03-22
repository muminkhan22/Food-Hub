package com.example.foodhub

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import javax.inject.Inject


class AuthRepository @Inject constructor(private val mumin: FirebaseAuth,private val db: FirebaseFirestore): AuthSrvice {

    override fun userRegistration(user: UserRegistr):Task<AuthResult> {

        return mumin.createUserWithEmailAndPassword(user.email,user.password )
    }

    override fun userLogin(user: UserLogin):Task<AuthResult> {

        return mumin.signInWithEmailAndPassword(user.email,user.password)
    }

    override fun createUser(user: UserRegistr): Task<Void> {
     return  db.collection(Nodes.USER).document(user.UserID).set(user)

    }


}