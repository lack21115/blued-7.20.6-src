package com.tencent.mapsdk.internal;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/z.class */
public class z implements b1, ce {
    public static final int q = 60;
    private static final int r = 200;
    private a k;
    private d9 m;
    private long n;
    private boolean o;
    private l5 p;
    private ArrayList<a9> g = new ArrayList<>();
    private final byte[] h = new byte[0];
    private ArrayList<a9> i = new ArrayList<>();
    private ArrayList<a9> j = new ArrayList<>();
    private int l = 60;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/z$a.class */
    public class a extends Thread {
        private boolean b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f38142c;

        public a() {
            super("tms-act");
        }

        public void a() {
            synchronized (this) {
                this.f38142c = false;
            }
        }

        public void b() {
            synchronized (this) {
                this.f38142c = true;
            }
        }

        @Override // java.lang.Thread
        public void destroy() {
            synchronized (this) {
                this.b = false;
                interrupt();
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (this.b) {
                if (!this.f38142c) {
                    if (z.this.m != null) {
                        z.this.m.a(a9.z);
                    }
                    if (z.this.o && System.currentTimeMillis() - z.this.n > 50) {
                        z.this.o = false;
                        na.a(ma.f, "notify onStable");
                        if (z.this.p != null) {
                            z.this.p.b();
                        }
                    }
                }
                try {
                    synchronized (this) {
                        wait(z.this.e());
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        }

        @Override // java.lang.Thread
        public void start() {
            synchronized (this) {
                this.b = true;
                super.start();
            }
        }
    }

    public z(d9 d9Var) {
        this.m = d9Var;
        z8.f(e());
    }

    @Override // com.tencent.mapsdk.internal.ce
    public void a() {
    }

    public void a(double d, double d2) {
        synchronized (this.h) {
            while (!this.g.isEmpty()) {
                ArrayList<a9> arrayList = this.g;
                if (arrayList.get(arrayList.size() - 1).f37291a != 3) {
                    break;
                }
                ArrayList<a9> arrayList2 = this.g;
                double[] dArr = arrayList2.remove(arrayList2.size() - 1).b;
                d += dArr[0];
                d2 += dArr[1];
            }
            a(new a9(3, new double[]{d, d2}));
        }
    }

    public void a(int i) {
        synchronized (this.h) {
            int size = this.g.size();
            while (true) {
                int i2 = size - 1;
                if (i2 >= 0) {
                    a9 a9Var = this.g.get(i2);
                    if (a9Var.f37291a == i) {
                        this.g.remove(i2);
                        a9Var.b();
                    }
                    size = i2;
                }
            }
        }
    }

    public void a(a9 a9Var) {
        synchronized (this.h) {
            if (this.g.size() > 200) {
                this.g.clear();
            }
            this.g.add(a9Var);
        }
        a();
    }

    public void a(l5 l5Var) {
        this.p = l5Var;
    }

    @Override // com.tencent.mapsdk.internal.b1
    public void a(v vVar) {
        this.o = true;
        this.n = System.currentTimeMillis();
    }

    public void b() {
        synchronized (this.h) {
            this.j.clear();
            this.i.clear();
            boolean z = false;
            Iterator<a9> it = this.g.iterator();
            while (it.hasNext()) {
                a9 next = it.next();
                if (next.e) {
                    z = true;
                    this.i.add(next);
                } else {
                    this.j.add(next);
                }
            }
            this.g.clear();
            if (z) {
                ArrayList<a9> arrayList = this.g;
                this.g = this.i;
                this.i = arrayList;
            }
            if (this.j.size() > 0) {
                Iterator<a9> it2 = this.j.iterator();
                while (it2.hasNext()) {
                    it2.next().b();
                }
            }
        }
    }

    public void b(int i) {
        if (i <= 0) {
            return;
        }
        this.l = i;
    }

    public void c() {
        a aVar = this.k;
        if (aVar != null) {
            aVar.destroy();
        }
    }

    public void d() {
        a aVar = this.k;
    }

    public long e() {
        long j = 1000 / this.l;
        long j2 = j;
        if (j == 0) {
            j2 = 1;
        }
        return j2;
    }

    public int f() {
        return this.l;
    }

    public boolean g() {
        boolean isEmpty;
        synchronized (this.h) {
            isEmpty = this.g.isEmpty();
        }
        return !isEmpty;
    }

    public void h() {
        a aVar = this.k;
        if (aVar != null) {
            aVar.b();
        }
        b();
    }

    public boolean i() {
        boolean isEmpty;
        synchronized (this.h) {
            if (this.g.isEmpty()) {
                return false;
            }
            a9 a9Var = this.g.get(0);
            if (a9Var != null && a9Var.a(this.m)) {
                a9Var.c();
                synchronized (this.h) {
                    this.g.remove(a9Var);
                }
            }
            synchronized (this.h) {
                isEmpty = this.g.isEmpty();
            }
            return !isEmpty;
        }
    }

    public void j() {
        this.l = 60;
    }

    public void k() {
        a aVar = this.k;
        if (aVar != null) {
            aVar.a();
        }
    }

    public void l() {
        a aVar = this.k;
        if (aVar != null) {
            aVar.destroy();
        }
        a aVar2 = new a();
        this.k = aVar2;
        aVar2.start();
    }
}
