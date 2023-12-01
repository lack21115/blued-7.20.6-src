package com.anythink.core.common.g;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.api.AdError;
import com.anythink.core.common.b.n;
import com.anythink.core.common.e.o;
import com.anythink.core.common.u;
import com.efs.sdk.base.Constants;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/g/b.class */
public final class b extends a {
    Context a;
    int b;
    List<String> e;
    int f;
    boolean g = false;
    String c = n.a().p();
    String d = n.a().q();

    public b(Context context, int i, List<String> list) {
        this.a = context;
        this.e = list;
        this.b = list.size();
        this.f = i;
    }

    private static String b(String str) {
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }

    @Override // com.anythink.core.common.g.a
    protected final int a() {
        return 1;
    }

    @Override // com.anythink.core.common.g.a
    protected final Object a(String str) {
        return Integer.valueOf(this.b);
    }

    @Override // com.anythink.core.common.g.a
    public final void a(int i, i iVar) {
        if (!TextUtils.isEmpty(b())) {
            super.a(i, iVar);
        } else if (iVar != null) {
            iVar.onLoadFinish(i, Integer.valueOf(this.b));
        }
    }

    @Override // com.anythink.core.common.g.a
    protected final void a(AdError adError) {
        if (this.g) {
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
            String g = g();
            u.a().a(1, b(), jSONObject2, g, o.a(1001));
        }
    }

    @Override // com.anythink.core.common.g.a
    protected final boolean a(int i) {
        return false;
    }

    @Override // com.anythink.core.common.g.a
    protected final String b() {
        com.anythink.core.common.i.a();
        return com.anythink.core.common.i.k();
    }

    @Override // com.anythink.core.common.g.a
    protected final void b(AdError adError) {
    }

    @Override // com.anythink.core.common.g.a
    protected final Map<String, String> c() {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Encoding", Constants.CP_GZIP);
        hashMap.put("Content-Type", "application/json;charset=utf-8");
        return hashMap;
    }

    @Override // com.anythink.core.common.g.a
    protected final byte[] d() {
        return c(g());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x00e6 -> B:18:0x0087). Please submit an issue!!! */
    @Override // com.anythink.core.common.g.a
    public final JSONObject e() {
        JSONObject e = super.e();
        if (e != null) {
            try {
                e.put("app_id", this.c);
                e.put("nw_ver", com.anythink.core.common.k.d.h());
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
                    } catch (Throwable th) {
                    }
                }
                JSONArray jSONArray = new JSONArray();
                if (this.e != null && this.e.size() > 0) {
                    for (String str2 : this.e) {
                        if (!TextUtils.isEmpty(str2)) {
                            jSONArray.put(new JSONObject(str2));
                        }
                    }
                }
                e.put("data", jSONArray);
            } catch (Exception e2) {
                return e;
            }
        }
        return e;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.anythink.core.common.g.a
    public final JSONObject f() {
        JSONObject f = super.f();
        if (f != null) {
            try {
                f.put(c.T, this.f);
            } catch (Exception e) {
                return f;
            }
        }
        return f;
    }

    @Override // com.anythink.core.common.g.a
    protected final String h() {
        return this.c;
    }

    @Override // com.anythink.core.common.g.a
    protected final Context i() {
        return this.a;
    }

    @Override // com.anythink.core.common.g.a
    protected final String j() {
        return this.d;
    }

    @Override // com.anythink.core.common.g.a
    protected final String k() {
        return "1.0";
    }

    @Override // com.anythink.core.common.g.a
    protected final Map<String, Object> l() {
        return null;
    }

    @Override // com.anythink.core.common.g.a
    protected final boolean o() {
        return true;
    }

    public final void p() {
        this.g = true;
    }
}
