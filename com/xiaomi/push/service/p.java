package com.xiaomi.push.service;

import android.content.Intent;
import android.os.SystemClock;
import com.xiaomi.push.service.XMPushService;
import java.util.concurrent.RejectedExecutionException;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/p.class */
public class p {

    /* renamed from: a  reason: collision with root package name */
    private static long f27997a;
    private static long b;

    /* renamed from: c  reason: collision with root package name */
    private static long f27998c;

    /* renamed from: a  reason: collision with other field name */
    private final a f1020a;

    /* renamed from: a  reason: collision with other field name */
    private final c f1021a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/p$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final c f27999a;

        a(c cVar) {
            this.f27999a = cVar;
        }

        protected final void finalize() {
            try {
                synchronized (this.f27999a) {
                    this.f27999a.f28002c = true;
                    this.f27999a.notify();
                }
            } finally {
                super.finalize();
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/p$b.class */
    public static abstract class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        protected int f28000a;

        public b(int i) {
            this.f28000a = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/p$c.class */
    public static final class c extends Thread {

        /* renamed from: b  reason: collision with other field name */
        private boolean f1024b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f28002c;

        /* renamed from: a  reason: collision with root package name */
        private volatile long f28001a = 0;

        /* renamed from: a  reason: collision with other field name */
        private volatile boolean f1023a = false;
        private long b = 50;

        /* renamed from: a  reason: collision with other field name */
        private a f1022a = new a();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/p$c$a.class */
        public static final class a {

            /* renamed from: a  reason: collision with root package name */
            private int f28003a;

            /* renamed from: a  reason: collision with other field name */
            private d[] f1025a;
            private int b;

            /* renamed from: c  reason: collision with root package name */
            private int f28004c;

            private a() {
                this.f28003a = 256;
                this.f1025a = new d[256];
                this.b = 0;
                this.f28004c = 0;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public int a(d dVar) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    d[] dVarArr = this.f1025a;
                    if (i2 >= dVarArr.length) {
                        return -1;
                    }
                    if (dVarArr[i2] == dVar) {
                        return i2;
                    }
                    i = i2 + 1;
                }
            }

            private void b(d dVar) {
                Intent a2;
                if (dVar.f1027a.f28000a == 8) {
                    XMPushService.d dVar2 = (XMPushService.d) dVar.f1027a;
                    if (dVar2.a().f403a != null) {
                        dVar2.a().f403a.f930b = System.currentTimeMillis();
                        dVar2.a().f403a.b = a(dVar);
                    }
                } else if (dVar.f1027a.f28000a == 15 && (a2 = ((XMPushService.i) dVar.f1027a).a()) != null && "10".equals(a2.getStringExtra("ext_chid"))) {
                    a2.putExtra("enqueue", System.currentTimeMillis());
                    a2.putExtra(com.anythink.expressad.foundation.d.l.d, a(dVar));
                }
            }

            private void c() {
                int i = this.b - 1;
                int i2 = (i - 1) / 2;
                while (true) {
                    int i3 = i2;
                    if (this.f1025a[i].f1026a >= this.f1025a[i3].f1026a) {
                        return;
                    }
                    d[] dVarArr = this.f1025a;
                    d dVar = dVarArr[i];
                    dVarArr[i] = dVarArr[i3];
                    dVarArr[i3] = dVar;
                    i = i3;
                    i2 = (i3 - 1) / 2;
                }
            }

            private void c(int i) {
                int i2 = i;
                int i3 = (i * 2) + 1;
                while (true) {
                    int i4 = this.b;
                    if (i3 >= i4 || i4 <= 0) {
                        return;
                    }
                    int i5 = i3 + 1;
                    int i6 = i3;
                    if (i5 < i4) {
                        i6 = i3;
                        if (this.f1025a[i5].f1026a < this.f1025a[i3].f1026a) {
                            i6 = i5;
                        }
                    }
                    if (this.f1025a[i2].f1026a < this.f1025a[i6].f1026a) {
                        return;
                    }
                    d[] dVarArr = this.f1025a;
                    d dVar = dVarArr[i2];
                    dVarArr[i2] = dVarArr[i6];
                    dVarArr[i6] = dVar;
                    i3 = (i6 * 2) + 1;
                    i2 = i6;
                }
            }

            public final d a() {
                return this.f1025a[0];
            }

            /* renamed from: a  reason: collision with other method in class */
            public final void m9154a() {
                this.f1025a = new d[this.f28003a];
                this.b = 0;
            }

            public final void a(int i) {
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= this.b) {
                        b();
                        return;
                    }
                    if (this.f1025a[i3].f28005a == i) {
                        this.f1025a[i3].a();
                    }
                    i2 = i3 + 1;
                }
            }

            public final void a(int i, b bVar) {
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= this.b) {
                        b();
                        return;
                    }
                    if (this.f1025a[i3].f1027a == bVar) {
                        this.f1025a[i3].a();
                    }
                    i2 = i3 + 1;
                }
            }

            /* renamed from: a  reason: collision with other method in class */
            public final void m9155a(d dVar) {
                d[] dVarArr = this.f1025a;
                int length = dVarArr.length;
                int i = this.b;
                if (length == i) {
                    d[] dVarArr2 = new d[i * 2];
                    System.arraycopy(dVarArr, 0, dVarArr2, 0, i);
                    this.f1025a = dVarArr2;
                }
                d[] dVarArr3 = this.f1025a;
                int i2 = this.b;
                this.b = i2 + 1;
                dVarArr3[i2] = dVar;
                c();
                b(dVar);
            }

            /* renamed from: a  reason: collision with other method in class */
            public final boolean m9156a() {
                return this.b == 0;
            }

            /* renamed from: a  reason: collision with other method in class */
            public final boolean m9157a(int i) {
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= this.b) {
                        return false;
                    }
                    if (this.f1025a[i3].f28005a == i) {
                        return true;
                    }
                    i2 = i3 + 1;
                }
            }

            public final void b() {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.b) {
                        return;
                    }
                    int i3 = i2;
                    if (this.f1025a[i2].f1029a) {
                        this.f28004c++;
                        b(i2);
                        i3 = i2 - 1;
                    }
                    i = i3 + 1;
                }
            }

            public final void b(int i) {
                int i2;
                if (i < 0 || i >= (i2 = this.b)) {
                    return;
                }
                d[] dVarArr = this.f1025a;
                int i3 = i2 - 1;
                this.b = i3;
                dVarArr[i] = dVarArr[i3];
                dVarArr[i3] = null;
                c(i);
            }
        }

        c(String str, boolean z) {
            setName(str);
            setDaemon(z);
            start();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(d dVar) {
            this.f1022a.m9155a(dVar);
            notify();
        }

        public final void a() {
            synchronized (this) {
                this.f1024b = true;
                this.f1022a.m9154a();
                notify();
            }
        }

        /* renamed from: a  reason: collision with other method in class */
        public final boolean m9153a() {
            return this.f1023a && SystemClock.uptimeMillis() - this.f28001a > 600000;
        }

        /* JADX WARN: Code restructure failed: missing block: B:60:0x0110, code lost:
            r5.f28001a = android.os.SystemClock.uptimeMillis();
            r5.f1023a = true;
            r0.f1027a.run();
            r5.f1023a = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:61:0x012b, code lost:
            r11 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:63:0x012e, code lost:
            monitor-enter(r5);
         */
        /* JADX WARN: Code restructure failed: missing block: B:64:0x012f, code lost:
            r5.f1024b = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:67:0x0138, code lost:
            throw r11;
         */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void run() {
            /*
                Method dump skipped, instructions count: 353
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.p.c.run():void");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/p$d.class */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        int f28005a;

        /* renamed from: a  reason: collision with other field name */
        long f1026a;

        /* renamed from: a  reason: collision with other field name */
        b f1027a;

        /* renamed from: a  reason: collision with other field name */
        final Object f1028a = new Object();

        /* renamed from: a  reason: collision with other field name */
        boolean f1029a;
        private long b;

        d() {
        }

        void a(long j) {
            synchronized (this.f1028a) {
                this.b = j;
            }
        }

        public boolean a() {
            boolean z;
            synchronized (this.f1028a) {
                z = !this.f1029a && this.f1026a > 0;
                this.f1029a = true;
            }
            return z;
        }
    }

    static {
        long j = 0;
        if (SystemClock.elapsedRealtime() > 0) {
            j = SystemClock.elapsedRealtime();
        }
        f27997a = j;
        b = j;
    }

    public p() {
        this(false);
    }

    public p(String str) {
        this(str, false);
    }

    public p(String str, boolean z) {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        c cVar = new c(str, z);
        this.f1021a = cVar;
        this.f1020a = new a(cVar);
    }

    public p(boolean z) {
        this("Timer-" + b(), z);
    }

    static long a() {
        long j;
        synchronized (p.class) {
            try {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                if (elapsedRealtime > b) {
                    f27997a += elapsedRealtime - b;
                }
                b = elapsedRealtime;
                j = f27997a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return j;
    }

    private static long b() {
        long j;
        synchronized (p.class) {
            try {
                j = f27998c;
                f27998c = 1 + j;
            } catch (Throwable th) {
                throw th;
            }
        }
        return j;
    }

    private void b(b bVar, long j) {
        synchronized (this.f1021a) {
            if (this.f1021a.f1024b) {
                throw new IllegalStateException("Timer was canceled");
            }
            long a2 = j + a();
            if (a2 < 0) {
                throw new IllegalArgumentException("Illegal delay to start the TimerTask: ".concat(String.valueOf(a2)));
            }
            d dVar = new d();
            dVar.f28005a = bVar.f28000a;
            dVar.f1027a = bVar;
            dVar.f1026a = a2;
            this.f1021a.a(dVar);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m9148a() {
        com.xiaomi.channel.commonutils.logger.b.m8344a("quit. finalizer:" + this.f1020a);
        this.f1021a.a();
    }

    public void a(int i) {
        synchronized (this.f1021a) {
            this.f1021a.f1022a.a(i);
        }
    }

    public void a(int i, b bVar) {
        synchronized (this.f1021a) {
            this.f1021a.f1022a.a(i, bVar);
        }
    }

    public void a(b bVar) {
        if (com.xiaomi.channel.commonutils.logger.b.a() > 0 || Thread.currentThread() == this.f1021a) {
            bVar.run();
        } else {
            com.xiaomi.channel.commonutils.logger.b.d("run job outside job job thread");
            throw new RejectedExecutionException("Run job outside job thread");
        }
    }

    public void a(b bVar, long j) {
        if (j < 0) {
            throw new IllegalArgumentException("delay < 0: ".concat(String.valueOf(j)));
        }
        b(bVar, j);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m9149a() {
        return this.f1021a.m9153a();
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m9150a(int i) {
        boolean m9157a;
        synchronized (this.f1021a) {
            m9157a = this.f1021a.f1022a.m9157a(i);
        }
        return m9157a;
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m9151b() {
        synchronized (this.f1021a) {
            this.f1021a.f1022a.m9154a();
        }
    }
}
