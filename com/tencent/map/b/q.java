package com.tencent.map.b;

import android.content.ClipDescription;
import android.net.Proxy;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/map/b/q.class */
public final class q {

    /* renamed from: a  reason: collision with root package name */
    private static int f37246a;
    private static boolean b;

    /* JADX WARN: Removed duplicated region for block: B:88:0x013f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.tencent.map.b.n a(java.net.HttpURLConnection r6, boolean r7) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 373
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.map.b.q.a(java.net.HttpURLConnection, boolean):com.tencent.map.b.n");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v9 */
    /* JADX WARN: Type inference failed for: r7v16 */
    public static n a(boolean z, String str, String str2, String str3, byte[] bArr, boolean z2, boolean z3) throws Exception {
        HttpURLConnection httpURLConnection;
        DataOutputStream dataOutputStream;
        Throwable th;
        boolean z4;
        HttpURLConnection httpURLConnection2;
        boolean z5;
        HttpURLConnection httpURLConnection3;
        p pVar;
        boolean z6;
        if (!l.d()) {
            throw new r();
        }
        try {
            try {
                httpURLConnection = a(str, z3);
                try {
                    if (b.a((String) null)) {
                        b.a(httpURLConnection.getURL().getHost());
                    } else {
                        httpURLConnection.setRequestProperty("Host", null);
                    }
                    if (z) {
                        httpURLConnection.setRequestMethod("GET");
                    } else {
                        httpURLConnection.setRequestMethod("POST");
                    }
                    httpURLConnection.setConnectTimeout(k.a());
                    httpURLConnection.setReadTimeout(k.b());
                    httpURLConnection.setRequestProperty("User-Agent", str2);
                    httpURLConnection.setDoInput(true);
                    httpURLConnection.setDoOutput(!z);
                    httpURLConnection.setUseCaches(false);
                    if (z2) {
                        httpURLConnection.setRequestProperty("Connection", com.anythink.expressad.foundation.g.f.g.c.f7906c);
                    }
                    k.a(httpURLConnection);
                    httpURLConnection.connect();
                    k.c();
                    if (!z && bArr != null && bArr.length != 0) {
                        dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                        try {
                            dataOutputStream.write(bArr);
                            dataOutputStream.flush();
                            dataOutputStream.close();
                        } catch (p e) {
                            e = e;
                            z6 = dataOutputStream;
                            httpURLConnection3 = httpURLConnection;
                            pVar = e;
                            z5 = z6;
                            HttpURLConnection httpURLConnection4 = httpURLConnection3;
                            k.a(true);
                            HttpURLConnection httpURLConnection5 = httpURLConnection3;
                            throw pVar;
                        } catch (Exception e2) {
                            e = e2;
                            httpURLConnection2 = httpURLConnection;
                            e = e;
                            z4 = dataOutputStream;
                            k.a(false);
                            HttpURLConnection httpURLConnection6 = httpURLConnection2;
                            throw e;
                        } catch (Throwable th2) {
                            th = th2;
                            if (dataOutputStream != null) {
                                dataOutputStream.close();
                            }
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            throw th;
                        }
                    }
                    int responseCode = httpURLConnection.getResponseCode();
                    if (responseCode == 200 || responseCode == 206) {
                        k.d();
                        n a2 = a(httpURLConnection, z);
                        k.a((a2 == null || a2.f37245a == null) ? 0 : a2.f37245a.length);
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        return a2;
                    } else if (responseCode == 202 || responseCode == 201 || responseCode == 204 || responseCode == 205 || responseCode == 304 || responseCode == 305 || responseCode == 408 || responseCode == 502 || responseCode == 504 || responseCode == 503) {
                        throw new IOException("doGetOrPost retry");
                    } else {
                        throw new p("response code is " + responseCode);
                    }
                } catch (p e3) {
                    e = e3;
                    z6 = false;
                } catch (Exception e4) {
                    e = e4;
                    dataOutputStream = 0;
                } catch (Throwable th3) {
                    dataOutputStream = null;
                    th = th3;
                }
            } catch (p e5) {
                z5 = false;
                httpURLConnection3 = null;
                pVar = e5;
            } catch (Exception e6) {
                e = e6;
                z4 = false;
                httpURLConnection2 = null;
            } catch (Throwable th4) {
                httpURLConnection = null;
                dataOutputStream = null;
                th = th4;
            }
        } catch (Throwable th5) {
            dataOutputStream = str;
            httpURLConnection = null;
            th = th5;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:52:0x0117, code lost:
        if (r11 != null) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0142, code lost:
        if (r11 == null) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0145, code lost:
        r11.disconnect();
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x002e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.net.HttpURLConnection a(java.lang.String r6, boolean r7) {
        /*
            Method dump skipped, instructions count: 440
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.map.b.q.a(java.lang.String, boolean):java.net.HttpURLConnection");
    }

    private static HttpURLConnection a(URL url, String str) throws IOException {
        String replaceFirst;
        String defaultHost = Proxy.getDefaultHost();
        int defaultPort = Proxy.getDefaultPort();
        int i = 80;
        int i2 = defaultPort;
        if (defaultPort == -1) {
            i2 = 80;
        }
        String host = url.getHost();
        int port = url.getPort();
        if (port != -1) {
            i = port;
        }
        if (str.indexOf(String.valueOf(host) + ":" + i) != -1) {
            replaceFirst = str.replaceFirst(String.valueOf(host) + ":" + i, String.valueOf(defaultHost) + ":" + i2);
        } else {
            replaceFirst = str.replaceFirst(host, String.valueOf(defaultHost) + ":" + i2);
        }
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(replaceFirst).openConnection();
            httpURLConnection.setRequestProperty("X-Online-Host", String.valueOf(host) + ":" + i);
            return httpURLConnection;
        } catch (MalformedURLException e) {
            return null;
        }
    }

    private static void a(int i) {
        if (f37246a == i) {
            return;
        }
        f37246a = i;
    }

    private static boolean a(HttpURLConnection httpURLConnection) throws IOException {
        InputStream inputStream;
        InputStream inputStream2;
        try {
            inputStream2 = httpURLConnection.getInputStream();
        } catch (Throwable th) {
            th = th;
            inputStream = null;
        }
        try {
            if (!httpURLConnection.getContentType().equals(ClipDescription.MIMETYPE_TEXT_HTML)) {
                if (inputStream2 != null) {
                    inputStream2.close();
                    return false;
                }
                return false;
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (inputStream2.available() > 0) {
                byteArrayOutputStream.write(inputStream2.read());
            }
            boolean equals = new String(byteArrayOutputStream.toByteArray()).trim().equals("1");
            if (inputStream2 != null) {
                inputStream2.close();
            }
            return equals;
        } catch (Throwable th2) {
            inputStream = inputStream2;
            th = th2;
            if (inputStream != null) {
                inputStream.close();
            }
            throw th;
        }
    }
}
