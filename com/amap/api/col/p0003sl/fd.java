package com.amap.api.col.p0003sl;

import com.amap.api.col.p0003sl.ia;
import com.amap.api.services.core.ServiceSettings;

/* renamed from: com.amap.api.col.3sl.fd  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/fd.class */
public final class fd {
    public static final String[] a = {"com.amap.api.services", "com.amap.api.search.admic"};

    public static ia a(boolean z) {
        try {
            return new ia.a("sea", "9.3.1", "AMAP SDK Android Search 9.3.1").a(a).a(z).a("9.3.1").a();
        } catch (hn e) {
            fe.a(e, "ConfigableConst", "getSDKInfo");
            return null;
        }
    }

    public static String a() {
        return ServiceSettings.getInstance().getProtocol() == 1 ? "http://restsdk.amap.com/v3" : "https://restsdk.amap.com/v3";
    }

    public static String b() {
        return ServiceSettings.getInstance().getProtocol() == 1 ? "http://restsdk.amap.com/v4" : "https://restsdk.amap.com/v4";
    }

    public static String c() {
        return ServiceSettings.getInstance().getProtocol() == 1 ? "http://restsdk.amap.com/v5" : "https://restsdk.amap.com/v5";
    }

    public static String d() {
        return ServiceSettings.getInstance().getProtocol() == 1 ? "http://yuntuapi.amap.com" : "https://yuntuapi.amap.com";
    }

    public static String e() {
        return ServiceSettings.getInstance().getProtocol() == 1 ? "http://restsdk.amap.com/rest/me/cpoint" : "https://restsdk.amap.com/rest/me/cpoint";
    }

    public static String f() {
        return ServiceSettings.getInstance().getProtocol() == 1 ? "http://m5.amap.com/ws/mapapi/shortaddress/transform" : "https://m5.amap.com/ws/mapapi/shortaddress/transform";
    }
}
