package com.opos.mobad.f.a.a;

import android.os.SystemClock;
import com.opos.mobad.f.a.a.n;
import com.opos.mobad.service.a.e;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/f/a/a/c.class */
public class c<T extends n> extends com.opos.mobad.l.j implements m, n, o {

    /* renamed from: a  reason: collision with root package name */
    private String f26022a;
    private T b;

    /* renamed from: c  reason: collision with root package name */
    private volatile T f26023c;
    private volatile boolean d;
    private volatile boolean g;
    private a<T> h;
    private int i;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/f/a/a/c$a.class */
    public interface a<T extends n> {
        int a(int i);

        T a(List<e.a> list, e.a aVar, long j);

        T a(List<e.a> list, e.a aVar, long j, int i);
    }

    public c(String str, int i, a<T> aVar) {
        super(null);
        this.d = false;
        this.g = false;
        this.f26022a = str;
        this.i = i;
        this.h = aVar;
        this.b = q();
        p();
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x00fb, code lost:
        if (r13 == null) goto L39;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.opos.mobad.service.a.e.a a(java.lang.String r11, java.util.List<com.opos.mobad.service.a.e.a> r12, com.opos.mobad.service.a.e.a r13, long r14) {
        /*
            Method dump skipped, instructions count: 280
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.f.a.a.c.a(java.lang.String, java.util.List, com.opos.mobad.service.a.e$a, long):com.opos.mobad.service.a.e$a");
    }

    private static e.a a(List<e.a> list, String str, long j) {
        ArrayList arrayList = list;
        if (list == null) {
            arrayList = new ArrayList();
        }
        e.a aVar = null;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        for (e.a aVar2 : arrayList) {
            if (1 == aVar2.f27301a) {
                aVar = aVar2;
            }
            i2 = aVar2.d;
            i3 = aVar2.e;
            i += aVar2.f;
        }
        e.a aVar3 = aVar;
        if (aVar == null) {
            aVar3 = new e.a(1, str, Math.max(0, 100 - i), j, i2, i3);
            arrayList.add(aVar3);
        }
        return aVar3;
    }

    private boolean a(e.b bVar) {
        for (e.a aVar : bVar.f27303a) {
            if (aVar != null) {
                int a2 = this.h.a(aVar.f27301a);
                if (a2 != 0 && 2 != a2 && 3 != a2) {
                    com.opos.cmn.an.f.a.b("dispatcherW", "has channel not init " + aVar.f27301a);
                    return false;
                }
                com.opos.cmn.an.f.a.b("dispatcherW", "has channel init " + aVar.f27301a);
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public e.b b(e.b bVar) {
        if (bVar == null) {
            return null;
        }
        e.b bVar2 = bVar;
        if (bVar.f27303a != null) {
            if (bVar.f27303a.size() <= 0) {
                return bVar;
            }
            ArrayList arrayList = new ArrayList();
            for (e.a aVar : bVar.f27303a) {
                if (aVar != null && this.h.a(aVar.f27301a) == 0) {
                    arrayList.add(aVar);
                }
            }
            bVar2 = new e.b(arrayList, bVar.e, bVar.b, bVar.f27304c, bVar.d);
        }
        return bVar2;
    }

    private static e.a c(String str) {
        return new e.a(1, str, 100, 30000L, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(e.b bVar) {
        T a2;
        synchronized (this) {
            com.opos.cmn.an.f.a.b("dispatcherW", "initDispatcher:" + this.g + "," + this.d, bVar);
            if (!this.g && !this.d) {
                if (bVar.f27303a != null && bVar.f27303a.size() > 0) {
                    if (1 != bVar.e) {
                        e.a a3 = a(bVar.f27303a, this.f26022a, bVar.f27304c);
                        com.opos.cmn.an.f.a.b("dispatcherW", "create ssp:", this.f26022a, bVar.f27303a, a3);
                        a2 = this.h.a(bVar.f27303a, a3, bVar.d, bVar.e);
                    } else {
                        e.a a4 = a(this.f26022a, bVar.f27303a, bVar.b, bVar.f27304c);
                        com.opos.cmn.an.f.a.b("dispatcherW", "create serial:", this.f26022a, bVar.f27303a, a4);
                        a2 = this.h.a(bVar.f27303a, a4, bVar.d);
                    }
                    this.d = true;
                    com.opos.cmn.an.f.a.b("dispatcherW", "dispatcher succ");
                    this.f26023c = a2;
                    if (this.g) {
                        a2.b();
                    }
                }
                com.opos.cmn.an.f.a.b("dispatcherW", "strategy size 0 ");
                this.d = true;
            }
        }
    }

    private void c(String str, int i) {
        if (this.f26023c != null) {
            com.opos.cmn.an.f.a.b("dispatcherW", "reset to target");
            T t = this.b;
            this.b = this.f26023c;
            t.b();
            this.f26023c = null;
        }
        this.b.a(str, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str, int i) {
        try {
            c(str, i);
        } finally {
            o();
        }
    }

    private void m() {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.f.a.a.c.2
            @Override // java.lang.Runnable
            public void run() {
                c.this.p();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        e.b a2 = a(0L);
        if (a2 != null) {
            c(a2);
        }
    }

    private T q() {
        return this.h.a(new ArrayList(), c(this.f26022a), 0L);
    }

    public e.b a(long j) {
        e.b bVar;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        e.b a2 = com.opos.mobad.service.f.b().a(this.f26022a, true);
        com.opos.cmn.an.f.a.b("dispatcherW", "channelStrategy = " + a2);
        if (a2 == null || !a(a2)) {
            if (j > 0) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= 10) {
                        return b(a2);
                    }
                    a2 = com.opos.mobad.service.f.b().a(this.f26022a, true);
                    if (a2 != null) {
                        bVar = a2;
                        if (a(a2)) {
                            break;
                        }
                    }
                    int elapsedRealtime2 = ((int) (j - (SystemClock.elapsedRealtime() - elapsedRealtime))) / (10 - i2);
                    if (elapsedRealtime2 <= 0) {
                        break;
                    }
                    try {
                        Thread.sleep(elapsedRealtime2);
                    } catch (Exception e) {
                        com.opos.cmn.an.f.a.b("dispatcherW", "sleep timeout", e);
                    }
                    i = i2 + 1;
                }
            }
            bVar = null;
            return bVar;
        }
        return a2;
    }

    @Override // com.opos.mobad.f.a.a.m
    public void a(int i, int i2) {
        T t = this.b;
        if (t instanceof m) {
            ((m) t).a(i, i2);
        }
    }

    @Override // com.opos.mobad.f.a.a.n
    public void a(int i, int i2, String str) {
        this.b.a(i, i2, str);
    }

    @Override // com.opos.mobad.l.j, com.opos.mobad.ad.b
    public void b() {
        com.opos.cmn.an.f.a.b("dispatcherW", "destroy");
        this.g = true;
        super.b();
        T t = this.b;
        if (t != null) {
            t.b();
        }
        if (this.f26023c != null) {
            this.f26023c.b();
        }
    }

    @Override // com.opos.mobad.l.j
    public boolean b(String str) {
        return false;
    }

    @Override // com.opos.mobad.l.j
    public boolean b(final String str, final int i) {
        if (!this.d) {
            if (this.i > 0) {
                com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.f.a.a.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        e.b b;
                        com.opos.cmn.an.f.a.b("dispatcherW", "init and load ad");
                        if (!c.this.d) {
                            FutureTask futureTask = new FutureTask(new Callable<e.b>() { // from class: com.opos.mobad.f.a.a.c.1.1
                                @Override // java.util.concurrent.Callable
                                /* renamed from: a */
                                public e.b call() throws Exception {
                                    return c.this.a(c.this.i);
                                }
                            });
                            com.opos.cmn.an.j.b.c(futureTask);
                            try {
                                b = (e.b) futureTask.get(c.this.i, TimeUnit.MILLISECONDS);
                            } catch (Exception e) {
                                com.opos.cmn.an.f.a.b("dispatcherW", "init timeout");
                                b = c.this.b(com.opos.mobad.service.f.b().a(c.this.f26022a, true));
                            }
                            if (b != null) {
                                c.this.c(b);
                            }
                        }
                        c.this.e.post(new Runnable() { // from class: com.opos.mobad.f.a.a.c.1.2
                            @Override // java.lang.Runnable
                            public void run() {
                                c.this.d(str, i);
                            }
                        });
                    }
                });
                return true;
            }
            m();
        }
        d(str, i);
        return true;
    }

    @Override // com.opos.mobad.ad.b
    public int c() {
        return this.b.c();
    }

    @Override // com.opos.mobad.f.a.a.n
    public void d(int i) {
        this.b.d(i);
    }

    @Override // com.opos.mobad.f.a.a.n
    public void e(int i) {
        this.b.e(i);
    }

    @Override // com.opos.mobad.f.a.a.o
    public List h() {
        T t = this.b;
        if (t instanceof o) {
            ((o) t).h();
            return null;
        }
        return null;
    }

    @Override // com.opos.mobad.f.a.a.n
    public com.opos.mobad.ad.b i() {
        return this.b.i();
    }

    @Override // com.opos.mobad.f.a.a.n
    public int j() {
        return this.b.j();
    }

    @Override // com.opos.mobad.f.a.a.n
    public e.a k() {
        return this.b.k();
    }
}
