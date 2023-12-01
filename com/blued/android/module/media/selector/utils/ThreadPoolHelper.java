package com.blued.android.module.media.selector.utils;

import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/media/selector/utils/ThreadPoolHelper.class */
public class ThreadPoolHelper {

    /* renamed from: a  reason: collision with root package name */
    public static int f15574a = 1;
    private static ThreadPoolHelper b;

    /* renamed from: c  reason: collision with root package name */
    private ThreadPoolExecutor f15575c = new ThreadPoolExecutor(4, 8, 10, TimeUnit.SECONDS, new LinkedBlockingQueue(), new AlbumThreadFactory(), new ThreadPoolExecutor.DiscardPolicy());
    private ThreadPoolExecutor d = new ThreadPoolExecutor(4, 8, 10, TimeUnit.SECONDS, new LinkedBlockingQueue(), new AlbumThreadFactory(), new ThreadPoolExecutor.DiscardPolicy());

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/media/selector/utils/ThreadPoolHelper$AlbumThread.class */
    public static class AlbumThread extends Thread {

        /* renamed from: a  reason: collision with root package name */
        protected boolean f15576a;
        protected boolean b;

        public AlbumThread() {
            super("vr_thread_" + ThreadPoolHelper.f15574a);
            this.f15576a = true;
            this.b = false;
            ThreadPoolHelper.f15574a = ThreadPoolHelper.f15574a + 1;
            this.f15576a = true;
            this.b = false;
        }

        public AlbumThread(Runnable runnable, String str) {
            super(runnable, str);
            this.f15576a = true;
            this.b = false;
            this.f15576a = true;
            this.b = false;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            if (this.f15576a) {
                this.b = false;
                super.run();
                this.b = true;
                ThreadPoolHelper.f15574a--;
            }
        }
    }

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/media/selector/utils/ThreadPoolHelper$AlbumThreadFactory.class */
    class AlbumThreadFactory implements ThreadFactory {
        public AlbumThreadFactory() {
            ThreadPoolHelper.f15574a = 1;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            AlbumThread albumThread = new AlbumThread(runnable, "vr_thread_" + ThreadPoolHelper.f15574a);
            ThreadPoolHelper.f15574a = ThreadPoolHelper.f15574a + 1;
            return albumThread;
        }
    }

    private ThreadPoolHelper() {
    }

    public static ThreadPoolHelper a() {
        if (b == null) {
            synchronized (ThreadPoolHelper.class) {
                try {
                    if (b == null) {
                        b = new ThreadPoolHelper();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return b;
    }

    public void a(Runnable runnable) {
        this.f15575c.execute(runnable);
    }

    public Future b(Runnable runnable) {
        return this.d.submit(runnable);
    }
}
