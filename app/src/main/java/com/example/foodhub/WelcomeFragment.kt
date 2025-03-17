package com.example.foodhub

import androidx.navigation.fragment.findNavController
import com.example.foodhub.databinding.FragmentWelcomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WelcomeFragment : BasteFragment<FragmentWelcomeBinding>
    (FragmentWelcomeBinding::inflate) {


        override fun setlistener() {
      with(binding){
          loginTV1.setOnClickListener {
              findNavController().navigate(R.id.action_welcomeFragment_to_loginFragment)
          }
          RegisterTV1.setOnClickListener {
              findNavController().navigate(R.id.action_welcomeFragment_to_registrationFragment)
          }
      }
    }

    override fun allObserver() {

    }
}

