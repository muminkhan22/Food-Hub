package com.example.foodhub

import android.Manifest
import android.app.Activity
import android.util.Log
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.viewModels
import com.example.foodhub.databinding.FragmentUploadProductBinding
import com.github.dhaval2404.imagepicker.ImagePicker
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.AndroidEntryPoint
import java.util.UUID

@AndroidEntryPoint
class UploadProductFragment : BasteFragment<FragmentUploadProductBinding>(
    FragmentUploadProductBinding::inflate
) {

      private val product: Product by lazy() {
          Product()
      }
    private val viewModel: ProdectUolidViewModel by viewModels()
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


                 FirebaseAuth.getInstance().currentUser?.let {

                     product.apply {
                         this.productId= UUID.randomUUID().toString()
                         this.sellerId= it.uid
                         this.name = name
                         this.description = description
                         this.price = price.toDouble()
                         this.amount = amount.toInt()
                     }
                 }

                 UploadProduct(product)
            }
        }


    }

    private fun getpermissionsRequest(): ActivityResultLauncher<Array<String>> {
        return registerForActivityResult (ActivityResultContracts.RequestMultiplePermissions()){
            if (areAllpermissionGranted(parmissionList)){
                Toast.makeText(requireContext(),"Granted",Toast.LENGTH_LONG).show()

                ImagePicker.with(this)
                    .compress(1024)         //Final image size will be less than 1 MB(Optional)
                    .maxResultSize(512,512)  //Final image resolution will be less than 1080 x 1080(Optional)
                    .createIntent { intent ->
                        startForProfileImageResult.launch(intent)
                    }

            }else{
                Toast.makeText(requireContext(),"Not Granted",Toast.LENGTH_LONG).show()


            }
        }
    }

    private fun UploadProduct(product: Product) {

        viewModel.prodectUplod(product)

    }

    override fun allObserver() {
        viewModel.prodectUplodRespons.observe(viewLifecycleOwner) {
            when(it){
                is DataState.Error -> {
                    loader.dismiss()
                }
                is DataState.Loding -> {
                    loader.show()
                }
                is DataState.Suscess -> {
                    Toast.makeText(requireContext(),it.data, Toast.LENGTH_LONG).show()
                    loader.dismiss()

                }
            }
        }

    }
    companion object{
        private val parmissionList= arrayOf(
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.CAMERA

        )
    }
    private lateinit var permissionsRequest: ActivityResultLauncher<Array<String>>
    private val startForProfileImageResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
            val resultCode = result.resultCode
            val data = result.data

            if (resultCode == Activity.RESULT_OK) {
                //Image Uri will not be null for RESULT_OK
                val fileUri = data?.data!!
                Log.d("TAG", "$fileUri")
                binding.usprofile.setImageURI(fileUri)

                product.imageLink = fileUri.toString()


            } else if (resultCode == ImagePicker.RESULT_ERROR) {
                Toast.makeText(requireContext(), ImagePicker.getError(data), Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(requireContext(), "Task Cancelled", Toast.LENGTH_SHORT).show()
            }
        }

}

