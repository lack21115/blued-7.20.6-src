package com.amap.api.col.p0003sl;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.sdk.util.i;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.amap.api.col.3sl.dt  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/dt.class */
public final class dt {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f4866a = false;
    private static boolean b = false;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f4867c = false;
    private static boolean d = false;
    private static boolean e = false;
    private static boolean f = false;
    private static boolean g = false;
    private static boolean h = false;
    private static boolean i = false;
    private static boolean j = false;
    private static HashMap<String, Boolean> k = new HashMap<>();
    private static ConcurrentHashMap<Integer, Integer> l = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<Integer, Integer> m = new ConcurrentHashMap<>();

    private static <T> String a(Map<String, T> map) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("{");
            for (Map.Entry<String, T> entry : map.entrySet()) {
                sb.append("\"" + entry.getKey() + "\":");
                sb.append(entry.getValue());
                sb.append(",");
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append(i.d);
            return sb.toString();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private static String a(boolean z) {
        try {
            return "{\"Quest\":" + z + i.d;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static void a(Context context) {
        if (f4867c) {
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("amap_3dmap_heatmap", 1);
            a(context, "O009", a(hashMap));
            f4867c = true;
        } catch (Throwable th) {
        }
    }

    public static void a(Context context, int i2) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("amap_3dmap_draw_fail", Integer.valueOf(i2));
            a(context, "O023", a(hashMap));
        } catch (Throwable th) {
        }
    }

    public static void a(Context context, int i2, int i3, String str) {
        if (context == null) {
            return;
        }
        try {
            synchronized (l) {
                if (!l.containsKey(Integer.valueOf(i2)) || l.get(Integer.valueOf(i2)).intValue() < 2) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("amap_3dmap_map_request_type", String.valueOf(i3));
                    hashMap.put("amap_3dmap_map_request_info", str);
                    a(context, "O019", a(hashMap));
                    if (l.containsKey(Integer.valueOf(i2))) {
                        l.put(Integer.valueOf(i2), Integer.valueOf(l.get(Integer.valueOf(i2)).intValue() + 1));
                    } else {
                        l.put(Integer.valueOf(i2), 0);
                    }
                }
            }
        } catch (Throwable th) {
        }
    }

    public static void a(Context context, int i2, long j2, long j3) {
        try {
            synchronized (m) {
                if (!m.containsKey(Integer.valueOf(i2)) || m.get(Integer.valueOf(i2)).intValue() < 2) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("amap_3dmap_map_request_rendertime", Long.valueOf(j2));
                    hashMap.put("amap_3dmap_map_request_size", Long.valueOf(j3));
                    a(context, "O020", a(hashMap));
                    if (m.containsKey(Integer.valueOf(i2))) {
                        m.put(Integer.valueOf(i2), Integer.valueOf(m.get(Integer.valueOf(i2)).intValue() + 1));
                    } else {
                        m.put(Integer.valueOf(i2), 0);
                    }
                }
            }
        } catch (Throwable th) {
        }
    }

    public static void a(Context context, long j2) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("amap_3dmap_rendertime", Long.valueOf(j2));
            hashMap.put("amap_3dmap_render_background", 0L);
            a(context, "O005", a(hashMap));
        } catch (Throwable th) {
        }
    }

    public static void a(Context context, String str) {
        synchronized (dt.class) {
            try {
                if (k != null && !TextUtils.isEmpty(str)) {
                    if (k.containsKey(str) && k.get(str).booleanValue()) {
                        return;
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put("amap_3dmap_coordinate", str);
                    a(context, "O008", a(hashMap));
                    if (!k.containsKey(str)) {
                        k.put(str, Boolean.TRUE);
                    }
                }
            } catch (Throwable th) {
            }
        }
    }

    private static void a(Context context, String str, String str2) {
        if (context == null) {
            return;
        }
        try {
            kj kjVar = new kj(context, "3dmap", "9.3.1", str);
            kjVar.a(str2);
            kk.a(kjVar, context);
        } catch (Throwable th) {
        }
    }

    public static void a(Context context, boolean z) {
        try {
            String a2 = a(z);
            kj kjVar = new kj(context, "3dmap", "9.3.1", "O001");
            kjVar.a(a2);
            kk.a(kjVar, context);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void b(Context context) {
        if (d) {
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("amap_3dmap_offlinemap", 1);
            a(context, "O010", a(hashMap));
            d = true;
        } catch (Throwable th) {
        }
    }

    public static void b(Context context, String str) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("amap_3dmap_engine_init_fail", str);
            a(context, "O021", a(hashMap));
        } catch (Throwable th) {
        }
    }

    public static void b(Context context, boolean z) {
        if (f4866a) {
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("amap_3dmap_stylemap", Integer.valueOf(z ? 1 : 0));
            a(context, "O006", a(hashMap));
            f4866a = true;
        } catch (Throwable th) {
        }
    }

    public static void c(Context context) {
        if (e) {
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("amap_3dmap_particleoverlay", 1);
            a(context, "O011", a(hashMap));
            e = true;
        } catch (Throwable th) {
        }
    }

    public static void c(Context context, String str) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("amap_3dmap_res_load_fail", str);
            a(context, "O022", a(hashMap));
        } catch (Throwable th) {
        }
    }

    public static void c(Context context, boolean z) {
        if (b) {
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("amap_3dmap_indoormap", Integer.valueOf(z ? 1 : 0));
            a(context, "O007", a(hashMap));
            b = true;
        } catch (Throwable th) {
        }
    }

    public static void d(Context context) {
        if (g) {
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("amap_3dmap_bzmapreview", 1);
            a(context, "O012", a(hashMap));
            g = true;
        } catch (Throwable th) {
        }
    }

    public static void e(Context context) {
        if (h) {
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("amap_3dmap_wxmapreview", 1);
            a(context, "O013", a(hashMap));
            h = true;
        } catch (Throwable th) {
        }
    }

    public static void f(Context context) {
        if (i) {
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("amap_3dmap_dxmapreview", 1);
            a(context, "0016", a(hashMap));
            i = true;
        } catch (Throwable th) {
        }
    }

    public static void g(Context context) {
        if (f) {
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("amap_3dmap_renderfps", 1);
            a(context, "O014", a(hashMap));
            f = true;
        } catch (Throwable th) {
        }
    }

    public static void h(Context context) {
        if (j) {
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("amap_3dmap_buildingoverlay", 1);
            a(context, "O015", a(hashMap));
            j = true;
        } catch (Throwable th) {
        }
    }
}
