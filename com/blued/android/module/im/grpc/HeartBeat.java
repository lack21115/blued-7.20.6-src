package com.blued.android.module.im.grpc;

import android.os.Handler;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/im/grpc/HeartBeat.class */
public class HeartBeat {
    private int a;
    private int b;
    private long c;
    private long d;
    private Runnable e;
    private Runnable f;
    private OnBeatListener g;
    private Handler h;

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/im/grpc/HeartBeat$OnBeatListener.class */
    public interface OnBeatListener {
        void a();

        void b();
    }

    public HeartBeat(Handler handler) {
        this(handler, 10000, 30000);
    }

    public HeartBeat(Handler handler, int i, int i2) {
        this.h = handler;
        this.a = i;
        this.b = i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        OnBeatListener onBeatListener = this.g;
        if (onBeatListener != null) {
            onBeatListener.a();
        }
        Runnable runnable = this.e;
        if (runnable != null) {
            this.h.postDelayed(runnable, this.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        long j = this.c - this.d;
        if (j <= 0 || j >= 3000) {
            OnBeatListener onBeatListener = this.g;
            if (onBeatListener != null) {
                onBeatListener.b();
                return;
            }
            return;
        }
        Runnable runnable = this.f;
        if (runnable != null) {
            this.h.removeCallbacks(runnable);
            this.h.postDelayed(this.f, j);
        }
        this.d = this.c;
    }

    public void a() {
        this.g = null;
        Runnable runnable = this.f;
        if (runnable != null) {
            this.h.removeCallbacks(runnable);
        }
        this.f = null;
        Runnable runnable2 = this.e;
        if (runnable2 != null) {
            this.h.removeCallbacks(runnable2);
        }
        this.e = null;
    }

    public void a(OnBeatListener onBeatListener) {
        this.g = onBeatListener;
        if (this.e == null) {
            Runnable runnable = new Runnable() { // from class: com.blued.android.module.im.grpc.HeartBeat.1
                @Override // java.lang.Runnable
                public void run() {
                    HeartBeat.this.b();
                }
            };
            this.e = runnable;
            this.h.postDelayed(runnable, this.a);
        }
        if (this.f != null) {
            Runnable runnable2 = new Runnable() { // from class: com.blued.android.module.im.grpc.HeartBeat.2
                @Override // java.lang.Runnable
                public void run() {
                    HeartBeat.this.c();
                }
            };
            this.f = runnable2;
            this.h.postDelayed(runnable2, this.b);
        }
    }

    public void update() {
        if (this.f != null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.c = currentTimeMillis;
            if (currentTimeMillis - this.d >= 3000) {
                this.h.removeCallbacks(this.f);
                this.h.postDelayed(this.f, this.b);
                this.d = this.c;
            }
        }
    }
}
