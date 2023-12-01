package com.kwad.sdk.core.request.model;

import android.content.Context;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.InstalledAppInfoManager;
import com.kwad.sdk.utils.ae;
import com.kwad.sdk.utils.ap;
import com.kwad.sdk.utils.au;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.k;
import com.kwad.sdk.utils.y;
import org.json.JSONArray;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/request/model/b.class */
public class b extends com.kwad.sdk.core.response.kwai.a {
    private static boolean akY;
    private static JSONArray akZ;
    public String OK;
    public String SR;
    public int SS;
    public int SU;
    public String SV;
    public int SX;
    public int SY;
    public String adV;
    public String adW;
    public String ala;
    public String alb;
    public String alc;
    public String ald;
    public String ale;
    public String alf;
    public int alg;
    public int alh;
    public String ali;
    public String alj;
    public String alk;
    public int all;
    public String alm;
    public String aln;
    public String alo;
    public JSONArray alp;
    public String alq;
    public String als;
    public String alt;
    public String alu;
    public String alw;
    public String alx;
    public int alr = 0;
    public long alv = 0;

    private static JSONArray aW(Context context) {
        synchronized (b.class) {
            try {
                if (!akY) {
                    akY = true;
                    InstalledAppInfoManager.a(context, new com.kwad.sdk.e.a<JSONArray>() { // from class: com.kwad.sdk.core.request.model.b.1
                        private static void g(JSONArray jSONArray) {
                            JSONArray unused = b.akZ = jSONArray;
                        }

                        @Override // com.kwad.sdk.e.a
                        public final /* synthetic */ void accept(JSONArray jSONArray) {
                            g(jSONArray);
                        }
                    });
                }
                JSONArray jSONArray = akZ;
                if (jSONArray != null) {
                    akZ = null;
                    return jSONArray;
                }
                return null;
            } finally {
            }
        }
    }

    public static b g(boolean z, int i) {
        b bVar = new b();
        com.kwad.sdk.service.kwai.e eVar = (com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class);
        Context context = eVar.getContext();
        bVar.adV = au.cl(context);
        bVar.ala = au.co(context);
        bVar.alb = au.cp(context);
        bVar.alc = bd.cT(context);
        bVar.adW = au.getOaid();
        bVar.alm = bd.EF();
        bVar.SR = bd.EH();
        bVar.SS = 1;
        bVar.SU = bd.ER();
        bVar.alf = bd.getOsVersion();
        bVar.SV = k.getLanguage();
        bVar.SY = k.getScreenHeight(context);
        bVar.SX = k.getScreenWidth(context);
        bVar.alg = k.bJ(context);
        bVar.alh = k.bK(context);
        bVar.ali = au.cm(context);
        if (z) {
            bVar.alp = aW(context);
        }
        bVar.alj = au.getDeviceId();
        bVar.alv = bd.EG();
        bVar.alk = bd.EO();
        bVar.alo = y.Dw();
        com.kwad.sdk.components.f fVar = (com.kwad.sdk.components.f) com.kwad.sdk.components.c.f(com.kwad.sdk.components.f.class);
        if (fVar != null) {
            bVar.aln = fVar.nv();
        }
        bVar.all = bd.EP();
        StringBuilder sb = new StringBuilder("DeviceInfo i=");
        sb.append(eVar.getAppId());
        sb.append(",n=");
        sb.append(eVar.getAppName());
        sb.append(",external:");
        sb.append(eVar.getIsExternal());
        sb.append(",v1:");
        sb.append(eVar.getApiVersion());
        sb.append(",v2:3.3.40");
        sb.append(",d:");
        sb.append(bVar.alj);
        sb.append(",dh:");
        String str = bVar.alj;
        sb.append(str != null ? Integer.valueOf(str.hashCode()) : "");
        sb.append(",o:");
        sb.append(bVar.adW);
        sb.append(",b:463");
        sb.append(",p:");
        sb.append(ap.isInMainProcess(context));
        sb.append(",dy:");
        sb.append(com.kwad.b.kwai.a.Yg);
        com.kwad.sdk.core.d.b.cb(sb.toString());
        bVar.alq = bd.EQ();
        bVar.alr = i;
        if (sE()) {
            bVar.als = com.kwad.sdk.a.b.tA().getVersion(context, "com.smile.gifmaker");
            bVar.alt = com.kwad.sdk.a.b.tA().getVersion(context, "com.kuaishou.nebula");
            bVar.alu = com.kwad.sdk.a.b.tA().getVersion(context, "com.tencent.mm");
        }
        bVar.OK = bd.EM();
        bVar.ale = ae.bY(context);
        bVar.alw = bd.EV();
        bVar.alx = bd.eV("/data/data");
        return bVar;
    }

    private static boolean sE() {
        return ((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).sE();
    }

    public static b xq() {
        b bVar = new b();
        bVar.adW = au.getOaid();
        bVar.alj = au.getDeviceId();
        bVar.alm = bd.EF();
        bVar.SS = 1;
        bVar.SU = bd.ER();
        bVar.alf = bd.getOsVersion();
        bVar.alo = y.Dw();
        com.kwad.sdk.components.f fVar = (com.kwad.sdk.components.f) com.kwad.sdk.components.c.f(com.kwad.sdk.components.f.class);
        if (fVar != null) {
            bVar.aln = fVar.nv();
        }
        com.kwad.sdk.service.kwai.e eVar = (com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class);
        if (eVar != null) {
            bVar.adV = au.cl(eVar.getContext());
        }
        return bVar;
    }
}
