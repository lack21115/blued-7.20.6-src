package com.opos.mobad.f.a.a;

import com.opos.mobad.ad.b;
import com.opos.mobad.f.a.a.t;
import com.opos.mobad.f.a.c.a;
import com.opos.mobad.f.a.m;
import com.opos.mobad.service.a.e;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/f/a/a/h.class */
public abstract class h<T extends com.opos.mobad.ad.b> extends com.opos.mobad.l.j implements n<T> {

    /* renamed from: a  reason: collision with root package name */
    private String f26032a;
    protected Map<Integer, T> b;

    /* renamed from: c  reason: collision with root package name */
    private String f26033c;
    private int d;
    private int g;
    private int h;
    private com.opos.mobad.f.a.m<a.C0695a> i;
    private com.opos.mobad.f.a.n j;
    private t<e.a> k;
    private Map<Integer, Boolean> l;
    private Map<Integer, e.a> m;
    private e.a n;
    private com.opos.mobad.f.a.c.a o;
    private w p;
    private int q;
    private String r;

    public h(final String str, int i, com.opos.mobad.f.a.c.a aVar, List<e.a> list, e.a aVar2, long j, com.opos.mobad.f.a.b.a<T> aVar3, b.a aVar4) {
        super(aVar4);
        this.g = -1;
        this.h = -1;
        this.f26033c = str;
        this.d = i;
        this.o = aVar;
        this.p = new w(str, j);
        this.i = new com.opos.mobad.f.a.m<>(new m.a<a.C0695a>() { // from class: com.opos.mobad.f.a.a.h.1
            @Override // com.opos.mobad.f.a.m.a
            public void a(a.C0695a c0695a) {
                if (c0695a == null) {
                    return;
                }
                h hVar = h.this;
                int i2 = c0695a.b;
                hVar.b(i2, "" + c0695a.f26075c);
            }
        });
        this.j = new com.opos.mobad.f.a.n(new Runnable() { // from class: com.opos.mobad.f.a.a.h.2
            @Override // java.lang.Runnable
            public void run() {
                com.opos.cmn.an.f.a.a("delegator", "timeout for next =" + str);
                if (1 != h.this.d()) {
                    com.opos.cmn.an.f.a.b("delegator", "start with error state");
                    return;
                }
                h.this.p.a(h.this.h, -2);
                h.this.a(-1, com.opos.mobad.ad.a.a(-1));
            }
        });
        this.b = new ConcurrentHashMap(list.size());
        this.l = new ConcurrentHashMap(list.size());
        this.m = new HashMap(list.size());
        a(list, aVar3);
        if (aVar2 != null) {
            a(aVar2, aVar3);
        }
    }

    private void a(e.a aVar, com.opos.mobad.f.a.b.a<T> aVar2) {
        if (!this.b.containsKey(Integer.valueOf(aVar.f27301a))) {
            T b = aVar2.b(aVar, this);
            if (b == null) {
                com.opos.cmn.an.f.a.d("delegator", "disable reserve");
                return;
            }
            this.b.put(Integer.valueOf(aVar.f27301a), b);
        }
        this.n = aVar;
    }

    private void a(List<e.a> list, com.opos.mobad.f.a.b.a<T> aVar) {
        StringBuilder sb;
        t.a aVar2 = new t.a();
        com.opos.cmn.an.f.a.b("delegator", "channel size:" + list.size());
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                this.k = aVar2.a();
                return;
            }
            e.a aVar3 = list.get(i2);
            this.m.put(Integer.valueOf(aVar3.f27301a), aVar3);
            if (aVar3.f <= 0) {
                sb = new StringBuilder();
                sb.append("percent fail with channel:");
                sb.append(aVar3.f27301a);
            } else {
                T b = aVar.b(aVar3, this);
                if (b == null) {
                    sb = new StringBuilder();
                    sb.append("ad null with channel:");
                    sb.append(aVar3);
                } else {
                    this.b.put(Integer.valueOf(aVar3.f27301a), b);
                    aVar2.a(aVar3, aVar3.f);
                    i = i2 + 1;
                }
            }
            com.opos.cmn.an.f.a.a("delegator", sb.toString());
            i = i2 + 1;
        }
    }

    private void d(int i, String str) {
        this.q = i;
        this.r = str;
        e.a a2 = this.k.a();
        e.a aVar = a2;
        if (a2 == null) {
            com.opos.cmn.an.f.a.b("delegator", "reserve:" + this.n + ",current:" + this.h);
            e.a aVar2 = this.n;
            if (aVar2 == null || this.h == aVar2.f27301a) {
                b(i, str);
                this.p.b(-7);
                return;
            }
            aVar = this.n;
        }
        this.h = aVar.f27301a;
        a.C0695a a3 = this.o.a(aVar.f27301a);
        if (a3 != null && !a3.f26074a) {
            this.p.a(aVar.f27301a, a3.b);
            d(i, str);
            return;
        }
        com.opos.cmn.an.f.a.b("delegator", "start:" + aVar.f27301a);
        if (aVar.f27301a != 1 && this.l.containsKey(Integer.valueOf(aVar.f27301a)) && this.l.get(Integer.valueOf(aVar.f27301a)).booleanValue() && g(aVar.f27301a)) {
            final int i2 = aVar.f27301a;
            com.opos.cmn.an.f.a.b("delegator", "cache");
            com.opos.mobad.service.c.a(new Runnable() { // from class: com.opos.mobad.f.a.a.h.4
                @Override // java.lang.Runnable
                public void run() {
                    h.this.i(i2);
                }
            });
            return;
        }
        a(this.f26032a, aVar);
        com.opos.cmn.an.f.a.b("delegator", "timeout:" + aVar.f27302c);
        this.j.a(aVar.f27302c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(final int i) {
        this.i.a();
        this.j.a();
        a.C0695a a2 = this.o.a(this.f26033c, i);
        if (a2.f26074a) {
            c(new Callable<Boolean>() { // from class: com.opos.mobad.f.a.a.h.5
                @Override // java.util.concurrent.Callable
                /* renamed from: a */
                public Boolean call() {
                    h.this.f(i);
                    return true;
                }
            });
            return;
        }
        b(a2.b, a2.f26075c);
        this.p.b(a2.b);
    }

    @Override // com.opos.mobad.f.a.a.n
    public final void a(int i, int i2, String str) {
        com.opos.cmn.an.f.a.a("delegator", "onChannelPercentFailed :" + i + ",code: " + i2 + ", msg:" + str);
        if (i != this.h) {
            return;
        }
        if (1 != d()) {
            com.opos.cmn.an.f.a.b("delegator", "start with error state");
            return;
        }
        this.p.a(i, i2);
        a(i2, str);
    }

    protected final void a(int i, String str) {
        if (1 != d()) {
            com.opos.cmn.an.f.a.b("delegator", "start with error state");
        } else {
            d(i, str);
        }
    }

    @Override // com.opos.mobad.l.j, com.opos.mobad.ad.b
    public void a(String str) {
        a(str, this.d);
    }

    protected void a(String str, e.a aVar) {
        T t = this.b.get(Integer.valueOf(aVar.f27301a));
        if (aVar.f27301a == 1) {
            t.a(str, (int) aVar.f27302c);
        } else {
            t.a(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(T t, int i) {
        if (t == null) {
            return false;
        }
        return t.e();
    }

    @Override // com.opos.mobad.l.j, com.opos.mobad.ad.b
    public void b() {
        this.i.b();
        this.j.b();
        if (this.p != null && d() == 1) {
            this.p.b(-6);
        }
        this.k.b();
        super.b();
        for (Integer num : this.b.keySet()) {
            this.b.get(num).b();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean b(int i, int i2, String str) {
        return false;
    }

    @Override // com.opos.mobad.l.j
    public boolean b(String str) {
        com.opos.cmn.an.f.a.b("delegator", "doload:" + str);
        a.C0695a a2 = this.o.a(this.f26033c);
        this.p.a(str);
        this.p.a();
        if (!a2.f26074a) {
            com.opos.cmn.an.f.a.b("delegator", "intercept " + a2.f26075c);
            this.i.a(500L, a2);
            this.p.c(a2.b);
            return true;
        }
        this.g = -1;
        this.h = -1;
        this.f26032a = str;
        this.i.a();
        this.j.a();
        this.k.b();
        d(-1, com.opos.mobad.ad.a.a(-1));
        return true;
    }

    @Override // com.opos.mobad.ad.b
    public int c() {
        return 0;
    }

    @Override // com.opos.mobad.f.a.a.n
    public final void d(int i) {
        com.opos.cmn.an.f.a.a("delegator", "onChannelPercentSucc :" + i);
        this.l.put(Integer.valueOf(i), true);
        if (d() == 1 && i == this.h && !b(i, this.q, this.r)) {
            i(i);
        }
    }

    @Override // com.opos.mobad.f.a.a.n
    public void e(int i) {
        if (i == j()) {
            i_();
        }
    }

    @Override // com.opos.mobad.l.j, com.opos.mobad.ad.b
    public boolean e() {
        return a((h<T>) this.b.get(Integer.valueOf(this.g)), this.g);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(int i) {
        com.opos.cmn.an.f.a.a("delegator", "percent select:" + i);
        this.p.a(i);
        this.l.put(Integer.valueOf(i), false);
        this.g = i;
    }

    protected boolean g(int i) {
        return a((h<T>) this.b.get(Integer.valueOf(i)), i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h(int i) {
        this.l.put(Integer.valueOf(i), false);
    }

    @Override // com.opos.mobad.f.a.a.n
    public T i() {
        return this.b.get(Integer.valueOf(this.g));
    }

    @Override // com.opos.mobad.f.a.a.n
    public int j() {
        int i = -1;
        if (2 == d()) {
            i = this.g;
            if (i == -1) {
                return -1;
            }
        }
        return i;
    }

    @Override // com.opos.mobad.f.a.a.n
    public e.a k() {
        return this.m.get(Integer.valueOf(j()));
    }

    @Override // com.opos.mobad.l.j
    public void l() {
        a(new Callable<Boolean>() { // from class: com.opos.mobad.f.a.a.h.3
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Boolean call() throws Exception {
                h.this.i.a();
                h.this.j.a();
                if (h.this.h != -1) {
                    h.this.p.a(h.this.h, -2);
                }
                h.this.p.b(-2);
                return true;
            }
        });
    }
}
