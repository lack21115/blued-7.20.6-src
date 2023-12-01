package com.igexin.push.f;

import android.text.TextUtils;
import com.tencent.smtt.sdk.TbsVideoCacheTask;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/push/f/r.class */
public class r {

    /* renamed from: a  reason: collision with root package name */
    public static final String f23667a = r.class.getName();
    public static final String b = "utf-8";

    /* renamed from: c  reason: collision with root package name */
    private static final String f23668c = "POST";
    private static final String d = "GET";
    private static final String e = "GETUI";
    private static final int f = 30000;

    private static String a(InputStream inputStream, String str) throws Exception {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, str));
            StringWriter stringWriter = new StringWriter();
            char[] cArr = new char[256];
            while (true) {
                int read = bufferedReader.read(cArr);
                if (read <= 0) {
                    break;
                }
                stringWriter.write(cArr, 0, read);
            }
            String stringWriter2 = stringWriter.toString();
            if (inputStream != null) {
                inputStream.close();
            }
            return stringWriter2;
        } catch (Throwable th) {
            if (inputStream != null) {
                inputStream.close();
            }
            throw th;
        }
    }

    private static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "utf-8";
        }
        String[] split = str.split(";");
        int length = split.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return "utf-8";
            }
            String trim = split[i2].trim();
            if (trim.startsWith("charset")) {
                String[] split2 = trim.split("=", 2);
                return (split2.length != 2 || TextUtils.isEmpty(split2[1])) ? "utf-8" : split2[1].trim();
            }
            i = i2 + 1;
        }
    }

    private static String a(Map<String, String> map, String str) throws Exception {
        if (map == null || map.isEmpty()) {
            return null;
        }
        String str2 = str;
        if (TextUtils.isEmpty(str)) {
            str2 = "utf-8";
        }
        StringBuilder sb = new StringBuilder();
        boolean z = false;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (!TextUtils.isEmpty(key) && !TextUtils.isEmpty(value)) {
                if (z) {
                    sb.append("&");
                } else {
                    z = true;
                }
                sb.append(key);
                sb.append("=");
                sb.append(URLEncoder.encode(value, str2));
            }
        }
        return sb.toString();
    }

    private static HttpURLConnection a(URL url, String str, String str2) throws Exception {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod(str);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setConnectTimeout(30000);
        httpURLConnection.setReadTimeout(30000);
        httpURLConnection.setRequestProperty("User-Agent", e);
        httpURLConnection.setRequestProperty("Content-Type", str2);
        httpURLConnection.setRequestProperty("HOST", url.getHost() + ":" + url.getPort());
        return httpURLConnection;
    }

    private static URL a(String str, String str2) throws Exception {
        String str3;
        StringBuilder sb;
        StringBuilder sb2;
        String sb3;
        URL url = new URL(str);
        if (TextUtils.isEmpty(str2)) {
            return url;
        }
        if (TextUtils.isEmpty(url.getQuery())) {
            str3 = "?";
            if (str.endsWith("?")) {
                sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(str2);
                sb3 = sb2.toString();
            } else {
                sb = new StringBuilder();
                sb.append(str);
                sb.append(str3);
                sb.append(str2);
                sb3 = sb.toString();
            }
        } else {
            str3 = "&";
            if (str.endsWith("&")) {
                sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(str2);
                sb3 = sb2.toString();
            } else {
                sb = new StringBuilder();
                sb.append(str);
                sb.append(str3);
                sb.append(str2);
                sb3 = sb.toString();
            }
        }
        return new URL(sb3);
    }

    private static URL a(String str, Map<String, String> map, String str2) throws Exception {
        return a(str, a(map, str2));
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x007d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static byte[] a(java.io.InputStream r5) {
        /*
            r0 = 0
            r8 = r0
            java.io.BufferedInputStream r0 = new java.io.BufferedInputStream     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L5a
            r1 = r0
            r2 = r5
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L5a
            r7 = r0
            r0 = r7
            r5 = r0
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Exception -> L50 java.lang.Throwable -> L74
            r1 = r0
            r2 = 1024(0x400, float:1.435E-42)
            r1.<init>(r2)     // Catch: java.lang.Exception -> L50 java.lang.Throwable -> L74
            r8 = r0
            r0 = r7
            r5 = r0
            r0 = 1024(0x400, float:1.435E-42)
            byte[] r0 = new byte[r0]     // Catch: java.lang.Exception -> L50 java.lang.Throwable -> L74
            r9 = r0
        L21:
            r0 = r7
            r5 = r0
            r0 = r7
            r1 = r9
            int r0 = r0.read(r1)     // Catch: java.lang.Exception -> L50 java.lang.Throwable -> L74
            r6 = r0
            r0 = r6
            r1 = -1
            if (r0 == r1) goto L3c
            r0 = r7
            r5 = r0
            r0 = r8
            r1 = r9
            r2 = 0
            r3 = r6
            r0.write(r1, r2, r3)     // Catch: java.lang.Exception -> L50 java.lang.Throwable -> L74
            goto L21
        L3c:
            r0 = r7
            r5 = r0
            r0 = r8
            byte[] r0 = r0.toByteArray()     // Catch: java.lang.Exception -> L50 java.lang.Throwable -> L74
            r8 = r0
            r0 = r7
            r0.close()     // Catch: java.io.IOException -> L49
            r0 = r8
            return r0
        L49:
            r5 = move-exception
            r0 = r5
            com.igexin.c.a.c.a.a(r0)
            r0 = r8
            return r0
        L50:
            r8 = move-exception
            goto L5d
        L54:
            r5 = move-exception
            r0 = r8
            r7 = r0
            goto L79
        L5a:
            r8 = move-exception
            r0 = 0
            r7 = r0
        L5d:
            r0 = r7
            r5 = r0
            r0 = r8
            com.igexin.c.a.c.a.a(r0)     // Catch: java.lang.Throwable -> L74
            r0 = r7
            if (r0 == 0) goto L72
            r0 = r7
            r0.close()     // Catch: java.io.IOException -> L6d
            r0 = 0
            return r0
        L6d:
            r5 = move-exception
            r0 = r5
            com.igexin.c.a.c.a.a(r0)
        L72:
            r0 = 0
            return r0
        L74:
            r8 = move-exception
            r0 = r5
            r7 = r0
            r0 = r8
            r5 = r0
        L79:
            r0 = r7
            if (r0 == 0) goto L89
            r0 = r7
            r0.close()     // Catch: java.io.IOException -> L84
            goto L89
        L84:
            r7 = move-exception
            r0 = r7
            com.igexin.c.a.c.a.a(r0)
        L89:
            r0 = r5
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.f.r.a(java.io.InputStream):byte[]");
    }

    private static byte[] a(String str, String str2, String str3) throws IOException {
        return ("Content-Disposition:form-data;name=\"" + str + "\"\r\nContent-Type:text/plain\r\n\r\n" + str2).getBytes(str3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:36:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00a7  */
    /* JADX WARN: Type inference failed for: r0v10, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r0v18, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r0v35, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r0v9, types: [java.net.HttpURLConnection] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static byte[] a(java.lang.String r4, java.lang.String r5, byte[] r6, int r7, int r8) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 197
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.f.r.a(java.lang.String, java.lang.String, byte[], int, int):byte[]");
    }

    private static byte[] a(String str, Map<String, String> map, int i, int i2) throws Exception {
        return a(str, map, "utf-8", i, i2);
    }

    private static byte[] a(String str, Map<String, String> map, int i, int i2, String str2) throws Exception {
        HttpURLConnection b2 = b(str, map, i, i2, str2);
        try {
            try {
                byte[] a2 = a(b2);
                if (b2 != null) {
                    b2.disconnect();
                }
                return a2;
            } catch (Exception e2) {
                throw e2;
            }
        } catch (Throwable th) {
            if (b2 != null) {
                b2.disconnect();
            }
            throw th;
        }
    }

    private static byte[] a(String str, Map<String, String> map, String str2, int i, int i2) throws Exception {
        String concat = "application/x-www-form-urlencoded;charset=".concat(String.valueOf(str2));
        String a2 = a(map, str2);
        byte[] bArr = new byte[0];
        if (a2 != null) {
            bArr = a2.getBytes(str2);
        }
        return a(str, concat, bArr, i, i2);
    }

    private static byte[] a(String str, Map<String, String> map, Map<String, i> map2, int i, int i2) throws Exception {
        return (map2 == null || map2.isEmpty()) ? a(str, map, "utf-8", i, i2) : a(str, map, map2, "utf-8", i, i2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:158:0x03cd  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x03d5  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0275  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x027c A[Catch: all -> 0x037e, Exception -> 0x0384, TRY_ENTER, TryCatch #8 {Exception -> 0x0384, all -> 0x037e, blocks: (B:94:0x026b, B:110:0x02af, B:98:0x027c, B:102:0x028d, B:106:0x029e, B:111:0x02b8, B:113:0x02e5, B:117:0x02f1, B:119:0x0333, B:121:0x033e), top: B:199:0x026b }] */
    /* JADX WARN: Type inference failed for: r0v187, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v194, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v199, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v204, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v21, types: [java.lang.Exception] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static byte[] a(java.lang.String r4, java.util.Map<java.lang.String, java.lang.String> r5, java.util.Map<java.lang.String, com.igexin.push.f.i> r6, java.lang.String r7, int r8, int r9) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 1102
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.f.r.a(java.lang.String, java.util.Map, java.util.Map, java.lang.String, int, int):byte[]");
    }

    public static byte[] a(String str, byte[] bArr) throws Exception {
        return a(str, "application/octet-stream", bArr, 10000, 10000);
    }

    private static byte[] a(HttpURLConnection httpURLConnection) throws Exception {
        return httpURLConnection.getErrorStream() == null ? a(httpURLConnection.getInputStream()) : b(httpURLConnection).getBytes();
    }

    private static String b(HttpURLConnection httpURLConnection) throws Exception {
        String a2 = a(httpURLConnection.getErrorStream(), a(httpURLConnection.getContentType()));
        if (TextUtils.isEmpty(a2)) {
            throw new IOException(httpURLConnection.getResponseCode() + ":" + httpURLConnection.getResponseMessage());
        }
        return a2;
    }

    private static HttpURLConnection b(String str, Map<String, String> map, int i, int i2, String str2) throws Exception {
        HttpURLConnection a2 = a(a(str, a(map, str2)), "GET", "application/x-www-form-urlencoded;charset=".concat(String.valueOf(str2)));
        a2.setConnectTimeout(i);
        a2.setReadTimeout(i2);
        return a2;
    }

    private static byte[] b(String str, String str2, String str3) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("Content-Disposition:form-data;name=\"");
        sb.append("dp_data");
        sb.append("\";filename=\"");
        String str4 = str;
        if (TextUtils.isEmpty(str)) {
            str4 = TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_FILENAME;
        }
        sb.append(str4);
        sb.append("\"\r\nContent-Type:");
        sb.append(str2);
        sb.append("\r\n\r\n");
        return sb.toString().getBytes(str3);
    }

    private static byte[] b(String str, Map<String, String> map, int i, int i2) throws Exception {
        return a(str, map, i, i2, "utf-8");
    }

    private static byte[] c(String str, Map<String, String> map, int i, int i2) throws Exception {
        HttpURLConnection b2 = b(str, map, i, i2, "utf-8");
        try {
            try {
                byte[] a2 = a(b2);
                if (b2 != null) {
                    b2.disconnect();
                }
                return a2;
            } catch (Exception e2) {
                throw e2;
            }
        } catch (Throwable th) {
            if (b2 != null) {
                b2.disconnect();
            }
            throw th;
        }
    }
}
