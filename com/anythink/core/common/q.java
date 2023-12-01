package com.anythink.core.common;

import android.text.TextUtils;
import com.adjust.sdk.Adjust;
import com.adjust.sdk.AdjustEvent;
import com.appsflyer.AppsFlyerLib;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/q.class */
public class q {
    private static volatile q c;
    private final String a = "1";
    private final String b = "2";

    private q() {
    }

    public static q a() {
        if (c == null) {
            synchronized (q.class) {
                try {
                    if (c == null) {
                        c = new q();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return c;
    }

    public static void a(com.anythink.core.common.e.e eVar) {
        if (eVar == null) {
            return;
        }
        try {
            com.anythink.core.c.d a = com.anythink.core.c.e.a(com.anythink.core.common.b.n.a().g()).a(eVar.W());
            if (a != null) {
                String B = a.B();
                if (TextUtils.isEmpty(B)) {
                    return;
                }
                JSONObject jSONObject = new JSONObject(B);
                JSONObject optJSONObject = jSONObject.optJSONObject("1");
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("token");
                    if (!TextUtils.isEmpty(optString)) {
                        String p = eVar.p();
                        double w = eVar.w() / 1000.0d;
                        String l = eVar.l();
                        try {
                            AdjustEvent adjustEvent = new AdjustEvent(optString);
                            adjustEvent.setRevenue(w, p);
                            adjustEvent.setOrderId(l);
                            Adjust.trackEvent(adjustEvent);
                        } catch (Throwable th) {
                        }
                    }
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("2");
                if (optJSONObject2 != null) {
                    int optInt = optJSONObject2.optInt("rtye");
                    HashMap hashMap = new HashMap();
                    hashMap.put("af_order_id", eVar.l());
                    hashMap.put("af_content_id", eVar.W());
                    hashMap.put("af_content_type", eVar.Y());
                    hashMap.put("af_revenue", Double.valueOf(optInt == 2 ? eVar.w() : eVar.w() / 1000.0d));
                    hashMap.put("af_currency", "USD");
                    AppsFlyerLib.getInstance().trackEvent(com.anythink.core.common.b.n.a().g(), "af_ad_view", hashMap);
                }
            }
        } catch (Throwable th2) {
        }
    }

    private static void a(String str, double d, String str2, String str3) {
        try {
            AdjustEvent adjustEvent = new AdjustEvent(str);
            adjustEvent.setRevenue(d, str2);
            adjustEvent.setOrderId(str3);
            Adjust.trackEvent(adjustEvent);
        } catch (Throwable th) {
        }
    }
}
