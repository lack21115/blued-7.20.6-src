package com.opos.cmn.func.dl.base.a;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.opos.cmn.func.dl.base.DownloadRequest;
import com.opos.cmn.func.dl.base.a.a;
import com.opos.cmn.func.dl.base.a.a.e;
import com.opos.cmn.func.dl.base.a.a.f;
import com.opos.cmn.func.dl.base.exception.DlException;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/func/dl/base/a/c.class */
public class c implements d, Comparable<c> {
    private static final String d = c.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    public b f11205a;
    public com.opos.cmn.func.dl.base.g.a b;

    /* renamed from: c  reason: collision with root package name */
    public f f11206c;
    private Context e;
    private com.opos.cmn.func.dl.base.e.b f;
    private com.opos.cmn.func.dl.base.d g;
    private com.opos.cmn.func.dl.base.f.a h;
    private com.opos.cmn.func.dl.base.b.c i;
    private com.opos.cmn.func.dl.base.a.b.a j;
    private List<com.opos.cmn.func.dl.base.e.c> k;
    private com.opos.cmn.func.dl.base.a.a l;
    private CountDownLatch m;
    private Lock n = new ReentrantLock();
    private AtomicLong o = new AtomicLong(0);
    private List<com.opos.cmn.func.dl.base.a.a.c> p = new ArrayList();
    private long q;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/func/dl/base/a/c$a.class */
    public final class a implements f {
        public a() {
        }

        @Override // com.opos.cmn.func.dl.base.a.a.f
        public final void a() {
            File a2 = c.this.f11205a.a();
            if (!com.opos.cmn.an.d.b.a.a(c.this.f11205a.j, a2)) {
                com.opos.cmn.an.f.a.c(c.d, "Rename failed");
                throw new DlException(1004);
            } else if (!com.opos.cmn.func.dl.base.h.a.a(c.this.f11205a.k, a2)) {
                long length = a2.length();
                long j = c.this.f11205a.k;
                String str = c.d;
                com.opos.cmn.an.f.a.c(str, "Length check Failed!Server=" + j + ",local=" + length);
                throw new DlException(1010, String.valueOf(j), String.valueOf(length));
            } else if (com.opos.cmn.func.dl.base.h.a.a(c.this.f11205a.d, a2)) {
                c.this.b.h();
                c.this.d();
            } else {
                String a3 = com.opos.cmn.an.a.c.a(a2);
                String str2 = c.this.f11205a.d;
                String str3 = c.d;
                com.opos.cmn.an.f.a.c(str3, "MD5 check Failed!Server=" + str2 + ",local=" + a3);
                throw new DlException(1005, String.valueOf(str2), String.valueOf(a3));
            }
        }

        @Override // com.opos.cmn.func.dl.base.a.a.f
        public final void a(com.opos.cmn.func.dl.base.a.a.a aVar) {
            e eVar;
            com.opos.cmn.func.dl.base.a.a.d a2 = c.this.h.a();
            e[] eVarArr = a2.b;
            int length = eVarArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    e eVar2 = null;
                    e[] eVarArr2 = a2.b;
                    int length2 = eVarArr2.length;
                    int i3 = 0;
                    while (i3 < length2) {
                        e eVar3 = eVarArr2[i3];
                        if (eVar2 != null) {
                            eVar = eVar2;
                            if (eVar2.a() <= eVar3.a()) {
                                i3++;
                                eVar2 = eVar;
                            }
                        }
                        eVar = eVar3;
                        i3++;
                        eVar2 = eVar;
                    }
                    if (eVar2 != null) {
                        eVar2.a(aVar);
                        return;
                    }
                    return;
                }
                e eVar4 = eVarArr[i2];
                if (eVar4.f11200c.containsKey(Integer.valueOf(aVar.b))) {
                    eVar4.a(aVar);
                    return;
                }
                i = i2 + 1;
            }
        }

        @Override // com.opos.cmn.func.dl.base.a.a.f
        public final void a(com.opos.cmn.func.dl.base.e.c cVar) {
            String str = c.d;
            com.opos.cmn.an.f.a.b(str, "url: " + c.this.f11205a.e + " finish a read thread! ThreadInfo=" + cVar.toString() + ",use time:" + (System.currentTimeMillis() - c.this.q));
        }

        @Override // com.opos.cmn.func.dl.base.a.a.f
        public final void a(DlException dlException) {
            c.this.a(dlException);
        }

        @Override // com.opos.cmn.func.dl.base.a.a.f
        public final void b(com.opos.cmn.func.dl.base.a.a.a aVar) {
            int i = aVar.f11191a;
            if (c.this.k != null && i < c.this.k.size()) {
                ((com.opos.cmn.func.dl.base.e.c) c.this.k.get(i)).d += aVar.f11192c;
                com.opos.cmn.func.dl.base.e.b bVar = c.this.f;
                bVar.f.a(bVar.e);
            }
            long a2 = c.this.j.a(c.this.f11205a.k, c.this.f11205a.l, c.this.q, c.this.f11205a.s.get(), c.this.g.c(), c.this.g.d(), c.this.g.e());
            if (a2 > 0) {
                c.this.b.a(a2);
            }
        }
    }

    public c(DownloadRequest downloadRequest, com.opos.cmn.func.dl.base.f.a aVar) {
        this.h = aVar;
        com.opos.cmn.func.dl.base.d dVar = aVar.f11236c;
        this.g = dVar;
        this.e = dVar.f();
        this.i = this.g.g();
        this.j = new com.opos.cmn.func.dl.base.a.b.b();
        this.f11206c = new a();
        b bVar = new b(downloadRequest, this.g);
        this.f11205a = bVar;
        this.b = new com.opos.cmn.func.dl.base.g.a(bVar, this.h.d);
        this.l = new com.opos.cmn.func.dl.base.a.a(this.f11205a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DlException dlException) {
        this.b.a(dlException);
        d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        CountDownLatch countDownLatch = this.m;
        if (countDownLatch != null) {
            countDownLatch.countDown();
            this.m = null;
        }
    }

    private void e() {
        for (com.opos.cmn.func.dl.base.a.a.c cVar : this.p) {
            cVar.f11195a = true;
        }
        this.p.clear();
    }

    private void f() {
        this.i.b().remove(this);
    }

    public final void a() {
        this.b.f();
        d();
        e();
        f();
    }

    public final void a(boolean z) {
        if (this.b.c()) {
            try {
                com.opos.cmn.func.dl.base.a.a aVar = this.l;
                String str = aVar.b.e;
                if (TextUtils.isEmpty(str) || !str.matches("(https?|ftp|file)://[-A-Za-z0-9+&@#/%?=~_|!:,.;]+[-A-Za-z0-9+&@#/%=~_|]")) {
                    throw new DlException(1007);
                }
                if (!com.opos.cmn.an.h.c.a.d(aVar.f11188c)) {
                    throw new DlException(1003);
                }
                aVar.a(z);
                if (!com.opos.cmn.func.dl.base.h.a.a(aVar.f11188c)) {
                    com.opos.cmn.an.f.a.c(com.opos.cmn.func.dl.base.a.a.f11187a, "has no storage permission");
                }
                if (this.b.d()) {
                    this.i.b().execute(this);
                }
            } catch (DlException e) {
                a(e);
            }
        }
    }

    public final void b() {
        this.b.g();
        d();
        e();
        f();
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(c cVar) {
        return cVar.f11205a.b - this.f11205a.b >= 0 ? 1 : -1;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.opos.cmn.func.dl.base.e.c cVar;
        com.opos.cmn.an.f.a.b(d, "Download task begin run");
        try {
            try {
                long incrementAndGet = this.o.incrementAndGet();
                this.n.lock();
                this.q = SystemClock.uptimeMillis();
                if (this.b.b() && incrementAndGet == this.o.get()) {
                    this.l.a(false);
                    if (this.b.e()) {
                        a.C0470a a2 = this.l.a();
                        if (this.b.b() && incrementAndGet == this.o.get()) {
                            this.l.a(false);
                            if (a2.f) {
                                this.b.h();
                            } else {
                                if (this.f == null) {
                                    this.f = new com.opos.cmn.func.dl.base.e.b(this.f11205a);
                                }
                                com.opos.cmn.func.dl.base.e.b bVar = this.f;
                                com.opos.cmn.an.f.a.b(com.opos.cmn.func.dl.base.e.b.f11227a, "get thread infos!");
                                bVar.e = bVar.f.a();
                                if (bVar.e == null || bVar.e.isEmpty()) {
                                    if (com.opos.cmn.an.d.b.a.a(bVar.b)) {
                                        com.opos.cmn.an.d.b.a.e(bVar.b);
                                    }
                                    if (com.opos.cmn.an.d.b.a.a(bVar.f11228c)) {
                                        com.opos.cmn.an.d.b.a.e(bVar.f11228c);
                                    }
                                    com.opos.cmn.func.dl.base.h.a.a(bVar.b);
                                    com.opos.cmn.func.dl.base.h.a.a(bVar.f11228c);
                                    long j = bVar.d.k;
                                    boolean a3 = com.opos.cmn.func.dl.base.e.b.a(j, Boolean.valueOf(bVar.d.m));
                                    int a4 = com.opos.cmn.func.dl.base.e.b.a(j, a3);
                                    com.opos.cmn.an.f.a.b(com.opos.cmn.func.dl.base.e.b.f11227a, "block num=".concat(String.valueOf(a4)));
                                    bVar.e = new ArrayList(a4);
                                    if (a3) {
                                        long j2 = j / a4;
                                        com.opos.cmn.an.f.a.a(com.opos.cmn.func.dl.base.e.b.f11227a, "average:".concat(String.valueOf(j2)));
                                        int i = 0;
                                        while (true) {
                                            int i2 = i;
                                            if (i2 >= a4) {
                                                break;
                                            }
                                            long j3 = i2 * j2;
                                            bVar.e.add(new com.opos.cmn.func.dl.base.e.c(i2, j3, 0L, i2 == a4 - 1 ? j - j3 : j2));
                                            com.opos.cmn.an.f.a.b(com.opos.cmn.func.dl.base.e.b.f11227a, "thread info:" + cVar.toString());
                                            i = i2 + 1;
                                        }
                                    } else {
                                        bVar.e.add(new com.opos.cmn.func.dl.base.e.c(0, 0L, 0L, j));
                                    }
                                }
                                int i3 = 0;
                                for (com.opos.cmn.func.dl.base.e.c cVar2 : bVar.e) {
                                    i3 = (int) (cVar2.d + i3);
                                }
                                b bVar2 = bVar.d;
                                long j4 = i3;
                                bVar2.l = j4;
                                bVar.d.a(j4);
                                this.k = bVar.e;
                                if (this.b.b() && incrementAndGet == this.o.get()) {
                                    this.l.a(false);
                                    for (com.opos.cmn.func.dl.base.e.c cVar3 : this.k) {
                                        if (cVar3.d < cVar3.f11230c || cVar3.f11230c == -1) {
                                            com.opos.cmn.func.dl.base.a.a.c cVar4 = new com.opos.cmn.func.dl.base.a.a.c(this.e, this.h.e, this, cVar3);
                                            this.i.c().execute(cVar4);
                                            this.p.add(cVar4);
                                        }
                                    }
                                    if (this.b.a() == 3) {
                                        CountDownLatch countDownLatch = new CountDownLatch(1);
                                        this.m = countDownLatch;
                                        countDownLatch.await();
                                    }
                                }
                            }
                        }
                    }
                }
            } catch (DlException e) {
                a(e);
            } catch (Exception e2) {
                a(new DlException(1000, e2));
            }
        } finally {
            this.n.unlock();
        }
    }
}
