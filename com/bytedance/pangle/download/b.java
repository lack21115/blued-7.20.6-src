package com.bytedance.pangle.download;

import android.os.Handler;
import android.os.Looper;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/pangle/download/b.class */
public class b {
    private static volatile b e;

    /* renamed from: a  reason: collision with root package name */
    final Map<String, Long> f21380a = new ConcurrentHashMap();
    public final Handler b = new Handler(Looper.getMainLooper());

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, Runnable> f21381c = new ConcurrentHashMap();
    final Map<String, Runnable> d = new ConcurrentHashMap();

    private b() {
    }

    public static b a() {
        if (e == null) {
            synchronized (b.class) {
                try {
                    if (e == null) {
                        e = new b();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return e;
    }
}
