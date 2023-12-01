package com.kwad.components.core.webview.jshandler;

import android.content.Context;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bd;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/webview/jshandler/x.class */
public final class x implements com.kwad.sdk.core.webview.b.a {

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/webview/jshandler/x$a.class */
    public static final class a extends com.kwad.sdk.core.response.kwai.a {
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
        public String appId;
        public String appName;
        public String appVersion;
        public String model;

        public static a qW() {
            a aVar = new a();
            aVar.SK = "3.3.40";
            aVar.SL = 3034000;
            aVar.SM = ((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).getApiVersion();
            aVar.SN = ((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).getApiVersionCode();
            aVar.SO = 1;
            Context context = ((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).getContext();
            aVar.appVersion = com.kwad.sdk.utils.k.bH(context);
            aVar.appName = ((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).getAppName();
            aVar.appId = ((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).getAppId();
            aVar.SP = String.valueOf(com.kwad.sdk.utils.ag.ca(context));
            aVar.SQ = bd.EO();
            aVar.model = bd.EF();
            aVar.SR = bd.EH();
            aVar.SS = 1;
            aVar.ST = bd.getOsVersion();
            aVar.SU = bd.ER();
            aVar.SV = bd.getLanguage();
            aVar.SW = bd.getLocale();
            aVar.SX = bd.getScreenWidth(context);
            aVar.SY = bd.getScreenHeight(context);
            aVar.SZ = com.kwad.sdk.c.kwai.a.getStatusBarHeight(context);
            aVar.Ta = com.kwad.sdk.c.kwai.a.a(context, 50.0f);
            return aVar;
        }
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final String getKey() {
        return "getKsPlayableDeviceInfo";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void handleJsCall(String str, com.kwad.sdk.core.webview.b.c cVar) {
        cVar.a(a.qW());
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
    }
}
