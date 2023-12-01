package com.qiniu.pili.droid.streaming;

import a.a.a.a.a.a.h.f;
import a.a.a.a.a.d.c;
import a.a.a.a.a.e.e;
import a.a.a.a.a.k.b;
import android.content.Context;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/streaming/StreamingEnv.class */
public class StreamingEnv {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f14141a = false;
    public static boolean b = true;

    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/streaming/StreamingEnv$a.class */
    public static class a {
    }

    public static void a() {
        if (!f14141a) {
            throw new IllegalStateException("You must initialize StreamingEnv by StreamingEnv#init first!");
        }
    }

    public static void a(Context context, a aVar) {
        e.d.c("StreamingEnv", "init");
        if (f14141a) {
            e.d.d("StreamingEnv", "ignore since had been initialized!");
            return;
        }
        f14141a = true;
        b.a(context);
        a.a.a.a.a.n.b.a(context);
        f.a(context);
        c.a(context);
        a.a.a.a.a.j.a.a().a(context);
        e.d.c("StreamingEnv", "init success !");
    }

    public static boolean b() {
        return b;
    }

    public static void checkAuthentication(PLAuthenticationResultCallback pLAuthenticationResultCallback) {
        if (f14141a) {
            a.a.a.a.a.n.b.a().a(pLAuthenticationResultCallback);
        } else {
            e.d.e("StreamingEnv", "Should StreamingEnv.init first!");
        }
    }

    public static void init(Context context) {
        a(context, null);
    }

    public static void setLogLevel(int i) {
        e.a(i);
    }

    public static void setNeedLoadSO(boolean z) {
        b = z;
    }
}
