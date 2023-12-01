package com.umeng.commonsdk.stateless;

import android.content.Context;
import android.text.TextUtils;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.umeng.analytics.pro.bh;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.statistics.SdkVersion;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.common.ULog;
import java.io.File;
import java.io.OutputStream;
import java.net.URL;
import java.security.SecureRandom;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLHandshakeException;
import org.apache.http.conn.ssl.SSLSocketFactory;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/commonsdk/stateless/c.class */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private String f40894a = "10.0.0.172";
    private int b = 80;

    /* renamed from: c  reason: collision with root package name */
    private Context f40895c;

    public c(Context context) {
        this.f40895c = context;
    }

    private void a() {
        String imprintProperty = UMEnvelopeBuild.imprintProperty(this.f40895c, "sl_domain_p", "");
        if (TextUtils.isEmpty(imprintProperty)) {
            return;
        }
        a.i = DataHelper.assembleStatelessURL(imprintProperty);
    }

    private void b() {
        String imprintProperty = UMEnvelopeBuild.imprintProperty(this.f40895c, "sl_domain_p", "");
        String imprintProperty2 = UMEnvelopeBuild.imprintProperty(this.f40895c, "oversea_sl_domain_p", "");
        if (!TextUtils.isEmpty(imprintProperty)) {
            a.h = DataHelper.assembleStatelessURL(imprintProperty);
        }
        if (!TextUtils.isEmpty(imprintProperty2)) {
            a.k = DataHelper.assembleStatelessURL(imprintProperty2);
        }
        a.i = a.k;
        if (TextUtils.isEmpty(com.umeng.commonsdk.statistics.b.b)) {
            return;
        }
        if (com.umeng.commonsdk.statistics.b.b.startsWith("460") || com.umeng.commonsdk.statistics.b.b.startsWith("461")) {
            a.i = a.h;
        }
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v26, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r8v0, types: [javax.net.ssl.HttpsURLConnection, java.lang.String] */
    public boolean a(byte[] bArr, String str, String str2, String str3) {
        HttpsURLConnection httpsURLConnection;
        HttpsURLConnection httpsURLConnection2;
        boolean z = false;
        boolean z2 = false;
        if (bArr == null || str == 0) {
            ULog.i("walle", "[stateless] sendMessage, envelopeByte == null || path == null ");
            return false;
        }
        if (SdkVersion.SDK_TYPE == 0) {
            a();
        } else {
            a.h = a.k;
            b();
        }
        String str4 = a.i;
        if (!com.umeng.commonsdk.vchannel.a.f40970c.equalsIgnoreCase(str)) {
            str2 = str4;
        }
        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 无状态收数域名：" + str2);
        OutputStream outputStream = null;
        OutputStream outputStream2 = null;
        try {
            try {
                httpsURLConnection2 = (HttpsURLConnection) new URL(str2 + File.separator + ((String) str)).openConnection();
                outputStream = null;
                outputStream2 = null;
            } catch (SSLHandshakeException e) {
                e = e;
                httpsURLConnection = null;
            } catch (Throwable th) {
                th = th;
                httpsURLConnection = null;
            }
            try {
                httpsURLConnection2.setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
                SSLContext sSLContext = SSLContext.getInstance("TLS");
                sSLContext.init(null, null, new SecureRandom());
                httpsURLConnection2.setSSLSocketFactory(sSLContext.getSocketFactory());
                httpsURLConnection2.setRequestProperty("X-Umeng-UTC", String.valueOf(System.currentTimeMillis()));
                httpsURLConnection2.setRequestProperty("Msg-Type", "envelope/json");
                StringBuilder sb = new StringBuilder();
                sb.append(bh.aT);
                sb.append(str3);
                httpsURLConnection2.setRequestProperty("Content-Type", sb.toString());
                httpsURLConnection2.setRequestProperty("SM-IMP", "1");
                httpsURLConnection2.setRequestProperty("User-Agent", DeviceConfig.getCustomAgt());
                httpsURLConnection2.setConnectTimeout(30000);
                httpsURLConnection2.setReadTimeout(30000);
                httpsURLConnection2.setRequestMethod("POST");
                httpsURLConnection2.setDoOutput(true);
                httpsURLConnection2.setDoInput(true);
                httpsURLConnection2.setUseCaches(false);
                OutputStream outputStream3 = httpsURLConnection2.getOutputStream();
                outputStream3.write(bArr);
                outputStream3.flush();
                httpsURLConnection2.connect();
                if (httpsURLConnection2.getResponseCode() == 200) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("--->>> send stateless message success : ");
                    sb2.append(a.i);
                    sb2.append(BridgeUtil.SPLIT_MARK);
                    sb2.append((String) str);
                    outputStream = outputStream3;
                    outputStream2 = outputStream3;
                    UMRTLog.i(UMRTLog.RTLOG_TAG, sb2.toString());
                    z2 = true;
                }
                if (outputStream3 != null) {
                    try {
                        outputStream3.close();
                    } catch (Exception e2) {
                    }
                }
                z = z2;
            } catch (SSLHandshakeException e3) {
                e = e3;
                httpsURLConnection = httpsURLConnection2;
                MLog.e("SSLHandshakeException, Failed to send message.", e);
                if (outputStream2 != null) {
                    try {
                        outputStream2.close();
                    } catch (Exception e4) {
                    }
                }
                if (httpsURLConnection != null) {
                    z2 = false;
                    try {
                        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> stateless: disconnect connection.");
                        httpsURLConnection.disconnect();
                        return z2;
                    } catch (Throwable th2) {
                        return z2;
                    }
                }
                return z;
            } catch (Throwable th3) {
                th = th3;
                httpsURLConnection = httpsURLConnection2;
                MLog.e("Exception,Failed to send message.", th);
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (Exception e5) {
                    }
                }
                if (httpsURLConnection != null) {
                    z2 = false;
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> stateless: disconnect connection.");
                    httpsURLConnection.disconnect();
                    return z2;
                }
                return z;
            }
            if (httpsURLConnection2 != null) {
                httpsURLConnection = httpsURLConnection2;
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> stateless: disconnect connection.");
                httpsURLConnection.disconnect();
                return z2;
            }
            return z;
        } catch (Throwable th4) {
            if (str2 != null) {
                try {
                    str2.close();
                } catch (Exception e6) {
                }
            }
            if (str != 0) {
                try {
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> stateless: disconnect connection.");
                    str.disconnect();
                } catch (Throwable th5) {
                }
            }
            throw th4;
        }
    }
}
