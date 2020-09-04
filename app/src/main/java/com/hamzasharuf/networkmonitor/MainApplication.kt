package com.hamzasharuf.networkmonitor

import android.app.Application
import com.hamzasharuf.networkmonitor.ConnectivityStateHolder.registerConnectivityBroadcaster

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        registerConnectivityBroadcaster()
    }
}