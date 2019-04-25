package com.zalyyh.yzmvvm;

import android.content.Context;
import android.util.Log;

import com.zalyyh.mvvm.reflex.interfaces.ConfigModule;

import org.jetbrains.annotations.NotNull;

public class GlobalConfiguration implements ConfigModule {
    @Override
    public void applyOptions(@NotNull Context context) {
        Log.e("你好世界","我不好怎么，额");
    }
}
