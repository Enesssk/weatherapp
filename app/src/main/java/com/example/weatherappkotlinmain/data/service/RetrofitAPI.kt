package com.example.weatherappkotlinmain.data.service

import com.example.weatherappkotlinmain.data.model.WeatherModel
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitAPI {

    //https://api.openweathermap.org/data/2.5/weather?lat=44.34&lon=10.99&appid=937871ce6e334e836aaa378e7e26b614

    @GET("data/2.5/weather?&units=metric&appid=937871ce6e334e836aaa378e7e26b614")
    fun getData(
        @Query("q") cityName : String)
    : Single<WeatherModel>


}