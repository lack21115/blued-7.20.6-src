package com.kwad.components.splash.monitor;

import android.os.SystemClock;
import com.kwad.components.core.response.model.AdResultData;
import com.kwad.sdk.core.report.KSLoggerReporter;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/splash/monitor/a.class */
public class a {
    private static volatile a Ye;

    public static void B(long j) {
        KSLoggerReporter.l(new SplashMonitorInfo(j).setStatus(1).toJson());
    }

    public static void C(long j) {
        KSLoggerReporter.m(new SplashMonitorInfo(j).setStatus(1).toJson());
    }

    public static void T(AdTemplate adTemplate) {
        KSLoggerReporter.l(new SplashMonitorInfo(adTemplate.posId).setType(adTemplate.notNetworkRequest ? 2 : 1).setStatus(2).setLoadDataTime(adTemplate.loadDataTime).setPreloadId(com.kwad.sdk.core.response.a.a.aS(d.cb(adTemplate))).toJson());
    }

    public static void U(AdTemplate adTemplate) {
        boolean aV = com.kwad.sdk.core.response.a.a.aV(d.cb(adTemplate));
        int i = 1;
        SplashMonitorInfo status = new SplashMonitorInfo(adTemplate.posId).setStatus(1);
        if (aV) {
            i = 2;
        }
        KSLoggerReporter.p(status.setType(i).toJson());
    }

    public static void V(AdTemplate adTemplate) {
        AdInfo cb = d.cb(adTemplate);
        KSLoggerReporter.p(new SplashMonitorInfo(adTemplate.posId).setStatus(4).setCreativeId(com.kwad.sdk.core.response.a.a.D(cb)).setType(com.kwad.sdk.core.response.a.a.aV(cb) ? 2 : 1).toJson());
    }

    public static void a(AdInfo adInfo, int i, String str, long j) {
        SplashMonitorInfo errorMsg = new SplashMonitorInfo(j).setStatus(2).setPreloadId(com.kwad.sdk.core.response.a.a.aS(adInfo)).setCreativeId(com.kwad.sdk.core.response.a.a.D(adInfo)).setFailUrl(com.kwad.sdk.core.response.a.a.aU(adInfo) ? com.kwad.sdk.core.response.a.a.E(adInfo) : com.kwad.sdk.core.response.a.a.aM(adInfo).materialUrl).setErrorCode(i).setErrorMsg(str);
        int i2 = 2;
        if (com.kwad.sdk.core.response.a.a.aU(adInfo)) {
            i2 = 1;
        }
        KSLoggerReporter.n(errorMsg.setMaterialType(i2).setType(1).toJson());
    }

    public static void a(AdInfo adInfo, long j, int i, long j2) {
        File aX = com.kwad.sdk.core.diskcache.a.a.vs().aX(com.kwad.sdk.core.response.a.a.aU(adInfo) ? com.kwad.sdk.core.response.a.a.E(adInfo) : com.kwad.sdk.core.response.a.a.aM(adInfo).materialUrl);
        int i2 = 1;
        SplashMonitorInfo size = new SplashMonitorInfo(j2).setStatus(1).setPreloadId(com.kwad.sdk.core.response.a.a.aS(adInfo)).setCostTime(j).setCacheValidTime(adInfo.adPreloadInfo.validityPeriod * 1000).setSize((aX == null || !aX.exists()) ? 0L : aX.length());
        if (!com.kwad.sdk.core.response.a.a.aU(adInfo)) {
            i2 = 2;
        }
        KSLoggerReporter.n(size.setMaterialType(i2).setType(i).setCreativeId(com.kwad.sdk.core.response.a.a.D(adInfo)).toJson());
    }

    public static void a(String str, boolean z, int i, String str2, long j) {
        KSLoggerReporter.l(new SplashMonitorInfo(j).setStatus(4).setType(z ? 2 : 1).setErrorCode(i).setPreloadId(str).setErrorMsg(str2).toJson());
    }

    public static void a(List<AdTemplate> list, long j, long j2) {
        ArrayList arrayList = new ArrayList();
        for (AdTemplate adTemplate : list) {
            arrayList.add(com.kwad.sdk.core.response.a.a.aS(d.cb(adTemplate)));
        }
        KSLoggerReporter.m(new SplashMonitorInfo(j2).setStatus(2).setIds(arrayList).setLoadDataTime(j).setCount(list.size()).toJson());
    }

    public static void b(int i, String str, long j) {
        KSLoggerReporter.m(new SplashMonitorInfo(j).setStatus(3).setErrorCode(i).setErrorMsg(str).toJson());
    }

    public static void b(AdTemplate adTemplate, int i, long j) {
        long elapsedRealtime = SystemClock.elapsedRealtime() - j;
        KSLoggerReporter.l(new SplashMonitorInfo(adTemplate.posId).setType(adTemplate.notNetworkRequest ? 2 : 1).setStatus(3).setLoadDataTime(adTemplate.loadDataTime).setCheckStatus(i).setCheckDataTime(elapsedRealtime).setLoadAndCheckDataTime(adTemplate.loadDataTime + elapsedRealtime).setPreloadId(com.kwad.sdk.core.response.a.a.aS(d.cb(adTemplate))).toJson());
    }

    public static void c(AdTemplate adTemplate, int i, long j) {
        long elapsedRealtime = SystemClock.elapsedRealtime() - j;
        KSLoggerReporter.l(new SplashMonitorInfo(adTemplate.posId).setType(adTemplate.notNetworkRequest ? 2 : 1).setStatus(5).setCheckStatus(i).setLoadDataTime(adTemplate.loadDataTime).setCheckDataTime(elapsedRealtime).setLoadAndCheckDataTime(adTemplate.loadDataTime + elapsedRealtime).setPreloadId(com.kwad.sdk.core.response.a.a.aS(d.cb(adTemplate))).toJson());
    }

    public static void d(AdTemplate adTemplate, int i, String str) {
        AdInfo cb = d.cb(adTemplate);
        boolean aV = com.kwad.sdk.core.response.a.a.aV(cb);
        KSLoggerReporter.p(new SplashMonitorInfo(adTemplate.posId).setStatus(3).setCreativeId(com.kwad.sdk.core.response.a.a.D(cb)).setPreloadId(com.kwad.sdk.core.response.a.a.aS(cb)).setType(aV ? 2 : 1).setFailUrl(aV ? com.kwad.sdk.core.response.a.a.aM(cb).materialUrl : com.kwad.sdk.core.response.a.a.E(cb)).setErrorCode(i).setErrorMsg(str).toJson());
    }

    public static void f(AdTemplate adTemplate, long j) {
        AdInfo cb = d.cb(adTemplate);
        KSLoggerReporter.p(new SplashMonitorInfo(adTemplate.posId).setStatus(5).setType(com.kwad.sdk.core.response.a.a.aV(cb) ? 2 : 1).setCostTime(j).setCreativeId(com.kwad.sdk.core.response.a.a.D(cb)).setPreloadId(com.kwad.sdk.core.response.a.a.aS(cb)).toJson());
    }

    public static void g(AdTemplate adTemplate, long j) {
        AdInfo cb = d.cb(adTemplate);
        boolean aV = com.kwad.sdk.core.response.a.a.aV(cb);
        int i = 2;
        SplashMonitorInfo status = new SplashMonitorInfo(adTemplate.posId).setStatus(2);
        if (!aV) {
            i = 1;
        }
        KSLoggerReporter.p(status.setType(i).setCostTime(j).setCreativeId(com.kwad.sdk.core.response.a.a.D(cb)).setPreloadId(com.kwad.sdk.core.response.a.a.aS(cb)).toJson());
    }

    public static void h(AdResultData adResultData) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (AdTemplate adTemplate : adResultData.getAdTemplateList()) {
            arrayList.add(String.valueOf(com.kwad.sdk.core.response.a.a.D(d.cb(adTemplate))));
            arrayList2.add(com.kwad.sdk.core.response.a.a.aS(d.cb(adTemplate)));
        }
        KSLoggerReporter.o(new SplashMonitorInfo(adResultData.getPosId()).setTotalCount(adResultData.getAdTemplateList().size()).setCreativeIds(arrayList).setPreloadIds(arrayList2).toJson());
    }

    public static void h(AdTemplate adTemplate, long j) {
        if (j <= 0) {
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        AdInfo cb = d.cb(adTemplate);
        KSLoggerReporter.p(new SplashMonitorInfo(adTemplate.posId).setStatus(6).setCreativeId(com.kwad.sdk.core.response.a.a.D(cb)).setLoadDataTime(elapsedRealtime - j).setType(com.kwad.sdk.core.response.a.a.aV(cb) ? 2 : 1).toJson());
    }

    public static a rY() {
        if (Ye == null) {
            synchronized (a.class) {
                try {
                    if (Ye == null) {
                        Ye = new a();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return Ye;
    }
}
