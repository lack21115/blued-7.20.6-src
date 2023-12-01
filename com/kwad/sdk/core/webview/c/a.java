package com.kwad.sdk.core.webview.c;

import android.content.Context;
import com.kwad.sdk.components.c;
import com.kwad.sdk.components.f;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.kwai.e;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.au;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.k;
import com.kwad.sdk.utils.y;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/webview/c/a.class */
public final class a implements com.kwad.sdk.core.webview.b.a {

    /* renamed from: com.kwad.sdk.core.webview.c.a$a  reason: collision with other inner class name */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/webview/c/a$a.class */
    public static final class C0569a extends com.kwad.sdk.core.response.kwai.a {
        public String SK;
        public int SL;
        public String SM;
        public int SN;
        public int SO;
        public String SP;
        public String SQ;
        public String SR;
        public int SS;
        public String ST;
        public int SU;
        public String SV;
        public String SW;
        public int SX;
        public int SY;
        public int SZ;
        public int Ta;
        public String adV;
        public String adW;
        public String ajB;
        public String alB;
        public String ali;
        public String aln;
        public String alo;
        public String appId;
        public String appName;
        public String appVersion;
        public String aqh;
        public String aqi;
        public boolean aqj;
        public String aqk;
        public String model;

        public static C0569a zf() {
            C0569a c0569a = new C0569a();
            c0569a.SK = "3.3.40";
            c0569a.SL = 3034000;
            c0569a.ajB = "5.0.1";
            c0569a.aqk = "1.1";
            c0569a.SM = ((e) ServiceProvider.get(e.class)).getApiVersion();
            c0569a.SN = ((e) ServiceProvider.get(e.class)).getApiVersionCode();
            c0569a.SO = 1;
            Context context = ((e) ServiceProvider.get(e.class)).getContext();
            c0569a.appVersion = k.bH(context);
            c0569a.appName = ((e) ServiceProvider.get(e.class)).getAppName();
            c0569a.appId = ((e) ServiceProvider.get(e.class)).getAppId();
            c0569a.aqh = "";
            c0569a.alo = y.Dw();
            f fVar = (f) c.f(f.class);
            if (fVar != null) {
                c0569a.aln = fVar.nv();
            }
            c0569a.SP = String.valueOf(ag.ca(context));
            c0569a.SQ = bd.EO();
            c0569a.model = bd.EF();
            c0569a.SR = bd.EH();
            c0569a.SS = 1;
            c0569a.ST = bd.getOsVersion();
            c0569a.SU = bd.ER();
            c0569a.SV = bd.getLanguage();
            c0569a.SW = bd.getLocale();
            c0569a.aqj = ((e) ServiceProvider.get(e.class)).getIsExternal();
            c0569a.aqi = au.getDeviceId();
            c0569a.SX = bd.getScreenWidth(context);
            c0569a.SY = bd.getScreenHeight(context);
            c0569a.adV = au.cl(context);
            c0569a.adW = au.getOaid();
            c0569a.ali = au.cm(context);
            c0569a.alB = au.cn(context);
            c0569a.SZ = com.kwad.sdk.c.kwai.a.getStatusBarHeight(context);
            c0569a.Ta = com.kwad.sdk.c.kwai.a.a(context, 50.0f);
            return c0569a;
        }
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final String getKey() {
        return "getDeviceInfo";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void handleJsCall(String str, com.kwad.sdk.core.webview.b.c cVar) {
        cVar.a(C0569a.zf());
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
    }
}
