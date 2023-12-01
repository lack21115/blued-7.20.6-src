package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.mobads.sdk.api.IXAdContainerFactory;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/internal/ch.class */
public class ch {
    public static final String b = "404";

    /* renamed from: c  reason: collision with root package name */
    protected final bq f6539c = bq.a();
    private Context g;

    /* renamed from: a  reason: collision with root package name */
    public static final String f6538a = w.b;
    private static ch f = new ch();
    public static volatile String d = "";
    public static volatile String e = "";
    private static AtomicBoolean h = new AtomicBoolean(false);
    private static String i = "";
    private static AtomicBoolean j = new AtomicBoolean(false);
    private static String k = "";

    private ch() {
    }

    public static ch a() {
        return f;
    }

    private String a(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    private String a(String str, String str2) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            String str3 = (String) cls.getDeclaredMethod(MonitorConstants.CONNECT_TYPE_GET, String.class).invoke(cls, str);
            return TextUtils.isEmpty(str3) ? str2 : str3;
        } catch (Throwable th) {
            this.f6539c.a(th);
            return str2;
        }
    }

    private String a(String str, Object... objArr) {
        IXAdContainerFactory c2;
        z a2 = z.a();
        if (a2 == null || (c2 = a2.c()) == null) {
            return "";
        }
        Object remoteParam = c2.getRemoteParam(str, objArr);
        return remoteParam instanceof String ? (String) remoteParam : "";
    }

    private void a(String str, String str2, HashMap<String, String> hashMap) {
        Uri.Builder builder = new Uri.Builder();
        try {
            builder.appendQueryParameter("type", str2).appendQueryParameter(com.umeng.analytics.pro.bh.bg, "9.26").appendQueryParameter("appsid", a("appsid", new Object[0])).appendQueryParameter("v", "android_" + d() + "_" + ci.f).appendQueryParameter("pack", this.g != null ? this.g.getPackageName() : "").appendQueryParameter("sn", a("encodedSn", this.g)).appendQueryParameter("cuid", a("encodedCUID", this.g)).appendQueryParameter(com.umeng.analytics.pro.bh.x, "android").appendQueryParameter("osv", bj.a(this.g).c()).appendQueryParameter("romn", b()).appendQueryParameter("romv", c()).appendQueryParameter("bdr", "" + bj.a(this.g).a()).appendQueryParameter("brd", "" + a(bj.a(this.g).e()));
            String str3 = str;
            if (str != null) {
                str3 = str;
                if (str.length() > 128) {
                    int indexOf = str.indexOf(10);
                    if (indexOf <= 0) {
                        indexOf = 127;
                    }
                    str3 = str.substring(0, indexOf);
                }
            }
            builder.appendQueryParameter("reason", str3);
            if (hashMap != null) {
                for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                    builder.appendQueryParameter(entry.getKey(), entry.getValue());
                }
            }
        } catch (Throwable th) {
            this.f6539c.a(th);
        }
        am amVar = new am(f6538a, "POST");
        amVar.a(builder);
        amVar.b();
    }

    private String d() {
        String str = ci.e;
        if (ci.d.equals(str)) {
            try {
                double b2 = bw.b(bw.a(this.g));
                if (b2 > 0.0d) {
                    return String.valueOf(b2);
                }
            } catch (Throwable th) {
                this.f6539c.a(th);
            }
        }
        return str;
    }

    public void a(Context context) {
        if (this.g == null) {
            this.g = context;
        }
    }

    public void a(String str, String str2, String str3) {
        try {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("ad", str3);
            hashMap.put("stacktrace", str2);
            a(str, b, hashMap);
        } catch (Exception e2) {
            this.f6539c.a(e2);
        }
    }

    public String b() {
        try {
            if (h.compareAndSet(false, true)) {
                Class<?> cls = Class.forName("com.huawei.system.BuildEx");
                String str = (String) cls.getMethod("getOsBrand", new Class[0]).invoke(cls, new Object[0]);
                if (!TextUtils.isEmpty(str)) {
                    i = str;
                }
            }
            return i;
        } catch (Throwable th) {
            this.f6539c.a(th);
            return i;
        }
    }

    public String c() {
        try {
            if (j.get()) {
                return k;
            }
            if (!h.get()) {
                b();
            }
            if (i.equalsIgnoreCase("")) {
                j.set(true);
                return "";
            }
            if (j.compareAndSet(false, true)) {
                String a2 = a("hw_sc.build.platform.version", "");
                if (!TextUtils.isEmpty(a2)) {
                    k = a2;
                }
            }
            return k;
        } catch (Throwable th) {
            this.f6539c.a(th);
            return k;
        }
    }
}
