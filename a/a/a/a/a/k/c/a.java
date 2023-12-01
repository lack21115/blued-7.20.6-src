package a.a.a.a.a.k.c;

import a.a.a.a.a.e.e;
import android.app.ActivityManager;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Debug;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoWcdma;
import android.telephony.TelephonyManager;
import android.view.Choreographer;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.lang.reflect.Method;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/k/c/a.class */
public final class a {

    /* renamed from: a.a.a.a.a.k.c.a$a  reason: collision with other inner class name */
    /* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/k/c/a$a.class */
    public static class C0014a {

        /* renamed from: a  reason: collision with root package name */
        public final float f1352a;
        public final float b;

        public C0014a(float f, float f2) {
            this.f1352a = f;
            this.b = f2;
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/k/c/a$b.class */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final long f1353a;
        public final long b;

        /* renamed from: c  reason: collision with root package name */
        public final long f1354c;

        public b(long j, long j2, long j3, long j4) {
            this.f1353a = j;
            this.b = j2;
            this.f1354c = j4;
        }
    }

    public static b a(Context context) {
        ActivityManager activityManager;
        if (Build.VERSION.SDK_INT >= 16 && (activityManager = (ActivityManager) context.getSystemService("activity")) != null) {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            Debug.MemoryInfo memoryInfo2 = new Debug.MemoryInfo();
            Debug.getMemoryInfo(memoryInfo2);
            long j = (memoryInfo2.dalvikPrivateDirty + memoryInfo2.nativePrivateDirty) * 1024;
            long j2 = memoryInfo.totalMem;
            return new b(j2, j2 - memoryInfo.availMem, memoryInfo.threshold, j);
        }
        return new b(0L, 0L, 0L, 0L);
    }

    public static String a() {
        String hostAddress;
        try {
            DatagramSocket datagramSocket = new DatagramSocket();
            datagramSocket.connect(InetAddress.getByName("114.114.114.114"), 53);
            InetAddress localAddress = datagramSocket.getLocalAddress();
            datagramSocket.close();
            return (localAddress == null || (hostAddress = localAddress.getHostAddress()) == null || "::".equals(hostAddress)) ? "" : hostAddress;
        } catch (IOException e) {
            return "";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002e A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(java.lang.String r6, java.lang.String r7, org.json.JSONObject r8) {
        /*
            Method dump skipped, instructions count: 229
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.a.a.a.k.c.a.a(java.lang.String, java.lang.String, org.json.JSONObject):java.lang.String");
    }

    public static boolean a(Context context, String str) {
        return context.checkCallingOrSelfPermission(str) == 0;
    }

    public static String b(Context context) {
        if (context == null) {
            return "";
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager == null) {
            return "None";
        }
        try {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            return (activeNetworkInfo != null && activeNetworkInfo.isConnected() && activeNetworkInfo.getState() == NetworkInfo.State.CONNECTED) ? activeNetworkInfo.getType() == 1 ? "WIFI" : activeNetworkInfo.getSubtypeName() : "None";
        } catch (Exception e) {
            return "Unknown";
        }
    }

    public static InetAddress[] b() {
        String hostAddress;
        try {
            LineNumberReader lineNumberReader = new LineNumberReader(new InputStreamReader(Runtime.getRuntime().exec("getprop").getInputStream()));
            ArrayList arrayList = new ArrayList(5);
            while (true) {
                String readLine = lineNumberReader.readLine();
                if (readLine == null) {
                    break;
                }
                int indexOf = readLine.indexOf("]: [");
                if (indexOf != -1) {
                    int i = indexOf + 4;
                    if (i + 7 <= readLine.length() - 1) {
                        String substring = readLine.substring(1, indexOf);
                        String substring2 = readLine.substring(i, readLine.length() - 1);
                        if (substring.endsWith(".dns") || substring.endsWith(".dns1") || substring.endsWith(".dns2") || substring.endsWith(".dns3") || substring.endsWith(".dns4")) {
                            InetAddress byName = InetAddress.getByName(substring2);
                            if (byName != null && (hostAddress = byName.getHostAddress()) != null && hostAddress.length() != 0) {
                                arrayList.add(byName);
                            }
                        }
                    }
                }
            }
            if (arrayList.size() > 0) {
                return (InetAddress[]) arrayList.toArray(new InetAddress[arrayList.size()]);
            }
            return null;
        } catch (IOException e) {
            e eVar = e.f1313c;
            eVar.b("Exception in findDNSByExec: " + e);
            return null;
        }
    }

    public static boolean c(Context context) {
        String packageName;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        if (context == null || (packageName = context.getPackageName()) == null || (runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) == null) {
            return true;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (packageName.equals(runningAppProcessInfo.processName)) {
                if (runningAppProcessInfo.importance != 100) {
                    e eVar = e.f1313c;
                    String packageName2 = context.getPackageName();
                    eVar.c(packageName2, "Background" + runningAppProcessInfo.processName);
                    return true;
                }
                e eVar2 = e.f1313c;
                String packageName3 = context.getPackageName();
                eVar2.c(packageName3, "Foreground" + runningAppProcessInfo.processName);
                return false;
            }
        }
        return false;
    }

    public static InetAddress[] c() {
        InetAddress byName;
        String hostAddress;
        try {
            Method method = Class.forName("android.os.SystemProperties").getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class);
            ArrayList arrayList = new ArrayList(5);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= 4) {
                    break;
                }
                String str = (String) method.invoke(null, new String[]{"net.dns1", "net.dns2", "net.dns3", "net.dns4"}[i2]);
                if (str != null && str.length() != 0 && (byName = InetAddress.getByName(str)) != null && (hostAddress = byName.getHostAddress()) != null && hostAddress.length() != 0 && !arrayList.contains(byName)) {
                    arrayList.add(byName);
                }
                i = i2 + 1;
            }
            if (arrayList.size() > 0) {
                return (InetAddress[]) arrayList.toArray(new InetAddress[arrayList.size()]);
            }
            return null;
        } catch (Exception e) {
            e eVar = e.f1313c;
            eVar.b("Exception in findDNSByReflection" + e);
            return null;
        }
    }

    public static String d() {
        InetAddress[] c2 = c();
        String str = "";
        InetAddress[] inetAddressArr = c2;
        if (c2 == null) {
            InetAddress[] b2 = b();
            inetAddressArr = b2;
            if (b2 == null) {
                return "";
            }
        }
        int length = inetAddressArr.length;
        String[] strArr = new String[length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return str;
            }
            strArr[i2] = inetAddressArr[i2].toString();
            if (strArr[i2].indexOf(47) == 0) {
                strArr[i2] = strArr[i2].substring(1);
                str = strArr[i2];
            }
            i = i2 + 1;
        }
    }

    public static boolean d(Context context) {
        if (context != null) {
            try {
                if (a(context, "android.permission.READ_PHONE_STATE")) {
                    return a(context, "android.permission.ACCESS_COARSE_LOCATION");
                }
                return false;
            } catch (RuntimeException e) {
                e eVar = e.e;
                eVar.e("QosUtil", "getPhonePermission failed: " + e.getMessage());
                return false;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 45, insn: 0x0385: MOVE  (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r45 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:119:0x0385 */
    /* JADX WARN: Removed duplicated region for block: B:182:0x02d0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:194:0x031a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:208:0x0292 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r45v21, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r45v23, types: [java.io.IOException] */
    /* JADX WARN: Type inference failed for: r45v24 */
    /* JADX WARN: Type inference failed for: r45v25, types: [java.lang.InterruptedException] */
    /* JADX WARN: Type inference failed for: r45v26 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:133:0x03ae -> B:218:0x0065). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:141:0x03c2 -> B:196:0x00e5). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:147:0x03d1 -> B:214:0x0163). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static a.a.a.a.a.k.c.a.C0014a e() {
        /*
            Method dump skipped, instructions count: 1042
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.a.a.a.k.c.a.e():a.a.a.a.a.k.c.a$a");
    }

    public static boolean e(Context context) {
        if (context != null) {
            try {
                return a(context, "android.permission.ACCESS_WIFI_STATE");
            } catch (RuntimeException e) {
                e eVar = e.e;
                eVar.e("QosUtil", "getWifiPermission failed: " + e.getMessage());
                return false;
            }
        }
        return false;
    }

    public static void f() {
        if (Build.VERSION.SDK_INT >= 16) {
            a.a.a.a.a.k.d.a.f1355a.a();
            try {
                Choreographer.getInstance().postFrameCallback(a.a.a.a.a.k.d.a.f1355a);
            } catch (RuntimeException e) {
                e.printStackTrace();
            }
        }
    }

    public static String[] f(Context context) {
        WifiManager wifiManager;
        WifiInfo connectionInfo;
        if (!e(context) || (wifiManager = (WifiManager) context.getSystemService("wifi")) == null || (connectionInfo = wifiManager.getConnectionInfo()) == null) {
            return null;
        }
        return new String[]{connectionInfo.getSSID(), Integer.toString(connectionInfo.getRssi())};
    }

    public static void g() {
        if (Build.VERSION.SDK_INT >= 16) {
            a.a.a.a.a.k.d.a.f1355a.b();
        }
    }

    public static String[] g(Context context) {
        String[] strArr = null;
        if (context != null) {
            strArr = null;
            if (d(context)) {
                strArr = null;
                if (Build.VERSION.SDK_INT > 17) {
                    TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                    if (telephonyManager == null) {
                        return null;
                    }
                    String[] strArr2 = {"", ""};
                    int i = 0;
                    strArr2[0] = telephonyManager.getNetworkOperatorName();
                    List<CellInfo> allCellInfo = telephonyManager.getAllCellInfo();
                    strArr = strArr2;
                    if (allCellInfo != null) {
                        while (true) {
                            strArr = strArr2;
                            if (i >= allCellInfo.size()) {
                                break;
                            }
                            if (allCellInfo.get(i).isRegistered()) {
                                CellInfo cellInfo = allCellInfo.get(i);
                                if (cellInfo instanceof CellInfoCdma) {
                                    strArr2[1] = String.valueOf(((CellInfoCdma) cellInfo).getCellSignalStrength().getLevel());
                                } else if (cellInfo instanceof CellInfoWcdma) {
                                    strArr2[1] = String.valueOf(((CellInfoWcdma) cellInfo).getCellSignalStrength().getLevel());
                                } else if (cellInfo instanceof CellInfoGsm) {
                                    strArr2[1] = String.valueOf(((CellInfoGsm) cellInfo).getCellSignalStrength().getLevel());
                                } else if (cellInfo instanceof CellInfoLte) {
                                    strArr2[1] = String.valueOf(((CellInfoLte) cellInfo).getCellSignalStrength().getLevel());
                                }
                            }
                            i++;
                        }
                    }
                }
            }
        }
        return strArr;
    }

    public static int h() {
        if (Build.VERSION.SDK_INT >= 16) {
            return a.a.a.a.a.k.d.a.f1355a.c();
        }
        return 60;
    }
}
