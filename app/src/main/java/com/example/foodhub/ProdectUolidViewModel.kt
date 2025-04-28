package com.example.foodhub

import android.net.Uri
import androidx.core.net.toUri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProdectUolidViewModel @Inject constructor(private val repo: SellerRepository):ViewModel() {

   private val _prodectUplodRespons= MutableLiveData<DataState<String>>()
    val prodectUplodRespons: LiveData<DataState<String>> =_prodectUplodRespons

    fun prodectUplod(product: Product){
            _prodectUplodRespons.postValue(DataState.Loding())

        val imageUri: Uri = product.imageLink.toUri()

        repo.uplodProdactImsge(imageUri).addOnSuccessListener {   snapshot->

            snapshot.metadata?.reference?.downloadUrl?.addOnSuccessListener {url->
                product.imageLink= url.toString()
                repo.uplodProdact(product).addOnSuccessListener {
                    _prodectUplodRespons.postValue(DataState.Suscess("Uploded and Updated Prodect Successfully "))

                }.addOnFailureListener {
                    _prodectUplodRespons.postValue(DataState.Error("${it.message}"))

                }
            }

        }.addOnFailureListener {
            _prodectUplodRespons.postValue(DataState.Error("Image Uploded Fail"))



        }

    }
}