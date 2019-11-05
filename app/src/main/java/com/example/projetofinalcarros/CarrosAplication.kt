package com.example.projetofinalcarros

import android.app.Application
import android.util.Log

class CarrosAplication: Application() {
    private val TAG = "CarrosApplication"

    override fun onCreate() {
        super.onCreate()
        appInstance = this
    }

    companion object{

        private var appInstance:CarrosAplication?=null
        fun getInstance(): CarrosAplication{
            if (appInstance==null){
                throw IllegalStateException("Configure a classe de Application no AndroidManifest.xml")
            }
            return appInstance!!
        }
    }

    override fun onTerminate() {
        super.onTerminate()
        Log.d(TAG, "CarrosApplication.onTerminate")
    }
}