package com.kwad.sdk.core.report;

import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.scene.URLPackage;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.service.ServiceProvider;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/report/q.class */
public class q extends f {
    public String Hq;
    public String Hr;
    public long Ht;
    public String NY;
    public long Oe;
    public long Of;
    public long Og;
    public transient SceneImpl Ow;
    public long Pa;
    public String SM;
    public int SO;
    public String Ts;
    public int Tt;
    public long Vl;
    public long aeM;
    public long aiF;
    public long aiG;
    public JSONObject aiH;
    public JSONObject aiI;
    public long aiJ;
    public long aiK;
    public long aiL;
    public long aiM;
    public long aiN;
    public long aiP;
    public URLPackage aiR;
    public String aiS;
    public JSONArray aiT;
    public JSONArray aiU;
    public a aiV;
    public int aiW;
    public int aiX;
    public int aiY;
    public int aiZ;
    public JSONArray ajA;
    public String ajB;
    public String ajC;
    public String ajD;
    public String ajE;
    public String ajF;
    public String ajH;
    public String ajI;
    public int ajJ;
    public long ajL;
    public long ajM;
    public int aja;
    public int ajb;
    public String ajc;
    public JSONObject ajd;
    public JSONArray aje;
    public int ajf;
    public int ajg;
    public int ajh;
    public JSONArray ajj;
    public boolean ajk;
    public String ajl;
    public long ajo;
    public int ajp;
    public String ajq;
    public long ajr;
    public long ajs;
    public long ajt;
    public long aju;
    public String ajv;
    public int ajw;
    public JSONArray ajx;
    public long ajy;
    public long ajz;
    public long blockDuration;
    public long clickTime;
    public int contentSourceType;
    public long creativeId;
    public long downloadDuration;
    public String entryPageSource;
    public int errorCode;
    public String errorMsg;
    public String failUrl;
    public long llsid;
    public transient AdTemplate mAdTemplate;
    public int pageType;
    public long photoId;
    public long posId;
    public long position;
    public String sessionId;
    public long timestamp;
    public String trace;
    public URLPackage urlPackage;
    public int adStyle = -1;
    public int contentType = 0;
    public int realShowType = 0;
    public long aiO = -1;
    public int aiQ = 0;
    public long aji = 0;
    public int ajm = 0;
    public int ajn = -1;
    public int ajG = 0;
    public int ajK = 3034000;
    public String sdkVersion = "3.3.40";

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/report/q$a.class */
    public static final class a extends com.kwad.sdk.core.response.kwai.a {
        public int ajN;
        public int ajO;

        public static a xd() {
            a aVar = new a();
            aVar.ajN = b.ajN;
            aVar.ajO = b.ajO;
            return aVar;
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/report/q$b.class */
    public static final class b {
        public static int ajN;
        public static int ajO;
    }

    public q(long j) {
        this.SM = ServiceProvider.get(com.kwad.sdk.service.kwai.e.class) == null ? "" : ((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).getApiVersion();
        this.SO = 1;
        this.aiG = j;
    }

    public q(long j, AdTemplate adTemplate) {
        this.SM = ServiceProvider.get(com.kwad.sdk.service.kwai.e.class) == null ? "" : ((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).getApiVersion();
        this.SO = 1;
        this.aiG = j;
        this.mAdTemplate = adTemplate;
    }

    public q(long j, AdTemplate adTemplate, String str) {
        this.SM = ServiceProvider.get(com.kwad.sdk.service.kwai.e.class) == null ? "" : ((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).getApiVersion();
        this.SO = 1;
        this.aiG = j;
        this.mAdTemplate = adTemplate;
        this.Ts = str;
    }

    public q(String str) {
        this.SM = ServiceProvider.get(com.kwad.sdk.service.kwai.e.class) == null ? "" : ((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).getApiVersion();
        this.SO = 1;
        try {
            parseJson(new JSONObject(str));
        } catch (JSONException e) {
            com.kwad.sdk.core.d.b.printStackTrace(e);
        }
    }

    public q(JSONObject jSONObject) {
        this.SM = ServiceProvider.get(com.kwad.sdk.service.kwai.e.class) == null ? "" : ((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).getApiVersion();
        this.SO = 1;
        parseJson(jSONObject);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:51:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void aG(com.kwad.sdk.core.response.model.AdTemplate r6) {
        /*
            Method dump skipped, instructions count: 423
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.report.q.aG(com.kwad.sdk.core.response.model.AdTemplate):void");
    }

    @Override // com.kwad.sdk.core.report.f, com.kwad.sdk.core.response.kwai.a
    public void afterParseJson(JSONObject jSONObject) {
        super.afterParseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        this.aiX = 3;
        this.adStyle = jSONObject.optInt("adStyle", -1);
        this.ajb = jSONObject.optInt(com.anythink.expressad.foundation.d.l.d);
        this.aja = jSONObject.optInt("state");
        this.aji = jSONObject.optLong("timeSpend");
        this.ajy = jSONObject.optLong("loadingDuration");
        this.ajz = jSONObject.optLong("loadingDurationLimt");
        this.ajn = jSONObject.optInt("playerTypeInfo", -1);
        if (jSONObject.has("actionId")) {
            this.actionId = jSONObject.optString("actionId");
        }
    }

    @Override // com.kwad.sdk.core.report.f, com.kwad.sdk.core.response.kwai.a
    public void afterToJson(JSONObject jSONObject) {
        super.afterToJson(jSONObject);
        com.kwad.sdk.utils.t.putValue(jSONObject, "actionId", this.actionId);
        int i = this.adStyle;
        if (i > 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adStyle", i);
        }
        int i2 = this.ajb;
        if (i2 > 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, com.anythink.expressad.foundation.d.l.d, i2);
        }
        int i3 = this.aja;
        if (i3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "state", i3);
        }
        long j = this.aji;
        if (j > 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "timeSpend", j);
        }
        long j2 = this.ajy;
        if (j2 > 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "loadingDuration", j2);
        }
        long j3 = this.ajz;
        if (j3 > 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "loadingDurationLimt", j3);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "playerTypeInfo", this.ajn);
    }

    public final q xb() {
        aG(this.mAdTemplate);
        return this;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public final void xc() {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
}
