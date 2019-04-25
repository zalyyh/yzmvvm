package com.zalyyh.mvvm.reflex

import android.content.Context
import com.zalyyh.mvvm.reflex.interfaces.AppLifecycles
import com.zalyyh.mvvm.reflex.interfaces.ConfigModule
import com.zalyyh.mvvm.reflex.utlis.ManifestParser

class AppDelegate :AppLifecycles {
    private var mAppLifecycles: List<AppLifecycles> = java.util.ArrayList()
    var mModules:List<ConfigModule>  = ArrayList();
    constructor(context: Context){
        mModules = ManifestParser(context).parse()
        for (module:ConfigModule in mModules){
            module.applyOptions(context)
        }
    }

    override fun attachBaseContext(bass: Context) {
        for (lifecycle in mAppLifecycles) {
            lifecycle.attachBaseContext(bass)
        }
    }
}