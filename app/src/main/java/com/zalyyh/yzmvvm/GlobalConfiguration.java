package com.zalyyh.yzmvvm;

import android.app.Application;
import android.content.Context;
import android.support.v4.app.FragmentManager;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.zalyyh.mvvm.base.GlobalConfigModule;
import com.zalyyh.mvvm.reflex.interfaces.AppLifecycles;
import com.zalyyh.mvvm.reflex.interfaces.ConfigModule;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import timber.log.Timber;

public class GlobalConfiguration implements ConfigModule {
    @Override
    public void applyOptions(@NotNull Context context, @NotNull GlobalConfigModule.Companion.Builder builder) {
        Timber.e("我不好怎么，额");
        Logger.addLogAdapter(new AndroidLogAdapter());
        Timber.plant(new Timber.DebugTree(){
            @Override
            protected void log(int priority, @Nullable String tag, @NotNull String message, @Nullable Throwable t) {
                Logger.log(priority,tag,message,t);
            }
        });
    }


    @Override
    public void injectAppLifecycle(@NotNull Context context, @NotNull List< AppLifecycles> lifecycles) {
        lifecycles.add(new AppLifecyclesImpl());
    }

    @Override
    public void injectActivityLifecycle(@NotNull Context context, @NotNull List<? extends Application.ActivityLifecycleCallbacks> lifecycles) {

    }

    @Override
    public void injectFragmentLifecycle(@NotNull Context context, @NotNull List<? extends FragmentManager.FragmentLifecycleCallbacks> lifecycles) {

    }
}
