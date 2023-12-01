package com.blued.android.module.shortvideo.utils;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/utils/StvThreadPoolHelper.class */
public class StvThreadPoolHelper {

    /* renamed from: a  reason: collision with root package name */
    public static int f15859a = 1;
    private static StvThreadPoolHelper b;

    /* renamed from: c  reason: collision with root package name */
    private ThreadPoolExecutor f15860c = new ThreadPoolExecutor(4, 8, 10, TimeUnit.SECONDS, new LinkedBlockingQueue(), new StvThreadFactory(), new ThreadPoolExecutor.DiscardPolicy());
    private ThreadPoolExecutor d = new ThreadPoolExecutor(4, 8, 10, TimeUnit.SECONDS, new LinkedBlockingQueue(), new StvThreadFactory(), new ThreadPoolExecutor.DiscardPolicy());

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/utils/StvThreadPoolHelper$StvThread.class */
    public static class StvThread extends Thread {
        protected boolean b;

        /* renamed from: c  reason: collision with root package name */
        protected boolean f15861c;

        public StvThread() {
            super("stv_thread_" + StvThreadPoolHelper.f15859a);
            this.b = true;
            this.f15861c = false;
            StvThreadPoolHelper.f15859a = StvThreadPoolHelper.f15859a + 1;
            this.b = true;
            this.f15861c = false;
        }

        public StvThread(Runnable runnable) {
            super(runnable);
            this.b = true;
            this.f15861c = false;
            this.b = true;
            this.f15861c = false;
        }

        public StvThread(Runnable runnable, String str) {
            super(runnable, str);
            this.b = true;
            this.f15861c = false;
            this.b = true;
            this.f15861c = false;
        }

        public void a() {
            this.b = false;
            this.f15861c = true;
        }

        public boolean b() {
            return this.f15861c;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            if (this.b) {
                this.f15861c = false;
                super.run();
                this.f15861c = true;
                StvThreadPoolHelper.f15859a--;
            }
        }
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/utils/StvThreadPoolHelper$StvThreadFactory.class */
    class StvThreadFactory implements ThreadFactory {
        public StvThreadFactory() {
            StvThreadPoolHelper.f15859a = 1;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            StvThread stvThread = new StvThread(runnable, "stv_thread_" + StvThreadPoolHelper.f15859a);
            StvThreadPoolHelper.f15859a = StvThreadPoolHelper.f15859a + 1;
            return stvThread;
        }
    }

    private StvThreadPoolHelper() {
    }

    public static StvThreadPoolHelper a() {
        if (b == null) {
            synchronized (StvThreadPoolHelper.class) {
                try {
                    if (b == null) {
                        b = new StvThreadPoolHelper();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return b;
    }

    public void a(StvThread stvThread) {
        if (stvThread == null || stvThread.b()) {
            return;
        }
        stvThread.a();
        stvThread.interrupt();
    }

    public void a(Runnable runnable) {
        this.f15860c.execute(runnable);
    }

    public void b(Runnable runnable) {
        this.d.execute(runnable);
    }
}
