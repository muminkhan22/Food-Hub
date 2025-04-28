package com.example.foodhub

import android.net.Uri
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.UploadTask
import javax.inject.Inject


class SellerRepository @Inject constructor(
    private val mumin: FirebaseAuth,
    private val storageRef: StorageReference):
    SellerSrvice {


    override fun uplodProdactImsge(prodectImageUri: Uri): UploadTask {
        val storage:StorageReference=storageRef.child("prodects").child("PRD_${System.currentTimeMillis()}")
      return  storage.putFile(prodectImageUri)
    }

    override fun uplodProdact(product: Product): Task<Void> {

        return  mumin.collection(Nodes.PRODUCTS).document(product.productId).set(product)

    }


}