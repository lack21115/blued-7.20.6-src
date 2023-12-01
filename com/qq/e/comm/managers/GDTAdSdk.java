package com.qq.e.comm.managers;

import android.content.Context;

/* loaded from: source-8303388-dex2jar.jar:com/qq/e/comm/managers/GDTAdSdk.class */
public class GDTAdSdk {
    public static IGDTAdManager getGDTAdManger() {
        return b.b();
    }

    public static void init(Context context, String str) {
        b.b().a(context, str);
    }
}
