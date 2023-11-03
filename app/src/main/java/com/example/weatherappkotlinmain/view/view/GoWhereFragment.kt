package com.example.weatherappkotlinmain.view.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.weatherappkotlinmain.R
import com.example.weatherappkotlinmain.databinding.FragmentGoWhereBinding
import com.example.weatherappkotlinmain.databinding.FragmentLoginBinding

class GoWhereFragment : Fragment() {

    private lateinit var binding : FragmentGoWhereBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentGoWhereBinding.inflate(inflater,container,false)


        binding.searchScreenImage.setOnClickListener {
            Navigation.findNavController(it).navigate(GoWhereFragmentDirections.actionGoWhereFragmentToDetailsFragment())
        }

        binding.profileImage.setOnClickListener {
           Navigation.findNavController(it).navigate(GoWhereFragmentDirections.actionGoWhereFragmentToProfileFragment())
        }

        return binding.root
    }


}