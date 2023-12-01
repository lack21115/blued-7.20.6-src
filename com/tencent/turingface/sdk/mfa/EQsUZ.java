package com.tencent.turingface.sdk.mfa;

import java.net.NetworkInterface;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/turingface/sdk/mfa/EQsUZ.class */
public final class EQsUZ {
    /* JADX WARN: Removed duplicated region for block: B:101:0x015b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.tencent.turingface.sdk.mfa.Gc2mM a(int r6, byte[] r7) {
        /*
            Method dump skipped, instructions count: 1084
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.turingface.sdk.mfa.EQsUZ.a(int, byte[]):com.tencent.turingface.sdk.mfa.Gc2mM");
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x002e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(android.content.Context r4, java.lang.String r5) {
        /*
            Method dump skipped, instructions count: 250
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.turingface.sdk.mfa.EQsUZ.a(android.content.Context, java.lang.String):java.lang.String");
    }

    public static String a(byte[] bArr) {
        byte[] bArr2;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(new String(com.tencent.turingcam.oqKCa.c("4D4435")));
            messageDigest.update(bArr);
            bArr2 = messageDigest.digest();
        } catch (NoSuchAlgorithmException e) {
            bArr2 = null;
        }
        return com.tencent.turingcam.oqKCa.a(bArr2);
    }

    public static boolean a() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            if (networkInterfaces != null) {
                Iterator it = Collections.list(networkInterfaces).iterator();
                while (it.hasNext()) {
                    NetworkInterface networkInterface = (NetworkInterface) it.next();
                    if (networkInterface.isUp() && networkInterface.getInterfaceAddresses().size() != 0 && networkInterface.getName().matches("tun\\d+")) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        } catch (Throwable th) {
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0041, code lost:
        if (android.text.TextUtils.equals(java.lang.System.getProperty("http.proxyPort"), "-1") == false) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(android.content.Context r3) {
        /*
            r0 = 0
            r5 = r0
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L48
            r1 = 14
            if (r0 >= r1) goto L23
            r0 = r5
            r4 = r0
            r0 = r3
            java.lang.String r0 = android.net.Proxy.getHost(r0)     // Catch: java.lang.Throwable -> L48
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L48
            if (r0 != 0) goto L46
            r0 = r5
            r4 = r0
            r0 = r3
            int r0 = android.net.Proxy.getPort(r0)     // Catch: java.lang.Throwable -> L48
            r1 = -1
            if (r0 == r1) goto L46
            goto L44
        L23:
            r0 = r5
            r4 = r0
            java.lang.String r0 = "http.proxyHost"
            java.lang.String r0 = java.lang.System.getProperty(r0)     // Catch: java.lang.Throwable -> L48
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L48
            if (r0 != 0) goto L46
            java.lang.String r0 = "http.proxyPort"
            java.lang.String r0 = java.lang.System.getProperty(r0)     // Catch: java.lang.Throwable -> L48
            java.lang.String r1 = "-1"
            boolean r0 = android.text.TextUtils.equals(r0, r1)     // Catch: java.lang.Throwable -> L48
            r6 = r0
            r0 = r5
            r4 = r0
            r0 = r6
            if (r0 != 0) goto L46
        L44:
            r0 = 1
            r4 = r0
        L46:
            r0 = r4
            return r0
        L48:
            r3 = move-exception
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.turingface.sdk.mfa.EQsUZ.a(android.content.Context):boolean");
    }
}
