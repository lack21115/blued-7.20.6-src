package com.kwad.sdk.g;

import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.report.KSLoggerReporter;
import com.kwad.sdk.core.report.o;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.aw;
import com.kwad.sdk.utils.g;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;
import com.kwai.adclient.kscommerciallogger.model.SubBusinessType;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/g/b.class */
public class b {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/g/b$a.class */
    public static class a extends com.kwad.sdk.core.response.kwai.a {
        public int auj;
        public String auk;
        public String sdkVersion;
    }

    /* renamed from: com.kwad.sdk.g.b$b  reason: collision with other inner class name */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/g/b$b.class */
    public static class C0405b extends com.kwad.sdk.core.response.kwai.a {
        public int aul;
        public String aum;
        public String aun;
        public String auo;
        public String aup;
        public String auq;
    }

    public static void Bd() {
        g.execute(new aw() { // from class: com.kwad.sdk.g.b.1
            @Override // com.kwad.sdk.utils.aw
            public final void doTask() {
                b.Be();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void Be() {
        a a2;
        JSONObject jSONObject = (JSONObject) d.uu().getAppConfigData(null, new com.kwad.sdk.e.b<JSONObject, JSONObject>() { // from class: com.kwad.sdk.g.b.2
            private static JSONObject D(JSONObject jSONObject2) {
                return jSONObject2.optJSONObject("sdkTTPerfMonitor");
            }

            @Override // com.kwad.sdk.e.b
            public final /* synthetic */ JSONObject apply(JSONObject jSONObject2) {
                return D(jSONObject2);
            }
        });
        if (jSONObject == null) {
            return;
        }
        C0405b c0405b = new C0405b();
        try {
            c0405b.parseJson(jSONObject);
            if (c0405b.aul == 1 && (a2 = a(ServiceProvider.getContext().getClassLoader(), c0405b)) != null) {
                KSLoggerReporter.a(new o.a().cE(ILoggerReporter.Category.APM_LOG).b(BusinessType.OTHER).a(SubBusinessType.OTHER).cF("ad_sdk_tt_sdk_info").A(a2.toJson()).xa());
            }
        } catch (Throwable th) {
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    private static a a(ClassLoader classLoader, C0405b c0405b) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
}
