package com.getui.gtc.dim.c;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.location.Location;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiEnterpriseConfig;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import com.anythink.expressad.video.module.a.a.m;
import com.getui.gtc.base.util.CommonUtil;
import com.igexin.assist.util.AssistUtils;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/dim/c/a.class */
public final class a {

    /* renamed from: c  reason: collision with root package name */
    private static final Map<String, String> f8337c = new HashMap<String, String>() { // from class: com.getui.gtc.dim.c.a.1
        {
            put(AssistUtils.BRAND_HW, "ro.build.version.emui");
            put(AssistUtils.BRAND_XIAOMI, "ro.build.version.incremental");
            put("redmi", "ro.build.version.incremental");
            put("blackshark", "ro.build.version.incremental");
            put("samsang", "ro.build.version.incremental");
            put(AssistUtils.BRAND_VIVO, "ro.vivo.os.version");
            put(AssistUtils.BRAND_OPPO, "ro.build.version.opporom");
            put(AssistUtils.BRAND_MZ, "ro.build.display.id");
            put("lenovo", "ro.build.version.incremental");
            put("smartisan", "ro.modversion");
            put("htc", "ro.build.sense.version");
            put("oneplus", "ro.rom.version");
            put("yunos", "ro.cta.yunos.version");
            put("360", "ro.build.uiversion");
            put("nubia", "ro.build.rom.internal.id");
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public static final Map<String, String> f8336a = new HashMap();
    private static final Map<String, String> d = new HashMap<String, String>() { // from class: com.getui.gtc.dim.c.a.2
        {
            put(AssistUtils.BRAND_HW, "com.android.permission.GET_INSTALLED_APP");
            put(AssistUtils.BRAND_HON, "com.android.permission.GET_INSTALLED_APPS");
        }
    };
    public static final Map<String, String> b = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.getui.gtc.dim.c.a$a  reason: collision with other inner class name */
    /* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/dim/c/a$a.class */
    public final class ServiceConnectionC0175a implements ServiceConnection {

        /* renamed from: a  reason: collision with root package name */
        boolean f8338a = false;
        final LinkedBlockingQueue<IBinder> b = new LinkedBlockingQueue<>(1);

        ServiceConnectionC0175a() {
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.b.put(iBinder);
            } catch (Throwable th) {
                com.getui.gtc.dim.e.b.a(th);
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/dim/c/a$b.class */
    public final class b implements IInterface {

        /* renamed from: a  reason: collision with root package name */
        private IBinder f8339a;

        public b(IBinder iBinder) {
            this.f8339a = iBinder;
        }

        public final String a() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    this.f8339a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } catch (Exception e) {
                    com.getui.gtc.dim.e.b.a(e);
                    obtain2.recycle();
                    obtain.recycle();
                    return null;
                }
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this.f8339a;
        }
    }

    public static Location a(Context context, String str) {
        try {
            com.getui.gtc.dim.e.c.a(context, "network".equals(str) ? "android.permission.ACCESS_COARSE_LOCATION" : "android.permission.ACCESS_FINE_LOCATION", true);
            return ((LocationManager) context.getSystemService("location")).getLastKnownLocation(str);
        } catch (Throwable th) {
            com.getui.gtc.dim.e.b.a(th);
            return null;
        }
    }

    public static String a() {
        Process process;
        BufferedReader bufferedReader;
        try {
            StringBuilder sb = new StringBuilder();
            process = com.getui.gtc.dim.e.c.a(new String(Base64.decode("aXAgYWRkcg==", 0)));
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        } else if (Pattern.matches("^\\d+: ((wlan\\d+)|(eth\\d+)): .*", readLine)) {
                            String substring = readLine.substring(readLine.indexOf(": ") + 2);
                            sb.append(sb.length() == 0 ? "" : ",");
                            sb.append(substring.substring(0, substring.indexOf(": ")));
                            sb.append("#");
                            String readLine2 = bufferedReader.readLine();
                            if (readLine2 != null) {
                                sb.append(readLine2.substring(readLine2.indexOf("link/ether ") + 11, readLine2.indexOf(" brd")));
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        try {
                            com.getui.gtc.dim.e.b.a(th);
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (Throwable th2) {
                                }
                            }
                            if (process != null) {
                                try {
                                    process.destroy();
                                    return "";
                                } catch (Throwable th3) {
                                    return "";
                                }
                            }
                            return "";
                        } catch (Throwable th4) {
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (Throwable th5) {
                                }
                            }
                            if (process != null) {
                                try {
                                    process.destroy();
                                } catch (Throwable th6) {
                                }
                            }
                            throw th4;
                        }
                    }
                }
                String sb2 = sb.toString();
                try {
                    bufferedReader.close();
                } catch (Throwable th7) {
                }
                if (process != null) {
                    try {
                        process.destroy();
                    } catch (Throwable th8) {
                        return sb2;
                    }
                }
                return sb2;
            } catch (Throwable th9) {
                th = th9;
                bufferedReader = null;
            }
        } catch (Throwable th10) {
            th = th10;
            process = null;
            bufferedReader = null;
        }
    }

    public static String a(int i, Context context) {
        String deviceId;
        try {
            if (Build.VERSION.SDK_INT < 29) {
                if (AssistUtils.BRAND_VIVO.equalsIgnoreCase(b()) && Build.VERSION.SDK_INT < 26) {
                    throw new RuntimeException("do not get imei from vivo below 29");
                }
                if (Build.VERSION.SDK_INT >= 23) {
                    com.getui.gtc.dim.e.c.a(context, "android.permission.READ_PHONE_STATE", true);
                    TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                    return (telephonyManager == null || i < 0 || (deviceId = telephonyManager.getDeviceId(i)) == null) ? "" : deviceId;
                }
                return "";
            }
            throw new RuntimeException("can not get imei above 29");
        } catch (Throwable th) {
            com.getui.gtc.dim.e.b.a(th);
            return "";
        }
    }

    public static String a(Context context) {
        try {
            if (Build.VERSION.SDK_INT < 29) {
                com.getui.gtc.dim.e.c.a(context, "android.permission.READ_PHONE_STATE", true);
                String deviceId = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
                return !TextUtils.isEmpty(deviceId) ? deviceId : "";
            }
            throw new RuntimeException("can not get imei above 29");
        } catch (Throwable th) {
            com.getui.gtc.dim.e.b.a(th);
            return "";
        }
    }

    public static String b() {
        try {
            return Build.BRAND;
        } catch (Throwable th) {
            com.getui.gtc.dim.e.b.a(th);
            return "";
        }
    }

    public static String b(int i, Context context) {
        try {
            if (Build.VERSION.SDK_INT < 29) {
                com.getui.gtc.dim.e.c.a(context, "android.permission.READ_PHONE_STATE", true);
                Object a2 = com.getui.gtc.dim.e.c.a(i, "getSubscriberId", context);
                return a2 != null ? (String) a2 : "";
            }
            throw new RuntimeException("can not get imsi above 29");
        } catch (Throwable th) {
            com.getui.gtc.dim.e.b.a(th);
            return "";
        }
    }

    public static String b(Context context) {
        try {
            if (Build.VERSION.SDK_INT < 29) {
                com.getui.gtc.dim.e.c.a(context, "android.permission.READ_PHONE_STATE", true);
                String subscriberId = ((TelephonyManager) context.getSystemService("phone")).getSubscriberId();
                return !TextUtils.isEmpty(subscriberId) ? subscriberId : "";
            }
            throw new RuntimeException("can not get imsi above 29");
        } catch (Throwable th) {
            com.getui.gtc.dim.e.b.a(th);
            return "";
        }
    }

    public static String b(Context context, String str) {
        try {
            com.getui.gtc.dim.e.c.a(context, "android.permission.ACCESS_WIFI_STATE", true);
            if (com.getui.gtc.dim.e.c.c(context)) {
                int i = ((WifiManager) context.getApplicationContext().getSystemService("wifi")).getDhcpInfo().gateway;
                String b2 = com.getui.gtc.dim.e.c.b((i & 255) + "." + ((i >> 8) & 255) + "." + ((i >> 16) & 255) + "." + ((i >> 24) & 255));
                String replace = str.replace("\"", "");
                return "1#" + replace + "#" + b2;
            }
            return "2##";
        } catch (Throwable th) {
            com.getui.gtc.dim.e.b.a(th);
            return "";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00a9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int c(int r9, android.content.Context r10) {
        /*
            Method dump skipped, instructions count: 223
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.getui.gtc.dim.c.a.c(int, android.content.Context):int");
    }

    public static String c() {
        try {
            return Build.MODEL;
        } catch (Throwable th) {
            com.getui.gtc.dim.e.b.a(th);
            return "";
        }
    }

    public static String c(Context context) {
        String str;
        String str2;
        try {
            com.getui.gtc.dim.e.c.a(context, "android.permission.READ_PHONE_STATE", true);
            str = ((TelephonyManager) context.getSystemService("phone")).getSimSerialNumber();
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            str2 = str;
            try {
                if (!TextUtils.isEmpty(str)) {
                    str2 = str;
                    if (str.length() < 20) {
                        return "";
                    }
                }
            } catch (Throwable th) {
                th = th;
                com.getui.gtc.dim.e.b.a(th);
                str2 = str;
                return str2;
            }
        } catch (Throwable th2) {
            th = th2;
            str = "";
        }
        return str2;
    }

    public static String d() {
        try {
            String b2 = b();
            if (!TextUtils.isEmpty(b2)) {
                String lowerCase = b2.toLowerCase();
                if (f8336a.containsKey(lowerCase)) {
                    return com.getui.gtc.dim.e.c.a(f8336a.get(lowerCase), "");
                }
                if (f8337c.containsKey(lowerCase)) {
                    return com.getui.gtc.dim.e.c.a(f8337c.get(lowerCase), "");
                }
            }
            String e = e();
            if (TextUtils.isEmpty(e)) {
                return "";
            }
            String lowerCase2 = e.toLowerCase();
            return f8336a.containsKey(lowerCase2) ? com.getui.gtc.dim.e.c.a(f8336a.get(lowerCase2), "") : f8337c.containsKey(lowerCase2) ? com.getui.gtc.dim.e.c.a(f8337c.get(lowerCase2), "") : "";
        } catch (Throwable th) {
            com.getui.gtc.dim.e.b.a(th);
            return "";
        }
    }

    public static String d(int i, Context context) {
        String str;
        try {
            com.getui.gtc.dim.e.c.a(context, "android.permission.READ_PHONE_STATE", true);
            Object a2 = com.getui.gtc.dim.e.c.a(i, "getSimSerialNumber", context);
            str = a2 != null ? (String) a2 : "";
        } catch (Throwable th) {
            th = th;
            str = "";
        }
        try {
            if (!TextUtils.isEmpty(str)) {
                if (str.length() < 20) {
                    return "";
                }
            }
            return str;
        } catch (Throwable th2) {
            th = th2;
            com.getui.gtc.dim.e.b.a(th);
            return str;
        }
    }

    public static String d(Context context) {
        try {
            return Settings.Secure.getString(context.getContentResolver(), "android_id");
        } catch (Throwable th) {
            com.getui.gtc.dim.e.b.a(th);
            return "";
        }
    }

    public static String e() {
        try {
            return Build.MANUFACTURER;
        } catch (Throwable th) {
            com.getui.gtc.dim.e.b.a(th);
            return "";
        }
    }

    public static String e(Context context) {
        try {
            if (CommonUtil.isMainThread()) {
                throw new RuntimeException("cannot get advertisingId from main thread");
            }
            Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
            intent.setPackage("com.google.android.gms");
            ServiceConnectionC0175a serviceConnectionC0175a = new ServiceConnectionC0175a();
            if (context.bindService(intent, serviceConnectionC0175a, 1)) {
                try {
                    if (serviceConnectionC0175a.f8338a) {
                        throw new IllegalStateException();
                    }
                    serviceConnectionC0175a.f8338a = true;
                    String a2 = new b(serviceConnectionC0175a.b.poll(m.ag, TimeUnit.MILLISECONDS)).a();
                    context.unbindService(serviceConnectionC0175a);
                    return a2;
                } catch (Exception e) {
                    throw e;
                }
            }
            throw new IOException("Google Play connection failed");
        } catch (Throwable th) {
            com.getui.gtc.dim.e.b.a(th);
            return "";
        }
    }

    public static String f() {
        try {
            return Build.VERSION.RELEASE;
        } catch (Throwable th) {
            com.getui.gtc.dim.e.b.a(th);
            return "";
        }
    }

    public static String f(Context context) {
        Object invoke;
        try {
            com.getui.gtc.dim.e.c.a(context, "android.permission.READ_PHONE_STATE", true);
            if (Build.VERSION.SDK_INT < 26) {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                invoke = cls.getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class).invoke(cls, "ro.serialno");
            } else if (Build.VERSION.SDK_INT >= 29) {
                throw new RuntimeException("can not get serialnumber above 29");
            } else {
                Class<?> cls2 = Class.forName("android.os.Build");
                invoke = cls2.getMethod("getSerial", new Class[0]).invoke(cls2, new Object[0]);
            }
            return (String) invoke;
        } catch (Throwable th) {
            com.getui.gtc.dim.e.b.a(th);
            return null;
        }
    }

    public static String g(Context context) {
        try {
            if (Looper.myLooper() != Looper.getMainLooper()) {
                d.a();
                d.a(context);
                if (d.f8341a) {
                    return d.b();
                }
                return null;
            }
            throw new RuntimeException("can not get oaid at main thread");
        } catch (Throwable th) {
            com.getui.gtc.dim.e.b.a(th);
            return "";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:70:0x0077 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0082 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x00af -> B:28:0x0086). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.List<android.content.pm.PackageInfo> g() {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L66
            r1 = r0
            r1.<init>()     // Catch: java.lang.Throwable -> L66
            r8 = r0
            java.lang.String r0 = new java.lang.String     // Catch: java.lang.Throwable -> L66
            r1 = r0
            java.lang.String r2 = "cG0gbGlzdCBwYWNrYWdlcw=="
            r3 = 0
            byte[] r2 = android.util.Base64.decode(r2, r3)     // Catch: java.lang.Throwable -> L66
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L66
            java.lang.Process r0 = com.getui.gtc.dim.e.c.a(r0)     // Catch: java.lang.Throwable -> L66
            r6 = r0
            java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L62 java.lang.Throwable -> L66
            r1 = r0
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L62
            r3 = r2
            r4 = r6
            java.io.InputStream r4 = r4.getInputStream()     // Catch: java.lang.Throwable -> L62
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L62
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L62
            r7 = r0
        L2d:
            r0 = r7
            java.lang.String r0 = r0.readLine()     // Catch: java.lang.Throwable -> L5e
            r9 = r0
            r0 = r9
            if (r0 == 0) goto L4d
            r0 = r8
            r1 = r9
            java.lang.String r2 = ":"
            java.lang.String[] r1 = r1.split(r2)     // Catch: java.lang.Throwable -> La0
            r2 = 1
            r1 = r1[r2]     // Catch: java.lang.Throwable -> La0
            r2 = 0
            android.content.pm.PackageInfo r1 = com.getui.gtc.dim.e.d.a(r1, r2)     // Catch: java.lang.Throwable -> La0
            boolean r0 = r0.add(r1)     // Catch: java.lang.Throwable -> La0
            goto L2d
        L4d:
            r0 = r7
            r0.close()     // Catch: java.lang.Throwable -> La4
            goto L54
        L54:
            r0 = r6
            if (r0 == 0) goto L5c
            r0 = r6
            r0.destroy()     // Catch: java.lang.Throwable -> La8
        L5c:
            r0 = r8
            return r0
        L5e:
            r8 = move-exception
            goto L6f
        L62:
            r7 = move-exception
            goto L69
        L66:
            r7 = move-exception
            r0 = 0
            r6 = r0
        L69:
            r0 = 0
            r9 = r0
            r0 = r7
            r8 = r0
            r0 = r9
            r7 = r0
        L6f:
            r0 = r8
            com.getui.gtc.dim.e.b.a(r0)     // Catch: java.lang.Throwable -> L8a
            r0 = r7
            if (r0 == 0) goto L7e
            r0 = r7
            r0.close()     // Catch: java.lang.Throwable -> Lab
            goto L7e
        L7e:
            r0 = r6
            if (r0 == 0) goto L86
            r0 = r6
            r0.destroy()     // Catch: java.lang.Throwable -> Laf
        L86:
            java.util.List r0 = java.util.Collections.emptyList()     // Catch: java.lang.Throwable -> Laf
            return r0
        L8a:
            r8 = move-exception
            r0 = r7
            if (r0 == 0) goto L96
            r0 = r7
            r0.close()     // Catch: java.lang.Throwable -> Lb3
            goto L96
        L96:
            r0 = r6
            if (r0 == 0) goto L9e
            r0 = r6
            r0.destroy()     // Catch: java.lang.Throwable -> Lb7
        L9e:
            r0 = r8
            throw r0
        La0:
            r9 = move-exception
            goto L2d
        La4:
            r7 = move-exception
            goto L54
        La8:
            r6 = move-exception
            r0 = r8
            return r0
        Lab:
            r7 = move-exception
            goto L7e
        Laf:
            r6 = move-exception
            goto L86
        Lb3:
            r7 = move-exception
            goto L96
        Lb7:
            r6 = move-exception
            goto L9e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.getui.gtc.dim.c.a.g():java.util.List");
    }

    @Deprecated
    public static String h() {
        return "";
    }

    public static String h(Context context) {
        String str;
        try {
        } catch (Throwable th) {
            com.getui.gtc.dim.e.b.a(th);
            str = "";
        }
        if (Build.VERSION.SDK_INT < 23) {
            com.getui.gtc.dim.e.c.a(context, "android.permission.ACCESS_WIFI_STATE", true);
            return ((WifiManager) context.getApplicationContext().getSystemService("wifi")).getConnectionInfo().getMacAddress();
        }
        Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
        String str2 = "";
        while (true) {
            str = str2;
            if (!networkInterfaces.hasMoreElements()) {
                break;
            }
            String str3 = str2;
            NetworkInterface nextElement = networkInterfaces.nextElement();
            String str4 = str2;
            if ("wlan0".equalsIgnoreCase(nextElement.getName())) {
                String str5 = str2;
                byte[] hardwareAddress = nextElement.getHardwareAddress();
                if (hardwareAddress != null && hardwareAddress.length != 0) {
                    String str6 = str2;
                    StringBuilder sb = new StringBuilder();
                    String str7 = str2;
                    int length = hardwareAddress.length;
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= length) {
                            break;
                        }
                        sb.append(String.format("%02X:", Byte.valueOf(hardwareAddress[i2])));
                        i = i2 + 1;
                    }
                    if (sb.length() > 0) {
                        String str8 = str2;
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    String str9 = str2;
                    str2 = sb.toString();
                }
            }
        }
        return str;
    }

    public static String i(Context context) {
        try {
            String simOperator = ((TelephonyManager) context.getSystemService("phone")).getSimOperator();
            if (TextUtils.isEmpty(simOperator)) {
                return "";
            }
            boolean z = true;
            int hashCode = simOperator.hashCode();
            if (hashCode != 49679479) {
                if (hashCode != 49679502) {
                    switch (hashCode) {
                        case 49679470:
                            if (simOperator.equals("46000")) {
                                z = false;
                                break;
                            }
                            break;
                        case 49679471:
                            if (simOperator.equals("46001")) {
                                z = true;
                                break;
                            }
                            break;
                        case 49679472:
                            if (simOperator.equals("46002")) {
                                z = true;
                                break;
                            }
                            break;
                        case 49679473:
                            if (simOperator.equals("46003")) {
                                z = true;
                                break;
                            }
                            break;
                        case 49679474:
                            if (simOperator.equals("46004")) {
                                z = true;
                                break;
                            }
                            break;
                        case 49679475:
                            if (simOperator.equals("46005")) {
                                z = true;
                                break;
                            }
                            break;
                        case 49679476:
                            if (simOperator.equals("46006")) {
                                z = true;
                                break;
                            }
                            break;
                        case 49679477:
                            if (simOperator.equals("46007")) {
                                z = true;
                                break;
                            }
                            break;
                    }
                } else if (simOperator.equals("46011")) {
                    z = true;
                }
            } else if (simOperator.equals("46009")) {
                z = true;
            }
            switch (z) {
                case false:
                case true:
                case true:
                case true:
                    return "中国移动";
                case true:
                case true:
                case true:
                    return "中国联通";
                case true:
                case true:
                case true:
                    return "中国电信";
                default:
                    return simOperator;
            }
        } catch (Throwable th) {
            com.getui.gtc.dim.e.b.a(th);
            return "";
        }
    }

    public static String j(Context context) {
        try {
            com.getui.gtc.dim.e.c.a(context, "android.permission.ACCESS_NETWORK_STATE", true);
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            if (connectivityManager != null) {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo != null) {
                    if (activeNetworkInfo.isAvailable()) {
                        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
                        if (networkInfo == null || !networkInfo.isConnectedOrConnecting()) {
                            int subtype = activeNetworkInfo.getSubtype();
                            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                            if (telephonyManager != null) {
                                subtype = telephonyManager.getNetworkType();
                            }
                            if (subtype != 20) {
                                switch (subtype) {
                                    case 1:
                                    case 2:
                                    case 4:
                                    case 7:
                                    case 11:
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
                                        return "3G";
                                    case 13:
                                        return "4G";
                                    default:
                                        return WifiEnterpriseConfig.EMPTY_VALUE;
                                }
                            }
                            return "5G";
                        }
                        return "WIFI";
                    }
                    throw new IllegalStateException("no available activeNetwork");
                }
                throw new IllegalStateException("getActiveNetworkInfo failed");
            }
            throw new IllegalStateException("getSystemService: CONNECTIVITY_SERVICE failed");
        } catch (Throwable th) {
            com.getui.gtc.dim.e.b.a(th);
            return WifiEnterpriseConfig.EMPTY_VALUE;
        }
    }

    public static String k(Context context) {
        try {
            if (com.getui.gtc.dim.e.c.a(context)) {
                boolean b2 = com.getui.gtc.dim.e.c.b(context);
                boolean c2 = com.getui.gtc.dim.e.c.c(context);
                ArrayList<String> arrayList = new ArrayList();
                ArrayList<String> arrayList2 = new ArrayList();
                Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
                while (networkInterfaces.hasMoreElements()) {
                    NetworkInterface nextElement = networkInterfaces.nextElement();
                    if ((b2 && nextElement.getName().toLowerCase().contains("rmnet")) || (c2 && nextElement.getName().toLowerCase().contains("wlan0"))) {
                        List<InterfaceAddress> interfaceAddresses = nextElement.getInterfaceAddresses();
                        ArrayList arrayList3 = new ArrayList();
                        for (InterfaceAddress interfaceAddress : interfaceAddresses) {
                            InetAddress address = interfaceAddress.getAddress();
                            if (!address.isLoopbackAddress()) {
                                arrayList3.add(address.getHostAddress());
                            }
                        }
                        if (b2) {
                            arrayList.addAll(arrayList3);
                        }
                        if (c2) {
                            arrayList2.addAll(arrayList3);
                        }
                    }
                }
                if (b2) {
                    StringBuilder sb = new StringBuilder();
                    for (String str : arrayList) {
                        sb.append(str);
                        sb.append(",");
                    }
                    if (sb.toString().endsWith(",")) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    return sb.toString();
                } else if (c2) {
                    StringBuilder sb2 = new StringBuilder();
                    for (String str2 : arrayList2) {
                        sb2.append(str2);
                        sb2.append(",");
                    }
                    if (sb2.toString().endsWith(",")) {
                        sb2.deleteCharAt(sb2.length() - 1);
                    }
                    return sb2.toString();
                } else {
                    return "";
                }
            }
            throw new IllegalStateException("network not connected");
        } catch (Throwable th) {
            com.getui.gtc.dim.e.b.a(th);
            return "";
        }
    }

    public static String l(Context context) {
        try {
            if (com.getui.gtc.dim.e.c.a(context)) {
                boolean b2 = com.getui.gtc.dim.e.c.b(context);
                boolean c2 = com.getui.gtc.dim.e.c.c(context);
                ArrayList<String> arrayList = new ArrayList();
                ArrayList<String> arrayList2 = new ArrayList();
                Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
                while (networkInterfaces.hasMoreElements()) {
                    NetworkInterface nextElement = networkInterfaces.nextElement();
                    String lowerCase = nextElement.getName().toLowerCase();
                    if ((b2 && (lowerCase.contains("rmnet") || lowerCase.contains("ccmni"))) || (c2 && lowerCase.contains("wlan0"))) {
                        List<InterfaceAddress> interfaceAddresses = nextElement.getInterfaceAddresses();
                        ArrayList arrayList3 = new ArrayList();
                        boolean z = false;
                        for (InterfaceAddress interfaceAddress : interfaceAddresses) {
                            InetAddress address = interfaceAddress.getAddress();
                            if (!address.isLoopbackAddress()) {
                                if (address instanceof Inet6Address) {
                                    arrayList3.add(address.getHostAddress());
                                } else if (address instanceof Inet4Address) {
                                    z = true;
                                }
                            }
                        }
                        if (z) {
                            if (b2) {
                                arrayList.addAll(arrayList3);
                            }
                            if (c2) {
                                arrayList2.addAll(arrayList3);
                            }
                        }
                    }
                }
                if (b2) {
                    StringBuilder sb = new StringBuilder();
                    for (String str : arrayList) {
                        sb.append(str);
                        sb.append(",");
                    }
                    if (sb.toString().endsWith(",")) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    return sb.toString();
                } else if (c2) {
                    StringBuilder sb2 = new StringBuilder();
                    for (String str2 : arrayList2) {
                        sb2.append(str2);
                        sb2.append(",");
                    }
                    if (sb2.toString().endsWith(",")) {
                        sb2.deleteCharAt(sb2.length() - 1);
                    }
                    return sb2.toString();
                } else {
                    return "";
                }
            }
            throw new IllegalStateException("network not connected");
        } catch (Throwable th) {
            com.getui.gtc.dim.e.b.a(th);
            return "";
        }
    }

    public static WifiInfo m(Context context) {
        try {
            com.getui.gtc.dim.e.c.a(context, "android.permission.ACCESS_WIFI_STATE", true);
            return ((WifiManager) context.getApplicationContext().getSystemService("wifi")).getConnectionInfo();
        } catch (Throwable th) {
            com.getui.gtc.dim.e.b.a(th);
            return null;
        }
    }

    public static List<ScanResult> n(Context context) {
        try {
            if (CommonUtil.isMainThread()) {
                throw new IllegalStateException("cannot get wifi list from the main thread");
            }
            com.getui.gtc.dim.e.c.a(context, "android.permission.ACCESS_FINE_LOCATION", true);
            List<ScanResult> scanResults = ((WifiManager) context.getApplicationContext().getSystemService("wifi")).getScanResults();
            if (scanResults == null || scanResults.size() <= 0) {
                return null;
            }
            return scanResults;
        } catch (Throwable th) {
            com.getui.gtc.dim.e.b.a(th);
            return null;
        }
    }

    /* JADX WARN: Not initialized variable reg: 9, insn: 0x00af: MOVE  (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r9 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:30:0x00af */
    /* JADX WARN: Removed duplicated region for block: B:49:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0113 A[Catch: all -> 0x01bf, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x01bf, blocks: (B:2:0x0000, B:5:0x000a, B:14:0x0035, B:17:0x0050, B:19:0x005a, B:21:0x0062, B:47:0x0105, B:52:0x0132, B:56:0x0183, B:58:0x018d, B:60:0x01ac, B:61:0x01b7, B:51:0x0113, B:45:0x00ff, B:6:0x0014, B:8:0x001d, B:11:0x0029, B:12:0x0033), top: B:70:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String o(android.content.Context r4) {
        /*
            Method dump skipped, instructions count: 478
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.getui.gtc.dim.c.a.o(android.content.Context):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:74:0x0277 A[Catch: all -> 0x02de, TryCatch #3 {all -> 0x02de, blocks: (B:3:0x0005, B:5:0x000d, B:11:0x0028, B:14:0x0039, B:16:0x0046, B:18:0x004f, B:22:0x005c, B:24:0x0077, B:26:0x0081, B:28:0x0095, B:30:0x009d, B:72:0x026f, B:74:0x0277, B:76:0x0281, B:31:0x00be, B:33:0x00c6, B:34:0x00e3, B:36:0x00eb, B:38:0x00f3, B:39:0x0114, B:41:0x011c, B:42:0x013d, B:71:0x0268, B:77:0x02ba, B:79:0x02c2, B:81:0x02c8, B:81:0x02c8, B:82:0x02cb, B:83:0x02d2, B:84:0x02d3, B:84:0x02d3, B:85:0x02d6, B:86:0x02dd), top: B:107:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String p(android.content.Context r4) {
        /*
            Method dump skipped, instructions count: 791
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.getui.gtc.dim.c.a.p(android.content.Context):java.lang.String");
    }

    public static List<PackageInfo> q(Context context) {
        try {
            ArrayList arrayList = new ArrayList();
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_LAUNCHER);
            List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
            if (queryIntentActivities.size() > 0) {
                for (ResolveInfo resolveInfo : queryIntentActivities) {
                    try {
                        arrayList.add(com.getui.gtc.dim.e.d.a(resolveInfo.activityInfo.packageName, 0));
                    } catch (Throwable th) {
                    }
                }
            }
            return arrayList;
        } catch (Throwable th2) {
            com.getui.gtc.dim.e.b.a(th2);
            return Collections.emptyList();
        }
    }

    public static List<PackageInfo> r(Context context) {
        String str;
        try {
            String lowerCase = b().toLowerCase();
            if (b.containsKey(lowerCase)) {
                str = b.get(lowerCase);
            } else if (!d.containsKey(lowerCase)) {
                throw new RuntimeException("not support brand: ".concat(String.valueOf(lowerCase)));
            } else {
                str = d.get(lowerCase);
            }
            com.getui.gtc.dim.e.c.a(context, str, false);
            PackageManager packageManager = context.getPackageManager();
            return (List) packageManager.getClass().getDeclaredMethod(new String(Base64.decode("Z2V0SW5zdGFsbGVkUGFja2FnZXM=", 0)), Integer.TYPE).invoke(packageManager, 5);
        } catch (Throwable th) {
            com.getui.gtc.dim.e.b.a(th);
            return Collections.emptyList();
        }
    }

    public static List<PackageInfo> s(Context context) {
        String[] list;
        try {
            File externalCacheDir = context.getExternalCacheDir();
            File file = null;
            if (externalCacheDir != null) {
                File parentFile = externalCacheDir.getParentFile();
                file = null;
                if (parentFile != null) {
                    file = parentFile.getParentFile();
                }
            }
            if (file != null && file.isDirectory() && (list = file.list(new FilenameFilter() { // from class: com.getui.gtc.dim.c.a.3
                @Override // java.io.FilenameFilter
                public final boolean accept(File file2, String str) {
                    try {
                        if (file2.isDirectory()) {
                            return str.contains(".");
                        }
                        return false;
                    } catch (Throwable th) {
                        return false;
                    }
                }
            })) != null) {
                ArrayList arrayList = new ArrayList();
                int length = list.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= length) {
                        return arrayList;
                    }
                    try {
                        arrayList.add(com.getui.gtc.dim.e.d.a(list[i2], 0));
                    } catch (Throwable th) {
                    }
                    i = i2 + 1;
                }
            }
        } catch (Throwable th2) {
            com.getui.gtc.dim.e.b.a(th2);
        }
        return Collections.emptyList();
    }
}
