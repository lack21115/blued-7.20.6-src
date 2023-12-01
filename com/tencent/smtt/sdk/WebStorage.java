package com.tencent.smtt.sdk;

import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/sdk/WebStorage.class */
public class WebStorage {

    /* renamed from: a  reason: collision with root package name */
    private static WebStorage f38803a;

    @Deprecated
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/sdk/WebStorage$QuotaUpdater.class */
    public interface QuotaUpdater {
        void updateQuota(long j);
    }

    private static WebStorage a() {
        WebStorage webStorage;
        synchronized (WebStorage.class) {
            try {
                if (f38803a == null) {
                    f38803a = new WebStorage();
                }
                webStorage = f38803a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return webStorage;
    }

    public static WebStorage getInstance() {
        return a();
    }

    public void deleteAllData() {
        w a2 = w.a();
        if (a2 == null || !a2.b()) {
            android.webkit.WebStorage.getInstance().deleteAllData();
        } else {
            a2.c().n();
        }
    }

    public void deleteOrigin(String str) {
        w a2 = w.a();
        if (a2 == null || !a2.b()) {
            android.webkit.WebStorage.getInstance().deleteOrigin(str);
        } else {
            a2.c().e(str);
        }
    }

    public void getOrigins(ValueCallback<Map> valueCallback) {
        w a2 = w.a();
        if (a2 == null || !a2.b()) {
            android.webkit.WebStorage.getInstance().getOrigins(valueCallback);
        } else {
            a2.c().a(valueCallback);
        }
    }

    public void getQuotaForOrigin(String str, ValueCallback<Long> valueCallback) {
        w a2 = w.a();
        if (a2 == null || !a2.b()) {
            android.webkit.WebStorage.getInstance().getQuotaForOrigin(str, valueCallback);
        } else {
            a2.c().b(str, valueCallback);
        }
    }

    public void getUsageForOrigin(String str, ValueCallback<Long> valueCallback) {
        w a2 = w.a();
        if (a2 == null || !a2.b()) {
            android.webkit.WebStorage.getInstance().getUsageForOrigin(str, valueCallback);
        } else {
            a2.c().a(str, valueCallback);
        }
    }

    @Deprecated
    public void setQuotaForOrigin(String str, long j) {
        w a2 = w.a();
        if (a2 == null || !a2.b()) {
            android.webkit.WebStorage.getInstance().setQuotaForOrigin(str, j);
        } else {
            a2.c().a(str, j);
        }
    }
}
