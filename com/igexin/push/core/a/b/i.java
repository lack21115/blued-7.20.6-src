package com.igexin.push.core.a.b;

import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/push/core/a/b/i.class */
public final class i extends a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f9800a = "ResponseDeviceidAction";

    @Override // com.igexin.push.core.a.b.a
    public final boolean a(Object obj, JSONObject jSONObject) {
        try {
            if (jSONObject.has("action") && jSONObject.getString("action").equals("response_deviceid")) {
                com.igexin.push.core.e.f.a().a(jSONObject.getString("deviceid"));
                if (com.igexin.push.core.e.H != null) {
                    com.igexin.push.core.a.b.d().i();
                }
                String str = com.igexin.push.core.e.H;
                return true;
            }
            return true;
        } catch (Exception e) {
            com.igexin.c.a.c.a.a(e);
            return true;
        }
    }
}
