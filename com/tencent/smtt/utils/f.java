package com.tencent.smtt.utils;

import android.os.Build;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/utils/f.class */
public class f {

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/utils/f$a.class */
    public interface a {
        void a(int i);
    }

    public static String a(String str, Map<String, String> map, byte[] bArr, a aVar, boolean z) {
        if (bArr == null) {
            return null;
        }
        HttpURLConnection a2 = a(str, map);
        String str2 = null;
        if (a2 != null) {
            if (z) {
                a(a2, bArr);
            } else {
                b(a2, bArr);
            }
            str2 = a(a2, aVar, false);
        }
        return str2;
    }

    public static String a(String str, byte[] bArr, a aVar, boolean z) {
        try {
            String str2 = str + (z ? h.a().c() : g.a().b());
            try {
                bArr = z ? h.a().a(bArr) : g.a().a(bArr);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (bArr == null) {
                return null;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("Content-Type", "application/x-www-form-urlencoded");
            hashMap.put("Content-Length", String.valueOf(bArr.length));
            HttpURLConnection a2 = a(str2, hashMap);
            String str3 = null;
            if (a2 != null) {
                b(a2, bArr);
                str3 = a(a2, aVar, z);
            }
            return str3;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private static String a(HttpURLConnection httpURLConnection, a aVar, boolean z) {
        ByteArrayOutputStream byteArrayOutputStream;
        InputStream inputStream;
        ByteArrayOutputStream byteArrayOutputStream2;
        String str;
        GZIPInputStream gZIPInputStream;
        try {
            int responseCode = httpURLConnection.getResponseCode();
            if (aVar != null) {
                aVar.a(responseCode);
            }
            if (responseCode == 200) {
                InputStream inputStream2 = httpURLConnection.getInputStream();
                String contentEncoding = httpURLConnection.getContentEncoding();
                if (contentEncoding == null || !contentEncoding.equalsIgnoreCase("gzip")) {
                    gZIPInputStream = inputStream2;
                    if (contentEncoding != null) {
                        gZIPInputStream = inputStream2;
                        if (contentEncoding.equalsIgnoreCase("deflate")) {
                            gZIPInputStream = new InflaterInputStream(inputStream2, new Inflater(true));
                        }
                    }
                } else {
                    gZIPInputStream = new GZIPInputStream(inputStream2);
                }
                try {
                    byteArrayOutputStream2 = new ByteArrayOutputStream();
                    try {
                        byte[] bArr = new byte[128];
                        while (true) {
                            int read = gZIPInputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            byteArrayOutputStream2.write(bArr, 0, read);
                        }
                        str = z ? new String(byteArrayOutputStream2.toByteArray(), "utf-8") : new String(g.a().c(byteArrayOutputStream2.toByteArray()));
                    } catch (Throwable th) {
                        byteArrayOutputStream = byteArrayOutputStream2;
                        inputStream = gZIPInputStream;
                        th = th;
                        try {
                            th.printStackTrace();
                            a(inputStream);
                            a(byteArrayOutputStream);
                            return null;
                        } catch (Throwable th2) {
                            a(inputStream);
                            a(byteArrayOutputStream);
                            throw th2;
                        }
                    }
                } catch (Throwable th3) {
                    inputStream = gZIPInputStream;
                    th = th3;
                    byteArrayOutputStream = null;
                }
            } else {
                byteArrayOutputStream2 = null;
                str = null;
                gZIPInputStream = null;
            }
            a(gZIPInputStream);
            a(byteArrayOutputStream2);
            return str;
        } catch (Throwable th4) {
            th = th4;
            byteArrayOutputStream = null;
            inputStream = null;
        }
    }

    private static HttpURLConnection a(String str, Map<String, String> map) {
        HttpURLConnection httpURLConnection;
        String str2;
        String str3;
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection2.setRequestMethod("POST");
                httpURLConnection2.setDoOutput(true);
                httpURLConnection2.setDoInput(true);
                httpURLConnection2.setUseCaches(false);
                httpURLConnection2.setConnectTimeout(20000);
                if (Build.VERSION.SDK_INT > 13) {
                    str2 = "Connection";
                    str3 = "close";
                } else {
                    str2 = "http.keepAlive";
                    str3 = "false";
                }
                httpURLConnection2.setRequestProperty(str2, str3);
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    httpURLConnection2.setRequestProperty(entry.getKey(), entry.getValue());
                }
                return httpURLConnection2;
            } catch (Exception e) {
                e = e;
                httpURLConnection = httpURLConnection2;
                e.printStackTrace();
                return httpURLConnection;
            }
        } catch (Exception e2) {
            e = e2;
            httpURLConnection = null;
        }
    }

    private static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e) {
            }
        }
    }

    private static void a(HttpURLConnection httpURLConnection, byte[] bArr) {
        GZIPOutputStream gZIPOutputStream;
        GZIPOutputStream gZIPOutputStream2;
        try {
            try {
                gZIPOutputStream2 = new GZIPOutputStream(new BufferedOutputStream(httpURLConnection.getOutputStream(), 204800));
            } catch (Exception e) {
                e = e;
                gZIPOutputStream2 = null;
            } catch (Throwable th) {
                th = th;
                gZIPOutputStream = null;
                a(null);
                a(gZIPOutputStream);
                throw th;
            }
            try {
                gZIPOutputStream2.write(bArr);
                gZIPOutputStream = gZIPOutputStream2;
                gZIPOutputStream2.flush();
            } catch (Exception e2) {
                e = e2;
                gZIPOutputStream = gZIPOutputStream2;
                e.printStackTrace();
                a(null);
                a(gZIPOutputStream2);
            }
            a(null);
            a(gZIPOutputStream2);
        } catch (Throwable th2) {
            th = th2;
            a(null);
            a(gZIPOutputStream);
            throw th;
        }
    }

    private static void b(HttpURLConnection httpURLConnection, byte[] bArr) {
        OutputStream outputStream;
        OutputStream outputStream2 = null;
        OutputStream outputStream3 = null;
        try {
            try {
                outputStream = httpURLConnection.getOutputStream();
                outputStream.write(bArr);
                outputStream3 = outputStream;
                outputStream2 = outputStream;
                outputStream.flush();
            } catch (Exception e) {
                outputStream3 = outputStream2;
                e.printStackTrace();
                outputStream = outputStream2;
            }
            a(outputStream);
        } catch (Throwable th) {
            a(outputStream3);
            throw th;
        }
    }
}
