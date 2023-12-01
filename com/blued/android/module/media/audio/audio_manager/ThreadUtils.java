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

        /* renamed from: a  reason: collision with root package name */
        Exception f15522a;

        C1CaughtException() {
        }
    }

    /* renamed from: com.blued.android.module.media.audio.audio_manager.ThreadUtils$1Result  reason: invalid class name */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/media/audio/audio_manager/ThreadUtils$1Result.class */
    class C1Result {

        /* renamed from: a  reason: collision with root package name */
        public V f15523a;

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

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C1Result f15524a;
        final /* synthetic */ Callable b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ C1CaughtException f15525c;
        final /* synthetic */ CountDownLatch d;

        /* JADX WARN: Type inference failed for: r1v3, types: [V, java.lang.Object] */
        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f15524a.f15523a = this.b.call();
            } catch (Exception e) {
                this.f15525c.f15522a = e;
            }
            this.d.countDown();
        }
    }

    /* renamed from: com.blued.android.module.media.audio.audio_manager.ThreadUtils$4  reason: invalid class name */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/media/audio/audio_manager/ThreadUtils$4.class */
    static final class AnonymousClass4 implements Callable<Void> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Runnable f15526a;

        @Override // java.util.concurrent.Callable
        public Void call() {
            this.f15526a.run();
            return null;
        }
    }

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/media/audio/audio_manager/ThreadUtils$BlockingOperation.class */
    public interface BlockingOperation {
    }

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/media/audio/audio_manager/ThreadUtils$ThreadChecker.class */
    public static class ThreadChecker {

        /* renamed from: a  reason: collision with root package name */
        private Thread f15527a = Thread.currentThread();

        public void a() {
            if (this.f15527a == null) {
                this.f15527a = Thread.currentThread();
            }
            if (Thread.currentThread() != this.f15527a) {
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
