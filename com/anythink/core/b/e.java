package com.anythink.core.b;

import android.os.SystemClock;
import android.text.TextUtils;
import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.core.api.ATBidRequestInfo;
import com.anythink.core.api.AdError;
import com.anythink.core.b.i;
import com.anythink.core.common.b.n;
import com.anythink.core.common.e.ai;
import com.anythink.core.common.e.l;
import com.anythink.core.common.e.m;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/b/e.class */
public abstract class e extends d {
    public static final double g = 10000.0d;
    final String h;
    protected final List<JSONObject> i;
    List<ai> j;
    List<ai> k;
    String l;
    String m;
    String n;
    com.anythink.core.b.b.a o;
    long p;
    protected m q;
    protected String r;
    protected AtomicBoolean s;
    protected AtomicBoolean t;
    ConcurrentHashMap<String, ai> u;
    ConcurrentHashMap<String, ai> v;
    ConcurrentHashMap<String, ai> w;
    ConcurrentHashMap<String, ai> x;
    Runnable y;

    public e(com.anythink.core.common.e.a aVar) {
        super(aVar);
        this.h = getClass().getSimpleName() + ":";
        this.i = new ArrayList();
        this.j = new ArrayList();
        this.k = new ArrayList();
        this.s = new AtomicBoolean(false);
        this.t = new AtomicBoolean(false);
        this.u = new ConcurrentHashMap<>();
        this.v = new ConcurrentHashMap<>();
        this.w = new ConcurrentHashMap<>();
        this.x = new ConcurrentHashMap<>();
        this.y = new Runnable() { // from class: com.anythink.core.b.e.1
            @Override // java.lang.Runnable
            public final void run() {
                com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.core.b.e.1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        e.this.g();
                    }
                });
            }
        };
        if (aVar.i != null && aVar.i.size() > 0) {
            for (ai aiVar : aVar.i) {
                if (aiVar != null) {
                    this.u.put(aiVar.t(), aiVar);
                    this.w.put(aiVar.t(), aiVar);
                }
            }
        }
        if (aVar.k != null && aVar.k.size() > 0) {
            for (ai aiVar2 : aVar.k) {
                this.v.put(aiVar2.t(), aiVar2);
            }
        }
        if (aVar.r != null) {
            this.i.add(aVar.r);
        }
        if (aVar.t != null) {
            this.q = aVar.t.N();
            this.r = aVar.t.t();
            if (this.q == null) {
                com.anythink.core.common.e.b a = com.anythink.core.common.a.a().a(aVar.d, aVar.t);
                if (a != null) {
                    this.q = a.e().getUnitGroupInfo().N();
                } else {
                    this.q = f.a().a(aVar.t);
                }
            }
        }
        this.l = aVar.c;
        this.m = aVar.d;
        this.n = b();
    }

    static /* synthetic */ List a(e eVar, Object obj) {
        ArrayList arrayList = new ArrayList();
        if (obj instanceof JSONObject) {
            JSONArray optJSONArray = ((JSONObject) obj).optJSONArray("data");
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= optJSONArray.length()) {
                    break;
                }
                m a = m.a(optJSONArray.optString(i2));
                if (a != null) {
                    a.b(eVar.l);
                }
                arrayList.add(a);
                i = i2 + 1;
            }
        }
        return arrayList;
    }

    private List<m> a(Object obj) {
        ArrayList arrayList = new ArrayList();
        if (obj instanceof JSONObject) {
            JSONArray optJSONArray = ((JSONObject) obj).optJSONArray("data");
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= optJSONArray.length()) {
                    break;
                }
                m a = m.a(optJSONArray.optString(i2));
                if (a != null) {
                    a.b(this.l);
                }
                arrayList.add(a);
                i = i2 + 1;
            }
        }
        return arrayList;
    }

    private void a(long j) {
        n.a().a(this.y, j);
    }

    private void a(long j, int i, String str, Map<String, ai> map) {
        for (ai aiVar : map.values()) {
            if (a(aiVar, str, i)) {
                this.k.add(aiVar);
            } else {
                b(aiVar, str, j, i);
            }
        }
        map.clear();
    }

    static /* synthetic */ void a(e eVar, ai aiVar) {
        int c = aiVar.c();
        com.anythink.core.common.j.c.a(aiVar, eVar.d, SystemClock.elapsedRealtime() - eVar.p, true, f.a().b(c));
        f.a().a(c);
    }

    static /* synthetic */ void a(e eVar, Object obj, List list) {
        JSONArray optJSONArray;
        if (!(obj instanceof JSONObject)) {
            return;
        }
        JSONObject jSONObject = (JSONObject) obj;
        if (!jSONObject.has("wf") || (optJSONArray = jSONObject.optJSONArray("wf")) == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= optJSONArray.length()) {
                break;
            }
            arrayList.add(j.a(optJSONArray.optString(i2)));
            i = i2 + 1;
        }
        Collections.sort(arrayList);
        int size = arrayList.size();
        if (size == 1) {
            j jVar = (j) arrayList.get(0);
            if (jVar.c == 0.0d && TextUtils.equals(eVar.r, jVar.b)) {
                jVar.c = 10000.0d;
                Iterator it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    m mVar = (m) it.next();
                    if (TextUtils.equals(jVar.b, mVar.k) && mVar.isSuccessWithUseType()) {
                        m mVar2 = eVar.q;
                        if (mVar2 == null || !TextUtils.equals(mVar2.g, jVar.d)) {
                            eVar.q = mVar;
                        }
                        jVar.c = Math.max(jVar.c, mVar.o);
                    }
                }
                f.a().a(jVar.d, jVar.b, jVar);
                return;
            }
            return;
        }
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= size) {
                return;
            }
            j jVar2 = (j) arrayList.get(i4);
            if (jVar2.c == 0.0d && TextUtils.equals(eVar.r, jVar2.b)) {
                if (i4 == 0) {
                    int i5 = i4 + 1;
                    if (((j) arrayList.get(i5)).c == 0.0d) {
                        jVar2.c = 10000.0d;
                    } else {
                        jVar2.c = ((j) arrayList.get(i5)).c + 0.1d;
                    }
                } else if (i4 == size - 1) {
                    int i6 = i4 - 1;
                    if (((j) arrayList.get(i6)).c - 0.1d <= 0.0d) {
                        jVar2.c = ((j) arrayList.get(i6)).c / 2.0d;
                    } else {
                        jVar2.c = ((j) arrayList.get(i6)).c - 0.1d;
                    }
                } else {
                    double d = ((j) arrayList.get(i4 - 1)).c;
                    double d2 = d - 0.1d;
                    double d3 = d - ((j) arrayList.get(i4 + 1)).c;
                    if (Math.abs(d3) <= 0.1d) {
                        d2 = d - (d3 / 2.0d);
                    }
                    jVar2.c = d2;
                }
                Iterator it2 = list.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    m mVar3 = (m) it2.next();
                    if (TextUtils.equals(jVar2.b, mVar3.k) && mVar3.isSuccessWithUseType()) {
                        m mVar4 = eVar.q;
                        if (mVar4 == null || !TextUtils.equals(mVar4.g, jVar2.d)) {
                            eVar.q = mVar3;
                        }
                        jVar2.c = Math.max(jVar2.c, mVar3.o);
                    }
                }
                f.a().a(jVar2.d, jVar2.b, jVar2);
            }
            i3 = i4 + 1;
        }
    }

    static /* synthetic */ void a(e eVar, String str, ai aiVar) {
        if (TextUtils.equals(str, ATBidRequestInfo.NO_ADAPTER_ERROR_TYPE) || TextUtils.equals(str, ATBidRequestInfo.NO_SUPPORT_BIDDING_TYPE)) {
            return;
        }
        int c = aiVar.c();
        com.anythink.core.common.j.c.a(aiVar, eVar.d, SystemClock.elapsedRealtime() - eVar.p, false, f.a().b(c));
        f.a().a(c);
    }

    private void a(m mVar) {
        if (TextUtils.isEmpty(mVar.i)) {
            return;
        }
        try {
            com.anythink.core.common.e.g a = com.anythink.core.common.a.c.a(mVar.token, new JSONObject(mVar.i), mVar.d);
            if (a == null) {
                return;
            }
            if (mVar.d == 67) {
                com.anythink.core.common.d.c.a(this.d.a).a(a.p(), a.P());
                com.anythink.core.common.d.b.a(this.d.a).a(a.q(), a.P());
            }
            com.anythink.core.common.a.a.a().a(this.d.a, mVar.d, mVar.k, mVar.token, mVar.i);
        } catch (Throwable th) {
        }
    }

    private void a(Object obj, List<m> list) {
        JSONArray optJSONArray;
        if (!(obj instanceof JSONObject)) {
            return;
        }
        JSONObject jSONObject = (JSONObject) obj;
        if (!jSONObject.has("wf") || (optJSONArray = jSONObject.optJSONArray("wf")) == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= optJSONArray.length()) {
                break;
            }
            arrayList.add(j.a(optJSONArray.optString(i2)));
            i = i2 + 1;
        }
        Collections.sort(arrayList);
        int size = arrayList.size();
        if (size == 1) {
            j jVar = (j) arrayList.get(0);
            if (jVar.c == 0.0d && TextUtils.equals(this.r, jVar.b)) {
                jVar.c = 10000.0d;
                Iterator<m> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    m next = it.next();
                    if (TextUtils.equals(jVar.b, next.k) && next.isSuccessWithUseType()) {
                        m mVar = this.q;
                        if (mVar == null || !TextUtils.equals(mVar.g, jVar.d)) {
                            this.q = next;
                        }
                        jVar.c = Math.max(jVar.c, next.o);
                    }
                }
                f.a().a(jVar.d, jVar.b, jVar);
                return;
            }
            return;
        }
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= size) {
                return;
            }
            j jVar2 = (j) arrayList.get(i4);
            if (jVar2.c == 0.0d && TextUtils.equals(this.r, jVar2.b)) {
                if (i4 == 0) {
                    int i5 = i4 + 1;
                    if (((j) arrayList.get(i5)).c == 0.0d) {
                        jVar2.c = 10000.0d;
                    } else {
                        jVar2.c = ((j) arrayList.get(i5)).c + 0.1d;
                    }
                } else if (i4 == size - 1) {
                    int i6 = i4 - 1;
                    if (((j) arrayList.get(i6)).c - 0.1d <= 0.0d) {
                        jVar2.c = ((j) arrayList.get(i6)).c / 2.0d;
                    } else {
                        jVar2.c = ((j) arrayList.get(i6)).c - 0.1d;
                    }
                } else {
                    double d = ((j) arrayList.get(i4 - 1)).c;
                    double d2 = d - 0.1d;
                    double d3 = d - ((j) arrayList.get(i4 + 1)).c;
                    if (Math.abs(d3) <= 0.1d) {
                        d2 = d - (d3 / 2.0d);
                    }
                    jVar2.c = d2;
                }
                Iterator<m> it2 = list.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    m next2 = it2.next();
                    if (TextUtils.equals(jVar2.b, next2.k) && next2.isSuccessWithUseType()) {
                        m mVar2 = this.q;
                        if (mVar2 == null || !TextUtils.equals(mVar2.g, jVar2.d)) {
                            this.q = next2;
                        }
                        jVar2.c = Math.max(jVar2.c, next2.o);
                    }
                }
                f.a().a(jVar2.d, jVar2.b, jVar2);
            }
            i3 = i4 + 1;
        }
    }

    private void a(String str, ai aiVar) {
        if (TextUtils.equals(str, ATBidRequestInfo.NO_ADAPTER_ERROR_TYPE) || TextUtils.equals(str, ATBidRequestInfo.NO_SUPPORT_BIDDING_TYPE)) {
            return;
        }
        int c = aiVar.c();
        com.anythink.core.common.j.c.a(aiVar, this.d, SystemClock.elapsedRealtime() - this.p, false, f.a().b(c));
        f.a().a(c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<m> list, long j, String str, Map<String, ai> map) {
        synchronized (this) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.h);
            sb.append("handleResult: ");
            if (list != null && list.size() > 0) {
                Collections.sort(list);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= list.size()) {
                        break;
                    }
                    m mVar = list.get(i2);
                    this.u.remove(mVar.k);
                    ai remove = map.remove(mVar.k);
                    ai aiVar = remove;
                    if (remove == null) {
                        aiVar = remove;
                        if (this.v.containsKey(mVar.k)) {
                            aiVar = this.v.remove(mVar.k);
                            this.v.clear();
                        }
                    }
                    if (aiVar != null) {
                        if (mVar.isSuccessWithUseType()) {
                            int i3 = i2 + 1;
                            double d = 0.0d;
                            if (i3 < list.size()) {
                                m mVar2 = list.get(i3);
                                d = mVar2.getSortPrice();
                                if (d == 0.0d) {
                                    d = f.a().a(mVar2.g, aiVar.t());
                                }
                            }
                            a(aiVar.c(), mVar, d);
                        }
                        a(aiVar, mVar, j);
                    }
                    i = i2 + 1;
                }
            }
            if (map != null) {
                for (String str2 : map.keySet()) {
                    if (str2 != null) {
                        this.u.remove(str2);
                    }
                    if (this.v.containsKey(str2)) {
                        this.v.clear();
                    }
                }
            }
            if (map != null) {
                a(j, -4, TextUtils.isEmpty(str) ? "No Response error." : "No Response error." + str, map);
            }
            if (this.k.size() >= 2) {
                Collections.sort(this.k);
            }
            n();
            m();
            l();
        }
    }

    private void a(List<JSONObject> list, Map<String, ai> map) {
        synchronized (this) {
            list.addAll(this.i);
            this.i.clear();
            map.putAll(this.x);
            this.x.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(JSONObject jSONObject, ai aiVar) {
        synchronized (this) {
            this.i.add(jSONObject);
            this.x.put(aiVar.t(), aiVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final long j) {
        synchronized (this) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.h);
            sb.append("beginRequestBidInfo");
            ArrayList arrayList = new ArrayList();
            final ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            a(arrayList, concurrentHashMap);
            this.t.set(true);
            a(arrayList, new com.anythink.core.common.g.i() { // from class: com.anythink.core.b.e.3
                @Override // com.anythink.core.common.g.i
                public final void onLoadCanceled(int i) {
                    synchronized (e.class) {
                        try {
                            e.this.t.set(false);
                            e.this.d();
                            e.this.a((List<m>) null, SystemClock.elapsedRealtime() - j, "onLoadCanceled.", concurrentHashMap);
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }

                @Override // com.anythink.core.common.g.i
                public final void onLoadError(int i, String str, AdError adError) {
                    synchronized (e.class) {
                        try {
                            e.this.t.set(false);
                            e.this.d();
                            e.this.a((List<m>) null, SystemClock.elapsedRealtime() - j, adError != null ? adError.getPlatformMSG() : "", concurrentHashMap);
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }

                @Override // com.anythink.core.common.g.i
                public final void onLoadFinish(int i, Object obj) {
                    synchronized (e.class) {
                        try {
                            e.this.t.set(false);
                            long elapsedRealtime = SystemClock.elapsedRealtime();
                            long j2 = j;
                            List a = e.a(e.this, obj);
                            e.a(e.this, obj, a);
                            e.this.a(a, elapsedRealtime - j2, (String) null, concurrentHashMap);
                            e.this.d();
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }

                @Override // com.anythink.core.common.g.i
                public final void onLoadStart(int i) {
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ void b(com.anythink.core.b.e r7) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r11 = r0
            r0 = r11
            r1 = r7
            java.lang.String r1 = r1.h
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r11
            java.lang.String r1 = "handleBidTokenResult"
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r7
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.anythink.core.common.e.ai> r0 = r0.w
            int r0 = r0.size()
            r8 = r0
            r0 = 1
            r10 = r0
            r0 = r8
            if (r0 != 0) goto L3d
            r0 = r7
            r0.e()
            r0 = r7
            java.util.concurrent.atomic.AtomicBoolean r0 = r0.t
            boolean r0 = r0.get()
            if (r0 != 0) goto L3d
            r0 = 1
            r8 = r0
            goto L3f
        L3d:
            r0 = 0
            r8 = r0
        L3f:
            r0 = r7
            int r0 = r0.h()
            if (r0 <= 0) goto L70
            r0 = r10
            r9 = r0
            r0 = r8
            if (r0 != 0) goto L72
            r0 = r7
            java.util.concurrent.atomic.AtomicBoolean r0 = r0.s
            boolean r0 = r0.get()
            if (r0 == 0) goto L65
            r0 = r7
            java.util.concurrent.atomic.AtomicBoolean r0 = r0.t
            boolean r0 = r0.get()
            if (r0 != 0) goto L65
            r0 = 1
            r8 = r0
            goto L67
        L65:
            r0 = 0
            r8 = r0
        L67:
            r0 = r8
            if (r0 == 0) goto L70
            r0 = r10
            r9 = r0
            goto L72
        L70:
            r0 = 0
            r9 = r0
        L72:
            r0 = r9
            if (r0 == 0) goto L7f
            r0 = r7
            r1 = r7
            long r1 = r1.p
            r0.b(r1)
            return
        L7f:
            r0 = r7
            java.util.List<com.anythink.core.common.e.ai> r0 = r0.j
            int r0 = r0.size()
            if (r0 <= 0) goto L9c
            r0 = r7
            boolean r0 = r0.o()
            if (r0 == 0) goto L9c
            r0 = r7
            r1 = 0
            r2 = 0
            java.lang.String r3 = ""
            r4 = 0
            r0.a(r1, r2, r3, r4)
        L9c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.core.b.e.b(com.anythink.core.b.e):void");
    }

    private void b(ai aiVar) {
        int c = aiVar.c();
        com.anythink.core.common.j.c.a(aiVar, this.d, SystemClock.elapsedRealtime() - this.p, true, f.a().b(c));
        f.a().a(c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ai aiVar, String str, long j, int i) {
        a(aiVar, str, j, i);
        this.j.add(aiVar);
    }

    private void e() {
        n.a().c(this.y);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void f() {
        /*
            r7 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r11 = r0
            r0 = r11
            r1 = r7
            java.lang.String r1 = r1.h
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r11
            java.lang.String r1 = "handleBidTokenResult"
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r7
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.anythink.core.common.e.ai> r0 = r0.w
            int r0 = r0.size()
            r8 = r0
            r0 = 1
            r10 = r0
            r0 = r8
            if (r0 != 0) goto L3d
            r0 = r7
            r0.e()
            r0 = r7
            java.util.concurrent.atomic.AtomicBoolean r0 = r0.t
            boolean r0 = r0.get()
            if (r0 != 0) goto L3d
            r0 = 1
            r8 = r0
            goto L3f
        L3d:
            r0 = 0
            r8 = r0
        L3f:
            r0 = r7
            int r0 = r0.h()
            if (r0 <= 0) goto L70
            r0 = r10
            r9 = r0
            r0 = r8
            if (r0 != 0) goto L72
            r0 = r7
            java.util.concurrent.atomic.AtomicBoolean r0 = r0.s
            boolean r0 = r0.get()
            if (r0 == 0) goto L65
            r0 = r7
            java.util.concurrent.atomic.AtomicBoolean r0 = r0.t
            boolean r0 = r0.get()
            if (r0 != 0) goto L65
            r0 = 1
            r8 = r0
            goto L67
        L65:
            r0 = 0
            r8 = r0
        L67:
            r0 = r8
            if (r0 == 0) goto L70
            r0 = r10
            r9 = r0
            goto L72
        L70:
            r0 = 0
            r9 = r0
        L72:
            r0 = r9
            if (r0 == 0) goto L7f
            r0 = r7
            r1 = r7
            long r1 = r1.p
            r0.b(r1)
            return
        L7f:
            r0 = r7
            java.util.List<com.anythink.core.common.e.ai> r0 = r0.j
            int r0 = r0.size()
            if (r0 <= 0) goto L9c
            r0 = r7
            boolean r0 = r0.o()
            if (r0 == 0) goto L9c
            r0 = r7
            r1 = 0
            r2 = 0
            java.lang.String r3 = ""
            r4 = 0
            r0.a(r1, r2, r3, r4)
        L9c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.core.b.e.f():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        synchronized (this) {
            if (this.f.get()) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(this.h);
            sb.append("get token short timeout.");
            this.s.set(true);
            if (h() > 0) {
                b(SystemClock.elapsedRealtime());
            }
        }
    }

    private int h() {
        int size;
        synchronized (this) {
            size = this.i.size();
        }
        return size;
    }

    private boolean i() {
        return !this.t.get() && this.i.size() > 0;
    }

    private boolean j() {
        return this.s.get() && !this.t.get();
    }

    private void k() {
        synchronized (this) {
            if (!this.f.get()) {
                StringBuilder sb = new StringBuilder();
                sb.append(this.h);
                sb.append("finishCallback: ");
                this.f.set(true);
                e();
                this.w.clear();
                a(0L, -3, ATBidRequestInfo.BIDDING_REQUEST_TIMEOUT_TYPE, this.u);
                a(0L, -3, ATBidRequestInfo.BIDDING_REQUEST_TIMEOUT_TYPE, this.v);
                n();
                m();
                l();
            }
        }
    }

    private void l() {
        com.anythink.core.b.b.a aVar;
        if ((this.k.size() > 0 || this.j.size() > 0) && (aVar = this.o) != null) {
            aVar.a(this.k, this.j);
        }
        this.k.clear();
        this.j.clear();
    }

    private void m() {
        synchronized (this) {
            if (o()) {
                this.f.set(true);
            }
        }
    }

    private void n() {
        if (this.e) {
            if (this.k.size() > 0 || this.j.size() > 0) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("S2S HeadBidding Success List", a(this.k));
                    jSONObject.put("S2S HeadBidding Fail List", a(this.j));
                } catch (Exception e) {
                }
                com.anythink.core.common.k.n.a(com.anythink.core.common.k.n.a, jSONObject.toString(), false);
            }
        }
    }

    private boolean o() {
        return this.u.size() == 0 && this.v.size() == 0 && this.w.size() == 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.anythink.core.b.d
    public final void a() {
        k();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.anythink.core.b.d
    public final void a(com.anythink.core.b.b.a aVar) {
        this.p = SystemClock.elapsedRealtime();
        this.o = aVar;
        if (this.e) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("S2S Start HeadBidding List", a(this.d.i));
                jSONObject.put("S2S Start HeadBidding List(Directly)", b(this.i));
            } catch (Exception e) {
            }
            com.anythink.core.common.k.n.a(com.anythink.core.common.k.n.a, jSONObject.toString(), false);
        }
        if (this.d.i.size() == 0 && this.d.k != null && this.d.k.size() > 0) {
            b(this.p);
            return;
        }
        long t = this.d.n.t();
        long j = t;
        if (t <= 0) {
            j = 500;
        }
        n.a().a(this.y, j);
        for (Map.Entry<String, ai> entry : this.u.entrySet()) {
            ai value = entry.getValue();
            i iVar = new i(this.d);
            i.a aVar2 = new i.a() { // from class: com.anythink.core.b.e.2
                @Override // com.anythink.core.b.i.a
                public final void a(ai aiVar, ATBaseAdAdapter aTBaseAdAdapter) {
                    if (e.this.o != null) {
                        e.this.o.a(aiVar, aTBaseAdAdapter);
                    }
                }

                @Override // com.anythink.core.b.i.a
                public final void a(ai aiVar, JSONObject jSONObject2) {
                    if (e.this.f.get()) {
                        return;
                    }
                    e.this.w.remove(aiVar.t());
                    e.a(e.this, aiVar);
                    e.this.a(jSONObject2, aiVar);
                    e.b(e.this);
                }

                @Override // com.anythink.core.b.i.a
                public final void a(String str, ai aiVar) {
                    if (e.this.f.get()) {
                        return;
                    }
                    String str2 = str;
                    if (str == null) {
                        str2 = "";
                    }
                    e.this.w.remove(aiVar.t());
                    e.this.u.remove(aiVar.t());
                    e.a(e.this, str2, aiVar);
                    boolean z = true;
                    switch (str2.hashCode()) {
                        case -1295842379:
                            if (str2.equals(ATBidRequestInfo.NO_SUPPORT_BIDDING_TYPE)) {
                                z = true;
                                break;
                            }
                            break;
                        case -49992206:
                            if (str2.equals(ATBidRequestInfo.BIDTOKEN_OBTAIN_TIMEOUT_TYPE)) {
                                z = true;
                                break;
                            }
                            break;
                        case 56988620:
                            if (str2.equals(ATBidRequestInfo.BIDTOKEN_EMPTY_ERROR_TYPE)) {
                                z = true;
                                break;
                            }
                            break;
                        case 204511524:
                            if (str2.equals(ATBidRequestInfo.INIT_ERROR_TYPE)) {
                                z = true;
                                break;
                            }
                            break;
                        case 1316982070:
                            if (str2.equals(ATBidRequestInfo.RETURN_PARAMS_ERROR_TYPE)) {
                                z = true;
                                break;
                            }
                            break;
                        case 1956498070:
                            if (str2.equals(ATBidRequestInfo.NO_ADAPTER_ERROR_TYPE)) {
                                z = false;
                                break;
                            }
                            break;
                    }
                    if (!z || z || z || z) {
                        e.this.b(aiVar, str2, 0L, -9);
                    } else if (z || z) {
                        e.this.b(aiVar, str2, 0L, -2);
                    } else {
                        e.this.b(aiVar, "Unknown error: ".concat(String.valueOf(str2)), 0L, -9);
                    }
                    e.b(e.this);
                }
            };
            iVar.d = aVar2;
            ATBaseAdAdapter a = com.anythink.core.common.k.i.a(value);
            if (a == null) {
                aVar2.a(ATBidRequestInfo.NO_ADAPTER_ERROR_TYPE, value);
            } else {
                com.anythink.core.common.k.b.a.a().a(new i.AnonymousClass1(a, value));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.anythink.core.b.d
    public void a(ai aiVar, l lVar, long j) {
        String str;
        int i;
        boolean z = lVar instanceof m;
        if (z) {
            m mVar = (m) lVar;
            if (mVar.isSuccessWithUseType()) {
                if (z && !TextUtils.isEmpty(mVar.i)) {
                    try {
                        com.anythink.core.common.e.g a = com.anythink.core.common.a.c.a(mVar.token, new JSONObject(mVar.i), mVar.d);
                        if (a != null) {
                            if (mVar.d == 67) {
                                com.anythink.core.common.d.c.a(this.d.a).a(a.p(), a.P());
                                com.anythink.core.common.d.b.a(this.d.a).a(a.q(), a.P());
                            }
                            com.anythink.core.common.a.a.a().a(this.d.a, mVar.d, mVar.k, mVar.token, mVar.i);
                        }
                    } catch (Throwable th) {
                    }
                }
                aiVar.a(j);
                this.k.add(aiVar);
                if (aiVar.l() == 3 || aiVar.l() == 7) {
                    mVar.f = mVar.e + System.currentTimeMillis();
                } else {
                    mVar.f = aiVar.n() + System.currentTimeMillis();
                }
                a(aiVar, mVar);
                return;
            }
            int i2 = 0;
            if (mVar.useType == 2) {
                aiVar.Q();
                str = "filter by s2s bid max count";
                i2 = 1;
                i = 0;
            } else {
                str = "errorCode:[" + mVar.a + "],errorMsg:[" + mVar.errorMsg + "]";
                i = -1;
            }
            if (a(aiVar, str, i, i2)) {
                this.k.add(aiVar);
            } else {
                b(aiVar, str, j, i);
            }
        }
    }

    protected abstract void a(List<JSONObject> list, com.anythink.core.common.g.i iVar);

    @Override // com.anythink.core.b.d
    public final void a(boolean z) {
        this.e = z;
    }

    protected abstract String b();

    protected final void d() {
        synchronized (this) {
            if (!this.t.get() && this.i.size() > 0) {
                com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.core.b.e.4
                    @Override // java.lang.Runnable
                    public final void run() {
                        e.this.b(SystemClock.elapsedRealtime());
                    }
                });
            }
        }
    }
}
