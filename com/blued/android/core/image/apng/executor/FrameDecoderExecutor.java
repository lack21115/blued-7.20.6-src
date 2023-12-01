package com.blued.android.core.image.apng.executor;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/image/apng/executor/FrameDecoderExecutor.class */
public class FrameDecoderExecutor {
    private HandlerThread a;
    private Handler b;
    private volatile Looper c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/image/apng/executor/FrameDecoderExecutor$Inner.class */
    public static class Inner {
        static final FrameDecoderExecutor a = new FrameDecoderExecutor();

        private Inner() {
        }
    }

    private FrameDecoderExecutor() {
        this.a = null;
        this.b = null;
        this.c = null;
    }

    public static FrameDecoderExecutor a() {
        return Inner.a;
    }

    public void a(Runnable runnable) {
        b().removeCallbacks(runnable);
    }

    public void a(Runnable runnable, long j) {
        b().postDelayed(runnable, j);
    }

    public Handler b() {
        if (this.b == null) {
            synchronized (Inner.a) {
                if (this.b == null) {
                    HandlerThread handlerThread = new HandlerThread("FrameDecoderExecutor");
                    this.a = handlerThread;
                    handlerThread.start();
                    this.c = this.a.getLooper();
                    this.b = new Handler(this.c);
                }
            }
        }
        return this.b;
    }

    public void b(Runnable runnable) {
        b().post(runnable);
    }

    public boolean c() {
        return Looper.myLooper() == this.c;
    }
}
