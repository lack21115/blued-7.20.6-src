package com.soft.blued.bluedBus;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/bluedBus/HandlerPoster.class */
public class HandlerPoster extends Handler implements Poster {

    /* renamed from: a  reason: collision with root package name */
    private final PendingPostQueue f28299a;
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private final BluedBus f28300c;
    private boolean d;

    /* JADX INFO: Access modifiers changed from: protected */
    public HandlerPoster(BluedBus bluedBus, Looper looper, int i) {
        super(looper);
        this.f28300c = bluedBus;
        this.b = i;
        this.f28299a = new PendingPostQueue();
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        try {
            long uptimeMillis = SystemClock.uptimeMillis();
            do {
                PendingPost a2 = this.f28299a.a();
                PendingPost pendingPost = a2;
                if (a2 == null) {
                    synchronized (this) {
                        pendingPost = this.f28299a.a();
                        if (pendingPost == null) {
                            this.d = false;
                            return;
                        }
                    }
                }
                this.f28300c.a(pendingPost);
            } while (SystemClock.uptimeMillis() - uptimeMillis < this.b);
            if (!sendMessage(obtainMessage())) {
                throw new RuntimeException("Could not send handler message");
            }
            this.d = true;
        } finally {
            this.d = false;
        }
    }
}
