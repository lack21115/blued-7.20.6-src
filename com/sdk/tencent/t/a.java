package com.sdk.tencent.t;

import android.content.Context;
import com.sdk.tencent.f.c;

/* loaded from: source-8303388-dex2jar.jar:com/sdk/tencent/t/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static a f28078a;
    public static String b;

    /* renamed from: c  reason: collision with root package name */
    public static String f28079c;

    static {
        boolean z = c.b;
    }

    public a(Context context) {
    }

    public static a a(Context context) {
        if (f28078a == null) {
            synchronized (a.class) {
                try {
                    f28078a = new a(context);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f28078a;
    }
}
