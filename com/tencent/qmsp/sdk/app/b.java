package com.tencent.qmsp.sdk.app;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.qmsp.sdk.f.h;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qmsp/sdk/app/b.class */
public class b {
    private static final byte[] d = {20, 96, -116, 77, 47, 50, 121};
    private static final byte[] e = {20, 96, -116, 100, 33, 44, 121, -15, 42, 113, -73};
    private static b f;

    /* renamed from: a  reason: collision with root package name */
    private List<HandlerThread> f24828a = new ArrayList();
    private Handler b;

    /* renamed from: c  reason: collision with root package name */
    private Handler f24829c;

    private b() {
        this.b = null;
        this.f24829c = null;
        this.b = a(h.a(d));
        this.f24829c = a(h.a(e));
    }

    private Handler a(String str) {
        HandlerThread handlerThread = new HandlerThread(str);
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper());
        this.f24828a.add(handlerThread);
        return handler;
    }

    public static b e() {
        if (f == null) {
            synchronized (b.class) {
                try {
                    if (f == null) {
                        f = new b();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f;
    }

    public void a(Runnable runnable) {
        this.b.post(runnable);
    }

    public boolean a() {
        for (HandlerThread handlerThread : this.f24828a) {
            if (handlerThread.getName().equalsIgnoreCase(h.a(d))) {
                return handlerThread.isAlive();
            }
        }
        return false;
    }

    public Looper b() {
        return this.f24829c.getLooper();
    }

    public Looper c() {
        return this.b.getLooper();
    }

    public void d() {
        Handler handler = this.b;
        if (handler != null) {
            handler.getLooper().quit();
            this.b = null;
        }
        Handler handler2 = this.f24829c;
        if (handler2 != null) {
            handler2.getLooper().quit();
            this.f24829c = null;
        }
        if (f != null) {
            f = null;
        }
    }
}
