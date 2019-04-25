package com.zalyyh.mvvm.reflex.interfaces

import android.content.Context

interface ConfigModule {
    /**
     * 框架配置
     * */
    fun applyOptions(context: Context);
}