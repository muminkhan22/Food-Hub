package com.example.foodhub

import android.widget.EditText

fun EditText.isEmpty():Boolean{
   return if (this.text.toString().isEmpty()){
        this.error="This need to be fill up"
        true
    }else{
        false
    }
}