package com.efs.sdk.base.core.a;

import android.text.TextUtils;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.core.util.PackageUtil;
import com.huawei.hms.framework.common.ContainerUtils;
import com.umeng.analytics.pro.bh;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

/* loaded from: source-7206380-dex2jar.jar:com/efs/sdk/base/core/a/c.class */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    String f8116a;
    String b;

    /* renamed from: c  reason: collision with root package name */
    String f8117c;
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
        cVar.f8116a = ControllerCenter.getGlobalEnvStruct().getAppid();
        cVar.b = ControllerCenter.getGlobalEnvStruct().getSecret();
        cVar.l = ControllerCenter.getGlobalEnvStruct().getUid();
        cVar.j = "1.3.10.umeng";
        cVar.f8117c = PackageUtil.getAppVersionName(ControllerCenter.getGlobalEnvStruct().mAppContext);
        cVar.i = String.valueOf(com.efs.sdk.base.core.config.a.c.a().d.f8143a);
        cVar.k = "1.6.4";
        return cVar;
    }

    public final String b() {
        a.a();
        String valueOf = String.valueOf(a.b() / 1000);
        String a2 = com.efs.sdk.base.core.util.b.b.a(com.efs.sdk.base.core.util.b.a.a(this.l + valueOf, this.b));
        TreeMap treeMap = new TreeMap();
        treeMap.put("app", this.f8116a);
        treeMap.put("sd", a2);
        if (!TextUtils.isEmpty(this.d)) {
            treeMap.put("cp", this.d);
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
        treeMap.put("ver", this.f8117c);
        treeMap.put("um_sdk_ver", this.k);
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (Map.Entry entry : treeMap.entrySet()) {
            String str3 = ((String) entry.getKey()) + "=" + ((String) entry.getValue());
            sb2.append(str3);
            sb.append(str3);
            sb.append(ContainerUtils.FIELD_DELIMITER);
        }
        String a3 = com.efs.sdk.base.core.util.b.b.a(sb2.toString() + this.b);
        sb.append("sign=");
        sb.append(a3);
        Log.d("efs.config", sb.toString());
        return com.efs.sdk.base.core.util.b.b.b(sb.toString());
    }
}
