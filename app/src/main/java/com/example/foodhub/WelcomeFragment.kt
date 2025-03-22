package com.example.foodhub

import androidx.navigation.fragment.findNavController
import com.example.foodhub.databinding.FragmentWelcomeBinding
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WelcomeFragment : BasteFragment<FragmentWelcomeBinding>
    (FragmentWelcomeBinding::inflate) {


        override fun setlistener() {
            setUpAutoLogin()
      with(binding){
          loginTV1.setOnClickListener {
              findNavController().navigate(R.id.action_welcomeFragment_to_loginFragment)
          }
          RegisterTV1.setOnClickListener {
              findNavController().navigate(R.id.action_welcomeFragment_to_registrationFragment)
          }
      }
    }

    private fun setUpAutoLogin() {
        FirebaseAuth.getInstance().currentUser?.let{
            findNavController().navigate(R.id.action_welcomeFragment_to_userFragment)
        }
    }

    override fun allObserver() {

    }
}

