package com.tencent.tendinsv.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.SystemClock;
import android.provider.Settings;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.lang.reflect.Method;
import java.util.Arrays;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tendinsv/utils/g.class */
public class g {

    /* renamed from: a  reason: collision with root package name */
    static boolean f25404a = false;
    static int b = -2;

    /* renamed from: c  reason: collision with root package name */
    static int f25405c = -1;
    private static final long d = 3000;
    private static long e = 0;
    private static int f = -1;

    private static int a() {
        Integer num;
        int i = -1;
        try {
            Class<?> cls = Class.forName("android.telephony.SubscriptionManager");
            if (Build.VERSION.SDK_INT >= 22) {
                Method declaredMethod = cls.getDeclaredMethod("getDefaultDataSubscriptionId", new Class[0]);
                declaredMethod.setAccessible(true);
                num = (Integer) declaredMethod.invoke(null, new Object[0]);
            } else {
                Method method = cls.getMethod("getDefaultDataSubId", new Class[0]);
                method.setAccessible(true);
                num = (Integer) method.invoke(null, new Object[0]);
            }
            int intValue = num.intValue();
            i = intValue;
            l.a(com.tencent.tendinsv.b.L, "default data sub scriptionId", Integer.valueOf(intValue));
            return intValue;
        } catch (Throwable th) {
            l.d(com.tencent.tendinsv.b.L, "default data sub scriptionId Exception_e", th);
            return i;
        }
    }

    private static int a(int i) {
        l.a(com.tencent.tendinsv.b.L, "getNetwork1 networkType", Integer.valueOf(i));
        switch (i) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
            case 16:
                return 2;
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
                return 3;
            case 13:
            case 18:
            case 19:
                return 4;
            case 20:
                return 5;
            default:
                return 0;
        }
    }

    public static Integer a(Context context, int i) {
        Method declaredMethod;
        Method method;
        try {
            int g = g(context);
            boolean a2 = a(context, "defaultdata_sub");
            l.a(com.tencent.tendinsv.b.L, "slot index", Integer.valueOf(i), Integer.valueOf(g), Boolean.valueOf(a2));
            if (g > 0 && (i == 0 || a2)) {
                if (Build.VERSION.SDK_INT < 22) {
                    Class<?> cls = Class.forName("android.telephony.SubscriptionManager");
                    try {
                        declaredMethod = cls.getDeclaredMethod("getDefaultDataSubId", new Class[0]);
                    } catch (NoSuchMethodException e2) {
                        declaredMethod = cls.getDeclaredMethod("getDefaultDataSubscriptionId", new Class[0]);
                    }
                    int intValue = ((Integer) declaredMethod.invoke(null, new Object[0])).intValue();
                    f25405c = Build.VERSION.SDK_INT == 21 ? ((Integer) cls.getDeclaredMethod("getSlotId", Long.TYPE).invoke(null, Long.valueOf(intValue))).intValue() : ((Integer) cls.getDeclaredMethod("getSlotId", Integer.TYPE).invoke(null, Integer.valueOf(intValue))).intValue();
                    return Integer.valueOf(f25405c);
                }
                SubscriptionManager subscriptionManager = (SubscriptionManager) context.getSystemService(Context.TELEPHONY_SUBSCRIPTION_SERVICE);
                if (e.a(context, "android.permission.READ_PHONE_STATE")) {
                    l.a(com.tencent.tendinsv.b.L, "get default data SubscriptionInfo by system");
                    SubscriptionInfo subscriptionInfo = (SubscriptionInfo) subscriptionManager.getClass().getMethod("getDefaultDataSubscriptionInfo", new Class[0]).invoke(subscriptionManager, new Object[0]);
                    if (subscriptionInfo != null) {
                        f25405c = subscriptionInfo.getSimSlotIndex();
                    }
                }
                if (f25405c < 0 && (method = subscriptionManager.getClass().getMethod("getDefaultDataPhoneId", new Class[0])) != null) {
                    f25405c = ((Integer) method.invoke(subscriptionManager, new Object[0])).intValue();
                }
            }
        } catch (Throwable th) {
            l.d(com.tencent.tendinsv.b.L, "slot index Exception_e", th);
        }
        l.a(com.tencent.tendinsv.b.L, "default data slot index", Integer.valueOf(f25405c));
        return Integer.valueOf(f25405c);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private static String a(String str) {
        boolean z;
        int hashCode = str.hashCode();
        switch (hashCode) {
            case 49679470:
                if (str.equals("46000")) {
                    z = false;
                    break;
                }
                z = true;
                break;
            case 49679471:
                if (str.equals("46001")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 49679472:
                if (str.equals("46002")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 49679473:
                if (str.equals("46003")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 49679474:
                if (str.equals("46004")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 49679475:
                if (str.equals("46005")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 49679476:
                if (str.equals("46006")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 49679477:
                if (str.equals("46007")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 49679478:
                if (str.equals("46008")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 49679479:
                if (str.equals("46009")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            default:
                switch (hashCode) {
                    case 49679501:
                        if (str.equals("46010")) {
                            z = true;
                            break;
                        }
                        z = true;
                        break;
                    case 49679502:
                        if (str.equals("46011")) {
                            z = true;
                            break;
                        }
                        z = true;
                        break;
                    case 49679503:
                        if (str.equals("46012")) {
                            z = true;
                            break;
                        }
                        z = true;
                        break;
                    case 49679504:
                        if (str.equals("46013")) {
                            z = true;
                            break;
                        }
                        z = true;
                        break;
                    default:
                        z = true;
                        break;
                }
        }
        switch (z) {
            case false:
            case true:
            case true:
            case true:
            case true:
            case true:
                return com.tencent.tendinsv.b.i;
            case true:
            case true:
            case true:
            case true:
                return com.tencent.tendinsv.b.g;
            case true:
            case true:
            case true:
            case true:
                return com.tencent.tendinsv.b.h;
            default:
                return "Unknown_Operator";
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x007a, code lost:
        if (r0 >= 2) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x008b, code lost:
        if (r0 >= 3) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x009c, code lost:
        if (r0 >= 4) goto L37;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(android.content.Context r6) {
        /*
            Method dump skipped, instructions count: 280
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tendinsv.utils.g.a(android.content.Context):boolean");
    }

    public static boolean a(Context context, String str) {
        try {
        } catch (Exception e2) {
            l.d(com.tencent.tendinsv.b.F, "data sim card changed Exception_e", e2);
        }
        if (g(context) > 0 && -1 != b) {
            int d2 = d(context);
            b = d2;
            if (-1 != d2) {
                int b2 = t.b(context, str, -2);
                l.a(com.tencent.tendinsv.b.L, "data sim card changed sub", str, Integer.valueOf(b2), Integer.valueOf(b));
                if (b != b2) {
                    f25404a = true;
                    t.a(context, str, b);
                }
            }
            l.a(com.tencent.tendinsv.b.L, "data sim card changed ", Boolean.valueOf(f25404a));
            return f25404a;
        }
        f25404a = false;
        l.a(com.tencent.tendinsv.b.L, "data sim card changed ", Boolean.valueOf(f25404a));
        return f25404a;
    }

    private static int b(Context context, int i) {
        if (i != -1) {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                Method declaredMethod = Class.forName("android.telephony.TelephonyManager").getDeclaredMethod("getNetworkType", Integer.TYPE);
                declaredMethod.setAccessible(true);
                return ((Integer) declaredMethod.invoke(telephonyManager, Integer.valueOf(i))).intValue();
            } catch (Throwable th) {
                l.d(com.tencent.tendinsv.b.L, "getNetworkType Exception_e", th);
                return -1;
            }
        }
        return -1;
    }

    private static int b(String str) {
        if (d.a(str)) {
            return 0;
        }
        String lowerCase = str.toLowerCase();
        if (lowerCase.contains("lte") || lowerCase.contains("iwlan")) {
            return 4;
        }
        if (lowerCase.contains("nr")) {
            return 5;
        }
        if (lowerCase.contains("unknown")) {
            return 0;
        }
        if (lowerCase.contains("gprs") || lowerCase.contains("edge") || lowerCase.contains("cdma") || lowerCase.contains("1xrtt") || lowerCase.contains("iden")) {
            return 2;
        }
        return (lowerCase.contains("umts") || lowerCase.contains("evdo") || lowerCase.contains("hsdpa") || lowerCase.contains("hsupa") || lowerCase.contains("hspa") || lowerCase.contains("ehrpd") || lowerCase.contains("scdma")) ? 3 : 0;
    }

    private static String b(Context context, String str) {
        String str2;
        try {
            Class<?> loadClass = context.getClassLoader().loadClass("android.os.SystemProperties");
            str2 = (String) loadClass.getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class).invoke(loadClass, new String(str));
        } catch (Throwable th) {
            l.d(com.tencent.tendinsv.b.L, "getGMSType Exception_e", th);
            str2 = "";
        }
        l.a(com.tencent.tendinsv.b.L, "get gms  type", str, "gmsType", str2);
        return str2;
    }

    public static boolean b(Context context) {
        boolean z;
        WifiManager wifiManager;
        try {
            wifiManager = (WifiManager) context.getSystemService("wifi");
        } catch (Exception e2) {
            l.d(com.tencent.tendinsv.b.L, "is wifi enable Exception", false);
        }
        if (wifiManager != null) {
            z = wifiManager.isWifiEnabled();
            l.a(com.tencent.tendinsv.b.L, "is wifi enable", Boolean.valueOf(z));
            return z;
        }
        z = false;
        l.a(com.tencent.tendinsv.b.L, "is wifi enable", Boolean.valueOf(z));
        return z;
    }

    private static int c(Context context, int i) {
        if (i < 0) {
            return 0;
        }
        try {
            String b2 = b(context, "gsm.network.type");
            String b3 = b(context, "gsm.network.type.2");
            String str = b2;
            if (!d.a(b3)) {
                str = b2 + "," + b3;
            }
            String[] split = d.a(str) ? null : str.split(",");
            String str2 = null;
            if (split != null) {
                str2 = null;
                if (split.length > i) {
                    str2 = split[i];
                }
            }
            return b(str2);
        } catch (Throwable th) {
            l.d(com.tencent.tendinsv.b.L, "getGSMNetwork Exception_e", th);
            return 0;
        }
    }

    public static String c(Context context) {
        try {
            String a2 = a(i(context));
            l.a(com.tencent.tendinsv.b.L, "network Operator Type", a2);
            return a2;
        } catch (Throwable th) {
            l.d(com.tencent.tendinsv.b.F, "network Operator Exception_e", th);
            return "Unknown_Operator";
        }
    }

    public static int d(Context context) {
        try {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (elapsedRealtime - e > 3000 || elapsedRealtime < e) {
                e = SystemClock.elapsedRealtime();
                int a2 = a();
                f = a2;
                if (-1 == a2) {
                    f = h(context);
                }
            }
        } catch (Exception e2) {
            l.d(com.tencent.tendinsv.b.L, "data sub  Exception_e", e2);
        }
        l.a(com.tencent.tendinsv.b.L, "current data sub ", Integer.valueOf(f));
        return f;
    }

    private static int d(Context context, int i) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            Method declaredMethod = TelephonyManager.class.getDeclaredMethod("getSimState", Integer.TYPE);
            declaredMethod.setAccessible(true);
            int intValue = ((Integer) declaredMethod.invoke(telephonyManager, Integer.valueOf(i))).intValue();
            l.a(com.tencent.tendinsv.b.L, "data sim card simState invoke", Integer.valueOf(intValue));
            l.a(com.tencent.tendinsv.b.L, "sim card id", Integer.valueOf(i), "simState", Integer.valueOf(intValue));
            return intValue;
        } catch (Throwable th) {
            l.d(com.tencent.tendinsv.b.L, "get sim card  Exception_e", th);
            return 1;
        }
    }

    public static int e(Context context) {
        int a2;
        if (e.a(context, "android.permission.READ_PHONE_STATE")) {
            try {
                a2 = a(b(context, d(context)));
            } catch (Throwable th) {
                l.d(com.tencent.tendinsv.b.L, "getNetworkType Exception_e", th);
                return 0;
            }
        } else {
            a2 = 0;
        }
        int i = a2;
        if (a2 == 0) {
            int intValue = a(context, 1).intValue();
            i = a2;
            if (intValue >= 0) {
                i = c(context, intValue);
            }
        }
        int i2 = i;
        if (i == 0) {
            int j = j(context);
            i2 = a(j);
            l.a(com.tencent.tendinsv.b.L, "getNetworkType networkType", Integer.valueOf(j), "network", Integer.valueOf(i2));
        }
        l.a(com.tencent.tendinsv.b.L, "getNetworkType network", Integer.valueOf(i2));
        return i2;
    }

    public static boolean f(Context context) {
        boolean z;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
            Method declaredMethod = ConnectivityManager.class.getDeclaredMethod("getMobileDataEnabled", new Class[0]);
            declaredMethod.setAccessible(true);
            z = ((Boolean) declaredMethod.invoke(connectivityManager, new Object[0])).booleanValue();
        } catch (Throwable th) {
            l.d(com.tencent.tendinsv.b.F, "getMobileDataEnabled Exception_e", th);
            z = true;
        }
        l.a(com.tencent.tendinsv.b.L, "mobile data enable  ", Boolean.valueOf(z));
        return z;
    }

    public static int g(Context context) {
        int i;
        int i2;
        try {
            String b2 = b(context, "gsm.sim.state");
            String b3 = b(context, "gsm.sim.state.2");
            String str = b2;
            if (!d.a(b3)) {
                str = b2 + "," + b3;
            }
            String[] split = d.a(str) ? null : str.split(",");
            l.a(com.tencent.tendinsv.b.L, "sim state", Arrays.toString(split));
            if (split != null) {
                int length = split.length;
                int i3 = 0;
                int i4 = 0;
                while (true) {
                    i = i4;
                    i2 = i;
                    if (i3 >= length) {
                        break;
                    }
                    String str2 = split[i3];
                    int i5 = i;
                    try {
                        if (!"ABSENT".equalsIgnoreCase(str2)) {
                            i5 = i;
                            if (!"NOT_READY".equalsIgnoreCase(str2)) {
                                i5 = i + 1;
                            }
                        }
                        i3++;
                        i4 = i5;
                    } catch (Exception e2) {
                        e = e2;
                        l.a(com.tencent.tendinsv.b.L, "simCardCount Exception", e);
                        i2 = i;
                        l.a(com.tencent.tendinsv.b.L, "current sim card count", Integer.valueOf(i2));
                        return i2;
                    }
                }
            } else {
                int d2 = d(context, 0);
                int d3 = d(context, 1);
                l.a(com.tencent.tendinsv.b.L, "simState1", Integer.valueOf(d2), "statesLength", Integer.valueOf(d3));
                int i6 = d2 == 5 ? 1 : 0;
                i2 = i6;
                if (d3 == 5) {
                    i2 = i6 + 1;
                }
            }
        } catch (Exception e3) {
            e = e3;
            i = 0;
        }
        l.a(com.tencent.tendinsv.b.L, "current sim card count", Integer.valueOf(i2));
        return i2;
    }

    private static int h(Context context) {
        int intValue = a(context, 0).intValue();
        try {
            Method declaredMethod = Class.forName("android.telephony.SubscriptionManager").getDeclaredMethod("getSubId", Integer.TYPE);
            declaredMethod.setAccessible(true);
            int[] iArr = (int[]) declaredMethod.invoke(null, Integer.valueOf(intValue));
            if (iArr.length > 0) {
                return iArr[0];
            }
        } catch (Exception e2) {
            l.d(com.tencent.tendinsv.b.L, "data sub by subid Exception_e", e2);
        }
        return intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x004d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String i(android.content.Context r7) {
        /*
            Method dump skipped, instructions count: 235
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tendinsv.utils.g.i(android.content.Context):java.lang.String");
    }

    private static int j(Context context) {
        int i;
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            Method declaredMethod = Class.forName("android.telephony.TelephonyManager").getDeclaredMethod("getNetworkType", new Class[0]);
            declaredMethod.setAccessible(true);
            i = ((Integer) declaredMethod.invoke(telephonyManager, new Object[0])).intValue();
        } catch (Throwable th) {
            l.d(com.tencent.tendinsv.b.F, "getNetworkType2 Exception_e", th);
            i = -1;
        }
        l.a(com.tencent.tendinsv.b.L, "net type ", Integer.valueOf(i));
        return i;
    }

    private static boolean k(Context context) {
        boolean z;
        try {
        } catch (Throwable th) {
            l.d(com.tencent.tendinsv.b.L, "isAirplaneMode Exception_e", th);
        }
        if (Settings.System.getInt(context.getContentResolver(), "airplane_mode_on", 0) != 1) {
            z = false;
            l.a(com.tencent.tendinsv.b.L, "airplane mode  ", Boolean.valueOf(z));
            return z;
        }
        z = true;
        l.a(com.tencent.tendinsv.b.L, "airplane mode  ", Boolean.valueOf(z));
        return z;
    }

    private static boolean l(Context context) {
        try {
            g(context);
        } catch (Throwable th) {
            l.d(com.tencent.tendinsv.b.L, "isSimStateReady Exception_e", th);
        }
        l.a(com.tencent.tendinsv.b.L, "sim card  ready", true);
        return true;
    }
}
