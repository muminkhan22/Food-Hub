package com.example.foodhub

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegistrationViewModel @Inject constructor(private val authSrvice: AuthRepository):ViewModel() {
   private val _reistrationRespons= MutableLiveData<DataState<UserRegistr>>()
    val reistrationRespons: LiveData<DataState<UserRegistr>> =_reistrationRespons

    fun userResistration(user: UserRegistr){
            _reistrationRespons.postValue(DataState.Loding())

        authSrvice.userRegistration(user).
        addOnSuccessListener {
            it.user?.let{createUser->
                user.UserID =createUser.uid
                authSrvice.createUser(user).addOnSuccessListener {
                    _reistrationRespons.postValue(DataState.Suscess(user))
                }.addOnFailureListener { error->
                    _reistrationRespons.postValue(DataState.Error("${error.message}"))

                }

            }
        }.addOnFailureListener {error->
           _reistrationRespons.postValue(DataState.Error("${error.message}"))

       }


    }
}