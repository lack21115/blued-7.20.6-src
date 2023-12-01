package com.alipay.apmobilesecuritysdk.d;

import android.content.Context;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: source-6737240-dex2jar.jar:com/alipay/apmobilesecuritysdk/d/e.class */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    private static Map<String, String> f4548a;
    private static final String[] b = {"AD1", "AD2", "AD3", "AD8", "AD9", "AD10", "AD11", "AD12", "AD14", "AD15", "AD16", "AD18", "AD20", "AD21", "AD23", "AD24", "AD26", "AD27", "AD28", "AD29", "AD30", "AD31", "AD34", "AA1", "AA2", "AA3", "AA4", "AC4", "AC10", "AE1", "AE2", "AE3", "AE4", "AE5", "AE6", "AE7", "AE8", "AE9", "AE10", "AE11", "AE12", "AE13", "AE14", "AE15"};

    private static String a(Map<String, String> map) {
        StringBuffer stringBuffer = new StringBuffer();
        ArrayList arrayList = new ArrayList(map.keySet());
        Collections.sort(arrayList);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= arrayList.size()) {
                return stringBuffer.toString();
            }
            String str = (String) arrayList.get(i2);
            String str2 = map.get(str);
            String str3 = "";
            String str4 = str2;
            if (str2 == null) {
                str4 = "";
            }
            StringBuilder sb = new StringBuilder();
            if (i2 != 0) {
                str3 = "&";
            }
            sb.append(str3);
            sb.append(str);
            sb.append("=");
            sb.append(str4);
            stringBuffer.append(sb.toString());
            i = i2 + 1;
        }
    }

    public static Map<String, String> a(Context context, Map<String, String> map) {
        Map<String, String> map2;
        synchronized (e.class) {
            try {
                if (f4548a == null) {
                    c(context, map);
                }
                f4548a.putAll(d.a());
                map2 = f4548a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return map2;
    }

    public static void a() {
        synchronized (e.class) {
            try {
                f4548a = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static String b(Context context, Map<String, String> map) {
        String a2;
        synchronized (e.class) {
            try {
                a(context, map);
                TreeMap treeMap = new TreeMap();
                String[] strArr = b;
                int length = strArr.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < length) {
                        String str = strArr[i2];
                        if (f4548a.containsKey(str)) {
                            treeMap.put(str, f4548a.get(str));
                        }
                        i = i2 + 1;
                    } else {
                        a2 = com.alipay.security.mobile.module.a.a.b.a(a(treeMap));
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return a2;
    }

    private static void c(Context context, Map<String, String> map) {
        synchronized (e.class) {
            try {
                TreeMap treeMap = new TreeMap();
                f4548a = treeMap;
                treeMap.putAll(b.a(context, map));
                f4548a.putAll(d.a(context));
                f4548a.putAll(c.a(context));
                f4548a.putAll(a.a(context, map));
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
