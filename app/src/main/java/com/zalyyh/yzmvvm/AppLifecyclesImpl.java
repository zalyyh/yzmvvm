package com.zalyyh.yzmvvm;

import android.app.Application;
import android.content.Context;

import com.zalyyh.mvvm.reflex.interfaces.AppLifecycles;

import org.jetbrains.annotations.NotNull;

import timber.log.Timber;

public class AppLifecyclesImpl implements AppLifecycles {
    @Override
    public void attachBaseContext(@NotNull Context base) {
        Timber.e("11----------------11");
    }

    @Override
    public void onCreate(@NotNull Application application) {
        Timber.e("22----------------11");
    }

    @Override
    public void onLowMemory(@NotNull Application application) {
        Timber.e("33----------------11");
    }

    @Override
    public void onTrimMemory(@NotNull Application application) {
        Timber.e("44----------------11");
    }
}
