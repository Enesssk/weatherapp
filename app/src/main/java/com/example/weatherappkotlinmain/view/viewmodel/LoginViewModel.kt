package com.example.weatherappkotlinmain.view.viewmodel

import android.content.Context
import android.view.View
import androidx.lifecycle.ViewModel
import com.example.weatherappkotlinmain.data.repo.LoginRepository

class LoginViewModel : ViewModel() {

    var repo=LoginRepository()

    fun kayitOl(email:String, password:String, mContexT: Context, view: View){
        return repo.kayitOl(email, password, mContexT, view)
    }

    fun girisYap(email:String, password:String, mContexT: Context, view: View){
        return repo.girisYap(email, password, mContexT, view)
    }

    fun cikisYap(view:View){
        repo.cikisYap(view)
    }

}