package com.alibaba.mtl.log.e;

import android.text.TextUtils;
import com.alibaba.mtl.log.model.LogField;
import com.android.internal.content.NativeLibraryHelper;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/mtl/log/e/h.class */
public class h {
    public static String a(String str, String str2, String str3, String str4, String str5, Map<String, String> map, String str6, String str7) {
        HashMap hashMap = new HashMap();
        if (map != null) {
            hashMap.putAll(map);
        }
        if (!TextUtils.isEmpty(str)) {
            hashMap.put(LogField.PAGE.toString(), str);
        }
        hashMap.put(LogField.EVENTID.toString(), str2);
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put(LogField.ARG1.toString(), str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            hashMap.put(LogField.ARG2.toString(), str4);
        }
        if (!TextUtils.isEmpty(str5)) {
            hashMap.put(LogField.ARG3.toString(), str5);
        }
        if (!TextUtils.isEmpty(str7)) {
            hashMap.put(LogField.RECORD_TIMESTAMP.toString(), str7);
        }
        if (!TextUtils.isEmpty(str6)) {
            hashMap.put(LogField.RESERVE3.toString(), str6);
        }
        return b(hashMap);
    }

    public static String a(Map<String, String> map) {
        boolean z;
        LogField logField;
        StringBuilder sb = new StringBuilder();
        LogField[] values = LogField.values();
        int length = values.length;
        int i = 0;
        while (true) {
            int i2 = i;
            String str = null;
            if (i2 >= length || (logField = values[i2]) == LogField.ARGS) {
                break;
            }
            if (map.containsKey(logField.toString())) {
                str = map.get(logField.toString()) + "";
                map.remove(logField.toString());
            }
            sb.append(d(str));
            sb.append("||");
            i = i2 + 1;
        }
        if (map.containsKey(LogField.ARGS.toString())) {
            sb.append(d(map.get(LogField.ARGS.toString()) + ""));
            map.remove(LogField.ARGS.toString());
            z = false;
        } else {
            z = true;
        }
        for (String str2 : map.keySet()) {
            String str3 = map.containsKey(str2) ? map.get(str2) + "" : null;
            if (z) {
                if ("StackTrace".equals(str2)) {
                    sb.append("StackTrace=====>");
                    sb.append(str3);
                } else {
                    sb.append(d(str2));
                    sb.append("=");
                    sb.append(str3);
                }
                z = false;
            } else if ("StackTrace".equals(str2)) {
                sb.append(",");
                sb.append("StackTrace=====>");
                sb.append(str3);
            } else {
                sb.append(",");
                sb.append(d(str2));
                sb.append("=");
                sb.append(str3);
            }
        }
        String sb2 = sb.toString();
        String str4 = sb2;
        if (!TextUtils.isEmpty(sb2)) {
            str4 = sb2;
            if (sb2.endsWith("||")) {
                str4 = sb2 + NativeLibraryHelper.CLEAR_ABI_OVERRIDE;
            }
        }
        return str4;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static Map<String, String> m8626a(Map<String, String> map) {
        HashMap hashMap = map;
        if (map == null) {
            hashMap = new HashMap();
        }
        try {
            String m = b.m();
            if (!TextUtils.isEmpty(m) && !hashMap.containsKey(LogField.USERNICK.toString())) {
                hashMap.put(LogField.USERNICK.toString(), m);
            }
            String j = b.j();
            if (!TextUtils.isEmpty(j) && !hashMap.containsKey(LogField.LL_USERNICK.toString())) {
                hashMap.put(LogField.LL_USERNICK.toString(), j);
            }
            String n = b.n();
            if (!TextUtils.isEmpty(n) && !hashMap.containsKey(LogField.USERID.toString())) {
                hashMap.put(LogField.USERID.toString(), n);
            }
            String k = b.k();
            if (!TextUtils.isEmpty(k) && !hashMap.containsKey(LogField.LL_USERID.toString())) {
                hashMap.put(LogField.LL_USERID.toString(), k);
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (!hashMap.containsKey(LogField.RECORD_TIMESTAMP.toString())) {
                hashMap.put(LogField.RECORD_TIMESTAMP.toString(), String.valueOf(currentTimeMillis));
            }
            if (!hashMap.containsKey(LogField.START_SESSION_TIMESTAMP.toString())) {
                hashMap.put(LogField.START_SESSION_TIMESTAMP.toString(), String.valueOf(com.alibaba.mtl.log.a.B));
            }
            Map<String, String> a = d.a(com.alibaba.mtl.log.a.getContext());
            if (a != null) {
                for (String str : a.keySet()) {
                    String str2 = a.get(str);
                    if (!TextUtils.isEmpty(str2) && !hashMap.containsKey(str)) {
                        hashMap.put(str, str2);
                    }
                }
            }
            String t = t();
            if (!TextUtils.isEmpty(t) && !hashMap.containsKey(LogField.RESERVES.toString())) {
                hashMap.put(LogField.RESERVES.toString(), t);
            }
            return hashMap;
        } catch (Throwable th) {
            return hashMap;
        }
    }

    public static String b(Map<String, String> map) {
        if (map == null || map.size() <= 0) {
            return null;
        }
        m8626a(map);
        return a(map);
    }

    private static String d(String str) {
        String str2 = str;
        if (TextUtils.isEmpty(str)) {
            str2 = NativeLibraryHelper.CLEAR_ABI_OVERRIDE;
        }
        return str2;
    }

    private static String t() {
        String wifiAddress;
        String str = "_ap=1";
        if (l.getWifiAddress(com.alibaba.mtl.log.a.getContext()) != null) {
            str = "_ap=1" + String.format("%s=%s", "_mac", wifiAddress);
        }
        String str2 = str;
        if (d.k()) {
            String q = d.q();
            str2 = str;
            if (!TextUtils.isEmpty(q)) {
                str2 = str + ",_did=" + q;
            }
        }
        return str2;
    }
}
