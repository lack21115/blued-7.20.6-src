package com.igexin.push.core.a.b;

import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/push/core/a/b/f.class */
public final class f extends a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f9797a = com.igexin.push.config.c.f9765a + "_QueryTagResultAction";

    @Override // com.igexin.push.core.a.b.a
    public final boolean a(Object obj, JSONObject jSONObject) {
        com.igexin.c.a.c.a.a(f9797a + "|query tag result resp data = " + jSONObject, new Object[0]);
        try {
            if (jSONObject.has("action") && jSONObject.getString("action").equals("query_tag_result")) {
                String string = jSONObject.getString("tags");
                com.igexin.push.core.l.a().a(jSONObject.getString("sn"), jSONObject.getString("error_code"), jSONObject.getString("tags"));
                String str = string;
                if (TextUtils.isEmpty(string)) {
                    str = "none";
                }
                com.igexin.push.core.e.f.a().e(str);
                return true;
            }
            return true;
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return true;
        }
    }
}
