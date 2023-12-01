package com.autonavi.aps.amapapi.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.SparseArray;
import com.amap.api.col.p0003sl.hn;
import com.amap.api.col.p0003sl.iw;
import com.amap.api.col.p0003sl.kh;
import com.amap.api.col.p0003sl.ki;
import com.amap.api.col.p0003sl.kj;
import com.amap.api.col.p0003sl.kk;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.tencent.tendinsv.a.b;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:com/autonavi/aps/amapapi/utils/g.class */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    public SparseArray<Long> f9283a = new SparseArray<>();
    public int b = -1;

    /* renamed from: c  reason: collision with root package name */
    public long f9284c = 0;
    String[] d = {"ol", "cl", "gl", "ha", "bs", "ds"};
    public int e = -1;
    public long f = -1;
    private static List<kj> i = new ArrayList();
    private static JSONArray j = null;
    static AMapLocation g = null;
    static boolean h = false;

    /* renamed from: com.autonavi.aps.amapapi.utils.g$1  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/autonavi/aps/amapapi/utils/g$1.class */
    static final /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f9285a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x002f -> B:19:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:9:0x002b -> B:15:0x0014). Please submit an issue!!! */
        static {
            int[] iArr = new int[AMapLocationClientOption.AMapLocationMode.values().length];
            f9285a = iArr;
            try {
                iArr[AMapLocationClientOption.AMapLocationMode.Battery_Saving.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f9285a[AMapLocationClientOption.AMapLocationMode.Device_Sensors.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f9285a[AMapLocationClientOption.AMapLocationMode.Hight_Accuracy.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    private static String a(int i2) {
        if (i2 != 2011) {
            if (i2 != 2031) {
                if (i2 != 2041) {
                    if (i2 != 2081) {
                        if (i2 != 2091) {
                            if (i2 != 2111) {
                                if (i2 != 2121) {
                                    if (i2 != 2141) {
                                        if (i2 != 2021) {
                                            if (i2 != 2022) {
                                                if (i2 != 2061) {
                                                    if (i2 != 2062) {
                                                        switch (i2) {
                                                            case 2051:
                                                                return "NeedLoginNetWork\t";
                                                            case 2052:
                                                                return "MaybeIntercepted";
                                                            case 2053:
                                                                return "DecryptResponseException";
                                                            case 2054:
                                                                return "ParserDataException";
                                                            default:
                                                                switch (i2) {
                                                                    case 2101:
                                                                        return "BindAPSServiceException";
                                                                    case 2102:
                                                                        return "AuthClientScodeFail";
                                                                    case 2103:
                                                                        return "NotConfigAPSService";
                                                                    default:
                                                                        switch (i2) {
                                                                            case 2131:
                                                                                return "NoCgiOAndWifiInfo";
                                                                            case 2132:
                                                                                return "AirPlaneModeAndWifiOff";
                                                                            case 2133:
                                                                                return "NoCgiAndWifiOff";
                                                                            default:
                                                                                switch (i2) {
                                                                                    case 2151:
                                                                                        return "MaybeMockNetLoc";
                                                                                    case 2152:
                                                                                        return "MaybeMockGPSLoc";
                                                                                    case 2153:
                                                                                        return "UNSUPPORT_COARSE_LBSLOC";
                                                                                    case 2154:
                                                                                        return "UNSUPPORT_CONTINUE_LOC";
                                                                                    default:
                                                                                        return "";
                                                                                }
                                                                        }
                                                                }
                                                        }
                                                    }
                                                    return "ServerLocFail";
                                                }
                                                return "ServerRetypeError";
                                            }
                                            return "OnlyOneWifiButNotMain";
                                        }
                                        return "OnlyMainWifi";
                                    }
                                    return "NoEnoughStatellites";
                                }
                                return "NotLocPermission";
                            }
                            return "ErrorCgiInfo";
                        }
                        return "InitException";
                    }
                    return "LocalLocException";
                }
                return "ResponseResultIsNull";
            }
            return "CreateApsReqException";
        }
        return "ContextIsNull";
    }

    public static void a(long j2, long j3) {
        try {
            if (h) {
                return;
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("gpsTime:");
            stringBuffer.append(i.a(j2, "yyyy-MM-dd HH:mm:ss.SSS"));
            stringBuffer.append(",");
            stringBuffer.append("sysTime:");
            stringBuffer.append(i.a(j3, "yyyy-MM-dd HH:mm:ss.SSS"));
            stringBuffer.append(",");
            long t = a.t();
            int i2 = (0L > t ? 1 : (0L == t ? 0 : -1));
            String a2 = i2 != 0 ? i.a(t, "yyyy-MM-dd HH:mm:ss.SSS") : "0";
            stringBuffer.append("serverTime:");
            stringBuffer.append(a2);
            a("checkgpstime", stringBuffer.toString());
            if (i2 != 0 && Math.abs(j2 - t) < 31536000000L) {
                stringBuffer.append(", correctError");
                a("checkgpstimeerror", stringBuffer.toString());
            }
            stringBuffer.delete(0, stringBuffer.length());
            h = true;
        } catch (Throwable th) {
        }
    }

    public static void a(Context context) {
        synchronized (g.class) {
            if (context != null) {
                try {
                    if (a.a()) {
                        if (i != null && i.size() > 0) {
                            ArrayList arrayList = new ArrayList();
                            arrayList.addAll(i);
                            kk.b(arrayList, context);
                            i.clear();
                        }
                        f(context);
                    }
                } catch (Throwable th) {
                    try {
                        b.a(th, "ReportUtil", "destroy");
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }
        }
    }

    public static void a(Context context, int i2, int i3, long j2, long j3) {
        if (i2 == -1 || i3 == -1) {
            return;
        }
        try {
            a(context, "O012", i2, i3, j2, j3);
        } catch (Throwable th) {
            b.a(th, "ReportUtil", "reportServiceAliveTime");
        }
    }

    public static void a(Context context, long j2, boolean z) {
        if (context != null) {
            try {
                if (a.a()) {
                    a(context, j2, z, "O015");
                }
            } catch (Throwable th) {
                b.a(th, "ReportUtil", "reportGPSLocUseTime");
            }
        }
    }

    private static void a(Context context, long j2, boolean z, String str) {
        a(context, str, !z ? "abroad" : "domestic", Long.valueOf(j2).intValue());
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0043 A[Catch: all -> 0x0156, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x0156, blocks: (B:4:0x0003, B:9:0x0012, B:25:0x0043, B:42:0x0069, B:44:0x006f, B:45:0x0079, B:45:0x0079, B:46:0x007c, B:48:0x00c5, B:52:0x00e0, B:53:0x0137, B:53:0x0137, B:54:0x013a, B:56:0x014e, B:49:0x00d2), top: B:77:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(android.content.Context r5, com.amap.api.location.AMapLocation r6) {
        /*
            Method dump skipped, instructions count: 389
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.utils.g.a(android.content.Context, com.amap.api.location.AMapLocation):void");
    }

    public static void a(Context context, AMapLocation aMapLocation, com.autonavi.aps.amapapi.a aVar) {
        int i2;
        if (aMapLocation == null) {
            return;
        }
        try {
            if ("gps".equalsIgnoreCase(aMapLocation.getProvider()) || aMapLocation.getLocationType() == 1) {
                return;
            }
            String str = a(aMapLocation) ? "abroad" : "domestic";
            String str2 = "cache";
            if (aMapLocation.getErrorCode() != 0) {
                int errorCode = aMapLocation.getErrorCode();
                str2 = (errorCode == 4 || errorCode == 5 || errorCode == 6 || errorCode == 11) ? "net" : "net";
                i2 = 0;
            } else {
                int locationType = aMapLocation.getLocationType();
                str2 = (locationType == 5 || locationType == 6) ? "net" : "net";
                i2 = 1;
            }
            a(context, "O016", str2, str, i2, aMapLocation.getErrorCode(), aVar);
        } catch (Throwable th) {
            b.a(th, "ReportUtil", "reportBatting");
        }
    }

    private static void a(Context context, String str, int i2, int i3, long j2, long j3) {
        if (context != null) {
            try {
                if (a.a()) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("param_int_first", i2);
                    jSONObject.put("param_int_second", i3);
                    jSONObject.put("param_long_first", j2);
                    jSONObject.put("param_long_second", j3);
                    a(context, str, jSONObject);
                }
            } catch (Throwable th) {
                b.a(th, "ReportUtil", "applyStatisticsEx");
            }
        }
    }

    private static void a(Context context, String str, String str2, int i2) {
        if (context != null) {
            try {
                if (a.a()) {
                    JSONObject jSONObject = new JSONObject();
                    if (!TextUtils.isEmpty(str2)) {
                        jSONObject.put("param_string_first", str2);
                    }
                    if (!TextUtils.isEmpty(null)) {
                        jSONObject.put("param_string_second", (Object) null);
                    }
                    if (i2 != Integer.MAX_VALUE) {
                        jSONObject.put("param_int_first", i2);
                    }
                    a(context, str, jSONObject);
                }
            } catch (Throwable th) {
                b.a(th, "ReportUtil", "applyStatisticsEx");
            }
        }
    }

    private static void a(Context context, String str, String str2, String str3, int i2, int i3, com.autonavi.aps.amapapi.a aVar) {
        if (context != null) {
            try {
                if (a.a()) {
                    JSONObject jSONObject = new JSONObject();
                    if (!TextUtils.isEmpty(str2)) {
                        jSONObject.put("param_string_first", str2);
                    }
                    if (!TextUtils.isEmpty(str3)) {
                        jSONObject.put("param_string_second", str3);
                    }
                    if (i2 != Integer.MAX_VALUE) {
                        jSONObject.put("param_int_first", i2);
                    }
                    if (i3 != Integer.MAX_VALUE) {
                        jSONObject.put("param_int_second", i3);
                    }
                    if (aVar != null) {
                        if (!TextUtils.isEmpty(aVar.d())) {
                            jSONObject.put("dns", aVar.d());
                        }
                        if (!TextUtils.isEmpty(aVar.e())) {
                            jSONObject.put("domain", aVar.e());
                        }
                        if (!TextUtils.isEmpty(aVar.f())) {
                            jSONObject.put("type", aVar.f());
                        }
                        if (!TextUtils.isEmpty(aVar.g())) {
                            jSONObject.put("reason", aVar.g());
                        }
                        if (!TextUtils.isEmpty(aVar.c())) {
                            jSONObject.put(b.a.q, aVar.c());
                        }
                        if (!TextUtils.isEmpty(aVar.b())) {
                            jSONObject.put("stack", aVar.b());
                        }
                        if (aVar.h() > 0) {
                            jSONObject.put("ctime", String.valueOf(aVar.h()));
                        }
                        if (aVar.a() > 0) {
                            jSONObject.put("ntime", String.valueOf(aVar.a()));
                        }
                    }
                    a(context, str, jSONObject);
                }
            } catch (Throwable th) {
                b.a(th, "ReportUtil", "applyStatisticsEx");
            }
        }
    }

    public static void a(Context context, String str, JSONObject jSONObject) {
        synchronized (g.class) {
            if (context != null) {
                try {
                    if (a.a()) {
                        kj kjVar = new kj(context, "loc", "6.1.0", str);
                        if (jSONObject != null) {
                            kjVar.a(jSONObject.toString());
                        }
                        i.add(kjVar);
                        if (i.size() >= 30) {
                            ArrayList arrayList = new ArrayList();
                            arrayList.addAll(i);
                            kk.b(arrayList, context);
                            i.clear();
                        }
                    }
                } catch (Throwable th) {
                    try {
                        b.a(th, "ReportUtil", "applyStatistics");
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }
        }
    }

    public static void a(AMapLocation aMapLocation, AMapLocation aMapLocation2) {
        try {
            if (g == null) {
                if (!i.a(aMapLocation)) {
                    g = aMapLocation2;
                    return;
                }
                g = aMapLocation.m2371clone();
            }
            if (i.a(g) && i.a(aMapLocation2)) {
                AMapLocation m2371clone = aMapLocation2.m2371clone();
                if (g.getLocationType() != 1 && g.getLocationType() != 9 && !"gps".equalsIgnoreCase(g.getProvider()) && g.getLocationType() != 7 && m2371clone.getLocationType() != 1 && m2371clone.getLocationType() != 9 && !"gps".equalsIgnoreCase(m2371clone.getProvider()) && m2371clone.getLocationType() != 7) {
                    long abs = Math.abs(m2371clone.getTime() - g.getTime()) / 1000;
                    long j2 = abs;
                    if (abs <= 0) {
                        j2 = 1;
                    }
                    if (j2 <= com.anythink.expressad.d.a.b.aC) {
                        float a2 = i.a(g, m2371clone);
                        float f = a2 / ((float) j2);
                        if (a2 > 30000.0f && f > 1000.0f) {
                            StringBuilder sb = new StringBuilder();
                            sb.append(g.getLatitude());
                            sb.append(",");
                            sb.append(g.getLongitude());
                            sb.append(",");
                            sb.append(g.getAccuracy());
                            sb.append(",");
                            sb.append(g.getLocationType());
                            sb.append(",");
                            if (aMapLocation.getTime() != 0) {
                                sb.append(i.a(g.getTime(), "yyyyMMdd_HH:mm:ss:SS"));
                            } else {
                                sb.append(g.getTime());
                            }
                            sb.append("#");
                            sb.append(m2371clone.getLatitude());
                            sb.append(",");
                            sb.append(m2371clone.getLongitude());
                            sb.append(",");
                            sb.append(m2371clone.getAccuracy());
                            sb.append(",");
                            sb.append(m2371clone.getLocationType());
                            sb.append(",");
                            if (m2371clone.getTime() != 0) {
                                sb.append(i.a(m2371clone.getTime(), "yyyyMMdd_HH:mm:ss:SS"));
                            } else {
                                sb.append(m2371clone.getTime());
                            }
                            a("bigshiftstatistics", sb.toString());
                            sb.delete(0, sb.length());
                        }
                    }
                }
                g = m2371clone;
            }
        } catch (Throwable th) {
        }
    }

    public static void a(String str, int i2) {
        a(str, String.valueOf(i2), a(i2));
    }

    public static void a(String str, String str2) {
        try {
            iw.b(b.c(), str2, str);
        } catch (Throwable th) {
            b.a(th, "ReportUtil", "reportLog");
        }
    }

    public static void a(String str, String str2, String str3) {
        try {
            iw.a(b.c(), "/mobile/binary", str3, str, str2);
        } catch (Throwable th) {
        }
    }

    public static void a(String str, Throwable th) {
        try {
            if (th instanceof hn) {
                iw.a(b.c(), str, (hn) th);
            }
        } catch (Throwable th2) {
        }
    }

    private static boolean a(AMapLocation aMapLocation) {
        return i.a(aMapLocation) ? !b.a(aMapLocation.getLatitude(), aMapLocation.getLongitude()) : "http://abroad.apilocate.amap.com/mobile/binary".equals(b.f9279c);
    }

    public static void b(Context context, long j2, boolean z) {
        if (context != null) {
            try {
                if (a.a()) {
                    a(context, j2, z, "O024");
                }
            } catch (Throwable th) {
                b.a(th, "ReportUtil", "reportCoarseLocUseTime");
            }
        }
    }

    private static void f(Context context) {
        try {
            if (j == null || j.length() <= 0) {
                return;
            }
            ki.a(new kh(context, b.c(), j.toString()), context);
            j = null;
        } catch (Throwable th) {
            b.a(th, "ReportUtil", "writeOfflineLocLog");
        }
    }

    public final void a(Context context, int i2) {
        try {
            if (this.b == i2) {
                return;
            }
            if (this.b != -1 && this.b != i2) {
                long b = i.b();
                long j2 = this.f9284c;
                this.f9283a.append(this.b, Long.valueOf((b - j2) + this.f9283a.get(this.b, 0L).longValue()));
            }
            this.f9284c = i.b() - h.a(context, "pref1", this.d[i2], 0L);
            this.b = i2;
        } catch (Throwable th) {
            b.a(th, "ReportUtil", "setLocationType");
        }
    }

    public final void a(Context context, AMapLocationClientOption aMapLocationClientOption) {
        try {
            int i2 = AnonymousClass1.f9285a[aMapLocationClientOption.getLocationMode().ordinal()];
            int i3 = 3;
            if (i2 == 1) {
                i3 = 4;
            } else if (i2 == 2) {
                i3 = 5;
            } else if (i2 != 3) {
                i3 = -1;
            }
            if (this.e == i3) {
                return;
            }
            if (this.e != -1 && this.e != i3) {
                this.f9283a.append(this.e, Long.valueOf((i.b() - this.f) + this.f9283a.get(this.e, 0L).longValue()));
            }
            this.f = i.b() - h.a(context, "pref1", this.d[i3], 0L);
            this.e = i3;
        } catch (Throwable th) {
            b.a(th, "ReportUtil", "setLocationMode");
        }
    }

    public final void b(Context context) {
        try {
            long b = i.b();
            long j2 = this.f9284c;
            if (this.b != -1) {
                this.f9283a.append(this.b, Long.valueOf((b - j2) + this.f9283a.get(this.b, 0L).longValue()));
            }
            long b2 = i.b();
            long j3 = this.f;
            if (this.e != -1) {
                this.f9283a.append(this.e, Long.valueOf((b2 - j3) + this.f9283a.get(this.e, 0L).longValue()));
            }
            SharedPreferences.Editor a2 = h.a(context, "pref1");
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.d.length) {
                    h.a(a2);
                    return;
                }
                long longValue = this.f9283a.get(i3, 0L).longValue();
                if (longValue > 0 && longValue > h.a(context, "pref1", this.d[i3], 0L)) {
                    h.a(a2, this.d[i3], longValue);
                }
                i2 = i3 + 1;
            }
        } catch (Throwable th) {
            b.a(th, "ReportUtil", "saveLocationTypeAndMode");
        }
    }

    public final int c(Context context) {
        try {
            long a2 = h.a(context, "pref1", this.d[2], 0L);
            long a3 = h.a(context, "pref1", this.d[0], 0L);
            long a4 = h.a(context, "pref1", this.d[1], 0L);
            if (a2 == 0 && a3 == 0 && a4 == 0) {
                return -1;
            }
            long j2 = a3 - a2;
            long j3 = a4 - a2;
            return a2 > j2 ? a2 > j3 ? 2 : 1 : j2 > j3 ? 0 : 1;
        } catch (Throwable th) {
            return -1;
        }
    }

    public final int d(Context context) {
        try {
            long a2 = h.a(context, "pref1", this.d[3], 0L);
            long a3 = h.a(context, "pref1", this.d[4], 0L);
            long a4 = h.a(context, "pref1", this.d[5], 0L);
            if (a2 == 0 && a3 == 0 && a4 == 0) {
                return -1;
            }
            return a2 > a3 ? a2 > a4 ? 3 : 5 : a3 > a4 ? 4 : 5;
        } catch (Throwable th) {
            return -1;
        }
    }

    public final void e(Context context) {
        try {
            SharedPreferences.Editor a2 = h.a(context, "pref1");
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.d.length) {
                    h.a(a2);
                    return;
                } else {
                    h.a(a2, this.d[i3], 0L);
                    i2 = i3 + 1;
                }
            }
        } catch (Throwable th) {
        }
    }
}
