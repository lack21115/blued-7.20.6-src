package com.kwad.sdk.core.network.kwai;

import android.text.TextUtils;
import android.util.Log;
import com.google.common.net.HttpHeaders;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.openalliance.ad.utils.ay;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.network.q;
import com.kwad.sdk.core.network.s;
import com.kwad.sdk.crash.utils.h;
import com.sobot.chat.core.channel.Const;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/network/kwai/b.class */
public final class b {
    private static com.kwad.sdk.core.network.c a(String str, Map<String, String> map, String str2, boolean z) {
        OutputStream outputStream;
        HttpURLConnection httpURLConnection;
        HttpURLConnection httpURLConnection2;
        OutputStream outputStream2;
        OutputStream outputStream3;
        com.kwad.sdk.core.network.c cVar = new com.kwad.sdk.core.network.c();
        try {
            httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
            outputStream2 = null;
            outputStream3 = null;
        } catch (Exception e) {
            e = e;
            outputStream = null;
            httpURLConnection = null;
        } catch (Throwable th) {
            th = th;
            outputStream = null;
            httpURLConnection = null;
        }
        try {
            s.wrapHttpURLConnection(httpURLConnection2);
            httpURLConnection2.setDoInput(true);
            httpURLConnection2.setDoOutput(true);
            httpURLConnection2.setRequestMethod("POST");
            httpURLConnection2.setRequestProperty("Content-Type", z ? "application/json" : "application/x-www-form-urlencoded");
            q.b(httpURLConnection2);
            a(httpURLConnection2, map);
            httpURLConnection2.setConnectTimeout(5000);
            httpURLConnection2.setReadTimeout(5000);
            httpURLConnection2.setUseCaches(false);
            httpURLConnection2.connect();
            OutputStream outputStream4 = null;
            if (!TextUtils.isEmpty(str2)) {
                outputStream4 = httpURLConnection2.getOutputStream();
                outputStream4.write(str2.getBytes());
                outputStream4.flush();
            }
            OutputStream outputStream5 = outputStream4;
            int responseCode = httpURLConnection2.getResponseCode();
            OutputStream outputStream6 = outputStream4;
            cVar.code = responseCode;
            OutputStream outputStream7 = outputStream4;
            cVar.agd = cVar.code;
            if (responseCode == 200) {
                outputStream2 = outputStream4;
                outputStream3 = outputStream4;
                cVar.agf = a(httpURLConnection2.getInputStream());
            }
            com.kwad.sdk.crash.utils.b.a(httpURLConnection2);
            com.kwad.sdk.crash.utils.b.closeQuietly(outputStream4);
            return cVar;
        } catch (Exception e2) {
            e = e2;
            httpURLConnection = httpURLConnection2;
            outputStream = outputStream3;
            try {
                a(cVar, e);
                com.kwad.sdk.crash.utils.b.a(httpURLConnection);
                com.kwad.sdk.crash.utils.b.closeQuietly(outputStream);
                return cVar;
            } catch (Throwable th2) {
                th = th2;
                com.kwad.sdk.crash.utils.b.a(httpURLConnection);
                com.kwad.sdk.crash.utils.b.closeQuietly(outputStream);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            outputStream = outputStream2;
            httpURLConnection = httpURLConnection2;
            com.kwad.sdk.crash.utils.b.a(httpURLConnection);
            com.kwad.sdk.crash.utils.b.closeQuietly(outputStream);
            throw th;
        }
    }

    public static com.kwad.sdk.core.network.c a(String str, Map<String, String> map, boolean z) {
        InputStream inputStream;
        HttpURLConnection httpURLConnection;
        Throwable th;
        com.kwad.sdk.core.network.c cVar = new com.kwad.sdk.core.network.c();
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
            InputStream inputStream2 = null;
            InputStream inputStream3 = null;
            try {
                s.wrapHttpURLConnection(httpURLConnection2);
                a(httpURLConnection2, map);
                httpURLConnection2.setRequestMethod("GET");
                httpURLConnection2.setRequestProperty(HttpHeaders.ACCEPT, "application/json");
                q.b(httpURLConnection2);
                cVar.code = httpURLConnection2.getResponseCode();
                cVar.agd = cVar.code;
                StringBuilder sb = new StringBuilder();
                InputStream inputStream4 = null;
                if (z) {
                    InputStream inputStream5 = httpURLConnection2.getInputStream();
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = inputStream5.read(bArr);
                        inputStream4 = inputStream5;
                        if (read == -1) {
                            break;
                        }
                        sb.append(new String(bArr, 0, read));
                    }
                }
                inputStream2 = inputStream4;
                inputStream3 = inputStream4;
                cVar.agf = sb.toString();
                com.kwad.sdk.crash.utils.b.a(httpURLConnection2);
                com.kwad.sdk.crash.utils.b.closeQuietly(inputStream4);
                return cVar;
            } catch (Exception e) {
                httpURLConnection = httpURLConnection2;
                inputStream = inputStream3;
                e = e;
                try {
                    a(cVar, e);
                    com.kwad.sdk.crash.utils.b.a(httpURLConnection);
                    com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                    return cVar;
                } catch (Throwable th2) {
                    th = th2;
                    com.kwad.sdk.crash.utils.b.a(httpURLConnection);
                    com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                inputStream = inputStream2;
                httpURLConnection = httpURLConnection2;
                com.kwad.sdk.crash.utils.b.a(httpURLConnection);
                com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            inputStream = null;
            httpURLConnection = null;
        } catch (Throwable th4) {
            inputStream = null;
            httpURLConnection = null;
            th = th4;
        }
    }

    private static String a(InputStream inputStream) {
        try {
            try {
                return h.c(inputStream);
            } catch (IOException e) {
                com.kwad.sdk.core.d.b.printStackTraceOnly(e);
                com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                return null;
            }
        } finally {
            com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
        }
    }

    private static void a(com.kwad.sdk.core.network.c cVar, Exception exc) {
        cVar.agd = cVar.code == 0 ? -1 : cVar.code;
        cVar.age = exc;
        if (exc instanceof SocketTimeoutException) {
            cVar.code = f.agi.errorCode;
            cVar.agf = f.agi.msg;
        } else {
            cVar.code = f.agj.errorCode;
            try {
                cVar.agf = f.agj.msg + "/n" + Log.getStackTraceString(exc);
            } catch (Exception e) {
            }
        }
        if (com.kwad.b.kwai.a.bI.booleanValue()) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(exc);
        }
    }

    private static void a(HttpURLConnection httpURLConnection, Map<String, String> map) {
        if (map == null || httpURLConnection == null) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
    }

    public static com.kwad.sdk.core.network.c doGet(String str, Map<String, String> map) {
        return a(str, map, true);
    }

    public static com.kwad.sdk.core.network.c doPost(String str, Map<String, String> map, Map<String, String> map2) {
        String str2;
        if (map2 != null) {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, String> entry : map2.entrySet()) {
                String encode = encode(entry.getValue());
                sb.append(entry.getKey());
                sb.append("=");
                sb.append(encode);
                sb.append(ContainerUtils.FIELD_DELIMITER);
            }
            str2 = sb.substring(0, sb.length() - 1);
        } else {
            str2 = null;
        }
        return a(str, map, str2, false);
    }

    public static com.kwad.sdk.core.network.c doPost(String str, Map<String, String> map, JSONObject jSONObject) {
        return a(str, map, jSONObject != null ? jSONObject.toString() : null, true);
    }

    public static boolean downloadUrlToStream(String str, OutputStream outputStream, int i) {
        HttpURLConnection httpURLConnection;
        BufferedInputStream bufferedInputStream;
        BufferedOutputStream bufferedOutputStream;
        BufferedOutputStream bufferedOutputStream2 = null;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                s.wrapHttpURLConnection(httpURLConnection);
                httpURLConnection.setRequestProperty(HttpHeaders.ACCEPT_LANGUAGE, ay.Code);
                httpURLConnection.setConnectTimeout(10000);
                httpURLConnection.setReadTimeout(Const.SOCKET_CHECK_CHANNEL);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setRequestProperty("Connection", "keep-alive");
                httpURLConnection.setRequestProperty("Charset", "UTF-8");
                q.b(httpURLConnection);
                BufferedInputStream bufferedInputStream2 = new BufferedInputStream(httpURLConnection.getInputStream());
                try {
                    byte[] bArr = new byte[1024];
                    long j = 0;
                    if (i > 0) {
                        while (true) {
                            int read = bufferedInputStream2.read(bArr);
                            bufferedOutputStream = null;
                            if (read == -1) {
                                break;
                            }
                            long j2 = j + read;
                            j = j2;
                            if (j2 > i) {
                                bufferedOutputStream = null;
                                break;
                            }
                        }
                    } else {
                        bufferedOutputStream = null;
                        if (i < 0) {
                            bufferedOutputStream = new BufferedOutputStream(outputStream);
                            while (true) {
                                try {
                                    int read2 = bufferedInputStream2.read(bArr);
                                    if (read2 == -1) {
                                        break;
                                    }
                                    bufferedOutputStream.write(bArr, 0, read2);
                                } catch (Throwable th) {
                                    bufferedOutputStream2 = bufferedOutputStream;
                                    bufferedInputStream = bufferedInputStream2;
                                    th = th;
                                    com.kwad.sdk.crash.utils.b.closeQuietly(bufferedOutputStream2);
                                    com.kwad.sdk.crash.utils.b.closeQuietly(bufferedInputStream);
                                    if (httpURLConnection != null) {
                                        httpURLConnection.disconnect();
                                    }
                                    throw th;
                                }
                            }
                            bufferedOutputStream.flush();
                        }
                    }
                    com.kwad.sdk.crash.utils.b.closeQuietly(bufferedOutputStream);
                    com.kwad.sdk.crash.utils.b.closeQuietly(bufferedInputStream2);
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                        return true;
                    }
                    return true;
                } catch (Throwable th2) {
                    th = th2;
                    bufferedInputStream = bufferedInputStream2;
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedInputStream = null;
            }
        } catch (Throwable th4) {
            th = th4;
            httpURLConnection = null;
            bufferedInputStream = null;
        }
    }

    private static String encode(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            com.kwad.sdk.core.d.b.printStackTrace(e);
            return "";
        }
    }
}
