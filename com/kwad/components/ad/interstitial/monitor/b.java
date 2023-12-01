package com.kwad.components.ad.interstitial.monitor;

import android.os.SystemClock;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.core.report.KSLoggerReporter;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/interstitial/monitor/b.class */
public final class b {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/interstitial/monitor/b$a.class */
    public static final class a {
        private static final b jn = new b((byte) 0);
    }

    private b() {
        init();
    }

    /* synthetic */ b(byte b) {
        this();
    }

    public static void a(int i, String str, long j) {
        KSLoggerReporter.s(new InterstitialMonitorInfo(j).setStatus(5).setErrorCode(i).setErrorMsg(str).toJson());
    }

    public static void a(AdTemplate adTemplate, int i, String str) {
        AdInfo cb = d.cb(adTemplate);
        KSLoggerReporter.w(new InterstitialMonitorInfo(adTemplate.posId).setCreativeId(com.kwad.sdk.core.response.a.a.D(cb)).setVideoUrl(com.kwad.sdk.core.response.a.a.E(cb)).setDownloadType(adTemplate.getDownloadType()).setDownloadSize(adTemplate.getDownloadSize()).setVideoDuration(com.kwad.sdk.core.response.a.a.F(cb) * 1000).setStatus(2).setErrorMsg(str).setErrorCode(i).toJson());
    }

    public static void a(AdTemplate adTemplate, long j, boolean z) {
        if (j <= 0) {
            return;
        }
        adTemplate.loadDataTime = SystemClock.elapsedRealtime() - j;
        if (adTemplate.loadDataTime <= 0 || adTemplate.loadDataTime >= 60000) {
            return;
        }
        int i = 2;
        InterstitialMonitorInfo status = new InterstitialMonitorInfo(adTemplate.posId).setStatus(2);
        if (!z) {
            i = 1;
        }
        KSLoggerReporter.s(status.setType(i).setLoadDataTime(adTemplate.loadDataTime).setExpectedRenderType(com.kwad.sdk.core.response.a.b.bv(adTemplate)).toJson());
    }

    public static void a(AdTemplate adTemplate, String str) {
        AdInfo cb = d.cb(adTemplate);
        KSLoggerReporter.u(new InterstitialMonitorInfo(adTemplate.posId).setCreativeId(com.kwad.sdk.core.response.a.a.D(cb)).setVideoUrl(com.kwad.sdk.core.response.a.a.E(cb)).setDownloadSize(adTemplate.getDownloadSize()).setDownloadType(adTemplate.getDownloadType()).setVideoDuration(com.kwad.sdk.core.response.a.a.F(cb) * 1000).setStatus(2).setErrorMsg(str).toJson());
    }

    public static void b(AdTemplate adTemplate, int i) {
        long elapsedRealtime = SystemClock.elapsedRealtime() - adTemplate.adShowStartTimeStamp;
        if (adTemplate.adShowStartTimeStamp <= 0 || adTemplate.loadDataTime <= 0 || adTemplate.loadDataTime >= 60000 || elapsedRealtime <= 0 || elapsedRealtime >= 5000) {
            return;
        }
        KSLoggerReporter.s(new InterstitialMonitorInfo(adTemplate.posId).setStatus(4).setType(adTemplate.notNetworkRequest ? 2 : 1).setMaterialType(com.kwad.sdk.core.response.a.a.aW(d.cb(adTemplate))).setRenderDuration(elapsedRealtime).setRenderType(i).setExpectedRenderType(com.kwad.sdk.core.response.a.b.bv(adTemplate)).toJson());
    }

    public static void b(AdTemplate adTemplate, long j, boolean z) {
        if (j > 0 && com.kwad.sdk.core.response.a.a.aZ(d.cb(adTemplate))) {
            adTemplate.downloadDuration = SystemClock.elapsedRealtime() - j;
            if (adTemplate.downloadDuration <= 0 || adTemplate.downloadDuration >= 60000) {
                return;
            }
            adTemplate.notNetworkRequest = z;
            KSLoggerReporter.s(new InterstitialMonitorInfo(adTemplate.posId).setStatus(3).setType(adTemplate.notNetworkRequest ? 2 : 1).setDownloadDuration(adTemplate.downloadDuration).setDownloadSize(adTemplate.getDownloadSize()).setDownloadType(adTemplate.getDownloadType()).toJson());
        }
    }

    public static b cR() {
        return a.jn;
    }

    public static void g(long j) {
        KSLoggerReporter.s(new InterstitialMonitorInfo(j).setStatus(1).toJson());
    }

    public static void g(AdTemplate adTemplate) {
        KSLoggerReporter.t(new InterstitialMonitorInfo(adTemplate.posId).setDownloadType(adTemplate.getDownloadType()).setStatus(1).toJson());
    }

    public static void h(long j) {
        KSLoggerReporter.s(new InterstitialMonitorInfo(j).setStatus(6).toJson());
    }

    public static void h(AdTemplate adTemplate) {
        KSLoggerReporter.v(new InterstitialMonitorInfo(adTemplate.posId).setDownloadType(adTemplate.getDownloadType()).setStatus(1).toJson());
    }

    private static void init() {
        KsAdSDKImpl.get().getContext();
    }
}
