package com.example.weatherappkotlinmain.view.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.ViewModelProvider
import com.example.weatherappkotlinmain.databinding.FragmentDetailsBinding

import com.example.weatherappkotlinmain.view.viewmodel.WeatherViewModel

class DetailsFragment : Fragment() {

    private lateinit var binding : FragmentDetailsBinding
    private lateinit var viewModel : WeatherViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentDetailsBinding.inflate(inflater,container,false)
        viewModel=ViewModelProvider(requireActivity()).get(WeatherViewModel::class.java)


        observeToResult()

        binding.searchText.addTextChangedListener {
            it?.let {
                var cityName=binding.searchText.text.toString()
                viewModel.searchWeather(cityName) }
            observeToResult()
        }


        return binding.root
    }

    fun observeToResult(){
        viewModel.weatherList.observe(viewLifecycleOwner,{
            it?.let {
                binding.humudity.text="% ${it.main.humidity}"
                binding.maxTemp.text="${it.main.tempMax.toInt()} C°"
                binding.minTemp.text="${it.main.tempMin.toInt()} C°"
                binding.latitudeTextView.text=it.coord.lat.toString()
                binding.longitudeTextView.text=it.coord.lon.toString()
                binding.temp.text="${it.main.temp.toInt()} C°"
                binding.wind.text="${it.wind.speed} km/h"
                binding.cityName.text=it.name
                binding.descriptionText.text=it.weather.get(0).description
                binding.countryName.text=it.sys.country + " /"
                binding.progressBar.visibility=View.GONE

            }

        })

        viewModel.weatherLoading.observe(viewLifecycleOwner,{
            it?.let {
                binding.progressBar.visibility=View.VISIBLE
            }

        })

        viewModel.weatherError.observe(viewLifecycleOwner,{
            it?.let {
                binding.progressBar.visibility=View.GONE
            }

        })

    }


}