package com.anythink.core.common;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.core.api.ATSDK;
import com.anythink.core.api.AdError;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.ErrorCode;
import com.anythink.core.api.IATAdFilter;
import com.anythink.core.common.b.g;
import com.anythink.core.common.e.ai;
import com.anythink.core.common.f;
import com.anythink.core.common.k;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/h.class */
public abstract class h {
    int A;
    int B;
    ConcurrentHashMap<String, ai> D;
    ai F;
    protected Runnable J;
    com.anythink.core.common.l.f L;
    ai N;
    double O;
    ai Q;
    List<ai> R;
    protected WeakReference<Context> b;

    /* renamed from: c  reason: collision with root package name */
    protected int f6736c;
    protected com.anythink.core.c.d e;
    protected String f;
    protected String g;
    Map<String, Object> h;
    com.anythink.core.common.e.e i;
    protected j j;
    protected com.anythink.core.common.b.b l;
    boolean p;
    boolean q;
    List<ai> t;
    List<ai> u;
    List<ai> v;
    String x;
    long z;
    private final String T = getClass().getSimpleName();
    protected String d = "";
    protected int k = 0;
    boolean m = false;
    boolean n = false;
    protected boolean o = false;
    boolean r = false;
    boolean s = false;
    Object C = new Object();
    double E = -1.0d;
    protected Runnable I = null;
    protected Runnable M = new Runnable() { // from class: com.anythink.core.common.h.1
        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.core.common.k.b.a.a().b(new Runnable() { // from class: com.anythink.core.common.h.1.1
                @Override // java.lang.Runnable
                public final void run() {
                    h.this.a();
                }
            });
        }
    };
    boolean P = false;
    boolean S = false;

    /* renamed from: a  reason: collision with root package name */
    protected Context f6735a = com.anythink.core.common.b.n.a().g();
    List<com.anythink.core.common.l.e> w = Collections.synchronizedList(new ArrayList(2));
    AdError y = ErrorCode.getErrorCode(ErrorCode.noADError, "", "");
    protected Map<String, com.anythink.core.common.l.d> G = new ConcurrentHashMap();
    List<ai> H = Collections.synchronizedList(new ArrayList(3));
    com.anythink.core.common.l.h K = new com.anythink.core.common.l.h();

    /* renamed from: com.anythink.core.common.h$2  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/h$2.class */
    final class AnonymousClass2 implements Runnable {
        AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            h.this.I = null;
            com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.core.common.h.2.1
                @Override // java.lang.Runnable
                public final void run() {
                    h.this.j();
                }
            });
        }
    }

    /* renamed from: com.anythink.core.common.h$3  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/h$3.class */
    final class AnonymousClass3 implements Runnable {
        AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            h.this.o();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.anythink.core.common.h$5  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/h$5.class */
    public final class AnonymousClass5 implements com.anythink.core.common.l.b {
        AnonymousClass5() {
        }

        @Override // com.anythink.core.common.l.b
        public final void a(ATBaseAdAdapter aTBaseAdAdapter) {
            h.this.a(aTBaseAdAdapter);
        }

        @Override // com.anythink.core.common.l.b
        public final void a(com.anythink.core.common.e.e eVar) {
            com.anythink.core.common.j.a.a(h.this.f6735a).a(1, eVar);
            com.anythink.core.common.k.g.a(eVar, g.i.f6511a, g.i.h, "");
        }

        @Override // com.anythink.core.common.l.b
        public final void a(String str, ATBaseAdAdapter aTBaseAdAdapter, ai aiVar) {
            h.this.a(str, aTBaseAdAdapter, aiVar);
        }

        @Override // com.anythink.core.common.l.b
        public final void a(String str, ATBaseAdAdapter aTBaseAdAdapter, BaseAd... baseAdArr) {
            IATAdFilter o = com.anythink.core.common.b.n.a().o(h.this.g);
            BaseAd baseAd = (baseAdArr == null || baseAdArr.length <= 0) ? null : baseAdArr[0];
            if (o == null || !o.isAdFilter(com.anythink.core.common.b.j.a(aTBaseAdAdapter), baseAd)) {
                h hVar = h.this;
                List<? extends BaseAd> list = null;
                if (baseAdArr != null) {
                    list = Arrays.asList(baseAdArr);
                }
                hVar.a(str, aTBaseAdAdapter, list);
                return;
            }
            com.anythink.core.common.l.a aVar = new com.anythink.core.common.l.a();
            aVar.f6831a = 8;
            aVar.f6832c = aTBaseAdAdapter.getTrackingInfo().K();
            aVar.b = ErrorCode.getErrorCode(ErrorCode.adSourceNotFilledError, "", "");
            aVar.d = aTBaseAdAdapter.getTrackingInfo();
            aVar.e = aTBaseAdAdapter.getUnitGroupInfo();
            h.this.a(str, aVar);
        }

        @Override // com.anythink.core.common.l.b
        public final void a(String str, com.anythink.core.common.l.a aVar) {
            h.this.a(str, aVar);
        }

        @Override // com.anythink.core.common.l.b
        public final void a(String str, String str2) {
            h.this.a(str);
        }

        @Override // com.anythink.core.common.l.b
        public final void b(com.anythink.core.common.e.e eVar) {
            h.a(h.this, eVar);
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/h$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static final int f6748a = 1;
        public static final int b = 2;

        /* renamed from: c  reason: collision with root package name */
        public static final int f6749c = 3;
        public static final int d = 4;
        public static final int e = 5;
    }

    public h(Context context) {
        this.b = new WeakReference<>(context);
    }

    private boolean A() {
        synchronized (this) {
            new StringBuilder("hasFinishAllRequest:isFinishBidding: ").append(this.m);
            new StringBuilder("hasFinishAllRequest:requestWaitingPool: ").append(this.t.size());
            new StringBuilder("hasFinishAllRequest:requestingPool: ").append(this.u.size());
            new StringBuilder("hasFinishAllRequest:defaultRequestWaitingPool: ").append(this.v.size());
            new StringBuilder("hasFinishAllRequest:showCapWaitingPool: ").append(this.w.size());
            if (this.t.size() == 0 && this.v.size() == 0 && this.w.size() == 0) {
                if (this.u.size() == 0) {
                    return true;
                }
            }
            return false;
        }
    }

    private boolean B() {
        boolean z;
        synchronized (this) {
            if (this.t.size() == 0) {
                if (this.u.size() == 0) {
                    z = true;
                }
            }
            z = false;
        }
        return z;
    }

    private boolean C() {
        return (this.e.j() != 1 || this.k == 8 || v.a().f(this.g)) ? false : true;
    }

    private void a(int i, List<ai> list, final k.a aVar) {
        boolean z = this.N != null || com.anythink.core.common.k.t.a(this.H);
        com.anythink.core.common.e.a aVar2 = new com.anythink.core.common.e.a();
        aVar2.f6611a = this.f6735a;
        aVar2.b = this.j;
        aVar2.f6612c = this.f;
        aVar2.d = this.g;
        aVar2.e = this.e.X();
        aVar2.f = this.e.H();
        aVar2.g = this.e.z();
        i.a();
        aVar2.l = i.a(this.e, z);
        i.a();
        aVar2.o = i.a(this.e);
        i.a();
        aVar2.p = i.b(this.e);
        aVar2.i = list;
        aVar2.n = this.e;
        aVar2.s = this.i;
        aVar2.q = this.h;
        aVar2.w = this.L.g();
        List<ai> b = w.a().b(this.g, this.f);
        if (b == null) {
            aVar2.j = new ArrayList(4);
        } else {
            aVar2.j = b;
        }
        aVar2.m = z;
        aVar2.u = i;
        aVar2.t = this.N;
        aVar2.v = com.anythink.core.common.k.g.a(this.Q);
        com.anythink.core.b.b bVar = new com.anythink.core.b.b(aVar2);
        bVar.a(ATSDK.isNetworkLogDebug());
        bVar.a(new k.a() { // from class: com.anythink.core.common.h.8
            @Override // com.anythink.core.common.k.a
            public final void a(String str) {
                k.a aVar3 = aVar;
                if (aVar3 != null) {
                    aVar3.a(str);
                }
            }

            @Override // com.anythink.core.common.k.a
            public final void a(String str, List<ai> list2, List<ai> list3) {
                k.a aVar3 = aVar;
                if (aVar3 != null) {
                    aVar3.a(str, list2, list3);
                }
            }

            @Override // com.anythink.core.common.k.a
            public final void b(String str) {
                k.a aVar3 = aVar;
                if (aVar3 != null) {
                    aVar3.b(str);
                }
            }
        });
    }

    private void a(long j) {
        if (this.J != null) {
            com.anythink.core.common.b.n.a().a(this.J, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ai aiVar) {
        if (aiVar != null && aiVar.j() && aiVar.L() == 2) {
            String str = this.f;
            String str2 = this.g;
            String str3 = this.d;
            com.anythink.core.c.d dVar = this.e;
            int i = this.k;
            int i2 = this.f6736c;
            j jVar = this.j;
            com.anythink.core.common.l.f.a(aiVar, com.anythink.core.common.k.s.a(str, str2, str3, dVar, "", 1, i, i2, jVar != null ? jVar.g : null), this.F, true);
        }
    }

    private void a(ai aiVar, int i) {
        synchronized (this) {
            List<ai> list = i != 2 ? this.t : this.v;
            synchronized (list) {
                com.anythink.core.common.k.g.a(list, aiVar, false);
            }
        }
    }

    private void a(com.anythink.core.common.e.e eVar) {
        this.i = eVar;
    }

    private void a(com.anythink.core.common.e.e eVar, AdError adError) {
        com.anythink.core.common.b.b bVar = this.l;
        if (bVar != null) {
            bVar.b(eVar, adError);
        }
    }

    static /* synthetic */ void a(h hVar, com.anythink.core.common.e.e eVar) {
        com.anythink.core.common.b.b bVar = hVar.l;
        if (bVar != null) {
            bVar.c(eVar);
        }
    }

    static /* synthetic */ void a(h hVar, com.anythink.core.common.l.d dVar, com.anythink.core.common.e.e eVar) {
        com.anythink.core.common.l.c cVar = new com.anythink.core.common.l.c();
        cVar.f6833a = hVar.f6735a;
        cVar.b = hVar.b;
        cVar.f6834c = hVar.f;
        cVar.d = hVar.g;
        cVar.e = hVar.e;
        cVar.f = hVar.h;
        cVar.g = hVar.A;
        cVar.h = eVar;
        dVar.a(cVar);
        dVar.a(new AnonymousClass5());
        dVar.b();
    }

    private void a(com.anythink.core.common.l.d dVar) {
        boolean e = dVar.e();
        if (e) {
            this.L.a(-1, dVar.f());
        }
        b(dVar);
        r();
        if (e) {
            if (this.L.d() == 0 && this.t.size() == 0 && (this.r || this.m)) {
                v();
            }
            new StringBuilder("checkToRequestNextAdSource: try to call next AdSource.||").append(dVar.f());
            this.L.a(dVar.f());
            a(this.L.b(dVar.f()), dVar.f());
            l();
        }
    }

    private void a(com.anythink.core.common.l.d dVar, ATBaseAdAdapter aTBaseAdAdapter, ai aiVar, com.anythink.core.common.e.e eVar) {
        eVar.g(aTBaseAdAdapter.getNetworkPlacementId());
        double a2 = dVar.f() != 2 ? com.anythink.core.common.k.g.a(aiVar) : 0.0d;
        if (a2 > this.E) {
            this.E = a2;
        }
        d(aiVar);
        if (this.F == null) {
            this.F = aiVar;
            com.anythink.core.b.f.a().a(this.g, this.F);
        } else if (com.anythink.core.common.k.g.a(aiVar) > com.anythink.core.common.k.g.a(this.F)) {
            this.F = aiVar;
            com.anythink.core.b.f.a().a(this.g, this.F);
        }
        this.L.b(aiVar);
        double d = this.O;
        if (d <= 0.0d) {
            eVar.s = 0;
        } else if (d < a2) {
            eVar.s = 2;
        } else {
            eVar.s = 1;
        }
        com.anythink.core.common.l.f.a(this.f6735a, this.g, this.f, aiVar, null);
    }

    private void a(com.anythink.core.common.l.d dVar, com.anythink.core.common.e.e eVar) {
        com.anythink.core.common.l.c cVar = new com.anythink.core.common.l.c();
        cVar.f6833a = this.f6735a;
        cVar.b = this.b;
        cVar.f6834c = this.f;
        cVar.d = this.g;
        cVar.e = this.e;
        cVar.f = this.h;
        cVar.g = this.A;
        cVar.h = eVar;
        dVar.a(cVar);
        dVar.a(new AnonymousClass5());
        dVar.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        synchronized (this) {
            if (this.K.b()) {
                return;
            }
            a(this.G.get(str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, ATBaseAdAdapter aTBaseAdAdapter, ai aiVar) {
        synchronized (this) {
            com.anythink.core.common.l.d remove = this.G.remove(str);
            if (remove == null) {
                return;
            }
            a(remove, aTBaseAdAdapter, aiVar, aTBaseAdAdapter.getTrackingInfo());
            new StringBuilder("[Enter] onCacheAdLoaded: ").append(aiVar.ab());
            b(aiVar);
            t();
            c(aTBaseAdAdapter.getTrackingInfo());
            aiVar.t();
            a(remove);
        }
    }

    private void a(List<ai> list) {
        this.R = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<ai> list, int i) {
        synchronized (this) {
            if (!this.K.b() && !this.K.c() && list != null && list.size() != 0) {
                this.u.addAll(list);
                new StringBuilder("addAdSourceToRequestingPool:start to request:  requesting size:").append(this.u.size());
                for (ai aiVar : list) {
                    b(aiVar, i);
                }
            }
        }
    }

    private void a(Map<String, Object> map) {
        this.h = map;
    }

    private ai b(String str) {
        ConcurrentHashMap<String, ai> concurrentHashMap = this.D;
        if (concurrentHashMap != null) {
            return concurrentHashMap.get(str);
        }
        return null;
    }

    private void b(long j) {
        com.anythink.core.common.b.n.a().a(this.M, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ai aiVar) {
        synchronized (this) {
            this.u.remove(aiVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final ai aiVar, final int i) {
        this.L.a(1, i);
        com.anythink.core.common.k.b.a.a().b(new Runnable() { // from class: com.anythink.core.common.h.4
            @Override // java.lang.Runnable
            public final void run() {
                String str;
                synchronized (h.this) {
                    if (h.this.K.b()) {
                        return;
                    }
                    if (com.anythink.core.common.k.t.a(aiVar) && TextUtils.isEmpty(v.a().a(h.this.g, aiVar.c()))) {
                        v.a().a(h.this.g, aiVar.c(), aiVar.g());
                    }
                    boolean c2 = h.c(i);
                    String str2 = h.this.f;
                    String str3 = h.this.g;
                    String str4 = h.this.d;
                    com.anythink.core.c.d dVar = h.this.e;
                    if (c2) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(aiVar.c());
                        str = sb.toString();
                    } else {
                        str = h.this.x;
                    }
                    com.anythink.core.common.e.e a2 = com.anythink.core.common.k.s.a(str2, str3, str4, dVar, str, h.this.e.l(), h.this.k, h.this.f6736c, h.this.j != null ? h.this.j.g : null);
                    if (h.this.i != null) {
                        a2.a(h.this.i.a());
                    }
                    com.anythink.core.common.k.s.a(a2, aiVar, h.this.A, true);
                    a2.a(SystemClock.elapsedRealtime() - h.this.z);
                    com.anythink.core.common.e.d d = v.a().d(h.this.g);
                    boolean z = false;
                    int i2 = 0;
                    if (d != null && d.a(aiVar)) {
                        com.anythink.core.common.k.n.a(h.this.g, a2, "Can't Load On Showing", aiVar, -1, -1);
                        com.anythink.core.common.j.c.a(a2, 7, ErrorCode.getErrorCode(ErrorCode.loadInShowingFilter, "", "Can't Load On Showing"));
                        v.a().a(h.this.g, d.a(), h.this.f);
                        synchronized (h.this.w) {
                            Iterator<com.anythink.core.common.l.e> it = h.this.w.iterator();
                            while (it.hasNext() && com.anythink.core.common.k.g.a(it.next().a()) > com.anythink.core.common.k.g.a(aiVar)) {
                                i2++;
                            }
                            h.this.w.add(i2, new com.anythink.core.common.l.e(aiVar, i));
                        }
                        h.this.b(aiVar);
                        h.this.L.a(i);
                        h.this.L.a(-1, i);
                        h hVar = h.this;
                        hVar.a(hVar.L.b(i), i);
                        return;
                    }
                    String unused = h.this.T;
                    new StringBuilder("startAdSourceRequest: ").append(aiVar.ab());
                    boolean z2 = false;
                    try {
                        if (aiVar.j()) {
                            String unused2 = h.this.T;
                            com.anythink.core.common.e.m N = aiVar.N();
                            if (aiVar.c() != 66 && aiVar.c() != 67) {
                                com.anythink.core.b.f.a().a(aiVar.t());
                            }
                            boolean z3 = false;
                            if (N != null) {
                                z3 = false;
                                if (N.a()) {
                                    z3 = true;
                                }
                            }
                            z = z3;
                            if (z3) {
                                z = z3;
                                if (N != null) {
                                    com.anythink.core.common.e.r rVar = new com.anythink.core.common.e.r();
                                    boolean z4 = z3;
                                    rVar.f6674a = 1;
                                    boolean z5 = z3;
                                    rVar.b = N.getSortPrice();
                                    boolean z6 = z3;
                                    rVar.e = a2;
                                    boolean z7 = z3;
                                    rVar.f6675c = aiVar;
                                    boolean z8 = z3;
                                    rVar.d = aiVar;
                                    z2 = z3;
                                    N.a(rVar, true);
                                    z = z3;
                                }
                            }
                        }
                    } catch (Throwable th) {
                        z = z2;
                    }
                    com.anythink.core.common.l.d dVar2 = new com.anythink.core.common.l.d(aiVar, i);
                    String a3 = dVar2.a();
                    h.this.G.put(a3, dVar2);
                    h.this.A++;
                    if (z) {
                        com.anythink.core.common.l.a aVar = new com.anythink.core.common.l.a();
                        aVar.f6831a = 6;
                        aVar.b = ErrorCode.getErrorCode(ErrorCode.noADError, "", "Bid result has expired.");
                        aVar.f6832c = 0L;
                        aVar.d = a2;
                        aVar.e = aiVar;
                        h.this.a(a3, aVar);
                        return;
                    }
                    if (aiVar.j()) {
                        h.this.d(aiVar);
                    }
                    int ac = aiVar.ac();
                    if (ac > 0) {
                        a2.q = ac;
                    } else if (h.this.n && h.this.B < h.this.e.am()) {
                        a2.q = 5;
                    }
                    h.a(h.this, dVar2, a2);
                }
            }
        });
    }

    private void b(com.anythink.core.common.e.e eVar) {
        com.anythink.core.common.b.b bVar = this.l;
        if (bVar != null) {
            bVar.c(eVar);
        }
    }

    private void b(com.anythink.core.common.l.d dVar) {
        if (dVar.d() == null || !dVar.d().booleanValue() || dVar.f() == 2 || !dVar.d().booleanValue()) {
            return;
        }
        this.B++;
    }

    private void c(ai aiVar) {
        if (this.D == null) {
            this.D = new ConcurrentHashMap<>();
        }
        this.D.put(aiVar.t(), aiVar);
    }

    private void c(com.anythink.core.common.e.e eVar) {
        com.anythink.core.common.b.b bVar = this.l;
        if (bVar != null) {
            bVar.d(eVar);
        }
    }

    static /* synthetic */ boolean c(int i) {
        return i == 3 || i == 5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ai aiVar) {
        if (aiVar == null) {
            return;
        }
        double a2 = com.anythink.core.common.k.g.a(aiVar);
        double d = a2;
        if (aiVar.j()) {
            d = a2;
            if (aiVar.c() == 1) {
                d = a2;
                if (a2 == 10000.0d) {
                    com.anythink.core.common.e.m N = aiVar.N();
                    d = a2;
                    if (N != null) {
                        d = N.o;
                    }
                }
            }
        }
        if (d > com.anythink.core.common.k.g.a(this.Q)) {
            this.Q = aiVar;
        }
    }

    private static boolean d(int i) {
        return i == 3 || i == 5;
    }

    private void e(int i) {
        synchronized (this) {
            int e = i != 2 ? this.L.e() : this.L.f();
            if (e == 0) {
                StringBuilder sb = new StringBuilder("checkToAddAdSourceToRequestingPool: vail requesting num: ");
                sb.append(e);
                sb.append(" | requestFrom: ");
                sb.append(i);
                a(this.L.b(i), i);
            }
        }
    }

    private int f(int i) {
        return i > 0 ? i : this.B < this.e.am() ? 5 : 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        synchronized (this) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.g);
            sb.append(":filled timeup to check cache.");
            com.anythink.core.common.e.b a2 = com.anythink.core.common.a.a().a(this.f6735a, this.g);
            this.s = true;
            if (this.o || a2 == null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(this.g);
                sb2.append(":filled timeup to check no cache, do nothing.");
                return;
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append(this.g);
            sb3.append(":filled timeup to check cache exist.");
            d(a2.e() != null ? a2.e().getUnitGroupInfo() : null);
            b(9);
        }
    }

    private void k() {
        synchronized (this) {
            if (this.p) {
                synchronized (this.t) {
                    for (ai aiVar : this.t) {
                        if (aiVar != null && aiVar.j()) {
                            a(aiVar);
                        }
                    }
                    this.t.clear();
                }
                synchronized (this.w) {
                    for (com.anythink.core.common.l.e eVar : this.w) {
                        if (eVar != null && eVar.a() != null && eVar.a().j()) {
                            a(eVar.a());
                        }
                    }
                    this.w.clear();
                }
                synchronized (this.v) {
                    this.v.clear();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        synchronized (this) {
            double a2 = this.L.a(false);
            double s = s();
            new StringBuilder("checkWaterfallStatus: vail requesting num: ").append(this.L.d());
            new StringBuilder("checkWaterfallStatus:isFinishBidding:").append(this.m);
            new StringBuilder("checkWaterfallStatus:currentCacheNum >= mStrategy.getCachedOffersNum():").append(this.B >= this.e.am());
            StringBuilder sb = new StringBuilder("checkWaterfallStatus:getCacheLowestPrice() > getWaitingResponseMaxPrice():");
            int i = (a2 > s ? 1 : (a2 == s ? 0 : -1));
            boolean z = false;
            if (i > 0) {
                z = true;
            }
            sb.append(z);
            new StringBuilder("checkWaterfallStatus:requestHasShow:").append(this.K.c());
            new StringBuilder("checkWaterfallStatus:hasLongTimeout:").append(this.K.b());
            if ((this.m && this.B >= this.e.am() && i > 0) || this.K.c() || this.K.b()) {
                this.p = true;
                k();
                if (this.L.d() == 0) {
                    com.anythink.core.common.l.f.a(this.f6735a, this.g);
                    q();
                }
            }
            p();
            if (this.p || A()) {
                q();
            }
        }
    }

    private void m() {
        if (this.e.m() <= 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.g);
            sb.append(": no filled count down.");
            return;
        }
        this.I = new AnonymousClass2();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.g);
        sb2.append(": start filled count down.");
        com.anythink.core.common.b.n.a().a(this.I, this.e.m());
    }

    private Runnable n() {
        return new AnonymousClass3();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        synchronized (this) {
            if (!this.o && this.v.size() > 0) {
                this.J = null;
                ai remove = this.v.remove(0);
                new StringBuilder("handleDefaultAdSourceRequest: startLoadDefaultAdSource:").append(remove.ab());
                this.u.add(remove);
                StringBuilder sb = new StringBuilder("handleDefaultAdSourceRequest:start to request: waiting size:");
                sb.append(this.v.size());
                sb.append("; requesting size:");
                sb.append(this.L.f());
                b(remove, 2);
            }
        }
    }

    private void p() {
        com.anythink.core.common.e.m N;
        ai a2;
        ai next;
        synchronized (this) {
            if (!this.K.g() && this.K.e()) {
                if (this.K.b()) {
                    return;
                }
                boolean z = false;
                if (this.m) {
                    z = false;
                    if (this.F != null) {
                        z = false;
                        if (this.F.j()) {
                            double a3 = com.anythink.core.common.k.g.a(this.F);
                            synchronized (this.u) {
                                Iterator<ai> it = this.u.iterator();
                                do {
                                    if (!it.hasNext()) {
                                        synchronized (this.w) {
                                            Iterator<com.anythink.core.common.l.e> it2 = this.w.iterator();
                                            do {
                                                if (it2.hasNext()) {
                                                    a2 = it2.next().a();
                                                } else {
                                                    z = true;
                                                }
                                            } while (com.anythink.core.common.k.g.a(a2) <= a3);
                                            new StringBuilder("tryToSendWinNotice(), do not send win: ").append(a2.ab());
                                            return;
                                        }
                                    }
                                    next = it.next();
                                } while (com.anythink.core.common.k.g.a(next) <= a3);
                                new StringBuilder("tryToSendWinNotice(), do not send win: ").append(next.ab());
                                return;
                            }
                        }
                    }
                }
                if (z && (N = this.F.N()) != null) {
                    this.K.h();
                    new StringBuilder("tryToSendWinNotice(), send win notice: ").append(this.F.ab());
                    N.a(this.F);
                }
                return;
            }
            StringBuilder sb = new StringBuilder("tryToSendWinNotice(), mHasSendWinNotice: ");
            sb.append(this.K.g());
            sb.append(", mHasHBAdSource: ");
            sb.append(this.K.e());
        }
    }

    private void q() {
        synchronized (this) {
            if (!this.K.e()) {
                new StringBuilder("tryToSendLossNotice(), mHasHBAdSource: ").append(this.K.e());
            } else if (this.K.b()) {
            } else {
                this.L.a(com.anythink.core.common.k.s.a(this.f, this.g, this.d, this.e, "", 1, this.k, this.f6736c, this.j != null ? this.j.g : null), this.F);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        boolean z;
        synchronized (this) {
            double s = s();
            if (this.E >= 0.0d) {
                if (((this.m || this.r) && this.E >= s) || this.s) {
                    if (!this.o) {
                        b(-1);
                    }
                    w();
                }
            } else if (this.m) {
                if (this.J == null || !B()) {
                    z = false;
                } else {
                    com.anythink.core.common.b.n.a().c(this.J);
                    this.J.run();
                    this.J = null;
                    z = true;
                }
                if (z) {
                    return;
                }
                if (A() && !this.o) {
                    z();
                }
            }
        }
    }

    private double s() {
        ai aiVar;
        ai aiVar2;
        if (this.e.a() == 2) {
            synchronized (this.G) {
                Iterator<Map.Entry<String, com.anythink.core.common.l.d>> it = this.G.entrySet().iterator();
                aiVar = null;
                ai aiVar3 = null;
                if (it != null) {
                    while (true) {
                        aiVar = aiVar3;
                        if (!it.hasNext()) {
                            break;
                        }
                        com.anythink.core.common.l.d value = it.next().getValue();
                        if (value != null) {
                            if (!value.g()) {
                                ai h = value.h();
                                if (h != null) {
                                    if (aiVar3 != null && com.anythink.core.common.k.g.a(h) <= com.anythink.core.common.k.g.a(aiVar3)) {
                                    }
                                    aiVar3 = h;
                                }
                            }
                        }
                    }
                }
            }
        } else {
            aiVar = null;
        }
        ai aiVar4 = this.t.size() > 0 ? this.t.get(0) : null;
        synchronized (this.w) {
            aiVar2 = null;
            if (this.w.size() > 0) {
                com.anythink.core.common.l.e eVar = this.w.get(0);
                aiVar2 = null;
                if (eVar != null) {
                    aiVar2 = eVar.a();
                }
            }
        }
        return Math.max(Math.max(com.anythink.core.common.k.g.a(aiVar4), com.anythink.core.common.k.g.a(aiVar2)), com.anythink.core.common.k.g.a(aiVar));
    }

    private void t() {
        synchronized (this) {
            this.v.clear();
            if (this.J != null) {
                com.anythink.core.common.b.n.a().c(this.J);
                this.J = null;
            }
        }
    }

    private void u() {
        v();
        if (this.P) {
            return;
        }
        h();
    }

    private boolean v() {
        synchronized (this) {
            if (this.R != null && this.R.size() != 0) {
                if (this.K.c()) {
                    return false;
                }
                this.S = true;
                ArrayList arrayList = new ArrayList(3);
                arrayList.addAll(this.R);
                this.R.clear();
                a(8, arrayList, new k.a() { // from class: com.anythink.core.common.h.6
                    @Override // com.anythink.core.common.k.a
                    public final void a(String str) {
                    }

                    @Override // com.anythink.core.common.k.a
                    public final void a(String str, List<ai> list, List<ai> list2) {
                        w.a().b(h.this.g, h.this.f, list);
                        for (ai aiVar : list) {
                            aiVar.y(8);
                            h.this.u.add(aiVar);
                            h.this.b(aiVar, 3);
                        }
                    }

                    @Override // com.anythink.core.common.k.a
                    public final void b(String str) {
                        h.this.S = false;
                        h.this.r();
                    }
                });
                return true;
            }
            return false;
        }
    }

    private void w() {
        synchronized (this) {
            if (this.m) {
                if (this.K.c()) {
                    return;
                }
                if (this.H != null && this.H.size() != 0) {
                    if (this.q) {
                        return;
                    }
                    this.q = true;
                    a(7, this.H, new k.a() { // from class: com.anythink.core.common.h.7
                        @Override // com.anythink.core.common.k.a
                        public final void a(String str) {
                        }

                        @Override // com.anythink.core.common.k.a
                        public final void a(String str, List<ai> list, List<ai> list2) {
                            if (h.this.K.c()) {
                                String unused = h.this.T;
                                for (ai aiVar : list) {
                                    h.this.a(aiVar);
                                }
                                return;
                            }
                            w.a().b(h.this.g, h.this.f, list);
                            if (h.this.B < h.this.e.am()) {
                                String unused2 = h.this.T;
                                h.this.a(list, (List<ai>) null, (List<ai>) null);
                                h.this.l();
                                return;
                            }
                            String unused3 = h.this.T;
                            double a2 = h.this.L.a(false);
                            int size = list.size();
                            ArrayList arrayList = new ArrayList(size);
                            ArrayList arrayList2 = new ArrayList(size);
                            for (int i = 0; i < size; i++) {
                                ai aiVar2 = list.get(i);
                                if (com.anythink.core.common.k.g.a(aiVar2) > a2) {
                                    arrayList.add(aiVar2);
                                } else {
                                    arrayList2.add(aiVar2);
                                }
                            }
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                ai aiVar3 = (ai) it.next();
                                aiVar3.y(7);
                                h.this.u.add(aiVar3);
                                h.this.b(aiVar3, 5);
                            }
                            Iterator it2 = arrayList2.iterator();
                            while (it2.hasNext()) {
                                h.this.a((ai) it2.next());
                            }
                        }

                        @Override // com.anythink.core.common.k.a
                        public final void b(String str) {
                        }
                    });
                }
            }
        }
    }

    private boolean x() {
        if (this.J == null || !B()) {
            return false;
        }
        com.anythink.core.common.b.n.a().c(this.J);
        this.J.run();
        this.J = null;
        return true;
    }

    private void y() {
        j jVar;
        boolean z = true;
        this.o = true;
        this.n = false;
        if (this.M != null) {
            com.anythink.core.common.b.n.a().c(this.M);
        }
        String str = this.f;
        String str2 = this.g;
        String str3 = this.d;
        com.anythink.core.c.d dVar = this.e;
        String str4 = this.x;
        int l = dVar.l();
        int i = this.k;
        int i2 = this.f6736c;
        j jVar2 = this.j;
        com.anythink.core.common.j.c.a(com.anythink.core.common.k.s.a(str, str2, str3, dVar, str4, l, i, i2, jVar2 != null ? jVar2.g : null), this.y);
        if (!this.P) {
            if (this.e.j() != 1 || this.k == 8 || v.a().f(this.g)) {
                z = false;
            }
            if (z) {
                f b = v.a().b(this.g);
                if (b != null && (jVar = this.j) != null) {
                    jVar.d = 8;
                    Context context = this.f6735a;
                    StringBuilder sb = new StringBuilder();
                    sb.append(this.e.X());
                    b.a(context, sb.toString(), this.g, (String) this.j, (com.anythink.core.common.b.a) null);
                }
            } else {
                a(this.y);
            }
        }
        f();
    }

    private void z() {
        if (com.anythink.core.common.a.a().a(this.f6735a, this.g) != null) {
            b(9);
        } else if (v()) {
        } else {
            y();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a() {
        ConcurrentHashMap concurrentHashMap;
        synchronized (this) {
            this.K.a();
            synchronized (this.G) {
                concurrentHashMap = new ConcurrentHashMap(this.G);
            }
            for (Map.Entry entry : concurrentHashMap.entrySet()) {
                com.anythink.core.common.l.d dVar = (com.anythink.core.common.l.d) entry.getValue();
                if (dVar != null) {
                    dVar.c();
                }
            }
            if (!this.o) {
                this.o = true;
                z();
            }
            l();
        }
    }

    public final void a(double d, ai aiVar) {
        synchronized (this) {
            if (!this.K.g() && aiVar != null && aiVar.j()) {
                this.K.h();
            }
            if (d > this.O) {
                this.O = d;
            }
            int X = this.e.X();
            if (X == 0 || X == 2) {
                return;
            }
            this.K.d();
            v.a().b(this.g).b(this.f);
            if (!this.o) {
                b(10);
            }
            l();
        }
    }

    public final void a(int i) {
        this.k = i;
    }

    public abstract void a(ATBaseAdAdapter aTBaseAdAdapter);

    public void a(AdError adError) {
        com.anythink.core.common.k.n.a("Mediation", "placementId:" + this.g + ";result_callback:fail;loadType:" + this.k + ";");
        j jVar = this.j;
        if (jVar == null || jVar.f == null) {
            return;
        }
        this.j.f.onAdLoadFail(adError);
        this.j.f = null;
    }

    public final void a(com.anythink.core.common.b.b bVar) {
        this.l = bVar;
    }

    public final void a(j jVar) {
        this.j = jVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(com.anythink.core.common.l.g gVar) {
        com.anythink.core.common.l.f fVar = new com.anythink.core.common.l.f(gVar);
        this.L = fVar;
        this.t = fVar.a();
        this.u = this.L.b();
        this.m = gVar.e;
        this.f = gVar.b;
        this.g = gVar.f6851a;
        this.e = gVar.f6852c;
        this.f6736c = gVar.f;
        this.x = com.anythink.core.common.l.f.a(gVar.d);
    }

    public final void a(String str, ATBaseAdAdapter aTBaseAdAdapter, List<? extends BaseAd> list) {
        f b;
        synchronized (this) {
            if (aTBaseAdAdapter != null) {
                aTBaseAdAdapter.getTrackingInfo().x();
            }
            com.anythink.core.common.l.d remove = this.G.remove(str);
            if (remove == null) {
                return;
            }
            com.anythink.core.common.e.e trackingInfo = aTBaseAdAdapter.getTrackingInfo();
            ai unitGroupInfo = aTBaseAdAdapter.getUnitGroupInfo();
            new StringBuilder("[Enter] onAdLoaded(): ").append(unitGroupInfo.ab());
            b(unitGroupInfo);
            t();
            a(remove, aTBaseAdAdapter, unitGroupInfo, trackingInfo);
            if (unitGroupInfo.B() != -1 && trackingInfo.J() > 0) {
                com.anythink.core.common.j.c.a(trackingInfo);
            }
            c(aTBaseAdAdapter.getTrackingInfo());
            com.anythink.core.common.j.a.a(this.f6735a).a(2, trackingInfo);
            com.anythink.core.common.a.a().a(this.g, trackingInfo.z(), aTBaseAdAdapter, list, unitGroupInfo.p());
            com.anythink.core.common.k.g.a(trackingInfo, g.i.b, g.i.f, "");
            if (!this.P && !this.K.c() && (b = v.a().b(this.g)) != null && this.e.T() > 0) {
                com.anythink.core.common.b.n.a().a(new f.AnonymousClass4(aTBaseAdAdapter, com.anythink.core.common.k.g.a(unitGroupInfo), this.f));
            }
            a(remove);
        }
    }

    public void a(String str, com.anythink.core.common.l.a aVar) {
        synchronized (this) {
            com.anythink.core.common.e.e eVar = aVar.d;
            ai aiVar = aVar.e;
            AdError adError = aVar.b;
            long j = aVar.f6832c;
            String x = eVar.x();
            com.anythink.core.common.l.d remove = this.G.remove(str);
            if (remove == null) {
                return;
            }
            new StringBuilder("[Enter] onAdError(): ").append(aiVar.ab());
            b(aiVar);
            this.y.putNetworkErrorMsg(x, eVar.H(), eVar.T(), adError);
            com.anythink.core.common.j.c.a(eVar, aVar.f6831a, adError, j);
            if (j > 0) {
                if (this.l != null) {
                    this.l.b(eVar, adError);
                }
                com.anythink.core.common.k.g.a(eVar, g.i.b, g.i.g, adError.printStackTrace());
            }
            a(remove);
        }
    }

    public final void a(List<ai> list, List<ai> list2, List<ai> list3) {
        synchronized (this.C) {
            if (list2 != null) {
                for (ai aiVar : list2) {
                    this.y.putNetworkErrorMsg(aiVar.t(), aiVar.c(), aiVar.d(), ErrorCode.getErrorCode(ErrorCode.noADError, "", aiVar.z()));
                }
            }
            if (list3 != null) {
                this.H.addAll(list3);
            }
            if (list != null && list.size() != 0) {
                this.K.f();
                ai aiVar2 = list.get(0);
                boolean a2 = com.anythink.core.common.l.f.a(aiVar2, this.K);
                boolean c2 = this.L.c(aiVar2);
                if (a2 || c2) {
                    StringBuilder sb = new StringBuilder("isAdvanceRequest: ");
                    sb.append(a2);
                    sb.append(", cutInLine: ");
                    sb.append(c2);
                    com.anythink.core.common.j.c.a(this.i, aiVar2.c(), aiVar2.t(), com.anythink.core.common.k.g.a(aiVar2), !this.o ? "1" : this.n ? "2" : "3", a2 ? "1" : c2 ? "2" : "1");
                    if (aiVar2.aa()) {
                        this.N = aiVar2;
                    }
                    this.L.a(aiVar2);
                    list.remove(0);
                    this.u.add(aiVar2);
                    com.anythink.core.common.l.f.a(this.f6735a, this.g, this.f, null, aiVar2);
                    b(aiVar2, 3);
                }
                for (ai aiVar3 : list) {
                    this.L.a(aiVar3);
                    com.anythink.core.common.l.f.a(this.f6735a, this.g, this.f, null, aiVar3);
                    if (this.D == null) {
                        this.D = new ConcurrentHashMap<>();
                    }
                    this.D.put(aiVar3.t(), aiVar3);
                    a(aiVar3, 1);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b() {
        long j;
        List<ai> c2 = this.L.c();
        this.v = c2;
        if (c2 == null || c2.size() <= 0) {
            j = 1000;
        } else {
            long o = this.e.o();
            j = o;
            if (this.t.size() == 0) {
                j = o;
                if (this.m) {
                    j = 0;
                }
            }
            this.J = new AnonymousClass3();
        }
        this.z = SystemClock.elapsedRealtime();
        StringBuilder sb = new StringBuilder();
        sb.append(this.g);
        sb.append(": start waterfall.");
        if (this.e.m() > 0) {
            this.I = new AnonymousClass2();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.g);
            sb2.append(": start filled count down.");
            com.anythink.core.common.b.n.a().a(this.I, this.e.m());
        } else {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(this.g);
            sb3.append(": no filled count down.");
        }
        com.anythink.core.common.b.n.a().a(this.M, this.e.R());
        if (this.v.size() == 0 && this.t.size() == 0 && this.m) {
            v();
        }
        a(this.L.h(), 1);
        if (this.J != null) {
            com.anythink.core.common.b.n.a().a(this.J, j);
        }
    }

    public final void b(int i) {
        if (this.I != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.g);
            sb.append(":remove filled countdown.");
            com.anythink.core.common.b.n.a().c(this.I);
            this.I = null;
        }
        boolean z = i == 5 || i == 9 || i == 10;
        this.o = true;
        this.n = true;
        if (this.M != null) {
            com.anythink.core.common.b.n.a().c(this.M);
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j = this.z;
        String str = this.f;
        String str2 = this.g;
        String str3 = this.d;
        com.anythink.core.c.d dVar = this.e;
        String str4 = this.x;
        int l = dVar.l();
        int i2 = this.k;
        int i3 = this.f6736c;
        j jVar = this.j;
        com.anythink.core.common.e.e a2 = com.anythink.core.common.k.s.a(str, str2, str3, dVar, str4, l, i2, i3, jVar != null ? jVar.g : null);
        a2.a(true);
        a2.d(elapsedRealtime - j);
        if (z) {
            a2.z(i);
        }
        com.anythink.core.common.j.a.a(this.f6735a).a(12, a2);
        f b = v.a().b(this.g);
        if (b != null && i != 10) {
            b.a(this.e.U());
        }
        com.anythink.core.common.l.f.a(this.f6735a, this.g);
        u();
    }

    public final boolean c() {
        if (this.o) {
            return true;
        }
        return this.m && this.t.size() == 0 && this.L.d() == 0;
    }

    public final void d() {
        this.r = true;
        r();
    }

    public final void e() {
        synchronized (this.C) {
            this.m = true;
            this.r = true;
            r();
            l();
        }
    }

    public final void f() {
        this.P = true;
        v.a().b(this.g).b(this.f);
    }

    public void g() {
        if (this.M != null) {
            com.anythink.core.common.b.n.a().c(this.M);
        }
    }

    public void h() {
        com.anythink.core.common.k.n.a("Mediation", "placementId:" + this.g + ";result_callback:success;loadType:" + this.k + ";");
        j jVar = this.j;
        if (jVar == null || jVar.f == null) {
            return;
        }
        this.j.f.onAdLoaded();
        this.j.f = null;
    }

    public final void i() {
        synchronized (this.w) {
            if (this.w.size() > 0) {
                ai a2 = this.w.remove(0).a();
                if (!this.o || this.B < this.e.am() || com.anythink.core.common.k.g.a(a2) > this.E) {
                    this.u.add(a2);
                    b(a2, 4);
                }
            }
            if (this.w.size() > 0) {
                for (com.anythink.core.common.l.e eVar : this.w) {
                    ai a3 = eVar.a();
                    if (!this.o || this.B < this.e.am() || com.anythink.core.common.k.g.a(a3) > this.E) {
                        int b = eVar.b();
                        if (b == 1) {
                            a(a3, 1);
                            e(b);
                        } else if (b == 2) {
                            a(a3, 2);
                            e(b);
                        } else if (b == 3) {
                            this.u.add(a3);
                            b(a3, 3);
                        }
                    }
                }
            }
            this.w.clear();
        }
        l();
    }
}
