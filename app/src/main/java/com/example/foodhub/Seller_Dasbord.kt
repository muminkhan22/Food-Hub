package com.example.foodhub

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.foodhub.databinding.ActivitySellerDasbordBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Seller_Dasbord : AppCompatActivity(){
  private lateinit var binding: ActivitySellerDasbordBinding
          lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySellerDasbordBinding.inflate(layoutInflater)

        setContentView(binding.root)
        navController = findNavController(R.id.fragmentContainerView2)
           val appBarConfig= AppBarConfiguration(setOf(
               R.id.product,
               R.id.add,
               R.id.profile
           ))
        binding.bottomNavigationView.setupWithNavController(navController)
        setupActionBarWithNavController(navController,appBarConfig)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()|| super.onSupportNavigateUp()
    }
}