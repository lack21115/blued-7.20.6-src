package com.cmic.gen.sdk.tencent.e;

import android.text.TextUtils;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

/* loaded from: source-7206380-dex2jar.jar:com/cmic/gen/sdk/tencent/e/p.class */
public class p {
    public static String[] a(boolean z) {
        String[] strArr = {"", ""};
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface nextElement = networkInterfaces.nextElement();
                if (!z || !nextElement.getName().toLowerCase().contains("wlan")) {
                    Enumeration<InetAddress> inetAddresses = nextElement.getInetAddresses();
                    while (inetAddresses.hasMoreElements()) {
                        InetAddress nextElement2 = inetAddresses.nextElement();
                        if (!nextElement2.isLoopbackAddress() && !nextElement2.isLinkLocalAddress()) {
                            String hostAddress = nextElement2.getHostAddress();
                            if (!TextUtils.isEmpty(hostAddress)) {
                                if (nextElement2 instanceof Inet6Address) {
                                    sb.append(hostAddress);
                                    sb.append(",");
                                } else if (nextElement2 instanceof Inet4Address) {
                                    sb2.append(hostAddress);
                                    sb2.append(",");
                                }
                            }
                        }
                    }
                }
            }
            StringBuilder sb3 = sb;
            if (!TextUtils.isEmpty(sb)) {
                sb3 = sb.delete(sb.length() - 1, sb.length());
            }
            StringBuilder sb4 = sb2;
            if (!TextUtils.isEmpty(sb2)) {
                sb4 = sb2.delete(sb2.length() - 1, sb2.length());
            }
            strArr[0] = sb4.toString();
            strArr[1] = sb3.toString();
            c.b("UmcIPUtils", "onlyMobileDataIp " + z + " IPV6 ip：" + sb3.toString());
            c.b("UmcIPUtils", "onlyMobileDataIp " + z + " IPV4 ip：" + sb4.toString());
            return strArr;
        } catch (Exception e) {
            e.printStackTrace();
            return strArr;
        }
    }
}
