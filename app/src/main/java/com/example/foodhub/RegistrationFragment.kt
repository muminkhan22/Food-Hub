package com.example.foodhub

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.foodhub.databinding.FragmentRegistrationBinding




class RegistrationFragment : Fragment() {
    lateinit var binding: FragmentRegistrationBinding
    private val viewModel: RegistrationViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentRegistrationBinding.inflate(inflater,container,false)
        setlistener()
        registrationObserver()
        return binding.root
    }
    private fun setlistener() {
        with(binding){
            RrgisTV2.setOnClickListener {
                userNam.isEmpty()
                EmailTV1.isEmpty()
                passTV1.isEmpty()

                if (!userNam.isEmpty() && !EmailTV1.isEmpty() && !passTV1.isEmpty()){
                   Toast.makeText(context,"All Input Done.!",Toast.LENGTH_LONG).show()
                    val user= UserRegistr(
                        userNam.text.toString(),
                        EmailTV1.text.toString(),
                        passTV1.text.toString(),
                        "seller",
                        ""
                        )
                    viewModel.userResistration(user)
                }
            }

        }
    }
    private fun registrationObserver() {
        viewModel.reistrationRespons.observe(viewLifecycleOwner) {
            when(it){
                is DataState.Error<*> -> {
                    Toast.makeText(context,it.massage, Toast.LENGTH_SHORT).show()
                }
                is DataState.Loding<*> -> {
                    Toast.makeText(context,"Lodding...!", Toast.LENGTH_SHORT).show()
                }
                is DataState.Suscess<*> -> {
                    Toast.makeText(context,"Created User: ${it.data}", Toast.LENGTH_SHORT).show()

                }
            }
        }

    }


}