package com.example.foodhub

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RegistrationViewModel: ViewModel() {
   private val _reistrationRespons= MutableLiveData<DataState<UserRegistr>>()
    val reistrationRespons: LiveData<DataState<UserRegistr>> =_reistrationRespons

    fun userResistration(user: UserRegistr){
        _reistrationRespons.postValue(DataState.Loding())

        val authSrvice= AuthRepository()
       authSrvice.userRegistration(user).addOnCanceledListener {
           _reistrationRespons.postValue(DataState.Suscess(user))

       }.addOnFailureListener {error->
           _reistrationRespons.postValue(DataState.Error("${error.message}"))

       }





    }
}