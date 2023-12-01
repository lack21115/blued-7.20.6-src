package com.sdk.tencent.b;

import android.content.Context;
import com.sdk.tencent.base.module.manager.SDKManager;
import com.xiaomi.mipush.sdk.Constants;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/* loaded from: source-8303388-dex2jar.jar:com/sdk/tencent/b/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f14328a = "a";
    public static Boolean b = Boolean.valueOf(com.sdk.tencent.f.c.b);

    public static String a(int i, String str) {
        String str2;
        String str3 = com.sdk.tencent.l.a.f14372a;
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            loop0: while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress nextElement = inetAddresses.nextElement();
                    if (!nextElement.isLoopbackAddress() && (nextElement instanceof Inet4Address)) {
                        str2 = nextElement.getHostAddress();
                        break loop0;
                    }
                }
            }
        } catch (SocketException e) {
        }
        str2 = null;
        if (com.sdk.tencent.n.b.b(str2).booleanValue()) {
            return "accessCode" + i + str + str2;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x008e A[Catch: Exception -> 0x00eb, TRY_ENTER, TryCatch #0 {Exception -> 0x00eb, blocks: (B:2:0x0000, B:6:0x0008, B:8:0x0018, B:10:0x0028, B:11:0x0035, B:21:0x008e, B:23:0x0095, B:26:0x00ac, B:27:0x00b3, B:28:0x00b6, B:30:0x00db, B:33:0x00e0, B:18:0x005b, B:12:0x0038), top: B:40:0x0000, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00db A[Catch: Exception -> 0x00eb, Exception -> 0x00eb, TRY_ENTER, TRY_LEAVE, TryCatch #0 {Exception -> 0x00eb, blocks: (B:2:0x0000, B:6:0x0008, B:8:0x0018, B:10:0x0028, B:11:0x0035, B:21:0x008e, B:23:0x0095, B:26:0x00ac, B:27:0x00b3, B:28:0x00b6, B:30:0x00db, B:33:0x00e0, B:18:0x005b, B:12:0x0038), top: B:40:0x0000, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(android.content.Context r5, int r6, java.lang.String r7) {
        /*
            Method dump skipped, instructions count: 243
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sdk.tencent.b.a.a(android.content.Context, int, java.lang.String):java.lang.String");
    }

    public static String a(String str) {
        return str.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER)[0];
    }

    public static void a(Context context, int i, String str, String str2) {
        if (SDKManager.useCache() && com.sdk.tencent.n.b.b(str).booleanValue()) {
            String a2 = a(i, str2);
            if (com.sdk.tencent.n.b.b(a2).booleanValue()) {
                com.sdk.tencent.j.a.a(context, a2, str);
            }
        }
    }

    public static String b(String str) {
        return str.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER)[1];
    }
}
