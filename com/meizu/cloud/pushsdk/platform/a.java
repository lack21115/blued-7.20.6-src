package com.meizu.cloud.pushsdk.platform;

import android.text.TextUtils;
import com.meizu.cloud.pushinternal.DebugLogger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: source-8303388-dex2jar.jar:com/meizu/cloud/pushsdk/platform/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static Map<String, String> f10565a = a();
    private static final List<String> b = new ArrayList(f10565a.keySet());

    public static String a(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            if (str.length() > 3) {
                String substring = str.substring(0, 3);
                if (f10565a.containsKey(substring)) {
                    String str3 = f10565a.get(substring);
                    str2 = str.substring(3);
                    try {
                        char[] cArr = new char[str2.length() / 2];
                        int i = 0;
                        int i2 = 0;
                        while (true) {
                            int i3 = i2;
                            if (i >= str2.length() / 2) {
                                return new String(String.valueOf(cArr).getBytes("iso-8859-1"), "UTF-8");
                            }
                            int i4 = i3;
                            if (i3 == str3.length()) {
                                i4 = 0;
                            }
                            int i5 = i * 2;
                            cArr[i] = (char) (((char) Integer.valueOf(str2.substring(i5, i5 + 2), 16).intValue()) ^ str3.charAt(i4));
                            i++;
                            i2 = i4 + 1;
                        }
                    } catch (Exception e) {
                        DebugLogger.e("PushIdEncryptUtils", "invalid pushId encryption " + str2);
                        return str;
                    }
                }
            }
        } catch (Exception e2) {
            str2 = str;
        }
        return str;
    }

    private static Map<String, String> a() {
        if (a(f10565a)) {
            synchronized (a.class) {
                try {
                    if (a(f10565a)) {
                        TreeMap treeMap = new TreeMap();
                        f10565a = treeMap;
                        treeMap.put("UCI", "v9tC0Myz1MGwXRFy");
                        f10565a.put("G3G", "XAsFqhhaf4gKpmAi");
                        f10565a.put("V5R", "cOqH18NXwBtZVkvz");
                        f10565a.put("0XC", "IgSEKZ3Ea6Pm4woS");
                        f10565a.put("Z9K", "pH6J9DMPNgqQp8m8");
                        f10565a.put("EIM", "K11Rs9HAKRXeNwq8");
                        f10565a.put("SO7", "T8LquL1DvwVcogiU");
                        f10565a.put("DDI", "d02F6ttOtV05MYCQ");
                        f10565a.put("ULY", "ToZZIhAywnUfHShN");
                        f10565a.put("0EV", "r5D5RRwQhfV0AYLb");
                        f10565a.put("N6A", "QAtSBFcXnQoUgHO2");
                        f10565a.put("S5Q", "sDWLrZINnum227am");
                        f10565a.put("RA5", "4Uq3Ruxo1FTBdHQE");
                        f10565a.put("J04", "N5hViUTdLCpN59H0");
                        f10565a.put("B68", "EY3sH1KKtalg5ZaT");
                        f10565a.put("9IW", "q1u0MiuFyim4pCYY");
                        f10565a.put("UU3", "syLnkkd8AqNykVV7");
                        f10565a.put("Z49", "V00FiWu124yE91sH");
                        f10565a.put("BNA", "rPP7AK1VWpKEry3p");
                        f10565a.put("WXG", "om8w5ahkJJgpAH9v");
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f10565a;
    }

    public static <K, V> boolean a(Map<K, V> map) {
        return map == null || map.isEmpty();
    }
}
