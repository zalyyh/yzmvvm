package com.zalyyh.mvvm.base

import android.app.Application
import android.content.Context
import android.content.res.Configuration
import com.zalyyh.mvvm.reflex.AppDelegate
import com.zalyyh.mvvm.reflex.interfaces.AppLifecycles

class BaseApplication : Application() {
    //定义一个可以为空的常量
    private var mAppDelegate: AppLifecycles? = null

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

    // 程序创建的时候执行
    override fun onCreate() {
        super.onCreate()
    }

    /**
     * 重写方法 : 重写时需要执行父类方法 super.onLowMemory(), 同时根据本应用特点, 释放掉一些不必要的数据;
     * 调用时机 : 在内存不足时会回调该方法;
     * */
    override fun onLowMemory() {
        super.onLowMemory()
    }

    /**
     * 回调时机 : 当 系统决定要清理一个进程不必要的内存时 回调该方法;
     * 清理内存时机 : 后台进程运行时, 当没有足够的内存去保持这些后台进程运行时, 就会进行内存清理;
     * 内存等级 : 每个等级都有一个对应的内存值, 但是这个内存等级的精确值是无法获取的, 因为随时都有新的中间值会累加上去;
     * */
    override fun onTrimMemory(level: Int) {
        super.onTrimMemory(level)
    }
    

}