package com.igexin.push.core.a.b;

import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/push/core/a/b/l.class */
public final class l extends a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f23410a = com.igexin.push.config.c.f23373a + "_UnBindAliasResultAction";

    @Override // com.igexin.push.core.a.b.a
    public final boolean a(Object obj, JSONObject jSONObject) {
        com.igexin.c.a.c.a.a(f23410a + "|unbind alias result resp data = " + jSONObject, new Object[0]);
        try {
            if (jSONObject.has("action") && jSONObject.getString("action").equals("response_unbind")) {
                com.igexin.push.core.l.a().c(jSONObject.getString("sn"), jSONObject.getString("result"));
                return true;
            }
            return true;
        } catch (Exception e) {
            com.igexin.c.a.c.a.a(e);
            com.igexin.c.a.c.a.a(f23410a + "|" + e.toString(), new Object[0]);
            return true;
        }
    }
}
