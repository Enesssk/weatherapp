package com.example.weatherappkotlinmain.data.repo

import com.example.weatherappkotlinmain.data.datasource.WeatherDataSource
import com.example.weatherappkotlinmain.data.model.WeatherModel
import io.reactivex.Single

class WeatherRepository {

    val wds=WeatherDataSource()


    fun getData(cityName:String) : Single<WeatherModel> {
        return wds.getData(cityName)
    }


}