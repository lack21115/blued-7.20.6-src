package com.tramini.plugin.a.d;

import android.content.Context;
import com.tramini.plugin.a.g.f;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/tramini/plugin/a/d/e.class */
public final class e extends a {
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private String f26821c;
    private JSONObject d;
    private JSONObject e;

    public e(Context context, String str, JSONObject jSONObject, JSONObject jSONObject2) {
        this.b = context;
        this.f26821c = str;
        this.d = jSONObject;
        this.e = jSONObject2;
    }

    @Override // com.tramini.plugin.a.d.a
    protected final Object a(String str) {
        return str.trim();
    }

    @Override // com.tramini.plugin.a.d.a
    protected final String a() {
        com.tramini.plugin.a.c.c cVar = com.tramini.plugin.b.b.a(this.b).b().e().get(this.f26821c);
        com.tramini.plugin.a.a.a();
        String c2 = com.tramini.plugin.a.a.c();
        if (cVar != null) {
            c2 = cVar.f26811a;
        }
        return c2;
    }

    @Override // com.tramini.plugin.a.d.a
    protected final Map<String, String> b() {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Encoding", "gzip");
        hashMap.put("Content-Type", "application/json;charset=utf-8");
        return hashMap;
    }

    @Override // com.tramini.plugin.a.d.a
    protected final byte[] c() {
        return b(e());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tramini.plugin.a.d.a
    public final JSONObject d() {
        JSONObject jSONObject = this.d;
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = super.d();
        }
        return jSONObject2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tramini.plugin.a.d.a
    public final String e() {
        JSONObject jSONObject = new JSONObject();
        String b = com.tramini.plugin.a.g.c.b(d().toString());
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(this.e);
        String b2 = com.tramini.plugin.a.g.c.b(jSONArray.toString());
        String a2 = f.a("d_version=1.0&dt=" + b2 + "&cm=" + b);
        try {
            jSONObject.put("cm", b);
            jSONObject.put("dt", b2);
            jSONObject.put("d_version", "1.0");
            jSONObject.put("d_sign", a2);
            jSONObject.put("pl_c", "2");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    @Override // com.tramini.plugin.a.d.a
    public final boolean f() {
        return false;
    }
}
