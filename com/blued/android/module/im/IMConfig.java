package com.blued.android.module.im;

import com.blued.android.statistics.util.Logger;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/im/IMConfig.class */
public class IMConfig {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f11331a = false;
    private static Logger b = new Logger("blued-grpc-im");

    public static Logger a() {
        return b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void a(boolean z) {
        f11331a = z;
    }

    public static boolean b() {
        return f11331a;
    }
}
