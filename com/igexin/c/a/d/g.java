package com.igexin.c.a.d;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.PowerManager;
import com.igexin.push.c.c.o;
import com.igexin.push.f.n;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/c/a/d/g.class */
public class g extends BroadcastReceiver implements Comparator<f> {
    protected static final String E = "AlarmTaskSchedule.";
    protected static final String F = "AlarmTaskScheduleBak.";
    protected static final String G = "AlarmNioTaskSchedule.";
    public static final String h = "TaskService";
    static final byte j = -1;
    static final byte k = 0;
    static final byte l = 1;
    static final byte m = 2;
    static final byte n = Byte.MIN_VALUE;
    static final byte o = 7;
    public String A;
    volatile long B;
    public volatile boolean C;
    public PowerManager u;
    public AlarmManager v;
    public Intent w;
    public PendingIntent x;
    public Intent y;
    public PendingIntent z;
    public static final String i = g.class.getName();
    public static final long D = TimeUnit.SECONDS.toMillis(2);
    final ReentrantLock t = new ReentrantLock();
    public boolean H = false;
    final HashMap<Long, com.igexin.c.a.d.a.c> q = new HashMap<>(7);
    public final e<f> s = new e<>(this, this);
    final d r = new d();
    public final b p = new b();

    /* renamed from: com.igexin.c.a.d.g$1  reason: invalid class name */
    /* loaded from: source-7994992-dex2jar.jar:com/igexin/c/a/d/g$1.class */
    public final class AnonymousClass1 extends IntentFilter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f23270a;

        public AnonymousClass1(Context context) {
            this.f23270a = context;
            addAction(g.E + this.f23270a.getPackageName());
            addAction(g.F + this.f23270a.getPackageName());
            addAction(Intent.ACTION_SCREEN_OFF);
            addAction(Intent.ACTION_SCREEN_ON);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/igexin/c/a/d/g$a.class */
    public final class a {
        volatile int g;

        /* renamed from: c  reason: collision with root package name */
        final ReentrantLock f23272c = new ReentrantLock();

        /* renamed from: a  reason: collision with root package name */
        final BlockingQueue<f> f23271a = new SynchronousQueue();
        final HashMap<Integer, RunnableC0447a> b = new HashMap<>();
        volatile long e = TimeUnit.SECONDS.toNanos(60);
        volatile int f = 0;
        ThreadFactory d = new b();
        volatile int h = Integer.MAX_VALUE;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.igexin.c.a.d.g$a$a  reason: collision with other inner class name */
        /* loaded from: source-7994992-dex2jar.jar:com/igexin/c/a/d/g$a$a.class */
        public final class RunnableC0447a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final BlockingQueue<f> f23273a = new LinkedBlockingQueue();
            f b;

            /* renamed from: c  reason: collision with root package name */
            f f23274c;
            volatile int d;
            volatile boolean e;

            public RunnableC0447a(f fVar) {
                this.b = fVar;
            }

            private void a() {
                this.f23273a.clear();
                this.f23274c = null;
            }

            private void a(f fVar) {
                if (this.d == 0) {
                    this.d = fVar.C;
                }
                boolean z = true;
                while (z) {
                    try {
                        try {
                            fVar.b_();
                            fVar.n();
                            if (!fVar.v) {
                                fVar.d_();
                            }
                            boolean z2 = fVar.m;
                            boolean z3 = fVar.p;
                            long j = fVar.w;
                        } catch (Exception e) {
                            com.igexin.c.a.c.a.a(e);
                            com.igexin.c.a.c.a.a(g.h + e.toString(), new Object[0]);
                            fVar.v = true;
                            fVar.E = e;
                            fVar.o();
                            fVar.k();
                            g.this.a((Object) fVar);
                            g.this.e();
                            if (!fVar.v) {
                                fVar.d_();
                            }
                            boolean z4 = fVar.m;
                            boolean z5 = fVar.p;
                            long j2 = fVar.w;
                            if (!fVar.m && fVar.p && fVar.w != 0) {
                            }
                        }
                    } finally {
                    }
                    if (!fVar.m && fVar.p && fVar.w != 0) {
                    }
                    fVar = null;
                    z = false;
                }
            }

            private f b() {
                f poll;
                while (this.d != 0) {
                    try {
                        poll = this.f23273a.poll(a.this.e, TimeUnit.NANOSECONDS);
                    } catch (InterruptedException e) {
                        com.igexin.c.a.c.a.a(e);
                    }
                    if (poll != null) {
                        return poll;
                    }
                    if (this.f23273a.isEmpty()) {
                        ReentrantLock reentrantLock = a.this.f23272c;
                        reentrantLock.lock();
                        if (this.f23273a.isEmpty()) {
                            a.this.b.remove(Integer.valueOf(this.d));
                            this.d = 0;
                            reentrantLock.unlock();
                            return null;
                        }
                        reentrantLock.unlock();
                    } else {
                        continue;
                    }
                }
                return null;
            }

            @Override // java.lang.Runnable
            public final void run() {
                boolean a2;
                boolean z = true;
                while (z) {
                    try {
                        try {
                            f fVar = this.b;
                            this.b = null;
                            while (true) {
                                f fVar2 = fVar;
                                if (fVar == null) {
                                    f b = b();
                                    fVar2 = b;
                                    if (b == null) {
                                        fVar2 = a.this.b();
                                        if (fVar2 == null) {
                                            a2 = a.this.a(this);
                                            z = a2;
                                            if (!a2) {
                                            }
                                        }
                                    }
                                }
                                this.f23274c = null;
                                if (this.d == 0) {
                                    this.d = fVar2.C;
                                }
                                f fVar3 = fVar2;
                                boolean z2 = true;
                                while (z2) {
                                    try {
                                        try {
                                            fVar3.b_();
                                            fVar3.n();
                                            if (!fVar3.v) {
                                                fVar3.d_();
                                            }
                                            boolean z3 = fVar3.m;
                                            boolean z4 = fVar3.p;
                                            long j = fVar3.w;
                                        } catch (Exception e) {
                                            com.igexin.c.a.c.a.a(e);
                                            com.igexin.c.a.c.a.a(g.h + e.toString(), new Object[0]);
                                            fVar3.v = true;
                                            fVar3.E = e;
                                            fVar3.o();
                                            fVar3.k();
                                            g.this.a((Object) fVar3);
                                            g.this.e();
                                            if (!fVar3.v) {
                                                fVar3.d_();
                                            }
                                            boolean z5 = fVar3.m;
                                            boolean z6 = fVar3.p;
                                            long j2 = fVar3.w;
                                            if (!fVar3.m && fVar3.p && fVar3.w != 0) {
                                            }
                                        }
                                    } catch (Throwable th) {
                                        if (!fVar3.v) {
                                            fVar3.d_();
                                        }
                                        boolean z7 = fVar3.m;
                                        boolean z8 = fVar3.p;
                                        long j3 = fVar3.w;
                                        if (fVar3.m || !fVar3.p || fVar3.w == 0) {
                                            throw th;
                                            break;
                                        }
                                    }
                                    if (!fVar3.m && fVar3.p && fVar3.w != 0) {
                                    }
                                    fVar3 = null;
                                    z2 = false;
                                }
                                this.f23274c = fVar2;
                                fVar = null;
                            }
                            throw th;
                            break;
                            break;
                        } catch (Exception e2) {
                            com.igexin.c.a.c.a.a(e2);
                            com.igexin.c.a.c.a.a("TaskService|Worker|run()|error" + e2.toString(), new Object[0]);
                            a2 = a.this.a(this);
                            z = a2;
                            if (!a2) {
                                z = a2;
                                a();
                            }
                        }
                    } catch (Throwable th2) {
                        if (!a.this.a(this)) {
                            a();
                        }
                        throw th2;
                    }
                }
            }
        }

        /* loaded from: source-7994992-dex2jar.jar:com/igexin/c/a/d/g$a$b.class */
        final class b implements ThreadFactory {

            /* renamed from: a  reason: collision with root package name */
            final AtomicInteger f23275a = new AtomicInteger(0);

            public b() {
            }

            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return new Thread(runnable, "TS-pool-" + this.f23275a.incrementAndGet());
            }
        }

        public a() {
        }

        private void c(f fVar) {
            if (fVar == null) {
                throw null;
            }
            if (fVar.C != 0) {
                ReentrantLock reentrantLock = this.f23272c;
                reentrantLock.lock();
                try {
                    RunnableC0447a runnableC0447a = this.b.get(Integer.valueOf(fVar.C));
                    if (runnableC0447a != null) {
                        runnableC0447a.f23273a.offer(fVar);
                        return;
                    }
                } finally {
                    reentrantLock.unlock();
                }
            }
            if (this.g >= this.f || !a(fVar)) {
                if (!this.f23271a.offer(fVar)) {
                    b(fVar);
                } else if (this.g == 0) {
                    a();
                }
            }
        }

        private void d(f fVar) {
            if (this.g >= this.f || !a(fVar)) {
                if (!this.f23271a.offer(fVar)) {
                    if (!b(fVar)) {
                    }
                } else if (this.g == 0) {
                    a();
                }
            }
        }

        private Thread e(f fVar) {
            RunnableC0447a runnableC0447a = new RunnableC0447a(fVar);
            if (fVar != null && fVar.C != 0) {
                this.b.put(Integer.valueOf(fVar.C), runnableC0447a);
            }
            Thread newThread = this.d.newThread(runnableC0447a);
            if (newThread != null) {
                this.g++;
            }
            return newThread;
        }

        final void a() {
            ReentrantLock reentrantLock = this.f23272c;
            reentrantLock.lock();
            try {
                Thread thread = null;
                if (this.g < Math.max(this.f, 1)) {
                    thread = null;
                    if (!this.f23271a.isEmpty()) {
                        thread = e(null);
                    }
                }
                reentrantLock.unlock();
                if (thread != null) {
                    thread.start();
                }
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }

        final boolean a(f fVar) {
            ReentrantLock reentrantLock = this.f23272c;
            reentrantLock.lock();
            try {
                Thread e = this.g < this.f ? e(fVar) : null;
                reentrantLock.unlock();
                if (e == null) {
                    return false;
                }
                e.start();
                return true;
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }

        final boolean a(RunnableC0447a runnableC0447a) {
            ReentrantLock reentrantLock = this.f23272c;
            reentrantLock.lock();
            try {
                int i = this.g - 1;
                this.g = i;
                if (i == 0 && !this.f23271a.isEmpty()) {
                    Thread e = e(null);
                    if (e != null) {
                        e.start();
                    }
                } else if (!runnableC0447a.f23273a.isEmpty()) {
                    reentrantLock.unlock();
                    return true;
                }
                this.b.remove(Integer.valueOf(runnableC0447a.d));
                reentrantLock.unlock();
                return false;
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }

        final f b() {
            f poll;
            while (true) {
                try {
                    poll = this.g > this.f ? this.f23271a.poll(this.e, TimeUnit.NANOSECONDS) : this.f23271a.take();
                } catch (InterruptedException e) {
                    com.igexin.c.a.c.a.a(e);
                }
                if (poll != null) {
                    return poll;
                }
                if (this.f23271a.isEmpty()) {
                    return null;
                }
            }
        }

        final boolean b(f fVar) {
            ReentrantLock reentrantLock = this.f23272c;
            reentrantLock.lock();
            try {
                Thread e = this.g < this.h ? e(fVar) : null;
                reentrantLock.unlock();
                if (e == null) {
                    return false;
                }
                e.start();
                return true;
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/igexin/c/a/d/g$b.class */
    public final class b extends Thread {

        /* renamed from: a  reason: collision with root package name */
        volatile boolean f23276a = true;
        long b;

        /* renamed from: c  reason: collision with root package name */
        long f23277c;
        a d;

        public b() {
            setName("TS-processor");
        }

        private static void a() {
        }

        /* JADX WARN: Can't wrap try/catch for region: R(16:(2:8|(2:10|(3:39|40|(2:43|28)(4:42|34|35|36))(9:12|13|14|15|16|17|18|19|(3:21|(2:26|27)(3:29|30|31)|28)(4:33|34|35|36))))(3:77|78|(6:88|89|(1:91)|92|93|(1:99)(3:95|96|98))(3:80|81|(4:85|86|87|36)))|44|45|46|(1:48)|49|(1:51)|54|13|14|15|16|17|18|19|(0)(0)) */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x0092, code lost:
            if (r11.C == 0) goto L135;
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x0095, code lost:
            r0 = r0.f23272c;
            r0.lock();
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x00a3, code lost:
            r0 = r0.b.get(java.lang.Integer.valueOf(r11.C));
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x00b8, code lost:
            if (r0 == null) goto L106;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x00bb, code lost:
            r0.f23273a.offer(r11);
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x00ca, code lost:
            r0.unlock();
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x00d0, code lost:
            r0.unlock();
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x00ec, code lost:
            if (r0.g >= r0.f) goto L129;
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x00f6, code lost:
            if (r0.a(r11) != false) goto L128;
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x0105, code lost:
            if (r0.f23271a.offer(r11) == false) goto L117;
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x010d, code lost:
            if (r0.g != 0) goto L127;
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x0110, code lost:
            r0.a();
         */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x0118, code lost:
            r0.b(r11);
         */
        /* JADX WARN: Code restructure failed: missing block: B:69:0x01d3, code lost:
            r12 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:70:0x01d5, code lost:
            com.igexin.c.a.c.a.a(r12);
            com.igexin.c.a.c.a.a(com.igexin.c.a.d.g.h, r12.toString());
            com.igexin.c.a.c.a.a("TaskService|SERVICE_PROCESSING|error|" + r12.toString(), new java.lang.Object[0]);
            r11.v = true;
            r11.E = r12;
            r11.o();
            r11.k();
            r5.e.r.a(r11);
         */
        /* JADX WARN: Code restructure failed: missing block: B:71:0x022a, code lost:
            r5.e.f();
         */
        /* JADX WARN: Code restructure failed: missing block: B:72:0x0235, code lost:
            if (r11.v == false) goto L60;
         */
        /* JADX WARN: Code restructure failed: missing block: B:73:0x0238, code lost:
            r11.d_();
         */
        /* JADX WARN: Code restructure failed: missing block: B:75:0x0242, code lost:
            if (r11.m == false) goto L63;
         */
        /* JADX WARN: Code restructure failed: missing block: B:77:0x024a, code lost:
            if (r11.q == false) goto L53;
         */
        /* JADX WARN: Removed duplicated region for block: B:135:0x0298 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:86:0x0278  */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void run() {
            /*
                Method dump skipped, instructions count: 789
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.igexin.c.a.d.g.b.run():void");
        }
    }

    public g() {
        f.H = this;
    }

    private static int a(f fVar, f fVar2) {
        if (fVar.w < fVar2.w) {
            return -1;
        }
        if (fVar.w > fVar2.w) {
            return 1;
        }
        if (fVar.D > fVar2.D) {
            return -1;
        }
        if (fVar.D < fVar2.D) {
            return 1;
        }
        if (fVar.x < fVar2.x) {
            return -1;
        }
        if (fVar.x > fVar2.x) {
            return 1;
        }
        return fVar.hashCode() - fVar2.hashCode();
    }

    private void a() {
        try {
            if (this.x != null) {
                this.v.cancel(this.x);
            }
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(h, th.toString());
        }
    }

    private void a(int i2, TimeUnit timeUnit) {
        this.p.b = TimeUnit.MILLISECONDS.convert(i2, timeUnit);
    }

    private void a(Context context) {
        if (this.H) {
            return;
        }
        if (!n.m()) {
            this.u = (PowerManager) context.getSystemService("power");
            this.C = true;
            this.v = (AlarmManager) context.getSystemService("alarm");
            context.registerReceiver(this, new AnonymousClass1(context), com.igexin.push.core.e.ac, null);
            this.A = G + context.getPackageName();
            context.registerReceiver(this, new IntentFilter(this.A), com.igexin.push.core.e.ac, null);
            int i2 = 134217728;
            if (n.a(context) >= 31) {
                i2 = 134217728;
                if (Build.VERSION.SDK_INT >= 30) {
                    i2 = 201326592;
                }
            }
            this.w = new Intent(E + context.getPackageName());
            this.x = PendingIntent.getBroadcast(context, hashCode(), this.w, i2);
            hashCode();
            this.y = new Intent(this.A);
            this.z = PendingIntent.getBroadcast(context, hashCode() + 2, this.y, i2);
            hashCode();
        }
        this.p.start();
        try {
            Thread.yield();
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
        this.H = true;
    }

    private static boolean a(com.igexin.c.a.d.a.e eVar, com.igexin.c.a.d.a.c cVar) {
        int c2 = eVar.c();
        boolean z = false;
        if (c2 <= Integer.MIN_VALUE || c2 >= 0) {
            if (c2 < 0 || c2 >= Integer.MAX_VALUE) {
                return false;
            }
            return cVar.a(eVar);
        }
        f fVar = (f) eVar;
        if (!fVar.v) {
            z = cVar.a(eVar);
        }
        if (z) {
            fVar.d_();
        }
        return z;
    }

    private boolean a(f fVar) {
        e<f> eVar = this.s;
        return eVar != null && eVar.c(fVar);
    }

    private boolean a(f fVar, boolean z, int i2, long j2, byte b2, Object obj, com.igexin.c.a.d.a.d dVar, int i3, com.igexin.c.a.d.a.g gVar) {
        if (fVar != null) {
            fVar.A = i2;
            fVar.a((int) b2);
            fVar.F = obj;
            fVar.O = dVar;
            fVar.a(j2, TimeUnit.MILLISECONDS);
            fVar.a(i3, gVar);
            return a(fVar, z);
        }
        throw null;
    }

    private boolean a(Class cls) {
        e<f> eVar = this.s;
        return eVar != null && eVar.a(cls);
    }

    private void b(long j2) {
        if (n.m()) {
            return;
        }
        com.igexin.c.a.c.a.a("setnioalarm|" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date(j2)), new Object[0]);
        long j3 = j2;
        if (j2 < 0) {
            j3 = System.currentTimeMillis() + D;
        }
        try {
            if (Build.VERSION.SDK_INT < 19) {
                this.v.set(0, j3, this.z);
                return;
            }
            try {
                this.v.setExact(0, j3, this.z);
            } catch (Exception e) {
                this.v.set(0, j3, this.z);
            }
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(h, th.toString());
        }
    }

    private boolean b() {
        e<f> eVar = this.s;
        if (eVar != null) {
            eVar.f23268c.clear();
            return true;
        }
        return false;
    }

    public final void a(long j2) {
        if (this.C) {
            com.igexin.c.a.c.a.a("setalarm|" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date(j2)), new Object[0]);
            long j3 = j2;
            if (j2 < 0) {
                j3 = System.currentTimeMillis() + D;
            }
            try {
                if (this.x != null) {
                    if (Build.VERSION.SDK_INT < 19) {
                        this.v.set(0, j3, this.x);
                    } else {
                        this.v.setExact(0, j3, this.x);
                    }
                }
            } catch (Throwable th) {
                com.igexin.c.a.c.a.a(h, th.toString());
                com.igexin.c.a.c.a.a(h + th.toString(), new Object[0]);
            }
        }
    }

    public final boolean a(com.igexin.c.a.d.a.c cVar) {
        ReentrantLock reentrantLock = this.t;
        if (reentrantLock.tryLock()) {
            try {
                if (this.q.containsKey(Long.valueOf(cVar.h()))) {
                    reentrantLock.unlock();
                    return false;
                }
                this.q.put(Long.valueOf(cVar.h()), cVar);
                reentrantLock.unlock();
                return true;
            } catch (Throwable th) {
                try {
                    com.igexin.c.a.c.a.a(th);
                    com.igexin.c.a.c.a.a("TaskService|" + th.toString(), new Object[0]);
                    reentrantLock.unlock();
                    return false;
                } catch (Throwable th2) {
                    reentrantLock.unlock();
                    throw th2;
                }
            }
        }
        return false;
    }

    public final boolean a(f fVar, boolean z) {
        int i2;
        if (fVar != null) {
            if (fVar.q || fVar.m) {
                return false;
            }
            fVar.getClass().getName();
            e<f> eVar = this.s;
            if ((fVar instanceof com.igexin.c.a.b.f) && (((com.igexin.c.a.b.f) fVar).d instanceof o)) {
                i2 = 0;
                if (z) {
                    i2 = Integer.MAX_VALUE;
                }
            } else {
                i2 = 0;
                if (z) {
                    i2 = eVar.d.incrementAndGet();
                }
            }
            fVar.D = i2;
            return eVar.a((e<f>) fVar);
        }
        throw null;
    }

    public final boolean a(f fVar, boolean z, boolean z2) {
        if (fVar != null) {
            if (fVar.n) {
                return false;
            }
            if (!z || z2) {
                boolean z3 = false;
                if (z2) {
                    z3 = false;
                    if (z) {
                        z3 = true;
                    }
                }
                return a(fVar, z3);
            }
            fVar.d();
            try {
                try {
                    fVar.b_();
                    fVar.n();
                    if (fVar.v) {
                        return true;
                    }
                    fVar.d_();
                    return true;
                } catch (Exception e) {
                    com.igexin.c.a.c.a.a(e);
                    fVar.v = true;
                    fVar.E = e;
                    fVar.k();
                    fVar.o();
                    a((Object) fVar);
                    e();
                    if (fVar.v) {
                        return false;
                    }
                    fVar.d_();
                    return false;
                }
            } catch (Throwable th) {
                if (!fVar.v) {
                    fVar.d_();
                }
                throw th;
            }
        }
        throw null;
    }

    public final boolean a(Object obj) {
        if (obj == null) {
            return false;
        }
        obj.getClass().getName();
        obj.hashCode();
        try {
            if (obj instanceof com.igexin.push.c.c.n) {
                obj.getClass().getName();
                obj.hashCode();
            }
        } catch (Exception e) {
            com.igexin.c.a.c.a.a(e);
        }
        obj.getClass().getName();
        obj.hashCode();
        com.igexin.c.a.c.a.a("TaskService|responseQueue ++ task = " + obj.getClass().getName() + "@" + obj.hashCode(), new Object[0]);
        if (obj instanceof com.igexin.c.a.d.a.e) {
            com.igexin.c.a.d.a.e eVar = (com.igexin.c.a.d.a.e) obj;
            if (eVar.i()) {
                return false;
            }
            eVar.a(false);
            if ((obj instanceof com.igexin.push.c.b.a) || (obj instanceof com.igexin.push.c.b.b)) {
                this.r.a();
                com.igexin.c.a.c.a.a("TaskService|change to primaryQueue", new Object[0]);
            }
            this.r.a(eVar);
            return true;
        }
        throw new ClassCastException("response Obj is not a TaskResult ");
    }

    @Override // java.util.Comparator
    public /* synthetic */ int compare(f fVar, f fVar2) {
        f fVar3 = fVar;
        f fVar4 = fVar2;
        if (fVar3.w < fVar4.w) {
            return -1;
        }
        if (fVar3.w > fVar4.w) {
            return 1;
        }
        if (fVar3.D > fVar4.D) {
            return -1;
        }
        if (fVar3.D < fVar4.D) {
            return 1;
        }
        if (fVar3.x < fVar4.x) {
            return -1;
        }
        if (fVar3.x > fVar4.x) {
            return 1;
        }
        return fVar3.hashCode() - fVar4.hashCode();
    }

    public final void d() {
        try {
            if (this.z != null) {
                this.v.cancel(this.z);
            }
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(h, th.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void e() {
        b bVar = this.p;
        if (bVar == null || bVar.isInterrupted()) {
            return;
        }
        this.p.interrupt();
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x00c2, code lost:
        if (r0 < 0) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00c5, code lost:
        ((com.igexin.c.a.d.f) r0).d_();
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0121, code lost:
        if (r0 < 0) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x012f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0000 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final void f() {
        /*
            Method dump skipped, instructions count: 366
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.c.a.d.g.f():void");
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (Intent.ACTION_SCREEN_OFF.equals(intent.getAction())) {
            this.C = true;
            com.igexin.c.a.c.a.a("screenoff", new Object[0]);
            if (this.s.g.get() > 0) {
                a(this.s.g.get());
            }
        } else if (Intent.ACTION_SCREEN_ON.equals(intent.getAction())) {
            this.C = false;
            com.igexin.c.a.c.a.a("screenon", new Object[0]);
        } else if (intent.getAction().startsWith(E) || intent.getAction().startsWith(F)) {
            Calendar.getInstance().getTime().toLocaleString();
            com.igexin.c.a.c.a.a("receivealarm|" + this.C, new Object[0]);
            e();
        } else if (this.A.equals(intent.getAction())) {
            Calendar calendar = Calendar.getInstance();
            String str = i;
            com.igexin.c.a.c.a.b(str, "CPU ON + NioAlarmReceiver:-> cTime; " + calendar.getTime().toLocaleString());
            try {
                com.igexin.c.a.c.a.a(h, " alarm time out #######");
                com.igexin.c.a.c.a.a("TaskService|alarm time out #######", new Object[0]);
                com.igexin.c.a.b.a.a.d.a().f();
            } catch (Exception e) {
                com.igexin.c.a.c.a.a(e);
            }
        }
    }
}
