package com.zalyyh.mvvm.base

import android.app.Activity
import android.app.Application

/**
 * ————————————————————————————————
 * 用于管理所有 {@link Activity}, 和在前台的 {@link Activity}
 * Date: 2019/4/28 10:32 AM
 * ————————————————————————————————
 */
class AppManager {
    @Volatile
    private var sAppManager: AppManager? = null
    private var mApplication: Application? = null
    /**
     * 管理所有存活的 Activity, 容器中的顺序仅仅是 Activity 的创建顺序, 并不能保证和 Activity 任务栈顺序一致
     */
    private var mActivityList: List<Activity>? = null
    /**
     * 当前在前台的 Activity
     */
    private var mCurrentActivity: Activity? = null
    /**
     * ————————————————————————————————
     * 单例 用于获取管理对象
     * Date: 2019/4/28 10:58 AM
     * ————————————————————————————————
     */
    fun getAppManager(): AppManager? {
        if (sAppManager == null) {
            synchronized(AppManager::class.java) {
                if (sAppManager == null) {
                    sAppManager = AppManager()
                }
            }
        }
        return sAppManager!!
    }

    /**
     * 获取最近启动的一个 [Activity], 此方法不保证获取到的 [Activity] 正处于前台可见状态
     * 即使 App 进入后台或在这个 [Activity] 中打开一个之前已经存在的 [Activity], 这时调用此方法
     * 还是会返回这个最近启动的 [Activity], 因此基本不会出现 `null` 的情况
     * 比较适合大部分的使用场景, 如 startActivity
     */
    fun getTopActivity(): Activity? {
        if (mActivityList == null) {
//            Timber.tag(TAG).w("mActivityList == null when getTopActivity()")
            return null
        }
        return if (mActivityList!!.size > 0) mActivityList!!.get(mActivityList!!.size - 1) else null
    }


}