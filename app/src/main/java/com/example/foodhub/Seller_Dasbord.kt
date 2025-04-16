package com.example.foodhub

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.foodhub.databinding.ActivitySellerDasbordBinding
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class Seller_Dasbord : AppCompatActivity(){
  private lateinit var binding: ActivitySellerDasbordBinding
          lateinit var navController: NavController
    @Inject
    lateinit var mumin: FirebaseAuth
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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.seller_top_m,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.logout->{
                mumin.signOut()
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
            R.id.sattings->{
                Toast.makeText(this,"Satting Claice", Toast.LENGTH_LONG).show()
            }
            R.id.report->{
                Toast.makeText(this,"Repoft Claice", Toast.LENGTH_LONG).show()

            }

        }

        return super.onOptionsItemSelected(item)
    }
}