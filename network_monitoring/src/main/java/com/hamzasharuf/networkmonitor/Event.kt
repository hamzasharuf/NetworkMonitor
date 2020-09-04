package com.hamzasharuf.networkmonitor

sealed class Event {

    class ConnectivityEvent(val isConnected: Boolean) : Event()
}