package com.getui.gtc.dim.c;

import android.content.Context;
import android.location.Location;
import android.net.wifi.WifiInfo;
import android.text.TextUtils;
import com.getui.gtc.dim.DimManager;
import com.getui.gtc.dim.DimRequest;
import com.getui.gtc.dim.bean.GtLocation;
import com.getui.gtc.dim.bean.GtWifiInfo;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/dim/c/b.class */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static final Map<String, String> f8340a = new HashMap<String, String>() { // from class: com.getui.gtc.dim.c.b.1
        {
            put("dim-2-1-18-4", "dim-2-1-18-1");
            put("dim-2-1-18-3", "dim-2-1-18-4");
            put("dim-2-1-17-3", "dim-2-1-17-1");
            put("dim-2-1-17-4", "dim-2-1-17-2");
        }
    };

    private static Object a(DimRequest dimRequest) {
        String str = f8340a.get(dimRequest.getKey());
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return DimManager.getInstance().get(new DimRequest.Builder(dimRequest).key(str).build());
    }

    public static String a(Context context, DimRequest dimRequest) {
        try {
            GtWifiInfo parseJson = GtWifiInfo.parseJson((String) a(dimRequest));
            return a.b(context, parseJson != null ? parseJson.getSSID() : "");
        } catch (Throwable th) {
            com.getui.gtc.dim.e.b.b(th);
            return null;
        }
    }

    public static String a(DimRequest dimRequest, int i) {
        String str;
        try {
            StringBuilder sb = new StringBuilder("get ");
            sb.append(dimRequest.getKey());
            sb.append(" policy:");
            sb.append(i);
            com.getui.gtc.dim.e.b.a(sb.toString());
            WifiInfo wifiInfo = (WifiInfo) a(dimRequest);
            str = null;
            if (wifiInfo != null) {
                if (i == 0) {
                    return new GtWifiInfo(wifiInfo).toJsonString();
                }
                if (i == 1) {
                    return e.a(wifiInfo);
                }
                String a2 = e.a(wifiInfo);
                str = a2;
                if (TextUtils.isEmpty(a2)) {
                    return new GtWifiInfo(wifiInfo).toJsonString();
                }
            }
        } catch (Throwable th) {
            com.getui.gtc.dim.e.b.b(th);
            str = null;
        }
        return str;
    }

    public static String b(DimRequest dimRequest, int i) {
        String str;
        try {
            StringBuilder sb = new StringBuilder("get ");
            sb.append(dimRequest.getKey());
            sb.append(" policy:");
            sb.append(i);
            com.getui.gtc.dim.e.b.a(sb.toString());
            Location location = (Location) a(dimRequest);
            str = null;
            if (location != null) {
                if (i == 0) {
                    return new GtLocation(location).toJsonString();
                }
                if (i == 1) {
                    return c.a(location);
                }
                String a2 = c.a(location);
                str = a2;
                if (TextUtils.isEmpty(a2)) {
                    return new GtLocation(location).toJsonString();
                }
            }
        } catch (Throwable th) {
            com.getui.gtc.dim.e.b.b(th);
            str = null;
        }
        return str;
    }
}
