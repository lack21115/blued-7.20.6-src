package com.tramini.plugin.a.d;

import android.content.Context;
import com.tramini.plugin.a.g.h;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/tramini/plugin/a/d/d.class */
public final class d extends a {
    @Override // com.tramini.plugin.a.d.a
    protected final Object a(String str) {
        return str.trim();
    }

    @Override // com.tramini.plugin.a.d.a
    protected final String a() {
        com.tramini.plugin.a.a.a();
        return com.tramini.plugin.a.a.b();
    }

    @Override // com.tramini.plugin.a.d.a
    protected final Map<String, String> b() {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json;charset=utf-8");
        return hashMap;
    }

    @Override // com.tramini.plugin.a.d.a
    protected final byte[] c() {
        try {
            return e().getBytes("utf-8");
        } catch (Exception e) {
            return e().getBytes();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tramini.plugin.a.d.a
    public final JSONObject d() {
        Object obj = "1";
        JSONObject jSONObject = new JSONObject();
        Context b = com.tramini.plugin.a.a.c.a().b();
        try {
            jSONObject.put("platform", "1");
            jSONObject.put("os_vn", com.tramini.plugin.a.g.e.b());
            jSONObject.put("os_vc", com.tramini.plugin.a.g.e.a());
            jSONObject.put("package_name", com.tramini.plugin.a.g.e.c(b));
            jSONObject.put("app_vn", com.tramini.plugin.a.g.e.b(b));
            jSONObject.put("app_vc", com.tramini.plugin.a.g.e.a(b));
            jSONObject.put("sdk_ver", "1.0.2");
            jSONObject.put("android_id", com.tramini.plugin.a.g.e.d(b));
            if (!h.a(b)) {
                obj = "0";
            }
            jSONObject.put("is_proxy", obj);
            jSONObject.put("pil_offset", com.tramini.plugin.a.a.c.a().c());
            return jSONObject;
        } catch (Exception e) {
            return jSONObject;
        }
    }

    @Override // com.tramini.plugin.a.d.a
    public final boolean f() {
        return true;
    }
}
