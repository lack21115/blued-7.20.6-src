package com.huawei.agconnect;

import android.content.Context;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/agconnect/AGConnectOptions.class */
public interface AGConnectOptions {
    boolean getBoolean(String str);

    boolean getBoolean(String str, boolean z);

    Context getContext();

    String getIdentifier();

    int getInt(String str);

    int getInt(String str, int i);

    String getPackageName();

    AGCRoutePolicy getRoutePolicy();

    String getString(String str);

    String getString(String str, String str2);
}