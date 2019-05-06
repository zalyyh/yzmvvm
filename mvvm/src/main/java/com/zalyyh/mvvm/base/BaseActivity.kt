package com.zalyyh.mvvm.base

import android.content.Context
import android.support.v7.app.AppCompatActivity

class BaseActivity : AppCompatActivity() {
    /**此方法会在 onCreate 方法之前调用 ！！！请谨慎使用 */
    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(newBase)
    }

}