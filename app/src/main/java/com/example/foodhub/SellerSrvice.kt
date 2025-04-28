package com.example.foodhub

import android.net.Uri
import com.google.android.gms.tasks.Task
import com.google.firebase.storage.UploadTask


interface SellerSrvice {
    fun uplodProdactImsge(prodectImageUri: Uri): UploadTask

    fun uplodProdact(product: Product): Task<Void>

}