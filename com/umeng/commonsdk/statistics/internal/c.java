package com.umeng.commonsdk.statistics.internal;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.CoreProtocol;
import com.umeng.analytics.pro.l;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.statistics.SdkVersion;
import com.umeng.commonsdk.statistics.UMServerURL;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.UnknownHostException;
import java.security.SecureRandom;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLHandshakeException;
import org.apache.http.conn.ssl.SSLSocketFactory;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/commonsdk/statistics/internal/c.class */
public class c {
    private static boolean e = false;
    private static boolean f = false;
    private static boolean g = false;

    /* renamed from: a  reason: collision with root package name */
    private String f27241a = "10.0.0.172";
    private int b = 80;

    /* renamed from: c  reason: collision with root package name */
    private Context f27242c;
    private b d;

    public c(Context context) {
        this.f27242c = context;
    }

    private void a() {
        String imprintProperty = UMEnvelopeBuild.imprintProperty(this.f27242c, "domain_p", "");
        String imprintProperty2 = UMEnvelopeBuild.imprintProperty(this.f27242c, "domain_s", "");
        if (!TextUtils.isEmpty(imprintProperty)) {
            UMServerURL.DEFAULT_URL = DataHelper.assembleURL(imprintProperty);
        }
        if (!TextUtils.isEmpty(imprintProperty2)) {
            UMServerURL.SECONDARY_URL = DataHelper.assembleURL(imprintProperty2);
        }
        AnalyticsConstants.APPLOG_URL_LIST = new String[]{UMServerURL.DEFAULT_URL, UMServerURL.SECONDARY_URL};
    }

    private void b() {
        String imprintProperty = UMEnvelopeBuild.imprintProperty(this.f27242c, "domain_p", "");
        String imprintProperty2 = UMEnvelopeBuild.imprintProperty(this.f27242c, "domain_s", "");
        if (!TextUtils.isEmpty(imprintProperty)) {
            UMServerURL.DEFAULT_URL = DataHelper.assembleURL(imprintProperty);
        }
        if (!TextUtils.isEmpty(imprintProperty2)) {
            UMServerURL.SECONDARY_URL = DataHelper.assembleURL(imprintProperty2);
        }
        String imprintProperty3 = UMEnvelopeBuild.imprintProperty(this.f27242c, "oversea_domain_p", "");
        String imprintProperty4 = UMEnvelopeBuild.imprintProperty(this.f27242c, "oversea_domain_s", "");
        if (!TextUtils.isEmpty(imprintProperty3)) {
            UMServerURL.OVERSEA_DEFAULT_URL = DataHelper.assembleURL(imprintProperty3);
        }
        if (!TextUtils.isEmpty(imprintProperty4)) {
            UMServerURL.OVERSEA_SECONDARY_URL = DataHelper.assembleURL(imprintProperty4);
        }
        AnalyticsConstants.APPLOG_URL_LIST = new String[]{UMServerURL.OVERSEA_DEFAULT_URL, UMServerURL.OVERSEA_SECONDARY_URL};
        if (TextUtils.isEmpty(com.umeng.commonsdk.statistics.b.b)) {
            return;
        }
        if (com.umeng.commonsdk.statistics.b.b.startsWith("460") || com.umeng.commonsdk.statistics.b.b.startsWith("461")) {
            AnalyticsConstants.APPLOG_URL_LIST = new String[]{UMServerURL.DEFAULT_URL, UMServerURL.SECONDARY_URL};
        }
    }

    private void c() {
        if (g) {
            return;
        }
        ImprintHandler.getImprintService(this.f27242c).registImprintCallback(AnalyticsConstants.CFG_FIELD_KEY, new UMImprintChangeCallback() { // from class: com.umeng.commonsdk.statistics.internal.c.1
            @Override // com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback
            public void onImprintValueChanged(String str, String str2) {
                if (FieldManager.b()) {
                    FieldManager.a().a(c.this.f27242c, str2);
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> apply imprint change and exit: key=" + str + "; value= " + str2);
                    UMWorkDispatch.sendEvent(c.this.f27242c, com.umeng.commonsdk.internal.a.w, com.umeng.commonsdk.internal.b.a(c.this.f27242c).a(), null);
                }
            }
        });
        g = true;
    }

    private void d() {
        if (f) {
            return;
        }
        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 注册零号报文 imprint 应答处理回调。");
        ImprintHandler.getImprintService(this.f27242c).registPreProcessCallback(AnalyticsConstants.ZERO_RESPONSE_FLAG, new UMImprintPreProcessCallback() { // from class: com.umeng.commonsdk.statistics.internal.c.2
            @Override // com.umeng.commonsdk.statistics.internal.UMImprintPreProcessCallback
            public boolean onPreProcessImprintKey(String str, String str2) {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> onImprintValueChanged: key=" + str + "; value= " + str2);
                FieldManager.a().a(c.this.f27242c);
                UMWorkDispatch.sendEvent(c.this.f27242c, com.umeng.commonsdk.internal.a.s, com.umeng.commonsdk.internal.b.a(c.this.f27242c).a(), null);
                ImprintHandler.getImprintService(c.this.f27242c).a(AnalyticsConstants.ZERO_RESPONSE_FLAG);
                return true;
            }
        });
        ImprintHandler.getImprintService(this.f27242c).registImprintCallback(AnalyticsConstants.CFG_FIELD_KEY, new UMImprintChangeCallback() { // from class: com.umeng.commonsdk.statistics.internal.c.3
            @Override // com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback
            public void onImprintValueChanged(String str, String str2) {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> first onImprintValueChanged: key=" + str + "; value= " + str2);
                FieldManager.a().a(c.this.f27242c, str2);
                UMWorkDispatch.sendEvent(c.this.f27242c, com.umeng.commonsdk.internal.a.s, com.umeng.commonsdk.internal.b.a(c.this.f27242c).a(), null);
                if (FieldManager.allow(com.umeng.commonsdk.utils.d.E)) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> recv zcfg response: foregound count timer enabled.");
                    if (!UMWorkDispatch.eventHasExist()) {
                        UMWorkDispatch.sendEventEx(c.this.f27242c, 8213, CoreProtocol.getInstance(c.this.f27242c), null, 0L);
                    }
                }
                if (FieldManager.allow(com.umeng.commonsdk.utils.d.F)) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> recv zcfg response: FirstResumeTrigger enabled.");
                    l.a(c.this.f27242c).b(c.this.f27242c);
                }
                ImprintHandler.getImprintService(c.this.f27242c).unregistImprintCallback(AnalyticsConstants.CFG_FIELD_KEY, this);
            }
        });
        f = true;
    }

    public void a(b bVar) {
        this.d = bVar;
    }

    /* JADX WARN: Not initialized variable reg: 12, insn: 0x024d: MOVE  (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r12 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:111:0x024d */
    /* JADX WARN: Not initialized variable reg: 13, insn: 0x0237: MOVE  (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r13 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:106:0x0237 */
    public byte[] a(byte[] bArr, String str) {
        HttpsURLConnection httpsURLConnection;
        OutputStream outputStream;
        OutputStream outputStream2;
        OutputStream outputStream3;
        OutputStream outputStream4;
        HttpsURLConnection httpsURLConnection2;
        try {
            try {
                if (this.d != null) {
                    this.d.onRequestStart();
                }
                httpsURLConnection2 = (HttpsURLConnection) new URL(str).openConnection();
                try {
                    boolean z = true;
                    if (!e) {
                        httpsURLConnection2.setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
                        SSLContext sSLContext = SSLContext.getInstance("TLS");
                        sSLContext.init(null, null, new SecureRandom());
                        httpsURLConnection2.setSSLSocketFactory(sSLContext.getSocketFactory());
                        e = true;
                    }
                    httpsURLConnection2.setRequestProperty("X-Umeng-UTC", String.valueOf(System.currentTimeMillis()));
                    httpsURLConnection2.setRequestProperty("X-Umeng-Sdk", a.a(this.f27242c).b());
                    httpsURLConnection2.setRequestProperty("Content-Type", a.a(this.f27242c).a());
                    httpsURLConnection2.setRequestProperty("Msg-Type", "envelope/json");
                    httpsURLConnection2.setRequestProperty("X-Umeng-Pro-Ver", "1.0.0");
                    httpsURLConnection2.setRequestProperty("SM-IMP", "1");
                    httpsURLConnection2.setRequestProperty("User-Agent", DeviceConfig.getCustomAgt());
                    httpsURLConnection2.setConnectTimeout(30000);
                    httpsURLConnection2.setReadTimeout(30000);
                    httpsURLConnection2.setRequestMethod("POST");
                    httpsURLConnection2.setDoOutput(true);
                    httpsURLConnection2.setDoInput(true);
                    httpsURLConnection2.setUseCaches(false);
                    outputStream4 = httpsURLConnection2.getOutputStream();
                    try {
                        outputStream4.write(bArr);
                        outputStream4.flush();
                        httpsURLConnection2.connect();
                        if (this.d != null) {
                            this.d.onRequestEnd();
                        }
                        int responseCode = httpsURLConnection2.getResponseCode();
                        String headerField = httpsURLConnection2.getHeaderField("Content-Type");
                        if (TextUtils.isEmpty(headerField) || !headerField.equalsIgnoreCase("application/thrift")) {
                            z = false;
                        }
                        boolean z2 = AnalyticsConstants.UM_DEBUG;
                        if (responseCode == 200 && z) {
                            InputStream inputStream = httpsURLConnection2.getInputStream();
                            try {
                                return HelperUtils.readStreamToByteArray(inputStream);
                            } finally {
                                HelperUtils.safeClose(inputStream);
                            }
                        }
                        if (outputStream4 != null) {
                            try {
                                outputStream4.close();
                            } catch (Exception e2) {
                                UMCrashManager.reportCrash(this.f27242c, e2);
                            }
                        }
                        if (httpsURLConnection2 != null) {
                            try {
                                httpsURLConnection2.getInputStream().close();
                            } catch (IOException e3) {
                            }
                            httpsURLConnection2.disconnect();
                            return null;
                        }
                        return null;
                    } catch (UnknownHostException e4) {
                        outputStream3 = outputStream4;
                        UMLog.aq("A_10200", 2, "\\|");
                        if (outputStream3 != null) {
                            try {
                                outputStream3.close();
                            } catch (Exception e5) {
                                UMCrashManager.reportCrash(this.f27242c, e5);
                            }
                        }
                        if (httpsURLConnection != null) {
                            try {
                                httpsURLConnection.getInputStream().close();
                            } catch (IOException e6) {
                            }
                            httpsURLConnection.disconnect();
                            return null;
                        }
                        return null;
                    } catch (SSLHandshakeException e7) {
                        outputStream2 = outputStream4;
                        UMLog.aq("A_10201", 2, "\\|");
                        if (outputStream2 != null) {
                            try {
                                outputStream2.close();
                            } catch (Exception e8) {
                                UMCrashManager.reportCrash(this.f27242c, e8);
                            }
                        }
                        if (httpsURLConnection != null) {
                            try {
                                httpsURLConnection.getInputStream().close();
                            } catch (IOException e9) {
                            }
                            httpsURLConnection.disconnect();
                            return null;
                        }
                        return null;
                    } catch (Throwable th) {
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (Exception e10) {
                                UMCrashManager.reportCrash(this.f27242c, e10);
                            }
                        }
                        if (httpsURLConnection != null) {
                            try {
                                httpsURLConnection.getInputStream().close();
                            } catch (IOException e11) {
                            }
                            httpsURLConnection.disconnect();
                            return null;
                        }
                        return null;
                    }
                } catch (UnknownHostException e12) {
                    outputStream3 = null;
                } catch (SSLHandshakeException e13) {
                    outputStream2 = null;
                } catch (Throwable th2) {
                    outputStream = null;
                }
            } catch (UnknownHostException e14) {
                httpsURLConnection = null;
                outputStream3 = null;
            } catch (SSLHandshakeException e15) {
                httpsURLConnection = null;
                outputStream2 = null;
            } catch (Throwable th3) {
                httpsURLConnection = null;
                outputStream = null;
            }
        } finally {
            if (outputStream4 != null) {
                try {
                    outputStream4.close();
                } catch (Exception e16) {
                    UMCrashManager.reportCrash(this.f27242c, e16);
                }
            }
            if (httpsURLConnection2 != null) {
                try {
                    httpsURLConnection2.getInputStream().close();
                } catch (IOException e17) {
                }
                httpsURLConnection2.disconnect();
            }
        }
    }

    public byte[] a(byte[] bArr, boolean z, boolean z2, String str) {
        byte[] bArr2;
        if (SdkVersion.SDK_TYPE == 0) {
            a();
        } else {
            UMServerURL.DEFAULT_URL = UMServerURL.OVERSEA_DEFAULT_URL;
            UMServerURL.SECONDARY_URL = UMServerURL.OVERSEA_SECONDARY_URL;
            b();
        }
        int i = 0;
        byte[] bArr3 = null;
        while (true) {
            bArr2 = bArr3;
            if (i >= AnalyticsConstants.APPLOG_URL_LIST.length) {
                break;
            }
            String str2 = AnalyticsConstants.APPLOG_URL_LIST[i];
            if (z2) {
                d();
            } else {
                c();
            }
            bArr3 = a(bArr, str2 + File.separator + str);
            if (bArr3 != null) {
                b bVar = this.d;
                bArr2 = bArr3;
                if (bVar != null) {
                    bVar.onRequestSucceed(z);
                    return bArr3;
                }
            } else {
                b bVar2 = this.d;
                if (bVar2 != null) {
                    bVar2.onRequestFailed();
                }
                i++;
            }
        }
        return bArr2;
    }
}
