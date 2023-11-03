package com.example.weatherappkotlinmain.view.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.weatherappkotlinmain.databinding.FragmentEntranceBinding


class EntranceFragment : Fragment() {

    private lateinit var binding: FragmentEntranceBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentEntranceBinding.inflate(inflater,container,false)

     binding.goButton.setOnClickListener {
         Navigation.findNavController(it).navigate(EntranceFragmentDirections.actionEntranceFragmentToLoginFragment())
     }
        return binding.root
    }


}