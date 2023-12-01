package com.cmic.gen.sdk.tencent.d;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7206380-dex2jar.jar:com/cmic/gen/sdk/tencent/d/c.class */
public class c extends b {
    public static ArrayList<Throwable> b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    private JSONObject f8049c = null;
    private JSONArray d;

    @Override // com.cmic.gen.sdk.tencent.d.b
    public void a(JSONArray jSONArray) {
        this.d = jSONArray;
    }

    public void a(JSONObject jSONObject) {
        this.f8049c = jSONObject;
    }

    @Override // com.cmic.gen.sdk.tencent.d.b, com.cmic.gen.sdk.tencent.c.b.g
    public JSONObject b() {
        JSONObject b2 = super.b();
        try {
            b2.put("event", this.f8049c);
            b2.put("exceptionStackTrace", this.d);
            return b2;
        } catch (JSONException e) {
            e.printStackTrace();
            return b2;
        }
    }
}
