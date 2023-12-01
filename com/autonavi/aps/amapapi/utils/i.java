package com.autonavi.aps.amapapi.utils;

import android.app.Application;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.ServiceInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.location.Location;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.amap.api.col.p0003sl.ho;
import com.amap.api.col.p0003sl.hs;
import com.amap.api.col.p0003sl.ht;
import com.amap.api.col.p0003sl.ib;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.DPoint;
import com.baidu.mobads.sdk.internal.bw;
import com.igexin.assist.util.AssistUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:com/autonavi/aps/amapapi/utils/i.class */
public final class i {

    /* renamed from: a  reason: collision with root package name */
    static WifiManager f9286a;
    private static int b;

    /* renamed from: c  reason: collision with root package name */
    private static String[] f9287c;
    private static String d;

    public static double a(double d2) {
        return b(d2);
    }

    public static float a(float f) {
        return (float) (((long) (f * 100.0d)) / 100.0d);
    }

    public static float a(AMapLocation aMapLocation, AMapLocation aMapLocation2) {
        return a(new double[]{aMapLocation.getLatitude(), aMapLocation.getLongitude(), aMapLocation2.getLatitude(), aMapLocation2.getLongitude()});
    }

    public static float a(DPoint dPoint, DPoint dPoint2) {
        return a(new double[]{dPoint.getLatitude(), dPoint.getLongitude(), dPoint2.getLatitude(), dPoint2.getLongitude()});
    }

    public static float a(double[] dArr) {
        float[] fArr = new float[1];
        Location.distanceBetween(dArr[0], dArr[1], dArr[2], dArr[3], fArr);
        return fArr[0];
    }

    public static int a(NetworkInfo networkInfo) {
        if (networkInfo != null && networkInfo.isAvailable() && networkInfo.isConnected()) {
            return networkInfo.getType();
        }
        return -1;
    }

    public static long a() {
        return System.currentTimeMillis();
    }

    public static Object a(Context context, String str) {
        if (context == null) {
            return null;
        }
        try {
            return context.getApplicationContext().getSystemService(str);
        } catch (Throwable th) {
            b.a(th, "Utils", "getServ");
            return null;
        }
    }

    public static String a(int i) {
        String str = "其他错误";
        if (i != 33) {
            switch (i) {
                case 0:
                    return bw.o;
                case 1:
                    return "重要参数为空";
                case 2:
                    return "WIFI信息不足";
                case 3:
                    return "请求参数获取出现异常";
                case 4:
                    return "网络连接异常";
                case 5:
                    return "解析数据异常";
                case 6:
                    return "定位结果错误";
                case 7:
                    return "KEY错误";
                case 8:
                    break;
                case 9:
                    return "初始化异常";
                case 10:
                    return "定位服务启动失败";
                case 11:
                    return "错误的基站信息，请检查是否插入SIM卡";
                case 12:
                    return "缺少定位权限";
                case 13:
                    return "网络定位失败，请检查设备是否插入sim卡，是否开启移动网络或开启了wifi模块";
                case 14:
                    return "GPS 定位失败，由于设备当前 GPS 状态差,建议持设备到相对开阔的露天场所再次尝试";
                case 15:
                    return "当前返回位置为模拟软件返回，请关闭模拟软件，或者在option中设置允许模拟";
                default:
                    switch (i) {
                        case 18:
                            return "定位失败，飞行模式下关闭了WIFI开关，请关闭飞行模式或者打开WIFI开关";
                        case 19:
                            return "定位失败，没有检查到SIM卡，并且关闭了WIFI开关，请打开WIFI开关或者插入SIM卡";
                        case 20:
                            return "模糊定位失败，具体可查看错误信息/详细信息描述";
                        default:
                            return "其他错误";
                    }
            }
        } else {
            str = "补偿定位失败，未命中缓存";
        }
        return str;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(long r5, java.lang.String r7) {
        /*
            r0 = r7
            r10 = r0
            r0 = r7
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto Le
            java.lang.String r0 = "yyyy-MM-dd HH:mm:ss"
            r10 = r0
        Le:
            r0 = 0
            r11 = r0
            java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat     // Catch: java.lang.Throwable -> L2c
            r1 = r0
            r2 = r10
            java.util.Locale r3 = java.util.Locale.CHINA     // Catch: java.lang.Throwable -> L2c
            r1.<init>(r2, r3)     // Catch: java.lang.Throwable -> L2c
            r7 = r0
            r0 = r7
            r1 = r10
            r0.applyPattern(r1)     // Catch: java.lang.Throwable -> L27
            goto L3a
        L27:
            r10 = move-exception
            goto L31
        L2c:
            r10 = move-exception
            r0 = r11
            r7 = r0
        L31:
            r0 = r10
            java.lang.String r1 = "Utils"
            java.lang.String r2 = "formatUTC"
            com.autonavi.aps.amapapi.utils.b.a(r0, r1, r2)
        L3a:
            r0 = r5
            r8 = r0
            r0 = r5
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 > 0) goto L46
            long r0 = a()
            r8 = r0
        L46:
            r0 = r7
            if (r0 != 0) goto L4d
            java.lang.String r0 = "NULL"
            return r0
        L4d:
            r0 = r7
            r1 = r8
            java.lang.Long r1 = java.lang.Long.valueOf(r1)
            java.lang.String r0 = r0.format(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.utils.i.a(long, java.lang.String):java.lang.String");
    }

    public static String a(Context context, TelephonyManager telephonyManager) {
        int i = 0;
        if (telephonyManager != null) {
            i = 0;
            try {
                if (context.getApplicationInfo().targetSdkVersion < 29) {
                    i = 0;
                    if (Build.VERSION.SDK_INT < 30) {
                        i = telephonyManager.getNetworkType();
                    }
                }
            } catch (Throwable th) {
                i = 0;
            }
        }
        switch (i) {
            case 1:
                return "GPRS";
            case 2:
                return "EDGE";
            case 3:
                return "UMTS";
            case 4:
                return "CDMA";
            case 5:
                return "EVDO_0";
            case 6:
                return "EVDO_A";
            case 7:
                return "1xRTT";
            case 8:
                return "HSDPA";
            case 9:
                return "HSUPA";
            case 10:
                return "HSPA";
            case 11:
                return "IDEN";
            case 12:
                return "EVDO_B";
            case 13:
                return "LTE";
            case 14:
                return "EHRPD";
            case 15:
                return "HSPAP";
            default:
                return "UNKWN";
        }
    }

    public static List<String> a(File file) {
        FileInputStream fileInputStream;
        InputStreamReader inputStreamReader;
        ArrayList arrayList = new ArrayList();
        BufferedReader bufferedReader = null;
        try {
            try {
                fileInputStream = b(file);
                try {
                    inputStreamReader = new InputStreamReader(fileInputStream, Charset.defaultCharset());
                    try {
                        BufferedReader bufferedReader2 = new BufferedReader(inputStreamReader);
                        while (true) {
                            try {
                                String readLine = bufferedReader2.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                arrayList.add(readLine);
                            } catch (Throwable th) {
                                bufferedReader = bufferedReader2;
                                if (bufferedReader != null) {
                                    bufferedReader.close();
                                }
                                if (inputStreamReader != null) {
                                    inputStreamReader.close();
                                }
                                if (fileInputStream != null) {
                                    fileInputStream.close();
                                }
                                return arrayList;
                            }
                        }
                        bufferedReader2.close();
                        inputStreamReader.close();
                        if (fileInputStream != null) {
                            fileInputStream.close();
                            return arrayList;
                        }
                    } catch (Throwable th2) {
                    }
                } catch (Throwable th3) {
                    inputStreamReader = null;
                }
            } catch (Throwable th4) {
                fileInputStream = null;
                inputStreamReader = null;
            }
            return arrayList;
        } catch (IOException e) {
            e.printStackTrace();
            return arrayList;
        }
    }

    public static void a(File file, String str) {
        FileOutputStream fileOutputStream = null;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                FileOutputStream c2 = c(file);
                if (str != null) {
                    fileOutputStream2 = c2;
                    fileOutputStream = c2;
                    c2.write(str.getBytes());
                }
                if (c2 != null) {
                    try {
                        c2.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } catch (IOException e2) {
                e2.printStackTrace();
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
            }
        } catch (Throwable th) {
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            }
            throw th;
        }
    }

    public static boolean a(Context context) {
        if (context == null) {
            return false;
        }
        try {
            return c() < 17 ? d(context, "android.provider.Settings$System") : d(context, "android.provider.Settings$Global");
        } catch (Throwable th) {
            return false;
        }
    }

    public static boolean a(SQLiteDatabase sQLiteDatabase, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String replace = "2.0.201501131131".replace(".", "");
        if (sQLiteDatabase != null) {
            Cursor cursor = null;
            try {
                if (sQLiteDatabase.isOpen()) {
                    StringBuilder sb = new StringBuilder("type = 'table' AND name = '");
                    sb.append(str.trim());
                    sb.append(replace);
                    sb.append("'");
                    Cursor query = sQLiteDatabase.query("sqlite_master", new String[]{"count(*) as c"}, sb.toString(), null, null, null, null);
                    boolean z = false;
                    if (query != null) {
                        z = false;
                        if (query.moveToFirst()) {
                            cursor = query;
                            z = false;
                            if (query.getInt(0) > 0) {
                                z = true;
                            }
                        }
                    }
                    if (query != null) {
                        query.close();
                    }
                    return z;
                }
                return false;
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                    return true;
                }
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001d A[Catch: all -> 0x0059, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x0059, blocks: (B:2:0x0000, B:11:0x001d, B:13:0x0028, B:16:0x0038, B:18:0x0041, B:20:0x004a), top: B:37:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x001b A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(android.location.Location r5, int r6) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L59
            r8 = r0
            r0 = r8
            r1 = 18
            if (r0 < r1) goto L13
            r0 = r5
            boolean r0 = r0.isFromMockProvider()     // Catch: java.lang.Throwable -> L5c
            r9 = r0
            goto L16
        L13:
            r0 = 0
            r9 = r0
        L16:
            r0 = r9
            if (r0 == 0) goto L1d
            r0 = 1
            return r0
        L1d:
            r0 = r5
            android.os.Bundle r0 = r0.getExtras()     // Catch: java.lang.Throwable -> L59
            r10 = r0
            r0 = r10
            if (r0 == 0) goto L61
            r0 = r10
            java.lang.String r1 = "satellites"
            int r0 = r0.getInt(r1)     // Catch: java.lang.Throwable -> L59
            r8 = r0
            goto L63
        L34:
            r0 = r6
            if (r0 != 0) goto L57
            r0 = r5
            double r0 = r0.getAltitude()     // Catch: java.lang.Throwable -> L59
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L57
            r0 = r5
            float r0 = r0.getBearing()     // Catch: java.lang.Throwable -> L59
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L57
            r0 = r5
            float r0 = r0.getSpeed()     // Catch: java.lang.Throwable -> L59
            r7 = r0
            r0 = r7
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L57
            r0 = 1
            return r0
        L57:
            r0 = 0
            return r0
        L59:
            r5 = move-exception
            r0 = 0
            return r0
        L5c:
            r10 = move-exception
            goto L13
        L61:
            r0 = 0
            r8 = r0
        L63:
            r0 = r8
            if (r0 > 0) goto L34
            r0 = 1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.utils.i.a(android.location.Location, int):boolean");
    }

    public static boolean a(AMapLocation aMapLocation) {
        if (aMapLocation != null && aMapLocation.getErrorCode() == 0) {
            return b(aMapLocation);
        }
        return false;
    }

    public static boolean a(com.autonavi.aps.amapapi.model.a aVar) {
        if (aVar == null || "8".equals(aVar.d()) || "5".equals(aVar.d()) || "6".equals(aVar.d())) {
            return false;
        }
        return b(aVar);
    }

    public static boolean a(String str) {
        boolean z = false;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (!"00:00:00:00:00:00".equals(str)) {
            if ("02:00:00:00:00:00".equals(str) || str.contains(" :")) {
                return false;
            }
            z = true;
        }
        return z;
    }

    public static boolean a(String str, String str2) {
        int i;
        int i2;
        int i3;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        ArrayList<String> b2 = b(str);
        String[] split = str2.toString().split("#");
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (true) {
            i = i6;
            if (i4 >= split.length) {
                break;
            }
            if (!split[i4].contains(",nb")) {
                i2 = i5;
                i3 = i;
                if (!split[i4].contains(",access")) {
                    i4++;
                    i5 = i2;
                    i6 = i3;
                }
            }
            int i7 = i5 + 1;
            i2 = i7;
            i3 = i;
            if (b2.contains(split[i4])) {
                i3 = i + 1;
                i2 = i7;
            }
            i4++;
            i5 = i2;
            i6 = i3;
        }
        return ((double) (i * 2)) >= ((double) (b2.size() + i5)) * 0.618d;
    }

    public static boolean a(JSONObject jSONObject, String str) {
        return ib.a(jSONObject, str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0009, code lost:
        if (r6.length < 2) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] a(int r5, byte[] r6) {
        /*
            r0 = r6
            if (r0 == 0) goto Lc
            r0 = r6
            r7 = r0
            r0 = r6
            int r0 = r0.length
            r1 = 2
            if (r0 >= r1) goto L10
        Lc:
            r0 = 2
            byte[] r0 = new byte[r0]
            r7 = r0
        L10:
            r0 = r7
            r1 = 0
            r2 = r5
            r3 = 255(0xff, float:3.57E-43)
            r2 = r2 & r3
            byte r2 = (byte) r2
            r0[r1] = r2
            r0 = r7
            r1 = 1
            r2 = r5
            r3 = 65280(0xff00, float:9.1477E-41)
            r2 = r2 & r3
            r3 = 8
            int r2 = r2 >> r3
            byte r2 = (byte) r2
            r0[r1] = r2
            r0 = r7
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.utils.i.a(int, byte[]):byte[]");
    }

    public static byte[] a(long j) {
        byte[] bArr = new byte[8];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 8) {
                return bArr;
            }
            bArr[i2] = (byte) ((j >> (i2 * 8)) & 255);
            i = i2 + 1;
        }
    }

    public static byte[] a(byte[] bArr) {
        return ib.b(bArr);
    }

    public static String[] a(TelephonyManager telephonyManager) {
        int i;
        int i2;
        String networkOperator = telephonyManager != null ? telephonyManager.getNetworkOperator() : null;
        String[] strArr = {"0", "0"};
        if (!TextUtils.isEmpty(networkOperator) && TextUtils.isDigitsOnly(networkOperator) && networkOperator.length() > 4) {
            strArr[0] = networkOperator.substring(0, 3);
            char[] charArray = networkOperator.substring(3).toCharArray();
            int i3 = 0;
            while (true) {
                i2 = i3;
                if (i2 >= charArray.length || !Character.isDigit(charArray[i2])) {
                    break;
                }
                i3 = i2 + 1;
            }
            strArr[1] = networkOperator.substring(3, i2 + 3);
        }
        try {
            i = Integer.parseInt(strArr[0]);
        } catch (Throwable th) {
            b.a(th, "Utils", "getMccMnc");
            i = 0;
        }
        if (i == 0) {
            strArr[0] = "0";
        }
        if (!"0".equals(strArr[0]) && !"0".equals(strArr[1])) {
            f9287c = strArr;
            return strArr;
        }
        String[] strArr2 = strArr;
        if ("0".equals(strArr[0])) {
            strArr2 = strArr;
            if ("0".equals(strArr[1])) {
                String[] strArr3 = f9287c;
                strArr2 = strArr;
                if (strArr3 != null) {
                    strArr2 = strArr3;
                }
            }
        }
        return strArr2;
    }

    public static double b(double d2) {
        return ((long) (d2 * 1000000.0d)) / 1000000.0d;
    }

    public static int b(byte[] bArr) {
        int i = 0;
        for (int i2 = 0; i2 < 2; i2++) {
            i |= (bArr[i2] & 255) << ((1 - i2) * 8);
        }
        return i;
    }

    public static long b() {
        return SystemClock.elapsedRealtime();
    }

    private static FileInputStream b(File file) throws IOException {
        if (!file.exists()) {
            throw new FileNotFoundException("File '" + file + "' does not exist");
        } else if (file.isDirectory()) {
            throw new IOException("File '" + file + "' exists but is a directory");
        } else if (file.canRead()) {
            return new FileInputStream(file);
        } else {
            throw new IOException("File '" + file + "' cannot be read");
        }
    }

    public static String b(Context context) {
        PackageInfo packageInfo;
        if (TextUtils.isEmpty(b.j)) {
            CharSequence charSequence = null;
            if (context == null) {
                return null;
            }
            try {
                packageInfo = context.getPackageManager().getPackageInfo(ho.c(context), 64);
            } catch (Throwable th) {
                b.a(th, "Utils", "getAppName part");
                packageInfo = null;
            }
            try {
                if (TextUtils.isEmpty(b.k)) {
                    b.k = null;
                }
            } catch (Throwable th2) {
                b.a(th2, "Utils", "getAppName");
            }
            StringBuilder sb = new StringBuilder();
            if (packageInfo != null) {
                if (packageInfo.applicationInfo != null) {
                    charSequence = packageInfo.applicationInfo.loadLabel(context.getPackageManager());
                }
                if (charSequence != null) {
                    sb.append(charSequence.toString());
                }
                if (!TextUtils.isEmpty(packageInfo.versionName)) {
                    sb.append(packageInfo.versionName);
                }
            }
            String c2 = ho.c(context);
            if (!TextUtils.isEmpty(c2)) {
                sb.append(",");
                sb.append(c2);
            }
            if (!TextUtils.isEmpty(b.k)) {
                sb.append(",");
                sb.append(b.k);
            }
            String sb2 = sb.toString();
            b.j = sb2;
            return sb2;
        }
        return b.j;
    }

    public static ArrayList<String> b(String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        if (!TextUtils.isEmpty(str)) {
            String[] split = str.split("#");
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= split.length) {
                    break;
                }
                if (split[i2].contains(",nb") || split[i2].contains(",access")) {
                    arrayList.add(split[i2]);
                }
                i = i2 + 1;
            }
        }
        return arrayList;
    }

    public static boolean b(Context context, String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getApplicationContext().getPackageManager().getPackageInfo(str, 256);
        } catch (Throwable th) {
            packageInfo = null;
        }
        return packageInfo != null;
    }

    public static boolean b(AMapLocation aMapLocation) {
        double longitude = aMapLocation.getLongitude();
        double latitude = aMapLocation.getLatitude();
        if (longitude == 0.0d && latitude == 0.0d) {
            return false;
        }
        boolean z = false;
        if (longitude <= 180.0d) {
            if (latitude > 90.0d) {
                return false;
            }
            z = false;
            if (longitude >= -180.0d) {
                if (latitude < -90.0d) {
                    return false;
                }
                z = true;
            }
        }
        return z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0009, code lost:
        if (r7.length < 4) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] b(int r6, byte[] r7) {
        /*
            r0 = r7
            if (r0 == 0) goto Lc
            r0 = r7
            r9 = r0
            r0 = r7
            int r0 = r0.length
            r1 = 4
            if (r0 >= r1) goto L10
        Lc:
            r0 = 4
            byte[] r0 = new byte[r0]
            r9 = r0
        L10:
            r0 = 0
            r8 = r0
        L12:
            r0 = r8
            r1 = r9
            int r1 = r1.length
            if (r0 >= r1) goto L2d
            r0 = r9
            r1 = r8
            r2 = r6
            r3 = r8
            r4 = 8
            int r3 = r3 * r4
            int r2 = r2 >> r3
            r3 = 255(0xff, float:3.57E-43)
            r2 = r2 & r3
            byte r2 = (byte) r2
            r0[r1] = r2
            r0 = r8
            r1 = 1
            int r0 = r0 + r1
            r8 = r0
            goto L12
        L2d:
            r0 = r9
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.utils.i.b(int, byte[]):byte[]");
    }

    public static double c(double d2) {
        return ((long) (d2 * 100.0d)) / 100.0d;
    }

    public static double c(String str) throws NumberFormatException {
        return Double.parseDouble(str);
    }

    public static int c() {
        int i = b;
        if (i > 0) {
            return i;
        }
        try {
            return e.b("android.os.Build$VERSION", "SDK_INT");
        } catch (Throwable th) {
            try {
                return Integer.parseInt(e.a("android.os.Build$VERSION", "SDK").toString());
            } catch (Throwable th2) {
                return 0;
            }
        }
    }

    public static NetworkInfo c(Context context) {
        try {
            return hs.p(context);
        } catch (Throwable th) {
            b.a(th, "Utils", "getNetWorkInfo");
            return null;
        }
    }

    private static FileOutputStream c(File file) throws IOException {
        if (!file.exists()) {
            File parentFile = file.getParentFile();
            if (parentFile != null) {
                if (!parentFile.mkdirs() && !parentFile.isDirectory()) {
                    throw new IOException("Directory '" + parentFile + "' could not be created");
                }
                file.createNewFile();
            }
        } else if (file.isDirectory()) {
            throw new IOException("File '" + file + "' exists but is a directory");
        } else if (!file.canWrite()) {
            throw new IOException("File '" + file + "' cannot be written to");
        }
        return new FileOutputStream(file, false);
    }

    public static boolean c(Context context, String str) {
        try {
            return Build.VERSION.SDK_INT >= 23 ? context != null && context.checkSelfPermission(ib.c(str)) == 0 : context != null && context.checkCallingOrSelfPermission(ib.c(str)) == 0;
        } catch (Throwable th) {
            return false;
        }
    }

    public static float d(String str) throws NumberFormatException {
        return Float.parseFloat(str);
    }

    public static int d() {
        return new Random().nextInt(65536) - 32768;
    }

    public static boolean d(Context context) {
        try {
            NetworkInfo c2 = c(context);
            if (c2 != null) {
                return c2.isConnectedOrConnecting();
            }
            return false;
        } catch (Throwable th) {
            return false;
        }
    }

    private static boolean d(Context context, String str) throws Throwable {
        return ((Integer) e.a(str, "getInt", new Object[]{context.getContentResolver(), ((String) e.a(str, "AIRPLANE_MODE_ON")).toString()}, new Class[]{ContentResolver.class, String.class})).intValue() == 1;
    }

    public static int e(String str) throws NumberFormatException {
        return Integer.parseInt(str);
    }

    public static String e() {
        try {
            return ht.b("S128DF1572465B890OE3F7A13167KLEI".getBytes("UTF-8")).substring(20);
        } catch (Throwable th) {
            return "";
        }
    }

    public static boolean e(Context context) {
        int i;
        if (Build.VERSION.SDK_INT < 23 || context.getApplicationInfo().targetSdkVersion < 23) {
            String[] strArr = com.autonavi.aps.amapapi.b.F;
            int length = strArr.length;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= length) {
                    return true;
                }
                if (context.checkCallingOrSelfPermission(strArr[i3]) != 0) {
                    return false;
                }
                i2 = i3 + 1;
            }
        } else {
            Application application = (Application) context;
            String[] strArr2 = com.autonavi.aps.amapapi.b.F;
            int length2 = strArr2.length;
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 >= length2) {
                    return true;
                }
                try {
                    i = e.b(application.getBaseContext(), "checkSelfPermission", strArr2[i5]);
                } catch (Throwable th) {
                    i = 0;
                }
                if (i != 0) {
                    return false;
                }
                i4 = i5 + 1;
            }
        }
    }

    public static int f(String str) throws NumberFormatException {
        return Integer.parseInt(str, 16);
    }

    public static boolean f(Context context) {
        int i;
        boolean z = true;
        if (context.getApplicationInfo().targetSdkVersion >= 29) {
            z = true;
            if (Build.VERSION.SDK_INT >= 29) {
                try {
                    i = e.b(((Application) context).getBaseContext(), "checkSelfPermission", com.autonavi.aps.amapapi.b.G);
                } catch (Throwable th) {
                    i = 0;
                }
                z = true;
                if (i != 0) {
                    z = false;
                }
            }
        }
        return z;
    }

    public static byte g(String str) throws NumberFormatException {
        return Byte.parseByte(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0048  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean g(android.content.Context r5) {
        /*
            r0 = r5
            if (r0 != 0) goto L6
            r0 = 1
            return r0
        L6:
            android.net.wifi.WifiManager r0 = com.autonavi.aps.amapapi.utils.i.f9286a
            if (r0 != 0) goto L19
            r0 = r5
            java.lang.String r1 = "wifi"
            java.lang.Object r0 = a(r0, r1)
            android.net.wifi.WifiManager r0 = (android.net.wifi.WifiManager) r0
            com.autonavi.aps.amapapi.utils.i.f9286a = r0
        L19:
            r0 = r5
            java.lang.String r1 = "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19XSUZJX1NUQVRF"
            boolean r0 = c(r0, r1)     // Catch: java.lang.Throwable -> L6b
            if (r0 == 0) goto L2d
            android.net.wifi.WifiManager r0 = com.autonavi.aps.amapapi.utils.i.f9286a     // Catch: java.lang.Throwable -> L6b
            boolean r0 = r0.isWifiEnabled()     // Catch: java.lang.Throwable -> L6b
            r6 = r0
            goto L42
        L2d:
            java.lang.Exception r0 = new java.lang.Exception     // Catch: java.lang.Throwable -> L6b
            r1 = r0
            java.lang.String r2 = "n_aws"
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L6b
            java.lang.String r1 = "OPENSDK_UTS"
            java.lang.String r2 = "iwfal_n_aws"
            com.autonavi.aps.amapapi.utils.b.a(r0, r1, r2)     // Catch: java.lang.Throwable -> L6b
        L40:
            r0 = 0
            r6 = r0
        L42:
            r0 = r6
            r7 = r0
            r0 = r6
            if (r0 != 0) goto L69
            r0 = r6
            r7 = r0
            int r0 = c()
            r1 = 17
            if (r0 <= r1) goto L69
            java.lang.String r0 = "true"
            android.net.wifi.WifiManager r1 = com.autonavi.aps.amapapi.utils.i.f9286a     // Catch: java.lang.Throwable -> L6f
            java.lang.String r2 = "isScanAlwaysAvailable"
            r3 = 0
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L6f
            java.lang.Object r1 = com.autonavi.aps.amapapi.utils.e.a(r1, r2, r3)     // Catch: java.lang.Throwable -> L6f
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch: java.lang.Throwable -> L6f
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Throwable -> L6f
            r7 = r0
        L69:
            r0 = r7
            return r0
        L6b:
            r5 = move-exception
            goto L40
        L6f:
            r5 = move-exception
            r0 = r6
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.utils.i.g(android.content.Context):boolean");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static String h(Context context) {
        String str;
        NetworkInfo c2 = c(context);
        if (c2 == null || !c2.isConnectedOrConnecting()) {
            return "DISCONNECTED";
        }
        int type = c2.getType();
        if (type == 1) {
            return "WIFI";
        }
        if (type == 0) {
            String subtypeName = c2.getSubtypeName();
            str = "3G";
            switch (c2.getSubtype()) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                case 16:
                    return "2G";
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                case 17:
                    break;
                case 13:
                    return "4G";
                default:
                    if ("GSM".equalsIgnoreCase(subtypeName)) {
                        return "2G";
                    }
                    str = "3G";
                    if (!"TD-SCDMA".equalsIgnoreCase(subtypeName)) {
                        str = "3G";
                        if (!"WCDMA".equalsIgnoreCase(subtypeName)) {
                            return "CDMA2000".equalsIgnoreCase(subtypeName) ? "3G" : subtypeName;
                        }
                    }
                    break;
            }
        } else {
            str = "UNKNOWN";
        }
        return str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x001e, code lost:
        if (r0.toLowerCase().contains(r3) != false) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean h(java.lang.String r3) {
        /*
            r0 = 0
            r4 = r0
            java.lang.String r0 = android.os.Build.MANUFACTURER     // Catch: java.lang.Throwable -> L25
            r6 = r0
            java.lang.String r0 = android.os.Build.BRAND     // Catch: java.lang.Throwable -> L25
            r7 = r0
            r0 = r6
            r1 = r3
            boolean r0 = r0.equalsIgnoreCase(r1)     // Catch: java.lang.Throwable -> L25
            if (r0 != 0) goto L21
            r0 = r7
            java.lang.String r0 = r0.toLowerCase()     // Catch: java.lang.Throwable -> L25
            r1 = r3
            boolean r0 = r0.contains(r1)     // Catch: java.lang.Throwable -> L25
            r5 = r0
            r0 = r5
            if (r0 == 0) goto L23
        L21:
            r0 = 1
            r4 = r0
        L23:
            r0 = r4
            return r0
        L25:
            r3 = move-exception
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.utils.i.h(java.lang.String):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0015, code lost:
        if (r0.equals("00:00:00:00:00:00") != false) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String i(android.content.Context r3) {
        /*
            r0 = r3
            java.lang.String r0 = com.amap.api.col.p0003sl.hs.k(r0)
            r5 = r0
            r0 = r5
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L18
            r0 = r5
            r4 = r0
            r0 = r5
            java.lang.String r1 = "00:00:00:00:00:00"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L1d
        L18:
            r0 = r3
            java.lang.String r0 = com.autonavi.aps.amapapi.utils.h.a(r0)
            r4 = r0
        L1d:
            r0 = r4
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L28
            java.lang.String r0 = "00:00:00:00:00:00"
            return r0
        L28:
            r0 = r4
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.utils.i.i(android.content.Context):java.lang.String");
    }

    public static boolean j(Context context) {
        return Build.VERSION.SDK_INT >= 28 && context.getApplicationInfo().targetSdkVersion >= 28;
    }

    public static boolean k(Context context) {
        ServiceInfo serviceInfo;
        try {
            serviceInfo = context.getPackageManager().getServiceInfo(new ComponentName(context, "com.amap.api.location.APSService"), 128);
        } catch (Throwable th) {
            serviceInfo = null;
        }
        return serviceInfo != null;
    }

    public static String l(Context context) {
        if (d == null) {
            d = com.autonavi.aps.amapapi.security.a.a("MD5", ho.c(context));
        }
        return d;
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x000f, code lost:
        if (n(r2) != false) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean m(android.content.Context r2) {
        /*
            r0 = 0
            r3 = r0
            r0 = r2
            boolean r0 = o(r0)     // Catch: java.lang.Throwable -> L16
            if (r0 != 0) goto L12
            r0 = r2
            boolean r0 = n(r0)     // Catch: java.lang.Throwable -> L16
            r4 = r0
            r0 = r4
            if (r0 == 0) goto L14
        L12:
            r0 = 1
            r3 = r0
        L14:
            r0 = r3
            return r0
        L16:
            r2 = move-exception
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.utils.i.m(android.content.Context):boolean");
    }

    private static boolean n(Context context) {
        return h(AssistUtils.BRAND_VIVO) && p(context) && q(context);
    }

    private static boolean o(Context context) {
        boolean z = false;
        try {
            if (Build.VERSION.SDK_INT >= 31) {
                z = false;
                if (context != null) {
                    z = false;
                    if (context.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0) {
                        z = false;
                        if (context.checkSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0) {
                            z = true;
                        }
                    }
                }
            }
            return z;
        } catch (Throwable th) {
            return false;
        }
    }

    private static boolean p(Context context) {
        boolean z = false;
        try {
            int i = Build.VERSION.SDK_INT;
            int i2 = context.getApplicationInfo().targetSdkVersion;
            boolean z2 = i == 30;
            boolean z3 = i2 >= 23;
            boolean z4 = i == 31;
            boolean z5 = i2 <= 30 && i2 >= 23;
            boolean z6 = z2 && z3;
            boolean z7 = z4 && z5;
            if (z6 || z7) {
                z = true;
            }
            return z;
        } catch (Throwable th) {
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0077  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean q(android.content.Context r9) {
        /*
            r0 = 0
            r11 = r0
            r0 = r9
            java.lang.String r0 = r0.getPackageName()     // Catch: java.lang.Throwable -> L80
            r13 = r0
            r0 = r9
            android.content.ContentResolver r0 = r0.getContentResolver()     // Catch: java.lang.Throwable -> L80
            java.lang.String r1 = "content://com.vivo.permissionmanager.provider.permission/fuzzy_location_apps"
            android.net.Uri r1 = android.net.Uri.parse(r1)     // Catch: java.lang.Throwable -> L80
            r2 = 2
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch: java.lang.Throwable -> L80
            r3 = r2
            r4 = 0
            java.lang.String r5 = "package_name"
            r3[r4] = r5     // Catch: java.lang.Throwable -> L80
            r3 = r2
            r4 = 1
            java.lang.String r5 = "selected_fuzzy"
            r3[r4] = r5     // Catch: java.lang.Throwable -> L80
            java.lang.String r3 = "package_name=?"
            r4 = 1
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch: java.lang.Throwable -> L80
            r5 = r4
            r6 = 0
            r7 = r13
            r5[r6] = r7     // Catch: java.lang.Throwable -> L80
            r5 = 0
            android.database.Cursor r0 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L80
            r9 = r0
            r0 = 0
            r11 = r0
        L35:
            r0 = r9
            r13 = r0
            r0 = r11
            r12 = r0
            r0 = r9
            if (r0 == 0) goto L72
            r0 = r9
            r13 = r0
            r0 = r11
            r12 = r0
            r0 = r9
            boolean r0 = r0.moveToNext()     // Catch: java.lang.Throwable -> L84
            if (r0 == 0) goto L72
            r0 = r9
            r1 = 0
            java.lang.String r0 = r0.getString(r1)     // Catch: java.lang.Throwable -> L84
            if (r0 == 0) goto L35
            r0 = r9
            r1 = 1
            int r0 = r0.getInt(r1)     // Catch: java.lang.Throwable -> L84
            r10 = r0
            r0 = r10
            r1 = 1
            if (r0 != r1) goto L35
            r0 = 1
            r11 = r0
            goto L35
        L68:
            goto L6d
        L6b:
            r0 = 0
            r9 = r0
        L6d:
            r0 = r11
            r12 = r0
            r0 = r9
            r13 = r0
        L72:
            r0 = r13
            if (r0 == 0) goto L7e
            r0 = r13
            r0.close()
        L7e:
            r0 = r12
            return r0
        L80:
            r9 = move-exception
            goto L6b
        L84:
            r13 = move-exception
            goto L68
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.utils.i.q(android.content.Context):boolean");
    }
}
