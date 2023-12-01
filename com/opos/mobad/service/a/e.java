package com.opos.mobad.service.a;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.opos.cmn.func.b.b.d;
import com.opos.cmn.i.a;
import com.opos.mobad.m.a.g;
import com.opos.mobad.m.a.h;
import com.opos.mobad.m.a.i;
import com.opos.mobad.m.a.j;
import com.opos.mobad.m.a.k;
import com.opos.mobad.m.a.l;
import com.opos.mobad.m.a.m;
import com.opos.mobad.m.a.n;
import com.opos.mobad.m.a.o;
import com.opos.mobad.m.a.p;
import com.opos.mobad.m.a.q;
import com.opos.mobad.m.a.r;
import com.opos.mobad.m.a.s;
import com.opos.mobad.m.a.t;
import com.opos.mobad.m.a.w;
import com.opos.mobad.m.a.x;
import com.opos.mobad.provider.strategy.PosInfo;
import com.opos.mobad.service.a.d;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONException;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/service/a/e.class */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static final int f27294a = n.HORIZONTAL.a();
    public static final int b = n.VERTICAL.a();

    /* renamed from: c  reason: collision with root package name */
    private Context f27295c;
    private int d;
    private String e;
    private String f;
    private int g;
    private com.opos.mobad.service.a.d h;
    private com.opos.cmn.i.a i;
    private d m;
    private Bundle s;
    private Integer j = null;
    private volatile c k = new c();
    private AtomicReference<Map<String, f>> l = new AtomicReference<>(null);
    private AtomicBoolean n = new AtomicBoolean(false);
    private long o = 0;
    private Map<String, String> p = new ConcurrentHashMap();
    private Map<String, String> q = new ConcurrentHashMap();
    private Map<String, String> r = new ConcurrentHashMap();

    /* renamed from: com.opos.mobad.service.a.e$5  reason: invalid class name */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/service/a/e$5.class */
    static /* synthetic */ class AnonymousClass5 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f27300a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0036 -> B:21:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x003a -> B:19:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x003e -> B:25:0x002a). Please submit an issue!!! */
        static {
            int[] iArr = new int[j.values().length];
            f27300a = iArr;
            try {
                iArr[j.BIDDING_MODE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f27300a[j.PERCENTAGE_MODE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f27300a[j.UNKNOWN_MODE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f27300a[j.RANKER_MODE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/service/a/e$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f27301a;
        public final String b;

        /* renamed from: c  reason: collision with root package name */
        public final long f27302c;
        public final int d;
        public final int e;
        public final int f;
        public final int g;

        public a(int i, String str, int i2, long j, int i3, int i4) {
            this(i, str, i2, j, i3, i4, 0);
        }

        public a(int i, String str, int i2, long j, int i3, int i4, int i5) {
            this.f27301a = i;
            this.b = str;
            this.f27302c = j;
            this.d = i3;
            this.e = i4;
            this.f = i2;
            this.g = i5;
        }

        public String toString() {
            return "channel:" + this.f27301a + ",posId:" + this.b + ",percnet:" + this.f + ",timeout:" + this.f27302c;
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/service/a/e$b.class */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final List<a> f27303a;
        public final a b;

        /* renamed from: c  reason: collision with root package name */
        public final long f27304c;
        public final long d;
        public final int e;

        public b(List<a> list, int i, a aVar, long j, long j2) {
            this.f27303a = list;
            this.b = aVar;
            this.f27304c = j;
            this.d = j2;
            this.e = i;
        }

        public b(List<a> list, a aVar, long j, long j2) {
            this(list, 2, aVar, j, j2);
        }

        public String toString() {
            return "DispatchChannelStrategy{channelList=" + this.f27303a + ", baseChannel=" + this.b + ", unionTimeout=" + this.f27304c + ", strategyVersion=" + this.d + ", dispatch=" + this.e + '}';
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/service/a/e$c.class */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        private final Map<Integer, com.opos.mobad.m.a.e> f27305a;
        private final com.opos.mobad.m.a.b b;

        /* renamed from: c  reason: collision with root package name */
        private final long f27306c;
        private final long d;
        private final long e;
        private final String f;
        private final Map<Integer, String> g;

        public c() {
            this(null, null, Long.MIN_VALUE, Long.MIN_VALUE, 0L, "", null);
        }

        public c(List<com.opos.mobad.m.a.e> list, com.opos.mobad.m.a.b bVar, long j, long j2, long j3, String str, List<o> list2) {
            this.f27305a = new HashMap();
            if (list != null && list.size() > 0) {
                for (com.opos.mobad.m.a.e eVar : list) {
                    if (e.b(eVar.e)) {
                        this.f27305a.put(Integer.valueOf(eVar.e.a()), eVar);
                    }
                }
            }
            this.b = bVar;
            this.f27306c = j;
            this.d = j2;
            this.e = j3;
            this.f = str;
            this.g = a(list2);
        }

        private Map<Integer, String> a(List<o> list) {
            HashMap hashMap = new HashMap();
            if (list != null) {
                if (list.size() <= 0) {
                    return hashMap;
                }
                for (o oVar : list) {
                    if (oVar != null && !TextUtils.isEmpty(oVar.f) && oVar.e != null) {
                        hashMap.put(oVar.e, oVar.f);
                    }
                }
            }
            return hashMap;
        }

        public boolean a() {
            com.opos.cmn.an.f.a.b("DispatchController", "current:" + System.currentTimeMillis() + ", exp:" + this.f27306c);
            return System.currentTimeMillis() >= this.f27306c;
        }

        public boolean b() {
            com.opos.cmn.an.f.a.b("DispatchController", "current:" + System.currentTimeMillis() + ", enable:" + this.d);
            return System.currentTimeMillis() >= this.d;
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/service/a/e$d.class */
    public interface d {
        void a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Bundle bundle) {
        com.opos.cmn.an.f.a.a("DispatchController", "read local strategy size:" + bundle.size());
        this.s = bundle;
        HashMap hashMap = new HashMap();
        for (String str : bundle.keySet()) {
            PosInfo posInfo = (PosInfo) bundle.getParcelable(str);
            try {
                hashMap.put(str, new f(posInfo.b, s.f26363c.a(posInfo.f27134a)));
            } catch (Exception e) {
                com.opos.cmn.an.f.a.b("DispatchController", "decode local fail", e);
            }
        }
        com.opos.cmn.an.f.a.b("DispatchController", "decode local strategy size:" + hashMap.size());
        if (this.l.compareAndSet(null, hashMap)) {
            com.opos.cmn.an.f.a.b("DispatchController", "local strategy size:" + hashMap.size());
            d dVar = this.m;
            if (dVar != null) {
                dVar.a();
            }
        }
        this.s = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final a.InterfaceC0645a interfaceC0645a) {
        com.opos.cmn.an.f.a.a("DispatchController", "init from local");
        this.h.a(new d.a() { // from class: com.opos.mobad.service.a.e.1
            @Override // com.opos.mobad.service.a.d.a
            public void a() {
                com.opos.cmn.an.f.a.a("DispatchController", "read app info local fail");
                interfaceC0645a.b();
                e.this.a();
            }

            @Override // com.opos.mobad.service.a.d.a
            public void a(r rVar, long j) {
                com.opos.cmn.an.f.a.a("DispatchController", "read app info local succ:", rVar);
                e.this.a(rVar.f, rVar.i, j, rVar.h.longValue(), rVar.j != null ? rVar.j.longValue() : 0L, rVar.k, rVar.l);
                com.opos.mobad.service.c.b.a().a(e.this.v());
                if (e.this.k != null && e.this.k.a()) {
                    e.this.b(interfaceC0645a);
                    return;
                }
                com.opos.cmn.an.f.a.a("DispatchController", "do not need to refresh");
                interfaceC0645a.b();
            }
        });
        w();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(q qVar) throws JSONException {
        String str;
        if (qVar.f.intValue() != 0) {
            str = "response fail ret:" + qVar.f + ",msg:" + qVar.g;
        } else {
            r rVar = qVar.h;
            if (rVar != null) {
                long longValue = rVar.j != null ? rVar.j.longValue() : 0L;
                HashMap hashMap = new HashMap();
                for (s sVar : rVar.g) {
                    hashMap.put(sVar.l, new f(longValue, sVar));
                }
                this.h.a(rVar, qVar.i.longValue());
                this.k = new c(rVar.f, rVar.i, qVar.i.longValue(), rVar.h.longValue(), longValue, rVar.k, rVar.l);
                a(hashMap);
                return;
            }
            str = "response data null";
        }
        com.opos.cmn.an.f.a.b("DispatchController", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<com.opos.mobad.m.a.e> list, com.opos.mobad.m.a.b bVar, long j, long j2, long j3, String str, List<o> list2) {
        this.k = new c(list, bVar, j, j2, j3, str, list2);
        d dVar = this.m;
        if (dVar != null) {
            dVar.a();
        }
    }

    private void a(Map<String, f> map) {
        com.opos.cmn.an.f.a.b("DispatchController", "refresh strategy size:" + map.size());
        this.l.set(map);
        d dVar = this.m;
        if (dVar != null) {
            dVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final a.InterfaceC0645a interfaceC0645a) {
        com.opos.cmn.an.j.b.b(new Runnable() { // from class: com.opos.mobad.service.a.e.4
            @Override // java.lang.Runnable
            public void run() {
                int i;
                com.opos.cmn.func.b.b.e a2;
                p.a c2 = new p.a().a(e.this.e).b(e.this.f).a(Integer.valueOf(e.this.d)).b(Integer.valueOf(e.this.g)).a(Long.valueOf(e.this.o)).c(e.this.f27295c.getPackageName());
                try {
                    h b2 = new h.a().a(new g.a().b(com.opos.mobad.service.e.a.a().e()).a(com.opos.mobad.service.e.a.a().k()).c(com.opos.cmn.f.a.a(e.this.f27295c)).d(com.opos.mobad.service.e.a.a().f()).e(com.opos.mobad.service.e.a.a().g()).f(com.opos.mobad.service.e.a.a().h()).a(Boolean.valueOf(com.opos.mobad.service.e.a.a().j())).b(Boolean.valueOf(com.opos.mobad.service.e.a.a().d())).g(com.opos.mobad.service.e.a.a().l()).b()).a(new i.a().c(com.opos.cmn.an.b.c.c()).a(com.opos.cmn.an.b.d.b()).b(com.opos.cmn.an.b.d.a()).b()).b(com.opos.cmn.an.b.a.a(e.this.f27295c)).a(com.opos.cmn.an.b.c.a()).b();
                    k b3 = new k.a().a(Boolean.valueOf(com.opos.mobad.service.f.a.a().c())).b(com.opos.mobad.service.f.a.a().b()).a(com.opos.mobad.service.f.a.a().d()).b();
                    x b4 = new x.a().a(Boolean.valueOf(com.opos.mobad.service.f.a.a().e())).b(com.opos.mobad.service.f.a.a().g()).a(com.opos.mobad.service.f.a.a().f()).b();
                    m b5 = new m.a().a(Integer.valueOf(com.opos.cmn.i.h.a(e.this.f27295c))).a(com.opos.cmn.i.h.b(e.this.f27295c)).b();
                    t tVar = null;
                    String c3 = com.opos.mobad.service.a.a().c();
                    i = -1;
                    if (!TextUtils.isEmpty(c3)) {
                        t.a a3 = new t.a().a(c3);
                        i = com.opos.mobad.service.a.a().d();
                        a3.a(i != -1 ? i != 0 ? i != 1 ? w.UNKNOWN_STATUS : w.VIP : w.NORMAL : w.UNKNOWN_STATUS);
                        tVar = a3.b();
                    }
                    l.a a4 = new l.a().a(com.opos.cmn.a.a.b());
                    try {
                        a4.b(com.opos.cmn.an.b.b.a());
                        a4.c(com.opos.cmn.an.b.b.b());
                    } catch (Exception e) {
                        com.opos.cmn.an.f.a.b("DispatchController", "local fail");
                    }
                    p b6 = c2.a(b2).a(b3).a(b4).a(b5).a(a4.b()).b(Long.valueOf(e.this.g())).a(tVar).b();
                    com.opos.cmn.an.f.a.a("DispatchController", "refresh request", b6);
                    HashMap hashMap = new HashMap();
                    hashMap.put("Content-Type", "application/x-protobuf");
                    hashMap.put("Route-Data", com.opos.cmn.biz.a.e.a(e.this.f27295c));
                    d.a b7 = new d.a().a(p.f26357c.b((com.heytap.nearx.a.a.e<p>) b6)).a(hashMap).b(e.this.y());
                    b7.a("POST");
                    a2 = com.opos.cmn.func.b.b.b.a().a(e.this.f27295c, b7.a());
                } catch (Throwable th) {
                    com.opos.cmn.an.f.a.a("", "", th);
                }
                if (a2 == null || 200 != a2.f24862a) {
                    com.opos.cmn.an.f.a.a("DispatchController", "get dispatch fail code:", a2);
                    interfaceC0645a.b();
                    return;
                }
                q a5 = q.f26359c.a(a2.f24863c);
                if (a5 == null) {
                    com.opos.cmn.an.f.a.a("DispatchController", "get dispatch parse fail");
                    return;
                }
                com.opos.cmn.an.f.a.a("DispatchController", "response dispatch strategy:", a5);
                e.this.a(a5);
                e.this.j = Integer.valueOf(i);
                com.opos.mobad.service.c.b.a().a(e.this.v());
                interfaceC0645a.a();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(com.opos.mobad.m.a.c cVar) {
        return cVar == com.opos.mobad.m.a.c.TT || cVar == com.opos.mobad.m.a.c.GDT || cVar == com.opos.mobad.m.a.c.UNION || cVar == com.opos.mobad.m.a.c.MIX || cVar == com.opos.mobad.m.a.c.FB || cVar == com.opos.mobad.m.a.c.GG || cVar == com.opos.mobad.m.a.c.JD;
    }

    private f c(String str) {
        Bundle bundle = this.s;
        if (bundle != null) {
            com.opos.cmn.an.f.a.b("DispatchController", "getCacheStrategy");
            PosInfo posInfo = (PosInfo) bundle.getParcelable(str);
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                return new f(posInfo.b, s.f26363c.a(posInfo.f27134a));
            } catch (Exception e) {
                com.opos.cmn.an.f.a.b("DispatchController", "decode pos fail" + str, e);
                return null;
            }
        }
        return null;
    }

    private void w() {
        com.opos.cmn.an.f.a.b("DispatchController", "readStrategyFromLocal");
        this.h.a(new d.b() { // from class: com.opos.mobad.service.a.e.2
            @Override // com.opos.mobad.service.a.d.b
            public void a() {
                com.opos.cmn.an.f.a.a("DispatchController", "read strategy local fail");
            }

            @Override // com.opos.mobad.service.a.d.b
            public void a(Bundle bundle) {
                e.this.a(bundle);
            }
        });
    }

    private void x() {
        this.i = new com.opos.cmn.i.a(new a.b() { // from class: com.opos.mobad.service.a.e.3
            @Override // com.opos.cmn.i.a.b
            public void a(a.InterfaceC0645a interfaceC0645a) {
                if (e.this.n.get() || !e.this.n.compareAndSet(false, true)) {
                    e.this.b(interfaceC0645a);
                } else {
                    e.this.a(interfaceC0645a);
                }
            }
        }, 30000, 300000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String y() {
        return "https://uapi.ads.heytapmobi.com/union/strategy/v3/select";
    }

    private void z() {
        if (this.f27295c == null || !this.k.a() || this.i == null) {
            return;
        }
        com.opos.cmn.an.f.a.b("DispatchController", "refresh");
        this.i.a();
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x003c, code lost:
        if (r4.f27307a.o != null) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x003f, code lost:
        r4 = r4.f27307a.o;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0020, code lost:
        if (r4.f27307a.o != null) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int a(java.lang.String r4) {
        /*
            r3 = this;
            r0 = r3
            java.util.concurrent.atomic.AtomicReference<java.util.Map<java.lang.String, com.opos.mobad.service.a.f>> r0 = r0.l
            java.lang.Object r0 = r0.get()
            java.util.Map r0 = (java.util.Map) r0
            r5 = r0
            r0 = r5
            if (r0 != 0) goto L26
            r0 = r3
            r1 = r4
            com.opos.mobad.service.a.f r0 = r0.c(r1)
            r4 = r0
            r0 = r4
            if (r0 == 0) goto L4a
            r0 = r4
            com.opos.mobad.m.a.s r0 = r0.f27307a
            com.opos.mobad.m.a.n r0 = r0.o
            if (r0 == 0) goto L4a
            goto L3f
        L26:
            r0 = r5
            r1 = r4
            java.lang.Object r0 = r0.get(r1)
            com.opos.mobad.service.a.f r0 = (com.opos.mobad.service.a.f) r0
            r4 = r0
            r0 = r4
            if (r0 == 0) goto L4a
            r0 = r4
            com.opos.mobad.m.a.s r0 = r0.f27307a
            com.opos.mobad.m.a.n r0 = r0.o
            if (r0 == 0) goto L4a
        L3f:
            r0 = r4
            com.opos.mobad.m.a.s r0 = r0.f27307a
            com.opos.mobad.m.a.n r0 = r0.o
            r4 = r0
            goto L4e
        L4a:
            com.opos.mobad.m.a.n r0 = com.opos.mobad.m.a.n.HORIZONTAL
            r4 = r0
        L4e:
            r0 = r4
            int r0 = r0.a()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.service.a.e.a(java.lang.String):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:66:0x01f4, code lost:
        if (r0 != 2) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0207, code lost:
        if (r0.n.booleanValue() != false) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x020a, code lost:
        r14 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x020f, code lost:
        r14 = 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.opos.mobad.service.a.e.b a(java.lang.String r12, boolean r13) {
        /*
            Method dump skipped, instructions count: 564
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.service.a.e.a(java.lang.String, boolean):com.opos.mobad.service.a.e$b");
    }

    public void a() {
        com.opos.cmn.i.a aVar;
        if (this.f27295c == null || (aVar = this.i) == null) {
            return;
        }
        aVar.a();
    }

    public void a(Context context, String str, String str2, int i, int i2, long j) {
        this.f27295c = context;
        this.e = str;
        this.f = str2;
        this.d = i;
        this.g = i2;
        this.o = j;
        this.h = new com.opos.mobad.service.a.d(context, str, str2);
        x();
        this.i.a();
    }

    public void a(d dVar) {
        this.m = dVar;
    }

    public boolean a(int i) {
        boolean b2 = i == 2 ? com.opos.mobad.service.a.c.a().b() : i == 3 ? com.opos.mobad.service.a.c.a().c() : i == 6 ? com.opos.mobad.service.a.c.a().e() : i == 7 ? com.opos.mobad.service.a.c.a().f() : i == 8 ? com.opos.mobad.service.a.c.a().g() : true;
        com.opos.cmn.an.f.a.b("DispatchController", "check enable:" + i + "," + b2);
        return b2;
    }

    public String b(int i) {
        if (1 == i) {
            return this.e;
        }
        com.opos.mobad.m.a.e eVar = (com.opos.mobad.m.a.e) this.k.f27305a.get(Integer.valueOf(i));
        if (eVar == null) {
            return null;
        }
        return eVar.f;
    }

    public boolean b() {
        return this.k.b();
    }

    public boolean b(String str) {
        Map<String, f> map = this.l.get();
        f c2 = map == null ? c(str) : map.get(str);
        return ((c2 == null || c2.f27307a.u == null) ? s.k : c2.f27307a.u).booleanValue();
    }

    public String c(int i) {
        com.opos.mobad.m.a.e eVar = (com.opos.mobad.m.a.e) this.k.f27305a.get(Integer.valueOf(i));
        if (eVar == null) {
            return null;
        }
        return eVar.g;
    }

    public boolean c() {
        if (this.k.b == null || this.k.b.o == null) {
            return false;
        }
        return this.k.b.o.booleanValue();
    }

    public int d() {
        return ((this.k.b == null || this.k.b.p == null) ? com.opos.mobad.m.a.b.e : this.k.b.p).intValue();
    }

    public boolean e() {
        if (this.k.b == null || this.k.b.q == null) {
            return true;
        }
        return this.k.b.q.booleanValue();
    }

    public boolean f() {
        if (this.k.b == null || this.k.b.r == null) {
            return true;
        }
        return this.k.b.r.booleanValue();
    }

    public long g() {
        if (this.k != null) {
            return this.k.e;
        }
        return 0L;
    }

    public String h() {
        return this.k != null ? this.k.f : "";
    }

    public int i() {
        if (this.k.b == null || this.k.b.m == null) {
            return 30000;
        }
        return this.k.b.m.h.intValue();
    }

    public int j() {
        return ((this.k.b == null || this.k.b.m == null || this.k.b.m.i == null) ? com.opos.mobad.m.a.a.e : this.k.b.m.i).intValue();
    }

    public int k() {
        if (this.k.b == null || this.k.b.n == null) {
            return 30000;
        }
        return this.k.b.n.h.intValue();
    }

    public int l() {
        return ((this.k.b == null || this.k.b.n == null || this.k.b.n.i == null) ? com.opos.mobad.m.a.a.e : this.k.b.n.i).intValue();
    }

    public com.opos.mobad.service.a.a m() {
        return (this.k.b == null || this.k.b.n == null) ? new com.opos.mobad.service.a.a() : new com.opos.mobad.service.a.a(this.k.b.n);
    }

    public int n() {
        if (this.k.b == null || this.k.b.h == null) {
            return 30000;
        }
        return this.k.b.h.h.intValue();
    }

    public int o() {
        return ((this.k.b == null || this.k.b.h == null || this.k.b.h.i == null) ? com.opos.mobad.m.a.a.e : this.k.b.h.i).intValue();
    }

    public int p() {
        if (this.k.b == null || this.k.b.i == null) {
            return 30000;
        }
        return this.k.b.i.h.intValue();
    }

    public int q() {
        if (this.k.b == null || this.k.b.j == null) {
            return 30000;
        }
        return this.k.b.j.h.intValue();
    }

    public int r() {
        return ((this.k.b == null || this.k.b.j == null || this.k.b.j.i == null) ? com.opos.mobad.m.a.a.e : this.k.b.j.i).intValue();
    }

    public int s() {
        if (this.k.b == null || this.k.b.k == null) {
            return 30000;
        }
        return this.k.b.k.h.intValue();
    }

    public int t() {
        return ((this.k.b == null || this.k.b.k == null || this.k.b.k.i == null) ? com.opos.mobad.m.a.a.e : this.k.b.k.i).intValue();
    }

    public int u() {
        if (this.k.b == null || this.k.b.l == null) {
            return 30000;
        }
        return this.k.b.l.h.intValue();
    }

    public Map<Integer, String> v() {
        if (this.k == null) {
            return null;
        }
        return this.k.g;
    }
}
