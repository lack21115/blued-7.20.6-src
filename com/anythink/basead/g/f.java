package com.anythink.basead.g;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.api.AdError;
import com.anythink.core.common.e.aa;
import com.anythink.core.common.e.k;
import com.anythink.core.common.e.o;
import com.anythink.core.common.i;
import com.anythink.core.common.u;
import com.efs.sdk.base.Constants;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/g/f.class */
public final class f extends com.anythink.core.common.g.a {
    String a;
    JSONObject b;
    int c;
    String d;
    aa e;
    Map<String, Object> f;

    public f(int i, aa aaVar, String str, Map<String, Object> map) {
        this.c = i;
        this.e = aaVar;
        this.f = map;
        this.d = str;
    }

    @Override // com.anythink.core.common.g.a
    public final int a() {
        return 1;
    }

    @Override // com.anythink.core.common.g.a
    public final Object a(String str) {
        return null;
    }

    @Override // com.anythink.core.common.g.a
    public final void a(AdError adError) {
        JSONObject jSONObject = new JSONObject();
        Map<String, String> c = c();
        if (c != null) {
            try {
                for (String str : c.keySet()) {
                    jSONObject.put(str, c.get(str));
                }
            } catch (Exception e) {
            }
        }
        String jSONObject2 = jSONObject.toString();
        JSONObject jSONObject3 = this.b;
        u.a().a(1, b(), jSONObject2, jSONObject3 != null ? jSONObject3.toString() : "", o.a(1000));
        com.anythink.core.common.j.c.a("tk", adError.getPlatformCode(), adError.getPlatformMSG(), this.a, "", "1", "");
    }

    @Override // com.anythink.core.common.g.a
    public final boolean a(int i) {
        return false;
    }

    @Override // com.anythink.core.common.g.a
    public final String b() {
        try {
            if (!TextUtils.isEmpty(this.d)) {
                this.b = new JSONObject(this.d);
                for (Map.Entry<String, Object> entry : this.f.entrySet()) {
                    this.b.put(entry.getKey(), entry.getValue());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        i.a();
        String g = i.g();
        this.a = g;
        return g;
    }

    @Override // com.anythink.core.common.g.a
    public final void b(AdError adError) {
    }

    public final void b(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.b.put("scenario", str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.anythink.core.common.g.a
    public final Map<String, String> c() {
        k k;
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Encoding", Constants.CP_GZIP);
        hashMap.put("Content-Type", "application/json;charset=utf-8");
        aa aaVar = this.e;
        if (aaVar != null && (k = aaVar.k()) != null && com.anythink.basead.a.b.a(this.c, k)) {
            String i = com.anythink.core.common.k.d.i();
            if (!TextUtils.isEmpty(i)) {
                hashMap.put("User-Agent", i);
            }
        }
        return hashMap;
    }

    @Override // com.anythink.core.common.g.a
    public final byte[] d() {
        return c(this.b.toString());
    }

    @Override // com.anythink.core.common.g.a
    public final String h() {
        return null;
    }

    @Override // com.anythink.core.common.g.a
    public final Context i() {
        return null;
    }

    @Override // com.anythink.core.common.g.a
    public final String j() {
        return null;
    }

    @Override // com.anythink.core.common.g.a
    public final String k() {
        return null;
    }

    @Override // com.anythink.core.common.g.a
    public final Map<String, Object> l() {
        return null;
    }
}
