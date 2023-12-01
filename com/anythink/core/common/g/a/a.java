package com.anythink.core.common.g.a;

import android.text.TextUtils;
import com.anythink.core.common.b.n;
import com.anythink.core.common.e.o;
import com.anythink.core.common.k.f;
import com.anythink.core.common.u;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/g/a/a.class */
public final class a extends c {
    List<String> a;
    int b;
    boolean c;
    private final String k = getClass().getSimpleName();

    public a(List<String> list) {
        this.a = list;
        this.b = list.size();
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x0178 -> B:18:0x0097). Please submit an issue!!! */
    private String i() {
        JSONObject g = super.g();
        JSONObject a = com.anythink.core.common.g.c.a();
        if (g != null) {
            try {
                g.put("app_id", n.a().p());
                g.put("nw_ver", com.anythink.core.common.k.d.h());
                JSONArray jSONArray = new JSONArray();
                if (this.a != null && this.a.size() > 0) {
                    for (String str : this.a) {
                        if (!TextUtils.isEmpty(str)) {
                            jSONArray.put(new JSONObject(str));
                        }
                    }
                }
                g.put("data", jSONArray);
            } catch (Exception e) {
            }
        }
        try {
            a.put(com.anythink.core.common.g.c.T, this.i);
            a.put(com.anythink.core.common.g.c.V, this.j);
        } catch (Exception e2) {
        }
        HashMap hashMap = new HashMap();
        String a2 = com.anythink.core.common.k.c.a(g.toString());
        String a3 = com.anythink.core.common.k.c.a(a.toString());
        hashMap.put(com.anythink.core.common.g.c.O, "1.0");
        hashMap.put(com.anythink.core.common.g.c.W, a2);
        hashMap.put(com.anythink.core.common.g.c.X, a3);
        ArrayList<String> arrayList = new ArrayList(hashMap.size());
        arrayList.addAll(hashMap.keySet());
        Collections.sort(arrayList);
        StringBuilder sb = new StringBuilder();
        for (String str2 : arrayList) {
            if (sb.length() > 0) {
                sb.append(com.alipay.sdk.sys.a.b);
            }
            sb.append(str2);
            sb.append("=");
            sb.append(hashMap.get(str2));
        }
        hashMap.put(com.anythink.core.common.g.c.Y, f.c(n.a().q() + sb.toString()));
        return new JSONObject(hashMap).toString();
    }

    public final void a() {
        this.c = true;
    }

    @Override // com.anythink.core.common.g.a.c
    public final void a(String str, String str2, String str3, int i) {
        if (this.c) {
            u.a().a(3, "", "", i(), o.a(1001));
        }
    }

    public final int b() {
        return this.b;
    }

    @Override // com.anythink.core.common.g.a.c
    public final int c() {
        return 2;
    }

    @Override // com.anythink.core.common.g.a.c
    public final int d() {
        return 3;
    }

    @Override // com.anythink.core.common.g.a.c
    public final byte[] e() {
        return a(i());
    }

    @Override // com.anythink.core.common.g.a.c
    public final boolean f() {
        return false;
    }
}
