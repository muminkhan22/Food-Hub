package com.example.foodhub

import android.Manifest
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.foodhub.databinding.FragmentUploadProductBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UploadProductFragment : BasteFragment<FragmentUploadProductBinding>(
    FragmentUploadProductBinding::inflate
) {
    override fun setlistener() {

        permissionsRequest= getpermissionsRequest()


        binding.apply {
            usprofile.setOnClickListener {
                requestPermission(permissionsRequest,parmissionList)
            }

             uploadproduct.setOnClickListener {
                val name= productname.extract()
                val price= productprice.extract()
                val description=productdescription.extract()
                val amount= productamount.extract()

                val product= product(
                    name=name,
                    price=price.toDouble(),
                    description=description,
                    amount=amount.toInt()
                )
                UploadProduct(product)
            }

        }


    }

    private fun getpermissionsRequest(): ActivityResultLauncher<Array<String>> {
        return registerForActivityResult (ActivityResultContracts.RequestMultiplePermissions()){
            if (areAllpermissionGranted(parmissionList)){
                Toast.makeText(requireContext(),"Granted",Toast.LENGTH_LONG).show()

            }else{
                Toast.makeText(requireContext(),"Not Granted",Toast.LENGTH_LONG).show()


            }
        }
    }

    private fun UploadProduct(product: product) {

    }

    override fun allObserver() {

    }
    companion object{
        private val parmissionList= arrayOf(
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.CAMERA

        )
    }
    private lateinit var permissionsRequest: ActivityResultLauncher<Array<String>>


}

