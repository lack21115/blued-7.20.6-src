package com.kuaishou.weapon.p0;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kuaishou/weapon/p0/v.class */
public class v {
    public static JSONObject h;
    public static final String i = "1";
    public static final String j = "2";
    public static final String k = "3";
    public static final String l = "4";
    public static final String m = "5";
    public static final String n = "6";
    public static final String o = "7";

    /* renamed from: a  reason: collision with root package name */
    public int f23869a;
    public long b;

    /* renamed from: c  reason: collision with root package name */
    public long f23870c;
    public String d;
    public String e;
    public String f;
    public int g;
    private PackageInfo p;
    private ApplicationInfo q;
    private Context r;

    public v(ApplicationInfo applicationInfo, Context context) {
        this.q = applicationInfo;
        this.r = context;
    }

    public v(PackageInfo packageInfo, Context context) {
        this.p = packageInfo;
        this.r = context;
    }

    public int a() {
        return this.f23869a;
    }

    public void a(int i2) {
        this.f23869a = i2;
    }

    public void a(long j2) {
        this.b = j2;
    }

    public void a(String str) {
        this.e = str;
    }

    public String b() {
        return this.e;
    }

    public void b(int i2) {
        this.g = i2;
    }

    public void b(long j2) {
        this.f23870c = j2;
    }

    public void b(String str) {
        this.f = str;
    }

    public String c() {
        return this.f;
    }

    public void c(String str) {
        this.d = str;
    }

    public long d() {
        return this.b;
    }

    public String e() {
        return this.d;
    }

    public long f() {
        return this.f23870c;
    }

    public int g() {
        return this.g;
    }

    public void h() {
        if (this.p == null && this.q == null) {
            return;
        }
        try {
            if (this.p == null && this.q != null) {
                this.p = this.r.getPackageManager().getPackageInfo(this.q.packageName, 0);
            }
        } catch (Exception e) {
        }
        PackageInfo packageInfo = this.p;
        a(packageInfo == null ? this.q.packageName : packageInfo.packageName);
        PackageInfo packageInfo2 = this.p;
        a((packageInfo2 == null ? this.q : packageInfo2.applicationInfo).flags & 1);
        b(j());
        PackageInfo packageInfo3 = this.p;
        if (packageInfo3 != null) {
            a(packageInfo3.firstInstallTime);
            b(this.p.lastUpdateTime);
            c(this.p.versionName);
            b(this.p.versionCode);
        }
    }

    public void i() {
        if (this.p == null && this.q == null) {
            return;
        }
        try {
            if (this.p == null && this.q != null) {
                this.p = this.r.getPackageManager().getPackageInfo(this.q.packageName, 0);
            }
        } catch (Exception e) {
        }
        PackageInfo packageInfo = this.p;
        a(packageInfo == null ? this.q.packageName : packageInfo.packageName);
        PackageInfo packageInfo2 = this.p;
        a((packageInfo2 == null ? this.q : packageInfo2.applicationInfo).flags & 1);
        PackageInfo packageInfo3 = this.p;
        if (packageInfo3 != null) {
            a(packageInfo3.firstInstallTime);
            b(this.p.lastUpdateTime);
            c(this.p.versionName);
            b(this.p.versionCode);
        }
    }

    public String j() {
        try {
            if (this.p != null && this.p.applicationInfo != null) {
                String charSequence = this.p.applicationInfo.loadLabel(this.r.getPackageManager()).toString();
                if (!TextUtils.isEmpty(charSequence)) {
                    return charSequence;
                }
            } else if (this.q != null) {
                String charSequence2 = this.q.loadLabel(this.r.getPackageManager()).toString();
                if (!TextUtils.isEmpty(charSequence2)) {
                    return charSequence2;
                }
            }
            return "";
        } catch (Throwable th) {
            return "";
        }
    }

    public JSONObject k() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("1", c());
            jSONObject.put("2", b());
            jSONObject.put("3", e());
            jSONObject.put("4", g());
            jSONObject.put("5", a());
            jSONObject.put("6", d());
            jSONObject.put("7", f());
            return jSONObject;
        } catch (Throwable th) {
            return null;
        }
    }
}
