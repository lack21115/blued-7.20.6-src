package com.soft.blued.utils.third;

import android.content.Context;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdSdk;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/utils/third/TTAdManagerHolder.class */
public class TTAdManagerHolder {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f34844a;

    public static TTAdManager a(Context context) {
        if (!f34844a) {
            c(context);
        }
        return TTAdSdk.getAdManager();
    }

    public static void b(Context context) {
        c(context);
    }

    private static void c(Context context) {
        if (f34844a) {
            return;
        }
        TTADUtils.a(context);
        f34844a = true;
    }
}
