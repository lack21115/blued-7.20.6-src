package com.igexin.push.core.a.b;

import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/push/core/a/b/b.class */
public final class b extends a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f23400a = com.igexin.push.config.c.f23373a + "_BindAliasResultAction";

    @Override // com.igexin.push.core.a.b.a
    public final boolean a(Object obj, JSONObject jSONObject) {
        com.igexin.c.a.c.a.b(f23400a, "bind alias result resp data = ".concat(String.valueOf(jSONObject)));
        try {
            if (jSONObject.has("action") && jSONObject.getString("action").equals("response_bind")) {
                com.igexin.push.core.l.a().b(jSONObject.getString("sn"), jSONObject.getString("result"));
                return true;
            }
            return true;
        } catch (Exception e) {
            com.igexin.c.a.c.a.a(e);
            return true;
        }
    }
}
