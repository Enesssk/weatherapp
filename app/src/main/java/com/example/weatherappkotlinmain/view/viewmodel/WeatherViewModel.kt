package com.example.weatherappkotlinmain.view.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weatherappkotlinmain.data.model.WeatherModel
import com.example.weatherappkotlinmain.data.repo.WeatherRepository
import com.example.weatherappkotlinmain.data.service.RetrofitAPI
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class WeatherViewModel : ViewModel() {

    var repo=WeatherRepository()
    val compositeDisposable=CompositeDisposable()

    val weatherList=MutableLiveData<WeatherModel>()
    val weatherError=MutableLiveData<Boolean>()
    val weatherLoading=MutableLiveData<Boolean>()


    fun searchWeather(cityName: String){
        getDataFromAPI(cityName)
    }


    fun getDataFromAPI(cityName: String){

        weatherLoading.value=true

        compositeDisposable.add(repo.getData(cityName).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableSingleObserver<WeatherModel>(){
                override fun onSuccess(t: WeatherModel) {
                    weatherError.value=false
                    weatherLoading.value=false
                    weatherList.value=t

                }

                override fun onError(e: Throwable) {
                    weatherError.value=true
                    weatherLoading.value=false
                }

            }))



    }





}