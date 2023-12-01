package com.igexin.push.f;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.location.Location;
import android.media.MediaDrm;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import com.getui.gtc.dim.AllowSysCall;
import com.getui.gtc.dim.DimManager;
import com.getui.gtc.dim.DimRequest;
import com.getui.gtc.dim.bean.GtWifiInfo;
import com.igexin.assist.util.AssistUtils;
import com.igexin.push.f.f;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/push/f/n.class */
public class n {

    /* renamed from: a  reason: collision with root package name */
    public static final String f23661a = "PhoneInfoUtils";
    public static final String b = "";

    /* renamed from: c  reason: collision with root package name */
    private static volatile PackageInfo f23662c;
    private static String d;

    public static int a(Context context) {
        try {
            return c(context).applicationInfo.targetSdkVersion;
        } catch (Exception e) {
            com.igexin.c.a.c.a.a(e);
            return 0;
        }
    }

    private static String a(String str, String str2) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop " + str).getInputStream()));
            String str3 = "";
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    return str3;
                }
                str3 = str3 + readLine;
            }
        } catch (Exception e) {
            return str2;
        }
    }

    public static List<PackageInfo> a() {
        List<PackageInfo> list;
        try {
            list = (List) DimManager.getInstance().get(new DimRequest.Builder().key(f.a.O).ramCacheValidTime(0L).storageCacheValidTime(0L).allowSysCall(AllowSysCall.ALL_ALLOW).build());
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            list = null;
        }
        List<PackageInfo> list2 = list;
        if (list == null) {
            list2 = Collections.emptyList();
        }
        return list2;
    }

    public static ApplicationInfo b(Context context) {
        try {
            return c(context).applicationInfo;
        } catch (PackageManager.NameNotFoundException e) {
            com.igexin.c.a.c.a.a(e);
            return null;
        }
    }

    public static Pair<String, String> b() {
        try {
            if (!com.igexin.push.config.d.X || d.b("3.1.12.0")) {
                com.igexin.c.a.c.a.b(f23661a, "use wf");
                WifiInfo wifiInfo = (WifiInfo) DimManager.getInstance().get(f.a.F);
                if (wifiInfo == null) {
                    return null;
                }
                return Pair.create(wifiInfo.getSSID(), wifiInfo.getBSSID());
            }
            com.igexin.c.a.c.a.b(f23661a, "use gt wf");
            GtWifiInfo parseJson = GtWifiInfo.parseJson((String) DimManager.getInstance().get(f.a.I));
            if (parseJson == null) {
                return null;
            }
            return Pair.create(parseJson.getSSID(), parseJson.getBSSID());
        } catch (Exception e) {
            com.igexin.c.a.c.a.a(e);
            return null;
        }
    }

    private static PackageInfo c(Context context) throws PackageManager.NameNotFoundException {
        if (f23662c != null) {
            com.igexin.c.a.c.a.b(f23661a, "getSelfPackageInfo cache");
            return f23662c;
        }
        synchronized (n.class) {
            try {
                if (f23662c == null) {
                    f23662c = context.getPackageManager().getPackageInfo(context.getPackageName(), 128);
                    com.igexin.c.a.c.a.b(f23661a, "getSelfPackageInfo");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return f23662c;
    }

    public static String c() {
        try {
            return (String) DimManager.getInstance().get(new DimRequest.Builder().key(f.a.j).useExpiredCacheForReserve(true).build());
        } catch (Exception e) {
            com.igexin.c.a.c.a.a(e);
            return "";
        }
    }

    public static String d() {
        return Build.BRAND;
    }

    public static String e() {
        return Build.MODEL;
    }

    public static String f() {
        try {
            return (String) DimManager.getInstance().get(new DimRequest.Builder().key(f.a.f).useExpiredCacheForReserve(true).build());
        } catch (Exception e) {
            com.igexin.c.a.c.a.a(e);
            return "";
        }
    }

    public static String g() {
        try {
            return (String) DimManager.getInstance().get(new DimRequest.Builder().key(f.a.b).useExpiredCacheForReserve(true).build());
        } catch (Exception e) {
            com.igexin.c.a.c.a.a(e);
            return "";
        }
    }

    public static String h() {
        try {
            return (String) DimManager.getInstance().get(f.a.e);
        } catch (Exception e) {
            com.igexin.c.a.c.a.a(e);
            return "";
        }
    }

    public static String i() {
        try {
            return (String) DimManager.getInstance().get(f.a.q);
        } catch (Exception e) {
            com.igexin.c.a.c.a.a(e);
            return "";
        }
    }

    public static String j() {
        try {
            return (String) DimManager.getInstance().get(f.a.r);
        } catch (Exception e) {
            com.igexin.c.a.c.a.a(e);
            return "";
        }
    }

    public static List<ScanResult> k() {
        try {
            return (List) DimManager.getInstance().get(f.a.G);
        } catch (Exception e) {
            com.igexin.c.a.c.a.a(e);
            return null;
        }
    }

    public static String l() {
        try {
            return Build.VERSION.SDK_INT < 21 ? Build.CPU_ABI : Build.SUPPORTED_ABIS[0];
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return "";
        }
    }

    public static boolean m() {
        try {
            return Arrays.asList(com.igexin.push.config.d.G.toUpperCase().split(",")).contains(Build.BRAND.toUpperCase());
        } catch (Exception e) {
            com.igexin.c.a.c.a.a(e);
            com.igexin.c.a.c.a.a("PhoneInfoUtils|delAlarm " + com.igexin.push.config.d.G + " err " + e.toString(), new Object[0]);
            return false;
        }
    }

    public static String n() {
        String str;
        try {
            str = (String) DimManager.getInstance().get(new DimRequest.Builder().key(f.a.l).ramCacheValidTime(0L).storageCacheValidTime(0L).allowSysCall(AllowSysCall.ALL_ALLOW).build());
        } catch (Exception e) {
            com.igexin.c.a.c.a.a(e);
            str = null;
        }
        if (!TextUtils.isEmpty(str) && !str.equals(com.igexin.push.core.e.h)) {
            com.igexin.push.core.e.h = str;
        }
        return str;
    }

    public static String o() {
        try {
            return c(com.igexin.push.core.e.l).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            com.igexin.c.a.c.a.a(e);
            return "";
        }
    }

    public static long p() {
        try {
            return c(com.igexin.push.core.e.l).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            com.igexin.c.a.c.a.a(e);
            return 0L;
        }
    }

    public static String q() {
        try {
            return (String) DimManager.getInstance().get(new DimRequest.Builder().key(f.a.H).ramCacheValidTime(0L).storageCacheValidTime(0L).build());
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a("PhoneInfoUtils|".concat(String.valueOf(th)), new Object[0]);
            return "";
        }
    }

    public static String r() {
        try {
            byte[] propertyByteArray = new MediaDrm(new UUID(-1301668207276963122L, -6645017420763422227L)).getPropertyByteArray(MediaDrm.PROPERTY_DEVICE_UNIQUE_ID);
            if (propertyByteArray == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            int length = propertyByteArray.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return sb.toString();
                }
                sb.append(String.format("%02x", Byte.valueOf(propertyByteArray[i2])));
                i = i2 + 1;
            }
        } catch (Error | Exception e) {
            return "";
        }
    }

    public static Location s() {
        try {
            return (Location) DimManager.getInstance().get(f.a.B);
        } catch (Throwable th) {
            return null;
        }
    }

    public static Location t() {
        try {
            return (Location) DimManager.getInstance().get(f.a.C);
        } catch (Throwable th) {
            return null;
        }
    }

    private static String u() {
        if (TextUtils.isEmpty(d)) {
            try {
                String str = Build.BRAND;
                if (TextUtils.isEmpty(str)) {
                    return "";
                }
                String lowerCase = str.toLowerCase();
                HashMap hashMap = new HashMap();
                hashMap.put(AssistUtils.BRAND_HW, "ro.build.version.emui");
                hashMap.put("blackshark", "ro.build.version.incremental");
                hashMap.put("redmi", "ro.build.version.incremental");
                hashMap.put(AssistUtils.BRAND_XIAOMI, "ro.build.version.incremental");
                hashMap.put("samsang", "ro.build.version.incremental");
                hashMap.put(AssistUtils.BRAND_VIVO, "ro.vivo.os.version");
                hashMap.put(AssistUtils.BRAND_OPPO, "ro.build.version.opporom");
                hashMap.put(AssistUtils.BRAND_MZ, "ro.build.display.id");
                hashMap.put("lenovo", "ro.build.version.incremental");
                hashMap.put("smartisan", "ro.modversion");
                hashMap.put("htc", "ro.build.sense.version");
                hashMap.put("oneplus", "ro.rom.version");
                hashMap.put("yunos", "ro.cta.yunos.version");
                hashMap.put("360", "ro.build.uiversion");
                hashMap.put("nubia", "ro.build.rom.internal.id");
                if (hashMap.containsKey(lowerCase)) {
                    String a2 = a((String) hashMap.get(lowerCase), "");
                    d = a2;
                    return a2;
                }
                return "";
            } catch (Throwable th) {
                com.igexin.c.a.c.a.a(th);
                return "";
            }
        }
        return d;
    }

    private static boolean v() {
        return Build.VERSION.SDK_INT > 28;
    }

    private static String w() {
        return (String) DimManager.getInstance().get(f.a.u);
    }

    private static String x() {
        try {
            return (String) DimManager.getInstance().get(f.a.J);
        } catch (Exception e) {
            com.igexin.c.a.c.a.a(e);
            return "";
        }
    }
}
