package com.autonavi.aps.amapapi.trans;

import android.content.Context;
import android.provider.MediaStore;
import android.security.Credentials;
import com.amap.api.col.p0003sl.ho;
import com.amap.api.col.p0003sl.hr;
import com.amap.api.col.p0003sl.hu;
import com.amap.api.col.p0003sl.hz;
import com.amap.api.col.p0003sl.ib;
import com.amap.api.col.p0003sl.ju;
import com.amap.api.col.p0003sl.kb;
import com.amap.api.col.p0003sl.kc;
import com.autonavi.aps.amapapi.utils.i;
import com.umeng.analytics.pro.bh;
import java.util.HashMap;
import java.util.Locale;

/* loaded from: source-8756600-dex2jar.jar:com/autonavi/aps/amapapi/trans/c.class */
public final class c {
    private static c b;

    /* renamed from: a  reason: collision with root package name */
    ju f9270a;

    /* renamed from: c  reason: collision with root package name */
    private Context f9271c;
    private int d = com.autonavi.aps.amapapi.utils.b.i;
    private boolean e = false;
    private int f = 0;

    private c(Context context) {
        this.f9270a = null;
        this.f9271c = null;
        try {
            hu.a().a(context);
        } catch (Throwable th) {
        }
        this.f9271c = context;
        this.f9270a = ju.a();
    }

    public static c a(Context context) {
        if (b == null) {
            b = new c(context);
        }
        return b;
    }

    public final kc a(d dVar) throws Throwable {
        if (this.e) {
            dVar.setHttpProtocol(kb.c.HTTPS);
        }
        return ju.a(dVar);
    }

    public final d a(Context context, byte[] bArr, String str, String str2, boolean z) {
        d dVar;
        try {
            HashMap hashMap = new HashMap(16);
            d dVar2 = new d(context, com.autonavi.aps.amapapi.utils.b.c());
            try {
                hashMap.put("Content-Type", "application/octet-stream");
                hashMap.put("Accept-Encoding", "gzip");
                hashMap.put("gzipped", "1");
                hashMap.put("Connection", com.anythink.expressad.foundation.g.f.g.c.f7906c);
                hashMap.put("User-Agent", "AMAP_Location_SDK_Android 6.1.0");
                hashMap.put(Credentials.EXTRA_PUBLIC_KEY, ho.f(context));
                hashMap.put("enginever", com.autonavi.aps.amapapi.utils.b.f9278a);
                String a2 = hr.a();
                String a3 = hr.a(context, a2, "key=" + ho.f(context));
                hashMap.put("ts", a2);
                hashMap.put("scode", a3);
                if (Double.valueOf(com.autonavi.aps.amapapi.utils.b.f9278a).doubleValue() >= 5.3d) {
                    hashMap.put("aps_s_src", "openapi");
                }
                hashMap.put("encr", "1");
                dVar2.b(hashMap);
                String str3 = z ? "loc" : "locf";
                dVar2.b(true);
                dVar2.a(String.format(Locale.US, "platform=Android&sdkversion=%s&product=%s&loc_channel=%s", "6.1.0", str3, 3));
                dVar2.a(z);
                dVar2.b(str);
                dVar2.c(str2);
                dVar2.c(i.a(bArr));
                dVar2.setProxy(hz.a(context));
                HashMap hashMap2 = new HashMap(16);
                hashMap2.put(MediaStore.EXTRA_OUTPUT, "bin");
                hashMap2.put(bh.bt, "3103");
                int i = this.f;
                if (i == 0) {
                    hashMap2.remove("custom");
                } else if (i == 1) {
                    hashMap2.put("custom", "language:cn");
                } else if (i != 2) {
                    hashMap2.remove("custom");
                } else {
                    hashMap2.put("custom", "language:en");
                }
                dVar2.a(hashMap2);
                dVar2.setConnectionTimeout(this.d);
                dVar2.setSoTimeout(this.d);
                dVar = dVar2;
                if (this.e) {
                    dVar2.setHttpProtocol(kb.c.HTTPS);
                    return dVar2;
                }
            } catch (Throwable th) {
                return dVar2;
            }
        } catch (Throwable th2) {
            dVar = null;
        }
        return dVar;
    }

    public final String a(Context context, double d, double d2) {
        try {
            HashMap hashMap = new HashMap(16);
            d dVar = new d(context, com.autonavi.aps.amapapi.utils.b.c());
            hashMap.clear();
            hashMap.put("Content-Type", "application/x-www-form-urlencoded");
            hashMap.put("Connection", com.anythink.expressad.foundation.g.f.g.c.f7906c);
            hashMap.put("User-Agent", "AMAP_Location_SDK_Android 6.1.0");
            HashMap hashMap2 = new HashMap(16);
            hashMap2.put("custom", "26260A1F00020002");
            hashMap2.put("key", ho.f(context));
            int i = this.f;
            if (i == 0) {
                hashMap2.remove("language");
            } else if (i == 1) {
                hashMap2.put("language", "zh-CN");
            } else if (i != 2) {
                hashMap2.remove("language");
            } else {
                hashMap2.put("language", "en");
            }
            hashMap2.put("curLocationType", i.m(this.f9271c) ? "coarseLoc" : "fineLoc");
            String a2 = hr.a();
            String a3 = hr.a(context, a2, ib.b(hashMap2));
            hashMap2.put("ts", a2);
            hashMap2.put("scode", a3);
            dVar.b(("output=json&radius=1000&extensions=all&location=" + d2 + "," + d).getBytes("UTF-8"));
            dVar.b(false);
            dVar.a(true);
            dVar.a(String.format(Locale.US, "platform=Android&sdkversion=%s&product=%s&loc_channel=%s", "6.1.0", "loc", 3));
            dVar.a(hashMap2);
            dVar.b(hashMap);
            dVar.setProxy(hz.a(context));
            dVar.setConnectionTimeout(com.autonavi.aps.amapapi.utils.b.i);
            dVar.setSoTimeout(com.autonavi.aps.amapapi.utils.b.i);
            dVar.c("http://dualstack-arestapi.amap.com/v3/geocode/regeo");
            dVar.b("http://restsdk.amap.com/v3/geocode/regeo");
            if (this.e) {
                dVar.setHttpProtocol(kb.c.HTTPS);
            }
            return new String(ju.a(dVar).f5264a, "utf-8");
        } catch (Throwable th) {
            return null;
        }
    }

    public final void a(long j, boolean z, int i) {
        try {
            this.e = z;
            this.d = Long.valueOf(j).intValue();
            this.f = i;
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "LocNetManager", "setOption");
        }
    }
}
