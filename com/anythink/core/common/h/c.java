package com.anythink.core.common.h;

import android.content.Context;
import com.anythink.core.api.AdError;
import com.anythink.core.api.ErrorCode;
import com.anythink.core.common.b.n;
import com.anythink.core.common.e.e;
import com.anythink.core.common.i;
import com.anythink.core.common.k.f;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/h/c.class */
public final class c extends com.anythink.core.common.g.a {
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private int f6754c;
    private String f;
    private e g;
    private com.anythink.core.c.d h;

    /* renamed from: a  reason: collision with root package name */
    boolean f6753a = false;
    private String d = n.a().p();
    private String e = n.a().q();

    public c(Context context, int i, String str, e eVar, com.anythink.core.c.d dVar) {
        this.b = context;
        this.f6754c = i;
        this.g = eVar;
        this.h = dVar;
        this.f = str;
    }

    @Override // com.anythink.core.common.g.a
    public final int a() {
        return 1;
    }

    @Override // com.anythink.core.common.g.a
    public final Object a(String str) {
        return str.trim();
    }

    @Override // com.anythink.core.common.g.a
    public final void a(AdError adError) {
    }

    @Override // com.anythink.core.common.g.a
    public final boolean a(int i) {
        return false;
    }

    @Override // com.anythink.core.common.g.a
    public final String b() {
        i.a();
        return i.i();
    }

    @Override // com.anythink.core.common.g.a
    public final void b(AdError adError) {
        try {
            if (ErrorCode.httpStatuException.equals(adError.getCode())) {
                com.anythink.core.common.j.c.a(this.g, this.h, adError.getPlatformCode(), adError.getPlatformMSG());
            } else if (this.f6753a) {
                com.anythink.core.common.j.c.a(this.g, this.h, adError.getPlatformCode(), adError.getPlatformMSG());
            } else {
                this.f6753a = true;
                com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.core.common.h.c.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        c cVar = c.this;
                        cVar.a(0, cVar.m);
                    }
                }, 5000L);
            }
        } catch (Throwable th) {
        }
    }

    @Override // com.anythink.core.common.g.a
    public final Map<String, String> c() {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Encoding", "gzip");
        hashMap.put("Content-Type", "application/json;charset=utf-8");
        return hashMap;
    }

    @Override // com.anythink.core.common.g.a
    public final byte[] d() {
        return c(g());
    }

    @Override // com.anythink.core.common.g.a
    public final JSONObject e() {
        JSONObject e = super.e();
        JSONObject f = super.f();
        e.put("app_id", this.d);
        Iterator<String> keys = f.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            e.put(next, f.opt(next));
        }
        Map<String, Object> m = n.a().m();
        if (m != null) {
            try {
                if (m.size() > 0 && m != null) {
                    JSONObject jSONObject = new JSONObject();
                    for (String str : m.keySet()) {
                        Object obj = m.get(str);
                        if (obj != null) {
                            jSONObject.put(str, obj.toString());
                        }
                    }
                    e.put("custom", jSONObject);
                }
            } catch (JSONException e2) {
                return e;
            }
        }
        return e;
    }

    @Override // com.anythink.core.common.g.a
    public final String g() {
        JSONObject jSONObject = new JSONObject();
        String a2 = com.anythink.core.common.k.c.a(e().toString());
        String c2 = f.c(this.e + "api_ver=1.0&common=" + a2 + "&data=" + this.f + "&ss_a=" + this.f6754c);
        try {
            jSONObject.put("common", a2);
            jSONObject.put("ss_a", this.f6754c);
            jSONObject.put("data", this.f);
            jSONObject.put(com.anythink.core.common.g.c.O, "1.0");
            jSONObject.put("sign", c2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    @Override // com.anythink.core.common.g.a
    public final String h() {
        return this.d;
    }

    @Override // com.anythink.core.common.g.a
    public final Context i() {
        return this.b;
    }

    @Override // com.anythink.core.common.g.a
    public final String j() {
        return this.e;
    }

    @Override // com.anythink.core.common.g.a
    public final String k() {
        return "1.0";
    }

    @Override // com.anythink.core.common.g.a
    public final Map<String, Object> l() {
        return null;
    }
}
