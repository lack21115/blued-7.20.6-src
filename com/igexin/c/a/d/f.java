package com.igexin.c.a.d;

import android.os.PowerManager;
import com.igexin.c.a.d.a.d;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/c/a/d/f.class */
public abstract class f extends b implements com.igexin.c.a.d.a.a, com.igexin.c.a.d.a.f {
    protected static g H;
    public int A;
    public int B;
    public int C;
    public int D;
    public Exception E;
    public Object F;
    public com.igexin.c.a.d.a.g G;
    protected final ReentrantLock I;
    protected final Condition J;
    public Thread K;
    protected volatile boolean L;
    PowerManager.WakeLock M;
    int N;
    protected com.igexin.c.a.d.a.d O;

    /* renamed from: a  reason: collision with root package name */
    private byte f23269a;
    protected volatile boolean m;
    protected volatile boolean n;
    protected volatile boolean o;
    protected volatile boolean p;
    protected volatile boolean q;
    protected volatile boolean r;
    protected volatile boolean s;
    protected volatile boolean t;
    protected volatile boolean u;
    protected volatile boolean v;
    protected volatile long w;
    volatile int x;
    public long z;

    public f(int i) {
        this(i, (byte) 0);
    }

    private f(int i, byte b) {
        this.C = i;
        this.O = null;
        ReentrantLock reentrantLock = new ReentrantLock();
        this.I = reentrantLock;
        this.J = reentrantLock.newCondition();
    }

    private int A() {
        return this.f23269a & 15;
    }

    private boolean B() {
        byte b = this.f23269a;
        return (b >> 4) > (b & 15);
    }

    private Thread C() {
        return this.K;
    }

    private static void D() throws Exception {
    }

    private void E() {
        this.n = true;
    }

    private Object F() {
        return this.F;
    }

    private com.igexin.c.a.d.a.d G() {
        return this.O;
    }

    private void a(int i, TimeUnit timeUnit) {
        this.v = false;
        this.E = null;
        this.w = 0L;
        byte b = this.f23269a;
        this.f23269a = (byte) (b + ((b & 15) < 15 ? (byte) 1 : (byte) 0));
        this.m = false;
        this.q = false;
        this.t = false;
        a(i, timeUnit);
    }

    private void a(long j) {
        this.z = j;
    }

    private void a(PowerManager.WakeLock wakeLock) {
        this.M = wakeLock;
    }

    private boolean a(Object obj) {
        if (this.m) {
            this.q = false;
            this.n = false;
            this.m = false;
            this.F = obj;
            return true;
        }
        return false;
    }

    private void b(int i) {
        if (i != this.D) {
            this.D = i;
            H.s.b(this);
        }
    }

    private void b(Object obj) {
        this.F = obj;
    }

    private ReentrantLock g() {
        ReentrantLock reentrantLock = this.I;
        if (reentrantLock != null) {
            return reentrantLock;
        }
        throw null;
    }

    private PowerManager.WakeLock h() {
        return this.M;
    }

    private void p() {
        this.z = System.currentTimeMillis();
    }

    private boolean q() {
        return this.v;
    }

    private int r() {
        long a2 = a(TimeUnit.MILLISECONDS);
        int i = this.N;
        this.N = a2 > 0 ? i | 134217728 : i & 1090519038;
        return this.N;
    }

    private void s() {
        int i = this.N + 1;
        this.N = i;
        this.N = i & 1090519038;
    }

    private long t() {
        return this.w - System.currentTimeMillis();
    }

    private boolean u() {
        return this.q;
    }

    private boolean v() {
        return this.u;
    }

    private boolean w() {
        return this.m;
    }

    private boolean x() {
        return this.s;
    }

    private boolean y() {
        return this.t;
    }

    private void z() {
        this.v = false;
        this.E = null;
        this.w = 0L;
        byte b = this.f23269a;
        this.f23269a = (byte) (b + ((b & 15) < 15 ? (byte) 1 : (byte) 0));
        this.m = false;
        this.q = false;
        this.t = false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0027, code lost:
        if (r0 != 1) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int a(long r9, java.util.concurrent.TimeUnit r11) {
        /*
            r8 = this;
            r0 = 1
            r12 = r0
            r0 = r9
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L4a
            com.igexin.c.a.d.g r0 = com.igexin.c.a.d.f.H
            com.igexin.c.a.d.e<com.igexin.c.a.d.f> r0 = r0.s
            r1 = r8
            r2 = r9
            r3 = r11
            int r0 = r0.a(r1, r2, r3)
            r13 = r0
            r0 = r13
            r1 = -2
            if (r0 == r1) goto L43
            r0 = r13
            r1 = -1
            if (r0 == r1) goto L2d
            r0 = r13
            r1 = 1
            if (r0 == r1) goto L4d
            goto L4a
        L2d:
            r0 = r8
            long r1 = java.lang.System.currentTimeMillis()
            java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.MILLISECONDS
            r3 = r9
            r4 = r11
            long r2 = r2.convert(r3, r4)
            long r1 = r1 + r2
            r0.w = r1
            r0 = -1
            r12 = r0
            goto L4d
        L43:
            r0 = -2
            r12 = r0
            goto L4d
        L4a:
            r0 = 0
            r12 = r0
        L4d:
            r0 = r8
            java.lang.Class r0 = r0.getClass()
            java.lang.String r0 = r0.getSimpleName()
            r0 = r8
            int r0 = r0.hashCode()
            java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.SECONDS
            r1 = r9
            r2 = r11
            long r0 = r0.convert(r1, r2)
            r0 = r12
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.c.a.d.f.a(long, java.util.concurrent.TimeUnit):int");
    }

    public final long a(TimeUnit timeUnit) {
        return timeUnit.convert(t(), TimeUnit.MILLISECONDS);
    }

    @Override // com.igexin.c.a.d.a.a
    public void a() {
        this.F = null;
        this.E = null;
        this.K = null;
    }

    public final void a(int i) {
        byte b = (byte) (this.f23269a & 15);
        this.f23269a = b;
        this.f23269a = (byte) (((i & 15) << 4) | b);
    }

    public final void a(int i, com.igexin.c.a.d.a.g gVar) {
        if (i < 0) {
            throw new IllegalArgumentException("second must > 0");
        }
        this.B = i;
        this.G = gVar;
    }

    public final void a(com.igexin.c.a.d.a.d dVar) {
        this.O = dVar;
    }

    public final void a(f fVar) {
        this.C = fVar.C;
        this.f23269a = (byte) (fVar.f23269a & 240);
        this.A = fVar.A;
        this.D = fVar.D;
        this.O = fVar.O;
        this.B = fVar.B;
        this.G = fVar.G;
    }

    public void b_() throws Exception {
        this.K = Thread.currentThread();
        this.q = true;
        getClass().getName();
        hashCode();
        this.K.getName();
    }

    public void d() {
        this.t = true;
    }

    @Override // com.igexin.c.a.d.a.f
    public void d_() {
        if (this.m || this.n) {
            a();
        }
    }

    public abstract void e();

    protected abstract void f();

    public final void k() {
        this.m = true;
    }

    public final boolean l() {
        return this.o;
    }

    public final boolean m() {
        return this.n;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void n() {
        if (!this.p && !this.r && !this.s) {
            this.m = true;
            this.q = false;
        } else if (this.r && !this.m) {
            this.q = false;
        } else if (!this.p || this.o || this.m) {
        } else {
            this.q = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void o() {
        if (this.O != null) {
            int i = d.a.f23261a;
        }
    }
}
