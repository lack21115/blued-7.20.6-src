package com.kwad.sdk.core.report;

import android.text.TextUtils;
import com.blued.das.live.LiveProtos;
import com.huawei.hms.ads.nativead.DetailedCreativeType;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.kwad.sdk.core.report.y;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.ai;
import com.kwad.sdk.utils.ak;
import java.util.concurrent.ExecutorService;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/report/a.class */
public final class a {
    private static ExecutorService ahP = GlobalThreadPools.xQ();
    public static JSONObject ahQ;
    public static boolean ahR;

    /* renamed from: com.kwad.sdk.core.report.a$a  reason: collision with other inner class name */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/report/a$a.class */
    public static class C0565a extends com.kwad.sdk.core.response.kwai.a {
        public int code;
        public String msg;

        public C0565a(int i, String str) {
            this.code = i;
            this.msg = str;
        }
    }

    private static boolean C(AdInfo adInfo) {
        com.kwad.sdk.service.kwai.e eVar = (com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class);
        if (eVar == null) {
            return false;
        }
        String aq = com.kwad.sdk.core.response.a.a.aq(adInfo);
        if (TextUtils.isEmpty(aq)) {
            return false;
        }
        return ak.ah(eVar.getContext(), aq);
    }

    public static void a(AdTemplate adTemplate, int i, long j, int i2, long j2, JSONObject jSONObject) {
        y.b bVar = new y.b();
        bVar.uV = j;
        bVar.akI = i2;
        bVar.akh = i;
        y.a aVar = new y.a();
        aVar.duration = j2;
        bVar.akG = aVar;
        b(adTemplate, 3, bVar, (JSONObject) null);
    }

    @Deprecated
    public static void a(AdTemplate adTemplate, int i, long j, JSONObject jSONObject) {
        y.b bVar = new y.b();
        bVar.akh = i;
        y.a aVar = new y.a();
        aVar.duration = j;
        bVar.akG = aVar;
        b(adTemplate, 3, bVar, jSONObject);
    }

    public static void a(AdTemplate adTemplate, int i, AdExposureFailedReason adExposureFailedReason) {
        if (i == 0 || i == 1 || i == 2 || i == 3 || i == 4) {
            y.b bVar = new y.b();
            bVar.akl = i;
            if (adExposureFailedReason != null && i == 2) {
                bVar.akm = adExposureFailedReason.winEcpm;
                try {
                    bVar.adnType = adExposureFailedReason.adnType;
                    if (adExposureFailedReason.adnType == 2) {
                        bVar.adnName = adExposureFailedReason.adnName;
                    }
                } catch (Throwable th) {
                }
            }
            b(adTemplate, 809, bVar, (JSONObject) null);
        }
    }

    public static void a(AdTemplate adTemplate, int i, y.b bVar, JSONObject jSONObject) {
        bVar.aki = i;
        b(adTemplate, 140, bVar, (JSONObject) null);
    }

    @Deprecated
    public static void a(AdTemplate adTemplate, int i, ac.a aVar) {
        y.b bVar = new y.b();
        bVar.jU = i;
        if (aVar != null) {
            bVar.jW = aVar;
        }
        a(adTemplate, bVar, (JSONObject) null);
    }

    @Deprecated
    public static void a(AdTemplate adTemplate, int i, ac.a aVar, JSONObject jSONObject) {
        y.b bVar = new y.b();
        bVar.jU = i;
        bVar.jW = aVar;
        a(adTemplate, bVar, jSONObject);
    }

    public static void a(AdTemplate adTemplate, int i, JSONObject jSONObject) {
        y.b bVar = new y.b();
        bVar.akf = i;
        b(adTemplate, 402, bVar, jSONObject);
    }

    public static void a(AdTemplate adTemplate, int i, JSONObject jSONObject, String str) {
        y.b bVar = new y.b();
        bVar.Ts = str;
        b(adTemplate, i, bVar, jSONObject);
    }

    public static void a(AdTemplate adTemplate, long j, JSONObject jSONObject) {
        y.b bVar = new y.b();
        y.a aVar = new y.a();
        if (j != -1) {
            aVar.duration = j;
            bVar.akG = aVar;
        }
        b(adTemplate, 934, bVar, (JSONObject) null);
    }

    public static void a(AdTemplate adTemplate, C0565a c0565a) {
        y.b bVar = new y.b();
        bVar.aku = c0565a.toJson().toString();
        b(adTemplate, 40, bVar, (JSONObject) null);
    }

    public static void a(AdTemplate adTemplate, i iVar) {
        b(adTemplate, 141, iVar != null ? iVar.wY() : null, (JSONObject) null);
    }

    public static void a(AdTemplate adTemplate, i iVar, JSONObject jSONObject) {
        a(adTemplate, iVar != null ? iVar.wY() : null, jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(AdTemplate adTemplate, y.b bVar) {
        AdInfo cb = com.kwad.sdk.core.response.a.d.cb(adTemplate);
        String str = cb.downloadFilePath;
        if (str == null) {
            return;
        }
        String aq = com.kwad.sdk.core.response.a.a.aq(cb);
        String eI = ak.eI(str);
        if (eI == null || TextUtils.isEmpty(eI) || eI.equals(aq)) {
            return;
        }
        bVar.akx = eI;
        bVar.akw = aq;
        cb.adBaseInfo.appPackageName = eI;
    }

    public static void a(AdTemplate adTemplate, y.b bVar, JSONObject jSONObject) {
        if (bVar != null && adTemplate.fromCache) {
            bVar.a(j.aE(adTemplate));
        }
        b(adTemplate, 2, bVar, jSONObject);
    }

    public static void a(AdTemplate adTemplate, String str, int i) {
        y.b bVar = new y.b();
        bVar.akp = i;
        if (!str.equals("")) {
            bVar.akq = str;
        }
        b(adTemplate, 803, bVar, (JSONObject) null);
    }

    public static void a(AdTemplate adTemplate, String str, int i, y.b bVar) {
        y.b bVar2 = bVar;
        if (bVar == null) {
            bVar2 = new y.b();
        }
        bVar2.akp = i;
        if (!str.equals("")) {
            bVar2.akq = str;
        }
        b(adTemplate, 320, bVar2, (JSONObject) null);
    }

    public static void aA(AdTemplate adTemplate) {
        r(adTemplate, 721);
    }

    public static void aB(AdTemplate adTemplate) {
        i iVar = new i();
        y.a aVar = new y.a();
        aVar.aka = 1;
        iVar.a(aVar);
        b(adTemplate, 804, iVar.wY(), (JSONObject) null);
    }

    public static void aC(AdTemplate adTemplate) {
        i iVar = new i();
        y.a aVar = new y.a();
        aVar.aka = 2;
        iVar.a(aVar);
        b(adTemplate, 804, iVar.wY(), (JSONObject) null);
    }

    private static boolean aD(AdTemplate adTemplate) {
        if (com.kwad.sdk.core.response.a.d.bT(adTemplate)) {
            return true;
        }
        com.kwad.sdk.service.kwai.e eVar = (com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class);
        return eVar != null && eVar.X(adTemplate);
    }

    public static void ao(AdTemplate adTemplate) {
        r(adTemplate, 4);
    }

    public static void ap(AdTemplate adTemplate) {
        y.b bVar = new y.b();
        bVar.downloadSource = adTemplate.downloadSource;
        b(adTemplate, 30, bVar, (JSONObject) null);
    }

    public static void aq(final AdTemplate adTemplate) {
        ahP.submit(new Runnable() { // from class: com.kwad.sdk.core.report.a.2
            @Override // java.lang.Runnable
            public final void run() {
                AdInfo cb = com.kwad.sdk.core.response.a.d.cb(AdTemplate.this);
                int ag = ak.ag(cb.downloadId, com.kwad.sdk.core.response.a.a.aq(cb));
                y.b bVar = new y.b();
                bVar.downloadSource = AdTemplate.this.downloadSource;
                bVar.aks = ag;
                bVar.akt = AdTemplate.this.installFrom;
                a.b(AdTemplate.this, 32, bVar, (JSONObject) null);
            }
        });
    }

    public static void ar(AdTemplate adTemplate) {
        r(adTemplate, 36);
    }

    public static void as(AdTemplate adTemplate) {
        r(adTemplate, 38);
    }

    public static void at(AdTemplate adTemplate) {
        r(adTemplate, 41);
    }

    public static void au(AdTemplate adTemplate) {
        y.b bVar = new y.b();
        bVar.akw = com.kwad.sdk.core.response.a.a.aq(com.kwad.sdk.core.response.a.d.cb(adTemplate));
        b(adTemplate, 768, bVar, new JSONObject());
    }

    public static void av(AdTemplate adTemplate) {
        h(adTemplate, null);
    }

    public static void aw(AdTemplate adTemplate) {
        r(adTemplate, 58);
    }

    public static void ax(AdTemplate adTemplate) {
        r(adTemplate, DetailedCreativeType.LONG_TEXT);
    }

    public static void ay(AdTemplate adTemplate) {
        y.b bVar = new y.b();
        bVar.akE = com.kwad.sdk.core.response.a.a.bo(com.kwad.sdk.core.response.a.d.cb(adTemplate));
        com.kwad.sdk.core.d.b.d("AdReportManager", "reportDownloadCardClose downloadStatus=" + bVar.akE);
        b(adTemplate, (int) LiveProtos.Event.LIVE_SHOW_PAGE_USER_PAGE_SHOW_VALUE, bVar, (JSONObject) null);
    }

    public static void az(AdTemplate adTemplate) {
        r(adTemplate, 722);
    }

    public static void b(final AdTemplate adTemplate, final int i, y.b bVar, final JSONObject jSONObject) {
        if (adTemplate == null || !aD(adTemplate)) {
            return;
        }
        y.b bVar2 = bVar;
        if (bVar == null) {
            bVar2 = new y.b();
        }
        bVar2.akF = com.kwad.sdk.core.response.a.a.aL(com.kwad.sdk.core.response.a.d.cb(adTemplate));
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        com.kwad.sdk.core.d.b.d("AdReportManager", sb.toString());
        bVar2.adxResult = adTemplate.adxResult;
        if (i == 2 && ahR) {
            if (bVar2.akG == null) {
                bVar2.akG = new y.a();
            }
            bVar2.akG.akd = ahQ;
        }
        final y.b bVar3 = bVar2;
        new x() { // from class: com.kwad.sdk.core.report.a.3
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.a
            /* renamed from: wN */
            public y createRequest() {
                return new y(AdTemplate.this, i, bVar3, jSONObject);
            }
        }.fetch();
    }

    public static void b(AdTemplate adTemplate, int i, JSONObject jSONObject) {
        y.b bVar = new y.b();
        bVar.aki = i;
        b(adTemplate, 140, bVar, jSONObject);
    }

    public static void b(AdTemplate adTemplate, i iVar, JSONObject jSONObject) {
        b(adTemplate, 3, iVar != null ? iVar.wY() : null, jSONObject);
    }

    public static void b(AdTemplate adTemplate, y.b bVar) {
        b(adTemplate, 50, bVar, (JSONObject) null);
    }

    public static void b(AdTemplate adTemplate, String str, int i, y.b bVar) {
        y.b bVar2 = bVar;
        if (bVar == null) {
            bVar2 = new y.b();
        }
        bVar2.akp = i;
        if (!str.equals("")) {
            bVar2.akq = str;
        }
        b(adTemplate, 321, bVar2, (JSONObject) null);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public static void b(AdTemplate adTemplate, JSONObject jSONObject, i iVar) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    public static void c(AdTemplate adTemplate, int i, int i2) {
        y.b bVar = new y.b();
        bVar.akC = i;
        bVar.akR = i2;
        b(adTemplate, 323, bVar, (JSONObject) null);
    }

    public static void c(AdTemplate adTemplate, int i, JSONObject jSONObject) {
        y.b bVar = new y.b();
        bVar.akw = com.kwad.sdk.core.response.a.a.aq(com.kwad.sdk.core.response.a.d.cb(adTemplate));
        bVar.aki = 93;
        b(adTemplate, 140, bVar, (JSONObject) null);
    }

    public static void c(AdTemplate adTemplate, y.b bVar) {
        b(adTemplate, 51, bVar, (JSONObject) null);
    }

    public static void c(AdTemplate adTemplate, JSONObject jSONObject) {
        y.b bVar = new y.b();
        bVar.downloadSource = adTemplate.downloadSource;
        b(adTemplate, 33, bVar, jSONObject);
    }

    public static void c(AdTemplate adTemplate, JSONObject jSONObject, i iVar) {
        b(adTemplate, 451, iVar != null ? iVar.wY() : null, (JSONObject) null);
    }

    public static void d(AdTemplate adTemplate, int i, int i2) {
        y.b bVar = new y.b();
        bVar.aki = 69;
        bVar.aky = i;
        bVar.akz = i2;
        b(adTemplate, 501, bVar, (JSONObject) null);
    }

    private static void d(AdTemplate adTemplate, int i, JSONObject jSONObject) {
        b(adTemplate, i, (y.b) null, jSONObject);
    }

    public static void d(AdTemplate adTemplate, y.b bVar) {
        b(adTemplate, 52, bVar, (JSONObject) null);
    }

    public static void d(AdTemplate adTemplate, JSONObject jSONObject) {
        y.b bVar = new y.b();
        bVar.downloadSource = adTemplate.downloadSource;
        b(adTemplate, 34, bVar, jSONObject);
    }

    public static void d(AdTemplate adTemplate, JSONObject jSONObject, i iVar) {
        b(adTemplate, 140, iVar != null ? iVar.wY() : null, jSONObject);
    }

    public static void e(AdTemplate adTemplate, y.b bVar) {
        b(adTemplate, 59, bVar, (JSONObject) null);
    }

    public static void e(final AdTemplate adTemplate, final JSONObject jSONObject) {
        ahP.submit(new Runnable() { // from class: com.kwad.sdk.core.report.a.1
            @Override // java.lang.Runnable
            public final void run() {
                y.b bVar = new y.b();
                bVar.downloadSource = AdTemplate.this.downloadSource;
                a.a(AdTemplate.this, bVar);
                a.b(AdTemplate.this, 31, bVar, jSONObject);
                AdInfo cb = com.kwad.sdk.core.response.a.d.cb(AdTemplate.this);
                ak.af(cb.downloadFilePath, cb.downloadId);
            }
        });
    }

    public static void f(AdTemplate adTemplate, JSONObject jSONObject) {
        y.b bVar = new y.b();
        bVar.downloadSource = adTemplate.downloadSource;
        b(adTemplate, 35, bVar, jSONObject);
    }

    public static void g(AdTemplate adTemplate, JSONObject jSONObject) {
        d(adTemplate, 399, jSONObject);
    }

    public static void h(AdTemplate adTemplate) {
        g(adTemplate, null);
    }

    public static void h(AdTemplate adTemplate, JSONObject jSONObject) {
        d(adTemplate, 400, jSONObject);
    }

    public static void i(AdTemplate adTemplate, int i) {
        y.b bVar = new y.b();
        bVar.akN = i;
        b(adTemplate, 37, bVar, (JSONObject) null);
    }

    public static void i(AdTemplate adTemplate, long j) {
        y.b bVar = new y.b();
        bVar.akk = j;
        b(adTemplate, 600, bVar, (JSONObject) null);
    }

    public static void i(AdTemplate adTemplate, JSONObject jSONObject) {
        d(adTemplate, 501, jSONObject);
    }

    public static void j(AdTemplate adTemplate, int i) {
        y.b bVar = new y.b();
        bVar.ako = i;
        b(adTemplate, 923, bVar, (JSONObject) null);
    }

    public static void j(AdTemplate adTemplate, long j) {
        y.b bVar = new y.b();
        bVar.akB = j;
        b(adTemplate, 401, bVar, (JSONObject) null);
    }

    public static void j(AdTemplate adTemplate, JSONObject jSONObject) {
        d(adTemplate, 450, jSONObject);
    }

    public static void k(AdTemplate adTemplate, int i) {
        y.b bVar = new y.b();
        bVar.akr = i;
        b(adTemplate, "wxsmallapp", 1, bVar);
    }

    public static void k(AdTemplate adTemplate, JSONObject jSONObject) {
        d(adTemplate, 451, jSONObject);
    }

    public static void l(AdTemplate adTemplate, int i) {
        c(adTemplate, i, 0);
    }

    public static void m(AdTemplate adTemplate, int i) {
        y.b bVar = new y.b();
        bVar.akg = i;
        b(adTemplate, 759, bVar, (JSONObject) null);
    }

    public static void n(AdTemplate adTemplate, int i) {
        y.b bVar = new y.b();
        bVar.akf = i;
        b(adTemplate, 28, bVar, (JSONObject) null);
    }

    public static void o(AdTemplate adTemplate, int i) {
        if (adTemplate == null) {
            return;
        }
        y.b bVar = new y.b();
        bVar.akw = com.kwad.sdk.core.response.a.a.aq(com.kwad.sdk.core.response.a.d.cb(adTemplate));
        b(adTemplate, i, bVar, new JSONObject());
    }

    public static void p(AdTemplate adTemplate, int i) {
        b(adTemplate, i, new y.b(), new JSONObject());
    }

    @Deprecated
    public static void q(AdTemplate adTemplate, int i) {
        a(adTemplate, new i().bl(i));
    }

    private static void r(AdTemplate adTemplate, int i) {
        b(adTemplate, i, (y.b) null, new JSONObject());
    }

    private static int wM() {
        return ai.DM() ? 2 : 1;
    }
}
