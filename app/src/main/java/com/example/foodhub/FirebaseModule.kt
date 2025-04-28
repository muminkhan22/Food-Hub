package com.example.foodhub

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
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
    fun providFirebaseFiereStoreDB(): FirebaseFirestore{

        return FirebaseFirestore.getInstance()
    }
    @Provides
    @Singleton
    fun providFirebaseFiereStorage(): StorageReference{

        return FirebaseStorage.getInstance().reference
    }

    @Provides
    @Singleton
    fun providFirebase(mumin: FirebaseAuth,db: FirebaseFirestore): AuthRepository{

        return AuthRepository(mumin,db)
    }
}