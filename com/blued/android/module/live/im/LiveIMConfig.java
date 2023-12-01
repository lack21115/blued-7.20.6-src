package com.blued.android.module.live.im;

import com.blued.android.statistics.util.Logger;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/live/im/LiveIMConfig.class */
public class LiveIMConfig {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f11584a = false;
    private static Logger b = new Logger("blued-grpc-live-im");

    public static Logger a() {
        return b;
    }

    public static String a(String str) {
        if (str == null || str.trim().length() <= 0) {
            return "blued-grpc-live-im";
        }
        return "blued-grpc-live-im-" + str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void a(boolean z) {
        f11584a = z;
    }

    public static boolean b() {
        return f11584a;
    }
}
