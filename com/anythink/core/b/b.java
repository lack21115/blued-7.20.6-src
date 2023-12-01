package com.anythink.core.b;

import android.text.TextUtils;
import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.core.api.ErrorCode;
import com.anythink.core.common.b.n;
import com.anythink.core.common.e.ai;
import com.anythink.core.common.e.m;
import com.anythink.core.common.e.r;
import com.anythink.core.common.k;
import com.anythink.core.common.k.s;
import com.anythink.core.common.w;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/b/b.class */
public class b extends com.anythink.core.common.k.a implements k.b {
    public static final String a = b.class.getSimpleName();
    Map<String, com.anythink.core.common.e.e> b = new ConcurrentHashMap(3);
    Runnable c = new Runnable() { // from class: com.anythink.core.b.b.1
        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.core.b.b.1.1
                @Override // java.lang.Runnable
                public final void run() {
                    b.this.c();
                }
            });
        }
    };
    private String d;
    private k.a e;
    private String f;
    private long g;
    private boolean h;
    private com.anythink.core.common.e.a i;
    private Map<Integer, d> j;
    private long k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.anythink.core.b.b$5  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/core/b/b$5.class */
    public final class AnonymousClass5 implements Runnable {
        final /* synthetic */ com.anythink.core.common.e.e a;
        final /* synthetic */ ai b;

        AnonymousClass5(com.anythink.core.common.e.e eVar, ai aiVar) {
            this.a = eVar;
            this.b = aiVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (b.this.i.b.e != null) {
                if (this.a != null) {
                    b.this.i.b.e.a(this.a, ErrorCode.getErrorCode(ErrorCode.adSourceBidError, "", this.b.z()));
                }
                b.this.b.remove(this.b.t());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.anythink.core.b.b$6  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/core/b/b$6.class */
    public final class AnonymousClass6 implements Runnable {
        final /* synthetic */ com.anythink.core.common.e.e a;
        final /* synthetic */ ai b;

        AnonymousClass6(com.anythink.core.common.e.e eVar, ai aiVar) {
            this.a = eVar;
            this.b = aiVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (b.this.i.b.e != null) {
                com.anythink.core.common.e.e eVar = this.a;
                if (eVar != null) {
                    s.a(eVar, this.b, 0, false);
                    b.this.i.b.e.b(this.a);
                }
                b.this.b.remove(this.b.t());
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01f8 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public b(com.anythink.core.common.e.a r8) {
        /*
            Method dump skipped, instructions count: 732
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.core.b.b.<init>(com.anythink.core.common.e.a):void");
    }

    static /* synthetic */ void a(b bVar, ai aiVar, ATBaseAdAdapter aTBaseAdAdapter) {
        if (aiVar.l() == 7 || aTBaseAdAdapter == null) {
            return;
        }
        try {
            if (bVar.i.b.e != null) {
                com.anythink.core.common.e.e N = bVar.i.s.N();
                s.a(N, aiVar, 0, false);
                N.g(aTBaseAdAdapter.getNetworkPlacementId());
                bVar.b.put(aiVar.t(), N);
                N.d(0.0d);
                N.a(0.0d);
                N.b(0.0d);
                bVar.i.b.e.a(N);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void a(ai aiVar) {
        com.anythink.core.common.e.e eVar = this.b.get(aiVar.t());
        if (eVar != null) {
            com.anythink.core.common.k.b.a.a().a(new AnonymousClass5(eVar, aiVar));
        }
    }

    private void a(ai aiVar, ATBaseAdAdapter aTBaseAdAdapter) {
        if (aiVar.l() == 7 || aTBaseAdAdapter == null) {
            return;
        }
        try {
            if (this.i.b.e != null) {
                com.anythink.core.common.e.e N = this.i.s.N();
                s.a(N, aiVar, 0, false);
                N.g(aTBaseAdAdapter.getNetworkPlacementId());
                this.b.put(aiVar.t(), N);
                N.d(0.0d);
                N.a(0.0d);
                N.b(0.0d);
                this.i.b.e.a(N);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Integer num) {
        synchronized (this) {
            d dVar = this.j.get(num);
            if (dVar != null && dVar.c()) {
                this.j.remove(num);
                e();
            }
        }
    }

    private void a(final Integer num, List<ai> list, List<ai> list2) {
        synchronized (this) {
            int size = list != null ? list.size() : 0;
            int size2 = list2 != null ? list2.size() : 0;
            if (size > 0 || size2 > 0) {
                final ArrayList arrayList = new ArrayList();
                final ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = new ArrayList();
                com.anythink.core.c.d a2 = com.anythink.core.c.e.a(this.i.a).a(this.d);
                if (size > 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= size) {
                            break;
                        }
                        ai aiVar = list.get(i2);
                        a(this.d, aiVar, true);
                        if (a2.a(aiVar.t()) || this.i.u == 8) {
                            arrayList.add(aiVar);
                            arrayList3.add(aiVar);
                            com.anythink.core.common.e.e eVar = this.b.get(aiVar.t());
                            if (eVar != null) {
                                com.anythink.core.common.k.b.a.a().a(new AnonymousClass6(eVar, aiVar));
                            }
                        }
                        i = i2 + 1;
                    }
                    list.clear();
                }
                if (size2 > 0) {
                    int i3 = 0;
                    while (true) {
                        int i4 = i3;
                        if (i4 >= size2) {
                            break;
                        }
                        ai aiVar2 = list2.get(i4);
                        if (aiVar2 == null) {
                            try {
                                StackTraceElement[] stackTrace = new Throwable().getStackTrace();
                                com.anythink.core.common.j.c.a("Bid Fail AdSource Object is null, currentSize:" + list2.size() + "\n" + com.anythink.core.common.k.h.a(stackTrace), "Bidding inner error", n.a().r());
                            } catch (Throwable th) {
                            }
                            i3 = i4 + 1;
                        }
                        a(this.d, aiVar2, false);
                        if (a2.a(aiVar2.t()) || this.i.u == 8) {
                            if (com.anythink.core.common.k.g.a(aiVar2) <= 0.0d || TextUtils.isEmpty(aiVar2.y())) {
                                arrayList2.add(aiVar2);
                            } else {
                                arrayList.add(aiVar2);
                            }
                            arrayList3.add(aiVar2);
                            com.anythink.core.common.e.e eVar2 = this.b.get(aiVar2.t());
                            if (eVar2 != null) {
                                com.anythink.core.common.k.b.a.a().a(new AnonymousClass5(eVar2, aiVar2));
                            }
                        }
                        i3 = i4 + 1;
                    }
                    list2.clear();
                }
                if (arrayList.size() > 1) {
                    Collections.sort(arrayList, new Comparator<ai>() { // from class: com.anythink.core.b.b.3
                        private static int a(ai aiVar3, ai aiVar4) {
                            int i5 = (com.anythink.core.common.k.g.a(aiVar3) > com.anythink.core.common.k.g.a(aiVar4) ? 1 : (com.anythink.core.common.k.g.a(aiVar3) == com.anythink.core.common.k.g.a(aiVar4) ? 0 : -1));
                            if (i5 > 0) {
                                return -1;
                            }
                            return i5 == 0 ? 0 : 1;
                        }

                        @Override // java.util.Comparator
                        public final /* synthetic */ int compare(ai aiVar3, ai aiVar4) {
                            int i5 = (com.anythink.core.common.k.g.a(aiVar3) > com.anythink.core.common.k.g.a(aiVar4) ? 1 : (com.anythink.core.common.k.g.a(aiVar3) == com.anythink.core.common.k.g.a(aiVar4) ? 0 : -1));
                            if (i5 > 0) {
                                return -1;
                            }
                            return i5 == 0 ? 0 : 1;
                        }
                    });
                }
                com.anythink.core.b.d.a.a(this.i.d, this.i.n, this.i.c, this.i.b != null ? this.i.b.d : 0, arrayList3, this.k, this.i.s.S(), this.i.u);
                com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.core.b.b.4
                    @Override // java.lang.Runnable
                    public final void run() {
                        synchronized (b.this) {
                            if (b.this.e != null) {
                                b.this.e.a(b.this.f, arrayList, arrayList2);
                            }
                            b.this.a(num);
                        }
                    }
                });
            }
        }
    }

    private void a(String str, ai aiVar, boolean z) {
        boolean z2;
        if (aiVar.m() == 2) {
            com.anythink.core.common.e.b a2 = com.anythink.core.common.a.a().a(str, aiVar);
            m N = aiVar.N();
            if (a2 != null) {
                try {
                    if (aiVar.aa()) {
                        m N2 = a2.e().getUnitGroupInfo().N();
                        if (N2 != null) {
                            j b = f.a().b(N2.g, N2.k);
                            m N3 = aiVar.N();
                            j b2 = N3 != null ? f.a().b(N3.g, N3.k) : null;
                            if (b != null && b2 != null) {
                                f.a().c(N2.g, N2.k);
                                z2 = true;
                            }
                        }
                        z2 = false;
                    } else {
                        if (com.anythink.core.common.k.g.a(aiVar) > com.anythink.core.common.k.g.a(a2.e().getUnitGroupInfo())) {
                            z2 = true;
                        }
                        z2 = false;
                    }
                    if (z2) {
                        aiVar.a(aiVar, 2, aiVar.o(), 1);
                        ai unitGroupInfo = a2.e().getUnitGroupInfo();
                        m N4 = unitGroupInfo.N();
                        if (N4 != null) {
                            double a3 = com.anythink.core.common.k.g.a(aiVar);
                            String str2 = this.i.c;
                            String str3 = this.i.d;
                            com.anythink.core.c.d dVar = this.i.n;
                            Map<String, Object> map = null;
                            if (this.i.b != null) {
                                map = this.i.b.g;
                            }
                            com.anythink.core.common.e.e a4 = s.a(str2, str3, "", dVar, "", 1, 0, 0, map);
                            r rVar = new r();
                            rVar.a = 2;
                            rVar.b = a3;
                            rVar.e = a4;
                            rVar.c = aiVar;
                            rVar.d = unitGroupInfo;
                            N4.a(rVar, true);
                        }
                        w.a().a(this.i.d, this.i.c, unitGroupInfo);
                        com.anythink.core.common.a.a().a(str, aiVar.t());
                        return;
                    }
                    ai unitGroupInfo2 = a2.e().getUnitGroupInfo();
                    double a5 = com.anythink.core.common.k.g.a(unitGroupInfo2);
                    String str4 = unitGroupInfo2.N() != null ? unitGroupInfo2.N().token : "";
                    if (N != null && !TextUtils.equals(N.token, str4)) {
                        String str5 = this.i.c;
                        String str6 = this.i.d;
                        com.anythink.core.c.d dVar2 = this.i.n;
                        Map<String, Object> map2 = null;
                        if (this.i.b != null) {
                            map2 = this.i.b.g;
                        }
                        com.anythink.core.common.e.e a6 = s.a(str5, str6, "", dVar2, "", 1, 0, 0, map2);
                        r rVar2 = new r();
                        rVar2.b = a5;
                        rVar2.e = a6;
                        rVar2.c = unitGroupInfo2;
                        rVar2.d = aiVar;
                        if (unitGroupInfo2.aa()) {
                            rVar2.a = 3;
                            N.a(rVar2, true);
                        } else {
                            rVar2.a = 2;
                            N.a(rVar2, true);
                        }
                    }
                    ai unitGroupInfo3 = a2.e().getUnitGroupInfo();
                    int o = aiVar.o();
                    int i = 0;
                    if (z) {
                        i = 1;
                    }
                    aiVar.a(unitGroupInfo3, 1, o, i);
                } catch (Exception e) {
                }
            }
        }
    }

    private void b(ai aiVar) {
        com.anythink.core.common.e.e eVar = this.b.get(aiVar.t());
        if (eVar != null) {
            com.anythink.core.common.k.b.a.a().a(new AnonymousClass6(eVar, aiVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Integer num, List<ai> list, List<ai> list2) {
        synchronized (this) {
            a(num, list, list2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        synchronized (this) {
            try {
                if (this.e != null) {
                    this.e.a(this.f);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private void d() {
        long j = this.i.h;
        long j2 = j;
        if (j <= 0) {
            j2 = 2000;
        }
        n.a().a(this.c, j2);
    }

    private void e() {
        synchronized (this) {
            if (this.j.size() == 0) {
                a();
                n.a().c(this.c);
                if (this.e != null) {
                    this.e.b(this.f);
                }
                this.e = null;
            }
        }
    }

    private void f() {
        this.e = null;
    }

    @Override // com.anythink.core.common.k.b
    public final void a(k.a aVar) {
        this.e = aVar;
        super.a(this.g);
        long j = this.i.h;
        long j2 = j;
        if (j <= 0) {
            j2 = 2000;
        }
        n.a().a(this.c, j2);
        this.k = System.currentTimeMillis();
        for (Map.Entry entry : new HashMap(this.j).entrySet()) {
            final Integer num = (Integer) entry.getKey();
            final d dVar = (d) entry.getValue();
            com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.core.b.b.2
                @Override // java.lang.Runnable
                public final void run() {
                    d dVar2 = dVar;
                    if (dVar2 != null) {
                        dVar2.a(b.this.h);
                        dVar.a(new com.anythink.core.b.b.a() { // from class: com.anythink.core.b.b.2.1
                            @Override // com.anythink.core.b.b.a
                            public final void a(ai aiVar, ATBaseAdAdapter aTBaseAdAdapter) {
                                b.a(b.this, aiVar, aTBaseAdAdapter);
                            }

                            @Override // com.anythink.core.b.b.a
                            public final void a(List<ai> list, List<ai> list2) {
                                b.this.b(num, list, list2);
                            }
                        });
                    }
                }
            });
        }
    }

    @Override // com.anythink.core.common.k.b
    public final void a(boolean z) {
        this.h = z;
    }

    @Override // com.anythink.core.common.k.a
    public final void b() {
        synchronized (this) {
            for (Map.Entry entry : new HashMap(this.j).entrySet()) {
                d dVar = (d) entry.getValue();
                if (dVar != null) {
                    dVar.a();
                }
            }
        }
    }
}
