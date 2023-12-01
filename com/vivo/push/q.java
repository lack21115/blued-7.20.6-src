package com.vivo.push;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

/* loaded from: source-8829756-dex2jar.jar:com/vivo/push/q.class */
public abstract class q {

    /* renamed from: a  reason: collision with root package name */
    protected Context f41115a;
    protected Handler b;

    /* renamed from: c  reason: collision with root package name */
    private final Object f41116c = new Object();

    /* loaded from: source-8829756-dex2jar.jar:com/vivo/push/q$a.class */
    final class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            q.this.b(message);
        }
    }

    public q() {
        HandlerThread handlerThread = new HandlerThread(getClass().getSimpleName(), 1);
        handlerThread.start();
        this.b = new a(handlerThread.getLooper());
    }

    public final void a(Context context) {
        this.f41115a = context;
    }

    public final void a(Message message) {
        synchronized (this.f41116c) {
            if (this.b == null) {
                String simpleName = getClass().getSimpleName();
                com.vivo.push.util.p.e(simpleName, ("Dead worker dropping a message: " + message.what) + " (Thread " + Thread.currentThread().getId() + ")");
            } else {
                this.b.sendMessage(message);
            }
        }
    }

    public abstract void b(Message message);
}
