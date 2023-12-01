package com.soft.blued.utils;

import com.blued.android.core.AppInfo;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/utils/DurationUtils.class */
public class DurationUtils {

    /* renamed from: a  reason: collision with root package name */
    private static long f34738a;

    public static void a() {
        f34738a = System.currentTimeMillis();
    }

    public static void a(String str) {
        if (AppInfo.m()) {
            Logger.c("Timer", str + "任务耗时：" + (System.currentTimeMillis() - f34738a));
        }
    }
}
