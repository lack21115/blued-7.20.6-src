package com.blued.android.core.image.apng.executor;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/image/apng/executor/FrameDecoderExecutor.class */
public class FrameDecoderExecutor {

    /* renamed from: a  reason: collision with root package name */
    private HandlerThread f9546a;
    private Handler b;

    /* renamed from: c  reason: collision with root package name */
    private volatile Looper f9547c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/image/apng/executor/FrameDecoderExecutor$Inner.class */
    public static class Inner {

        /* renamed from: a  reason: collision with root package name */
        static final FrameDecoderExecutor f9548a = new FrameDecoderExecutor();

        private Inner() {
        }
    }

    private FrameDecoderExecutor() {
        this.f9546a = null;
        this.b = null;
        this.f9547c = null;
    }

    public static FrameDecoderExecutor a() {
        return Inner.f9548a;
    }

    public void a(Runnable runnable) {
        b().removeCallbacks(runnable);
    }

    public void a(Runnable runnable, long j) {
        b().postDelayed(runnable, j);
    }

    public Handler b() {
        if (this.b == null) {
            synchronized (Inner.f9548a) {
                if (this.b == null) {
                    HandlerThread handlerThread = new HandlerThread("FrameDecoderExecutor");
                    this.f9546a = handlerThread;
                    handlerThread.start();
                    this.f9547c = this.f9546a.getLooper();
                    this.b = new Handler(this.f9547c);
                }
            }
        }
        return this.b;
    }

    public void b(Runnable runnable) {
        b().post(runnable);
    }

    public boolean c() {
        return Looper.myLooper() == this.f9547c;
    }
}
