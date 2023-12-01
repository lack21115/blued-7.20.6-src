package com.igexin.push.f;

import android.content.Context;
import android.net.DhcpInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.CellIdentityCdma;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoWcdma;
import android.telephony.TelephonyManager;
import com.getui.gtc.base.util.CommonUtil;
import com.igexin.push.core.b.v;
import java.lang.reflect.Method;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/push/f/q.class */
public final class q {

    /* renamed from: a  reason: collision with root package name */
    private static final String f10058a = "Task145PhoneDataUtils";

    private static int a() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface nextElement = networkInterfaces.nextElement();
                if ("wlan0".equalsIgnoreCase(nextElement.getName())) {
                    for (InterfaceAddress interfaceAddress : nextElement.getInterfaceAddresses()) {
                        InetAddress address = interfaceAddress.getAddress();
                        short networkPrefixLength = interfaceAddress.getNetworkPrefixLength();
                        if (!address.isLoopbackAddress() && (address instanceof Inet4Address)) {
                            com.igexin.c.a.c.a.b(f10058a, "IPv4 maskLength: ".concat(String.valueOf((int) networkPrefixLength)));
                            if (networkPrefixLength > 0) {
                                return networkPrefixLength;
                            }
                            return 24;
                        }
                    }
                    continue;
                }
            }
            return 24;
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return 24;
        }
    }

    private static String a(int i) {
        return (i & 255) + "." + ((i >> 8) & 255) + "." + ((i >> 16) & 255) + "." + ((i >> 24) & 255);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0028, code lost:
        if ("0.0.0.0".equalsIgnoreCase(r0) != false) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0050, code lost:
        r0 = r0.replace("wlan0/ipv4=", "");
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x005b, code lost:
        r7 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0063, code lost:
        if (r0.contains("/") == false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0066, code lost:
        r7 = r0.split("/")[0];
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0071, code lost:
        r4 = r7;
        r7 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0074, code lost:
        com.igexin.c.a.c.a.b(com.igexin.push.f.q.f10058a, "new get self iv4 by sl, ip = ".concat(java.lang.String.valueOf(r4)));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(android.content.Context r4) {
        /*
            java.lang.String r0 = ""
            r7 = r0
            r0 = r4
            com.igexin.push.core.b.v r0 = c(r0)     // Catch: java.lang.Throwable -> L93
            java.lang.String r0 = r0.b     // Catch: java.lang.Throwable -> L93
            r4 = r0
            java.lang.String r0 = "Task145PhoneDataUtils"
            java.lang.String r1 = "new get self iv4 by dhcp, ip = "
            r2 = r4
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch: java.lang.Throwable -> L8c
            java.lang.String r1 = r1.concat(r2)     // Catch: java.lang.Throwable -> L8c
            com.igexin.c.a.c.a.b(r0, r1)     // Catch: java.lang.Throwable -> L8c
            r0 = r4
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L8c
            if (r0 != 0) goto L2b
            r0 = r4
            r7 = r0
            java.lang.String r0 = "0.0.0.0"
            r1 = r4
            boolean r0 = r0.equalsIgnoreCase(r1)     // Catch: java.lang.Throwable -> L8c
            if (r0 == 0) goto L9e
        L2b:
            java.lang.String r0 = b()     // Catch: java.lang.Throwable -> L8c java.lang.Throwable -> L8c
            java.lang.String r1 = "#"
            java.lang.String[] r0 = r0.split(r1)     // Catch: java.lang.Throwable -> L8c
            r8 = r0
            r0 = r8
            int r0 = r0.length     // Catch: java.lang.Throwable -> L8c
            r6 = r0
            r0 = 0
            r5 = r0
        L3b:
            r0 = r4
            r7 = r0
            r0 = r5
            r1 = r6
            if (r0 >= r1) goto L9e
            r0 = r8
            r1 = r5
            r0 = r0[r1]
            r7 = r0
            r0 = r7
            java.lang.String r1 = "wlan0/ipv4"
            boolean r0 = r0.contains(r1)     // Catch: java.lang.Throwable -> L8c
            if (r0 == 0) goto L85
            r0 = r7
            java.lang.String r1 = "wlan0/ipv4="
            java.lang.String r2 = ""
            java.lang.String r0 = r0.replace(r1, r2)     // Catch: java.lang.Throwable -> L8c
            r8 = r0
            r0 = r4
            r7 = r0
            r0 = r8
            java.lang.String r1 = "/"
            boolean r0 = r0.contains(r1)     // Catch: java.lang.Throwable -> L8c
            if (r0 == 0) goto L70
            r0 = r8
            java.lang.String r1 = "/"
            java.lang.String[] r0 = r0.split(r1)     // Catch: java.lang.Throwable -> L8c
            r1 = 0
            r0 = r0[r1]     // Catch: java.lang.Throwable -> L8c
            r7 = r0
        L70:
            r0 = r7
            r4 = r0
            r0 = r4
            r7 = r0
            java.lang.String r0 = "Task145PhoneDataUtils"
            java.lang.String r1 = "new get self iv4 by sl, ip = "
            r2 = r4
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch: java.lang.Throwable -> L93
            java.lang.String r1 = r1.concat(r2)     // Catch: java.lang.Throwable -> L93
            com.igexin.c.a.c.a.b(r0, r1)     // Catch: java.lang.Throwable -> L93
            goto L9c
        L85:
            r0 = r5
            r1 = 1
            int r0 = r0 + r1
            r5 = r0
            goto L3b
        L8c:
            r8 = move-exception
            r0 = r4
            r7 = r0
            goto L95
        L93:
            r8 = move-exception
        L95:
            r0 = r8
            com.igexin.c.a.c.a.a(r0)
            r0 = r7
            r4 = r0
        L9c:
            r0 = r4
            r7 = r0
        L9e:
            r0 = r7
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.f.q.a(android.content.Context):java.lang.String");
    }

    public static com.igexin.push.core.b.d b(Context context) {
        try {
            if (CommonUtil.hasPermission(context, Build.VERSION.SDK_INT >= 29 && context.getApplicationInfo().targetSdkVersion >= 29 ? "android.permission.ACCESS_FINE_LOCATION" : "android.permission.ACCESS_COARSE_LOCATION", false) && d(context)) {
                return e(context);
            }
        } catch (Throwable th) {
        }
        return new com.igexin.push.core.b.d();
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x0200  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String b() {
        /*
            Method dump skipped, instructions count: 576
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.f.q.b():java.lang.String");
    }

    private static v c(Context context) {
        com.igexin.c.a.c.a.b(f10058a, "SLMA getDhcpWifiInfo.");
        v vVar = new v();
        try {
            CommonUtil.hasPermission(context, "android.permission.ACCESS_WIFI_STATE", false);
            DhcpInfo dhcpInfo = ((WifiManager) context.getSystemService("wifi")).getDhcpInfo();
            vVar.f9856a = a(dhcpInfo.gateway);
            vVar.b = a(dhcpInfo.ipAddress);
            int i = dhcpInfo.netmask;
            vVar.f9857c = a();
            return vVar;
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return vVar;
        }
    }

    private static boolean d(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getSimState() == 5;
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return false;
        }
    }

    private static com.igexin.push.core.b.d e(Context context) {
        if (Build.VERSION.SDK_INT < 17) {
            return new com.igexin.push.core.b.d();
        }
        long j = 0;
        List<CellInfo> allCellInfo = ((TelephonyManager) context.getSystemService("phone")).getAllCellInfo();
        if (allCellInfo == null || allCellInfo.isEmpty()) {
            return new com.igexin.push.core.b.d();
        }
        Iterator<CellInfo> it = allCellInfo.iterator();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            long j2 = j;
            if (!it.hasNext()) {
                com.igexin.push.core.b.d dVar = new com.igexin.push.core.b.d();
                dVar.f9827a = i;
                dVar.b = i2;
                dVar.f9828c = i3;
                dVar.d = j2;
                dVar.e = i4;
                return dVar;
            }
            CellInfo next = it.next();
            j = j2;
            if (next.isRegistered()) {
                if (next instanceof CellInfoGsm) {
                    CellIdentityGsm cellIdentity = ((CellInfoGsm) next).getCellIdentity();
                    i = cellIdentity.getMcc();
                    i2 = cellIdentity.getMnc();
                    i3 = cellIdentity.getLac();
                    j = cellIdentity.getCid();
                    i4 = 1;
                } else if (next instanceof CellInfoCdma) {
                    CellIdentityCdma cellIdentity2 = ((CellInfoCdma) next).getCellIdentity();
                    i2 = cellIdentity2.getSystemId();
                    i3 = cellIdentity2.getNetworkId();
                    j = cellIdentity2.getBasestationId();
                    i4 = 2;
                } else if (next instanceof CellInfoWcdma) {
                    CellIdentityWcdma cellIdentity3 = ((CellInfoWcdma) next).getCellIdentity();
                    i = cellIdentity3.getMcc();
                    i2 = cellIdentity3.getMnc();
                    i3 = cellIdentity3.getLac();
                    j = cellIdentity3.getCid();
                    i4 = 4;
                } else if (next instanceof CellInfoLte) {
                    CellIdentityLte cellIdentity4 = ((CellInfoLte) next).getCellIdentity();
                    i = cellIdentity4.getMcc();
                    i2 = cellIdentity4.getMnc();
                    i3 = cellIdentity4.getTac();
                    j = cellIdentity4.getCi();
                    i4 = 3;
                } else {
                    j = j2;
                    if ("android.telephony.CellInfoNr".equals(next.getClass().getName())) {
                        int i5 = i;
                        int i6 = i2;
                        int i7 = i3;
                        try {
                            Method method = Class.forName("android.telephony.CellInfoNr").getMethod("getCellIdentity", new Class[0]);
                            int i8 = i;
                            Class<?> cls = Class.forName("android.telephony.CellIdentityNr");
                            int i9 = i;
                            Method method2 = cls.getMethod("getMccString", new Class[0]);
                            int i10 = i;
                            Method method3 = cls.getMethod("getMncString", new Class[0]);
                            int i11 = i;
                            Method method4 = cls.getMethod("getTac", new Class[0]);
                            int i12 = i;
                            Method method5 = cls.getMethod("getNci", new Class[0]);
                            int i13 = i;
                            Object invoke = method.invoke(next, new Object[0]);
                            int i14 = i;
                            String str = (String) method2.invoke(invoke, new Object[0]);
                            int i15 = i;
                            String str2 = (String) method3.invoke(invoke, new Object[0]);
                            int i16 = i;
                            i = Integer.parseInt(str);
                            i2 = Integer.parseInt(str2);
                            i3 = ((Integer) method4.invoke(invoke, new Object[0])).intValue();
                            j = ((Long) method5.invoke(invoke, new Object[0])).longValue();
                            i4 = 6;
                        } catch (Throwable th) {
                            com.igexin.c.a.c.a.a(th);
                            j = j2;
                            i = i5;
                            i2 = i6;
                            i3 = i7;
                        }
                    }
                }
            }
        }
    }

    private static boolean f(Context context) {
        return CommonUtil.hasPermission(context, Build.VERSION.SDK_INT >= 29 && context.getApplicationInfo().targetSdkVersion >= 29 ? "android.permission.ACCESS_FINE_LOCATION" : "android.permission.ACCESS_COARSE_LOCATION", false);
    }
}
