package com.igexin.assist.control;

import android.content.Context;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/assist/control/AbstractPushManager.class */
public interface AbstractPushManager {
    String getBrandCode();

    String getToken(Context context);

    boolean isSupport();

    void register(Context context);

    void setSilentTime(Context context, int i, int i2);

    void turnOffPush(Context context);

    void turnOnPush(Context context);

    void unregister(Context context);
}
