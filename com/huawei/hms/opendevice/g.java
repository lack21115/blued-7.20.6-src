package com.huawei.hms.opendevice;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.secure.android.common.ssl.SecureSSLSocketFactory;
import com.huawei.secure.android.common.util.IOUtil;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.GeneralSecurityException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/opendevice/g.class */
public abstract class g {

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/opendevice/g$a.class */
    enum a {
        GET("GET"),
        POST("POST");
        

        /* renamed from: a  reason: collision with root package name */
        private String f9207a;

        a(String str) {
            this.f9207a = str;
        }

        public String a() {
            return this.f9207a;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v183, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v204, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v213, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v37, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v90, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v92, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v8 */
    public static String a(Context context, String str, String str2, Map<String, String> map) {
        HttpURLConnection httpURLConnection;
        Map<String, String> map2;
        HttpURLConnection httpURLConnection2;
        String str3;
        BufferedOutputStream bufferedOutputStream;
        HttpURLConnection httpURLConnection3;
        BufferedInputStream bufferedInputStream;
        BufferedOutputStream bufferedOutputStream2;
        String str4;
        BufferedInputStream bufferedInputStream2;
        BufferedOutputStream bufferedOutputStream3;
        String str5;
        String str6;
        HttpURLConnection httpURLConnection4;
        BufferedOutputStream bufferedOutputStream4 = null;
        if (str2 == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        int i = -1;
        try {
            try {
                httpURLConnection = a(context, str, map, a.POST.a());
                if (httpURLConnection == 0) {
                    IOUtil.closeSecure((OutputStream) null);
                    IOUtil.closeSecure((InputStream) null);
                    IOUtil.closeSecure((InputStream) null);
                    p.a(httpURLConnection);
                    HMSLog.i("PushHttpClient", "close connection");
                    return null;
                }
                try {
                    bufferedOutputStream = new BufferedOutputStream(httpURLConnection.getOutputStream());
                    int i2 = -1;
                    int i3 = -1;
                    int i4 = -1;
                    try {
                        bufferedOutputStream.write(str2.getBytes("UTF-8"));
                        bufferedOutputStream.flush();
                        i = httpURLConnection.getResponseCode();
                        StringBuilder sb = new StringBuilder();
                        sb.append("http post response code: ");
                        sb.append(i);
                        HMSLog.d("PushHttpClient", sb.toString());
                        if (i >= 400) {
                            i2 = i;
                            i3 = i;
                            i4 = i;
                            str4 = httpURLConnection.getErrorStream();
                        } else {
                            i2 = i;
                            i3 = i;
                            i4 = i;
                            str4 = httpURLConnection.getInputStream();
                        }
                    } catch (IOException e) {
                        str4 = null;
                        i = i2;
                    } catch (RuntimeException e2) {
                        str4 = null;
                        i = i3;
                    } catch (Exception e3) {
                        str4 = null;
                        i = i4;
                    } catch (Throwable th) {
                        th = th;
                        bufferedInputStream = null;
                        httpURLConnection3 = httpURLConnection;
                        str3 = null;
                    }
                } catch (IOException e4) {
                    bufferedOutputStream3 = null;
                    str4 = null;
                    str6 = httpURLConnection;
                    bufferedInputStream2 = null;
                    StringBuilder sb2 = new StringBuilder();
                    String str7 = str6;
                    sb2.append("http execute encounter IOException - http code:");
                    String str8 = str6;
                    sb2.append(i);
                    httpURLConnection4 = str6;
                    bufferedOutputStream4 = bufferedOutputStream3;
                    map = bufferedInputStream2;
                    HMSLog.w("PushHttpClient", sb2.toString());
                    str2 = str6;
                    IOUtil.closeSecure((OutputStream) bufferedOutputStream3);
                    IOUtil.closeSecure((InputStream) str4);
                    IOUtil.closeSecure((InputStream) bufferedInputStream2);
                    p.a((HttpURLConnection) str2);
                    HMSLog.i("PushHttpClient", "close connection");
                    return null;
                } catch (RuntimeException e5) {
                    bufferedOutputStream3 = null;
                    str4 = null;
                    str5 = httpURLConnection;
                    bufferedInputStream2 = null;
                    StringBuilder sb3 = new StringBuilder();
                    String str9 = str5;
                    sb3.append("http execute encounter RuntimeException - http code:");
                    String str10 = str5;
                    sb3.append(i);
                    httpURLConnection4 = str5;
                    bufferedOutputStream4 = bufferedOutputStream3;
                    map = bufferedInputStream2;
                    HMSLog.w("PushHttpClient", sb3.toString());
                    str2 = str5;
                    IOUtil.closeSecure((OutputStream) bufferedOutputStream3);
                    IOUtil.closeSecure((InputStream) str4);
                    IOUtil.closeSecure((InputStream) bufferedInputStream2);
                    p.a((HttpURLConnection) str2);
                    HMSLog.i("PushHttpClient", "close connection");
                    return null;
                } catch (Exception e6) {
                    httpURLConnection2 = httpURLConnection;
                    bufferedOutputStream2 = null;
                    str4 = null;
                    bufferedInputStream2 = null;
                    StringBuilder sb4 = new StringBuilder();
                    String str11 = httpURLConnection2;
                    sb4.append("http execute encounter unknown exception - http code:");
                    String str12 = httpURLConnection2;
                    sb4.append(i);
                    httpURLConnection4 = httpURLConnection2;
                    bufferedOutputStream4 = bufferedOutputStream2;
                    map = bufferedInputStream2;
                    HMSLog.w("PushHttpClient", sb4.toString());
                    str2 = httpURLConnection2;
                    bufferedOutputStream3 = bufferedOutputStream2;
                    IOUtil.closeSecure((OutputStream) bufferedOutputStream3);
                    IOUtil.closeSecure((InputStream) str4);
                    IOUtil.closeSecure((InputStream) bufferedInputStream2);
                    p.a((HttpURLConnection) str2);
                    HMSLog.i("PushHttpClient", "close connection");
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    str2 = null;
                    map2 = null;
                    HttpURLConnection httpURLConnection5 = httpURLConnection;
                    Map<String, String> map3 = map2;
                    str3 = str2;
                    bufferedOutputStream = bufferedOutputStream4;
                    httpURLConnection3 = httpURLConnection5;
                    bufferedInputStream = map3;
                    IOUtil.closeSecure((OutputStream) bufferedOutputStream);
                    IOUtil.closeSecure((InputStream) str3);
                    IOUtil.closeSecure((InputStream) bufferedInputStream);
                    p.a(httpURLConnection3);
                    HMSLog.i("PushHttpClient", "close connection");
                    throw th;
                }
                try {
                    BufferedInputStream bufferedInputStream3 = new BufferedInputStream(str4);
                    try {
                        String a2 = p.a((InputStream) bufferedInputStream3);
                        IOUtil.closeSecure((OutputStream) bufferedOutputStream);
                        IOUtil.closeSecure((InputStream) str4);
                        IOUtil.closeSecure((InputStream) bufferedInputStream3);
                        p.a(httpURLConnection);
                        HMSLog.i("PushHttpClient", "close connection");
                        return a2;
                    } catch (IOException e7) {
                        str6 = httpURLConnection;
                        bufferedOutputStream3 = bufferedOutputStream;
                        bufferedInputStream2 = bufferedInputStream3;
                        StringBuilder sb22 = new StringBuilder();
                        String str72 = str6;
                        sb22.append("http execute encounter IOException - http code:");
                        String str82 = str6;
                        sb22.append(i);
                        httpURLConnection4 = str6;
                        bufferedOutputStream4 = bufferedOutputStream3;
                        map = bufferedInputStream2;
                        HMSLog.w("PushHttpClient", sb22.toString());
                        str2 = str6;
                        IOUtil.closeSecure((OutputStream) bufferedOutputStream3);
                        IOUtil.closeSecure((InputStream) str4);
                        IOUtil.closeSecure((InputStream) bufferedInputStream2);
                        p.a((HttpURLConnection) str2);
                        HMSLog.i("PushHttpClient", "close connection");
                        return null;
                    } catch (RuntimeException e8) {
                        str5 = httpURLConnection;
                        bufferedOutputStream3 = bufferedOutputStream;
                        bufferedInputStream2 = bufferedInputStream3;
                        StringBuilder sb32 = new StringBuilder();
                        String str92 = str5;
                        sb32.append("http execute encounter RuntimeException - http code:");
                        String str102 = str5;
                        sb32.append(i);
                        httpURLConnection4 = str5;
                        bufferedOutputStream4 = bufferedOutputStream3;
                        map = bufferedInputStream2;
                        HMSLog.w("PushHttpClient", sb32.toString());
                        str2 = str5;
                        IOUtil.closeSecure((OutputStream) bufferedOutputStream3);
                        IOUtil.closeSecure((InputStream) str4);
                        IOUtil.closeSecure((InputStream) bufferedInputStream2);
                        p.a((HttpURLConnection) str2);
                        HMSLog.i("PushHttpClient", "close connection");
                        return null;
                    } catch (Exception e9) {
                        httpURLConnection2 = httpURLConnection;
                        bufferedOutputStream2 = bufferedOutputStream;
                        bufferedInputStream2 = bufferedInputStream3;
                        StringBuilder sb42 = new StringBuilder();
                        String str112 = httpURLConnection2;
                        sb42.append("http execute encounter unknown exception - http code:");
                        String str122 = httpURLConnection2;
                        sb42.append(i);
                        httpURLConnection4 = httpURLConnection2;
                        bufferedOutputStream4 = bufferedOutputStream2;
                        map = bufferedInputStream2;
                        HMSLog.w("PushHttpClient", sb42.toString());
                        str2 = httpURLConnection2;
                        bufferedOutputStream3 = bufferedOutputStream2;
                        IOUtil.closeSecure((OutputStream) bufferedOutputStream3);
                        IOUtil.closeSecure((InputStream) str4);
                        IOUtil.closeSecure((InputStream) bufferedInputStream2);
                        p.a((HttpURLConnection) str2);
                        HMSLog.i("PushHttpClient", "close connection");
                        return null;
                    } catch (Throwable th3) {
                        httpURLConnection3 = httpURLConnection;
                        str3 = str4;
                        th = th3;
                        bufferedInputStream = bufferedInputStream3;
                        IOUtil.closeSecure((OutputStream) bufferedOutputStream);
                        IOUtil.closeSecure((InputStream) str3);
                        IOUtil.closeSecure((InputStream) bufferedInputStream);
                        p.a(httpURLConnection3);
                        HMSLog.i("PushHttpClient", "close connection");
                        throw th;
                    }
                } catch (IOException e10) {
                    str6 = httpURLConnection;
                    bufferedOutputStream3 = bufferedOutputStream;
                    bufferedInputStream2 = null;
                    StringBuilder sb222 = new StringBuilder();
                    String str722 = str6;
                    sb222.append("http execute encounter IOException - http code:");
                    String str822 = str6;
                    sb222.append(i);
                    httpURLConnection4 = str6;
                    bufferedOutputStream4 = bufferedOutputStream3;
                    map = bufferedInputStream2;
                    HMSLog.w("PushHttpClient", sb222.toString());
                    str2 = str6;
                    IOUtil.closeSecure((OutputStream) bufferedOutputStream3);
                    IOUtil.closeSecure((InputStream) str4);
                    IOUtil.closeSecure((InputStream) bufferedInputStream2);
                    p.a((HttpURLConnection) str2);
                    HMSLog.i("PushHttpClient", "close connection");
                    return null;
                } catch (RuntimeException e11) {
                    str5 = httpURLConnection;
                    bufferedOutputStream3 = bufferedOutputStream;
                    bufferedInputStream2 = null;
                    StringBuilder sb322 = new StringBuilder();
                    String str922 = str5;
                    sb322.append("http execute encounter RuntimeException - http code:");
                    String str1022 = str5;
                    sb322.append(i);
                    httpURLConnection4 = str5;
                    bufferedOutputStream4 = bufferedOutputStream3;
                    map = bufferedInputStream2;
                    HMSLog.w("PushHttpClient", sb322.toString());
                    str2 = str5;
                    IOUtil.closeSecure((OutputStream) bufferedOutputStream3);
                    IOUtil.closeSecure((InputStream) str4);
                    IOUtil.closeSecure((InputStream) bufferedInputStream2);
                    p.a((HttpURLConnection) str2);
                    HMSLog.i("PushHttpClient", "close connection");
                    return null;
                } catch (Exception e12) {
                    httpURLConnection2 = httpURLConnection;
                    bufferedOutputStream2 = bufferedOutputStream;
                    bufferedInputStream2 = null;
                    StringBuilder sb422 = new StringBuilder();
                    String str1122 = httpURLConnection2;
                    sb422.append("http execute encounter unknown exception - http code:");
                    String str1222 = httpURLConnection2;
                    sb422.append(i);
                    httpURLConnection4 = httpURLConnection2;
                    bufferedOutputStream4 = bufferedOutputStream2;
                    map = bufferedInputStream2;
                    HMSLog.w("PushHttpClient", sb422.toString());
                    str2 = httpURLConnection2;
                    bufferedOutputStream3 = bufferedOutputStream2;
                    IOUtil.closeSecure((OutputStream) bufferedOutputStream3);
                    IOUtil.closeSecure((InputStream) str4);
                    IOUtil.closeSecure((InputStream) bufferedInputStream2);
                    p.a((HttpURLConnection) str2);
                    HMSLog.i("PushHttpClient", "close connection");
                    return null;
                } catch (Throwable th4) {
                    bufferedInputStream = null;
                    httpURLConnection3 = httpURLConnection;
                    str3 = str4;
                    th = th4;
                }
            } catch (IOException e13) {
                httpURLConnection = 0;
            } catch (RuntimeException e14) {
                httpURLConnection = 0;
            } catch (Exception e15) {
                httpURLConnection2 = null;
            } catch (Throwable th5) {
                th = th5;
                httpURLConnection = null;
                str2 = null;
                map2 = null;
            }
        } catch (Throwable th6) {
            th = th6;
            httpURLConnection = httpURLConnection4;
            map2 = map;
        }
    }

    private static HttpURLConnection a(Context context, String str, Map<String, String> map, String str2) throws Exception {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        a(context, httpURLConnection);
        httpURLConnection.setRequestMethod(str2);
        httpURLConnection.setConnectTimeout(15000);
        httpURLConnection.setReadTimeout(15000);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setRequestProperty("Content-type", "application/json; charset=UTF-8");
        httpURLConnection.setRequestProperty("Connection", "close");
        if (map != null) {
            if (map.size() < 1) {
                return httpURLConnection;
            }
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key != null && !TextUtils.isEmpty(key)) {
                    httpURLConnection.setRequestProperty(key, URLEncoder.encode(entry.getValue() == null ? "" : entry.getValue(), "UTF-8"));
                }
            }
        }
        return httpURLConnection;
    }

    private static void a(Context context, HttpURLConnection httpURLConnection) throws Exception {
        SecureSSLSocketFactory secureSSLSocketFactory;
        if (httpURLConnection instanceof HttpsURLConnection) {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnection;
            try {
                secureSSLSocketFactory = SecureSSLSocketFactory.getInstance(context);
            } catch (IOException e) {
                HMSLog.w("PushHttpClient", "Get SocketFactory IO Exception.");
                secureSSLSocketFactory = null;
            } catch (IllegalAccessException e2) {
                HMSLog.w("PushHttpClient", "Get SocketFactory Illegal Access Exception.");
                secureSSLSocketFactory = null;
            } catch (IllegalArgumentException e3) {
                HMSLog.w("PushHttpClient", "Get SocketFactory Illegal Argument Exception.");
                secureSSLSocketFactory = null;
            } catch (KeyStoreException e4) {
                HMSLog.w("PushHttpClient", "Get SocketFactory Key Store exception.");
                secureSSLSocketFactory = null;
            } catch (NoSuchAlgorithmException e5) {
                HMSLog.w("PushHttpClient", "Get SocketFactory Algorithm Exception.");
                secureSSLSocketFactory = null;
            } catch (GeneralSecurityException e6) {
                HMSLog.w("PushHttpClient", "Get SocketFactory General Security Exception.");
                secureSSLSocketFactory = null;
            }
            if (secureSSLSocketFactory == null) {
                throw new Exception("No ssl socket factory set.");
            }
            httpsURLConnection.setSSLSocketFactory(secureSSLSocketFactory);
            httpsURLConnection.setHostnameVerifier(SecureSSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
        }
    }
}
