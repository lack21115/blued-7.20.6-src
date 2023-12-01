package c.t.m.g;

import android.location.Location;
import android.net.wifi.ScanResult;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.map.geolocation.util.SoUtils;
import java.io.ByteArrayOutputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.GZIPOutputStream;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/f6.class */
public class f6 {

    /* renamed from: a  reason: collision with root package name */
    public static volatile long f3812a;
    public static volatile long b;

    public static double a(double d) {
        return (d * 3.141592653589793d) / 180.0d;
    }

    public static double a(double d, double d2, double d3, double d4) {
        double a2 = a(d);
        double a3 = a(d3);
        return (Math.round(((Math.asin(Math.sqrt(Math.pow(Math.sin((a2 - a3) / 2.0d), 2.0d) + ((Math.cos(a2) * Math.cos(a3)) * Math.pow(Math.sin((a(d2) - a(d4)) / 2.0d), 2.0d)))) * 2.0d) * 6378.137d) * 10000.0d) / 10000.0d) * 1000.0d;
    }

    public static double a(double d, int i) {
        try {
            if (Double.isNaN(d)) {
                return 0.0d;
            }
            return BigDecimal.valueOf(d).setScale(i, RoundingMode.HALF_DOWN).doubleValue();
        } catch (Exception e) {
            return 0.0d;
        }
    }

    public static int a(char c2) {
        int i = (c2 < 'A' || c2 > 'Z') ? 256 : c2 - 'A';
        int i2 = i;
        if (c2 >= 'a') {
            i2 = i;
            if (c2 <= 'z') {
                i2 = (c2 - 'a') + 64;
            }
        }
        int i3 = i2;
        if (c2 >= '0') {
            i3 = i2;
            if (c2 <= '9') {
                i3 = (c2 + 128) - 48;
            }
        }
        return i3;
    }

    public static String a(int i, int i2, int i3, long j, int i4, int i5, int i6, long j2) {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append("\"mcc\":");
        sb.append(i);
        sb.append(",\"mnc\":");
        sb.append(i2);
        sb.append(",\"lac\":");
        sb.append(i3);
        sb.append(",\"cellid\":");
        sb.append(j);
        sb.append(",\"rss\":");
        sb.append(i4);
        if (i5 != Integer.MAX_VALUE && i6 != Integer.MAX_VALUE) {
            sb.append(",\"stationLat\":");
            sb.append(String.format("%.6f", Float.valueOf(i5 / 14400.0f)));
            sb.append(",\"stationLng\":");
            sb.append(String.format("%.6f", Float.valueOf(i6 / 14400.0f)));
        }
        sb.append(",\"ts\":");
        sb.append(j2);
        sb.append(com.alipay.sdk.util.i.d);
        return sb.toString();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public static String a(int i, int i2, int i3, long j, int i4, int i5, int i6, boolean z, int i7, long j2) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    public static String a(a5 a5Var, boolean z) {
        if (a5Var == null) {
            return "[]";
        }
        int i = a5Var.b;
        int i2 = a5Var.f3750c;
        int ordinal = a5Var.f3749a.ordinal();
        ArrayList arrayList = new ArrayList();
        a5Var.d();
        long currentTimeMillis = System.currentTimeMillis();
        if (v5.a(ordinal, i, i2, a5Var.d, a5Var.f)) {
            arrayList.add(a(i, i2, a5Var.d, a5Var.f, a5Var.e, a5Var.g, a5Var.h, z, ordinal, (currentTimeMillis - a5Var.e()) / 1000));
        } else {
            a("illeagal main cell! ", i, i2, ordinal, a5Var.d, a5Var.f);
        }
        try {
            for (a5 a5Var2 : a5Var.c()) {
                arrayList.add(a(a5Var2.b, a5Var2.f3750c, a5Var2.d, a5Var2.f, a5Var2.e, a5Var2.g, a5Var2.h, (currentTimeMillis - a5Var2.e()) / 1000));
            }
        } catch (Throwable th) {
        }
        return "[" + x5.b(",").a(arrayList) + "]";
    }

    public static String a(b5 b5Var) {
        if (b5Var == null) {
            return "{}";
        }
        Location location = b5Var.f3763a;
        StringBuilder sb = new StringBuilder();
        double a2 = a(location.getLatitude(), 6);
        double a3 = a(location.getLongitude(), 6);
        double a4 = a(location.getAltitude(), 1);
        double a5 = a(location.getAccuracy(), 1);
        double a6 = a(location.getBearing(), 1);
        double a7 = a(location.getSpeed(), 1);
        sb.append("{");
        sb.append("\"latitude\":");
        sb.append(a2);
        sb.append(",\"longitude\":");
        sb.append(a3);
        sb.append(",\"additional\":");
        sb.append("\"" + a4 + "," + a5 + "," + a6 + "," + a7 + "," + b5Var.b + "\"");
        sb.append(",\"source\":");
        sb.append(b5Var.f.ordinal());
        sb.append(com.alipay.sdk.util.i.d);
        return sb.toString();
    }

    public static String a(g5 g5Var, boolean z) {
        long j;
        List<ScanResult> a2 = g5Var == null ? null : g5Var.a();
        if (a2 == null) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if (a2.size() <= 0) {
            sb.append("]");
            return sb.toString();
        }
        int i = 0;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j2 = elapsedRealtime / 1000;
        long j3 = Long.MAX_VALUE;
        for (ScanResult scanResult : a2) {
            if (a(scanResult, a2.size())) {
                if (i > 0) {
                    sb.append(",");
                }
                sb.append("{\"mac\":\"");
                sb.append(scanResult.BSSID.replace(":", ""));
                sb.append("\",");
                sb.append("\"rssi\":");
                sb.append(scanResult.level);
                if (Build.VERSION.SDK_INT < 17 || !z) {
                    j = j3;
                } else {
                    long j4 = scanResult.timestamp;
                    int i2 = j4 > 0 ? (int) (j2 - ((j4 / 1000) / 1000)) : -1;
                    sb.append(",");
                    sb.append("\"ts\":");
                    int i3 = i2;
                    if (i2 >= 1000) {
                        i3 = 1000;
                    }
                    sb.append(i3);
                    long j5 = elapsedRealtime - (scanResult.timestamp / 1000);
                    j = j3;
                    if (j5 < j3) {
                        j = j5;
                    }
                }
                sb.append(com.alipay.sdk.util.i.d);
                i++;
                j3 = j;
            }
        }
        sb.append("]");
        f3812a = j3 == Long.MAX_VALUE ? 0L : System.currentTimeMillis() - j3;
        return sb.toString();
    }

    public static void a(String str, int i, int i2, int i3, int i4, long j) {
        StringBuilder sb = new StringBuilder();
        sb.append("getCellInfoWithJsonFormat: ");
        sb.append(str);
        sb.append("isGsm=");
        boolean z = true;
        if (i3 != 1) {
            z = false;
        }
        sb.append(z);
        sb.append(", mcc,mnc=");
        sb.append(i);
        sb.append(",");
        sb.append(i2);
        sb.append(", lac,cid=");
        sb.append(i4);
        sb.append(",");
        sb.append(j);
    }

    public static boolean a(Location location, double[] dArr) {
        int latitude = (int) (location.getLatitude() * 1000000.0d);
        int longitude = (int) (location.getLongitude() * 1000000.0d);
        String a2 = g6.a("tencent_loc_lib");
        int i = 0;
        for (int i2 = 0; i2 < a2.length(); i2++) {
            i += a(a2.charAt(i2));
        }
        double[] dArr2 = new double[2];
        try {
            SoUtils.fun_b(latitude ^ i, longitude ^ i, dArr2);
        } catch (UnsatisfiedLinkError e) {
        }
        dArr[0] = dArr2[0];
        dArr[1] = dArr2[1];
        double d = dArr[0];
        double d2 = dArr[1];
        double d3 = dArr2[0];
        double d4 = dArr2[1];
        return true;
    }

    public static boolean a(ScanResult scanResult, int i) {
        return true;
    }

    public static boolean a(String str) {
        boolean z = false;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            boolean contains = str.contains("latitude");
            JSONArray optJSONArray = jSONObject.optJSONArray("cells");
            int length = optJSONArray == null ? 0 : optJSONArray.length();
            JSONArray optJSONArray2 = jSONObject.optJSONArray("wifis");
            int length2 = optJSONArray2 == null ? 0 : optJSONArray2.length();
            StringBuilder sb = new StringBuilder();
            sb.append("req gwc:");
            sb.append(contains ? "1" : "0");
            sb.append(",");
            sb.append(length2);
            sb.append(",");
            sb.append(length);
            s3.a("LOC", sb.toString());
            if (contains || length > 0 || length2 > 0) {
                z = true;
            }
            return z;
        } catch (Throwable th) {
            return false;
        }
    }

    public static byte[] a(byte[] bArr) {
        byte[] bArr2 = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            bArr2 = byteArray;
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Throwable th) {
            th.printStackTrace();
            return bArr2;
        }
    }
}
