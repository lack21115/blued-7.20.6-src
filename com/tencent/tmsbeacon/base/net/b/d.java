package com.tencent.tmsbeacon.base.net.b;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.tmsbeacon.a.c.f;
import com.tencent.tmsbeacon.d.g;
import com.tencent.tmsbeacon.pack.RequestPackage;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/base/net/b/d.class */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    private static Map<String, String> f39503a;

    public static RequestPackage a(int i, byte[] bArr, Map<String, String> map, String str) {
        com.tencent.tmsbeacon.a.c.c d = com.tencent.tmsbeacon.a.c.c.d();
        com.tencent.tmsbeacon.a.c.e l = com.tencent.tmsbeacon.a.c.e.l();
        RequestPackage requestPackage = new RequestPackage();
        requestPackage.model = f.e().h();
        requestPackage.osVersion = l.s();
        requestPackage.platformId = d.g();
        requestPackage.appkey = str;
        requestPackage.appVersion = com.tencent.tmsbeacon.a.c.b.a();
        requestPackage.sdkId = d.h();
        requestPackage.sdkVersion = d.i();
        requestPackage.cmd = i;
        requestPackage.encryType = (byte) 3;
        requestPackage.zipType = (byte) 2;
        requestPackage.sBuffer = bArr;
        requestPackage.reserved = b(map);
        return requestPackage;
    }

    public static Map<String, String> a() {
        Map<String, String> map;
        synchronized (d.class) {
            try {
                if (f39503a == null) {
                    HashMap hashMap = new HashMap(4);
                    f39503a = hashMap;
                    hashMap.put("wup_version", "3.0");
                    f39503a.put("TYPE_COMPRESS", String.valueOf(2));
                    f39503a.put("encr_type", "rsapost");
                    f39503a.put("Content-Type", "jce");
                    g b = g.b();
                    if (b != null) {
                        f39503a.put("bea_key", b.d());
                    }
                }
                map = f39503a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return map;
    }

    public static void a(long j, long j2, String str) {
        com.tencent.tmsbeacon.base.util.c.a("[BeaconNet]", "fixBeaconInfo, serverTime: " + j2 + ",ip: " + str, new Object[0]);
        com.tencent.tmsbeacon.a.c.c d = com.tencent.tmsbeacon.a.c.c.d();
        d.b(str);
        d.a(j2 - ((j + new Date().getTime()) / 2));
    }

    private static void a(String str, String str2) {
        com.tencent.tmsbeacon.base.util.c.a("[BeaconNet]", "update strategy sid: %s, max_time: %s", str, str2);
        g.b().a(str, str2);
    }

    public static boolean a(String str) {
        int length = str.length();
        boolean z = true;
        while (true) {
            int i = length - 1;
            if (i < 0) {
                return z;
            }
            char charAt = str.charAt(i);
            if (charAt >= ' ') {
                length = i;
                if (charAt >= 127) {
                }
            }
            z = false;
            length = i;
        }
    }

    public static boolean a(Map<String, List<String>> map) {
        if (map == null) {
            return false;
        }
        if (map.containsKey("encrypt-status")) {
            com.tencent.tmsbeacon.base.util.c.a("[BeaconNet]", "parse response header fail! cause by svr encrypt error!", new Object[0]);
            return false;
        } else if (map.containsKey("session_id") && map.containsKey("max_time")) {
            List<String> list = map.get("session_id");
            List<String> list2 = map.get("max_time");
            String str = null;
            String str2 = list != null ? list.get(0) : null;
            if (list2 != null) {
                str = list2.get(0);
            }
            if (str2 == null || str == null) {
                return true;
            }
            a(str2, str);
            return true;
        } else {
            return true;
        }
    }

    public static NetworkInfo b() {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) com.tencent.tmsbeacon.a.c.c.d().c().getSystemService(Context.CONNECTIVITY_SERVICE);
            if (connectivityManager == null) {
                return null;
            }
            return connectivityManager.getActiveNetworkInfo();
        } catch (Throwable th) {
            com.tencent.tmsbeacon.base.util.c.a(th);
            return null;
        }
    }

    public static String b(Map<String, String> map) {
        if (map == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            if (key.trim().length() <= 0 || !a(key)) {
                com.tencent.tmsbeacon.base.util.c.e("[core] '%s' should be ASCII code in 32-126!", key);
            } else {
                String trim = key.trim();
                sb.append("&");
                sb.append(trim.replace("|", "%7C").replace("&", "%26").replace("=", "%3D"));
                sb.append("=");
                String value = entry.getValue();
                if (value != null) {
                    sb.append(value.trim().replace('\n', ' ').replace('\r', ' ').replace("|", "%7C").replace("&", "%26").replace("=", "%3D"));
                }
            }
        }
        return sb.length() > 0 ? sb.substring(1) : "";
    }

    public static String c() {
        NetworkInfo b = b();
        if (b == null) {
            return "unknown";
        }
        if (b.getType() == 1) {
            return "wifi";
        }
        String extraInfo = b.getExtraInfo();
        String str = extraInfo;
        if (extraInfo != null) {
            str = extraInfo;
            if (extraInfo.length() > 64) {
                str = extraInfo.substring(0, 64);
            }
        }
        return "" + str;
    }

    public static void c(Map<String, String> map) {
        if (map != null) {
            if (map.containsKey("encrypt-status")) {
                com.tencent.tmsbeacon.base.util.c.a("[BeaconNet]", "parse response header fail! cause by svr encrypt error!", new Object[0]);
            }
            if (map.containsKey("session_id") && map.containsKey("max_time")) {
                a(map.get("session_id"), map.get("max_time"));
            }
        }
    }

    public static boolean d() {
        NetworkInfo b = b();
        return b != null && b.isConnected();
    }
}
