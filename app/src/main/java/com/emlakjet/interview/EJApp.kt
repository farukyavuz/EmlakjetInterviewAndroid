package com.emlakjet.interview

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.support.multidex.MultiDex


/**
 * Created by farukyavuz on 5.10.2018.
 * Copyright (c) 2018 Hürriyet to present
 * All rights reserved.
 */
class EJApp : Application() {

    init {
        instance = this
    }

    override fun onCreate() {
        super.onCreate()
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }
    companion object {

        private var instance: EJApp? = null
        fun getAppContext(): Context {
            return instance!!.applicationContext
        }

        fun EGAppGetApplication(): Application {
            return instance!!
        }

        fun isNetworkAvailable(): Boolean {
            val connectivityManager = getAppContext().getSystemService(Context.CONNECTIVITY_SERVICE)
            return if (connectivityManager is ConnectivityManager) {
                val networkInfo: NetworkInfo? = connectivityManager.activeNetworkInfo
                networkInfo?.isConnected ?: false
            } else false
        }

    }
}