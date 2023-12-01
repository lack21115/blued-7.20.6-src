package com.tencent.turingface.sdk.mfa;

import android.content.Context;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/turingface/sdk/mfa/i3cNc.class */
public final class i3cNc {

    /* renamed from: a  reason: collision with root package name */
    public static Context f26267a;

    public static Context a() {
        Context context;
        synchronized (i3cNc.class) {
            try {
                context = f26267a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return context;
    }

    public static boolean a(Context context) {
        synchronized (i3cNc.class) {
            try {
                if (f26267a != null) {
                    return true;
                }
                if (context == null) {
                    return false;
                }
                Context applicationContext = context.getApplicationContext();
                if (applicationContext == null) {
                    return false;
                }
                f26267a = applicationContext;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
