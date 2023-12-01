package com.amap.api.col.p0003sl;

import android.text.TextUtils;
import java.lang.Thread;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* renamed from: com.amap.api.col.3sl.la  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/la.class */
public final class la implements ThreadFactory {
    private static final int k;
    private static final int l;
    private static final int m;

    /* renamed from: a  reason: collision with root package name */
    private final AtomicLong f5351a;
    private final ThreadFactory b;

    /* renamed from: c  reason: collision with root package name */
    private final Thread.UncaughtExceptionHandler f5352c;
    private final String d;
    private final Integer e;
    private final Boolean f;
    private final int g;
    private final int h;
    private final BlockingQueue<Runnable> i;
    private final int j;

    /* renamed from: com.amap.api.col.3sl.la$a */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/la$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private ThreadFactory f5354a;
        private Thread.UncaughtExceptionHandler b;

        /* renamed from: c  reason: collision with root package name */
        private String f5355c;
        private Integer d;
        private Boolean e;
        private int f = la.l;
        private int g = la.m;
        private int h = 30;
        private BlockingQueue<Runnable> i;

        private void c() {
            this.f5354a = null;
            this.b = null;
            this.f5355c = null;
            this.d = null;
            this.e = null;
        }

        public final a a() {
            this.f = 1;
            return this;
        }

        public final a a(int i) {
            if (this.f > 0) {
                this.g = i;
                return this;
            }
            throw new NullPointerException("corePoolSize  must > 0!");
        }

        public final a a(String str) {
            if (str != null) {
                this.f5355c = str;
                return this;
            }
            throw new NullPointerException("Naming pattern must not be null!");
        }

        public final a a(BlockingQueue<Runnable> blockingQueue) {
            this.i = blockingQueue;
            return this;
        }

        public final la b() {
            la laVar = new la(this, (byte) 0);
            c();
            return laVar;
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        k = availableProcessors;
        l = Math.max(2, Math.min(availableProcessors - 1, 4));
        m = (k * 2) + 1;
    }

    private la(a aVar) {
        if (aVar.f5354a == null) {
            this.b = Executors.defaultThreadFactory();
        } else {
            this.b = aVar.f5354a;
        }
        int i = aVar.f;
        this.g = i;
        int i2 = m;
        this.h = i2;
        if (i2 < i) {
            throw new NullPointerException("maxPoolSize must > corePoolSize!");
        }
        this.j = aVar.h;
        if (aVar.i == null) {
            this.i = new LinkedBlockingQueue(256);
        } else {
            this.i = aVar.i;
        }
        if (TextUtils.isEmpty(aVar.f5355c)) {
            this.d = "amap-threadpool";
        } else {
            this.d = aVar.f5355c;
        }
        this.e = aVar.d;
        this.f = aVar.e;
        this.f5352c = aVar.b;
        this.f5351a = new AtomicLong();
    }

    /* synthetic */ la(a aVar, byte b) {
        this(aVar);
    }

    private ThreadFactory g() {
        return this.b;
    }

    private String h() {
        return this.d;
    }

    private Boolean i() {
        return this.f;
    }

    private Integer j() {
        return this.e;
    }

    private Thread.UncaughtExceptionHandler k() {
        return this.f5352c;
    }

    public final int a() {
        return this.g;
    }

    public final int b() {
        return this.h;
    }

    public final BlockingQueue<Runnable> c() {
        return this.i;
    }

    public final int d() {
        return this.j;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(final Runnable runnable) {
        new Runnable() { // from class: com.amap.api.col.3sl.la.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    runnable.run();
                } catch (Throwable th) {
                }
            }
        };
        Thread newThread = g().newThread(runnable);
        if (h() != null) {
            long incrementAndGet = this.f5351a.incrementAndGet();
            newThread.setName(String.format(h() + "-%d", Long.valueOf(incrementAndGet)));
        }
        if (k() != null) {
            newThread.setUncaughtExceptionHandler(k());
        }
        if (j() != null) {
            newThread.setPriority(j().intValue());
        }
        if (i() != null) {
            newThread.setDaemon(i().booleanValue());
        }
        return newThread;
    }
}
