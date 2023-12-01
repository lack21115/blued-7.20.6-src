package com.anythink.core.b;

import com.anythink.core.api.ATAdConst;
import com.anythink.core.common.l;
import org.json.JSONObject;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/b/j.class */
public final class j implements Comparable<j> {
    int a;
    String b;
    double c;
    String d;

    private double a() {
        return this.c;
    }

    private int a(j jVar) {
        return this.a < jVar.a ? -1 : 1;
    }

    public static j a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            j jVar = new j();
            jVar.a = jSONObject.optInt("prority");
            jVar.b = jSONObject.optString(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.AD_SOURCE_ID);
            if (jSONObject.has(l.am)) {
                jVar.c = jSONObject.optDouble(l.am);
            } else if (jSONObject.has("price")) {
                jVar.c = jSONObject.optDouble("price");
            } else {
                jVar.c = 0.0d;
            }
            jVar.d = jSONObject.optString("tp_bid_id");
            return jVar;
        } catch (Throwable th) {
            return null;
        }
    }

    private void a(double d) {
        this.c = d;
    }

    private String b() {
        return this.b;
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(j jVar) {
        return this.a < jVar.a ? -1 : 1;
    }
}
