package com.zalyyh.mvvm.reflex

import android.app.Application
import android.content.Context
import com.zalyyh.mvvm.reflex.interfaces.AppLifecycles

class BaseApplication: Application() {
  private  var mAppDelegate: AppLifecycles? = null
    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        if (mAppDelegate == null)
            this.mAppDelegate = AppDelegate(base)
        this.mAppDelegate!!.attachBaseContext(base)
    }
}