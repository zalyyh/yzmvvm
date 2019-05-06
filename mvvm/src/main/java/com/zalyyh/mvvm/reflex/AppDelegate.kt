package com.zalyyh.mvvm.reflex

import android.app.Application
import android.content.Context
import com.zalyyh.mvvm.base.GlobalConfigModule
import com.zalyyh.mvvm.reflex.interfaces.AppLifecycles
import com.zalyyh.mvvm.reflex.interfaces.ConfigModule
import com.zalyyh.mvvm.reflex.utlis.ManifestParser
/**
 * ================================================
 * AppDelegate 可以代理 Application 的生命周期,在对应的生命周期,执行对应的逻辑,因为 Java 只能单继承
 * 所以当遇到某些三方库需要继承于它的 Application 的时候,就只有自定义 Application 并继承于三方库的 Application
 * 这时就不用再继承 BaseApplication,只用在自定义Application中对应的生命周期调用AppDelegate对应的方法
 * (Application一定要实现APP接口),框架就能照常运行
 *
 * @see BaseApplication
 * ================================================
 */
class AppDelegate :AppLifecycles {
    private var mAppLifecycles: List<AppLifecycles> = java.util.ArrayList()
    private var mActivityLifecycles: List<Application.ActivityLifecycleCallbacks>? = java.util.ArrayList()

    var mModules:List<ConfigModule>  = ArrayList();
    override fun onCreate(application: Application) {
        val builder = GlobalConfigModule
                .builder()
        for (module in mModules) {
            module.applyOptions(application, builder)
        }

    }

    override fun onLowMemory(application: Application) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onTrimMemory(application: Application) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    constructor(context: Context){
        //用反射, 将 AndroidManifest.xml 中带有 ConfigModule 标签的 class 转成对象集合（List<ConfigModule>）
        mModules = ManifestParser(context).parse()
        //遍历之前获得的集合, 执行每一个 ConfigModule 实现类的某些方法
        for (module in mModules) {

            //将框架外部, 开发者实现的 Application 的生命周期回调 (AppLifecycles) 存入 mAppLifecycles 集合 (此时还未注册回调)
            module.injectAppLifecycle(context, mAppLifecycles)

            //将框架外部, 开发者实现的 Activity 的生命周期回调 (ActivityLifecycleCallbacks) 存入 mActivityLifecycles 集合 (此时还未注册回调)
            //module.injectActivityLifecycle(context, mActivityLifecycles)
        }
    }



    override fun attachBaseContext(bass: Context) {
        //遍历 mAppLifecycles, 执行所有已注册的 AppLifecycles 的 attachBaseContext() 方法 (框架外部, 开发者扩展的逻辑)
        for (lifecycle in mAppLifecycles) {
            lifecycle.attachBaseContext(bass)
        }
    }
}