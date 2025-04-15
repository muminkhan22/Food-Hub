@file:Suppress("DEPRECATION")

package com.example.foodhub



import android.content.pm.PackageManager
import android.widget.EditText
import androidx.activity.result.ActivityResultLauncher
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment



fun EditText.extract(): String {
    return text.toString().trim()
}

    fun Fragment.requestPermission(
        request: ActivityResultLauncher<Array<String>>,
        permation: Array<String>
    ) {
        request.launch(permation)
    }

    fun Fragment.areAllpermissionGranted(paragraph: Array<String>): Boolean {
        return paragraph.all {
            ContextCompat.checkSelfPermission(requireContext(),it) == PackageManager.PERMISSION_GRANTED
        }
    }


