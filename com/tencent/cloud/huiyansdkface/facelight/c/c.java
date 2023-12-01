package com.tencent.cloud.huiyansdkface.facelight.c;

import com.tencent.cloud.huiyansdkface.facelight.net.tools.HttpEventListener;
import com.tencent.cloud.huiyansdkface.normal.tools.WLogger;
import com.tencent.cloud.huiyansdkface.wehttp2.WeLog;
import com.tencent.cloud.huiyansdkface.wehttp2.WeOkHttp;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/c/c.class */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private WeOkHttp f21871a;

    private static String a(String str, String str2, boolean z) {
        return str;
    }

    public static String a(boolean z, boolean z2, boolean z3) {
        WLogger.d("HttpManager", "configBaseUrl");
        if (!z3) {
            return z2 ? a("https://idasc-kyc.tencentcloudapi.com", "https://idasc-kyc-test.tencentcloudapi.com", z) : a("https://miniprogram-kyc.tencentcloudapi.com", "https://miniprogram-kyc-test.tencentcloudapi.com", z);
        }
        WLogger.d("HttpManager", "retry,updatePlanBUrl");
        return z2 ? a("https://miniprogram-kyc.tencentcloudapi.com", "https://miniprogram-kyc-test.tencentcloudapi.com", z) : a("https://idasc-kyc.tencentcloudapi.com", "https://idasc-kyc-test.tencentcloudapi.com", z);
    }

    public WeOkHttp a() {
        WeOkHttp weOkHttp = this.f21871a;
        if (weOkHttp != null) {
            return weOkHttp;
        }
        WeOkHttp a2 = a(false);
        b(false, false, false);
        return a2;
    }

    public WeOkHttp a(boolean z) {
        this.f21871a = new WeOkHttp();
        this.f21871a.config().timeout(14L, 14L, 14L).log(new WeLog.Builder().setLevel(z ? WeLog.Level.BODY : WeLog.Level.NONE).setPrettyLog(true).setCutLongStr(true).setLogger(new WeLog.Logger() { // from class: com.tencent.cloud.huiyansdkface.facelight.c.c.1
            @Override // com.tencent.cloud.huiyansdkface.wehttp2.WeLog.Logger
            public void log(String str) {
                WLogger.d("WeHttp", str);
            }
        }).setLogWithTag(true)).cookieMemory().baseUrl("https://miniprogram-kyc.tencentcloudapi.com").supportTls12Before5(true).clientConfig().eventListenerFactory(HttpEventListener.FACTORY);
        return this.f21871a;
    }

    public void b(boolean z, boolean z2, boolean z3) {
        String a2 = a(z, z2, z3);
        WLogger.d("HttpManager", "baseUrl=" + a2);
        this.f21871a.config().baseUrl(a2);
    }
}
