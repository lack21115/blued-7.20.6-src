package com.efs.sdk.base.core.a;

import android.text.TextUtils;
import com.efs.sdk.base.BuildConfig;
import com.efs.sdk.base.EfsConstant;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.core.util.PackageUtil;
import com.umeng.analytics.pro.bh;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

/* loaded from: source-7206380-dex2jar.jar:com/efs/sdk/base/core/a/c.class */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    String f21722a;
    String b;

    /* renamed from: c  reason: collision with root package name */
    String f21723c;
    public String d;
    public int e;
    public String f;
    public byte g;
    public String h;
    String i;
    String j;
    String k;
    String l;
    public long m = 0;

    public static c a() {
        c cVar = new c();
        cVar.f21722a = ControllerCenter.getGlobalEnvStruct().getAppid();
        cVar.b = ControllerCenter.getGlobalEnvStruct().getSecret();
        cVar.l = ControllerCenter.getGlobalEnvStruct().getUid();
        cVar.j = BuildConfig.VERSION_NAME;
        cVar.f21723c = PackageUtil.getAppVersionName(ControllerCenter.getGlobalEnvStruct().mAppContext);
        cVar.i = String.valueOf(com.efs.sdk.base.core.config.a.c.a().d.f21749a);
        cVar.k = EfsConstant.UM_SDK_VERSION;
        return cVar;
    }

    public final String b() {
        a.a();
        String valueOf = String.valueOf(a.b() / 1000);
        String a2 = com.efs.sdk.base.core.util.b.b.a(com.efs.sdk.base.core.util.b.a.a(this.l + valueOf, this.b));
        TreeMap treeMap = new TreeMap();
        treeMap.put("app", this.f21722a);
        treeMap.put("sd", a2);
        if (!TextUtils.isEmpty(this.d)) {
            treeMap.put(com.alipay.sdk.app.statistic.c.f4610c, this.d);
        }
        if (this.g != 0) {
            treeMap.put(com.anythink.expressad.video.dynview.a.a.X, String.valueOf(this.e));
            treeMap.put("type", this.h);
            String str = this.f;
            String str2 = str;
            if (TextUtils.isEmpty(str)) {
                a.a();
                long b = a.b();
                str2 = String.format(Locale.SIMPLIFIED_CHINESE, "%d%04d", Long.valueOf(b), Integer.valueOf(new Random(b).nextInt(10000)));
            }
            treeMap.put("seq", str2);
        }
        treeMap.put("cver", this.i);
        treeMap.put(bh.x, "android");
        treeMap.put("sver", this.i);
        treeMap.put("tm", valueOf);
        treeMap.put("ver", this.f21723c);
        treeMap.put("um_sdk_ver", this.k);
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (Map.Entry entry : treeMap.entrySet()) {
            String str3 = ((String) entry.getKey()) + "=" + ((String) entry.getValue());
            sb2.append(str3);
            sb.append(str3);
            sb.append("&");
        }
        String a3 = com.efs.sdk.base.core.util.b.b.a(sb2.toString() + this.b);
        sb.append("sign=");
        sb.append(a3);
        Log.d("efs.config", sb.toString());
        return com.efs.sdk.base.core.util.b.b.b(sb.toString());
    }
}
