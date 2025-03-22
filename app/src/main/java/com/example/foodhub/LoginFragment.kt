package com.example.foodhub

import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.foodhub.databinding.FragmentLoginBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : BasteFragment<FragmentLoginBinding>(FragmentLoginBinding::inflate) {
    private val viewModel: LoginViewModel by viewModels()
    override fun setlistener() {
        with(binding){
            creativTV.setOnClickListener {
                findNavController().navigate(R.id.action_loginFragment_to_registrationFragment)
            }
            loginTV2.setOnClickListener {
               userEmilTV.isEmpty()
                passTV.isEmpty()
                if (!userEmilTV.isEmpty() && !passTV.isEmpty()) {
                    //Toast.makeText(context, "All Input Done.!", Toast.LENGTH_LONG).show()
                    val user = UserLogin(

                        userEmilTV.text.toString(),
                        passTV.text.toString(),

                    )
                    viewModel.userLogin(user)
                }
            }

        }

    }

    override fun allObserver() {
        viewModel.loginRespons.observe(viewLifecycleOwner) {
            when (it) {
                is DataState.Error<*> -> {
                    loader.dismiss()
                    Toast.makeText(context, it.massage, Toast.LENGTH_SHORT).show()
                }

                is DataState.Loding<*> -> {
                    loader.show()
                    Toast.makeText(context, "Lodding...!", Toast.LENGTH_SHORT).show()
                }

                is DataState.Suscess<*> -> {
                    loader.dismiss()
                    Toast.makeText(context, "Created User: ${it.data}", Toast.LENGTH_SHORT).show()
                    findNavController().navigate(R.id.action_loginFragment_to_userFragment)

                }
            }
        }

    }


}