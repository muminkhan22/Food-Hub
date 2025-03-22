package com.example.foodhub

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val authSrvice: AuthRepository):ViewModel() {
   private val _loginRespons= MutableLiveData<DataState<UserLogin>>()
    val loginRespons: LiveData<DataState<UserLogin>> =_loginRespons

    fun userLogin(user: UserLogin){
        _loginRespons.postValue(DataState.Loding())


       authSrvice.userLogin(user).addOnSuccessListener {
           _loginRespons.postValue(DataState.Suscess(user))

       }.addOnFailureListener {error->
           _loginRespons.postValue(DataState.Error("${error.message}"))

       }





    }
}