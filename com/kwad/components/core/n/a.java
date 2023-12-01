package com.kwad.components.core.n;

import android.text.TextUtils;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.o;
import com.kwad.sdk.utils.s;
import com.kwad.sdk.utils.t;
import com.kwad.sdk.utils.y;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/n/a.class */
public class a extends com.kwad.sdk.core.network.d {
    private static boolean Ol = true;
    com.kwad.components.core.n.kwai.b JW;
    private int Ok;

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public a(com.kwad.components.core.n.kwai.a aVar) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    public a(com.kwad.components.core.n.kwai.b bVar) {
        this(bVar, null);
    }

    private a(com.kwad.components.core.n.kwai.b bVar, com.kwad.components.core.n.kwai.d dVar) {
        this(bVar, null, false, null);
    }

    public a(com.kwad.components.core.n.kwai.b bVar, List<String> list, boolean z, com.kwad.components.core.n.kwai.d dVar) {
        super(c(bVar), bVar.Ow);
        putBody("timestamp", System.currentTimeMillis());
        this.JW = bVar;
        com.kwad.sdk.internal.api.a pk = bVar.pk();
        if (pk != null && !pk.AB()) {
            a(com.kwad.sdk.core.request.model.a.xo(), pk);
        }
        JSONArray jSONArray = new JSONArray();
        t.putValue(jSONArray, bVar.toJson());
        putBody("impInfo", jSONArray);
        putBody("universePhotoInfo", dVar);
        int i = this.Ok;
        if (i > 0) {
            putBody("calledUnionType", i);
        }
        com.kwad.sdk.components.c.f(DevelopMangerComponents.class);
        String tO = TextUtils.isEmpty("") ? ((DevelopMangerComponents) com.kwad.sdk.components.c.f(DevelopMangerComponents.class)).tO() : "";
        if (!TextUtils.isEmpty(tO)) {
            putBody("universeDebugParam", tO);
        }
        String d = d(bVar);
        if (!TextUtils.isEmpty(d)) {
            putBody("sdkDebugReqInfo", d);
        }
        com.kwad.sdk.components.c.f(DevelopMangerComponents.class);
        if (list != null) {
            putBody("preloadIdList", new JSONArray((Collection) list));
            putBody("preloadCheck", z);
        }
        putBody("appTag", y.Dv());
        com.kwad.sdk.components.c.f(DevelopMangerComponents.class);
        String az = this.JW.az("thirdUserId");
        com.kwad.sdk.core.request.model.g xv = com.kwad.sdk.core.request.model.g.xv();
        if (az != null) {
            xv.cH(az);
        }
        if (pk != null && !pk.AA()) {
            a(xv, pk);
        }
        putBody("userInfo", xv);
    }

    private static void a(com.kwad.sdk.core.request.model.g gVar, com.kwad.sdk.internal.api.a aVar) {
        if (aVar.aaM != 0) {
            gVar.aaM = aVar.aaM;
        }
        if (aVar.aaN != 0) {
            gVar.aaN = aVar.aaN;
        }
        if (TextUtils.isEmpty(aVar.aaO)) {
            return;
        }
        gVar.aaO = aVar.aaO;
    }

    private void a(JSONObject jSONObject, com.kwad.sdk.internal.api.a aVar) {
        JSONObject jSONObject2 = new JSONObject();
        if (!TextUtils.isEmpty(aVar.aaP)) {
            t.putValue(jSONObject2, "prevTitle", aVar.aaP);
        }
        if (!TextUtils.isEmpty(aVar.aaQ)) {
            t.putValue(jSONObject2, "postTitle", aVar.aaQ);
        }
        if (!TextUtils.isEmpty(aVar.aaR)) {
            t.putValue(jSONObject2, "historyTitle", aVar.aaR);
        }
        if (!TextUtils.isEmpty(aVar.aaS)) {
            t.putValue(jSONObject2, "channel", aVar.aaS);
        }
        t.putValue(jSONObject, "content", jSONObject2);
        putBody("appInfo", jSONObject);
    }

    private static int c(com.kwad.components.core.n.kwai.b bVar) {
        try {
            return bVar.Ow.getScreenOrientation();
        } catch (Throwable th) {
            return 0;
        }
    }

    private static String d(com.kwad.components.core.n.kwai.b bVar) {
        com.kwad.sdk.service.kwai.e eVar;
        if (Ol && (eVar = (com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)) != null) {
            try {
                return (String) s.c(Class.forName("com.kwad.devTools.PosConfigFetcher").newInstance(), "getConfigParamByPosId", Long.valueOf(bVar.Ow.getPosId()), eVar.getContext());
            } catch (Exception e) {
                Ol = false;
                return "";
            }
        }
        return "";
    }

    public final void aD(int i) {
        this.Ok = i;
    }

    public final int getAdNum() {
        return this.JW.Ow.getAdNum();
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public SceneImpl getScene() {
        com.kwad.components.core.n.kwai.b bVar = this.JW;
        if (bVar != null) {
            return bVar.Ow;
        }
        return null;
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public String getUrl() {
        return com.kwad.sdk.c.sc();
    }

    @Override // com.kwad.sdk.core.network.d
    public boolean needAppList() {
        return true;
    }

    @Override // com.kwad.sdk.core.network.b
    public void onCreate() {
        o.bw(true);
        super.onCreate();
    }
}
