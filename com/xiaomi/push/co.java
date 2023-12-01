package com.xiaomi.push;

import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/co.class */
public class co {

    /* renamed from: a  reason: collision with root package name */
    private int f41312a;

    /* renamed from: a  reason: collision with other field name */
    private long f256a;

    /* renamed from: a  reason: collision with other field name */
    private String f257a;
    private long b;

    /* renamed from: c  reason: collision with root package name */
    private long f41313c;

    public co() {
        this(0, 0L, 0L, null);
    }

    public co(int i, long j, long j2, Exception exc) {
        this.f41312a = i;
        this.f256a = j;
        this.f41313c = j2;
        this.b = System.currentTimeMillis();
        if (exc != null) {
            this.f257a = exc.getClass().getSimpleName();
        }
    }

    public int a() {
        return this.f41312a;
    }

    public co a(JSONObject jSONObject) {
        this.f256a = jSONObject.getLong("cost");
        this.f41313c = jSONObject.getLong("size");
        this.b = jSONObject.getLong("ts");
        this.f41312a = jSONObject.getInt(com.anythink.expressad.d.a.b.R);
        this.f257a = jSONObject.optString("expt");
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public JSONObject m11586a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("cost", this.f256a);
        jSONObject.put("size", this.f41313c);
        jSONObject.put("ts", this.b);
        jSONObject.put(com.anythink.expressad.d.a.b.R, this.f41312a);
        jSONObject.put("expt", this.f257a);
        return jSONObject;
    }
}
