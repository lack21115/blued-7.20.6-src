package com.opos.mobad.f.a.a;

import com.opos.mobad.ad.b;
import com.opos.mobad.f.a.a.t;
import com.opos.mobad.f.a.c.a;
import com.opos.mobad.f.a.m;
import com.opos.mobad.service.a.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/f/a/a/i.class */
public class i<T extends com.opos.mobad.ad.b> extends com.opos.mobad.l.j implements n<T> {

    /* renamed from: a  reason: collision with root package name */
    private String f26039a;
    protected Map<Integer, T> b;

    /* renamed from: c  reason: collision with root package name */
    protected HashMap<Integer, e.a> f26040c;
    private int d;
    private int g;
    private t<e.a> h;
    private u i;
    private j j;
    private Map<Integer, e.a> k;
    private e.a l;
    private CountDownLatch m;
    private com.opos.mobad.f.a.c.a n;
    private v o;
    private Map<Integer, Integer> p;
    private com.opos.mobad.f.a.m<a.C0695a> q;
    private int r;
    private String s;
    private int t;

    public i(String str, int i, com.opos.mobad.f.a.c.a aVar, List<e.a> list, e.a aVar2, long j, int i2, com.opos.mobad.f.a.b.a<T> aVar3, b.a aVar4) {
        super(aVar4);
        this.g = -1;
        this.m = null;
        this.r = -1;
        this.s = "unknown error.";
        this.n = aVar;
        this.o = new v(str, i2, j);
        this.p = new HashMap();
        this.f26039a = str;
        this.t = i2;
        this.d = i;
        this.b = new ConcurrentHashMap(list.size());
        this.f26040c = new HashMap<>(list.size());
        this.k = new HashMap(list.size());
        a(list, aVar3);
        if (aVar2 != null) {
            a(aVar2, aVar3);
        }
        this.q = new com.opos.mobad.f.a.m<>(new m.a<a.C0695a>() { // from class: com.opos.mobad.f.a.a.i.1
            @Override // com.opos.mobad.f.a.m.a
            public void a(a.C0695a c0695a) {
                if (c0695a == null) {
                    return;
                }
                i iVar = i.this;
                int i3 = c0695a.b;
                iVar.b(i3, "" + c0695a.f26075c);
            }
        });
    }

    private void a(e.a aVar, com.opos.mobad.f.a.b.a<T> aVar2) {
        if (!this.b.containsKey(Integer.valueOf(aVar.f27301a))) {
            T b = aVar2.b(aVar, this);
            if (b == null) {
                com.opos.cmn.an.f.a.d("delegator", "disable main");
                return;
            }
            a(aVar, (e.a) b);
        }
        this.l = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, boolean z) {
        int i;
        e.a p = this.t == 3 ? p() : null;
        if (p != null) {
            h();
        } else {
            p = q();
            if (p == null) {
                com.opos.cmn.an.f.a.a("delegator", "deal rank but fail,deal percent");
                e.a r = r();
                if (r != null) {
                    i = r.f27301a;
                    e(str, i);
                }
                com.opos.cmn.an.f.a.a("delegator", "deal fail ,posid=" + this.f26039a);
                if (!z) {
                    l();
                    this.o.b(-2);
                    return;
                }
                int i2 = this.r;
                if (i2 == -1) {
                    b(-7, this.r + "," + this.s);
                } else {
                    b(i2, this.s);
                }
                this.o.b(-7);
                return;
            }
        }
        i = p.f27301a;
        e(str, i);
    }

    private void a(List<e.a> list, com.opos.mobad.f.a.b.a<T> aVar) {
        StringBuilder sb;
        ArrayList arrayList = new ArrayList();
        t.a aVar2 = new t.a();
        com.opos.cmn.an.f.a.b("delegator", "channel size:" + list.size());
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                this.h = aVar2.a();
                this.i = new u(arrayList);
                this.j = new j(arrayList);
                return;
            }
            e.a aVar3 = list.get(i2);
            this.k.put(Integer.valueOf(aVar3.f27301a), aVar3);
            T b = aVar.b(aVar3, this);
            if (b == null) {
                sb = new StringBuilder();
                sb.append("ad null with channel:");
                sb.append(aVar3);
            } else {
                a(aVar3, (e.a) b);
                arrayList.add(aVar3);
                if (aVar3.f <= 0) {
                    sb = new StringBuilder();
                    sb.append("percent fail with channel:");
                    sb.append(aVar3.f27301a);
                } else {
                    aVar2.a(aVar3, aVar3.f);
                    i = i2 + 1;
                }
            }
            com.opos.cmn.an.f.a.b("delegator", sb.toString());
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(e.a aVar) {
        if (aVar == null) {
            com.opos.cmn.an.f.a.b("delegator", "check to select but entity is null");
            return false;
        } else if (f(aVar.f27301a)) {
            return true;
        } else {
            Integer num = this.p.get(Integer.valueOf(aVar.f27301a));
            Integer num2 = num;
            if (num == null) {
                num2 = -2;
            }
            this.o.a(aVar.f27301a, num2.intValue());
            return false;
        }
    }

    private void e(final String str, final int i) {
        this.q.a();
        a.C0695a a2 = this.n.a(this.f26039a, i);
        if (a2.f26074a) {
            c(new Callable<Boolean>() { // from class: com.opos.mobad.f.a.a.i.4
                @Override // java.util.concurrent.Callable
                /* renamed from: a */
                public Boolean call() {
                    i.this.c(str, i);
                    return true;
                }
            });
            return;
        }
        b(a2.b, a2.f26075c);
        this.o.b(a2.b);
    }

    private void h() {
        Map<Integer, T> map = this.b;
        if (map == null) {
            return;
        }
        for (Integer num : map.keySet()) {
            int intValue = num.intValue();
            if (!f(intValue)) {
                Integer num2 = this.p.get(Integer.valueOf(intValue));
                Integer num3 = num2;
                if (num2 == null) {
                    num3 = -2;
                }
                this.o.a(intValue, num3.intValue());
            }
        }
    }

    private e.a p() {
        this.o.c();
        return m();
    }

    private e.a q() {
        T t;
        e.a aVar = this.l;
        if (aVar == null || (t = this.b.get(Integer.valueOf(aVar.f27301a))) == null) {
            return null;
        }
        int c2 = t.c();
        com.opos.cmn.an.f.a.b("delegator", "deal rank dispatchMode =" + c2);
        if (c2 > 0) {
            this.i.a();
            this.o.b();
            e.a a2 = this.i.a(c2, new com.opos.cmn.i.e<e.a, Boolean>() { // from class: com.opos.mobad.f.a.a.i.3
                @Override // com.opos.cmn.i.e
                public Boolean a(e.a aVar2) {
                    return Boolean.valueOf(i.this.a(aVar2));
                }
            });
            if (a2 != null) {
                return a2;
            }
            return null;
        }
        return null;
    }

    private e.a r() {
        this.o.a();
        this.h.b();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.b.size()) {
                return null;
            }
            e.a a2 = this.h.a();
            if (a(a2)) {
                return a2;
            }
            i = i2 + 1;
        }
    }

    @Override // com.opos.mobad.f.a.a.n
    public final void a(int i, int i2, String str) {
        com.opos.cmn.an.f.a.a("delegator", "onChannelRankFailed:" + i + ",code: " + i2 + ", msg:" + str);
        this.r = i2;
        this.s = str;
        this.p.put(Integer.valueOf(i), Integer.valueOf(i2));
        CountDownLatch countDownLatch = this.m;
        if (countDownLatch != null) {
            try {
                countDownLatch.countDown();
            } catch (Exception e) {
                com.opos.cmn.an.f.a.b("delegator", "fail:" + i, e);
            }
        }
    }

    protected void a(e.a aVar, T t) {
        this.b.put(Integer.valueOf(aVar.f27301a), t);
    }

    protected void a(String str, List<Integer> list, int i) {
        if (list == null || list.isEmpty()) {
            com.opos.cmn.an.f.a.a("SyncStateController", "error Map to load");
            return;
        }
        for (Integer num : list) {
            int intValue = num.intValue();
            T t = this.b.get(Integer.valueOf(intValue));
            if (t != null) {
                if (intValue == 1) {
                    t.a(str, i);
                } else {
                    t.a(str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(T t, int i) {
        if (t == null) {
            return false;
        }
        return t.e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(Map.Entry<Integer, T> entry, T t) {
        a.C0695a a2;
        return (entry.getKey().intValue() == 1 || this.g == entry.getKey().intValue() || t.d() != 2 || !t.e()) && (a2 = this.n.a(entry.getKey().intValue())) != null && a2.f26074a;
    }

    @Override // com.opos.mobad.l.j, com.opos.mobad.ad.b
    public void b() {
        if (this.o != null && d() == 1) {
            this.o.b(-6);
        }
        this.h.b();
        this.i.a();
        super.b();
        for (T t : this.b.values()) {
            t.b();
        }
    }

    @Override // com.opos.mobad.l.j
    public boolean b(String str) {
        return true;
    }

    @Override // com.opos.mobad.l.j
    public boolean b(String str, int i) {
        com.opos.cmn.an.f.a.b("delegator", "doload:" + str);
        this.o.a(str);
        a.C0695a a2 = this.n.a(this.f26039a);
        if (a2.f26074a) {
            this.q.a();
            this.h.b();
            this.i.a();
            this.p.clear();
            d(str, Math.min(i, this.d));
            return true;
        }
        com.opos.cmn.an.f.a.b("delegator", "intercept " + a2.f26075c);
        this.q.a(500L, a2);
        this.o.c(a2.b);
        return true;
    }

    @Override // com.opos.mobad.ad.b
    public int c() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(String str, int i) {
        com.opos.cmn.an.f.a.b("delegator", "select:" + i);
        this.g = i;
        this.o.a(i);
    }

    @Override // com.opos.mobad.f.a.a.n
    public final void d(int i) {
        com.opos.cmn.an.f.a.b("delegator", "onChannelRankSucc channel:" + i);
        CountDownLatch countDownLatch = this.m;
        if (countDownLatch != null) {
            try {
                countDownLatch.countDown();
            } catch (Exception e) {
                com.opos.cmn.an.f.a.b("delegator", "succ:" + i, e);
            }
        }
    }

    protected void d(final String str, final int i) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<Integer, T> entry : this.b.entrySet()) {
            T value = entry.getValue();
            if (value == null) {
                com.opos.cmn.an.f.a.b("delegator", "error disable ad");
            } else if (a((Map.Entry<Integer, Map.Entry<Integer, T>>) entry, (Map.Entry<Integer, T>) value)) {
                com.opos.cmn.an.f.a.a("SyncStateController", "add load ad channel:" + entry.getKey());
                arrayList.add(entry.getKey());
            }
        }
        this.g = -1;
        final int size = arrayList.size();
        if (size <= 0) {
            com.opos.cmn.an.f.a.a("SyncStateController", "not need to load");
            a(str, true);
            return;
        }
        this.m = new CountDownLatch(size);
        a(str, arrayList, i);
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.f.a.a.i.2
            @Override // java.lang.Runnable
            public void run() {
                com.opos.cmn.an.f.a.a("SyncStateController", "countdown:" + size + "," + i + ",posid=" + i.this.f26039a);
                try {
                    i.this.a(str, i.this.m.await(i, TimeUnit.MILLISECONDS));
                } catch (InterruptedException e) {
                    com.opos.cmn.an.f.a.b("", "", e);
                    i.this.a(str, false);
                }
            }
        });
    }

    @Override // com.opos.mobad.f.a.a.n
    public void e(int i) {
        if (i == j()) {
            i_();
        }
    }

    @Override // com.opos.mobad.l.j, com.opos.mobad.ad.b
    public boolean e() {
        if (2 != d()) {
            return false;
        }
        return a((i<T>) this.b.get(Integer.valueOf(this.g)), this.g);
    }

    protected boolean f(int i) {
        return a((i<T>) this.b.get(Integer.valueOf(i)), i);
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
        return this.k.get(Integer.valueOf(j()));
    }

    protected e.a m() {
        return this.j.a(this.b);
    }
}
