package com.example.foodhub

import android.app.ProgressDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

@Suppress("DEPRECATION")
abstract class BasteFragment<VB : ViewBinding>(
    private val bindingInflater: (inflater: LayoutInflater) -> VB

): Fragment() {
    private var _binding : VB? =null
    val binding :VB
        get() = _binding as VB
    lateinit var loader: ProgressDialog

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding=bindingInflater.invoke(inflater)
        loader= ProgressDialog(requireContext())

        setlistener()
        allObserver()

        return binding.root
    }
    abstract fun setlistener()
    abstract fun allObserver()
}