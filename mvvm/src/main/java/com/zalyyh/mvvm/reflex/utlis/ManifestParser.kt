package com.zalyyh.mvvm.reflex.utlis

import android.content.Context
import android.content.pm.PackageManager
import com.zalyyh.mvvm.reflex.interfaces.ConfigModule
/**
 * ================================================
 * 用于解析 AndroidManifest 中的 Meta 属性
 * 配合 {@link ConfigModule} 使用
 * ================================================
 */
class ManifestParser (context:Context) {
    /**
     * meta-data 配置需要的value
     * */
    val MODULE_VALUE:String = "ConfigModule"
    var context:Context = context;
    //获取配置文件里的配置方法
    fun parse():List<ConfigModule>{

       var modules = ArrayList<ConfigModule>()

        var appInfo = context.getPackageManager().getApplicationInfo(
               context.getPackageName(), PackageManager.GET_META_DATA)
        if (appInfo.metaData!=null){
            for (key:String in appInfo.metaData.keySet()){
                if (MODULE_VALUE == appInfo.metaData.get(key)) {
                    modules.add(parseModule(key))
                }
            }
        }
        return modules
    }
    fun parseModule(className:String):ConfigModule{

        val clazz: Class<*>
        try {
            clazz = Class.forName(className)
        } catch (e: ClassNotFoundException) {
            throw IllegalArgumentException("Unable to find ConfigModule implementation", e)
        }


        val module:Object
        try {
            module = clazz.newInstance() as Object
        } catch (e: InstantiationException) {
            throw RuntimeException("Unable to instantiate ConfigModule implementation for $clazz", e)
        } catch (e: IllegalAccessException) {
            throw RuntimeException("Unable to instantiate ConfigModule implementation for $clazz", e)
        }


        if (module !is ConfigModule) {
            throw RuntimeException("Expected instanceof ConfigModule, but found: $module")
        }

        return module as ConfigModule
    }
}


