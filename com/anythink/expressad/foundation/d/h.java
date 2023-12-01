package com.anythink.expressad.foundation.d;

import android.net.Uri;
import android.text.TextUtils;
import com.anythink.expressad.a.c;
import com.anythink.expressad.foundation.h.t;
import java.io.Serializable;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/foundation/d/h.class */
public class h extends com.anythink.expressad.out.j implements com.anythink.expressad.e.b, Serializable {
    public static final String cA = "adv_id";
    public static final String cB = "ttc_type";
    public static final String cC = "ttc_ct2";
    public static final String cD = "gh_id";
    public static final String cE = "gh_path";
    public static final String cF = "bind_id";
    public static final String cG = "mark";
    public static final String cH = "isPost";
    public static final int cI = 604800;
    public static final int cJ = 1800;
    public static final String cK = "apk_download_start";
    public static final String cL = "apk_download_end";
    public static final String cM = "apk_install";
    public static final String cN = "loopback";
    public static final String cO = "domain";
    public static final String cP = "key";
    public static final String cQ = "value";
    public static final String co = h.class.getSimpleName();
    public static final String cp = "apk_alt";
    public static final String cq = "disableApkAlt";
    public static final String cr = "apk_info";
    public static final String cs = "ntbarpt";
    public static final String ct = "ntbarpasbl";
    public static final String cu = "atat_type";
    public static final String cv = "akdlui";
    public static final String cw = "ttc";
    public static final String cx = "ttc_ct";
    public static final String cy = "ttc_pe";
    public static final String cz = "ttc_po";
    private static final long l = 1;
    private a d;
    private String i;
    private String j;
    private String k;
    private int n;
    private String o;
    private int p;
    private Map<String, String> q;
    private String r;
    private String s;
    private int t;
    private int u;
    private c.b v;

    /* renamed from: a  reason: collision with root package name */
    private int f7785a = 0;
    private int b = 0;

    /* renamed from: c  reason: collision with root package name */
    private String f7786c = "";
    private int e = 0;
    private int f = 0;
    private int g = 0;
    private String h = "";
    private boolean m = false;

    public static c a(JSONObject jSONObject, c cVar) {
        if (jSONObject != null) {
            try {
                ((h) cVar).m = jSONObject.optBoolean(cw);
                ((h) cVar).n = jSONObject.optInt(cx, 604800);
                ((h) cVar).s = jSONObject.optString(cA);
                ((h) cVar).t = jSONObject.optInt("ttc_type", 3);
                ((h) cVar).u = jSONObject.optInt(cC, 1800);
                cVar.a(System.currentTimeMillis());
                cVar.m(jSONObject.optString(d.f));
                cVar.n(jSONObject.optString(d.k));
                ((h) cVar).o = jSONObject.optString(cG);
                ((h) cVar).p = jSONObject.optInt(cH);
                try {
                    if (jSONObject.has("loopback")) {
                        String optString = jSONObject.optString("loopback");
                        if (!TextUtils.isEmpty(optString)) {
                            ((h) cVar).r = optString;
                            ((h) cVar).q = h(optString);
                        }
                    }
                } catch (Exception e) {
                    com.anythink.expressad.foundation.h.o.d("", "loopback parser error");
                }
                String optString2 = jSONObject.optString(cD);
                if (!TextUtils.isEmpty(optString2)) {
                    ((h) cVar).i = optString2;
                    String optString3 = jSONObject.optString(cE);
                    if (!TextUtils.isEmpty(optString3)) {
                        ((h) cVar).j = com.anythink.expressad.foundation.h.j.b(optString3);
                    }
                    ((h) cVar).k = jSONObject.optString(cF);
                }
                ((h) cVar).f7785a = jSONObject.optInt(cp, 0);
                ((h) cVar).b = jSONObject.optInt(cq, 0);
                ((h) cVar).d = a.a(jSONObject.optString(cr));
                ((h) cVar).f = jSONObject.optInt(ct, 0);
                ((h) cVar).e = jSONObject.optInt(cs, 0);
                ((h) cVar).g = jSONObject.optInt(cu, 0);
                ((h) cVar).h = jSONObject.optString(cv, "");
                return cVar;
            } catch (Exception e2) {
                e2.printStackTrace();
                String str = co;
                com.anythink.expressad.foundation.h.o.d(str, "parse campaign json exception: " + e2.getLocalizedMessage());
                return cVar;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String a(d dVar, c cVar, String str) {
        String str2 = str;
        if (dVar != null) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            String str3 = str;
            try {
                HashMap<String, String> a2 = dVar.a();
                String str4 = str;
                if (a2 != null) {
                    a2.entrySet().iterator();
                    Iterator<Map.Entry<String, String>> it = a2.entrySet().iterator();
                    while (true) {
                        str4 = str;
                        if (!it.hasNext()) {
                            break;
                        }
                        String str5 = str;
                        Map.Entry<String, String> next = it.next();
                        String str6 = str;
                        String key = next.getKey();
                        String str7 = str;
                        String value = next.getValue();
                        String str8 = str;
                        StringBuilder sb = new StringBuilder("\\{");
                        String str9 = str;
                        sb.append(key);
                        String str10 = str;
                        sb.append("\\}");
                        String str11 = str;
                        str = str.replaceAll(sb.toString(), value);
                    }
                }
                HashMap<String, String> z = cVar.z();
                String str12 = str4;
                if (z != null) {
                    z.entrySet().iterator();
                    String str13 = str4;
                    Iterator<Map.Entry<String, String>> it2 = z.entrySet().iterator();
                    while (true) {
                        str12 = str4;
                        if (!it2.hasNext()) {
                            break;
                        }
                        String str14 = str4;
                        Map.Entry<String, String> next2 = it2.next();
                        String str15 = str4;
                        String key2 = next2.getKey();
                        String str16 = str4;
                        String value2 = next2.getValue();
                        String str17 = str4;
                        StringBuilder sb2 = new StringBuilder("\\{");
                        String str18 = str4;
                        sb2.append(key2);
                        String str19 = str4;
                        sb2.append("\\}");
                        String str20 = str4;
                        str4 = str4.replaceAll(sb2.toString(), value2);
                    }
                }
                HashMap<String, String> b = dVar.b();
                String str21 = str12;
                if (b != null) {
                    Iterator<Map.Entry<String, String>> it3 = b.entrySet().iterator();
                    while (true) {
                        str21 = str12;
                        if (!it3.hasNext()) {
                            break;
                        }
                        String str22 = str12;
                        Map.Entry<String, String> next3 = it3.next();
                        String str23 = str12;
                        String key3 = next3.getKey();
                        String str24 = str12;
                        String value3 = next3.getValue();
                        String str25 = str12;
                        StringBuilder sb3 = new StringBuilder("\\{");
                        String str26 = str12;
                        sb3.append(key3);
                        String str27 = str12;
                        sb3.append("\\}");
                        String str28 = str12;
                        str12 = str12.replaceAll(sb3.toString(), value3);
                    }
                }
                String replaceAll = str21.replaceAll("\\{c\\}", URLEncoder.encode(dVar.e(), "utf-8"));
                Matcher matcher = Pattern.compile("=\\{.*?\\}").matcher(replaceAll);
                while (true) {
                    str3 = replaceAll;
                    str2 = replaceAll;
                    if (!matcher.find()) {
                        break;
                    }
                    String str29 = replaceAll;
                    replaceAll = replaceAll.replace(matcher.group(0), "=");
                }
            } catch (Throwable th) {
                com.anythink.expressad.foundation.h.o.b(co, th.getMessage(), th);
                str2 = str3;
            }
        }
        return str2;
    }

    private Map<String, String> a() {
        return this.q;
    }

    private void a(int i) {
        this.b = i;
    }

    private void a(a aVar) {
        this.d = aVar;
    }

    private void a(String str) {
        this.h = str;
    }

    private void a(Map<String, String> map) {
        this.q = map;
    }

    private void a(boolean z) {
        this.m = z;
    }

    public static c b(JSONObject jSONObject, c cVar) {
        if (jSONObject != null) {
            try {
                ((h) cVar).m = jSONObject.optBoolean(cw);
                ((h) cVar).n = jSONObject.optInt(cx, 604800);
                ((h) cVar).s = jSONObject.optString(cA);
                ((h) cVar).t = jSONObject.optInt("ttc_type", 3);
                ((h) cVar).u = jSONObject.optInt(cC, 1800);
                ((h) cVar).o = jSONObject.optString(cG);
                ((h) cVar).p = jSONObject.optInt(cH);
                try {
                    if (jSONObject.has("loopback")) {
                        String optString = jSONObject.optString("loopback");
                        if (!TextUtils.isEmpty(optString)) {
                            ((h) cVar).r = optString;
                            ((h) cVar).q = h(optString);
                        }
                    }
                } catch (Exception e) {
                    com.anythink.expressad.foundation.h.o.d("", "loopback parser error");
                }
                String optString2 = jSONObject.optString(cD);
                if (!TextUtils.isEmpty(optString2)) {
                    ((h) cVar).i = optString2;
                    String optString3 = jSONObject.optString(cE);
                    if (!TextUtils.isEmpty(optString3)) {
                        ((h) cVar).j = com.anythink.expressad.foundation.h.j.b(optString3);
                    }
                    ((h) cVar).k = jSONObject.optString(cF);
                }
                cVar.e(jSONObject.optString("cam_html"));
                cVar.b(jSONObject.optString("cam_html"));
                ((h) cVar).f7785a = jSONObject.optInt(cp, 0);
                ((h) cVar).b = jSONObject.optInt(cq, 0);
                ((h) cVar).d = a.a(jSONObject.optString(cr));
                ((h) cVar).f = jSONObject.optInt(ct, 0);
                ((h) cVar).e = jSONObject.optInt(cs, 0);
                ((h) cVar).g = jSONObject.optInt(cu, 0);
                ((h) cVar).h = jSONObject.optString(cv, "");
                return cVar;
            } catch (Exception e2) {
                e2.printStackTrace();
                String str = co;
                com.anythink.expressad.foundation.h.o.d(str, "parse campaign json exception: " + e2.getLocalizedMessage());
                return cVar;
            }
        }
        return null;
    }

    private String b() {
        return this.r;
    }

    private void b(int i) {
        this.f7785a = i;
    }

    private void b(String str) {
        this.i = str;
    }

    private static JSONObject c(JSONObject jSONObject, c cVar) {
        if (cVar == null) {
            return jSONObject;
        }
        jSONObject.put(cw, ((h) cVar).m);
        jSONObject.put(cx, ((h) cVar).n);
        jSONObject.put(cA, ((h) cVar).s);
        jSONObject.put("ttc_type", ((h) cVar).t);
        jSONObject.put(cC, ((h) cVar).u);
        jSONObject.put(cD, ((h) cVar).i);
        jSONObject.put(cE, com.anythink.expressad.foundation.h.j.a(((h) cVar).j));
        jSONObject.put(cF, ((h) cVar).k);
        jSONObject.put(cp, ((h) cVar).f7785a);
        jSONObject.put(cq, ((h) cVar).b);
        a aVar = ((h) cVar).d;
        if (aVar != null) {
            jSONObject.put(cr, aVar.g());
        }
        jSONObject.put(cG, ((h) cVar).o);
        jSONObject.put(cH, ((h) cVar).p);
        jSONObject.put(c.bc, cVar.x());
        jSONObject.put(ct, ((h) cVar).f);
        jSONObject.put(cs, ((h) cVar).e);
        jSONObject.put(cu, ((h) cVar).g);
        jSONObject.put(cv, ((h) cVar).h);
        return jSONObject;
    }

    private void c(int i) {
        this.e = i;
    }

    private void c(String str) {
        this.j = str;
    }

    private void d(int i) {
        this.f = i;
    }

    private void d(String str) {
        this.k = str;
    }

    private void e(int i) {
        this.g = i;
    }

    private void e(String str) {
        this.r = str;
    }

    private void f(int i) {
        this.p = i;
    }

    private void f(String str) {
        this.o = str;
    }

    private void g(int i) {
        this.u = i;
    }

    private void g(String str) {
        this.s = str;
    }

    private static Map<String, String> h(String str) {
        HashMap hashMap;
        HashMap hashMap2 = null;
        try {
            if (!TextUtils.isEmpty(str)) {
                HashMap hashMap3 = new HashMap();
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    hashMap3.put("domain", jSONObject.getString("domain"));
                    hashMap3.put("key", jSONObject.getString("key"));
                    hashMap3.put("value", jSONObject.getString("value"));
                    return hashMap3;
                } catch (Throwable th) {
                    hashMap = hashMap3;
                    com.anythink.expressad.foundation.h.o.d("", "loopbackStrToMap error");
                    hashMap2 = hashMap;
                    return hashMap2;
                }
            }
        } catch (Throwable th2) {
            hashMap = null;
        }
        return hashMap2;
    }

    private void h(int i) {
        this.t = i;
    }

    private void i(int i) {
        this.n = i;
    }

    public void a(c.b bVar) {
        this.v = bVar;
    }

    public final a aG() {
        return this.d;
    }

    public final int aH() {
        return this.b;
    }

    public final int aI() {
        return this.f7785a;
    }

    public final int aJ() {
        return this.e;
    }

    public final int aK() {
        return this.f;
    }

    public final int aL() {
        return this.g;
    }

    public final String aM() {
        return this.h;
    }

    public final String aN() {
        return this.i;
    }

    public final String aO() {
        return this.j;
    }

    @Deprecated
    public final String aP() {
        return this.k;
    }

    public final String aQ() {
        return this.o;
    }

    public final int aR() {
        return this.p;
    }

    public final int aS() {
        return this.u;
    }

    public final int aT() {
        return this.t;
    }

    public final String aU() {
        return this.s;
    }

    public final int aV() {
        return this.n;
    }

    public final boolean aW() {
        return this.m;
    }

    public c.b aj() {
        return this.v;
    }

    public final boolean b(c cVar) {
        boolean z = true;
        if (this.f7785a != 1 || cVar.Q() != 3 || ((h) cVar).b == 1) {
            z = false;
        }
        if (z) {
            try {
                if (t.a(com.anythink.core.common.b.n.a().g(), ba())) {
                    z = false;
                }
                return z;
            } catch (Throwable th) {
                com.anythink.expressad.foundation.h.o.a(co, th.getMessage());
            }
        }
        return z;
    }

    public final String u(String str) {
        Map<String, String> map;
        try {
            if (!TextUtils.isEmpty(str) && (map = this.q) != null && map.size() > 0) {
                Uri parse = Uri.parse(str);
                String host = parse.getHost();
                String str2 = map.get("domain");
                if (!TextUtils.isEmpty(host) && host.contains(str2)) {
                    String str3 = map.get("key");
                    String str4 = map.get("value");
                    if (!str.contains(str3) && TextUtils.isEmpty(parse.getQueryParameter(str3)) && !TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4)) {
                        return str + "&" + str3 + "=" + str4;
                    } else if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4)) {
                        return str.replace(str3 + "=" + (!TextUtils.isEmpty(parse.getQueryParameter(str3)) ? parse.getQueryParameter(str3) : ""), str3 + "=" + str4);
                    }
                }
            }
        } catch (Throwable th) {
            com.anythink.expressad.foundation.h.o.d("", "matchLoopback error");
        }
        return str;
    }
}
