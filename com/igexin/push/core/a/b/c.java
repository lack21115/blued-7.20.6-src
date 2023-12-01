package com.igexin.push.core.a.b;

import com.igexin.push.config.a;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/push/core/a/b/c.class */
public final class c extends a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f9793a = "BlockClientAction";

    @Override // com.igexin.push.core.a.b.a
    public final boolean a(Object obj, JSONObject jSONObject) {
        try {
            if (jSONObject.has("action") && jSONObject.getString("action").equals("block_client") && jSONObject.has("duration")) {
                long j = jSONObject.getLong("duration") * 1000;
                long currentTimeMillis = System.currentTimeMillis();
                if (j != 0) {
                    com.igexin.push.config.d.d = currentTimeMillis + j;
                    com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new a.AnonymousClass5(), false, true);
                    com.igexin.push.e.f.c().d();
                    return true;
                }
                return true;
            }
            return true;
        } catch (Exception e) {
            com.igexin.c.a.c.a.a(e);
            return true;
        }
    }
}
