package com.blued.android.module.media.audio.audio_manager;

import android.os.Looper;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/media/audio/audio_manager/ThreadUtils.class */
public class ThreadUtils {

    /* renamed from: com.blued.android.module.media.audio.audio_manager.ThreadUtils$1  reason: invalid class name */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/media/audio/audio_manager/ThreadUtils$1.class */
    static final class AnonymousClass1 implements BlockingOperation {
    }

    /* renamed from: com.blued.android.module.media.audio.audio_manager.ThreadUtils$1CaughtException  reason: invalid class name */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/media/audio/audio_manager/ThreadUtils$1CaughtException.class */
    class C1CaughtException {
        Exception a;

        C1CaughtException() {
        }
    }

    /* renamed from: com.blued.android.module.media.audio.audio_manager.ThreadUtils$1Result  reason: invalid class name */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/media/audio/audio_manager/ThreadUtils$1Result.class */
    class C1Result {
        public V a;

        C1Result() {
        }
    }

    /* renamed from: com.blued.android.module.media.audio.audio_manager.ThreadUtils$2  reason: invalid class name */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/media/audio/audio_manager/ThreadUtils$2.class */
    static final class AnonymousClass2 implements BlockingOperation {
    }

    /* renamed from: com.blued.android.module.media.audio.audio_manager.ThreadUtils$3  reason: invalid class name */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/media/audio/audio_manager/ThreadUtils$3.class */
    static final class AnonymousClass3 implements Runnable {
        final /* synthetic */ C1Result a;
        final /* synthetic */ Callable b;
        final /* synthetic */ C1CaughtException c;
        final /* synthetic */ CountDownLatch d;

        /* JADX WARN: Type inference failed for: r1v3, types: [V, java.lang.Object] */
        @Override // java.lang.Runnable
        public void run() {
            try {
                this.a.a = this.b.call();
            } catch (Exception e) {
                this.c.a = e;
            }
            this.d.countDown();
        }
    }

    /* renamed from: com.blued.android.module.media.audio.audio_manager.ThreadUtils$4  reason: invalid class name */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/media/audio/audio_manager/ThreadUtils$4.class */
    static final class AnonymousClass4 implements Callable<Void> {
        final /* synthetic */ Runnable a;

        @Override // java.util.concurrent.Callable
        public Void call() {
            this.a.run();
            return null;
        }
    }

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/media/audio/audio_manager/ThreadUtils$BlockingOperation.class */
    public interface BlockingOperation {
    }

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/media/audio/audio_manager/ThreadUtils$ThreadChecker.class */
    public static class ThreadChecker {
        private Thread a = Thread.currentThread();

        public void a() {
            if (this.a == null) {
                this.a = Thread.currentThread();
            }
            if (Thread.currentThread() != this.a) {
                throw new IllegalStateException("Wrong thread");
            }
        }
    }

    public static void a() {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            throw new IllegalStateException("Not on main thread!");
        }
    }
}
