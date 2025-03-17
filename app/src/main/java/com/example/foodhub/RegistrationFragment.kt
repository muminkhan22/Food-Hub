package com.example.foodhub


import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.foodhub.databinding.FragmentRegistrationBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegistrationFragment : BasteFragment<FragmentRegistrationBinding>
    (FragmentRegistrationBinding::inflate) {

    private val viewModel: RegistrationViewModel by viewModels()

    override fun setlistener() {
        with(binding) {
            RrgisTV2.setOnClickListener {
                userNam.isEmpty()
                EmailTV1.isEmpty()
                passTV1.isEmpty()

                if (!userNam.isEmpty() && !EmailTV1.isEmpty() && !passTV1.isEmpty()) {
                    Toast.makeText(context, "All Input Done.!", Toast.LENGTH_LONG).show()
                    val user = UserRegistr(
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

    override fun allObserver() {
        registrationObserver()
    }

    fun registrationObserver() {
        viewModel.reistrationRespons.observe(viewLifecycleOwner) {
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

                }
            }
        }
    }
}