package com.blued.android.module.live.im;

import com.android.internal.content.NativeLibraryHelper;
import com.blued.android.statistics.util.Logger;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/live/im/LiveIMConfig.class */
public class LiveIMConfig {
    private static boolean a = false;
    private static Logger b = new Logger("blued-grpc-live-im");

    public static Logger a() {
        return b;
    }

    public static String a(String str) {
        if (str == null || str.trim().length() <= 0) {
            return "blued-grpc-live-im";
        }
        return "blued-grpc-live-im" + NativeLibraryHelper.CLEAR_ABI_OVERRIDE + str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void a(boolean z) {
        a = z;
    }

    public static boolean b() {
        return a;
    }
}
