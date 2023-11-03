package com.example.weatherappkotlinmain.data.repo

import android.content.Context
import android.view.View
import com.example.weatherappkotlinmain.data.datasource.LoginDataSource

class LoginRepository {

        var lds=LoginDataSource()

    fun kayitOl(email:String, password:String, mContexT: Context, view: View){
        lds.kayitOl(email,password, mContexT, view)
    }

    fun girisYap(email:String, password:String, mContexT: Context, view: View){
        lds.girisYap(email,password, mContexT, view)
    }

    fun cikisYap(view:View){
        lds.cikisYap(view)
    }

}