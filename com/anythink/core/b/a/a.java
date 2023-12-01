package com.anythink.core.b.a;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.AdError;
import com.anythink.core.c.d;
import com.anythink.core.c.e;
import com.anythink.core.common.b.n;
import com.anythink.core.common.k.c;
import com.anythink.core.common.p;
import com.blued.android.chat.core.pack.ReqAckPackage;
import com.efs.sdk.base.Constants;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/b/a/a.class */
public final class a extends com.anythink.core.common.g.a {
    public static final int a = 0;
    public static final int b = 1;
    public static final String c = "ex_pkg";
    public static final String d = "unit_ids";
    String e;
    String f;
    String g;
    String h;
    String i;
    String j;
    String k;
    int l;
    int p;
    int q;
    String r;
    String s;
    String t;
    private int u;
    private final String v = d.a.j;
    private final String w = ATAdConst.NETWORK_CUSTOM_KEY.NETWORK_REQUEST_ID;
    private final String x = "ch_info";
    private final String y = "wf";
    private final String z = "np";
    private final String A = "hb_size";
    private final String B = "last_wf";
    private final String C = "co";
    private final String D = d.a.T;
    private final String E = "debug";

    public a(String str, String str2, String str3, List<JSONObject> list, int i) {
        this.u = 0;
        this.e = str3;
        this.h = str;
        this.i = str2;
        this.u = i;
        JSONArray jSONArray = new JSONArray();
        for (JSONObject jSONObject : list) {
            jSONArray.put(jSONObject);
        }
        this.f = c.a(jSONArray.toString().getBytes());
        d a2 = e.a(n.a().g()).a(str2);
        if (a2 != null) {
            this.l = a2.O();
            this.p = a2.ae();
        }
    }

    private void a(String str, String str2, String str3) {
        if (str != null) {
            this.g = c.a(str.getBytes());
        }
        if (!TextUtils.isEmpty(str2) && !TextUtils.equals("[]", str2)) {
            this.j = c.a(str2.getBytes());
        }
        if (TextUtils.isEmpty(str3) || TextUtils.equals("[]", str3)) {
            return;
        }
        this.k = c.a(str3.getBytes());
    }

    private void d(int i) {
        this.q = i;
    }

    @Override // com.anythink.core.common.g.a
    public final int a() {
        return 1;
    }

    @Override // com.anythink.core.common.g.a
    public final Object a(String str) {
        try {
            return new JSONObject(str);
        } catch (Exception e) {
            return null;
        }
    }

    @Override // com.anythink.core.common.g.a
    public final void a(AdError adError) {
    }

    public final void a(b bVar) {
        if (bVar.a != null) {
            this.g = c.a(bVar.a.getBytes());
        }
        this.q = bVar.f;
        if (!TextUtils.isEmpty(bVar.b) && !TextUtils.equals("[]", bVar.b)) {
            this.j = c.a(bVar.b.getBytes());
        }
        if (!TextUtils.isEmpty(bVar.c) && !TextUtils.equals("[]", bVar.c)) {
            this.k = c.a(bVar.c.getBytes());
        }
        if (!TextUtils.isEmpty(bVar.d) && !TextUtils.equals("[]", bVar.d)) {
            this.r = c.a(bVar.d.getBytes());
        }
        if (!TextUtils.isEmpty(bVar.e) && !TextUtils.equals("[]", bVar.e)) {
            this.s = c.a(bVar.e.getBytes());
        }
        this.t = "";
        if (TextUtils.isEmpty(bVar.g)) {
            return;
        }
        this.t = c.a(bVar.g.getBytes());
    }

    @Override // com.anythink.core.common.g.a
    public final boolean a(int i) {
        return false;
    }

    @Override // com.anythink.core.common.g.a
    public final String b() {
        return this.h;
    }

    @Override // com.anythink.core.common.g.a
    public final void b(AdError adError) {
    }

    @Override // com.anythink.core.common.g.a
    public final Map<String, String> c() {
        HashMap hashMap = new HashMap();
        if (this.u == 0) {
            hashMap.put("Accept-Encoding", Constants.CP_GZIP);
        }
        hashMap.put("Content-Type", "application/json;charset=utf-8");
        return hashMap;
    }

    @Override // com.anythink.core.common.g.a
    public final byte[] d() {
        return g().getBytes();
    }

    @Override // com.anythink.core.common.g.a
    public final JSONObject e() {
        JSONObject e = super.e();
        try {
            e.put("app_id", n.a().p());
            e.put("pl_id", this.i);
            e.put(ReqAckPackage.REQ_RESPONSE_KEY.SESSION_ID, n.a().g(this.i));
            e.put("t_g_id", this.l);
            e.put("gro_id", this.p);
            String y = n.a().y();
            if (!TextUtils.isEmpty(y)) {
                e.put("sy_id", y);
            }
            String z = n.a().z();
            if (TextUtils.isEmpty(z)) {
                n.a().j(n.a().x());
                e.put("bk_id", n.a().x());
            } else {
                e.put("bk_id", z);
            }
            if (n.a().b() != null) {
                e.put("deny", com.anythink.core.common.k.d.o(n.a().g()));
            }
            if (this.u == 0) {
                e.put("misk_spt", p.a().c());
                p.a();
                e.put("misk_pt_det", p.b());
            }
            e.put(com.anythink.core.common.g.c.ap, com.anythink.core.common.n.a().c());
            JSONObject a2 = com.anythink.core.common.g.c.a(this.i);
            if (a2 != null) {
                e.put("customs", a2);
            }
            com.anythink.core.common.g.c.a(e);
            return e;
        } catch (Exception e2) {
            return e;
        }
    }

    @Override // com.anythink.core.common.g.a
    public final JSONObject f() {
        JSONObject f = super.f();
        try {
            if (n.a().b() != null) {
                f.put("btts", com.anythink.core.common.k.d.g());
            }
            return f;
        } catch (JSONException e) {
            return f;
        }
    }

    @Override // com.anythink.core.common.g.a
    public final String g() {
        HashMap hashMap = new HashMap();
        String a2 = c.a(e().toString());
        String a3 = c.a(f().toString());
        hashMap.put(com.anythink.core.common.g.c.W, a2);
        hashMap.put(com.anythink.core.common.g.c.X, a3);
        hashMap.put(d.a.j, this.f);
        hashMap.put(ATAdConst.NETWORK_CUSTOM_KEY.NETWORK_REQUEST_ID, this.e);
        int i = this.q;
        if (i > 0) {
            hashMap.put("hb_size", Integer.valueOf(i));
        }
        if (this.u == 0) {
            if (!TextUtils.isEmpty(this.g)) {
                hashMap.put("ch_info", this.g);
            }
            if (!TextUtils.isEmpty(this.j)) {
                hashMap.put("wf", this.j);
            }
            if (!TextUtils.isEmpty(this.k)) {
                hashMap.put("np", this.k);
            }
            if (!TextUtils.isEmpty(this.r)) {
                hashMap.put("last_wf", this.r);
            }
            if (!TextUtils.isEmpty(this.s)) {
                hashMap.put("co", this.s);
            }
            hashMap.put(d.a.T, this.t);
            if (n.a().l() != null) {
                hashMap.put(c, c.a(n.a().l().toString()));
            }
            if (n.a().A() && n.a().u()) {
                hashMap.put("debug", 1);
            }
        }
        Set<String> keySet = hashMap.keySet();
        JSONObject jSONObject = new JSONObject();
        try {
            for (String str : keySet) {
                jSONObject.put(str, hashMap.get(str));
            }
            return jSONObject.toString();
        } catch (Exception e) {
            return null;
        } catch (OutOfMemoryError e2) {
            System.gc();
            return null;
        }
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

    @Override // com.anythink.core.common.g.a
    public final int m() {
        return 2;
    }
}
