package com.tencent.open.utils;

import android.os.AsyncTask;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/open/utils/ThreadManager.class */
public final class ThreadManager {

    /* renamed from: a  reason: collision with root package name */
    private static Handler f38283a;

    /* renamed from: c  reason: collision with root package name */
    private static Handler f38284c;
    private static HandlerThread d;
    private static Handler e;
    private static HandlerThread f;
    private static Object b = new Object();
    public static final Executor NETWORK_EXECUTOR = a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/open/utils/ThreadManager$SerialExecutor.class */
    public static class SerialExecutor implements Executor {

        /* renamed from: a  reason: collision with root package name */
        final Queue<Runnable> f38285a;
        Runnable b;

        private SerialExecutor() {
            this.f38285a = new LinkedList();
        }

        protected void a() {
            synchronized (this) {
                Runnable poll = this.f38285a.poll();
                this.b = poll;
                if (poll != null) {
                    ThreadManager.NETWORK_EXECUTOR.execute(this.b);
                }
            }
        }

        @Override // java.util.concurrent.Executor
        public void execute(final Runnable runnable) {
            synchronized (this) {
                this.f38285a.offer(new Runnable() { // from class: com.tencent.open.utils.ThreadManager.SerialExecutor.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            runnable.run();
                        } finally {
                            SerialExecutor.this.a();
                        }
                    }
                });
                if (this.b == null) {
                    a();
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.util.concurrent.Executor] */
    private static Executor a() {
        ThreadPoolExecutor threadPoolExecutor;
        if (Build.VERSION.SDK_INT >= 11) {
            threadPoolExecutor = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        } else {
            try {
                Field declaredField = AsyncTask.class.getDeclaredField("sExecutor");
                declaredField.setAccessible(true);
                threadPoolExecutor = (Executor) declaredField.get(null);
            } catch (Exception e2) {
                threadPoolExecutor = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue());
            }
        }
        if (threadPoolExecutor instanceof ThreadPoolExecutor) {
            threadPoolExecutor.setCorePoolSize(3);
        }
        return threadPoolExecutor;
    }

    public static void executeOnFileThread(Runnable runnable) {
        getFileThreadHandler().post(runnable);
    }

    public static void executeOnNetWorkThread(Runnable runnable) {
        try {
            NETWORK_EXECUTOR.execute(runnable);
        } catch (RejectedExecutionException e2) {
        }
    }

    public static void executeOnSubThread(Runnable runnable) {
        getSubThreadHandler().post(runnable);
    }

    public static Handler getFileThreadHandler() {
        if (e == null) {
            synchronized (ThreadManager.class) {
                try {
                    HandlerThread handlerThread = new HandlerThread("SDK_FILE_RW");
                    f = handlerThread;
                    handlerThread.start();
                    e = new Handler(f.getLooper());
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return e;
    }

    public static Looper getFileThreadLooper() {
        return getFileThreadHandler().getLooper();
    }

    public static Handler getMainHandler() {
        if (f38283a == null) {
            synchronized (b) {
                if (f38283a == null) {
                    f38283a = new Handler(Looper.getMainLooper());
                }
            }
        }
        return f38283a;
    }

    public static Thread getSubThread() {
        if (d == null) {
            getSubThreadHandler();
        }
        return d;
    }

    public static Handler getSubThreadHandler() {
        if (f38284c == null) {
            synchronized (ThreadManager.class) {
                try {
                    HandlerThread handlerThread = new HandlerThread("SDK_SUB");
                    d = handlerThread;
                    handlerThread.start();
                    f38284c = new Handler(d.getLooper());
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f38284c;
    }

    public static Looper getSubThreadLooper() {
        return getSubThreadHandler().getLooper();
    }

    public static void init() {
    }

    public static Executor newSerialExecutor() {
        return new SerialExecutor();
    }
}
