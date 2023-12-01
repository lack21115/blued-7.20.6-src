package com.bytedance.pangle.dex;

import android.os.Build;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/pangle/dex/DirectDex.class */
public class DirectDex {
    static {
        System.loadLibrary("zeus_direct_dex");
        native_init(Build.VERSION.SDK_INT);
    }

    private static native boolean native_init(int i);

    public static native Object native_load_direct_dex(String str);
}
