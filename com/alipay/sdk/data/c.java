package com.alipay.sdk.data;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.widget.TextView;
import com.alipay.mobilesecuritysdk.face.SecurityClientMobile;
import com.alipay.sdk.app.i;
import com.alipay.sdk.util.n;
import com.anythink.expressad.video.module.a.a.m;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/* loaded from: source-6737240-dex2jar.jar:com/alipay/sdk/data/c.class */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static final String f4623a = "virtualImeiAndImsi";
    private static final String b = "virtual_imei";

    /* renamed from: c  reason: collision with root package name */
    private static final String f4624c = "virtual_imsi";
    private static volatile c d;
    private String e;
    private String f = "sdk-and-lite";
    private String g;

    private c() {
        String a2 = i.a();
        if (i.b()) {
            return;
        }
        this.f += '_' + a2;
    }

    public static String a(Context context) {
        if (context != null) {
            try {
                StringBuilder sb = new StringBuilder();
                String packageName = context.getPackageName();
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
                sb.append("(");
                sb.append(packageName);
                sb.append(";");
                sb.append(packageInfo.versionCode);
                sb.append(")");
                return sb.toString();
            } catch (Exception e) {
                return "";
            }
        }
        return "";
    }

    public static void a(String str) {
        synchronized (c.class) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                PreferenceManager.getDefaultSharedPreferences(com.alipay.sdk.sys.b.a().b()).edit().putString(com.alipay.sdk.cons.b.i, str).apply();
                com.alipay.sdk.cons.a.e = str;
            } finally {
            }
        }
    }

    public static c b() {
        c cVar;
        synchronized (c.class) {
            try {
                if (d == null) {
                    d = new c();
                }
                cVar = d;
            } catch (Throwable th) {
                throw th;
            }
        }
        return cVar;
    }

    private static String b(Context context) {
        return Float.toString(new TextView(context).getTextSize());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(com.alipay.sdk.sys.a aVar, Context context, HashMap<String, String> hashMap) {
        String str;
        try {
            str = SecurityClientMobile.GetApdid(context, hashMap);
        } catch (Throwable th) {
            com.alipay.sdk.util.c.a(th);
            com.alipay.sdk.app.statistic.a.a(aVar, com.alipay.sdk.app.statistic.c.e, com.alipay.sdk.app.statistic.c.h, th);
            str = "";
        }
        if (TextUtils.isEmpty(str)) {
            com.alipay.sdk.app.statistic.a.a(aVar, com.alipay.sdk.app.statistic.c.e, com.alipay.sdk.app.statistic.c.i, "apdid == null");
        }
        com.alipay.sdk.util.c.a(com.alipay.sdk.cons.a.x, "apdid:" + str);
        return str;
    }

    public static String c() {
        Context b2 = com.alipay.sdk.sys.b.a().b();
        SharedPreferences sharedPreferences = b2.getSharedPreferences(f4623a, 0);
        String string = sharedPreferences.getString(b, null);
        String str = string;
        if (TextUtils.isEmpty(string)) {
            str = TextUtils.isEmpty(com.alipay.sdk.tid.b.a(b2).a()) ? g() : com.alipay.sdk.util.a.a(b2).b();
            sharedPreferences.edit().putString(b, str).apply();
        }
        return str;
    }

    private static String c(Context context) {
        WifiInfo connectionInfo = ((WifiManager) context.getApplicationContext().getSystemService("wifi")).getConnectionInfo();
        return connectionInfo != null ? connectionInfo.getSSID() : "-1";
    }

    private static String c(com.alipay.sdk.sys.a aVar, Context context, HashMap<String, String> hashMap) {
        try {
            return (String) Executors.newFixedThreadPool(2).submit(new d(aVar, context, hashMap)).get(m.ag, TimeUnit.MILLISECONDS);
        } catch (Throwable th) {
            com.alipay.sdk.app.statistic.a.a(aVar, com.alipay.sdk.app.statistic.c.e, com.alipay.sdk.app.statistic.c.j, th);
            return "";
        }
    }

    public static String d() {
        Context b2 = com.alipay.sdk.sys.b.a().b();
        SharedPreferences sharedPreferences = b2.getSharedPreferences(f4623a, 0);
        String string = sharedPreferences.getString(f4624c, null);
        String str = string;
        if (TextUtils.isEmpty(string)) {
            if (TextUtils.isEmpty(com.alipay.sdk.tid.b.a(b2).a())) {
                String e = com.alipay.sdk.sys.b.a().e();
                str = TextUtils.isEmpty(e) ? g() : e.substring(3, 18);
            } else {
                str = com.alipay.sdk.util.a.a(b2).a();
            }
            sharedPreferences.edit().putString(f4624c, str).apply();
        }
        return str;
    }

    private static String d(Context context) {
        WifiInfo connectionInfo = ((WifiManager) context.getApplicationContext().getSystemService("wifi")).getConnectionInfo();
        return connectionInfo != null ? connectionInfo.getBSSID() : "00";
    }

    private static String e() {
        return "1";
    }

    private static String f() {
        return "-1;-1";
    }

    private static String g() {
        String hexString = Long.toHexString(System.currentTimeMillis());
        Random random = new Random();
        return hexString + (random.nextInt(9000) + 1000);
    }

    public String a() {
        return this.g;
    }

    public String a(com.alipay.sdk.sys.a aVar, com.alipay.sdk.tid.b bVar) {
        Context b2 = com.alipay.sdk.sys.b.a().b();
        com.alipay.sdk.util.a a2 = com.alipay.sdk.util.a.a(b2);
        if (TextUtils.isEmpty(this.e)) {
            String b3 = n.b();
            String c2 = n.c();
            String d2 = n.d(b2);
            String f = n.f(b2);
            String e = n.e(b2);
            String b4 = b(b2);
            this.e = "Msp/15.7.4 (" + b3 + ";" + c2 + ";" + d2 + ";" + f + ";" + e + ";" + b4;
        }
        String b5 = com.alipay.sdk.util.a.b(b2).b();
        String g = n.g(b2);
        String e2 = e();
        String a3 = a2.a();
        String b6 = a2.b();
        String d3 = d();
        String c3 = c();
        if (bVar != null) {
            this.g = bVar.b();
        }
        String replace = Build.MANUFACTURER.replace(";", " ");
        String replace2 = Build.MODEL.replace(";", " ");
        boolean d4 = com.alipay.sdk.sys.b.d();
        String d5 = a2.d();
        String c4 = c(b2);
        String d6 = d(b2);
        StringBuilder sb = new StringBuilder();
        sb.append(this.e);
        sb.append(";");
        sb.append(b5);
        sb.append(";");
        sb.append(g);
        sb.append(";");
        sb.append(e2);
        sb.append(";");
        sb.append(a3);
        sb.append(";");
        sb.append(b6);
        sb.append(";");
        sb.append(this.g);
        sb.append(";");
        sb.append(replace);
        sb.append(";");
        sb.append(replace2);
        sb.append(";");
        sb.append(d4);
        sb.append(";");
        sb.append(d5);
        sb.append(";");
        sb.append(f());
        sb.append(";");
        sb.append(this.f);
        sb.append(";");
        sb.append(d3);
        sb.append(";");
        sb.append(c3);
        sb.append(";");
        sb.append(c4);
        sb.append(";");
        sb.append(d6);
        if (bVar != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("tid", com.alipay.sdk.tid.b.a(b2).a());
            hashMap.put(com.alipay.sdk.cons.b.g, com.alipay.sdk.sys.b.a().e());
            String c5 = c(aVar, b2, hashMap);
            if (!TextUtils.isEmpty(c5)) {
                sb.append(";");
                sb.append(c5);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
