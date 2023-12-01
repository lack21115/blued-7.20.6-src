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
    private static volatile b f27527a;

    /* renamed from: a  reason: collision with other field name */
    private Context f98a;

    /* renamed from: a  reason: collision with other field name */
    private a f99a;

    /* renamed from: a  reason: collision with other field name */
    String f100a;

    /* renamed from: a  reason: collision with other field name */
    private Map<String, a> f101a;

    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/mipush/sdk/b$a.class */
    public static class a {

        /* renamed from: a  reason: collision with other field name */
        private Context f102a;

        /* renamed from: a  reason: collision with other field name */
        public String f103a;
        public String b;

        /* renamed from: c  reason: collision with root package name */
        public String f27529c;
        public String d;
        public String e;
        public String f;
        public String g;
        public String h;

        /* renamed from: a  reason: collision with other field name */
        public boolean f104a = true;

        /* renamed from: b  reason: collision with other field name */
        public boolean f105b = false;

        /* renamed from: a  reason: collision with root package name */
        public int f27528a = 1;

        public a(Context context) {
            this.f102a = context;
        }

        public static a a(Context context, String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                a aVar = new a(context);
                aVar.f103a = jSONObject.getString("appId");
                aVar.b = jSONObject.getString("appToken");
                aVar.f27529c = jSONObject.getString("regId");
                aVar.d = jSONObject.getString("regSec");
                aVar.f = jSONObject.getString("devId");
                aVar.e = jSONObject.getString("vName");
                aVar.f104a = jSONObject.getBoolean("valid");
                aVar.f105b = jSONObject.getBoolean("paused");
                aVar.f27528a = jSONObject.getInt("envType");
                aVar.g = jSONObject.getString("regResource");
                return aVar;
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.a(th);
                return null;
            }
        }

        private String a() {
            Context context = this.f102a;
            return com.xiaomi.push.g.m8748a(context, context.getPackageName());
        }

        public static String a(a aVar) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("appId", aVar.f103a);
                jSONObject.put("appToken", aVar.b);
                jSONObject.put("regId", aVar.f27529c);
                jSONObject.put("regSec", aVar.d);
                jSONObject.put("devId", aVar.f);
                jSONObject.put("vName", aVar.e);
                jSONObject.put("valid", aVar.f104a);
                jSONObject.put("paused", aVar.f105b);
                jSONObject.put("envType", aVar.f27528a);
                jSONObject.put("regResource", aVar.g);
                return jSONObject.toString();
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.a(th);
                return null;
            }
        }

        /* renamed from: a  reason: collision with other method in class */
        public void m8420a() {
            b.a(this.f102a).edit().clear().commit();
            this.f103a = null;
            this.b = null;
            this.f27529c = null;
            this.d = null;
            this.f = null;
            this.e = null;
            this.f104a = false;
            this.f105b = false;
            this.h = null;
            this.f27528a = 1;
        }

        public void a(int i) {
            this.f27528a = i;
        }

        public void a(String str, String str2) {
            this.f27529c = str;
            this.d = str2;
            this.f = com.xiaomi.push.i.h(this.f102a);
            this.e = a();
            this.f104a = true;
        }

        public void a(String str, String str2, String str3) {
            this.f103a = str;
            this.b = str2;
            this.g = str3;
            SharedPreferences.Editor edit = b.a(this.f102a).edit();
            edit.putString("appId", this.f103a);
            edit.putString("appToken", str2);
            edit.putString("regResource", str3);
            edit.commit();
        }

        public void a(boolean z) {
            this.f105b = z;
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m8421a() {
            return m8422a(this.f103a, this.b);
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m8422a(String str, String str2) {
            boolean equals = TextUtils.equals(this.f103a, str);
            boolean equals2 = TextUtils.equals(this.b, str2);
            boolean z = !TextUtils.isEmpty(this.f27529c);
            boolean z2 = !TextUtils.isEmpty(this.d);
            boolean z3 = TextUtils.equals(this.f, com.xiaomi.push.i.h(this.f102a)) || TextUtils.equals(this.f, com.xiaomi.push.i.g(this.f102a));
            boolean z4 = equals && equals2 && z && z2 && z3;
            if (!z4) {
                com.xiaomi.channel.commonutils.logger.b.e(String.format("register invalid, aid=%s;atn=%s;rid=%s;rse=%s;did=%s", Boolean.valueOf(equals), Boolean.valueOf(equals2), Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)));
            }
            return z4;
        }

        public void b() {
            this.f104a = false;
            b.a(this.f102a).edit().putBoolean("valid", this.f104a).commit();
        }

        public void b(String str, String str2, String str3) {
            this.f27529c = str;
            this.d = str2;
            this.f = com.xiaomi.push.i.h(this.f102a);
            this.e = a();
            this.f104a = true;
            this.h = str3;
            SharedPreferences.Editor edit = b.a(this.f102a).edit();
            edit.putString("regId", str);
            edit.putString("regSec", str2);
            edit.putString("devId", this.f);
            edit.putString("vName", a());
            edit.putBoolean("valid", true);
            edit.putString("appRegion", str3);
            edit.commit();
        }

        public void c(String str, String str2, String str3) {
            this.f103a = str;
            this.b = str2;
            this.g = str3;
        }
    }

    private b(Context context) {
        this.f98a = context;
        c();
    }

    public static SharedPreferences a(Context context) {
        return context.getSharedPreferences("mipush", 0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static b m8407a(Context context) {
        if (f27527a == null) {
            synchronized (b.class) {
                try {
                    if (f27527a == null) {
                        f27527a = new b(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f27527a;
    }

    private void c() {
        this.f99a = new a(this.f98a);
        this.f101a = new HashMap();
        SharedPreferences a2 = a(this.f98a);
        this.f99a.f103a = a2.getString("appId", null);
        this.f99a.b = a2.getString("appToken", null);
        this.f99a.f27529c = a2.getString("regId", null);
        this.f99a.d = a2.getString("regSec", null);
        this.f99a.f = a2.getString("devId", null);
        if (!TextUtils.isEmpty(this.f99a.f) && com.xiaomi.push.i.a(this.f99a.f)) {
            this.f99a.f = com.xiaomi.push.i.h(this.f98a);
            a2.edit().putString("devId", this.f99a.f).commit();
        }
        this.f99a.e = a2.getString("vName", null);
        this.f99a.f104a = a2.getBoolean("valid", true);
        this.f99a.f105b = a2.getBoolean("paused", false);
        this.f99a.f27528a = a2.getInt("envType", 1);
        this.f99a.g = a2.getString("regResource", null);
        this.f99a.h = a2.getString("appRegion", null);
    }

    public int a() {
        return this.f99a.f27528a;
    }

    public a a(String str) {
        if (this.f101a.containsKey(str)) {
            return this.f101a.get(str);
        }
        String concat = "hybrid_app_info_".concat(String.valueOf(str));
        SharedPreferences a2 = a(this.f98a);
        if (a2.contains(concat)) {
            a a3 = a.a(this.f98a, a2.getString(concat, ""));
            this.f101a.put(concat, a3);
            return a3;
        }
        return null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m8408a() {
        return this.f99a.f103a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m8409a() {
        this.f99a.m8420a();
    }

    public void a(int i) {
        this.f99a.a(i);
        a(this.f98a).edit().putInt("envType", i).commit();
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m8410a(String str) {
        SharedPreferences.Editor edit = a(this.f98a).edit();
        edit.putString("vName", str);
        edit.commit();
        this.f99a.e = str;
    }

    public void a(String str, a aVar) {
        this.f101a.put(str, aVar);
        String a2 = a.a(aVar);
        a(this.f98a).edit().putString("hybrid_app_info_".concat(String.valueOf(str)), a2).commit();
    }

    public void a(String str, String str2, String str3) {
        this.f99a.a(str, str2, str3);
    }

    public void a(boolean z) {
        this.f99a.a(z);
        a(this.f98a).edit().putBoolean("paused", z).commit();
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m8411a() {
        Context context = this.f98a;
        return !TextUtils.equals(com.xiaomi.push.g.m8748a(context, context.getPackageName()), this.f99a.e);
    }

    public boolean a(String str, String str2) {
        return this.f99a.m8422a(str, str2);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m8412a(String str, String str2, String str3) {
        a a2 = a(str3);
        return a2 != null && TextUtils.equals(str, a2.f103a) && TextUtils.equals(str2, a2.b);
    }

    public String b() {
        return this.f99a.b;
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m8413b() {
        this.f99a.b();
    }

    public void b(String str) {
        this.f101a.remove(str);
        a(this.f98a).edit().remove("hybrid_app_info_".concat(String.valueOf(str))).commit();
    }

    public void b(String str, String str2, String str3) {
        this.f99a.b(str, str2, str3);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m8414b() {
        if (this.f99a.m8421a()) {
            return true;
        }
        com.xiaomi.channel.commonutils.logger.b.m8344a("Don't send message before initialization succeeded!");
        return false;
    }

    /* renamed from: c  reason: collision with other method in class */
    public String m8415c() {
        return this.f99a.f27529c;
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m8416c() {
        return this.f99a.m8421a();
    }

    public String d() {
        return this.f99a.d;
    }

    /* renamed from: d  reason: collision with other method in class */
    public boolean m8417d() {
        return (TextUtils.isEmpty(this.f99a.f103a) || TextUtils.isEmpty(this.f99a.b) || TextUtils.isEmpty(this.f99a.f27529c) || TextUtils.isEmpty(this.f99a.d)) ? false : true;
    }

    public String e() {
        return this.f99a.g;
    }

    /* renamed from: e  reason: collision with other method in class */
    public boolean m8418e() {
        return this.f99a.f105b;
    }

    public String f() {
        return this.f99a.h;
    }

    /* renamed from: f  reason: collision with other method in class */
    public boolean m8419f() {
        return !this.f99a.f104a;
    }
}
