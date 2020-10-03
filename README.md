# Network Monitor [![Kotlin Version](https://img.shields.io/badge/kotlin-1.4.01-blue.svg)](https://kotlinlang.org) [![API](https://img.shields.io/badge/API-21%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=21) [![Ktlint](https://camo.githubusercontent.com/5652fd33142bf88d0f46018325126931fe65d01d/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f636f64652532307374796c652d2545322539442541342d4646343038312e737667)](https://github.com/pinterest/ktlint) [![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

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
        registerConnectivityBroadcaster() // Add this line
    }
}
```


## Usage

If you need to set a listener tot he network state, you have two options.

By observing the NetworkEvent LiveData

``` kotlin
NetworkEvents.observe(this, Observer {
            if (it is Event.ConnectivityEvent){
                 if (ConnectivityStateHolder.isConnected)
                    // Do something
            }
        })
```

## 🤝 CONTRIBUTING
### Would you like to contribute code?
1. [Fork NetworkMonitor](https://github.com/hamzasharuf/NetworkMonitor).
2. Create a new branch ([using GitHub](https://help.github.com/articles/creating-and-deleting-branches-within-your-repository/)) or the command `git checkout -b branch-name develop`).
3. [Start a pull request](https://github.com/hamzasharuf/NetworkMonitor/compare). Reference [existing issues](https://github.com/hamzasharuf/NetworkMonitor/issues) when possible.





## License

    Copyright 2020 Hamza Sharaf

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.


