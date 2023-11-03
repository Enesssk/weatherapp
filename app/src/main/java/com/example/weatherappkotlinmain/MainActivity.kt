package com.example.weatherappkotlinmain

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.weatherappkotlinmain.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//937871ce6e334e836aaa378e7e26b614


    }
}