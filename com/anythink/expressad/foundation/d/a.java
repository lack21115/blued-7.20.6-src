package com.anythink.expressad.foundation.d;

import android.text.TextUtils;
import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/foundation/d/a.class */
public final class a implements com.anythink.expressad.e.b, Serializable {

    /* renamed from: a  reason: collision with root package name */
    private static final String f7762a = "https://img.toponad.com/sdk/app-permissions.html?key=";
    private static String b = "app_name";

    /* renamed from: c  reason: collision with root package name */
    private static String f7763c = "perm_desc";
    private static String d = "ori_perm_desc";
    private static String e = "ori_perm_all";
    private static String f = "pri_url";
    private static String g = "upd_time";
    private static String h = "app_ver";
    private static String i = "dev_name";
    private String j;
    private String k;
    private ArrayList<String> l = new ArrayList<>(3);
    private ArrayList<String> m = new ArrayList<>(3);
    private ArrayList<String> n = new ArrayList<>(3);
    private String o;
    private String p;
    private String q;
    private String r;
    private String s;

    private static a a(a aVar) {
        a aVar2 = aVar;
        if (aVar == null) {
            aVar2 = new a();
        }
        return aVar2;
    }

    public static a a(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return a(new JSONObject(str));
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private static a a(JSONObject jSONObject) {
        a aVar = null;
        if (jSONObject.has(b)) {
            aVar = a((a) null);
            aVar.k = jSONObject.optString(b);
        }
        a aVar2 = aVar;
        if (jSONObject.has(f7763c)) {
            a a2 = a(aVar);
            JSONArray optJSONArray = jSONObject.optJSONArray(f7763c);
            aVar2 = a2;
            if (optJSONArray != null) {
                a2.l = a(optJSONArray);
                ArrayList<String> arrayList = a2.n;
                String str = f7762a;
                int i2 = 0;
                while (i2 < optJSONArray.length()) {
                    try {
                        String str2 = str;
                        if (optJSONArray.get(i2) instanceof String) {
                            if (i2 == 0) {
                                str2 = str + optJSONArray.optString(i2);
                            } else {
                                str2 = str + "," + optJSONArray.optString(i2);
                            }
                        }
                        i2++;
                        str = str2;
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
                a2.o = str;
                a2.n = arrayList;
                aVar2 = a2;
            }
        }
        a aVar3 = aVar2;
        if (jSONObject.has(d)) {
            a a3 = a(aVar2);
            JSONArray optJSONArray2 = jSONObject.optJSONArray(d);
            aVar3 = a3;
            if (optJSONArray2 != null) {
                a3.m = a(optJSONArray2);
                ArrayList<String> arrayList2 = a3.n;
                int i3 = 0;
                while (true) {
                    try {
                        int i4 = i3;
                        if (i4 >= optJSONArray2.length()) {
                            break;
                        }
                        Object obj = optJSONArray2.get(i4);
                        if (obj instanceof String) {
                            arrayList2.add((String) obj);
                        }
                        i3 = i4 + 1;
                    } catch (JSONException e3) {
                        e3.printStackTrace();
                    }
                }
                a3.n = arrayList2;
                aVar3 = a3;
            }
        }
        a aVar4 = aVar3;
        if (jSONObject.has(f)) {
            aVar4 = a(aVar3);
            aVar4.p = jSONObject.optString(f);
        }
        a aVar5 = aVar4;
        if (jSONObject.has(g)) {
            aVar5 = a(aVar4);
            aVar5.q = jSONObject.optString(g);
        }
        a aVar6 = aVar5;
        if (jSONObject.has(h)) {
            aVar6 = a(aVar5);
            aVar6.r = jSONObject.optString(h);
        }
        a aVar7 = aVar6;
        if (jSONObject.has(i)) {
            aVar7 = a(aVar6);
            aVar7.s = jSONObject.optString(i);
        }
        if (aVar7 != null) {
            aVar7.j = jSONObject.toString();
        }
        return aVar7;
    }

    private static ArrayList<String> a(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return null;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= jSONArray.length()) {
                return arrayList;
            }
            arrayList.add(jSONArray.optString(i3));
            i2 = i3 + 1;
        }
    }

    private void a(ArrayList<String> arrayList) {
        this.l = arrayList;
    }

    private void b(String str) {
        this.j = str;
    }

    private void b(ArrayList<String> arrayList) {
        this.m = arrayList;
    }

    private void c(String str) {
        this.o = str;
    }

    private void c(ArrayList<String> arrayList) {
        this.n = arrayList;
    }

    private static JSONArray d(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= arrayList.size()) {
                return jSONArray;
            }
            jSONArray.put(arrayList.get(i3));
            i2 = i3 + 1;
        }
    }

    private void d(String str) {
        this.k = str;
    }

    private void e(String str) {
        this.p = str;
    }

    private void f(String str) {
        this.q = str;
    }

    private void g(String str) {
        this.r = str;
    }

    private String h() {
        return this.j;
    }

    private void h(String str) {
        this.s = str;
    }

    private ArrayList<String> i() {
        return this.l;
    }

    private ArrayList<String> j() {
        return this.m;
    }

    private ArrayList<String> k() {
        return this.n;
    }

    public final String a() {
        return this.o;
    }

    public final String b() {
        return this.k;
    }

    public final String c() {
        return this.p;
    }

    public final String d() {
        return this.q;
    }

    public final String e() {
        return this.r;
    }

    public final String f() {
        return this.s;
    }

    public final JSONObject g() {
        try {
            JSONObject jSONObject = new JSONObject(this.j);
            if (jSONObject.length() > 0) {
                return jSONObject;
            }
            return null;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public final String toString() {
        return "ApkDisplayInfo{appName='" + this.k + "', permDescJArray=" + this.l + ", permDescOriJArray=" + this.m + ", permDescAll=" + this.n + ", priUrl='" + this.p + "', updateTime='" + this.q + "', appVersion='" + this.r + "', devName='" + this.s + "'}";
    }
}
