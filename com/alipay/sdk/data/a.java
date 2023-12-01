package com.alipay.sdk.data;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.sdk.util.j;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-6737240-dex2jar.jar:com/alipay/sdk/data/a.class */
public final class a {
    private static a F;
    private static final String b = "DynCon";
    private static final int c = 10000;
    private static final String d = "https://h5.m.taobao.com/mlapp/olist.html";
    private static final int e = 10;
    private static final boolean f = true;
    private static final boolean g = true;
    private static final boolean h = false;
    private static final boolean i = false;
    private static final int j = 1000;
    private static final int k = 20000;
    private static final String l = "alipay_cashier_dynamic_config";
    private static final String m = "timeout";
    private static final String n = "h5_port_degrade";
    private static final String o = "st_sdk_config";
    private static final String p = "tbreturl";
    private static final String q = "launchAppSwitch";
    private static final String r = "configQueryInterval";
    private static final String s = "deg_log_mcgw";
    private static final String t = "deg_start_srv_first";
    private static final String u = "scheme_pay_2";
    private static final String v = "intercept_batch";
    private int w = 10000;
    private boolean x = false;
    private String y = d;
    private int z = 10;
    private boolean A = true;
    private boolean B = true;
    public boolean a = false;
    private boolean C = false;
    private boolean D = false;
    private List<C0008a> E = null;

    /* renamed from: com.alipay.sdk.data.a$a  reason: collision with other inner class name */
    /* loaded from: source-6737240-dex2jar.jar:com/alipay/sdk/data/a$a.class */
    public static final class C0008a {
        public final String a;
        public final int b;
        public final String c;

        public C0008a(String str, int i, String str2) {
            this.a = str;
            this.b = i;
            this.c = str2;
        }

        public static C0008a a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            return new C0008a(jSONObject.optString("pn"), jSONObject.optInt("v", 0), jSONObject.optString("pk"));
        }

        public static List<C0008a> a(JSONArray jSONArray) {
            if (jSONArray == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int length = jSONArray.length();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return arrayList;
                }
                C0008a a = a(jSONArray.optJSONObject(i2));
                if (a != null) {
                    arrayList.add(a);
                }
                i = i2 + 1;
            }
        }

        public static JSONArray a(List<C0008a> list) {
            if (list == null) {
                return null;
            }
            JSONArray jSONArray = new JSONArray();
            for (C0008a c0008a : list) {
                jSONArray.put(a(c0008a));
            }
            return jSONArray;
        }

        public static JSONObject a(C0008a c0008a) {
            if (c0008a == null) {
                return null;
            }
            try {
                return new JSONObject().put("pn", c0008a.a).put("v", c0008a.b).put("pk", c0008a.c);
            } catch (JSONException e) {
                com.alipay.sdk.util.c.a(e);
                return null;
            }
        }

        public String toString() {
            return String.valueOf(a(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.alipay.sdk.sys.a aVar) {
        try {
            j.a(aVar, com.alipay.sdk.sys.b.a().b(), l, l().toString());
        } catch (Exception e2) {
            com.alipay.sdk.util.c.a(e2);
        }
    }

    private void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            a(new JSONObject(str));
        } catch (Throwable th) {
            com.alipay.sdk.util.c.a(th);
        }
    }

    private void a(JSONObject jSONObject) {
        this.w = jSONObject.optInt("timeout", 10000);
        this.x = jSONObject.optBoolean(n, false);
        this.y = jSONObject.optString(p, d).trim();
        this.z = jSONObject.optInt(r, 10);
        this.E = C0008a.a(jSONObject.optJSONArray(q));
        this.A = jSONObject.optBoolean(u, true);
        this.B = jSONObject.optBoolean(v, true);
        this.C = jSONObject.optBoolean(s, false);
        this.D = jSONObject.optBoolean(t, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject(o);
            if (optJSONObject != null) {
                a(optJSONObject);
            } else {
                com.alipay.sdk.util.c.c(b, "empty config");
            }
        } catch (Throwable th) {
            com.alipay.sdk.util.c.a(th);
        }
    }

    public static a j() {
        if (F == null) {
            a aVar = new a();
            F = aVar;
            aVar.k();
        }
        return F;
    }

    private void k() {
        a(j.b(com.alipay.sdk.sys.a.a(), com.alipay.sdk.sys.b.a().b(), l, null));
    }

    private JSONObject l() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("timeout", a());
        jSONObject.put(n, b());
        jSONObject.put(p, e());
        jSONObject.put(r, f());
        jSONObject.put(q, C0008a.a(i()));
        jSONObject.put(u, c());
        jSONObject.put(v, d());
        jSONObject.put(s, g());
        jSONObject.put(t, h());
        return jSONObject;
    }

    public int a() {
        int i2 = this.w;
        if (i2 < 1000 || i2 > 20000) {
            com.alipay.sdk.util.c.a(b, "time(def) = 10000");
            return 10000;
        }
        com.alipay.sdk.util.c.a(b, "time = " + this.w);
        return this.w;
    }

    public void a(com.alipay.sdk.sys.a aVar, Context context) {
        new Thread(new b(this, aVar, context)).start();
    }

    public void a(boolean z) {
        this.a = z;
    }

    public boolean b() {
        return this.x;
    }

    public boolean c() {
        return this.A;
    }

    public boolean d() {
        return this.B;
    }

    public String e() {
        return this.y;
    }

    public int f() {
        return this.z;
    }

    public boolean g() {
        return this.C;
    }

    public boolean h() {
        return this.D;
    }

    public List<C0008a> i() {
        return this.E;
    }
}
