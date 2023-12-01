package com.blued.android.module.im;

import com.blued.android.statistics.util.Logger;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/im/IMConfig.class */
public class IMConfig {
    private static boolean a = false;
    private static Logger b = new Logger("blued-grpc-im");

    public static Logger a() {
        return b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void a(boolean z) {
        a = z;
    }

    public static boolean b() {
        return a;
    }
}
