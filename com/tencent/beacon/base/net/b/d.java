package com.tencent.beacon.base.net.b;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.beacon.a.b.g;
import com.tencent.beacon.a.c.f;
import com.tencent.beacon.e.h;
import com.tencent.beacon.pack.RequestPackage;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/beacon/base/net/b/d.class */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    private static Map<String, String> f21283a;

    public static RequestPackage a(int i, byte[] bArr, Map<String, String> map, String str) {
        com.tencent.beacon.a.c.c d = com.tencent.beacon.a.c.c.d();
        com.tencent.beacon.a.c.e l = com.tencent.beacon.a.c.e.l();
        RequestPackage requestPackage = new RequestPackage();
        requestPackage.model = f.e().h();
        requestPackage.osVersion = l.s();
        requestPackage.platformId = d.h();
        requestPackage.appkey = str;
        requestPackage.appVersion = com.tencent.beacon.a.c.b.a();
        requestPackage.sdkId = d.i();
        requestPackage.sdkVersion = d.j();
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
                if (f21283a == null) {
                    HashMap hashMap = new HashMap(4);
                    f21283a = hashMap;
                    hashMap.put("wup_version", "3.0");
                    f21283a.put("TYPE_COMPRESS", String.valueOf(2));
                    f21283a.put("encr_type", "rsapost");
                    f21283a.put("Content-Type", "jce");
                    h b = h.b();
                    if (b != null) {
                        f21283a.put("bea_key", b.d());
                    }
                }
                map = f21283a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return map;
    }

    public static Map<String, String> a(String str, Map<String, String> map) {
        if (map == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        int i = 0;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String valueOf = String.valueOf(entry.getKey());
            int length = valueOf.trim().length();
            if (length <= 0 || !a(valueOf)) {
                com.tencent.beacon.base.util.c.e("[core] '%s' should be ASCII code in 32-126!", valueOf);
                g.e().a("102", "[event] eventName: " + str + ", key: " + valueOf + " should be ASCII code in 32-126!");
            } else {
                String trim = valueOf.trim();
                String str2 = trim;
                if (length > 64) {
                    str2 = trim.substring(0, 64);
                    String str3 = "[event] eventName: " + str + ", key: " + str2 + " should be less than 64!";
                    g.e().a("102", str3);
                    com.tencent.beacon.base.util.e.a(str3);
                }
                String replace = str2.replace("|", "%7C").replace(ContainerUtils.FIELD_DELIMITER, "%26").replace("=", "%3D");
                String valueOf2 = String.valueOf(entry.getValue());
                String trim2 = valueOf2 == null ? "" : valueOf2.trim();
                String str4 = trim2;
                if (trim2.length() > 10240) {
                    String str5 = "[event] eventName: " + str + ", key: " + replace + "'s value > 10K.";
                    g.e().a("103", str5);
                    com.tencent.beacon.base.util.e.a(str5);
                    str4 = trim2.substring(0, 10240);
                }
                String replace2 = str4.replace('\n', ' ').replace('\r', ' ').replace("|", "%7C").replace(ContainerUtils.FIELD_DELIMITER, "%26").replace("=", "%3D");
                hashMap.put(replace, replace2);
                i += replace.length() + replace2.length();
            }
        }
        if (i > 46080) {
            String str6 = "[event] eventName: " + str + " params > 45K";
            g.e().a("104", str6);
            com.tencent.beacon.base.util.e.a(str6);
            return null;
        }
        return hashMap;
    }

    public static void a(long j, long j2, String str) {
        com.tencent.beacon.base.util.c.a("[BeaconNet]", "fixBeaconInfo, serverTime: " + j2 + ",ip: " + str, new Object[0]);
        com.tencent.beacon.a.c.c d = com.tencent.beacon.a.c.c.d();
        d.b(str);
        d.a(j2 - ((j + new Date().getTime()) / 2));
    }

    private static void a(String str, String str2) {
        com.tencent.beacon.base.util.c.a("[BeaconNet]", "update strategy sid: %s, max_time: %s", str, str2);
        h.b().a(str, str2);
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
            com.tencent.beacon.base.util.c.a("[BeaconNet]", "parse response header fail! cause by svr encrypt error!", new Object[0]);
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
            ConnectivityManager connectivityManager = (ConnectivityManager) com.tencent.beacon.a.c.c.d().c().getSystemService(Context.CONNECTIVITY_SERVICE);
            if (connectivityManager == null) {
                return null;
            }
            return connectivityManager.getActiveNetworkInfo();
        } catch (Throwable th) {
            com.tencent.beacon.base.util.c.a(th);
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
                com.tencent.beacon.base.util.c.e("[core] '%s' should be ASCII code in 32-126!", key);
            } else {
                String trim = key.trim();
                sb.append(ContainerUtils.FIELD_DELIMITER);
                sb.append(trim.replace("|", "%7C").replace(ContainerUtils.FIELD_DELIMITER, "%26").replace("=", "%3D"));
                sb.append("=");
                String value = entry.getValue();
                if (value != null) {
                    sb.append(value.trim().replace('\n', ' ').replace('\r', ' ').replace("|", "%7C").replace(ContainerUtils.FIELD_DELIMITER, "%26").replace("=", "%3D"));
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
                com.tencent.beacon.base.util.c.a("[BeaconNet]", "parse response header fail! cause by svr encrypt error!", new Object[0]);
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
