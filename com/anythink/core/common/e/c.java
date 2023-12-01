package com.anythink.core.common.e;

import org.json.JSONObject;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/e/c.class */
public final class c {
    public int a;
    public long b;

    public final void a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.a = jSONObject.optInt("number");
            this.b = jSONObject.optLong("loadTime");
        } catch (Exception e) {
        }
    }

    public final String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("number", this.a);
            jSONObject.put("loadTime", this.b);
        } catch (Exception e) {
        }
        return jSONObject.toString();
    }
}
