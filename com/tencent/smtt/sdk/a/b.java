package com.tencent.smtt.sdk.a;

import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/sdk/a/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private int f25132a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private String f25133c;
    private long d;

    private b() {
    }

    public static b a(JSONObject jSONObject) {
        if (jSONObject != null) {
            b bVar = new b();
            bVar.f25132a = jSONObject.optInt("id", -1);
            bVar.b = jSONObject.optInt("cmd_id", -1);
            bVar.f25133c = jSONObject.optString("ext_params", "");
            bVar.d = jSONObject.optLong("expiration", 0L) * 1000;
            return bVar;
        }
        return null;
    }

    public int a() {
        return this.f25132a;
    }

    public int b() {
        return this.b;
    }

    public String c() {
        return this.f25133c;
    }

    public long d() {
        return this.d;
    }

    public boolean e() {
        return System.currentTimeMillis() > this.d;
    }

    public String toString() {
        return "[id=" + this.f25132a + ", cmd=" + this.b + ", extra='" + this.f25133c + "', expiration=" + a.a(this.d) + ']';
    }
}
