package com.amap.api.col.p0003sl;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.amap.api.col.3sl.io  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/io.class */
public final class io {

    /* renamed from: a  reason: collision with root package name */
    private ia f5169a;

    /* renamed from: com.amap.api.col.3sl.io$a */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/io$a.class */
    static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static Map<String, io> f5170a = new HashMap();
    }

    /* renamed from: com.amap.api.col.3sl.io$b */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/io$b.class */
    static final class b {

        /* renamed from: a  reason: collision with root package name */
        private String f5171a;
        private String b;

        /* renamed from: c  reason: collision with root package name */
        private String f5172c;

        public b(String str, String str2, String str3) {
            this.f5171a = str;
            this.b = str2;
            this.f5172c = str3;
        }

        private static b a(JSONObject jSONObject) {
            try {
                return new b(jSONObject.optString("sdkVersion"), jSONObject.optString("cpuType"), jSONObject.optString("content"));
            } catch (Throwable th) {
                return null;
            }
        }

        public static List<b> a(String str) {
            if (TextUtils.isEmpty(str)) {
                return new ArrayList();
            }
            ArrayList arrayList = new ArrayList();
            try {
                JSONArray jSONArray = new JSONArray(str);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= jSONArray.length()) {
                        return arrayList;
                    }
                    arrayList.add(a(jSONArray.getJSONObject(i2)));
                    i = i2 + 1;
                }
            } catch (Throwable th) {
                return new ArrayList();
            }
        }

        public static JSONArray a(List<b> list) {
            if (list == null) {
                return new JSONArray();
            }
            JSONArray jSONArray = new JSONArray();
            Iterator<b> it = list.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next != null) {
                    if ((next == null || TextUtils.isEmpty(next.f5172c)) ? false : true) {
                        jSONArray.put(next.a());
                    }
                }
            }
            return jSONArray;
        }

        private JSONObject a() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("sdkVersion", this.f5171a);
                jSONObject.put("cpuType", this.b);
                jSONObject.put("content", this.f5172c);
                return jSONObject;
            } catch (Throwable th) {
                return new JSONObject();
            }
        }

        public final boolean a(String str, String str2) {
            String str3 = str;
            if (TextUtils.isEmpty(str)) {
                str3 = this.f5171a;
            }
            String str4 = str2;
            if (TextUtils.isEmpty(str2)) {
                str4 = this.b;
            }
            return this.f5171a.equals(str3) && this.b.equals(str4);
        }
    }

    private io(ia iaVar) {
        this.f5169a = iaVar;
    }

    public static io a(ia iaVar) {
        if (iaVar == null || TextUtils.isEmpty(iaVar.a())) {
            return null;
        }
        if (a.f5170a.get(iaVar.a()) == null) {
            a.f5170a.put(iaVar.a(), new io(iaVar));
        }
        return a.f5170a.get(iaVar.a());
    }

    private static String a(Context context, String str, String str2) {
        return b(context, "C7ADB20F22F238708BA5EE26D0401DB9" + hw.b(str), "ik".concat(String.valueOf(str2)));
    }

    private static String b(Context context, String str, String str2) {
        return (context == null || TextUtils.isEmpty(str2)) ? "" : ib.a(hm.b(ib.d(context.getSharedPreferences(str, 0).getString(str2, ""))));
    }

    private static void b(Context context, String str, String str2, String str3) {
        if (str3 == null || TextUtils.isEmpty(str)) {
            return;
        }
        c(context, "C7ADB20F22F238708BA5EE26D0401DB9" + hw.b(str), "ik".concat(String.valueOf(str2)), str3);
    }

    private static void c(Context context, String str, String str2, String str3) {
        if (context == null || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str3)) {
            return;
        }
        String g = ib.g(hm.a(ib.a(str3)));
        SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
        edit.putString(str2, g);
        edit.commit();
    }

    public final String a(Context context, String str, String str2, String str3) {
        ia iaVar;
        if (context == null || (iaVar = this.f5169a) == null || TextUtils.isEmpty(iaVar.a())) {
            return null;
        }
        List<b> a2 = b.a(a(context, this.f5169a.a(), str3));
        if (a2.size() == 0) {
            return "";
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= a2.size()) {
                return null;
            }
            b bVar = a2.get(i2);
            if (bVar.a(str, str2)) {
                return bVar.f5172c;
            }
            i = i2 + 1;
        }
    }

    public final void a(Context context, String str, String str2, String str3, String str4) {
        ia iaVar;
        if (context == null || (iaVar = this.f5169a) == null || TextUtils.isEmpty(iaVar.a())) {
            return;
        }
        List<b> a2 = b.a(a(context, this.f5169a.a(), str3));
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= a2.size()) {
                a2.add(new b(str, str2, str4));
                b(context, this.f5169a.a(), str3, b.a(a2).toString());
                return;
            }
            b bVar = a2.get(i2);
            if (bVar.a(str, str2)) {
                bVar.f5172c = str4;
                b(context, this.f5169a.a(), str3, b.a(a2).toString());
                return;
            }
            i = i2 + 1;
        }
    }
}
