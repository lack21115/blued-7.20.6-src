package com.anythink.core.common.g.a;

import com.anythink.core.common.b.n;
import com.anythink.core.common.e.f;
import com.anythink.core.common.e.o;
import com.anythink.core.common.u;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/g/a/e.class */
public final class e extends c {

    /* renamed from: a  reason: collision with root package name */
    List<f> f6717a;
    boolean b;

    /* renamed from: c  reason: collision with root package name */
    private final String f6718c = getClass().getSimpleName();

    public e(List<f> list) {
        this.f6717a = list;
    }

    private String a(boolean z) {
        JSONObject jSONObject = new JSONObject();
        JSONObject g = super.g();
        JSONObject a2 = com.anythink.core.common.g.c.a();
        g.put("app_id", n.a().p());
        g.put(com.anythink.core.common.g.c.T, this.i);
        g.put(com.anythink.core.common.g.c.V, this.j);
        Iterator<String> keys = a2.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            g.put(next, a2.opt(next));
        }
        Map<String, Object> m = n.a().m();
        if (m != null) {
            try {
                if (m.size() > 0 && m != null) {
                    JSONObject jSONObject2 = new JSONObject();
                    for (String str : m.keySet()) {
                        Object obj = m.get(str);
                        if (obj != null) {
                            jSONObject2.put(str, obj.toString());
                        }
                    }
                    g.put("custom", jSONObject2);
                }
            } catch (Throwable th) {
            }
        }
        String a3 = com.anythink.core.common.k.c.a(g.toString());
        JSONArray jSONArray = new JSONArray();
        List<f> list = this.f6717a;
        if (list != null) {
            for (f fVar : list) {
                JSONObject a4 = fVar.a();
                if (z && a4 != null) {
                    try {
                        a4.put(com.anythink.core.common.g.c.U, 1);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                jSONArray.put(a4);
            }
        }
        String a5 = com.anythink.core.common.k.c.a(jSONArray.toString());
        String c2 = com.anythink.core.common.k.f.c(n.a().q() + "api_ver=1.0&common=" + a3 + "&data=" + a5);
        try {
            jSONObject.put("common", a3);
            jSONObject.put("data", a5);
            jSONObject.put(com.anythink.core.common.g.c.O, "1.0");
            jSONObject.put("sign", c2);
        } catch (Exception e2) {
        }
        return jSONObject.toString();
    }

    @Override // com.anythink.core.common.g.a.c
    public final void a(String str, String str2, String str3, int i) {
        if (this.b) {
            return;
        }
        String str4 = str3 + ":" + i;
        List<f> list = this.f6717a;
        com.anythink.core.common.j.c.a("tk", str, str2, str4, (String) null, String.valueOf(list != null ? list.size() : 0), "1");
        u.a().a(3, "", "", a(true), o.a(1000));
    }

    @Override // com.anythink.core.common.g.a.c
    public final int c() {
        return 1;
    }

    @Override // com.anythink.core.common.g.a.c
    public final int d() {
        return 3;
    }

    @Override // com.anythink.core.common.g.a.c
    public final byte[] e() {
        List<f> list = this.f6717a;
        return (list == null || list.size() <= 0) ? new byte[0] : a(a(false));
    }

    @Override // com.anythink.core.common.g.a.c
    public final boolean f() {
        return this.b;
    }

    @Override // com.anythink.core.common.g.a.c
    protected final int h() {
        return 2;
    }
}
