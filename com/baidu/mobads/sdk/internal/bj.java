package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

/* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/internal/bj.class */
public class bj {

    /* renamed from: a  reason: collision with root package name */
    public static final String f6501a = "mobads_builds";
    public static final String b = "brand_period";

    /* renamed from: c  reason: collision with root package name */
    public static final String f6502c = "version_period";
    public static final long d = 604800000;
    public static final long e = 172800000;
    public static final String f = "sdk_int";
    public static final String g = "sdk";
    public static final String h = "release";
    public static final String i = "model";
    public static final String j = "brand";
    public static final String k = "netopera";
    public static final String l = "tags";
    private int m;
    private String n;
    private String o;
    private String p;
    private String q;
    private String r;
    private String s;
    private Context t;
    private SharedPreferences u;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/internal/bj$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private static final bj f6503a = new bj();

        private a() {
        }
    }

    private bj() {
        this.m = 0;
        this.n = "";
        this.o = "";
        this.p = "";
        this.q = "";
        this.r = "";
        this.s = "";
    }

    public static bj a(Context context) {
        a.f6503a.b(context);
        return a.f6503a;
    }

    private String a(String str) {
        try {
            return this.u.getString(str, "");
        } catch (Throwable th) {
            bq.a().c(th.getMessage());
            return "";
        }
    }

    private void a(String str, int i2) {
        try {
            SharedPreferences.Editor k2 = k();
            k2.putInt(str, i2);
            k2.apply();
        } catch (Throwable th) {
            bq.a().c(th.getMessage());
        }
    }

    private void a(String str, Long l2) {
        try {
            SharedPreferences.Editor k2 = k();
            k2.putLong(str, l2.longValue());
            k2.apply();
        } catch (Throwable th) {
            bq.a().c(th.getMessage());
        }
    }

    private void a(String str, String str2) {
        try {
            SharedPreferences.Editor k2 = k();
            k2.putString(str, str2);
            k2.apply();
        } catch (Throwable th) {
            bq.a().c(th.getMessage());
        }
    }

    private Long b(String str) {
        try {
            return Long.valueOf(this.u.getLong(str, 0L));
        } catch (Throwable th) {
            bq.a().c(th.getMessage());
            return 0L;
        }
    }

    private int c(String str) {
        try {
            return this.u.getInt(str, 0);
        } catch (Throwable th) {
            bq.a().c(th.getMessage());
            return 0;
        }
    }

    private void h() {
        i();
        j();
    }

    private void i() {
        try {
            if (System.currentTimeMillis() <= b(b).longValue()) {
                this.p = a("model");
                this.q = a("brand");
                this.r = a(k);
                this.s = a("tags");
                return;
            }
            this.p = Build.MODEL;
            this.q = Build.BRAND;
            this.r = ((TelephonyManager) this.t.getSystemService("phone")).getNetworkOperator();
            this.s = Build.TAGS;
            a("model", this.p);
            a("brand", this.q);
            a(k, this.r);
            a("tags", this.s);
            a(b, Long.valueOf(System.currentTimeMillis() + 604800000));
        } catch (Throwable th) {
            bq.a().c(th.getMessage());
        }
    }

    private void j() {
        try {
            if (System.currentTimeMillis() <= b(f6502c).longValue()) {
                this.m = c(f);
                this.n = a("sdk");
                this.o = a("release");
                return;
            }
            this.m = Build.VERSION.SDK_INT;
            this.n = Build.VERSION.SDK;
            this.o = Build.VERSION.RELEASE;
            a(f, this.m);
            a("sdk", this.n);
            a("release", this.o);
            a(f6502c, Long.valueOf(System.currentTimeMillis() + e));
        } catch (Throwable th) {
            bq.a().c(th.getMessage());
        }
    }

    private SharedPreferences.Editor k() {
        return this.u.edit();
    }

    public int a() {
        if (this.m == 0) {
            this.m = Build.VERSION.SDK_INT;
        }
        return this.m;
    }

    public String b() {
        if (TextUtils.isEmpty(this.n)) {
            this.n = Build.VERSION.SDK;
        }
        return this.n;
    }

    public void b(Context context) {
        if (this.t != null || context == null) {
            if (a.f6503a == null) {
                ay.a(context);
                return;
            }
            return;
        }
        Context applicationContext = context.getApplicationContext();
        this.t = applicationContext;
        try {
            if (this.u == null) {
                this.u = applicationContext.getSharedPreferences(f6501a, 0);
                h();
            }
        } catch (Throwable th) {
            bq.a().c(th.getMessage());
        }
    }

    public String c() {
        return this.o;
    }

    public String d() {
        return this.p;
    }

    public String e() {
        return this.q;
    }

    public String f() {
        return this.r;
    }

    public String g() {
        return this.s;
    }
}
