package com.cmic.gen.sdk.tencent.c.b;

import android.media.TtmlUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7206380-dex2jar.jar:com/cmic/gen/sdk/tencent/c/b/f.class */
public class f extends g {

    /* renamed from: a  reason: collision with root package name */
    private b f8032a;
    private a b;

    /* loaded from: source-7206380-dex2jar.jar:com/cmic/gen/sdk/tencent/c/b/f$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private JSONObject f8033a;

        public JSONObject a() {
            return this.f8033a;
        }

        public void a(JSONObject jSONObject) {
            this.f8033a = jSONObject;
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/cmic/gen/sdk/tencent/c/b/f$b.class */
    public static class b extends g {

        /* renamed from: a  reason: collision with root package name */
        private String f8034a;
        private String b;

        /* renamed from: c  reason: collision with root package name */
        private String f8035c;
        private String d;
        private String e;

        @Override // com.cmic.gen.sdk.tencent.c.b.g
        public String a() {
            return this.d;
        }

        @Override // com.cmic.gen.sdk.tencent.c.b.g
        protected String a(String str) {
            return this.e + this.d + this.f8035c + this.b + "@Fdiwmxy7CBDDQNUI";
        }

        @Override // com.cmic.gen.sdk.tencent.c.b.g
        public JSONObject b() {
            return null;
        }

        public void b(String str) {
            this.e = str;
        }

        public String c() {
            return this.e;
        }

        public void c(String str) {
            this.d = str;
        }

        public String d() {
            return this.f8034a;
        }

        public void d(String str) {
            this.f8034a = str;
        }

        public String e() {
            return this.b;
        }

        public void e(String str) {
            this.b = str;
        }

        public String f() {
            return this.f8035c;
        }

        public void f(String str) {
            this.f8035c = str;
        }
    }

    @Override // com.cmic.gen.sdk.tencent.c.b.g
    public String a() {
        return this.f8032a.d;
    }

    @Override // com.cmic.gen.sdk.tencent.c.b.g
    protected String a(String str) {
        return null;
    }

    public void a(a aVar) {
        this.b = aVar;
    }

    public void a(b bVar) {
        this.f8032a = bVar;
    }

    @Override // com.cmic.gen.sdk.tencent.c.b.g
    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject2.put(com.anythink.expressad.d.a.b.d, this.f8032a.d());
            jSONObject2.put("msgid", this.f8032a.e());
            jSONObject2.put("systemtime", this.f8032a.f());
            jSONObject2.put("appid", this.f8032a.a());
            jSONObject2.put("version", this.f8032a.c());
            jSONObject.put("header", jSONObject2);
            jSONObject3.put("log", this.b.a());
            jSONObject.put(TtmlUtils.TAG_BODY, jSONObject3);
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
            return jSONObject;
        }
    }
}
