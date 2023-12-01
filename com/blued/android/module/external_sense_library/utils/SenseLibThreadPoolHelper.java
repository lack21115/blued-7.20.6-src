package com.blued.android.module.external_sense_library.utils;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/external_sense_library/utils/SenseLibThreadPoolHelper.class */
public class SenseLibThreadPoolHelper {

    /* renamed from: a  reason: collision with root package name */
    public static int f11321a = 1;
    private static SenseLibThreadPoolHelper b;

    /* renamed from: c  reason: collision with root package name */
    private ThreadPoolExecutor f11322c = new ThreadPoolExecutor(2, 2, 10, TimeUnit.SECONDS, new LinkedBlockingQueue(), new SenseLibThreadFactory(), new ThreadPoolExecutor.DiscardPolicy());

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/external_sense_library/utils/SenseLibThreadPoolHelper$SenseLibThread.class */
    public static class SenseLibThread extends Thread {

        /* renamed from: a  reason: collision with root package name */
        protected boolean f11323a;
        protected boolean b;

        public SenseLibThread() {
            super("stv_thread_" + SenseLibThreadPoolHelper.f11321a);
            this.f11323a = true;
            this.b = false;
            SenseLibThreadPoolHelper.f11321a = SenseLibThreadPoolHelper.f11321a + 1;
            this.f11323a = true;
            this.b = false;
        }

        public SenseLibThread(Runnable runnable) {
            super(runnable);
            this.f11323a = true;
            this.b = false;
            this.f11323a = true;
            this.b = false;
        }

        public SenseLibThread(Runnable runnable, String str) {
            super(runnable, str);
            this.f11323a = true;
            this.b = false;
            this.f11323a = true;
            this.b = false;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            if (this.f11323a) {
                this.b = false;
                super.run();
                this.b = true;
                SenseLibThreadPoolHelper.f11321a--;
            }
        }
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/external_sense_library/utils/SenseLibThreadPoolHelper$SenseLibThreadFactory.class */
    class SenseLibThreadFactory implements ThreadFactory {
        public SenseLibThreadFactory() {
            SenseLibThreadPoolHelper.f11321a = 1;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            SenseLibThread senseLibThread = new SenseLibThread(runnable, "stv_thread_" + SenseLibThreadPoolHelper.f11321a);
            SenseLibThreadPoolHelper.f11321a = SenseLibThreadPoolHelper.f11321a + 1;
            return senseLibThread;
        }
    }

    private SenseLibThreadPoolHelper() {
    }

    public static SenseLibThreadPoolHelper a() {
        if (b == null) {
            synchronized (SenseLibThreadPoolHelper.class) {
                try {
                    if (b == null) {
                        b = new SenseLibThreadPoolHelper();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return b;
    }

    public void a(Runnable runnable) {
        this.f11322c.execute(runnable);
    }
}
