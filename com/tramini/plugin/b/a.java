package com.tramini.plugin.b;

import android.text.TextUtils;
import com.tramini.plugin.a.c.c;
import com.tramini.plugin.a.c.d;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/tramini/plugin/b/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f40550a = a.class.getSimpleName();
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private long f40551c;
    private List d;
    private ConcurrentHashMap<String, c> e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private String k;
    private String l;
    private String m;
    private int n;
    private Set<d> o;
    private int p;
    private String q;
    private String r;
    private String s;
    private String t;

    /* renamed from: com.tramini.plugin.b.a$a  reason: collision with other inner class name */
    /* loaded from: source-8829756-dex2jar.jar:com/tramini/plugin/b/a$a.class */
    static final class C1073a {

        /* renamed from: a  reason: collision with root package name */
        private static String f40552a = "si";
        private static String b = "scto";

        /* renamed from: c  reason: collision with root package name */
        private static String f40553c = "tf";
        private static String d = "nl";
        private static String e = "t_sw";
        private static String f = "pil";
        private static String g = "att_sw";
        private static String h = "plst_addr";
        private static String i = "pltk_addr";
        private static String j = "cn_plst_addr";
        private static String k = "cn_pltk_addr";

        C1073a() {
        }
    }

    public static a a(String str) {
        JSONArray jSONArray;
        int length;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        a aVar = new a();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.isNull(C1073a.f40552a)) {
                aVar.b = "";
            } else {
                aVar.b = jSONObject.optString(C1073a.f40552a);
            }
            if (jSONObject.isNull(C1073a.b)) {
                aVar.f40551c = 3600000L;
            } else {
                aVar.f40551c = jSONObject.optInt(C1073a.b);
            }
            if (jSONObject.isNull(C1073a.g)) {
                aVar.p = 0;
            } else {
                aVar.p = jSONObject.optInt(C1073a.g);
            }
            if (!jSONObject.isNull(C1073a.h)) {
                aVar.q = jSONObject.optString(C1073a.h);
            }
            if (!jSONObject.isNull(C1073a.i)) {
                aVar.r = jSONObject.optString(C1073a.i);
            }
            if (!jSONObject.isNull(C1073a.j)) {
                aVar.s = jSONObject.optString(C1073a.j);
            }
            if (!jSONObject.isNull(C1073a.k)) {
                aVar.t = jSONObject.optString(C1073a.k);
            }
            if (!jSONObject.isNull(C1073a.f40553c)) {
                ConcurrentHashMap<String, c> concurrentHashMap = new ConcurrentHashMap<>();
                try {
                    JSONObject jSONObject2 = new JSONObject(jSONObject.optString(C1073a.f40553c));
                    Iterator<String> keys = jSONObject2.keys();
                    while (keys.hasNext()) {
                        try {
                            String next = keys.next();
                            c cVar = new c();
                            JSONObject optJSONObject = jSONObject2.optJSONObject(next);
                            cVar.d = optJSONObject.optString("pml");
                            cVar.f40502a = optJSONObject.optString("uu");
                            cVar.b = optJSONObject.optInt("dmin");
                            cVar.f40503c = optJSONObject.optInt("dmax");
                            if (optJSONObject.has("p_s") && !TextUtils.isEmpty(optJSONObject.optString("p_s"))) {
                                cVar.e = new JSONArray(optJSONObject.optString("p_s"));
                            }
                            concurrentHashMap.put(next, cVar);
                        } catch (Exception e) {
                        }
                    }
                } catch (Exception e2) {
                }
                aVar.e = concurrentHashMap;
            }
            if (!jSONObject.isNull(C1073a.d)) {
                JSONObject jSONObject3 = new JSONObject(jSONObject.optString(C1073a.d));
                aVar.f = jSONObject3.optString("p1");
                aVar.g = jSONObject3.optString(com.anythink.core.common.g.c.X);
                aVar.h = jSONObject3.optString("p3");
                aVar.i = jSONObject3.optString("p4");
                aVar.j = jSONObject3.optString("p5");
                aVar.k = jSONObject3.optString("p6");
                aVar.l = jSONObject3.optString("p7");
                aVar.m = jSONObject3.optString("p8");
                if (!jSONObject3.isNull("notifications") && (length = (jSONArray = new JSONArray(jSONObject3.optString("notifications"))).length()) > 0) {
                    ArrayList arrayList = new ArrayList(length);
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= length) {
                            break;
                        }
                        arrayList.add(jSONArray.optString(i2));
                        i = i2 + 1;
                    }
                    aVar.d = arrayList;
                }
            }
            if (jSONObject.isNull(C1073a.e)) {
                aVar.n = 0;
            } else {
                aVar.n = jSONObject.optInt(C1073a.e);
            }
            if (!jSONObject.isNull(C1073a.f)) {
                JSONObject jSONObject4 = new JSONObject(jSONObject.optString(C1073a.f));
                Iterator<String> keys2 = jSONObject4.keys();
                HashSet hashSet = new HashSet();
                while (keys2.hasNext()) {
                    d dVar = new d();
                    dVar.f40504a = keys2.next();
                    dVar.b = jSONObject4.optString(dVar.f40504a);
                    hashSet.add(dVar);
                }
                aVar.o = hashSet;
            }
            return aVar;
        } catch (JSONException e3) {
            return null;
        }
    }

    public final int a() {
        return this.p;
    }

    public final String b() {
        return this.b;
    }

    public final long c() {
        return this.f40551c;
    }

    public final List<String> d() {
        return this.d;
    }

    public final ConcurrentHashMap<String, c> e() {
        return this.e;
    }

    public final String f() {
        return this.f;
    }

    public final String g() {
        return this.g;
    }

    public final String h() {
        return this.h;
    }

    public final String i() {
        return this.i;
    }

    public final String j() {
        return this.j;
    }

    public final String k() {
        return this.k;
    }

    public final String l() {
        return this.l;
    }

    public final String m() {
        return this.m;
    }

    public final int n() {
        return this.n;
    }

    public final Set<d> o() {
        return this.o;
    }

    public final String p() {
        return this.q;
    }

    public final String q() {
        return this.r;
    }
}
