package com.blued.android.framework.urlmanager;

import com.blued.android.framework.utils.SharedPreferencesUtils;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/urlmanager/HostConfig.class */
public class HostConfig {
    private static int a;
    private static AREA b = AREA.UNKNOWN;
    private static final ConcurrentHashMap<AREA, ConcurrentHashMap<Object, String[]>> c = new ConcurrentHashMap<>();

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/urlmanager/HostConfig$AREA.class */
    public enum AREA {
        UNKNOWN,
        CHINA,
        OTHERS
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/urlmanager/HostConfig$ENV.class */
    public interface ENV {
    }

    public static String a() {
        StringBuilder sb = new StringBuilder();
        ConcurrentHashMap<Object, String[]> concurrentHashMap = c.get(d());
        if (concurrentHashMap != null) {
            for (Map.Entry<Object, String[]> entry : concurrentHashMap.entrySet()) {
                if (a >= entry.getValue().length) {
                    break;
                }
                sb.append(entry.getKey().toString());
                sb.append(": ");
                sb.append(entry.getValue()[a]);
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    public static String a(Object obj) {
        ConcurrentHashMap<Object, String[]> concurrentHashMap;
        String[] strArr;
        int i;
        return (obj == null || (concurrentHashMap = c.get(d())) == null || (strArr = concurrentHashMap.get(obj)) == null || (i = a) >= strArr.length) ? "" : strArr[i];
    }

    public static void a(int i) {
        a = i;
        c();
    }

    public static void a(AREA area) {
        b = area;
    }

    private static void a(AREA area, Object obj, String[] strArr) {
        if (obj == null || strArr == null || strArr.length <= 1) {
            return;
        }
        ConcurrentHashMap<Object, String[]> concurrentHashMap = c.get(area);
        if (concurrentHashMap != null) {
            concurrentHashMap.put(obj, strArr);
            return;
        }
        ConcurrentHashMap<Object, String[]> concurrentHashMap2 = new ConcurrentHashMap<>();
        concurrentHashMap2.put(obj, strArr);
        c.put(area, concurrentHashMap2);
    }

    public static void a(Object obj, String[] strArr) {
        a(AREA.CHINA, obj, strArr);
    }

    public static void b() {
        a = SharedPreferencesUtils.a().getInt("http_env", 0);
    }

    private static void c() {
        SharedPreferencesUtils.a().edit().putInt("http_env", a).commit();
    }

    private static AREA d() {
        AREA area = AREA.UNKNOWN;
        AREA area2 = b;
        if (area != area2) {
            return area2;
        }
        AREA e = e();
        if (e == AREA.OTHERS) {
            if (!c.containsKey(AREA.OTHERS)) {
                return AREA.CHINA;
            }
        } else if (!c.containsKey(AREA.CHINA)) {
            e = AREA.OTHERS;
        }
        return e;
    }

    private static AREA e() {
        try {
            String id = TimeZone.getDefault().getID();
            if ("Asia/Shanghai".equals(id) || "Asia/Chongqing".equals(id) || "Asia/Harbin".equals(id) || "Asia/Urumqi".equals(id)) {
                return AREA.CHINA;
            }
        } catch (Exception e) {
        }
        return AREA.OTHERS;
    }
}
