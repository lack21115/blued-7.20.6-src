package com.vivo.push;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

/* loaded from: source-8829756-dex2jar.jar:com/vivo/push/m.class */
public final class m {

    /* renamed from: a  reason: collision with root package name */
    private static final Handler f41107a = new Handler(Looper.getMainLooper());
    private static final HandlerThread b;

    /* renamed from: c  reason: collision with root package name */
    private static final Handler f41108c;

    static {
        HandlerThread handlerThread = new HandlerThread("push_client_thread");
        b = handlerThread;
        handlerThread.start();
        f41108c = new n(b.getLooper());
    }

    public static void a(l lVar) {
        if (lVar == null) {
            com.vivo.push.util.p.a("PushClientThread", "client thread error, task is null!");
            return;
        }
        int a2 = lVar.a();
        Message message = new Message();
        message.what = a2;
        message.obj = lVar;
        f41108c.sendMessageDelayed(message, 0L);
    }

    public static void a(Runnable runnable) {
        f41108c.removeCallbacks(runnable);
        f41108c.postDelayed(runnable, 15000L);
    }

    public static void b(Runnable runnable) {
        f41107a.post(runnable);
    }

    public static void c(Runnable runnable) {
        Handler handler = f41108c;
        if (handler != null) {
            handler.post(runnable);
        }
    }
}
