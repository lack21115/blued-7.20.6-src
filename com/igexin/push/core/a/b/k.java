package com.igexin.push.core.a.b;

import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/push/core/a/b/k.class */
public final class k extends a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f23409a = com.igexin.push.config.c.f23373a + "_SetTagResultAction";

    @Override // com.igexin.push.core.a.b.a
    public final boolean a(Object obj, JSONObject jSONObject) {
        com.igexin.c.a.c.a.a(f23409a + "|set tag result resp data = " + jSONObject, new Object[0]);
        try {
            if (jSONObject.has("action") && jSONObject.getString("action").equals("settag_result")) {
                com.igexin.push.core.l.a().a(jSONObject.getString("sn"), jSONObject.getString("error_code"));
            }
            if (!jSONObject.getString("error_code").equals("0") || com.igexin.push.core.e.e == null) {
                return true;
            }
            com.igexin.push.core.e.f.a().e(com.igexin.push.core.e.e);
            com.igexin.push.core.e.e = null;
            return true;
        } catch (Exception e) {
            com.igexin.c.a.c.a.a(e);
            com.igexin.c.a.c.a.a(f23409a + "|" + e.toString(), new Object[0]);
            return true;
        }
    }
}
