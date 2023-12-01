package com.xiaomi.push;

import com.cdo.oaps.ad.OapsKey;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/co.class */
public class co {

    /* renamed from: a  reason: collision with root package name */
    private int f27621a;

    /* renamed from: a  reason: collision with other field name */
    private long f209a;

    /* renamed from: a  reason: collision with other field name */
    private String f210a;
    private long b;

    /* renamed from: c  reason: collision with root package name */
    private long f27622c;

    public co() {
        this(0, 0L, 0L, null);
    }

    public co(int i, long j, long j2, Exception exc) {
        this.f27621a = i;
        this.f209a = j;
        this.f27622c = j2;
        this.b = System.currentTimeMillis();
        if (exc != null) {
            this.f210a = exc.getClass().getSimpleName();
        }
    }

    public int a() {
        return this.f27621a;
    }

    public co a(JSONObject jSONObject) {
        this.f209a = jSONObject.getLong("cost");
        this.f27622c = jSONObject.getLong(OapsKey.KEY_SIZE);
        this.b = jSONObject.getLong("ts");
        this.f27621a = jSONObject.getInt(com.anythink.expressad.d.a.b.R);
        this.f210a = jSONObject.optString("expt");
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public JSONObject m8536a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("cost", this.f209a);
        jSONObject.put(OapsKey.KEY_SIZE, this.f27622c);
        jSONObject.put("ts", this.b);
        jSONObject.put(com.anythink.expressad.d.a.b.R, this.f27621a);
        jSONObject.put("expt", this.f210a);
        return jSONObject;
    }
}
