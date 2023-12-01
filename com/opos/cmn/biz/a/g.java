package com.opos.cmn.biz.a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.util.Arrays;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/biz/a/g.class */
public class g {
    public static SSLSocketFactory a(Context context) {
        if (context != null) {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            if (Build.VERSION.SDK_INT < 28 || applicationInfo == null || applicationInfo.targetSdkVersion < 28) {
                return a(a(), context);
            }
            return null;
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0024, code lost:
        if (r0.targetSdkVersion < 28) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static javax.net.ssl.SSLSocketFactory a(javax.net.ssl.TrustManager r7, android.content.Context r8) {
        /*
            r0 = 0
            r10 = r0
            r0 = r10
            r9 = r0
            r0 = r8
            if (r0 == 0) goto L99
            r0 = r8
            android.content.pm.ApplicationInfo r0 = r0.getApplicationInfo()
            r11 = r0
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 28
            if (r0 < r1) goto L27
            r0 = r11
            if (r0 == 0) goto L27
            r0 = r10
            r9 = r0
            r0 = r11
            int r0 = r0.targetSdkVersion
            r1 = 28
            if (r0 >= r1) goto L99
        L27:
            r0 = r8
            if (r0 != 0) goto L30
            r0 = 0
            r8 = r0
            goto L39
        L30:
            android.net.SSLSessionCache r0 = new android.net.SSLSessionCache
            r1 = r0
            r2 = r8
            r1.<init>(r2)
            r8 = r0
        L39:
            java.lang.String r0 = "TLS"
            javax.net.ssl.SSLContext r0 = javax.net.ssl.SSLContext.getInstance(r0)
            r9 = r0
            r0 = r9
            r1 = 0
            r2 = 1
            javax.net.ssl.TrustManager[] r2 = new javax.net.ssl.TrustManager[r2]
            r3 = r2
            r4 = 0
            r5 = r7
            r3[r4] = r5
            r3 = 0
            r0.init(r1, r2, r3)
            r0 = r9
            javax.net.ssl.SSLSessionContext r0 = r0.getClientSessionContext()
            r1 = 0
            r0.setSessionCacheSize(r1)
            r0 = r9
            javax.net.ssl.SSLSessionContext r0 = r0.getClientSessionContext()
            r1 = 604800(0x93a80, float:8.47505E-40)
            r0.setSessionTimeout(r1)
            r0 = r8
            if (r0 == 0) goto L94
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 19
            if (r0 <= r1) goto L94
            java.lang.Class<android.net.SSLSessionCache> r0 = android.net.SSLSessionCache.class
            java.lang.String r1 = "install"
            r2 = 2
            java.lang.Class[] r2 = new java.lang.Class[r2]     // Catch: java.lang.Exception -> L9b
            r3 = r2
            r4 = 0
            java.lang.Class<android.net.SSLSessionCache> r5 = android.net.SSLSessionCache.class
            r3[r4] = r5     // Catch: java.lang.Exception -> L9b
            r3 = r2
            r4 = 1
            java.lang.Class<javax.net.ssl.SSLContext> r5 = javax.net.ssl.SSLContext.class
            r3[r4] = r5     // Catch: java.lang.Exception -> L9b
            java.lang.reflect.Method r0 = r0.getMethod(r1, r2)     // Catch: java.lang.Exception -> L9b
            r1 = 0
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: java.lang.Exception -> L9b
            r3 = r2
            r4 = 0
            r5 = r8
            r3[r4] = r5     // Catch: java.lang.Exception -> L9b
            r3 = r2
            r4 = 1
            r5 = r9
            r3[r4] = r5     // Catch: java.lang.Exception -> L9b
            java.lang.Object r0 = r0.invoke(r1, r2)     // Catch: java.lang.Exception -> L9b
        L94:
            r0 = r9
            javax.net.ssl.SSLSocketFactory r0 = r0.getSocketFactory()
            r9 = r0
        L99:
            r0 = r9
            return r0
        L9b:
            r7 = move-exception
            goto L94
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.cmn.biz.a.g.a(javax.net.ssl.TrustManager, android.content.Context):javax.net.ssl.SSLSocketFactory");
    }

    public static X509TrustManager a() {
        try {
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init((KeyStore) null);
            TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
            if (trustManagers.length == 1 && (trustManagers[0] instanceof X509TrustManager)) {
                return (X509TrustManager) trustManagers[0];
            }
            throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers));
        } catch (GeneralSecurityException e) {
            throw new AssertionError();
        }
    }
}
