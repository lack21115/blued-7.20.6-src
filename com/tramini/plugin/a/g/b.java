package com.tramini.plugin.a.g;

import android.text.TextUtils;
import com.adjust.sdk.Adjust;
import com.adjust.sdk.AdjustAttribution;
import com.anythink.expressad.foundation.d.r;
import com.appsflyer.AppsFlyerLib;
import com.cdo.oaps.ad.OapsKey;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/tramini/plugin/a/g/b.class */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static b f40537a;

    private b() {
    }

    public static b a() {
        if (f40537a == null) {
            f40537a = new b();
        }
        return f40537a;
    }

    public final void a(final com.tramini.plugin.b.a aVar) {
        com.tramini.plugin.a.g.b.a.a().a(new Runnable() { // from class: com.tramini.plugin.a.g.b.1
            @Override // java.lang.Runnable
            public final void run() {
                synchronized (b.this) {
                    if (aVar.a() != 1) {
                        return;
                    }
                    String a2 = g.a(aVar);
                    com.tramini.plugin.b.a aVar2 = aVar;
                    try {
                        com.tramini.plugin.a.c.b bVar = new com.tramini.plugin.a.c.b();
                        bVar.f40500a = AppsFlyerLib.getInstance().getSdkVersion();
                        bVar.b = 1;
                        String b = i.b(com.tramini.plugin.a.a.c.a().b(), "appsflyer-data", "attributionId", "");
                        if (!TextUtils.isEmpty(b)) {
                            bVar.f40501c = b;
                            JSONObject a3 = bVar.a();
                            String b2 = i.b(com.tramini.plugin.a.a.c.a().b(), "tramini", "S_ASF_ATT", "");
                            if (a3 != null && !TextUtils.equals(b2, b)) {
                                i.a(com.tramini.plugin.a.a.c.a().b(), "tramini", "S_ASF_ATT", b);
                                com.tramini.plugin.a.f.a.a().a(a2, aVar2.b(), d.f40545a, a3);
                            }
                        }
                    } catch (Throwable th) {
                    }
                    com.tramini.plugin.b.a aVar3 = aVar;
                    com.tramini.plugin.a.c.b bVar2 = new com.tramini.plugin.a.c.b();
                    bVar2.f40500a = Adjust.getSdkVersion();
                    bVar2.b = 2;
                    AdjustAttribution attribution = Adjust.getAttribution();
                    if (attribution != null) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("adgroup", attribution.adgroup);
                        jSONObject.put(OapsKey.KEY_ADID, attribution.adid);
                        jSONObject.put("campaign", attribution.campaign);
                        jSONObject.put("clickLabel", attribution.clickLabel);
                        jSONObject.put(r.aD, attribution.creative);
                        jSONObject.put("network", attribution.network);
                        jSONObject.put("trackerName", attribution.trackerName);
                        jSONObject.put("trackerToken", attribution.trackerToken);
                        jSONObject.put("attr", attribution.toString());
                        bVar2.f40501c = jSONObject.toString();
                        JSONObject a4 = bVar2.a();
                        if (!TextUtils.equals(i.b(com.tramini.plugin.a.a.c.a().b(), "tramini", "S_AJS_ATT", ""), jSONObject.toString())) {
                            i.a(com.tramini.plugin.a.a.c.a().b(), "tramini", "S_AJS_ATT", jSONObject.toString());
                            com.tramini.plugin.a.f.a.a().a(a2, aVar3.b(), d.f40545a, a4);
                        }
                    }
                }
            }
        });
    }
}
