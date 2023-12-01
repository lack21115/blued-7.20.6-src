package com.anythink.expressad.foundation.d;

import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.anythink.core.api.IExHandler;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/foundation/d/d.class */
public class d implements com.anythink.expressad.e.b, Serializable {
    public static final String A = "cam_tpl_url";
    public static final String B = "cam_html";
    public static final String C = "cam_tpl_url";
    public static final String D = "cam_html";
    public static final String E = "nscpt";
    public static final String F = "mof_template_url";
    public static final String G = "mof_tplid";
    public static final String H = "req_ext_data";
    public static final String I = "replace_tmp";
    private static final String K = d.class.getSimpleName();
    private static final long L = 1;

    /* renamed from: a  reason: collision with root package name */
    public static final String f4937a = "a";
    public static final String b = "pv_urls";

    /* renamed from: c  reason: collision with root package name */
    public static final String f4938c = "parent_session_id";
    public static final String d = "ad_type";
    public static final String e = "unit_size";
    public static final String f = "html_url";
    public static final String g = "only_impression_url";
    public static final String h = "ads";
    public static final String i = "template";
    public static final String j = "frames";
    public static final String k = "end_screen_url";
    public static final String l = "jm_do";
    public static final String m = "rks";
    public static final String n = "vcn";
    public static final String o = "token_r";
    public static final String p = "encrypt_p";
    public static final String q = "irlfa";
    public static final String r = "csp";
    public static final String s = "do";
    public static final String t = "sh";
    public static final String u = "ia_icon";
    public static final String v = "ia_rst";
    public static final String w = "ia_url";
    public static final String x = "ia_ori";
    public static final String y = "ia_all_ext1";
    public static final String z = "ia_all_ext2";
    public ArrayList<c> J;
    private String N;
    private String O;
    private String P;
    private String Q;
    private String R;
    private int S;
    private String T;
    private int U;
    private String V;
    private String W;
    private String X;
    private String Y;
    private int Z;
    private String aa;
    private String ab;
    private String ac;
    private int ad;
    private List<com.anythink.expressad.out.l> ae;
    private HashMap<String, String> ag;
    private HashMap<String, String> ah;
    private String ai;
    private String aj;
    private String ak;
    private int al;
    private int am;
    private int ao;
    private String ap;
    private String M = "";
    private StringBuffer af = new StringBuffer();
    private String an = "";

    private String A() {
        return this.aa;
    }

    private String B() {
        return this.ab;
    }

    private String C() {
        return this.ac;
    }

    private ArrayList<c> D() {
        return this.J;
    }

    private int E() {
        return this.ad;
    }

    public static d a(String str) {
        try {
            return b(new JSONObject(str), "");
        } catch (Throwable th) {
            return null;
        }
    }

    private static d a(JSONObject jSONObject) {
        return b(jSONObject, "");
    }

    private static d a(JSONObject jSONObject, String str) {
        return b(jSONObject, str);
    }

    private static Object a(Object obj) {
        Object obj2 = obj;
        if (obj == null) {
            obj2 = "";
        }
        return obj2;
    }

    private void a(int i2) {
        this.S = i2;
    }

    private void a(ArrayList<c> arrayList) {
        this.J = arrayList;
    }

    private void a(HashMap<String, String> hashMap) {
        this.ag = hashMap;
    }

    private void a(List<com.anythink.expressad.out.l> list) {
        this.ae = list;
    }

    private static d b(JSONObject jSONObject) {
        return b(jSONObject, "");
    }

    private static d b(JSONObject jSONObject, String str) {
        d dVar;
        d dVar2;
        d dVar3;
        int optInt;
        String optString;
        int optInt2;
        String jSONObject2;
        ArrayList arrayList;
        JSONArray optJSONArray;
        JSONArray optJSONArray2;
        if (jSONObject != null) {
            try {
                dVar2 = new d();
                dVar3 = dVar2;
                try {
                    String optString2 = jSONObject.optString(m);
                    if (!TextUtils.isEmpty(optString2)) {
                        JSONObject jSONObject3 = new JSONObject(optString2);
                        Iterator<String> keys = jSONObject3.keys();
                        HashMap<String, String> hashMap = new HashMap<>();
                        while (keys != null && keys.hasNext()) {
                            String next = keys.next();
                            hashMap.put(next, jSONObject3.optString(next));
                        }
                        dVar2.ag = hashMap;
                    }
                    if (!TextUtils.isEmpty(str)) {
                        HashMap<String, String> hashMap2 = new HashMap<>();
                        hashMap2.put("encrypt_p", "");
                        hashMap2.put(q, "");
                        dVar2.ah = hashMap2;
                    }
                    JSONObject optJSONObject = jSONObject.optJSONObject(H);
                    optInt = jSONObject.optInt(E, 1);
                    optString = jSONObject.optString(F, "");
                    optInt2 = jSONObject.optInt(G, 0);
                    jSONObject2 = optJSONObject != null ? optJSONObject.toString() : "";
                    new JSONArray();
                    JSONArray optJSONArray3 = jSONObject.optJSONArray("pv_urls");
                    if (optJSONArray3 != null && optJSONArray3.length() > 0) {
                        ArrayList arrayList2 = new ArrayList(optJSONArray3.length());
                        int i2 = 0;
                        while (true) {
                            int i3 = i2;
                            arrayList = arrayList2;
                            if (i3 >= optJSONArray3.length()) {
                                break;
                            }
                            arrayList2.add(optJSONArray3.getString(i3));
                            i2 = i3 + 1;
                        }
                    } else {
                        arrayList = null;
                    }
                    com.anythink.expressad.foundation.c.a.a.a().a(jSONObject.optJSONObject(I));
                    dVar2.X = jSONObject.optString("a");
                    dVar2.Y = jSONObject.optString("parent_session_id");
                    dVar2.Z = jSONObject.optInt("ad_type");
                    dVar2.aa = jSONObject.optString(e);
                    dVar2.ab = jSONObject.optString(f);
                    dVar2.ac = jSONObject.optString(g);
                    dVar2.ad = jSONObject.optInt("template");
                    dVar2.ao = jSONObject.optInt(l);
                    dVar2.R = jSONObject.optString("ia_icon");
                    dVar2.S = jSONObject.optInt("ia_rst");
                    dVar2.T = jSONObject.optString("ia_url");
                    dVar2.U = jSONObject.optInt("ia_ori");
                    dVar2.V = jSONObject.optString(y);
                    dVar2.W = jSONObject.optString(z);
                    dVar2.al = jSONObject.optInt("vcn");
                    dVar2.am = jSONObject.optInt("token_r");
                    dVar2.an = jSONObject.optString("encrypt_p");
                    optJSONArray = jSONObject.optJSONArray(h);
                    dVar3 = dVar2;
                    optJSONArray2 = jSONObject.optJSONArray(j);
                } catch (Exception e2) {
                }
            } catch (Exception e3) {
                dVar = null;
            }
            try {
                if (optJSONArray2 == null || optJSONArray2.length() <= 0) {
                    String str2 = jSONObject2;
                    if (optJSONArray != null && optJSONArray.length() > 0) {
                        ArrayList<c> arrayList3 = new ArrayList<>();
                        for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                            c a2 = c.a(optJSONArray.optJSONObject(i4), jSONObject.optString(g), jSONObject.optString(f), jSONObject.optString(k), false, dVar2, str);
                            if (a2 != null) {
                                a2.k(optInt2);
                                a2.r(optString);
                                a2.j(optInt);
                                a2.a((List<String>) arrayList);
                                a2.s(str2);
                                a2.d(dVar2.s());
                                a2.c(dVar2.t());
                                a2.c(dVar2.an);
                                arrayList3.add(a2);
                            } else {
                                dVar2.M = "parse campaign error ,campaign is null";
                            }
                        }
                        dVar2.J = arrayList3;
                    }
                    dVar = dVar2;
                } else {
                    ArrayList arrayList4 = new ArrayList();
                    int i5 = 0;
                    d dVar4 = dVar2;
                    while (true) {
                        dVar3 = dVar4;
                        if (i5 >= optJSONArray2.length()) {
                            dVar4.ae = arrayList4;
                            return dVar4;
                        }
                        d dVar5 = dVar4;
                        JSONObject optJSONObject2 = optJSONArray2.optJSONObject(i5);
                        d dVar6 = dVar4;
                        JSONArray jSONArray = optJSONObject2.getJSONArray(h);
                        d dVar7 = dVar4;
                        ArrayList arrayList5 = new ArrayList();
                        int i6 = 0;
                        String str3 = jSONObject2;
                        while (i6 < jSONArray.length()) {
                            d dVar8 = dVar4;
                            JSONObject optJSONObject3 = jSONArray.optJSONObject(i6);
                            d dVar9 = dVar4;
                            d dVar10 = dVar4;
                            d dVar11 = dVar4;
                            d dVar12 = dVar4;
                            c a3 = c.a(optJSONObject3, jSONObject.optString(g), jSONObject.optString(f), jSONObject.optString(k), false, dVar4, str);
                            if (a3 != null) {
                                a3.i(dVar12.T);
                                a3.h(dVar12.U);
                                a3.g(dVar12.S);
                                a3.h(dVar12.R);
                                a3.f(jSONObject.optInt("ad_type"));
                                a3.f(jSONObject.optString(c.aS));
                                a3.g(jSONObject.optString(c.aT));
                                a3.d(dVar12.s());
                                a3.c(dVar12.t());
                                a3.c(dVar12.an);
                                a3.k(optInt2);
                                a3.r(optString);
                                a3.j(optInt);
                                a3.a((List<String>) arrayList);
                                a3.s(str3);
                                arrayList5.add(a3);
                            } else {
                                dVar12.M = "parse campaign error ,campaign is null";
                            }
                            i6++;
                            dVar4 = dVar12;
                        }
                        com.anythink.expressad.out.l lVar = new com.anythink.expressad.out.l();
                        d dVar13 = dVar4;
                        lVar.b(jSONObject.optString("parent_session_id"));
                        d dVar14 = dVar4;
                        lVar.a(jSONObject.optString("a"));
                        d dVar15 = dVar4;
                        lVar.a(arrayList5);
                        d dVar16 = dVar4;
                        lVar.a(optJSONObject2.optInt("template"));
                        d dVar17 = dVar4;
                        arrayList4.add(lVar);
                        i5++;
                        jSONObject2 = str3;
                    }
                }
            } catch (Exception e4) {
                dVar = dVar3;
                com.anythink.expressad.foundation.h.o.d(K, "parse campaign unit exception");
                return dVar;
            }
        } else {
            dVar = null;
        }
        return dVar;
    }

    private void b(int i2) {
        this.U = i2;
    }

    private void b(String str) {
        this.M = str;
    }

    private void b(HashMap<String, String> hashMap) {
        this.ah = hashMap;
    }

    private void c(int i2) {
        this.al = i2;
    }

    private void c(String str) {
        this.N = str;
    }

    private void d(int i2) {
        this.am = i2;
    }

    private void d(String str) {
        this.O = str;
    }

    private void e(int i2) {
        this.ao = i2;
    }

    private void e(String str) {
        this.P = str;
    }

    private void f(int i2) {
        this.Z = i2;
    }

    private void f(String str) {
        this.Q = str;
    }

    private String g() {
        return this.M;
    }

    private void g(int i2) {
        this.ad = i2;
    }

    private void g(String str) {
        this.R = str;
    }

    private String h() {
        return this.N;
    }

    private void h(String str) {
        this.T = str;
    }

    private String i() {
        return this.O;
    }

    private void i(String str) {
        this.V = str;
    }

    private String j() {
        return this.P;
    }

    private void j(String str) {
        this.W = str;
    }

    private String k() {
        return this.Q;
    }

    private void k(String str) {
        this.an = str;
    }

    private String l() {
        return this.R;
    }

    private void l(String str) {
        this.ai = str;
    }

    private int m() {
        return this.S;
    }

    private void m(String str) {
        this.aj = str;
    }

    private String n() {
        return this.T;
    }

    private void n(String str) {
        this.ak = str;
    }

    private int o() {
        return this.U;
    }

    private void o(String str) {
        this.X = str;
    }

    private String p() {
        return this.V;
    }

    private void p(String str) {
        this.Y = str;
    }

    private String q() {
        return this.W;
    }

    private void q(String str) {
        this.aa = str;
    }

    private String r() {
        return this.an;
    }

    private void r(String str) {
        this.ab = str;
    }

    private int s() {
        int i2 = this.al;
        if (i2 > 1) {
            return i2;
        }
        return 1;
    }

    private void s(String str) {
        this.ac = str;
    }

    private int t() {
        int i2 = this.am;
        if (i2 == 1) {
            return i2;
        }
        return 0;
    }

    private String u() {
        return this.ai;
    }

    private String v() {
        return this.aj;
    }

    private String w() {
        return this.ak;
    }

    private int x() {
        return this.ao;
    }

    private List<com.anythink.expressad.out.l> y() {
        return this.ae;
    }

    private String z() {
        return this.Y;
    }

    public final HashMap<String, String> a() {
        return this.ag;
    }

    public final HashMap<String, String> b() {
        return this.ah;
    }

    public final String c() {
        return this.X;
    }

    public final int d() {
        return this.Z;
    }

    public final String e() {
        StringBuffer stringBuffer = this.af;
        if (stringBuffer == null || stringBuffer.length() <= 0) {
            try {
                String f2 = com.anythink.core.common.k.d.f();
                String c2 = com.anythink.core.common.k.d.c(com.anythink.core.common.b.n.a().g());
                String b2 = com.anythink.core.common.k.d.b(com.anythink.core.common.b.n.a().g());
                com.anythink.core.common.b.n.a().g();
                int a2 = com.anythink.expressad.foundation.h.k.a();
                StringBuffer stringBuffer2 = this.af;
                stringBuffer2.append(this.Z);
                stringBuffer2.append("|");
                stringBuffer2.append(a((Object) "1"));
                stringBuffer2.append("|");
                stringBuffer2.append(a((Object) Build.VERSION.RELEASE));
                stringBuffer2.append("|");
                stringBuffer2.append(a((Object) com.anythink.expressad.out.b.f5227a));
                stringBuffer2.append("|");
                stringBuffer2.append(a((Object) com.anythink.core.common.k.d.a()));
                stringBuffer2.append("|");
                stringBuffer2.append(a((Object) (com.anythink.expressad.foundation.h.k.e(com.anythink.core.common.b.n.a().g()) + "x" + com.anythink.expressad.foundation.h.k.f(com.anythink.core.common.b.n.a().g()))));
                stringBuffer2.append("|");
                stringBuffer2.append(a(Integer.valueOf(com.anythink.expressad.foundation.h.k.b(com.anythink.expressad.foundation.b.a.b().d()))));
                stringBuffer2.append("|");
                stringBuffer2.append(a((Object) com.anythink.core.common.k.d.f(com.anythink.expressad.foundation.b.a.b().d())));
                stringBuffer2.append("|");
                stringBuffer2.append(a((Object) String.valueOf(a2)));
                stringBuffer2.append("|");
                stringBuffer2.append(a((Object) b2));
                stringBuffer2.append(a((Object) c2));
                stringBuffer2.append("|");
                stringBuffer2.append(a((Object) "at_device1"));
                stringBuffer2.append("|");
                stringBuffer2.append(a((Object) "at_device2"));
                stringBuffer2.append("|");
                stringBuffer2.append(a((Object) com.anythink.core.common.k.d.d(com.anythink.core.common.b.n.a().g())));
                stringBuffer2.append("|");
                stringBuffer2.append(a((Object) f2));
                stringBuffer2.append("|");
                stringBuffer2.append(a((Object) ""));
                stringBuffer2.append("|");
                stringBuffer2.append(a((Object) com.anythink.core.common.k.d.b()));
                stringBuffer2.append("|");
                stringBuffer2.append(a((Object) ""));
                stringBuffer2.append("||");
                stringBuffer2.append(a((Object) ""));
                stringBuffer2.append("|");
                stringBuffer2.append(a((Object) (com.anythink.core.common.b.n.a().y() + "," + com.anythink.core.common.b.n.a().z())));
                stringBuffer2.append("|");
                this.af = stringBuffer2;
                IExHandler b3 = com.anythink.core.common.b.n.a().b();
                if (b3 != null) {
                    return b3.fillCDataParam(this.af.toString());
                }
            } catch (Throwable th) {
                com.anythink.expressad.foundation.h.o.b(K, th.getMessage(), th);
            }
            String stringBuffer3 = this.af.toString();
            stringBuffer3.replaceAll("at_device1", "");
            stringBuffer3.replaceAll("at_device2", "");
            return stringBuffer3;
        }
        return this.af.toString();
    }

    public final String f() {
        try {
            if (TextUtils.isEmpty(this.ap)) {
                if (TextUtils.isEmpty(this.ac)) {
                    return "";
                }
                Uri parse = Uri.parse(this.ac);
                if (parse != null) {
                    this.ap = parse.getQueryParameter("k");
                }
                return this.ap;
            }
            return this.ap;
        } catch (Exception e2) {
            return "";
        }
    }
}
