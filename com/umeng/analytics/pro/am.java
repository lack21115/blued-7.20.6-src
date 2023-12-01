package com.umeng.analytics.pro;

import android.text.TextUtils;
import android.util.Log;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.SecureRandom;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/analytics/pro/am.class */
public class am {

    /* renamed from: a  reason: collision with root package name */
    private static HostnameVerifier f40623a;

    private static HostnameVerifier a() {
        if (f40623a == null) {
            f40623a = new HostnameVerifier() { // from class: com.umeng.analytics.pro.am.1
                @Override // javax.net.ssl.HostnameVerifier
                public boolean verify(String str, SSLSession sSLSession) {
                    if (TextUtils.isEmpty(str)) {
                        return false;
                    }
                    return "pre-ucc.umeng.com".equalsIgnoreCase(str) || "ucc.umeng.com".equalsIgnoreCase(str) || "aspect-upush.umeng.com".equalsIgnoreCase(str) || "pre-msg.umengcloud.com".equalsIgnoreCase(str);
                }
            };
        }
        return f40623a;
    }

    private static HttpsURLConnection a(String str, String str2, byte[] bArr) {
        HttpsURLConnection httpsURLConnection;
        try {
            httpsURLConnection = (HttpsURLConnection) new URL(str).openConnection();
            try {
                SSLContext sSLContext = SSLContext.getInstance("TLS");
                sSLContext.init(null, null, new SecureRandom());
                httpsURLConnection.setSSLSocketFactory(sSLContext.getSocketFactory());
                httpsURLConnection.setHostnameVerifier(a());
                httpsURLConnection.setRequestMethod("POST");
                httpsURLConnection.setConnectTimeout(15000);
                httpsURLConnection.setDoOutput(true);
                httpsURLConnection.setDoInput(true);
                httpsURLConnection.setReadTimeout(15000);
                httpsURLConnection.addRequestProperty("Content-Type", "application/octet-stream");
                httpsURLConnection.addRequestProperty(str2, UMConfigure.sAppkey);
                httpsURLConnection.connect();
                OutputStream outputStream = httpsURLConnection.getOutputStream();
                outputStream.write(bArr);
                outputStream.flush();
                outputStream.close();
                return httpsURLConnection;
            } catch (Exception e) {
                e = e;
                e.printStackTrace();
                return httpsURLConnection;
            }
        } catch (Exception e2) {
            e = e2;
            httpsURLConnection = null;
        }
    }

    public static byte[] a(String str, String str2) {
        return a(str, str2.getBytes());
    }

    public static byte[] a(String str, byte[] bArr) {
        byte[] bArr2;
        byte[] bArr3;
        try {
            HttpsURLConnection a2 = a(str, "ak", as.a(bArr, UMConfigure.sAppkey.getBytes()));
            if (a2 == null || a2.getResponseCode() != 200) {
                return null;
            }
            InputStream inputStream = a2.getInputStream();
            try {
                bArr2 = HelperUtils.readStreamToByteArray(inputStream);
            } catch (Throwable th) {
                th = th;
                bArr2 = null;
            }
            try {
                String headerField = a2.getHeaderField("ak");
                if (TextUtils.isEmpty(headerField)) {
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "ccg 应答不包含ak!");
                    bArr3 = null;
                } else {
                    bArr3 = as.a(bArr2, headerField.getBytes());
                }
                HelperUtils.safeClose(inputStream);
                return bArr3;
            } catch (Throwable th2) {
                th = th2;
                HelperUtils.safeClose(inputStream);
                byte[] bArr4 = bArr2;
                throw th;
            }
        } catch (Throwable th3) {
            return null;
        }
    }

    public static void b(String str, byte[] bArr) {
        HttpsURLConnection httpsURLConnection;
        byte[] bArr2;
        HttpURLConnection httpURLConnection = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                as.a(bArr, byteArrayOutputStream);
                bArr2 = as.a(byteArrayOutputStream.toByteArray(), UMConfigure.sAppkey.getBytes());
            } catch (Throwable th) {
                bArr2 = null;
            }
            httpsURLConnection = a(str, "appkey", bArr2);
            if (httpsURLConnection != null) {
                int responseCode = httpsURLConnection.getResponseCode();
                if (responseCode != 200) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("SC event report error, http error code: ");
                    sb.append(responseCode);
                    Log.e(UMRTLog.RTLOG_TAG, sb.toString());
                } else {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "SC event report successful.");
                }
            }
            if (httpsURLConnection == null) {
                return;
            }
        } catch (Throwable th2) {
            try {
                th2.printStackTrace();
                if (0 == 0) {
                    return;
                }
                httpsURLConnection = null;
            } catch (Throwable th3) {
                if (0 != 0) {
                    try {
                        httpURLConnection.disconnect();
                    } catch (Throwable th4) {
                    }
                }
                throw th3;
            }
        }
        try {
            httpsURLConnection.disconnect();
        } catch (Throwable th5) {
        }
    }
}
