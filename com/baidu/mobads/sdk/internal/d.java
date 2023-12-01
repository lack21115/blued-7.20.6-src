package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.am;
import com.cdo.oaps.ad.OapsKey;
import dalvik.system.DexClassLoader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;

/* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/internal/d.class */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static volatile d f9409a;

    private d() {
    }

    public static d a() {
        if (f9409a == null) {
            synchronized (d.class) {
                try {
                    if (f9409a == null) {
                        f9409a = new d();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f9409a;
    }

    public DexClassLoader a(String str, String str2, String str3, ClassLoader classLoader) {
        return new DexClassLoader(str, str2, str3, classLoader);
    }

    public String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException | NullPointerException e) {
            return str;
        }
    }

    public void a(double d, am.b bVar) {
        cn a2 = cn.a();
        String c2 = a2.c(w.f9443a);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("v", "" + d);
        hashMap.put(com.umeng.analytics.pro.bh.x, "android");
        hashMap.put(OapsKey.KEY_TYPE, a(bj.a((Context) null).d()));
        hashMap.put("bdr", a(bj.a((Context) null).b()));
        am amVar = new am(a2.a(c2, hashMap));
        amVar.a(bVar);
        amVar.b();
    }
}
