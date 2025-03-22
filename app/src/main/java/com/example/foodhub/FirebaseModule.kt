package com.example.foodhub

import com.google.firebase.auth.FirebaseAuth
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class FirebaseModule {
    @Provides
    @Singleton
    fun providFirebaseAuth(): FirebaseAuth{

        return FirebaseAuth.getInstance()
    }

    @Provides
    @Singleton
    fun providFirebase(mumin: FirebaseAuth): AuthRepository{

        return AuthRepository(mumin)
    }
}