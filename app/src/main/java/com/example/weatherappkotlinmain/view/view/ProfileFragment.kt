package com.example.weatherappkotlinmain.view.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import com.example.weatherappkotlinmain.R
import com.example.weatherappkotlinmain.databinding.FragmentDetailsBinding
import com.example.weatherappkotlinmain.databinding.FragmentProfileBinding
import com.example.weatherappkotlinmain.view.viewmodel.LoginViewModel

class ProfileFragment : Fragment() {

    private lateinit var binding : FragmentProfileBinding
    private lateinit var viewModel : LoginViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : LoginViewModel by viewModels()
        viewModel=tempViewModel

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentProfileBinding.inflate(inflater,container,false)


        binding.buttonSignOut.setOnClickListener {
            viewModel.cikisYap(it)
        }


        return binding.root
    }


}