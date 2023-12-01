package com.anythink.core.common;

import android.content.Context;
import android.provider.Downloads;
import android.text.TextUtils;
import android.util.Log;
import com.anythink.core.api.ATAdInfo;
import com.anythink.core.api.ATAdStatusInfo;
import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.core.api.ATSDK;
import com.anythink.core.api.AdError;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.ErrorCode;
import com.anythink.core.c.e;
import com.anythink.core.common.b.g;
import com.anythink.core.common.e.ae;
import com.anythink.core.common.e.ah;
import com.anythink.core.common.e.ai;
import com.anythink.core.common.e.al;
import com.anythink.core.common.j;
import com.anythink.core.common.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/f.class */
public abstract class f<T extends j> {
    public Context b;

    /* renamed from: c  reason: collision with root package name */
    protected String f6687c;
    protected boolean f;
    protected g k;
    private long n;
    private long o;
    private boolean p;
    private long q;
    private List<com.anythink.core.common.b.a> s;

    /* renamed from: a  reason: collision with root package name */
    private final String f6686a = getClass().getSimpleName();
    protected int e = 0;
    public String g = "";
    private boolean r = false;
    protected int h = 1;
    private Object t = new Object();
    protected com.anythink.core.common.b.a i = new com.anythink.core.common.b.a() { // from class: com.anythink.core.common.f.1
        @Override // com.anythink.core.common.b.a
        public final void onAdLoadFail(AdError adError) {
            f.this.b();
            synchronized (f.this.t) {
                Iterator it = f.this.s.iterator();
                while (it.hasNext()) {
                    com.anythink.core.common.b.a aVar = (com.anythink.core.common.b.a) it.next();
                    if (aVar != null) {
                        String str = f.this.f6687c;
                        String a2 = f.this.a();
                        String str2 = g.i.x;
                        String str3 = g.i.g;
                        com.anythink.core.common.k.n.a(str, a2, str2, str3, "[listener:" + aVar.toString() + "]");
                        aVar.onAdLoadFail(adError);
                        it.remove();
                    }
                }
            }
            f.this.b(adError);
        }

        @Override // com.anythink.core.common.b.a
        public final void onAdLoaded() {
            synchronized (f.this.t) {
                if (f.this.s != null) {
                    Iterator it = f.this.s.iterator();
                    while (it.hasNext()) {
                        com.anythink.core.common.b.a aVar = (com.anythink.core.common.b.a) it.next();
                        if (aVar != null) {
                            String str = f.this.f6687c;
                            String a2 = f.this.a();
                            String str2 = g.i.x;
                            String str3 = g.i.f;
                            com.anythink.core.common.k.n.a(str, a2, str2, str3, "[listener:" + aVar.toString() + "]");
                            aVar.onAdLoaded();
                            it.remove();
                        }
                    }
                }
            }
            f.this.l();
        }
    };
    Random j = new Random();
    double l = 0.0d;
    String m = "";
    protected ConcurrentHashMap<String, h> d = new ConcurrentHashMap<>(5);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.anythink.core.common.f$2  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/f$2.class */
    public final class AnonymousClass2 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ j f6689a;
        final /* synthetic */ String b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ com.anythink.core.common.b.a f6690c;
        final /* synthetic */ Context d;
        final /* synthetic */ int[] e;
        final /* synthetic */ String f;
        final /* synthetic */ Map g;

        AnonymousClass2(j jVar, String str, com.anythink.core.common.b.a aVar, Context context, int[] iArr, String str2, Map map) {
            this.f6689a = jVar;
            this.b = str;
            this.f6690c = aVar;
            this.d = context;
            this.e = iArr;
            this.f = str2;
            this.g = map;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public final void run() {
            synchronized (f.this) {
                if (!f.this.e() || this.f6689a.d == 0) {
                    if (f.this.i() || this.f6689a.d != 5) {
                        if (f.this.j() && this.f6689a.d == 0) {
                            Log.e("anythink", "PlacementId(" + this.b + ") the load api calls are not allowed in Auto-load mode");
                            return;
                        }
                        f.this.a(this.f6690c);
                        this.f6689a.f = f.this.i;
                        if (this.f6689a.d != 4) {
                            f.this.h = 1;
                        } else {
                            f.this.h++;
                        }
                        f.this.k();
                        StringBuilder sb = new StringBuilder("PlacementId(");
                        sb.append(this.b);
                        sb.append(") start load type:");
                        sb.append(this.f6689a.d);
                        com.anythink.core.common.b.n.a().a(this.d, com.anythink.core.common.b.n.a().p(), com.anythink.core.common.b.n.a().q());
                        final String a2 = com.anythink.core.common.k.g.a(this.d);
                        this.f6689a.f6762a = a2;
                        f.this.a(this.f6689a.f6762a, this.f6690c);
                        if (com.anythink.core.common.b.n.a().g() != null && !TextUtils.isEmpty(com.anythink.core.common.b.n.a().p()) && !TextUtils.isEmpty(com.anythink.core.common.b.n.a().q()) && !com.anythink.core.common.k.h.a(this.b)) {
                            if (f.this.g()) {
                                Log.i("anythink", "Placement(" + this.b + ") is loading.");
                                return;
                            }
                            final Context applicationContext = this.d.getApplicationContext();
                            String p = com.anythink.core.common.b.n.a().p();
                            String q = com.anythink.core.common.b.n.a().q();
                            boolean v = com.anythink.core.common.b.n.a().v();
                            com.anythink.core.c.d a3 = v ? null : com.anythink.core.c.e.a(applicationContext).a(this.b);
                            String U = a3 != null ? a3.U() : "";
                            final com.anythink.core.common.e.e a4 = com.anythink.core.common.k.s.a(a2, this.b, "", a3, "", a3 != null ? a3.l() : -1, this.f6689a.d, this.e[0], this.f6689a.g);
                            a4.z(this.f);
                            if (this.g != null) {
                                a4.a(this.g);
                            }
                            if (a3 == null && !v && (!TextUtils.isEmpty(this.f6689a.f6763c) || this.f6689a.b != null)) {
                                Log.i("anythink", "request default adsource for splash.");
                                if (f.this.a(this.b, a2, (String) this.f6689a, this.f6690c)) {
                                    com.anythink.core.c.e.a(this.d).a(null, p, q, this.b, this.f6689a.g, null);
                                    return;
                                }
                            }
                            if (f.this.e == 1 && !f.this.d() && a.a().a(this.d, this.b) != null) {
                                w.a().a(this.b, a2);
                                f.this.h();
                                a4.a(false);
                                a4.z(4);
                                com.anythink.core.common.j.a.a(applicationContext).a(10, a4);
                                com.anythink.core.common.j.a.a(applicationContext).a(12, a4);
                                f.this.f = false;
                                return;
                            }
                            if (a3 != null && f.this.p) {
                                long currentTimeMillis = System.currentTimeMillis() - f.this.q;
                                if (currentTimeMillis > 0 && currentTimeMillis < a3.aj()) {
                                    AdError errorCode = ErrorCode.getErrorCode(ErrorCode.loadFailInPacingError, "", "");
                                    a4.z(7);
                                    f.this.a(f.this.r ? false : true, a4, new e(errorCode, errorCode.printStackTrace()));
                                    f.this.r = true;
                                    return;
                                }
                            }
                            f.f(f.this);
                            f.g(f.this);
                            f.this.r = false;
                            if (a3 != null && com.anythink.core.a.b.a().a(applicationContext, this.b, a3)) {
                                AdError errorCode2 = ErrorCode.getErrorCode(ErrorCode.loadCappingError, "", "");
                                a4.z(8);
                                f.this.a(true, a4, (Throwable) new e(errorCode2, errorCode2.printStackTrace()));
                                return;
                            } else if (f.this.e()) {
                                Log.i("anythink", "Placement(" + this.b + ") is loading.");
                                return;
                            } else {
                                f.this.f = true;
                                for (h hVar : f.this.d.values()) {
                                    hVar.f();
                                }
                                final String str = U;
                                com.anythink.core.c.e.a(this.d).a(a3, p, q, this.b, this.f6689a.g, new e.a() { // from class: com.anythink.core.common.f.2.1
                                    @Override // com.anythink.core.c.e.a
                                    public final void a(AdError adError) {
                                        String str2 = g.i.g;
                                        String str3 = AnonymousClass2.this.b;
                                        String d = com.anythink.core.common.k.g.d(AnonymousClass2.this.f);
                                        String printStackTrace = adError.printStackTrace();
                                        if (ATSDK.isNetworkLogDebug()) {
                                            try {
                                                JSONObject jSONObject = new JSONObject();
                                                jSONObject.put("action", g.i.w);
                                                jSONObject.put("result", str2);
                                                jSONObject.put(com.anythink.expressad.videocommon.e.b.v, str3);
                                                jSONObject.put("adtype", d);
                                                jSONObject.put(Downloads.Impl.COLUMN_ERROR_MSG, printStackTrace);
                                                com.anythink.core.common.k.n.a("anythink_network", jSONObject.toString(), TextUtils.equals(g.i.g, str2));
                                            } catch (Throwable th) {
                                            }
                                        }
                                        AdError errorCode3 = ErrorCode.getErrorCode(ErrorCode.placeStrategyError, adError.getPlatformCode(), adError.getPlatformMSG());
                                        a4.z(5);
                                        f.this.a(true, a4, errorCode3);
                                    }

                                    @Override // com.anythink.core.c.e.a
                                    public final void a(final com.anythink.core.c.d dVar) {
                                        com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.core.common.f.2.1.1
                                            @Override // java.lang.Runnable
                                            public final void run() {
                                                synchronized (f.this) {
                                                    f.this.o = dVar.S();
                                                    com.anythink.core.common.k.s.a(a4, dVar);
                                                    if (TextUtils.equals(String.valueOf(dVar.X()), AnonymousClass2.this.f)) {
                                                        f.a(f.this, applicationContext, AnonymousClass2.this.b, a2, dVar, a4, AnonymousClass2.this.f6689a);
                                                        return;
                                                    }
                                                    AdError errorCode3 = ErrorCode.getErrorCode(ErrorCode.formatError, "", "Format corresponding to API: " + com.anythink.core.common.k.g.d(AnonymousClass2.this.f) + ", Format corresponding to placement strategy: " + com.anythink.core.common.k.g.d(String.valueOf(dVar.X())));
                                                    f.this.a(errorCode3);
                                                    a4.a(false);
                                                    com.anythink.core.common.j.c.a(a4, errorCode3);
                                                    f.this.f = false;
                                                }
                                            }
                                        });
                                    }

                                    @Override // com.anythink.core.c.e.a
                                    public final void b(final com.anythink.core.c.d dVar) {
                                        if (!TextUtils.equals(str, dVar.U())) {
                                            f.this.e = 0;
                                        }
                                        com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.core.common.f.2.1.2
                                            @Override // java.lang.Runnable
                                            public final void run() {
                                                synchronized (f.this) {
                                                    try {
                                                        f.a(f.this, dVar, a2, AnonymousClass2.this.b);
                                                    }
                                                }
                                            }
                                        });
                                    }
                                });
                                return;
                            }
                        }
                        f.this.a(ErrorCode.getErrorCode(ErrorCode.appIdOrPlaceIdEmpty, "", ""));
                        if (com.anythink.core.common.b.n.a().A()) {
                            Log.e("anythink", "Please check these params in your code (AppId: " + com.anythink.core.common.b.n.a().p() + ", AppKey: " + com.anythink.core.common.b.n.a().q() + ", PlacementId: " + this.b + ")");
                        }
                        f.this.f = false;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.anythink.core.common.f$3  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/f$3.class */
    public final class AnonymousClass3 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f6695a;
        final /* synthetic */ j b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f6696c;
        final /* synthetic */ String d;
        final /* synthetic */ com.anythink.core.c.d e;
        final /* synthetic */ boolean f;
        final /* synthetic */ List g;
        final /* synthetic */ com.anythink.core.common.e.e h;
        final /* synthetic */ al i;
        final /* synthetic */ List j;
        final /* synthetic */ List k;

        AnonymousClass3(Context context, j jVar, String str, String str2, com.anythink.core.c.d dVar, boolean z, List list, com.anythink.core.common.e.e eVar, al alVar, List list2, List list3) {
            this.f6695a = context;
            this.b = jVar;
            this.f6696c = str;
            this.d = str2;
            this.e = dVar;
            this.f = z;
            this.g = list;
            this.h = eVar;
            this.i = alVar;
            this.j = list2;
            this.k = list3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                System.currentTimeMillis();
                com.anythink.core.common.e.a aVar = new com.anythink.core.common.e.a();
                aVar.f6611a = this.f6695a;
                aVar.b = this.b;
                aVar.f6612c = this.f6696c;
                aVar.d = this.d;
                aVar.e = this.e.X();
                aVar.f = this.e.H();
                aVar.g = this.e.z();
                aVar.h = this.e.i();
                i.a();
                aVar.l = i.a(this.e, this.f);
                i.a();
                aVar.o = i.a(this.e);
                i.a();
                aVar.p = i.b(this.e);
                aVar.i = this.g;
                aVar.n = this.e;
                aVar.s = this.h;
                aVar.w = this.i;
                aVar.q = v.a().c(f.this.f6687c);
                if (this.j.size() > 0) {
                    aVar.t = (ai) this.j.get(0);
                }
                ArrayList arrayList = new ArrayList();
                if (this.k != null) {
                    arrayList.addAll(this.k);
                }
                aVar.j = arrayList;
                aVar.m = this.f;
                if (this.b.d == 8) {
                    aVar.u = 7;
                }
                com.anythink.core.b.b bVar = new com.anythink.core.b.b(aVar);
                bVar.a(ATSDK.isNetworkLogDebug());
                bVar.a(new k.a() { // from class: com.anythink.core.common.f.3.1
                    @Override // com.anythink.core.common.k.a
                    public final void a(String str) {
                        h hVar = f.this.d.get(str);
                        if (hVar != null) {
                            hVar.d();
                        }
                    }

                    @Override // com.anythink.core.common.k.a
                    public final void a(String str, List<ai> list, List<ai> list2) {
                        boolean z = com.anythink.core.c.e.a(f.this.b).a(f.this.f6687c).j() == 1;
                        ArrayList arrayList2 = null;
                        for (ai aiVar : list2) {
                            ArrayList arrayList3 = arrayList2;
                            if (z) {
                                if (aiVar.l() != 1) {
                                    arrayList3 = arrayList2;
                                    if (aiVar.l() != 3) {
                                    }
                                }
                                if (aiVar.P() != 1) {
                                    arrayList3 = arrayList2;
                                    if (arrayList2 == null) {
                                        arrayList3 = new ArrayList(4);
                                    }
                                    aiVar.y(7);
                                    arrayList3.add(aiVar);
                                }
                            }
                            arrayList2 = arrayList3;
                            if (!z) {
                                arrayList2 = arrayList3;
                                if (aiVar.k() != 0) {
                                    c.a().f6566c.put(aiVar.t(), Long.valueOf(System.currentTimeMillis()));
                                    arrayList2 = arrayList3;
                                }
                            }
                        }
                        if (list.size() > 0) {
                            w.a().a(AnonymousClass3.this.d, str, list);
                        }
                        h hVar = f.this.d.get(str);
                        if (hVar != null) {
                            hVar.a(list, list2, arrayList2);
                        }
                    }

                    @Override // com.anythink.core.common.k.a
                    public final void b(String str) {
                        w.a().a(AnonymousClass3.this.d, str);
                        h hVar = f.this.d.get(str);
                        if (hVar != null) {
                            hVar.e();
                        }
                    }
                });
            } catch (Throwable th) {
                h hVar = f.this.d.get(this.f6696c);
                if (hVar != null) {
                    hVar.e();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.anythink.core.common.f$4  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/f$4.class */
    public final class AnonymousClass4 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ATBaseAdAdapter f6698a;
        final /* synthetic */ double b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f6699c;

        /* JADX INFO: Access modifiers changed from: package-private */
        public AnonymousClass4(ATBaseAdAdapter aTBaseAdAdapter, double d, String str) {
            this.f6698a = aTBaseAdAdapter;
            this.b = d;
            this.f6699c = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.core.common.e.e trackingInfo = this.f6698a.getTrackingInfo();
            ai unitGroupInfo = this.f6698a.getUnitGroupInfo();
            if (trackingInfo == null || unitGroupInfo == null || unitGroupInfo.j() || TextUtils.equals(trackingInfo.Y(), "2") || TextUtils.equals(trackingInfo.Y(), "4")) {
                return;
            }
            if ((f.this.l <= this.b || !f.this.m.equals(this.f6699c)) && trackingInfo.H() != 35) {
                f.this.l = this.b;
                f.this.m = this.f6699c;
                if (f.this.k != null) {
                    f.this.k.cancel();
                    f.this.k = null;
                }
                f.a(f.this, unitGroupInfo, trackingInfo);
            }
        }
    }

    public f(Context context, String str) {
        this.b = context.getApplicationContext();
        this.f6687c = str;
        if (com.anythink.core.common.b.n.a().g() == null) {
            com.anythink.core.common.b.n.a().a(this.b);
        }
    }

    public static String a(com.anythink.core.common.e.j jVar) {
        return jVar.b + jVar.f6664c + jVar.f + System.currentTimeMillis();
    }

    private List<ai> a(com.anythink.core.c.d dVar, String str, int i, List<ai> list) {
        JSONArray jSONArray = new JSONArray();
        com.anythink.core.common.e.e eVar = new com.anythink.core.common.e.e();
        eVar.x(this.f6687c);
        eVar.y(str);
        StringBuilder sb = new StringBuilder();
        sb.append(dVar.X());
        eVar.z(sb.toString());
        eVar.w(dVar.U());
        eVar.t(i);
        eVar.E(dVar.O());
        eVar.v(dVar.ae());
        ArrayList arrayList = new ArrayList();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        HashMap hashMap = new HashMap(3);
        for (ai aiVar : list) {
            double a2 = com.anythink.core.common.k.g.a(aiVar);
            List list2 = (List) linkedHashMap.get(String.valueOf(a2));
            ArrayList arrayList2 = list2;
            if (list2 == null) {
                ArrayList arrayList3 = new ArrayList();
                linkedHashMap.put(String.valueOf(a2), arrayList3);
                arrayList2 = arrayList3;
            }
            Integer num = (Integer) hashMap.get(String.valueOf(a2));
            Integer num2 = num;
            if (num == null) {
                num2 = 0;
            }
            hashMap.put(String.valueOf(a2), Integer.valueOf(num2.intValue() + aiVar.T()));
            arrayList2.add(aiVar);
        }
        Iterator it = linkedHashMap.entrySet().iterator();
        while (true) {
            int i2 = 0;
            int i3 = 1;
            if (!it.hasNext()) {
                break;
            }
            Map.Entry entry = (Map.Entry) it.next();
            List list3 = (List) entry.getValue();
            if (list3.size() > 1) {
                int intValue = ((Integer) hashMap.get(entry.getKey())).intValue();
                ArrayList arrayList4 = new ArrayList();
                while (true) {
                    int i4 = i3;
                    if (list3.size() <= 0) {
                        break;
                    } else if (list3.size() == i4) {
                        arrayList4.add((ai) list3.get(i2));
                        list3.remove(i2);
                        break;
                    } else {
                        int nextInt = this.j.nextInt(intValue);
                        Iterator it2 = list3.iterator();
                        int i5 = 0;
                        int i6 = i4;
                        while (true) {
                            i3 = i6;
                            if (it2.hasNext()) {
                                ai aiVar2 = (ai) it2.next();
                                if (aiVar2.T() + i5 >= nextInt + i4) {
                                    arrayList4.add(aiVar2);
                                    list3.remove(aiVar2);
                                    intValue -= aiVar2.T();
                                    i2 = 0;
                                    i3 = 1;
                                    break;
                                }
                                i5 += aiVar2.T();
                                i2 = 0;
                                i6 = 1;
                            }
                        }
                    }
                }
                linkedHashMap.put((String) entry.getKey(), arrayList4);
            }
        }
        new StringBuilder("Request UnitGroup's Number:").append(dVar.l());
        int i7 = 0;
        for (Map.Entry entry2 : linkedHashMap.entrySet()) {
            Iterator it3 = ((List) entry2.getValue()).iterator();
            int i8 = i7;
            while (true) {
                int i9 = i8;
                i7 = i9;
                if (it3.hasNext()) {
                    ai aiVar3 = (ai) it3.next();
                    aiVar3.m((i9 / dVar.l()) + 1);
                    StringBuilder sb2 = new StringBuilder("UnitGroupInfo requestLevel:");
                    sb2.append(i9);
                    sb2.append(" || layer:");
                    sb2.append(aiVar3.E());
                    arrayList.add(aiVar3);
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("sortpriority", i9);
                        jSONObject.put("sorttype", aiVar3.o());
                        jSONObject.put("unit_id", aiVar3.t());
                        try {
                            jSONObject.put("bidresult", 1);
                            jSONObject.put("bidprice", aiVar3.M() ? String.valueOf(aiVar3.x()) : "0");
                            jSONArray.put(jSONObject);
                        } catch (Exception e) {
                        }
                    } catch (Exception e2) {
                    }
                    i8 = i9 + 1;
                }
            }
        }
        eVar.s(jSONArray.toString());
        com.anythink.core.common.j.a.a(this.b).a(15, eVar);
        return arrayList;
    }

    private void a(int i, com.anythink.core.c.d dVar, List<ai> list, List<ai> list2, List<ai> list3, List<ai> list4, List<ai> list5, List<ai> list6, List<ai> list7, ae aeVar, com.anythink.core.common.e.e eVar) {
        AtomicInteger atomicInteger = new AtomicInteger(list.size() + list2.size() + list3.size());
        for (ai aiVar : list) {
            if (a(i, dVar, eVar.W(), eVar, aeVar, aiVar, atomicInteger)) {
                aiVar.b();
                list7.add(aiVar);
            } else {
                list4.add(aiVar);
            }
        }
        for (ai aiVar2 : list2) {
            if (a(i, dVar, eVar.W(), eVar, aeVar, aiVar2, atomicInteger)) {
                aiVar2.b();
                list7.add(aiVar2);
            } else {
                list5.add(aiVar2);
            }
        }
        for (ai aiVar3 : list3) {
            if (a(i, dVar, eVar.W(), eVar, aeVar, aiVar3, atomicInteger)) {
                aiVar3.b();
                list7.add(aiVar3);
            } else {
                list6.add(aiVar3);
            }
        }
        if (list4.size() > 0 || list5.size() > 0 || list6.size() > 0) {
            return;
        }
        eVar.z(6);
        if (atomicInteger.get() == 0) {
            eVar.z(10);
        }
        AdError errorCode = ErrorCode.getErrorCode(ErrorCode.noAvailableAdsource, "", "");
        throw new e(errorCode, errorCode.printStackTrace());
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x039e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(android.content.Context r17, java.lang.String r18, java.lang.String r19, com.anythink.core.c.d r20, com.anythink.core.common.e.e r21, T r22) {
        /*
            Method dump skipped, instructions count: 1035
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.core.common.f.a(android.content.Context, java.lang.String, java.lang.String, com.anythink.core.c.d, com.anythink.core.common.e.e, com.anythink.core.common.j):void");
    }

    private void a(ATBaseAdAdapter aTBaseAdAdapter, String str, double d) {
        com.anythink.core.common.b.n.a().a(new AnonymousClass4(aTBaseAdAdapter, d, str));
    }

    private static void a(com.anythink.core.c.d dVar, ae aeVar, com.anythink.core.common.e.e eVar) {
        long ab = dVar.ab();
        long ac = dVar.ac();
        int i = 0;
        int i2 = aeVar != null ? aeVar.d : 0;
        if (aeVar != null) {
            i = aeVar.f6623c;
        }
        if ((ab == -1 || i < ab) && (ac == -1 || i2 < ac)) {
            return;
        }
        eVar.z(1);
        throw new e(ErrorCode.getErrorCode(ErrorCode.outOfCapError, "", ""), "Capping.");
    }

    private static void a(com.anythink.core.c.d dVar, com.anythink.core.common.e.e eVar) {
        if (dVar.aw()) {
            return;
        }
        eVar.z(5);
        throw new e(ErrorCode.getErrorCode(ErrorCode.placementAdClose, "", ""), "Strategy is close.");
    }

    private void a(com.anythink.core.c.d dVar, String str, String str2) {
        List<ai> a2 = com.anythink.core.c.d.a(dVar.af(), dVar.ag());
        List<ai> a3 = com.anythink.core.c.d.a(dVar.ah(), dVar.C(), dVar.ai(), dVar.A(), dVar.s(), dVar.ao(), dVar.ap());
        a3.addAll(com.anythink.core.c.d.d(dVar.g()));
        List<ai> c2 = com.anythink.core.c.d.c(dVar.n());
        if (c2 != null) {
            int size = c2.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    break;
                }
                com.anythink.core.common.k.g.a(a2, c2.get(i2), true);
                i = i2 + 1;
            }
        }
        if ((a3 != null ? a3.size() : 0) > 0) {
            for (ai aiVar : a3) {
                com.anythink.core.common.e.b a4 = a.a().a(str2, aiVar);
                if (a4 != null) {
                    try {
                        aiVar.a(a4.e().getUnitGroupInfo(), 0, 3, 1);
                        com.anythink.core.common.k.g.a(a2, aiVar, true);
                    } catch (Exception e) {
                    }
                }
                com.anythink.core.common.e.m a5 = com.anythink.core.b.f.a().a(aiVar);
                if (a5 != null) {
                    aiVar.a(a5, 0, 2, 1);
                    com.anythink.core.common.k.g.a(a2, aiVar, true);
                } else if (!TextUtils.isEmpty(str)) {
                    h hVar = this.d.get(str);
                    ai aiVar2 = null;
                    if (hVar != null) {
                        String t = aiVar.t();
                        aiVar2 = null;
                        if (hVar.D != null) {
                            aiVar2 = hVar.D.get(t);
                        }
                    }
                    if (aiVar2 != null) {
                        aiVar.a(aiVar2, 0, 3, 1);
                        com.anythink.core.common.k.g.a(a2, aiVar, true);
                    }
                }
            }
        }
        w.a().a(str2, str, dVar, a2);
    }

    private static void a(com.anythink.core.c.d dVar, List list, List list2, List list3, com.anythink.core.common.e.e eVar) {
        if (list == null || list.size() == 0) {
            if (list2 == null || list2.size() == 0) {
                if (list3 == null || list3.size() == 0) {
                    eVar.z(5);
                    if (dVar.h() != 1) {
                        throw new e(ErrorCode.getErrorCode(ErrorCode.noAdsourceConfig, "", ""), "No Adsource.");
                    }
                    throw new e(ErrorCode.getErrorCode(ErrorCode.noAdsourceConfigInDebugerMode, "", ""), "No Adsource.");
                }
            }
        }
    }

    private void a(ai aiVar, com.anythink.core.common.e.e eVar) {
        g gVar = new g(aiVar.p(), aiVar.p(), aiVar, eVar);
        this.k = gVar;
        gVar.start();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x039e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ void a(com.anythink.core.common.f r16, android.content.Context r17, java.lang.String r18, java.lang.String r19, com.anythink.core.c.d r20, com.anythink.core.common.e.e r21, com.anythink.core.common.j r22) {
        /*
            Method dump skipped, instructions count: 1035
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.core.common.f.a(com.anythink.core.common.f, android.content.Context, java.lang.String, java.lang.String, com.anythink.core.c.d, com.anythink.core.common.e.e, com.anythink.core.common.j):void");
    }

    static /* synthetic */ void a(f fVar, com.anythink.core.c.d dVar, String str, String str2) {
        List<ai> a2 = com.anythink.core.c.d.a(dVar.af(), dVar.ag());
        List<ai> a3 = com.anythink.core.c.d.a(dVar.ah(), dVar.C(), dVar.ai(), dVar.A(), dVar.s(), dVar.ao(), dVar.ap());
        a3.addAll(com.anythink.core.c.d.d(dVar.g()));
        List<ai> c2 = com.anythink.core.c.d.c(dVar.n());
        if (c2 != null) {
            int size = c2.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    break;
                }
                com.anythink.core.common.k.g.a(a2, c2.get(i2), true);
                i = i2 + 1;
            }
        }
        if ((a3 != null ? a3.size() : 0) > 0) {
            for (ai aiVar : a3) {
                com.anythink.core.common.e.b a4 = a.a().a(str2, aiVar);
                if (a4 != null) {
                    try {
                        aiVar.a(a4.e().getUnitGroupInfo(), 0, 3, 1);
                        com.anythink.core.common.k.g.a(a2, aiVar, true);
                    } catch (Exception e) {
                    }
                }
                com.anythink.core.common.e.m a5 = com.anythink.core.b.f.a().a(aiVar);
                if (a5 != null) {
                    aiVar.a(a5, 0, 2, 1);
                    com.anythink.core.common.k.g.a(a2, aiVar, true);
                } else if (!TextUtils.isEmpty(str)) {
                    h hVar = fVar.d.get(str);
                    ai aiVar2 = null;
                    if (hVar != null) {
                        String t = aiVar.t();
                        aiVar2 = null;
                        if (hVar.D != null) {
                            aiVar2 = hVar.D.get(t);
                        }
                    }
                    if (aiVar2 != null) {
                        aiVar.a(aiVar2, 0, 3, 1);
                        com.anythink.core.common.k.g.a(a2, aiVar, true);
                    }
                }
            }
        }
        w.a().a(str2, str, dVar, a2);
    }

    static /* synthetic */ void a(f fVar, ai aiVar, com.anythink.core.common.e.e eVar) {
        g gVar = new g(aiVar.p(), aiVar.p(), aiVar, eVar);
        fVar.k = gVar;
        gVar.start();
    }

    private void a(List<ai> list, List<ai> list2, com.anythink.core.common.e.e eVar, List<ai> list3) {
        boolean z;
        int size = list2.size() - 1;
        boolean z2 = false;
        while (true) {
            z = z2;
            if (size < 0) {
                break;
            }
            ai aiVar = list2.get(size);
            if (aiVar.aa()) {
                list3.add(aiVar);
            }
            boolean z3 = z;
            if (aiVar.m() != 2) {
                com.anythink.core.common.e.b a2 = a.a().a(this.f6687c, aiVar);
                ai aiVar2 = null;
                if (a2 != null) {
                    aiVar.a(a2.e().getUnitGroupInfo(), 0, 3, 1);
                    aiVar2 = aiVar;
                }
                ai aiVar3 = aiVar2;
                if (aiVar2 == null) {
                    try {
                        com.anythink.core.common.e.m a3 = com.anythink.core.b.f.a().a(aiVar);
                        if (a3 == null || a3.a()) {
                            aiVar3 = aiVar2;
                            if (a3 != null) {
                                com.anythink.core.common.e.r rVar = new com.anythink.core.common.e.r();
                                rVar.f6674a = 1;
                                rVar.b = a3.getSortPrice();
                                rVar.e = eVar;
                                rVar.f6675c = aiVar;
                                rVar.d = aiVar;
                                a3.a(rVar, true);
                                aiVar3 = aiVar2;
                            }
                        } else {
                            aiVar.a(a3, 0, 2, 1);
                            aiVar3 = aiVar;
                        }
                    } catch (Throwable th) {
                        aiVar3 = aiVar2;
                    }
                }
                z3 = z;
                if (aiVar3 != null) {
                    z3 = z;
                    try {
                        if (aiVar.l() == 7) {
                            z3 = true;
                        }
                        list2.remove(size);
                        boolean z4 = z3;
                        com.anythink.core.common.k.g.a(list, aiVar, false);
                    } catch (Exception e) {
                        z3 = z;
                    }
                }
            }
            size--;
            z2 = z3;
        }
        if (!z) {
            return;
        }
        int size2 = list2.size();
        while (true) {
            int i = size2 - 1;
            if (i < 0) {
                return;
            }
            if (list2.get(i).l() == 7) {
                list2.remove(i);
            }
            size2 = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, com.anythink.core.common.e.e eVar, AdError adError) {
        this.f = false;
        a(adError);
        eVar.a(false);
        if (z) {
            com.anythink.core.common.j.a.a(this.b).a(10, eVar);
            com.anythink.core.common.j.c.a(eVar, adError);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, com.anythink.core.common.e.e eVar, Throwable th) {
        a(z, eVar, th instanceof e ? ((e) th).f6610a : ErrorCode.getErrorCode(ErrorCode.exception, "", th.getMessage()));
    }

    private boolean a(int i, com.anythink.core.c.d dVar, String str, com.anythink.core.common.e.e eVar, ae aeVar, ai aiVar, AtomicInteger atomicInteger) {
        com.anythink.core.common.e.d d;
        com.anythink.core.common.e.e N = eVar.N();
        com.anythink.core.common.k.s.a(N, aiVar, 0, false);
        ae.a a2 = aeVar != null ? aeVar.a(aiVar.t()) : null;
        int i2 = a2 != null ? a2.e : 0;
        int i3 = a2 != null ? a2.d : 0;
        if (aiVar.e() != -1 && i3 >= aiVar.e()) {
            aiVar.g(-5);
            aiVar.h("Out of Cap");
            com.anythink.core.common.k.n.a(str, eVar, "Out of Cap", aiVar, i2, i3);
            com.anythink.core.common.j.c.a(N, 2, ErrorCode.getErrorCode(ErrorCode.outOfCapError, "", "Out of Cap"));
            return true;
        } else if (aiVar.f() != -1 && i2 >= aiVar.f()) {
            aiVar.g(-5);
            aiVar.h("Out of Cap");
            com.anythink.core.common.k.n.a(str, eVar, "Out of Cap", aiVar, i2, i3);
            com.anythink.core.common.j.c.a(N, 2, ErrorCode.getErrorCode(ErrorCode.outOfCapError, "", "Out of Cap"));
            return true;
        } else if (com.anythink.core.a.c.a().a(str, aiVar)) {
            aiVar.g(-6);
            aiVar.h("Out of Pacing");
            com.anythink.core.common.k.n.a(str, eVar, "Out of Pacing", aiVar, i2, i3);
            com.anythink.core.common.j.c.a(N, 3, ErrorCode.getErrorCode(ErrorCode.inPacingError, "", "Out of Pacing"));
            return true;
        } else if (c.a().a(aiVar)) {
            aiVar.g(-6);
            aiVar.h("Request fail in pacing");
            com.anythink.core.common.k.n.a(str, eVar, "Request fail in pacing", aiVar, i2, i3);
            com.anythink.core.common.j.c.a(N, 4, ErrorCode.getErrorCode(ErrorCode.inRequestFailPacing, "", "Request fail in pacing"));
            return true;
        } else {
            List<String> l = com.anythink.core.common.b.n.a().l(this.f6687c);
            if (l != null && l.contains(aiVar.t())) {
                aiVar.g(-8);
                aiVar.h("Request fail in filter list");
                com.anythink.core.common.k.n.a(str, eVar, "Request fail in filter list", aiVar, i2, i3, l);
                com.anythink.core.common.j.c.a(N, 5, ErrorCode.getErrorCode(ErrorCode.filterSourceError, "", "Request fail in filter list"));
                return true;
            }
            List<String> m = com.anythink.core.common.b.n.a().m(this.f6687c);
            if (m != null && m.contains(String.valueOf(aiVar.c()))) {
                aiVar.g(-8);
                aiVar.h("Filter by network firm id.");
                com.anythink.core.common.k.n.a(str, eVar, "Filter by network firm id.", aiVar, i2, i3, m);
                com.anythink.core.common.j.c.a(N, 9, ErrorCode.getErrorCode(ErrorCode.networkFirmIdfilterSourceError, "", "Filter by network firm id."));
                return true;
            }
            if (aiVar.j()) {
                if (c.a().b(aiVar)) {
                    aiVar.g(-7);
                    aiVar.h("Bid fail in pacing");
                    com.anythink.core.common.k.n.a(str, eVar, "Bid fail in pacing", aiVar, i2, i3);
                    com.anythink.core.common.j.c.a(N, 4, ErrorCode.getErrorCode(ErrorCode.inRequestFailPacing, "", "Bid fail in pacing"));
                    return true;
                } else if (aiVar.X() != 1 && aiVar.l() == 2 && (d = v.a().d(this.f6687c)) != null && d.a(aiVar)) {
                    aiVar.g(-7);
                    aiVar.h("Can't Load On Showing");
                    com.anythink.core.common.k.n.a(str, eVar, "Can't Load On Showing", aiVar, i2, i3);
                    com.anythink.core.common.j.c.a(eVar, 7, ErrorCode.getErrorCode(ErrorCode.loadInShowingFilter, "", "Can't Load On Showing"));
                    return true;
                }
            }
            if (c.a().a(i, dVar, aiVar)) {
                atomicInteger.decrementAndGet();
                aiVar.g(-8);
                aiVar.h("Error Code Request fail in pacing");
                com.anythink.core.common.k.n.a(str, eVar, "Error Code Request fail in pacing", aiVar, i2, i3);
                com.anythink.core.common.j.c.a(N, 10, ErrorCode.getErrorCode(ErrorCode.inNetworkErrorCodeRequestFailPacing, "", "Error Code Request fail in pacing"));
                return true;
            }
            return false;
        }
    }

    private boolean a(boolean z, boolean z2, Map<String, Object> map) {
        com.anythink.core.c.d a2 = com.anythink.core.c.e.a(com.anythink.core.common.b.n.a().g()).a(this.f6687c);
        String str = TextUtils.isEmpty(this.g) ? "" : this.g;
        com.anythink.core.c.d dVar = a2;
        if (a2 == null) {
            dVar = com.anythink.core.c.e.a(this.b).a(this.f6687c);
        }
        if (dVar == null) {
            com.anythink.core.common.e.e a3 = com.anythink.core.common.k.s.a("", this.f6687c, "", null, "", -1, 0, 0, map);
            if (z) {
                com.anythink.core.common.j.c.a(a3, 4, "", str);
                return true;
            } else if (z2) {
                com.anythink.core.common.j.c.a(a3, false, 4, -1, "", -1, "", "", str, false, "");
                return true;
            } else {
                return true;
            }
        }
        com.anythink.core.a.c.a();
        if (com.anythink.core.a.c.a(this.f6687c, dVar)) {
            com.anythink.core.common.e.e a4 = com.anythink.core.common.k.s.a("", this.f6687c, "", dVar, "", dVar.l(), 0, 0, map);
            if (z) {
                com.anythink.core.common.j.c.a(a4, 3, "", str);
                return true;
            } else if (z2) {
                com.anythink.core.common.j.c.a(a4, false, 3, -1, "", -1, "", "", str, false, "");
                return true;
            } else {
                return true;
            }
        } else if (com.anythink.core.a.a.a(this.b).a(dVar, this.f6687c)) {
            com.anythink.core.common.e.e a5 = com.anythink.core.common.k.s.a("", this.f6687c, "", dVar, "", dVar.l(), 0, 0, map);
            if (z) {
                com.anythink.core.common.j.c.a(a5, 2, "", str);
                return true;
            } else if (z2) {
                com.anythink.core.common.j.c.a(a5, false, 2, -1, "", -1, "", "", str, false, "");
                return true;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    private static void b(com.anythink.core.c.d dVar, com.anythink.core.common.e.e eVar) {
        com.anythink.core.a.c.a();
        if (com.anythink.core.a.c.a(eVar.W(), dVar)) {
            eVar.z(2);
            throw new e(ErrorCode.getErrorCode(ErrorCode.inPacingError, "", ""), "Pacing.");
        }
    }

    static /* synthetic */ boolean f(f fVar) {
        fVar.p = false;
        return false;
    }

    static /* synthetic */ long g(f fVar) {
        fVar.q = 0L;
        return 0L;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.anythink.core.api.ATAdStatusInfo a(android.content.Context r7, java.util.Map<java.lang.String, java.lang.Object> r8) {
        /*
            r6 = this;
            r0 = r6
            boolean r0 = r0.e()
            r10 = r0
            r0 = 0
            r9 = r0
            r0 = r6
            r1 = r7
            r2 = 1
            r3 = 0
            r4 = r8
            com.anythink.core.common.e.b r0 = r0.a(r1, r2, r3, r4)
            r8 = r0
            r0 = r8
            if (r0 == 0) goto L3c
            r0 = r8
            com.anythink.core.api.BaseAd r0 = r0.f()
            r7 = r0
            r0 = r8
            com.anythink.core.api.ATBaseAdAdapter r0 = r0.e()
            r11 = r0
            r0 = r7
            if (r0 == 0) goto L2c
            r0 = r7
            com.anythink.core.common.b.j r0 = com.anythink.core.common.b.j.a(r0)
            r7 = r0
            goto L3e
        L2c:
            r0 = r11
            if (r0 == 0) goto L3c
            r0 = r8
            com.anythink.core.api.ATBaseAdAdapter r0 = r0.e()
            com.anythink.core.common.b.j r0 = com.anythink.core.common.b.j.a(r0)
            r7 = r0
            goto L3e
        L3c:
            r0 = 0
            r7 = r0
        L3e:
            r0 = r8
            if (r0 == 0) goto L44
            r0 = 1
            r9 = r0
        L44:
            com.anythink.core.api.ATAdStatusInfo r0 = new com.anythink.core.api.ATAdStatusInfo
            r1 = r0
            r2 = r10
            r3 = r9
            r4 = r7
            r1.<init>(r2, r3, r4)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.core.common.f.a(android.content.Context, java.util.Map):com.anythink.core.api.ATAdStatusInfo");
    }

    public com.anythink.core.common.e.b a(Context context, boolean z, boolean z2, Map<String, Object> map) {
        if (a(z2, z, map)) {
            return null;
        }
        return a.a().a(context, this.f6687c, z, z2, map);
    }

    public abstract h a(T t);

    protected abstract String a();

    public final List<ATAdInfo> a(Context context) {
        List<com.anythink.core.common.e.b> a2;
        if (a(false, false, (Map<String, Object>) null) || (a2 = a.a().a(context, this.f6687c, false, false, true, null)) == null || a2.size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(3);
        Iterator<com.anythink.core.common.e.b> it = a2.iterator();
        while (it.hasNext()) {
            com.anythink.core.common.e.b next = it.next();
            BaseAd f = next != null ? next.f() : null;
            ATBaseAdAdapter e = next != null ? next.e() : null;
            if (f != null) {
                arrayList.add(com.anythink.core.common.b.j.a(f));
            } else if (e != null) {
                arrayList.add(com.anythink.core.common.b.j.a(e));
            }
        }
        return arrayList;
    }

    public final void a(Context context, String str, String str2, T t, com.anythink.core.common.b.a aVar) {
        Map<String, Object> c2 = v.a().c(str2);
        int[] iArr = {0};
        if (c2.containsKey(ah.O)) {
            try {
                iArr[0] = ((Integer) c2.get(ah.O)).intValue();
            } catch (Throwable th) {
            }
        }
        if (t.d == 0 || t.d == 3) {
            v.a().a(str2, new Throwable().getStackTrace());
        }
        com.anythink.core.common.k.b.a.a().a(new AnonymousClass2(t, str2, aVar, context, iArr, str, c2));
    }

    public final void a(AdError adError) {
        com.anythink.core.common.b.a aVar = this.i;
        if (aVar != null) {
            aVar.onAdLoadFail(adError);
        }
    }

    public final void a(com.anythink.core.common.b.a aVar) {
        synchronized (this.t) {
            if (this.s == null) {
                this.s = new ArrayList();
            }
            if (aVar == null) {
                return;
            }
            boolean z = false;
            for (com.anythink.core.common.b.a aVar2 : this.s) {
                if (aVar2 == aVar) {
                    z = true;
                }
            }
            if (!z) {
                this.s.add(aVar);
            }
        }
    }

    public final void a(com.anythink.core.common.e.b bVar) {
        if (bVar.c()) {
            this.e = 0;
        }
    }

    public final void a(String str) {
        if (!TextUtils.equals(str, com.anythink.core.c.e.a(this.b).a(this.f6687c).U())) {
            this.e = 0;
            return;
        }
        this.e = 1;
        this.n = System.currentTimeMillis();
        this.p = false;
        this.q = 0L;
        this.r = false;
    }

    public final void a(String str, double d, ai aiVar) {
        h hVar = this.d.get(str);
        if (hVar != null) {
            hVar.a(d, aiVar);
        }
    }

    public void a(String str, com.anythink.core.common.b.a aVar) {
    }

    public final boolean a(ATAdStatusInfo aTAdStatusInfo) {
        com.anythink.core.c.d a2 = com.anythink.core.c.e.a(com.anythink.core.common.b.n.a().g()).a(this.f6687c);
        if (this.e != 1 || d() || aTAdStatusInfo == null || !aTAdStatusInfo.isReady()) {
            if (j()) {
                return true;
            }
            return a2 != null && a2.V() == 1;
        }
        return false;
    }

    public boolean a(String str, String str2, T t, com.anythink.core.common.b.a aVar) {
        return false;
    }

    public final void b() {
        com.anythink.core.c.d b = com.anythink.core.c.e.a(this.b).b(this.f6687c);
        if (this.p || b == null) {
            return;
        }
        this.p = true;
        this.q = System.currentTimeMillis();
    }

    public void b(AdError adError) {
    }

    public final void b(String str) {
        this.d.remove(str);
    }

    public final h c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.d.get(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean c() {
        return System.currentTimeMillis() - this.q <= 2000;
    }

    public final void d(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.core.common.f.6
            @Override // java.lang.Runnable
            public final void run() {
                h hVar = f.this.d.get(str);
                if (hVar != null) {
                    hVar.i();
                }
            }
        });
    }

    public final boolean d() {
        return System.currentTimeMillis() - this.n >= this.o;
    }

    public final boolean e() {
        h hVar;
        if (this.f) {
            return true;
        }
        return (TextUtils.isEmpty(this.g) || (hVar = this.d.get(this.g)) == null || hVar.c()) ? false : true;
    }

    public final void f() {
        com.anythink.core.common.b.n.a().a(new Runnable() { // from class: com.anythink.core.common.f.5
            @Override // java.lang.Runnable
            public final void run() {
                if (f.this.k != null) {
                    f.this.k.cancel();
                    f.this.k = null;
                }
            }
        });
    }

    public boolean g() {
        return false;
    }

    public final void h() {
        com.anythink.core.common.b.a aVar = this.i;
        if (aVar != null) {
            aVar.onAdLoaded();
        }
    }

    public boolean i() {
        return !TextUtils.isEmpty(this.g);
    }

    protected boolean j() {
        return false;
    }

    protected void k() {
    }

    public void l() {
    }
}
