package com.example.weatherappkotlinmain.data.datasource

import android.content.Context
import android.view.View
import android.widget.Toast
import androidx.navigation.Navigation
import com.example.weatherappkotlinmain.view.view.LoginFragmentDirections
import com.example.weatherappkotlinmain.view.view.ProfileFragmentDirections
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginDataSource {

    lateinit var auth:FirebaseAuth

    fun kayitOl(email:String,password:String,mContexT:Context,view: View){

        auth= Firebase.auth

        auth.createUserWithEmailAndPassword(email, password).addOnSuccessListener {

            if(email.isNotEmpty() || password.isNotEmpty()){
                Navigation.findNavController(view).navigate(LoginFragmentDirections.actionLoginFragmentToGoWhereFragment())
            }


        }.addOnFailureListener {
            Toast.makeText(mContexT,"Enter a password or email",Toast.LENGTH_LONG).show()
        }

    }

    fun girisYap(email:String,password:String,mContexT:Context,view: View){
        auth=Firebase.auth

        auth.signInWithEmailAndPassword(email, password).addOnSuccessListener {

            if(email.isNotEmpty() || password.isNotEmpty()){
                Navigation.findNavController(view).navigate(LoginFragmentDirections.actionLoginFragmentToGoWhereFragment())
            }
        }.addOnFailureListener {
            Toast.makeText(mContexT,"Enter a password or email",Toast.LENGTH_LONG).show()
        }

    }

    fun cikisYap(view:View){
        auth=Firebase.auth

        auth.signOut()

        Navigation.findNavController(view).navigate(ProfileFragmentDirections.actionProfileFragmentToLoginFragment())

    }

}