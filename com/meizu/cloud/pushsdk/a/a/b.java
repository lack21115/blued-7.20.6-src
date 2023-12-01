package com.meizu.cloud.pushsdk.a.a;

import android.content.Context;
import android.text.TextUtils;
import com.meizu.cloud.pushinternal.DebugLogger;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPOutputStream;

/* loaded from: source-7994992-dex2jar.jar:com/meizu/cloud/pushsdk/a/a/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static final String f23950a = b.class.getSimpleName();
    private static final Object b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private static b f23951c;

    private b(Context context) {
        try {
            System.setProperty("sun.net.http.allowRestrictedHeaders", "true");
        } catch (Exception e) {
            e.printStackTrace();
        }
        a.a(context);
    }

    public static b a(Context context) {
        if (f23951c == null) {
            synchronized (b) {
                if (f23951c == null) {
                    f23951c = new b(context);
                }
            }
        }
        return f23951c;
    }

    private Map<String, String> a(Map<String, String> map) {
        HashMap hashMap = map;
        if (map == null) {
            hashMap = new HashMap(2);
        }
        byte[] c2 = a.a().c();
        if (c2 != null && c2.length > 0) {
            String str = new String(c2);
            String str2 = f23950a;
            DebugLogger.d(str2, "attach x_s_key: " + str);
            hashMap.put("X-S-Key", str);
            return hashMap;
        }
        byte[] b2 = a.a().b();
        if (b2 != null && b2.length > 0) {
            String str3 = new String(a.a().b());
            String str4 = f23950a;
            DebugLogger.d(str4, "attach x_a_key: " + str3);
            hashMap.put("X-A-Key", str3);
        }
        return hashMap;
    }

    private void a(HttpURLConnection httpURLConnection, byte[] bArr) throws IOException {
        GZIPOutputStream gZIPOutputStream;
        try {
            GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(httpURLConnection.getOutputStream());
            try {
                gZIPOutputStream2.write(bArr);
                gZIPOutputStream2.flush();
                try {
                    gZIPOutputStream2.close();
                } catch (Exception e) {
                }
            } catch (Throwable th) {
                gZIPOutputStream = gZIPOutputStream2;
                th = th;
                if (gZIPOutputStream != null) {
                    try {
                        gZIPOutputStream.close();
                    } catch (Exception e2) {
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            gZIPOutputStream = null;
        }
    }

    private void a(URLConnection uRLConnection) {
        try {
            String headerField = uRLConnection.getHeaderField("X-S-Key");
            String str = f23950a;
            DebugLogger.d(str, "get x_s_key = " + headerField);
            if (TextUtils.isEmpty(headerField)) {
                return;
            }
            a.a().a(headerField);
        } catch (NullPointerException e) {
        }
    }

    private byte[] a(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            try {
                int read = inputStream.read();
                if (read == -1) {
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    try {
                        return byteArray;
                    } catch (IOException e) {
                        return byteArray;
                    }
                }
                byteArrayOutputStream.write(read);
            } finally {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e2) {
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0217  */
    /* JADX WARN: Type inference failed for: r0v114, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v0, types: [com.meizu.cloud.pushsdk.a.a.b] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.meizu.cloud.pushsdk.a.a.c b(java.lang.String r8, java.util.Map<java.lang.String, java.lang.String> r9, java.lang.String r10) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 586
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.cloud.pushsdk.a.a.b.b(java.lang.String, java.util.Map, java.lang.String):com.meizu.cloud.pushsdk.a.a.c");
    }

    private void b(URLConnection uRLConnection) {
        try {
            String headerField = uRLConnection.getHeaderField("Key-Timeout");
            String str = f23950a;
            DebugLogger.d(str, "get keyTimeout = " + headerField);
        } catch (NullPointerException e) {
        }
    }

    public c a(String str, Map<String, String> map, String str2) {
        try {
            return b(str, a(map), str2);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
