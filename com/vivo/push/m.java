package com.vivo.push;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

/* loaded from: source-8829756-dex2jar.jar:com/vivo/push/m.class */
public final class m {

    /* renamed from: a  reason: collision with root package name */
    private static final Handler f27416a = new Handler(Looper.getMainLooper());
    private static final HandlerThread b;

    /* renamed from: c  reason: collision with root package name */
    private static final Handler f27417c;

    static {
        HandlerThread handlerThread = new HandlerThread("push_client_thread");
        b = handlerThread;
        handlerThread.start();
        f27417c = new n(b.getLooper());
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
        f27417c.sendMessageDelayed(message, 0L);
    }

    public static void a(Runnable runnable) {
        f27417c.removeCallbacks(runnable);
        f27417c.postDelayed(runnable, 15000L);
    }

    public static void b(Runnable runnable) {
        f27416a.post(runnable);
    }

    public static void c(Runnable runnable) {
        Handler handler = f27417c;
        if (handler != null) {
            handler.post(runnable);
        }
    }
}
