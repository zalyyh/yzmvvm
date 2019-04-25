package com.zalyyh.mvvm.reflex

import android.app.Application
import android.content.Context
import com.zalyyh.mvvm.reflex.interfaces.AppLifecycles

class BaseApplication: Application() {
    //定义一个可以为空的常量
  private  var mAppDelegate: AppLifecycles? = null
    /**
     * 这里会在 {@link BaseApplication#onCreate} 之前被调用,可以做一些较早的初始化
     * 常用于 MultiDex 以及插件化框架的初始化
     *
     * @param base
     */
    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        if (mAppDelegate == null)
            this.mAppDelegate = AppDelegate(base)
        this.mAppDelegate!!.attachBaseContext(base)
    }
}