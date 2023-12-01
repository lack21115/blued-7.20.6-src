package com.blued.android.module.media.selector.utils;

import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/media/selector/utils/ThreadPoolHelper.class */
public class ThreadPoolHelper {
    public static int a = 1;
    private static ThreadPoolHelper b;
    private ThreadPoolExecutor c = new ThreadPoolExecutor(4, 8, 10, TimeUnit.SECONDS, new LinkedBlockingQueue(), new AlbumThreadFactory(), new ThreadPoolExecutor.DiscardPolicy());
    private ThreadPoolExecutor d = new ThreadPoolExecutor(4, 8, 10, TimeUnit.SECONDS, new LinkedBlockingQueue(), new AlbumThreadFactory(), new ThreadPoolExecutor.DiscardPolicy());

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/media/selector/utils/ThreadPoolHelper$AlbumThread.class */
    public static class AlbumThread extends Thread {
        protected boolean a;
        protected boolean b;

        public AlbumThread() {
            super("vr_thread_" + ThreadPoolHelper.a);
            this.a = true;
            this.b = false;
            ThreadPoolHelper.a = ThreadPoolHelper.a + 1;
            this.a = true;
            this.b = false;
        }

        public AlbumThread(Runnable runnable, String str) {
            super(runnable, str);
            this.a = true;
            this.b = false;
            this.a = true;
            this.b = false;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            if (this.a) {
                this.b = false;
                super.run();
                this.b = true;
                ThreadPoolHelper.a--;
            }
        }
    }

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/media/selector/utils/ThreadPoolHelper$AlbumThreadFactory.class */
    class AlbumThreadFactory implements ThreadFactory {
        public AlbumThreadFactory() {
            ThreadPoolHelper.a = 1;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            AlbumThread albumThread = new AlbumThread(runnable, "vr_thread_" + ThreadPoolHelper.a);
            ThreadPoolHelper.a = ThreadPoolHelper.a + 1;
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
        this.c.execute(runnable);
    }

    public Future b(Runnable runnable) {
        return this.d.submit(runnable);
    }
}
