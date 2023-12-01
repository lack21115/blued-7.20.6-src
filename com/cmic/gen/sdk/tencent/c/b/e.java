package com.cmic.gen.sdk.tencent.c.b;

import android.util.Base64;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7206380-dex2jar.jar:com/cmic/gen/sdk/tencent/c/b/e.class */
public class e extends g {

    /* renamed from: a  reason: collision with root package name */
    private a f21636a;
    private byte[] b;

    /* renamed from: c  reason: collision with root package name */
    private String f21637c;
    private byte[] d;
    private String e;
    private boolean f = false;

    @Override // com.cmic.gen.sdk.tencent.c.b.g
    public String a() {
        return this.f21636a.a();
    }

    @Override // com.cmic.gen.sdk.tencent.c.b.g
    protected String a(String str) {
        return null;
    }

    public void a(a aVar) {
        this.f21636a = aVar;
    }

    public void a(boolean z) {
        this.f = z;
    }

    public void a(byte[] bArr) {
        this.b = bArr;
    }

    @Override // com.cmic.gen.sdk.tencent.c.b.g
    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        if (this.f) {
            try {
                jSONObject.put("encrypted", this.f21637c);
                jSONObject.put("encryptedIV", Base64.encodeToString(this.d, 0));
                jSONObject.put("reqdata", com.cmic.gen.sdk.tencent.e.a.a(this.b, this.f21636a.toString(), this.d));
                jSONObject.put("securityreinforce", this.e);
                return jSONObject;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return jSONObject;
    }

    public void b(String str) {
        this.e = str;
    }

    public void b(byte[] bArr) {
        this.d = bArr;
    }

    public a c() {
        return this.f21636a;
    }

    public void c(String str) {
        this.f21637c = str;
    }
}
