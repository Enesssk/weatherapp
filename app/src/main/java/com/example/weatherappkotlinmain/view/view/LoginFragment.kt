package com.example.weatherappkotlinmain.view.view

import android.os.Binder
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels

import androidx.navigation.Navigation
import com.example.weatherappkotlinmain.R
import com.example.weatherappkotlinmain.databinding.FragmentDetailsBinding
import com.example.weatherappkotlinmain.databinding.FragmentLoginBinding
import com.example.weatherappkotlinmain.view.viewmodel.LoginViewModel

class LoginFragment : Fragment() {

    private lateinit var binding : FragmentLoginBinding
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
        binding=FragmentLoginBinding.inflate(inflater,container,false)


        binding.signInButton.setOnClickListener {
           var email=binding.emailText.text.toString()
            var password=binding.passwordText.text.toString()

            if(email.isNotEmpty() || password.isNotEmpty()){
                viewModel.girisYap(email,password,requireContext(),it)
            }

        }
        binding.signUpButton.setOnClickListener {
            var email=binding.emailText.text.toString()
            var password=binding.passwordText.text.toString()

            if(email.isNotEmpty() || password.isNotEmpty()){
                viewModel.kayitOl(email,password,requireContext(),it)
            }

        }

        return binding.root
    }

}