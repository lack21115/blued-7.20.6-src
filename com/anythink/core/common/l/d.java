package com.anythink.core.common.l;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.core.api.ATCustomLoadListener;
import com.anythink.core.api.ATSDK;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.ErrorCode;
import com.anythink.core.common.b.g;
import com.anythink.core.common.b.n;
import com.anythink.core.common.b.p;
import com.anythink.core.common.e.ae;
import com.anythink.core.common.e.ai;
import com.anythink.core.common.e.m;
import com.anythink.core.common.k.i;
import com.anythink.core.common.k.s;
import com.anythink.core.common.k.t;
import com.anythink.core.common.v;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/l/d.class */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static final String f6835a = d.class.getSimpleName();
    String b;

    /* renamed from: c  reason: collision with root package name */
    ai f6836c;
    com.anythink.core.common.e.e d;
    String e;
    int f;
    ATBaseAdAdapter g;
    b h;
    boolean i;
    boolean j;
    long k;
    long l;
    Runnable m;
    Runnable n;
    c o;
    Boolean p;
    int q;
    String r;
    boolean s;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.anythink.core.common.l.d$1  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/l/d$1.class */
    public final class AnonymousClass1 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ATBaseAdAdapter f6837a;
        final /* synthetic */ ai b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Map f6838c;

        AnonymousClass1(ATBaseAdAdapter aTBaseAdAdapter, ai aiVar, Map map) {
            this.f6837a = aTBaseAdAdapter;
            this.b = aiVar;
            this.f6838c = map;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (d.this.h != null) {
                d.this.h.a(this.f6837a);
            }
            Context a2 = d.a(d.this);
            if (a2 == null) {
                if (d.this.h != null) {
                    com.anythink.core.common.l.a aVar = new com.anythink.core.common.l.a();
                    aVar.f6831a = 0;
                    aVar.f6832c = SystemClock.elapsedRealtime() - d.this.k;
                    aVar.b = ErrorCode.getErrorCode(ErrorCode.adapterInnerError, "", "Request Context is null! Please check the Ad init Context.");
                    d.this.a(this.f6837a, aVar);
                    return;
                }
                return;
            }
            d.a(d.this, a2, this.b, this.f6837a);
            try {
                Map<String, Object> b = d.b(d.this);
                d.this.g = this.f6837a;
                this.f6837a.internalLoad(a2, this.f6838c, b, new a(d.this, d.this, this.f6837a, (byte) 0));
                com.anythink.core.common.e.e trackingInfo = this.f6837a.getTrackingInfo();
                trackingInfo.g(this.f6837a.getNetworkPlacementId());
                if (d.this.h != null) {
                    d.this.h.b(trackingInfo);
                }
            } catch (Throwable th) {
                com.anythink.core.common.l.a aVar2 = new com.anythink.core.common.l.a();
                aVar2.f6831a = 0;
                aVar2.f6832c = SystemClock.elapsedRealtime() - d.this.k;
                aVar2.b = ErrorCode.getErrorCode(ErrorCode.adapterInnerError, "", th.getMessage());
                d.this.a(this.f6837a, aVar2);
            }
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/l/d$a.class */
    public final class a implements ATCustomLoadListener {

        /* renamed from: a  reason: collision with root package name */
        ATBaseAdAdapter f6842a;
        d b;

        private a(d dVar, ATBaseAdAdapter aTBaseAdAdapter) {
            this.b = dVar;
            this.f6842a = aTBaseAdAdapter;
        }

        /* synthetic */ a(d dVar, d dVar2, ATBaseAdAdapter aTBaseAdAdapter, byte b) {
            this(dVar2, aTBaseAdAdapter);
        }

        @Override // com.anythink.core.api.ATCustomLoadListener
        public final void onAdCacheLoaded(final BaseAd... baseAdArr) {
            com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.core.common.l.d.a.2
                @Override // java.lang.Runnable
                public final void run() {
                    synchronized (a.this) {
                        if (a.this.b != null && a.this.f6842a != null) {
                            a.this.b.a(a.this.f6842a, baseAdArr);
                            a.this.b = null;
                            a.this.f6842a = null;
                        }
                    }
                }
            });
        }

        @Override // com.anythink.core.api.ATCustomLoadListener
        public final void onAdDataLoaded() {
            com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.core.common.l.d.a.1
                @Override // java.lang.Runnable
                public final void run() {
                    synchronized (a.this) {
                        if (a.this.b != null && a.this.f6842a != null) {
                            a.this.b.q();
                        }
                    }
                }
            });
        }

        @Override // com.anythink.core.api.ATCustomLoadListener
        public final void onAdLoadError(final String str, final String str2) {
            com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.core.common.l.d.a.3
                @Override // java.lang.Runnable
                public final void run() {
                    synchronized (a.this) {
                        if (a.this.b != null && a.this.f6842a != null) {
                            com.anythink.core.common.l.a aVar = new com.anythink.core.common.l.a();
                            aVar.f6831a = 0;
                            aVar.b = ErrorCode.getErrorCode(ErrorCode.noADError, str, str2);
                            aVar.f6832c = SystemClock.elapsedRealtime() - d.this.k;
                            a.this.b.a(a.this.f6842a, aVar);
                            a.this.b = null;
                            a.this.f6842a = null;
                        }
                    }
                }
            });
        }
    }

    public d(ai aiVar, int i) {
        this.f6836c = aiVar;
        this.q = i;
        this.e = aiVar.t();
        this.r = this.e + BridgeUtil.UNDERLINE_STR + hashCode();
    }

    static /* synthetic */ Context a(d dVar) {
        Context context = dVar.o.b.get();
        Context context2 = context;
        if (!(context instanceof Activity)) {
            context2 = n.a().E();
        }
        if (ATSDK.isNetworkLogDebug()) {
            Log.d(f6835a, "requestContext = ".concat(String.valueOf(context2)));
        }
        return context2;
    }

    private void a(long j) {
        if (j == -1) {
            return;
        }
        this.n = p();
        n.a().a(this.n, j);
    }

    private void a(Context context, ai aiVar, ATBaseAdAdapter aTBaseAdAdapter) {
        if (com.anythink.core.c.a.am()) {
            p a2 = p.a(n.a().g());
            try {
                if (a2.c(aiVar.c()) || !aTBaseAdAdapter.setUserDataConsent(context, a2.c(), ATSDK.isEUTraffic(this.o.f6833a))) {
                    return;
                }
                a2.b(aiVar.c());
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private void a(ATBaseAdAdapter aTBaseAdAdapter) {
        this.g = aTBaseAdAdapter;
    }

    private void a(ATBaseAdAdapter aTBaseAdAdapter, ai aiVar) {
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(aTBaseAdAdapter, aiVar, k());
        if (TextUtils.equals(String.valueOf(this.o.e.X()), "2")) {
            n.a().a(anonymousClass1);
        } else {
            com.anythink.core.common.k.b.a.a().b(anonymousClass1);
        }
    }

    private static void a(ATBaseAdAdapter aTBaseAdAdapter, ai aiVar, com.anythink.core.common.e.e eVar) {
        if (aTBaseAdAdapter == null || aiVar == null) {
            return;
        }
        Map<String, Object> networkInfoMap = aTBaseAdAdapter.getNetworkInfoMap();
        m N = aiVar.N();
        if (N != null) {
            N.a(networkInfoMap);
            N.a(eVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ATBaseAdAdapter aTBaseAdAdapter, BaseAd... baseAdArr) {
        synchronized (this) {
            if (n()) {
                return;
            }
            ai unitGroupInfo = aTBaseAdAdapter.getUnitGroupInfo();
            long j = 0;
            if (unitGroupInfo.l() == 2) {
                j = unitGroupInfo.k();
            }
            this.d.d((SystemClock.elapsedRealtime() - this.k) + j);
            i();
            j();
            this.g = null;
            this.p = Boolean.TRUE;
            if (this.i) {
                this.d.r = 1;
            }
            com.anythink.core.common.e.e eVar = this.d;
            if (aTBaseAdAdapter != null && unitGroupInfo != null) {
                Map<String, Object> networkInfoMap = aTBaseAdAdapter.getNetworkInfoMap();
                m N = unitGroupInfo.N();
                if (N != null) {
                    N.a(networkInfoMap);
                    N.a(eVar);
                }
            }
            if (this.h != null) {
                this.h.a(this.r, aTBaseAdAdapter, baseAdArr);
            }
        }
    }

    static /* synthetic */ void a(d dVar, Context context, ai aiVar, ATBaseAdAdapter aTBaseAdAdapter) {
        if (com.anythink.core.c.a.am()) {
            p a2 = p.a(n.a().g());
            try {
                if (a2.c(aiVar.c()) || !aTBaseAdAdapter.setUserDataConsent(context, a2.c(), ATSDK.isEUTraffic(dVar.o.f6833a))) {
                    return;
                }
                a2.b(aiVar.c());
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    static /* synthetic */ Map b(d dVar) {
        Map<String, Object> map = dVar.o.f;
        HashMap hashMap = map;
        if (map == null) {
            hashMap = new HashMap(2);
        }
        return hashMap;
    }

    private void b(long j) {
        if (j == -1) {
            return;
        }
        this.m = p();
        n.a().a(this.m, j);
    }

    private void b(ATBaseAdAdapter aTBaseAdAdapter, ai aiVar) {
        synchronized (this) {
            if (n()) {
                return;
            }
            i();
            j();
            this.g = null;
            this.p = Boolean.TRUE;
            if (this.i) {
                this.d.r = 1;
            }
            if (this.h != null) {
                this.h.a(this.r, aTBaseAdAdapter, aiVar);
            }
        }
    }

    private void i() {
        if (this.m != null) {
            n.a().c(this.m);
            this.m = null;
        }
    }

    private void j() {
        if (this.n != null) {
            n.a().c(this.n);
            this.n = null;
        }
    }

    private Map<String, Object> k() {
        com.anythink.core.c.d dVar = this.o.e;
        String str = this.o.f6834c;
        if (dVar == null) {
            return new HashMap();
        }
        Map<String, Object> a2 = dVar.a(this.b, str, this.f6836c);
        int c2 = this.f6836c.c();
        int i = 0;
        if (c2 == 2) {
            com.anythink.core.c.a b = com.anythink.core.c.b.a(this.o.f6833a).b(n.a().p());
            if (b != null) {
                a2.put(g.k.p, Boolean.valueOf(b.j() == 1));
            }
        } else if (c2 == 6) {
            JSONObject a3 = com.anythink.core.common.k.g.a(this.o.f6833a, str, this.b, dVar.X(), this.f);
            if (dVar.av() == 1) {
                a2.put("tp_info", a3.toString());
            }
        }
        if (t.a(this.f6836c) && this.o.e.aq() == 1) {
            ae a4 = com.anythink.core.a.a.a(this.o.f6833a).a(this.b);
            if (a4 != null) {
                i = a4.f6623c;
            }
            a2.put(g.k.k, Integer.valueOf(i));
            synchronized (v.a().a(this.b)) {
                String a5 = v.a().a(this.b, this.f6836c.c());
                if (!TextUtils.isEmpty(a5)) {
                    a2.put(g.k.l, a5);
                }
            }
            return a2;
        }
        return a2;
    }

    private Map<String, Object> l() {
        Map<String, Object> map = this.o.f;
        HashMap hashMap = map;
        if (map == null) {
            hashMap = new HashMap(2);
        }
        return hashMap;
    }

    private Context m() {
        Context context = this.o.b.get();
        Context context2 = context;
        if (!(context instanceof Activity)) {
            context2 = n.a().E();
        }
        if (ATSDK.isNetworkLogDebug()) {
            Log.d(f6835a, "requestContext = ".concat(String.valueOf(context2)));
        }
        return context2;
    }

    private boolean n() {
        return !this.s || this.j || s();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        synchronized (this) {
            if (n()) {
                return;
            }
            this.i = true;
            new StringBuilder("network short timeout: ").append(this.e);
            if (this.h != null) {
                this.h.a(this.r, this.e);
            }
        }
    }

    private Runnable p() {
        return new Runnable() { // from class: com.anythink.core.common.l.d.2
            @Override // java.lang.Runnable
            public final void run() {
                com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.core.common.l.d.2.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        d.this.o();
                    }
                });
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        synchronized (this) {
            i();
            long elapsedRealtime = SystemClock.elapsedRealtime() - this.k;
            this.l = elapsedRealtime;
            if (this.d != null) {
                this.d.c(elapsedRealtime);
            }
        }
    }

    private void r() {
        this.g = null;
    }

    private boolean s() {
        return this.p != null;
    }

    private long t() {
        return this.k;
    }

    public final String a() {
        return this.r;
    }

    public final void a(final ATBaseAdAdapter aTBaseAdAdapter, com.anythink.core.common.l.a aVar) {
        synchronized (this) {
            if (n()) {
                return;
            }
            i();
            j();
            if (aTBaseAdAdapter != null) {
                n.a().a(new Runnable() { // from class: com.anythink.core.common.l.d.3
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            if (aTBaseAdAdapter != null) {
                                aTBaseAdAdapter.destory();
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                });
            }
            this.g = null;
            this.p = Boolean.FALSE;
            if (this.j) {
                this.d.r = 2;
            } else if (this.i) {
                this.d.r = 1;
            }
            if (!this.j) {
                long currentTimeMillis = System.currentTimeMillis();
                com.anythink.core.common.c.a().a(this.e, currentTimeMillis);
                com.anythink.core.common.c.a().a(this.e, currentTimeMillis, aVar.b);
            }
            aVar.d = this.d;
            aVar.e = this.f6836c;
            if (this.h != null) {
                this.h.a(this.r, aVar);
            }
        }
    }

    public final void a(b bVar) {
        this.h = bVar;
    }

    public final void a(c cVar) {
        this.o = cVar;
        this.b = cVar.d;
        this.d = cVar.h;
        this.f = cVar.g;
    }

    public final void b() {
        BaseAd baseAd;
        ATBaseAdAdapter aTBaseAdAdapter;
        boolean z;
        String str;
        this.s = true;
        com.anythink.core.common.e.b a2 = com.anythink.core.common.a.a().a(this.b, this.f6836c);
        if (a2 != null && a2.a()) {
            b bVar = this.h;
            if (bVar != null) {
                bVar.b(a2.e().getTrackingInfo());
            }
            b(a2.e(), this.f6836c);
            return;
        }
        m N = this.f6836c.N();
        if (N == null || !N.s) {
            baseAd = null;
            aTBaseAdAdapter = null;
            z = false;
        } else {
            com.anythink.core.b.c.a aVar = N.r;
            if (aVar != null) {
                aTBaseAdAdapter = aVar.a();
                baseAd = aVar.b();
            } else {
                baseAd = null;
                aTBaseAdAdapter = null;
            }
            N.r = null;
            z = true;
        }
        ATBaseAdAdapter aTBaseAdAdapter2 = aTBaseAdAdapter;
        if (aTBaseAdAdapter == null) {
            aTBaseAdAdapter2 = aTBaseAdAdapter;
            if (!z) {
                aTBaseAdAdapter2 = i.a(this.f6836c);
            }
        }
        if (aTBaseAdAdapter2 == null) {
            if (this.h != null) {
                com.anythink.core.common.l.a aVar2 = new com.anythink.core.common.l.a();
                aVar2.f6831a = 0;
                aVar2.f6832c = z ? this.f6836c.k() : 0L;
                String str2 = z ? ErrorCode.c2sBiddingCacheError : "2002";
                if (z) {
                    str = "";
                } else {
                    str = this.f6836c.h() + " does not exist!";
                }
                aVar2.b = ErrorCode.getErrorCode(str2, "", str);
                a((ATBaseAdAdapter) null, aVar2);
                return;
            }
            return;
        }
        try {
            com.anythink.core.common.k.d.a(this.f6836c.c(), aTBaseAdAdapter2.getNetworkSDKVersion());
        } catch (Throwable th) {
        }
        com.anythink.core.common.e.e a3 = s.a(aTBaseAdAdapter2, this.d, this.f6836c);
        this.d = a3;
        b bVar2 = this.h;
        if (bVar2 != null) {
            bVar2.a(a3);
        }
        long B = this.f6836c.B();
        if (B != -1) {
            this.m = p();
            n.a().a(this.m, B);
        }
        long q = this.f6836c.q();
        if (q != -1) {
            this.n = p();
            n.a().a(this.n, q);
        }
        this.k = SystemClock.elapsedRealtime();
        Context context = this.o.b.get();
        if (context != null && (context instanceof Activity)) {
            aTBaseAdAdapter2.refreshActivityContext((Activity) context);
        }
        if (!z) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(aTBaseAdAdapter2, this.f6836c, k());
            if (TextUtils.equals(String.valueOf(this.o.e.X()), "2")) {
                n.a().a(anonymousClass1);
                return;
            } else {
                com.anythink.core.common.k.b.a.a().b(anonymousClass1);
                return;
            }
        }
        b bVar3 = this.h;
        if (bVar3 != null) {
            bVar3.b(this.d);
        }
        if (baseAd != null) {
            a(aTBaseAdAdapter2, baseAd);
        } else {
            a(aTBaseAdAdapter2, new BaseAd[0]);
        }
    }

    public final void c() {
        synchronized (this) {
            if (n()) {
                return;
            }
            this.p = Boolean.FALSE;
            this.j = true;
            com.anythink.core.common.l.a aVar = new com.anythink.core.common.l.a();
            aVar.f6831a = 0;
            aVar.f6832c = SystemClock.elapsedRealtime() - this.k;
            aVar.b = ErrorCode.getErrorCode(ErrorCode.timeOutError, "", "");
            a(this.g, aVar);
        }
    }

    public final Boolean d() {
        return this.p;
    }

    public final boolean e() {
        return (s() && this.i) ? false : true;
    }

    public final int f() {
        return this.q;
    }

    public final boolean g() {
        return this.i;
    }

    public final ai h() {
        return this.f6836c;
    }
}
