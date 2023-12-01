package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/mipush/sdk/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static volatile b f41218a;

    /* renamed from: a  reason: collision with other field name */
    private Context f145a;

    /* renamed from: a  reason: collision with other field name */
    private a f146a;

    /* renamed from: a  reason: collision with other field name */
    String f147a;

    /* renamed from: a  reason: collision with other field name */
    private Map<String, a> f148a;

    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/mipush/sdk/b$a.class */
    public static class a {

        /* renamed from: a  reason: collision with other field name */
        private Context f149a;

        /* renamed from: a  reason: collision with other field name */
        public String f150a;
        public String b;

        /* renamed from: c  reason: collision with root package name */
        public String f41220c;
        public String d;
        public String e;
        public String f;
        public String g;
        public String h;

        /* renamed from: a  reason: collision with other field name */
        public boolean f151a = true;

        /* renamed from: b  reason: collision with other field name */
        public boolean f152b = false;

        /* renamed from: a  reason: collision with root package name */
        public int f41219a = 1;

        public a(Context context) {
            this.f149a = context;
        }

        public static a a(Context context, String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                a aVar = new a(context);
                aVar.f150a = jSONObject.getString("appId");
                aVar.b = jSONObject.getString("appToken");
                aVar.f41220c = jSONObject.getString("regId");
                aVar.d = jSONObject.getString("regSec");
                aVar.f = jSONObject.getString("devId");
                aVar.e = jSONObject.getString("vName");
                aVar.f151a = jSONObject.getBoolean("valid");
                aVar.f152b = jSONObject.getBoolean("paused");
                aVar.f41219a = jSONObject.getInt("envType");
                aVar.g = jSONObject.getString("regResource");
                return aVar;
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.a(th);
                return null;
            }
        }

        private String a() {
            Context context = this.f149a;
            return com.xiaomi.push.g.m11798a(context, context.getPackageName());
        }

        public static String a(a aVar) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("appId", aVar.f150a);
                jSONObject.put("appToken", aVar.b);
                jSONObject.put("regId", aVar.f41220c);
                jSONObject.put("regSec", aVar.d);
                jSONObject.put("devId", aVar.f);
                jSONObject.put("vName", aVar.e);
                jSONObject.put("valid", aVar.f151a);
                jSONObject.put("paused", aVar.f152b);
                jSONObject.put("envType", aVar.f41219a);
                jSONObject.put("regResource", aVar.g);
                return jSONObject.toString();
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.a(th);
                return null;
            }
        }

        /* renamed from: a  reason: collision with other method in class */
        public void m11470a() {
            b.a(this.f149a).edit().clear().commit();
            this.f150a = null;
            this.b = null;
            this.f41220c = null;
            this.d = null;
            this.f = null;
            this.e = null;
            this.f151a = false;
            this.f152b = false;
            this.h = null;
            this.f41219a = 1;
        }

        public void a(int i) {
            this.f41219a = i;
        }

        public void a(String str, String str2) {
            this.f41220c = str;
            this.d = str2;
            this.f = com.xiaomi.push.i.h(this.f149a);
            this.e = a();
            this.f151a = true;
        }

        public void a(String str, String str2, String str3) {
            this.f150a = str;
            this.b = str2;
            this.g = str3;
            SharedPreferences.Editor edit = b.a(this.f149a).edit();
            edit.putString("appId", this.f150a);
            edit.putString("appToken", str2);
            edit.putString("regResource", str3);
            edit.commit();
        }

        public void a(boolean z) {
            this.f152b = z;
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m11471a() {
            return m11472a(this.f150a, this.b);
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m11472a(String str, String str2) {
            boolean equals = TextUtils.equals(this.f150a, str);
            boolean equals2 = TextUtils.equals(this.b, str2);
            boolean z = !TextUtils.isEmpty(this.f41220c);
            boolean z2 = !TextUtils.isEmpty(this.d);
            boolean z3 = TextUtils.equals(this.f, com.xiaomi.push.i.h(this.f149a)) || TextUtils.equals(this.f, com.xiaomi.push.i.g(this.f149a));
            boolean z4 = equals && equals2 && z && z2 && z3;
            if (!z4) {
                com.xiaomi.channel.commonutils.logger.b.e(String.format("register invalid, aid=%s;atn=%s;rid=%s;rse=%s;did=%s", Boolean.valueOf(equals), Boolean.valueOf(equals2), Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)));
            }
            return z4;
        }

        public void b() {
            this.f151a = false;
            b.a(this.f149a).edit().putBoolean("valid", this.f151a).commit();
        }

        public void b(String str, String str2, String str3) {
            this.f41220c = str;
            this.d = str2;
            this.f = com.xiaomi.push.i.h(this.f149a);
            this.e = a();
            this.f151a = true;
            this.h = str3;
            SharedPreferences.Editor edit = b.a(this.f149a).edit();
            edit.putString("regId", str);
            edit.putString("regSec", str2);
            edit.putString("devId", this.f);
            edit.putString("vName", a());
            edit.putBoolean("valid", true);
            edit.putString("appRegion", str3);
            edit.commit();
        }

        public void c(String str, String str2, String str3) {
            this.f150a = str;
            this.b = str2;
            this.g = str3;
        }
    }

    private b(Context context) {
        this.f145a = context;
        c();
    }

    public static SharedPreferences a(Context context) {
        return context.getSharedPreferences("mipush", 0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static b m11457a(Context context) {
        if (f41218a == null) {
            synchronized (b.class) {
                try {
                    if (f41218a == null) {
                        f41218a = new b(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f41218a;
    }

    private void c() {
        this.f146a = new a(this.f145a);
        this.f148a = new HashMap();
        SharedPreferences a2 = a(this.f145a);
        this.f146a.f150a = a2.getString("appId", null);
        this.f146a.b = a2.getString("appToken", null);
        this.f146a.f41220c = a2.getString("regId", null);
        this.f146a.d = a2.getString("regSec", null);
        this.f146a.f = a2.getString("devId", null);
        if (!TextUtils.isEmpty(this.f146a.f) && com.xiaomi.push.i.a(this.f146a.f)) {
            this.f146a.f = com.xiaomi.push.i.h(this.f145a);
            a2.edit().putString("devId", this.f146a.f).commit();
        }
        this.f146a.e = a2.getString("vName", null);
        this.f146a.f151a = a2.getBoolean("valid", true);
        this.f146a.f152b = a2.getBoolean("paused", false);
        this.f146a.f41219a = a2.getInt("envType", 1);
        this.f146a.g = a2.getString("regResource", null);
        this.f146a.h = a2.getString("appRegion", null);
    }

    public int a() {
        return this.f146a.f41219a;
    }

    public a a(String str) {
        if (this.f148a.containsKey(str)) {
            return this.f148a.get(str);
        }
        String concat = "hybrid_app_info_".concat(String.valueOf(str));
        SharedPreferences a2 = a(this.f145a);
        if (a2.contains(concat)) {
            a a3 = a.a(this.f145a, a2.getString(concat, ""));
            this.f148a.put(concat, a3);
            return a3;
        }
        return null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m11458a() {
        return this.f146a.f150a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m11459a() {
        this.f146a.m11470a();
    }

    public void a(int i) {
        this.f146a.a(i);
        a(this.f145a).edit().putInt("envType", i).commit();
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m11460a(String str) {
        SharedPreferences.Editor edit = a(this.f145a).edit();
        edit.putString("vName", str);
        edit.commit();
        this.f146a.e = str;
    }

    public void a(String str, a aVar) {
        this.f148a.put(str, aVar);
        String a2 = a.a(aVar);
        a(this.f145a).edit().putString("hybrid_app_info_".concat(String.valueOf(str)), a2).commit();
    }

    public void a(String str, String str2, String str3) {
        this.f146a.a(str, str2, str3);
    }

    public void a(boolean z) {
        this.f146a.a(z);
        a(this.f145a).edit().putBoolean("paused", z).commit();
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m11461a() {
        Context context = this.f145a;
        return !TextUtils.equals(com.xiaomi.push.g.m11798a(context, context.getPackageName()), this.f146a.e);
    }

    public boolean a(String str, String str2) {
        return this.f146a.m11472a(str, str2);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m11462a(String str, String str2, String str3) {
        a a2 = a(str3);
        return a2 != null && TextUtils.equals(str, a2.f150a) && TextUtils.equals(str2, a2.b);
    }

    public String b() {
        return this.f146a.b;
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m11463b() {
        this.f146a.b();
    }

    public void b(String str) {
        this.f148a.remove(str);
        a(this.f145a).edit().remove("hybrid_app_info_".concat(String.valueOf(str))).commit();
    }

    public void b(String str, String str2, String str3) {
        this.f146a.b(str, str2, str3);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m11464b() {
        if (this.f146a.m11471a()) {
            return true;
        }
        com.xiaomi.channel.commonutils.logger.b.m11394a("Don't send message before initialization succeeded!");
        return false;
    }

    /* renamed from: c  reason: collision with other method in class */
    public String m11465c() {
        return this.f146a.f41220c;
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m11466c() {
        return this.f146a.m11471a();
    }

    public String d() {
        return this.f146a.d;
    }

    /* renamed from: d  reason: collision with other method in class */
    public boolean m11467d() {
        return (TextUtils.isEmpty(this.f146a.f150a) || TextUtils.isEmpty(this.f146a.b) || TextUtils.isEmpty(this.f146a.f41220c) || TextUtils.isEmpty(this.f146a.d)) ? false : true;
    }

    public String e() {
        return this.f146a.g;
    }

    /* renamed from: e  reason: collision with other method in class */
    public boolean m11468e() {
        return this.f146a.f152b;
    }

    public String f() {
        return this.f146a.h;
    }

    /* renamed from: f  reason: collision with other method in class */
    public boolean m11469f() {
        return !this.f146a.f151a;
    }
}
