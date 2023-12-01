package com.xiaomi.push.service;

import android.content.Intent;
import android.os.SystemClock;
import com.xiaomi.push.service.XMPushService;
import java.util.concurrent.RejectedExecutionException;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/p.class */
public class p {

    /* renamed from: a  reason: collision with root package name */
    private static long f41688a;
    private static long b;

    /* renamed from: c  reason: collision with root package name */
    private static long f41689c;

    /* renamed from: a  reason: collision with other field name */
    private final a f1067a;

    /* renamed from: a  reason: collision with other field name */
    private final c f1068a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/p$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final c f41690a;

        a(c cVar) {
            this.f41690a = cVar;
        }

        protected final void finalize() {
            try {
                synchronized (this.f41690a) {
                    this.f41690a.f41693c = true;
                    this.f41690a.notify();
                }
            } finally {
                super.finalize();
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/p$b.class */
    public static abstract class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        protected int f41691a;

        public b(int i) {
            this.f41691a = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/p$c.class */
    public static final class c extends Thread {

        /* renamed from: b  reason: collision with other field name */
        private boolean f1071b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f41693c;

        /* renamed from: a  reason: collision with root package name */
        private volatile long f41692a = 0;

        /* renamed from: a  reason: collision with other field name */
        private volatile boolean f1070a = false;
        private long b = 50;

        /* renamed from: a  reason: collision with other field name */
        private a f1069a = new a();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/p$c$a.class */
        public static final class a {

            /* renamed from: a  reason: collision with root package name */
            private int f41694a;

            /* renamed from: a  reason: collision with other field name */
            private d[] f1072a;
            private int b;

            /* renamed from: c  reason: collision with root package name */
            private int f41695c;

            private a() {
                this.f41694a = 256;
                this.f1072a = new d[256];
                this.b = 0;
                this.f41695c = 0;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public int a(d dVar) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    d[] dVarArr = this.f1072a;
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
                if (dVar.f1074a.f41691a == 8) {
                    XMPushService.d dVar2 = (XMPushService.d) dVar.f1074a;
                    if (dVar2.a().f450a != null) {
                        dVar2.a().f450a.f977b = System.currentTimeMillis();
                        dVar2.a().f450a.b = a(dVar);
                    }
                } else if (dVar.f1074a.f41691a == 15 && (a2 = ((XMPushService.i) dVar.f1074a).a()) != null && "10".equals(a2.getStringExtra("ext_chid"))) {
                    a2.putExtra("enqueue", System.currentTimeMillis());
                    a2.putExtra(com.anythink.expressad.foundation.d.l.d, a(dVar));
                }
            }

            private void c() {
                int i = this.b - 1;
                int i2 = (i - 1) / 2;
                while (true) {
                    int i3 = i2;
                    if (this.f1072a[i].f1073a >= this.f1072a[i3].f1073a) {
                        return;
                    }
                    d[] dVarArr = this.f1072a;
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
                        if (this.f1072a[i5].f1073a < this.f1072a[i3].f1073a) {
                            i6 = i5;
                        }
                    }
                    if (this.f1072a[i2].f1073a < this.f1072a[i6].f1073a) {
                        return;
                    }
                    d[] dVarArr = this.f1072a;
                    d dVar = dVarArr[i2];
                    dVarArr[i2] = dVarArr[i6];
                    dVarArr[i6] = dVar;
                    i3 = (i6 * 2) + 1;
                    i2 = i6;
                }
            }

            public final d a() {
                return this.f1072a[0];
            }

            /* renamed from: a  reason: collision with other method in class */
            public final void m12204a() {
                this.f1072a = new d[this.f41694a];
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
                    if (this.f1072a[i3].f41696a == i) {
                        this.f1072a[i3].a();
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
                    if (this.f1072a[i3].f1074a == bVar) {
                        this.f1072a[i3].a();
                    }
                    i2 = i3 + 1;
                }
            }

            /* renamed from: a  reason: collision with other method in class */
            public final void m12205a(d dVar) {
                d[] dVarArr = this.f1072a;
                int length = dVarArr.length;
                int i = this.b;
                if (length == i) {
                    d[] dVarArr2 = new d[i * 2];
                    System.arraycopy(dVarArr, 0, dVarArr2, 0, i);
                    this.f1072a = dVarArr2;
                }
                d[] dVarArr3 = this.f1072a;
                int i2 = this.b;
                this.b = i2 + 1;
                dVarArr3[i2] = dVar;
                c();
                b(dVar);
            }

            /* renamed from: a  reason: collision with other method in class */
            public final boolean m12206a() {
                return this.b == 0;
            }

            /* renamed from: a  reason: collision with other method in class */
            public final boolean m12207a(int i) {
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= this.b) {
                        return false;
                    }
                    if (this.f1072a[i3].f41696a == i) {
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
                    if (this.f1072a[i2].f1076a) {
                        this.f41695c++;
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
                d[] dVarArr = this.f1072a;
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
            this.f1069a.m12205a(dVar);
            notify();
        }

        public final void a() {
            synchronized (this) {
                this.f1071b = true;
                this.f1069a.m12204a();
                notify();
            }
        }

        /* renamed from: a  reason: collision with other method in class */
        public final boolean m12203a() {
            return this.f1070a && SystemClock.uptimeMillis() - this.f41692a > 600000;
        }

        /* JADX WARN: Code restructure failed: missing block: B:60:0x0110, code lost:
            r5.f41692a = android.os.SystemClock.uptimeMillis();
            r5.f1070a = true;
            r0.f1074a.run();
            r5.f1070a = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:61:0x012b, code lost:
            r11 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:63:0x012e, code lost:
            monitor-enter(r5);
         */
        /* JADX WARN: Code restructure failed: missing block: B:64:0x012f, code lost:
            r5.f1071b = true;
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
        int f41696a;

        /* renamed from: a  reason: collision with other field name */
        long f1073a;

        /* renamed from: a  reason: collision with other field name */
        b f1074a;

        /* renamed from: a  reason: collision with other field name */
        final Object f1075a = new Object();

        /* renamed from: a  reason: collision with other field name */
        boolean f1076a;
        private long b;

        d() {
        }

        void a(long j) {
            synchronized (this.f1075a) {
                this.b = j;
            }
        }

        public boolean a() {
            boolean z;
            synchronized (this.f1075a) {
                z = !this.f1076a && this.f1073a > 0;
                this.f1076a = true;
            }
            return z;
        }
    }

    static {
        long j = 0;
        if (SystemClock.elapsedRealtime() > 0) {
            j = SystemClock.elapsedRealtime();
        }
        f41688a = j;
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
        this.f1068a = cVar;
        this.f1067a = new a(cVar);
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
                    f41688a += elapsedRealtime - b;
                }
                b = elapsedRealtime;
                j = f41688a;
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
                j = f41689c;
                f41689c = 1 + j;
            } catch (Throwable th) {
                throw th;
            }
        }
        return j;
    }

    private void b(b bVar, long j) {
        synchronized (this.f1068a) {
            if (this.f1068a.f1071b) {
                throw new IllegalStateException("Timer was canceled");
            }
            long a2 = j + a();
            if (a2 < 0) {
                throw new IllegalArgumentException("Illegal delay to start the TimerTask: ".concat(String.valueOf(a2)));
            }
            d dVar = new d();
            dVar.f41696a = bVar.f41691a;
            dVar.f1074a = bVar;
            dVar.f1073a = a2;
            this.f1068a.a(dVar);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m12198a() {
        com.xiaomi.channel.commonutils.logger.b.m11394a("quit. finalizer:" + this.f1067a);
        this.f1068a.a();
    }

    public void a(int i) {
        synchronized (this.f1068a) {
            this.f1068a.f1069a.a(i);
        }
    }

    public void a(int i, b bVar) {
        synchronized (this.f1068a) {
            this.f1068a.f1069a.a(i, bVar);
        }
    }

    public void a(b bVar) {
        if (com.xiaomi.channel.commonutils.logger.b.a() > 0 || Thread.currentThread() == this.f1068a) {
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
    public boolean m12199a() {
        return this.f1068a.m12203a();
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m12200a(int i) {
        boolean m12207a;
        synchronized (this.f1068a) {
            m12207a = this.f1068a.f1069a.m12207a(i);
        }
        return m12207a;
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m12201b() {
        synchronized (this.f1068a) {
            this.f1068a.f1069a.m12204a();
        }
    }
}
