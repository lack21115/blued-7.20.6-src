package com.anythink.splashad.a;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.core.api.ATCustomLoadListener;
import com.anythink.core.api.ATMediationRequestInfo;
import com.anythink.core.api.AdError;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.ErrorCode;
import com.anythink.core.common.b.g;
import com.anythink.core.common.b.n;
import com.anythink.core.common.k.h;
import com.anythink.core.common.k.i;
import com.anythink.core.common.v;
import com.anythink.splashad.unitgroup.api.CustomSplashAdapter;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/splashad/a/d.class */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    boolean f6357a;
    b b;

    /* renamed from: c  reason: collision with root package name */
    long f6358c;
    com.anythink.core.common.e.b d;
    String e;
    String f;
    String g;
    int h;
    String i;
    String j;
    int k = -1;
    Map<String, Object> l;
    private Context m;
    private boolean n;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.anythink.splashad.a.d$1  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/splashad/a/d$1.class */
    public final class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (d.this.b != null) {
                d.this.b.onAdLoaded();
            }
            d.this.b = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.anythink.splashad.a.d$2  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/splashad/a/d$2.class */
    public final class AnonymousClass2 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CustomSplashAdapter f6360a;
        final /* synthetic */ AdError b;

        AnonymousClass2(CustomSplashAdapter customSplashAdapter, AdError adError) {
            this.f6360a = customSplashAdapter;
            this.b = adError;
        }

        @Override // java.lang.Runnable
        public final void run() {
            CustomSplashAdapter customSplashAdapter = this.f6360a;
            if (customSplashAdapter != null) {
                customSplashAdapter.destory();
            }
            if (d.this.b != null) {
                d.this.b.onAdLoadFail(this.b);
            }
            d.this.b = null;
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/splashad/a/d$a.class */
    final class a implements ATCustomLoadListener {

        /* renamed from: a  reason: collision with root package name */
        CustomSplashAdapter f6362a;

        public a(CustomSplashAdapter customSplashAdapter) {
            this.f6362a = customSplashAdapter;
        }

        public final void onAdCacheLoaded(BaseAd... baseAdArr) {
            d.this.a(this.f6362a, baseAdArr);
        }

        public final void onAdDataLoaded() {
        }

        public final void onAdLoadError(String str, String str2) {
            d.this.a(this.f6362a, ErrorCode.getErrorCode("4001", str, str2));
        }
    }

    public d(Context context) {
        this.m = context.getApplicationContext();
    }

    private void a(ATMediationRequestInfo aTMediationRequestInfo) {
        this.g = aTMediationRequestInfo.getAdSourceId();
        this.h = aTMediationRequestInfo.getNetworkFirmId();
        this.i = aTMediationRequestInfo.getClassName();
        Map<String, Object> requestParamMap = aTMediationRequestInfo.getRequestParamMap();
        this.l = requestParamMap;
        this.k = 4;
        requestParamMap.put("ad_type", 4);
    }

    private void a(String str) {
        this.g = "0";
        this.l = new HashMap(1);
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.g = jSONObject.optString("unit_id");
            this.h = jSONObject.optInt("nw_firm_id");
            this.i = jSONObject.optString("adapter_class");
            this.j = jSONObject.optString("content");
            this.k = jSONObject.optInt("ad_type", -1);
            Map<String, Object> c2 = h.c(this.j);
            this.l = c2;
            c2.put("ad_type", Integer.valueOf(this.k));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void b() {
        n.a().a(new AnonymousClass1());
    }

    private void b(CustomSplashAdapter customSplashAdapter, AdError adError) {
        n.a().a(new AnonymousClass2(customSplashAdapter, adError));
    }

    private void c() {
        this.b = null;
    }

    private void d() {
        this.d = null;
    }

    private void e() {
        com.anythink.core.common.e.e eVar = new com.anythink.core.common.e.e();
        eVar.x(this.f);
        eVar.y(this.e);
        eVar.z("4");
        eVar.w("0");
        eVar.a(true);
        com.anythink.core.common.j.c.a(eVar, ErrorCode.getErrorCode("2001", "", "Splash FetchAd Timeout."));
    }

    private com.anythink.core.common.e.b f() {
        com.anythink.core.common.e.b bVar = this.d;
        if (bVar == null || bVar.d() > 0) {
            return null;
        }
        return this.d;
    }

    private com.anythink.core.common.e.b g() {
        return this.d;
    }

    public final void a(Context context, String str, String str2, ATMediationRequestInfo aTMediationRequestInfo, String str3, b bVar, int i) {
        this.b = bVar;
        this.e = str2;
        this.f = str;
        if (!TextUtils.isEmpty(str3)) {
            this.g = "0";
            this.l = new HashMap(1);
            try {
                JSONObject jSONObject = new JSONObject(str3);
                this.g = jSONObject.optString("unit_id");
                this.h = jSONObject.optInt("nw_firm_id");
                this.i = jSONObject.optString("adapter_class");
                this.j = jSONObject.optString("content");
                this.k = jSONObject.optInt("ad_type", -1);
                Map<String, Object> c2 = h.c(this.j);
                this.l = c2;
                c2.put("ad_type", Integer.valueOf(this.k));
            } catch (Throwable th) {
                th.printStackTrace();
            }
        } else if (aTMediationRequestInfo != null) {
            this.g = aTMediationRequestInfo.getAdSourceId();
            this.h = aTMediationRequestInfo.getNetworkFirmId();
            this.i = aTMediationRequestInfo.getClassName();
            Map<String, Object> requestParamMap = aTMediationRequestInfo.getRequestParamMap();
            this.l = requestParamMap;
            this.k = 4;
            requestParamMap.put("ad_type", 4);
        }
        n.a();
        n.n(this.g);
        com.anythink.core.common.e.e eVar = new com.anythink.core.common.e.e();
        eVar.x(str);
        eVar.y(str2);
        eVar.u(this.h);
        eVar.z("4");
        eVar.l(TextUtils.isEmpty(this.g) ? "0" : this.g);
        eVar.w("0");
        eVar.a(true);
        if (!TextUtils.isEmpty(this.j)) {
            eVar.n(this.j);
        }
        if (!TextUtils.isEmpty(str3)) {
            eVar.c(8);
        }
        eVar.w(this.k);
        try {
            ATBaseAdAdapter a2 = i.a(this.i);
            if (!(a2 instanceof CustomSplashAdapter)) {
                throw new Exception("The class isn't instanceof CustomSplashAdapter");
            }
            ((CustomSplashAdapter) a2).setFetchAdTimeout(i);
            this.n = true;
            this.f6357a = false;
            this.f6358c = SystemClock.elapsedRealtime();
            try {
                eVar.v(a2.getNetworkName());
                eVar.u = a2.getNetworkSDKVersion();
                eVar.q = 2;
            } catch (Throwable th2) {
            }
            a2.setTrackingInfo(eVar);
            com.anythink.core.common.k.g.a(eVar, g.i.a, g.i.h, "");
            com.anythink.core.common.j.a.a(this.m).a(10, eVar);
            com.anythink.core.common.j.a.a(this.m).a(1, eVar);
            a2.internalLoad(context, this.l, v.a().c(str), new a((CustomSplashAdapter) a2));
        } catch (Throwable th3) {
            if (this.b != null) {
                this.b.onAdLoadFail(ErrorCode.getErrorCode("2002", "", th3.getMessage()));
            }
            this.b = null;
        }
    }

    public final void a(CustomSplashAdapter customSplashAdapter, AdError adError) {
        if (this.f6357a) {
            return;
        }
        if (customSplashAdapter != null) {
            com.anythink.core.common.k.g.a(customSplashAdapter.getTrackingInfo(), g.i.b, g.i.g, adError.printStackTrace());
        }
        this.f6357a = true;
        this.n = false;
        n.a().a(new AnonymousClass2(customSplashAdapter, adError));
    }

    public final void a(CustomSplashAdapter customSplashAdapter, BaseAd... baseAdArr) {
        if (this.f6357a) {
            return;
        }
        if (customSplashAdapter != null) {
            customSplashAdapter.getTrackingInfo().d(SystemClock.elapsedRealtime() - this.f6358c);
            customSplashAdapter.getTrackingInfo().g(customSplashAdapter.getNetworkPlacementId());
            com.anythink.core.common.k.g.a(customSplashAdapter.getTrackingInfo(), g.i.b, g.i.f, "");
            com.anythink.core.common.j.a.a(this.m).a(12, customSplashAdapter.getTrackingInfo());
            com.anythink.core.common.j.a.a(this.m).a(2, customSplashAdapter.getTrackingInfo());
            com.anythink.core.common.e.b bVar = new com.anythink.core.common.e.b();
            bVar.b(0);
            bVar.a(customSplashAdapter);
            bVar.c(System.currentTimeMillis());
            bVar.b(600000L);
            bVar.a(customSplashAdapter.getTrackingInfo().X());
            bVar.a(600000L);
            if (baseAdArr != null && baseAdArr.length > 0) {
                baseAdArr[0].setTrackingInfo(customSplashAdapter.getTrackingInfo().N());
                bVar.a(baseAdArr[0]);
            }
            this.d = bVar;
        }
        this.f6357a = true;
        this.n = false;
        n.a().a(new AnonymousClass1());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean a() {
        return this.n;
    }
}
