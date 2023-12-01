package com.tencent.cloud.huiyansdkface.analytics;

import com.tencent.cloud.huiyansdkface.wehttp2.WeLog;
import com.tencent.cloud.huiyansdkface.wehttp2.WeOkHttp;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/analytics/b.class */
public class b {
    private static volatile b b;

    /* renamed from: a  reason: collision with root package name */
    WeOkHttp f21805a;

    private b() {
        WeOkHttp weOkHttp = new WeOkHttp();
        this.f21805a = weOkHttp;
        weOkHttp.config().timeout(14L, 14L, 14L).log(WeLog.Level.BODY, new WeLog.Logger() { // from class: com.tencent.cloud.huiyansdkface.analytics.b.1
            @Override // com.tencent.cloud.huiyansdkface.wehttp2.WeLog.Logger
            public final void log(String str) {
                WBSLogger.d("ReportWBAEvents", str, new Object[0]);
            }
        });
    }

    public static b a() {
        if (b == null) {
            synchronized (b.class) {
                try {
                    if (b == null) {
                        b = new b();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return b;
    }
}
