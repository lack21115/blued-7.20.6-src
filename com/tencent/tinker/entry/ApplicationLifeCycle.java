package com.tencent.tinker.entry;

import android.content.Context;
import android.content.res.Configuration;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/entry/ApplicationLifeCycle.class */
public interface ApplicationLifeCycle {
    void onBaseContextAttached(Context context);

    void onConfigurationChanged(Configuration configuration);

    void onCreate();

    void onLowMemory();

    void onTerminate();

    void onTrimMemory(int i);
}
