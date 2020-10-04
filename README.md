# Network Monitor
[![Kotlin Version](https://img.shields.io/badge/kotlin-1.4.10-blue.svg)](https://kotlinlang.org) [![API](https://img.shields.io/badge/API-21%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=21) [![Ktlint](https://camo.githubusercontent.com/5652fd33142bf88d0f46018325126931fe65d01d/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f636f64652532307374796c652d2545322539442541342d4646343038312e737667)](https://github.com/hamzasharuf/NetworkMonitor)

Starting from Android Q, Monitoring the network state of the android device became different from the old methods and instead it became dependant on the Callbacks.
For that, Network Monitor was designed as a simple and lightweight library to monitor the network state of your android device which supports all versions of android starting from 21 and afterwords.

## Prerequisites

Add this in your root `build.gradle` file (**not** your module `build.gradle` file):

```gradle
allprojects {
	repositories {
		...
		maven { url 'https://www.jitpack.io' }
	}
}
```

## Dependency

Add this to your module's `build.gradle` file (make sure the version matches the JitPack badge above):

```gradle
dependencies {
	...
	implementation 'com.github.hamzasharuf:NetworkMonitor:1.1'
}
```

## Configuration

This step is mandatory, in order to register the listeners for the network state. Place this  in your app class:

```kotlin
class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()
	// This starts the broadcast of network events to NetworkState and all Activity implementing NetworkConnectivityListener
        registerConnectivityBroadcaster()
    }
}
```


## Usage

If you need to set a listener to the network state, you have two options.

1. By observing the **NetworkEvent** LiveData

``` kotlin
NetworkEvents.observe(this, Observer {
    if (it is Event.ConnectivityEvent) {
        handleConnectivityChange()
    }
})

private fun handleConnectivityChange() {
    if (ConnectivityStateHolder.isConnected) {
        // Network is available
    }

    if (!ConnectivityStateHolder.isConnected && previousSate) {
        // Network is not available
    }
}
```

2. By implementing the **NetworkConnectivityListener**

```kotlin
class MainActivity : AppCompatActivity(), NetworkConnectivityListener {


    override fun networkConnectivityChanged(event: Event) {
        when (event) {
            is Event.ConnectivityEvent -> {
                if (event.isConnected) {
                    // Connected
                } else {
                    // Not Connected
                }
            }
        }
    }
    
    // ...
}
```

To get the network state anywhere you can use the `ConnectivityStateHolder`

```kotlin
if(ConnectivityStateHolder.isConnected){
    // Connected
}
```


## CONTRIBUTING
### Would you like to contribute code?
1. [Fork NetworkMonitor](https://github.com/hamzasharuf/NetworkMonitor).
2. Create a new branch ([using GitHub](https://help.github.com/articles/creating-and-deleting-branches-within-your-repository/)) or the command `git checkout -b branch-name develop`).
3. [Start a pull request](https://github.com/hamzasharuf/NetworkMonitor/compare). Reference [existing issues](https://github.com/hamzasharuf/NetworkMonitor/issues) when possible.



