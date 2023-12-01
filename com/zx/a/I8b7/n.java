package com.zx.a.I8b7;

import android.content.Context;

/* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/n.class */
public class n {

    /* renamed from: a  reason: collision with root package name */
    public static float f28458a;

    public static int a(Context context, float f) {
        if (f28458a == 0.0f) {
            f28458a = context.getResources().getDisplayMetrics().density;
        }
        return (int) ((f * f28458a) + 0.5f);
    }
}
