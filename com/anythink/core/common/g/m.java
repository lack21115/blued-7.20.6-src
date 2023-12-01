package com.anythink.core.common.g;

import android.content.Context;
import com.anythink.core.api.AdError;
import com.anythink.core.common.b.n;
import com.anythink.core.common.e.o;
import com.anythink.core.common.u;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/g/m.class */
public class m extends a {

    /* renamed from: a  reason: collision with root package name */
    public static final int f6733a = 1;
    public static final int b = 2;

    /* renamed from: c  reason: collision with root package name */
    public static final int f6734c = 3;
    public static final int d = 4;
    public static final int e = 5;
    public static final int f = 6;
    public static final int g = 7;
    public static final int h = 8;
    public static final int i = 9;
    public static final int j = 10;
    public static final int k = 11;
    public static final int l = 12;
    public static final int p = 13;
    public static final int q = 15;
    public static final int r = 16;
    public static final int s = 18;
    public static final int t = 19;
    public static final int u = 20;
    public static final int v = 21;
    private static final String x = m.class.getSimpleName();
    private List<com.anythink.core.common.e.f> B;
    private com.anythink.core.common.e.f C;
    private int D;
    private Context y;
    boolean w = false;
    private String z = n.a().p();
    private String A = n.a().q();

    public m(Context context, int i2, List<com.anythink.core.common.e.f> list) {
        this.y = context;
        this.D = i2;
        this.B = list;
    }

    private void a(JSONObject jSONObject) {
        if (!this.w || jSONObject == null) {
            return;
        }
        try {
            jSONObject.put(c.U, 1);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.anythink.core.common.g.a
    protected final int a() {
        return 1;
    }

    @Override // com.anythink.core.common.g.a
    protected final Object a(String str) {
        return str.trim();
    }

    @Override // com.anythink.core.common.g.a
    protected final void a(AdError adError) {
        JSONObject jSONObject = new JSONObject();
        Map<String, String> c2 = c();
        if (c2 != null) {
            try {
                for (String str : c2.keySet()) {
                    jSONObject.put(str, c2.get(str));
                }
            } catch (Exception e2) {
            }
        }
        String jSONObject2 = jSONObject.toString();
        this.w = true;
        String g2 = g();
        this.w = false;
        u.a().a(1, b(), jSONObject2, g2, o.a(1000));
    }

    @Override // com.anythink.core.common.g.a
    protected final boolean a(int i2) {
        return false;
    }

    @Override // com.anythink.core.common.g.a
    protected final String b() {
        com.anythink.core.common.e.f fVar = this.C;
        if (fVar != null) {
            return fVar.b.ao;
        }
        com.anythink.core.common.i.a();
        return com.anythink.core.common.i.j();
    }

    @Override // com.anythink.core.common.g.a
    protected final void b(AdError adError) {
        List<com.anythink.core.common.e.f> list = this.B;
        com.anythink.core.common.j.c.a("tk", adError.getPlatformCode(), adError.getPlatformMSG(), b(), (String) null, String.valueOf(list != null ? list.size() : 1), "0");
    }

    @Override // com.anythink.core.common.g.a
    protected final Map<String, String> c() {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Encoding", "gzip");
        hashMap.put("Content-Type", "application/json;charset=utf-8");
        return hashMap;
    }

    @Override // com.anythink.core.common.g.a
    protected final byte[] d() {
        return c(g());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.anythink.core.common.g.a
    public final JSONObject e() {
        JSONObject e2 = super.e();
        JSONObject f2 = super.f();
        e2.put("app_id", this.z);
        e2.put(c.T, this.D);
        Iterator<String> keys = f2.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            e2.put(next, f2.opt(next));
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
                    e2.put("custom", jSONObject);
                }
            } catch (JSONException e3) {
                return e2;
            }
        }
        return e2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.anythink.core.common.g.a
    public final String g() {
        JSONObject jSONObject = new JSONObject();
        String a2 = com.anythink.core.common.k.c.a(e().toString());
        JSONArray jSONArray = new JSONArray();
        List<com.anythink.core.common.e.f> list = this.B;
        if (list != null) {
            for (com.anythink.core.common.e.f fVar : list) {
                JSONObject a3 = fVar.a();
                a(a3);
                jSONArray.put(a3);
            }
        } else {
            com.anythink.core.common.e.f fVar2 = this.C;
            if (fVar2 != null) {
                JSONObject a4 = fVar2.a();
                a(a4);
                jSONArray.put(a4);
            }
        }
        String a5 = com.anythink.core.common.k.c.a(jSONArray.toString());
        String c2 = com.anythink.core.common.k.f.c(this.A + "api_ver=1.0&common=" + a2 + "&data=" + a5);
        try {
            jSONObject.put("common", a2);
            jSONObject.put("data", a5);
            jSONObject.put(c.O, "1.0");
            jSONObject.put("sign", c2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    @Override // com.anythink.core.common.g.a
    protected final String h() {
        return this.z;
    }

    @Override // com.anythink.core.common.g.a
    protected final Context i() {
        return this.y;
    }

    @Override // com.anythink.core.common.g.a
    protected final String j() {
        return this.A;
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
    protected final int m() {
        return 2;
    }

    @Override // com.anythink.core.common.g.a
    protected final boolean o() {
        return true;
    }
}
