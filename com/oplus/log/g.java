package com.oplus.log;

import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.oplus.log.c;
import com.oplus.log.d.k;
import com.oplus.log.env.oversea.AreaEnv;
import com.oplus.log.env.test.TestAreaEnv;
import java.net.URLEncoder;

/* loaded from: source-8303388-dex2jar.jar:com/oplus/log/g.class */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private static final String f10683a = g.class.getName();
    private static String b = "";

    /* renamed from: c  reason: collision with root package name */
    private static String f10684c = "222%23";
    private static String d;

    private static String a() {
        String str;
        try {
            str = TestAreaEnv.getHostTest();
        } catch (Throwable th) {
            str = "";
        }
        try {
            return b.a() ? str : com.oplus.log.d.b.b() ? com.oplus.log.d.b.c() ? AreaEnv.getIndiaHost() : AreaEnv.getSingaporeHost() : com.oplus.log.e.a.a.a();
        } catch (Throwable th2) {
            if (!b.a()) {
                Log.e("NearX-HLog", "makeUploadUrl--> Don't find AreaEnv class");
                return "";
            }
            Log.e("NearX-HLog", "makeUploadUrl-->".concat(String.valueOf(th2)));
            th2.printStackTrace();
            return "";
        }
    }

    private static String a(c.a aVar) {
        return aVar == null ? "" : aVar.a();
    }

    private static String a(c.b bVar) {
        if (bVar == null) {
            return "";
        }
        String a2 = bVar.a() == null ? "" : bVar.a();
        String b2 = bVar.b() == null ? "" : bVar.b();
        String c2 = bVar.c() == null ? "" : bVar.c();
        return a2 + "/" + b2 + "/" + c2;
    }

    private static String a(String str) {
        try {
            if (TextUtils.isEmpty(d)) {
                d = f10684c + com.oplus.log.d.a.a("puwQbwBb9CMen91BMLD+UA==", str);
            }
            if (!TextUtils.isEmpty(d) && !f10684c.equals(d)) {
                return d;
            }
        } catch (Exception e) {
            if (b.a()) {
                e.printStackTrace();
            }
        }
        return str;
    }

    public static String a(String str, String str2, c.a aVar, c.b bVar, String str3) {
        return ((a() + "/usertrace/log/business/config").replace("business", str) + "?subType=" + str2 + "&imei=" + b(a(aVar)) + "&openId=" + a(a(bVar)) + "&tracePkg=" + str3).replaceAll(" ", "_");
    }

    public static String a(String str, String str2, String str3, int i, String str4, String str5, c.a aVar, c.b bVar, String str6) {
        StringBuilder sb = new StringBuilder((a() + "/usertrace/log/business/upload").replace("business", str));
        sb.append("?traceId=");
        sb.append(str2);
        sb.append("&businessVersion=");
        sb.append(com.oplus.log.d.b.c(com.oplus.log.d.b.a()));
        sb.append("&protocolVersion=3&errorCode=");
        sb.append(i);
        sb.append("&subType=");
        sb.append(str5);
        sb.append("&brand=");
        sb.append(com.oplus.log.d.f.b());
        sb.append("&model=");
        sb.append(Build.MODEL);
        sb.append("&osVersion=");
        sb.append(com.oplus.log.d.f.c());
        sb.append("&romVersion=");
        sb.append(com.oplus.log.d.f.a());
        sb.append("&androidVersion=");
        sb.append(Build.VERSION.RELEASE);
        sb.append("&imei=");
        sb.append(b(a(aVar)));
        sb.append("&openId=");
        sb.append(a(a(bVar)));
        sb.append("&tracePkg=");
        sb.append(str6);
        if (!TextUtils.isEmpty(str3)) {
            sb.append("&fileName=");
            sb.append(str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            sb.append("&errorMsg=");
            sb.append(str4);
        }
        return sb.toString().replaceAll(" ", "_");
    }

    public static String a(String str, String str2, String str3, int i, String str4, String str5, c.a aVar, c.b bVar, String str6, String str7, String str8, long j, String str9, String str10, a aVar2) {
        String replace = (a() + "/usertrace/log/business/report").replace("business", str);
        String b2 = b(a(aVar));
        String a2 = a(a(bVar));
        String a3 = k.a(str2, str8, j, i, str5, b2, a2, str6, str7, str3, str4, str9, str10, aVar2);
        StringBuilder sb = new StringBuilder(replace);
        sb.append("?specificId=");
        sb.append(str2);
        sb.append("&reportReason=");
        sb.append(URLEncoder.encode(str8));
        sb.append("&program=");
        sb.append(str7);
        sb.append("&ts=");
        sb.append(j);
        sb.append("&sign=");
        sb.append(a3);
        sb.append("&businessVersion=");
        sb.append(com.oplus.log.d.b.c(com.oplus.log.d.b.a()));
        sb.append("&protocolVersion=3&errorCode=");
        sb.append(i);
        sb.append("&subType=");
        sb.append(str5);
        sb.append("&brand=");
        sb.append(com.oplus.log.d.f.b());
        sb.append("&model=");
        sb.append(Build.MODEL);
        sb.append("&osVersion=");
        sb.append(com.oplus.log.d.f.c());
        sb.append("&romVersion=");
        sb.append(com.oplus.log.d.f.a());
        sb.append("&androidVersion=");
        sb.append(Build.VERSION.RELEASE);
        sb.append("&imei=");
        sb.append(b2);
        sb.append("&openId=");
        sb.append(a2);
        sb.append("&tracePkg=");
        sb.append(str6);
        if (!TextUtils.isEmpty(str3)) {
            sb.append("&fileName=");
            sb.append(str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            sb.append("&errorMsg=");
            sb.append(str4);
        }
        String sb2 = sb.toString();
        aVar2.a("NearX-HLog", "签名后请求空格替换前参数: data: ".concat(String.valueOf(sb2)));
        String replaceAll = sb2.replaceAll(" ", "_");
        aVar2.a("NearX-HLog", "签名后请求空格替换后参数: data: ".concat(String.valueOf(replaceAll)));
        return replaceAll;
    }

    private static String b(String str) {
        try {
            if (TextUtils.isEmpty(b)) {
                b = f10684c + com.oplus.log.d.a.a("puwQbwBb9CMen91BMLD+UA==", str);
            }
            if (!TextUtils.isEmpty(b) && !f10684c.equals(b)) {
                return b;
            }
        } catch (Exception e) {
            if (b.a()) {
                e.printStackTrace();
            }
        }
        return str;
    }
}
