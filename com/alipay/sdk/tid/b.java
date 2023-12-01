package com.alipay.sdk.tid;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.alipay.sdk.util.c;
import java.util.Random;
import org.json.JSONObject;

/* loaded from: source-6737240-dex2jar.jar:com/alipay/sdk/tid/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final String f4654a = "alipay_tid_storage";
    public static final String b = "tidinfo";

    /* renamed from: c  reason: collision with root package name */
    public static final String f4655c = "upgraded_from_db";
    public static final String d = "tid";
    public static final String e = "client_key";
    public static final String f = "timestamp";
    public static final String g = "vimei";
    public static final String h = "vimsi";
    private static Context i;
    private static b o;
    private String j;
    private String k;
    private long l;
    private String m;
    private String n;
    private boolean p = false;

    /* loaded from: source-6737240-dex2jar.jar:com/alipay/sdk/tid/b$a.class */
    public static class a {
        private static String a() {
            return "!@#23457";
        }

        public static String a(String str, String str2, boolean z) {
            if (b.i == null) {
                return null;
            }
            String string = b.i.getSharedPreferences(str, 0).getString(str2, null);
            String str3 = string;
            if (!TextUtils.isEmpty(string)) {
                str3 = string;
                if (z) {
                    String b = com.alipay.sdk.encrypt.b.b(string, b());
                    String str4 = b;
                    if (TextUtils.isEmpty(b)) {
                        String b2 = com.alipay.sdk.encrypt.b.b(string, a());
                        str4 = b2;
                        if (!TextUtils.isEmpty(b2)) {
                            a(str, str2, b2, true);
                            str4 = b2;
                        }
                    }
                    String str5 = str4;
                    str3 = str5;
                    if (TextUtils.isEmpty(str5)) {
                        c.a(com.alipay.sdk.cons.a.x, "tid_str: pref failed");
                        str3 = str5;
                    }
                }
            }
            c.a(com.alipay.sdk.cons.a.x, "tid_str: from local");
            return str3;
        }

        public static void a(String str, String str2, String str3) {
            a(str, str2, str3, true);
        }

        public static void a(String str, String str2, String str3, boolean z) {
            if (b.i == null) {
                return;
            }
            SharedPreferences sharedPreferences = b.i.getSharedPreferences(str, 0);
            String str4 = str3;
            if (z) {
                String b = b();
                str4 = com.alipay.sdk.encrypt.b.a(str3, b);
                if (TextUtils.isEmpty(str4)) {
                    String.format("LocalPreference::putLocalPreferences failed %s，%s", str3, b);
                }
            }
            sharedPreferences.edit().putString(str2, str4).apply();
        }

        public static boolean a(String str, String str2) {
            if (b.i == null) {
                return false;
            }
            return b.i.getSharedPreferences(str, 0).contains(str2);
        }

        private static String b() {
            String str;
            try {
                str = b.i.getApplicationContext().getPackageName();
            } catch (Throwable th) {
                c.a(th);
                str = "";
            }
            String str2 = str;
            if (TextUtils.isEmpty(str)) {
                str2 = "unknow";
            }
            return (str2 + "00000000").substring(0, 8);
        }

        public static void b(String str, String str2) {
            if (b.i == null) {
                return;
            }
            b.i.getSharedPreferences(str, 0).edit().remove(str2).apply();
        }

        public static String c(String str, String str2) {
            return a(str, str2, true);
        }

        public static boolean d(String str, String str2) {
            if (b.i == null) {
                return false;
            }
            return b.i.getSharedPreferences(str, 0).contains(str2);
        }
    }

    public static b a(Context context) {
        b bVar;
        synchronized (b.class) {
            try {
                if (o == null) {
                    o = new b();
                }
                if (i == null) {
                    o.b(context);
                }
                bVar = o;
            } catch (Throwable th) {
                throw th;
            }
        }
        return bVar;
    }

    private void a(String str, String str2, String str3, String str4, Long l) {
        if (a(str, str2, str3, str4)) {
            return;
        }
        this.j = str;
        this.k = str2;
        this.m = str3;
        this.n = str4;
        if (l == null) {
            this.l = System.currentTimeMillis();
        } else {
            this.l = l.longValue();
        }
        p();
    }

    private boolean a(String str, String str2, String str3, String str4) {
        return TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4);
    }

    private void b(Context context) {
        if (context != null) {
            i = context.getApplicationContext();
        }
        if (this.p) {
            return;
        }
        this.p = true;
        k();
        l();
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0089, code lost:
        if (r6 == null) goto L25;
     */
    /* JADX WARN: Finally extract failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void k() {
        /*
            Method dump skipped, instructions count: 225
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.tid.b.k():void");
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00db  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void l() {
        /*
            Method dump skipped, instructions count: 252
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.tid.b.l():void");
    }

    private void m() {
        this.j = "";
        this.k = f();
        this.l = System.currentTimeMillis();
        this.m = n();
        this.n = n();
        a.b(f4654a, b);
    }

    private String n() {
        String hexString = Long.toHexString(System.currentTimeMillis());
        Random random = new Random();
        return hexString + (random.nextInt(9000) + 1000);
    }

    private void o() {
    }

    private void p() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("tid", this.j);
            jSONObject.put(e, this.k);
            jSONObject.put("timestamp", this.l);
            jSONObject.put(g, this.m);
            jSONObject.put(h, this.n);
            a.a(f4654a, b, jSONObject.toString(), true);
        } catch (Exception e2) {
            c.a(e2);
        }
    }

    public String a() {
        return this.j;
    }

    public void a(String str, String str2) {
        c.a(com.alipay.sdk.cons.a.x, "tid_str: save");
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.j = str;
        this.k = str2;
        this.l = System.currentTimeMillis();
        p();
        o();
    }

    public String b() {
        return this.k;
    }

    public String c() {
        return this.m;
    }

    public String d() {
        return this.n;
    }

    public boolean e() {
        return TextUtils.isEmpty(this.j) || TextUtils.isEmpty(this.k) || TextUtils.isEmpty(this.m) || TextUtils.isEmpty(this.n);
    }

    public String f() {
        String hexString = Long.toHexString(System.currentTimeMillis());
        String str = hexString;
        if (hexString.length() > 10) {
            str = hexString.substring(hexString.length() - 10);
        }
        return str;
    }

    public void g() {
        c.a(com.alipay.sdk.cons.a.x, "tid_str: del");
        m();
    }

    public boolean h() {
        return e();
    }

    public Long i() {
        return Long.valueOf(this.l);
    }
}
