package com.alibaba.mtl.log.e;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.alibaba.mtl.appmonitor.AppMonitor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/mtl/log/e/r.class */
public class r {
    private static int F = 1;
    private static int G = 2;
    private static int H = 10;
    private static int I = 60;

    /* renamed from: a  reason: collision with root package name */
    public static r f4501a;

    /* renamed from: a  reason: collision with other field name */
    private static ThreadPoolExecutor f40a;
    private static final AtomicInteger f = new AtomicInteger();
    private HandlerThread b;
    private Handler mHandler;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-6737240-dex2jar.jar:com/alibaba/mtl/log/e/r$a.class */
    public static class a implements ThreadFactory {
        private int priority;

        public a(int i) {
            this.priority = i;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            int andIncrement = r.f.getAndIncrement();
            Thread thread = new Thread(runnable, "AppMonitor:" + andIncrement);
            thread.setPriority(this.priority);
            return thread;
        }
    }

    private r() {
        HandlerThread handlerThread = new HandlerThread(AppMonitor.TAG);
        this.b = handlerThread;
        handlerThread.start();
        this.mHandler = new Handler(this.b.getLooper()) { // from class: com.alibaba.mtl.log.e.r.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                try {
                    if (message.obj == null || !(message.obj instanceof Runnable)) {
                        return;
                    }
                    r.b().submit((Runnable) message.obj);
                } catch (Throwable th) {
                }
            }
        };
    }

    public static r a() {
        r rVar;
        synchronized (r.class) {
            try {
                if (f4501a == null) {
                    f4501a = new r();
                }
                rVar = f4501a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return rVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    private static ThreadPoolExecutor m2193a() {
        ThreadPoolExecutor threadPoolExecutor;
        synchronized (r.class) {
            try {
                if (f40a == null) {
                    f40a = a(F, G, H, I, 500);
                }
                threadPoolExecutor = f40a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return threadPoolExecutor;
    }

    private static ThreadPoolExecutor a(int i, int i2, int i3, int i4, int i5) {
        return new ThreadPoolExecutor(i2, i3, i4, TimeUnit.SECONDS, i5 > 0 ? new LinkedBlockingQueue(i5) : new LinkedBlockingQueue(), new a(i), new ThreadPoolExecutor.DiscardOldestPolicy());
    }

    static /* synthetic */ ThreadPoolExecutor b() {
        return m2193a();
    }

    public final void a(int i, Runnable runnable, long j) {
        try {
            Message obtain = Message.obtain(this.mHandler, i);
            obtain.obj = runnable;
            this.mHandler.sendMessageDelayed(obtain, j);
        } catch (Exception e) {
            com.alibaba.mtl.appmonitor.b.b.m2144a((Throwable) e);
        }
    }

    public void b(Runnable runnable) {
        try {
            m2193a().submit(runnable);
        } catch (Throwable th) {
        }
    }

    public final boolean b(int i) {
        return this.mHandler.hasMessages(i);
    }

    public final void f(int i) {
        this.mHandler.removeMessages(i);
    }
}
