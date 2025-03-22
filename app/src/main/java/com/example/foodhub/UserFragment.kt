package com.example.foodhub

import androidx.navigation.fragment.findNavController
import com.example.foodhub.databinding.FragmentUserBinding
import com.google.firebase.auth.FirebaseAuth
import javax.inject.Inject


class UserFragment : BasteFragment<FragmentUserBinding>(FragmentUserBinding::inflate) {

    @Inject
    lateinit var mumin: FirebaseAuth
    override fun setlistener() {
        with(binding){
            logout.setOnClickListener {
                mumin.signOut()
                findNavController().navigate(R.id.action_userFragment_to_welcomeFragment)

            }
        }

    }

    override fun allObserver() {

    }
}