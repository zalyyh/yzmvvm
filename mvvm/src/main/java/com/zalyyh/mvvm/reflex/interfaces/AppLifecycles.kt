package com.zalyyh.mvvm.reflex.interfaces

import android.app.Application
import android.content.Context


public interface AppLifecycles {
    abstract fun attachBaseContext(base: Context)

    abstract fun onCreate(application: Application)

    abstract fun onLowMemory(application: Application)
    abstract fun onTrimMemory(application: Application)
}