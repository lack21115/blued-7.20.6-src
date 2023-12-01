package com.amap.api.col.p0003sl;

import android.content.Context;
import android.util.Log;
import com.alipay.sdk.sys.a;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.PolygonOptions;
import com.amap.api.maps.model.PolylineOptions;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* renamed from: com.amap.api.col.3sl.dy  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/dy.class */
public final class dy {
    private static Map<String, dz> a = new ConcurrentHashMap();
    private static String b = "";

    public static void a() {
        try {
            if (dx.a) {
                for (Map.Entry<String, dz> entry : a.entrySet()) {
                    entry.getValue().a();
                }
            }
        } catch (Throwable th) {
        }
    }

    private static void a(int i, String str, String str2) {
        if (i == 0) {
            Log.i("linklog", str + " " + str2);
            return;
        }
        Log.e("linklog", str + " " + str2);
    }

    private static void a(int i, String str, String str2, String str3, String str4) {
        dz dzVar;
        try {
            String str5 = str3 + str4;
            if (dx.b) {
                a(i, str2, str5);
            }
            if (!dx.a || a == null || (dzVar = a.get(str)) == null) {
                return;
            }
            dzVar.a(i, str2, str5);
        } catch (Throwable th) {
        }
    }

    public static void a(Context context) {
        if (context == null) {
            return;
        }
        try {
            b();
            il.a(dw.a()).a(context.getApplicationContext());
        } catch (Throwable th) {
        }
    }

    public static void a(String str, String str2) {
        a(0, "normal", b, str, str2);
    }

    public static void a(String str, String str2, MarkerOptions markerOptions) {
        if (markerOptions == null) {
            c(str, str2);
            return;
        }
        c(str, str2 + " " + markerOptions.getPosition() + " " + markerOptions.getIcons());
    }

    public static void a(String str, String str2, PolygonOptions polygonOptions) {
        if (polygonOptions == null) {
            c(str, str2);
            return;
        }
        StringBuilder sb = new StringBuilder();
        List<LatLng> points = polygonOptions.getPoints();
        if (points != null) {
            sb.append("points size =");
            sb.append(points.size());
        }
        sb.append(";width=");
        sb.append(polygonOptions.getStrokeWidth());
        sb.append(";fillColor=");
        sb.append(polygonOptions.getFillColor());
        sb.append(";strokeColor=");
        sb.append(polygonOptions.getStrokeColor());
        sb.append(";visible=");
        sb.append(polygonOptions.isVisible());
        c(str, str2 + " " + sb.toString());
    }

    public static void a(String str, String str2, PolylineOptions polylineOptions) {
        if (polylineOptions == null) {
            c(str, str2);
            return;
        }
        StringBuilder sb = new StringBuilder();
        List<LatLng> points = polylineOptions.getPoints();
        if (points != null) {
            sb.append("points size =");
            sb.append(points.size());
        }
        sb.append(";width=");
        sb.append(polylineOptions.getWidth());
        sb.append(";color=");
        sb.append(polylineOptions.getColor());
        sb.append(";visible=");
        sb.append(polylineOptions.isVisible());
        c(str, str2 + " " + sb.toString());
    }

    public static void a(String str, String str2, List<MarkerOptions> list) {
        if (list != null) {
            for (MarkerOptions markerOptions : list) {
                a(str, str2, markerOptions);
            }
        }
    }

    public static void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            boolean a2 = hp.a(jSONObject.optString("able", ""), false);
            boolean a3 = hp.a(jSONObject.optString("mobile", ""), false);
            boolean a4 = hp.a(jSONObject.optString("debugupload", ""), false);
            boolean a5 = hp.a(jSONObject.optString("debugwrite", ""), false);
            boolean a6 = hp.a(jSONObject.optString("forcedUpload", ""), false);
            dx.a = a2;
            boolean a7 = hp.a(jSONObject.optString("di", ""), false);
            String optString = jSONObject.optString("dis", "");
            if (!a7 || ib.e(optString)) {
                il.a(dw.a()).a(a2, a3, a5, a4, Arrays.asList(jSONObject.optString("filter", "").split(a.b)));
                if (a6) {
                    il.a(dw.a()).a(a6);
                }
            }
        } catch (Throwable th) {
        }
    }

    private static void b() {
        try {
            a.put("overlay", new eb());
            a.put("normal", new ea());
        } catch (Throwable th) {
        }
    }

    public static void b(String str, String str2) {
        a(1, "normal", b, str, str2);
    }

    private static void c(String str, String str2) {
        a(1, "overlay", b, str, str2);
    }
}
