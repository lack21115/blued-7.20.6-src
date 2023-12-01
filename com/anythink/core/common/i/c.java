package com.anythink.core.common.i;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/i/c.class */
public class c implements a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f6760a = "TimeOutHandlerImpl";
    private static volatile c b;

    /* renamed from: c  reason: collision with root package name */
    private final Handler f6761c;
    private final Handler d;

    private c() {
        HandlerThread handlerThread = new HandlerThread("timeout_handler_thread");
        handlerThread.start();
        this.d = new Handler(handlerThread.getLooper());
        this.f6761c = new Handler(Looper.getMainLooper());
    }

    private Handler a(boolean z) {
        return z ? this.f6761c : this.d;
    }

    public static a a() {
        if (b == null) {
            synchronized (c.class) {
                try {
                    if (b == null) {
                        b = new c();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return b;
    }

    @Override // com.anythink.core.common.i.a
    public final void a(b bVar) {
        Handler handler = this.f6761c;
        if (handler != null) {
            handler.removeCallbacks(bVar);
        }
        Handler handler2 = this.d;
        if (handler2 != null) {
            handler2.removeCallbacks(bVar);
        }
    }

    @Override // com.anythink.core.common.i.a
    public final void a(b bVar, long j) {
        a(bVar, j, true);
    }

    @Override // com.anythink.core.common.i.a
    public final void a(b bVar, long j, boolean z) {
        StringBuilder sb = new StringBuilder("sendTimeOutMsg() >>> delayMillis=");
        sb.append(j);
        sb.append(" isMainThread=");
        sb.append(z);
        Handler a2 = a(z);
        if (a2 == null) {
            return;
        }
        a2.postDelayed(bVar, j);
    }
}
