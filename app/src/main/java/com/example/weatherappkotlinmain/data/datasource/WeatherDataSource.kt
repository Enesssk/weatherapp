package com.example.weatherappkotlinmain.data.datasource

import com.example.weatherappkotlinmain.data.model.WeatherModel
import com.example.weatherappkotlinmain.data.service.RetrofitAPI
import com.example.weatherappkotlinmain.data.util.util.base_Url
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class WeatherDataSource {


    fun retrofitAPI() : RetrofitAPI{
        return Retrofit.Builder().baseUrl(base_Url).addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build().create(RetrofitAPI::class.java)
    }

    fun getData(cityName:String) : Single<WeatherModel> {
        return retrofitAPI().getData(cityName)
    }


}