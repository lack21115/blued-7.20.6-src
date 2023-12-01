package com.cmic.gen.sdk.tencent.c.b;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7206380-dex2jar.jar:com/cmic/gen/sdk/tencent/c/b/d.class */
public class d extends g {

    /* renamed from: a  reason: collision with root package name */
    private final String f21634a;
    private final String b;

    /* renamed from: c  reason: collision with root package name */
    private final String f21635c;
    private String d = "authz";
    private String e;

    public d(String str, String str2, String str3) {
        this.f21634a = str;
        this.b = str2;
        this.f21635c = str3;
    }

    @Override // com.cmic.gen.sdk.tencent.c.b.g
    public String a() {
        return this.f21634a;
    }

    @Override // com.cmic.gen.sdk.tencent.c.b.g
    protected String a(String str) {
        return null;
    }

    @Override // com.cmic.gen.sdk.tencent.c.b.g
    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ver", this.b);
            jSONObject.put("data", this.f21635c);
            jSONObject.put("userCapaid", this.e);
            jSONObject.put("funcType", this.d);
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
            return jSONObject;
        }
    }

    public void b(String str) {
        this.d = str;
    }

    public void c(String str) {
        this.e = str;
    }
}
