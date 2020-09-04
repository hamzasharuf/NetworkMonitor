package com.hamzasharuf.networkmonitor

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    private var previousSate = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        textView.text = "This view is hooked to network changed using NetworkState and LiveData"

        savedInstanceState?.let {
            previousSate = it.getBoolean("LOST_CONNECTION")
        }

        wifi_off_icon.visibility = if (!ConnectivityStateHolder.isConnected) View.VISIBLE else View.GONE

        NetworkEvents.observe(this, Observer {
            if (it is Event.ConnectivityEvent)
                handleConnectivityChange()
        })

        fab.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putBoolean("LOST_CONNECTION", previousSate)
        super.onSaveInstanceState(outState)
    }

    private fun handleConnectivityChange() {
        if (ConnectivityStateHolder.isConnected && !previousSate) {
            showSnackBar(textView, "The network is back !")
            wifi_off_icon.visibility = View.GONE
        }

        if (!ConnectivityStateHolder.isConnected && previousSate) {
            showSnackBar(textView, "No Network !")
            wifi_off_icon.visibility = View.VISIBLE
        }

        previousSate = ConnectivityStateHolder.isConnected
    }

    override fun onResume() {
        super.onResume()
        handleConnectivityChange()
    }

}


