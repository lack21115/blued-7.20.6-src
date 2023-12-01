package com.igexin.push.core.a.b;

import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/push/core/a/b/g.class */
public final class g extends a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f9798a = "ReceivedAction";

    @Override // com.igexin.push.core.a.b.a
    public final boolean a(Object obj, JSONObject jSONObject) {
        try {
            if (jSONObject.has("action") && jSONObject.getString("action").equals(com.igexin.push.core.b.B)) {
                String string = jSONObject.getString("id");
                com.igexin.c.a.c.a.a("ReceivedAction received, cmd id :".concat(String.valueOf(string)), new Object[0]);
                try {
                    com.igexin.push.core.e.e.a().a(Long.parseLong(string), false);
                    com.igexin.push.core.a.b.d();
                    com.igexin.push.core.a.b.g();
                    return true;
                } catch (NumberFormatException e) {
                    com.igexin.c.a.c.a.a("ReceivedAction|" + e.toString(), new Object[0]);
                    return true;
                }
            }
            return true;
        } catch (Exception e2) {
            com.igexin.c.a.c.a.a(e2);
            com.igexin.c.a.c.a.a("ReceivedAction|" + e2.toString(), new Object[0]);
            return true;
        }
    }
}
