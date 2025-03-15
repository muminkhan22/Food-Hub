package com.example.foodhub

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.foodhub.databinding.FragmentWelcomeBinding




class WelcomeFragment : Fragment() {
    lateinit var binding: FragmentWelcomeBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWelcomeBinding.inflate(inflater, container, false)
       setlistener()
        return binding.root

    }

    private fun setlistener() {
      with(binding){
          loginTV1.setOnClickListener {
              findNavController().navigate(R.id.action_welcomeFragment_to_loginFragment)
          }
          RegisterTV1.setOnClickListener {
              findNavController().navigate(R.id.action_welcomeFragment_to_registrationFragment)
          }
      }
    }
}

