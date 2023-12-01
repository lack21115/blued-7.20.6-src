package com.mokee.volley.toolbox;

import android.content.Context;
import com.mokee.volley.RequestQueue;

/* loaded from: source-4181928-dex2jar.jar:com/mokee/volley/toolbox/Volley.class */
public class Volley {
    private static final String[] a = null;

    static {
        String[] strArr = new String[2];
        throw new VerifyError("bad dex opcode");
    }

    public static RequestQueue newRequestQueue(Context context) {
        return newRequestQueue(context, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0062, code lost:
        if (com.mokee.volley.toolbox.ImageLoader.h != false) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.mokee.volley.RequestQueue newRequestQueue(android.content.Context r6, com.mokee.volley.toolbox.HttpStack r7) {
        /*
            java.io.File r0 = new java.io.File
            r1 = r0
            r2 = r6
            java.io.File r2 = r2.getCacheDir()
            java.lang.String[] r3 = com.mokee.volley.toolbox.Volley.a
            r4 = 0
            r3 = r3[r4]
            r1.<init>(r2, r3)
            r10 = r0
            java.lang.String[] r0 = com.mokee.volley.toolbox.Volley.a
            r1 = 1
            r0 = r0[r1]
            r9 = r0
            r0 = r6
            java.lang.String r0 = r0.getPackageName()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L95
            r11 = r0
            r0 = r6
            android.content.pm.PackageManager r0 = r0.getPackageManager()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L95
            r1 = r11
            r2 = 0
            android.content.pm.PackageInfo r0 = r0.getPackageInfo(r1, r2)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L95
            r6 = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L95
            r1 = r0
            r2 = r11
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L95
            r1.<init>(r2)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L95
            java.lang.String r1 = "/"
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L95
            r1 = r6
            int r1 = r1.versionCode     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L95
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L95
            java.lang.String r0 = r0.toString()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L95
            r6 = r0
            r0 = r6
            r9 = r0
        L47:
            r0 = r7
            r6 = r0
            r0 = r7
            if (r0 != 0) goto L71
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L92
            r8 = r0
            r0 = r8
            r1 = 9
            if (r0 < r1) goto L65
            com.mokee.volley.toolbox.HurlStack r0 = new com.mokee.volley.toolbox.HurlStack
            r1 = r0
            r1.<init>()
            r6 = r0
            boolean r0 = com.mokee.volley.toolbox.ImageLoader.h
            if (r0 == 0) goto L71
        L65:
            com.mokee.volley.toolbox.HttpClientStack r0 = new com.mokee.volley.toolbox.HttpClientStack
            r1 = r0
            r2 = r9
            android.net.http.AndroidHttpClient r2 = android.net.http.AndroidHttpClient.newInstance(r2)
            r1.<init>(r2)
            r6 = r0
        L71:
            com.mokee.volley.toolbox.BasicNetwork r0 = new com.mokee.volley.toolbox.BasicNetwork
            r1 = r0
            r2 = r6
            r1.<init>(r2)
            r6 = r0
            com.mokee.volley.RequestQueue r0 = new com.mokee.volley.RequestQueue
            r1 = r0
            com.mokee.volley.toolbox.DiskBasedCache r2 = new com.mokee.volley.toolbox.DiskBasedCache
            r3 = r2
            r4 = r10
            r3.<init>(r4)
            r3 = r6
            r1.<init>(r2, r3)
            r6 = r0
            r0 = r6
            r0.start()
            r0 = r6
            return r0
        L92:
            r6 = move-exception
            r0 = r6
            throw r0
        L95:
            r6 = move-exception
            goto L47
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mokee.volley.toolbox.Volley.newRequestQueue(android.content.Context, com.mokee.volley.toolbox.HttpStack):com.mokee.volley.RequestQueue");
    }
}
