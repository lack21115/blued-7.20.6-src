package com.kwad.components.ad.reward.monitor;

import android.os.SystemClock;
import com.kwad.sdk.core.report.KSLoggerReporter;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/monitor/a.class */
public final class a {
    public static void K(boolean z) {
        KSLoggerReporter.j(new RewardWebViewInfo().setEvent("ad_show").setSceneId(z ? "ad_reward" : "ad_fullscreen").toJson());
    }

    public static void a(AdTemplate adTemplate, int i, int i2, boolean z) {
        AdInfo cb = d.cb(adTemplate);
        KSLoggerReporter.k(new RewardMonitorInfo(adTemplate.posId).setCreativeId(com.kwad.sdk.core.response.a.a.D(cb)).setRewardType(!z ? 1 : 0).setTaskType(i).setTaskStep(i2).setVideoUrl(com.kwad.sdk.core.response.a.a.E(cb)).setVideoDuration(com.kwad.sdk.core.response.a.a.F(cb) * 1000).toJson());
    }

    public static void a(boolean z, int i, String str, long j) {
        KSLoggerReporter.a(z, new RewardMonitorInfo(j).setLoadStatus(4).setErrorCode(i).setErrorMsg(str).toJson(), com.kwai.adclient.kscommerciallogger.model.a.aEc);
    }

    public static void a(boolean z, long j) {
        KSLoggerReporter.a(z, new RewardMonitorInfo(j).setLoadStatus(1).toJson(), com.kwai.adclient.kscommerciallogger.model.a.aEg);
    }

    public static void a(boolean z, AdTemplate adTemplate) {
        AdInfo cb = d.cb(adTemplate);
        KSLoggerReporter.b(z, new RewardMonitorInfo(adTemplate.posId).setPageStatus(3).setLoadType(adTemplate.isLoadFromCache() ? 2 : 1).setDownloadType(adTemplate.getDownloadType()).setDownloadSize(adTemplate.getDownloadSize()).setCreativeId(com.kwad.sdk.core.response.a.a.D(cb)).setVideoUrl(com.kwad.sdk.core.response.a.a.E(cb)).setVideoDuration(com.kwad.sdk.core.response.a.a.F(cb) * 1000).toJson());
    }

    public static void a(boolean z, AdTemplate adTemplate, int i, long j) {
        long loadDataTime = (j <= 0 || adTemplate.getLoadDataTime() <= 0) ? -1L : adTemplate.getLoadDataTime() - j;
        int i2 = 1;
        if (a(loadDataTime)) {
            loadDataTime = -1;
        }
        AdInfo cb = d.cb(adTemplate);
        RewardMonitorInfo loadStatus = new RewardMonitorInfo(adTemplate.posId).setLoadStatus(2);
        if (adTemplate.isLoadFromCache()) {
            i2 = 2;
        }
        KSLoggerReporter.a(z, loadStatus.setLoadType(i2).setAdCount(i).setLoadDataDuration(loadDataTime).setCreativeId(com.kwad.sdk.core.response.a.a.D(cb)).setVideoUrl(com.kwad.sdk.core.response.a.a.E(cb)).setVideoDuration(com.kwad.sdk.core.response.a.a.F(cb) * 1000).toJson(), com.kwai.adclient.kscommerciallogger.model.a.aEg);
    }

    public static void a(boolean z, AdTemplate adTemplate, long j) {
        if (adTemplate.getLoadDataTime() <= 0 || adTemplate.getDownloadFinishTime() <= 0) {
            return;
        }
        long loadDataTime = adTemplate.getLoadDataTime();
        long downloadFinishTime = adTemplate.getDownloadFinishTime();
        AdInfo cb = d.cb(adTemplate);
        int i = 1;
        RewardMonitorInfo pageStatus = new RewardMonitorInfo(adTemplate.posId).setPageStatus(1);
        if (adTemplate.isLoadFromCache()) {
            i = 2;
        }
        KSLoggerReporter.b(z, pageStatus.setLoadType(i).setDataLoadInterval(j - loadDataTime).setDataDownloadInterval(j - downloadFinishTime).setDownloadType(adTemplate.getDownloadType()).setDownloadSize(adTemplate.getDownloadSize()).setCreativeId(com.kwad.sdk.core.response.a.a.D(cb)).setVideoUrl(com.kwad.sdk.core.response.a.a.E(cb)).setVideoDuration(com.kwad.sdk.core.response.a.a.F(cb) * 1000).toJson());
    }

    public static void a(boolean z, AdTemplate adTemplate, long j, int i, long j2) {
        AdInfo cb = d.cb(adTemplate);
        KSLoggerReporter.c(z, new RewardMonitorInfo(adTemplate.posId).setLoadType(adTemplate.isLoadFromCache() ? 2 : 1).setCurrentDuration(j).setErrorCode(i).setErrorMsg(String.valueOf(j2)).setDownloadType(adTemplate.getDownloadType()).setDownloadSize(adTemplate.getDownloadSize()).setCreativeId(com.kwad.sdk.core.response.a.a.D(cb)).setVideoUrl(com.kwad.sdk.core.response.a.a.E(cb)).setVideoDuration(com.kwad.sdk.core.response.a.a.F(cb) * 1000).toJson());
    }

    public static void a(boolean z, AdTemplate adTemplate, String str) {
        AdInfo cb = d.cb(adTemplate);
        KSLoggerReporter.a(z, new RewardMonitorInfo(adTemplate.posId).setLoadType(adTemplate.isLoadFromCache() ? 2 : 1).setDownloadType(adTemplate.getDownloadType()).setDownloadSize(adTemplate.getDownloadSize()).setCreativeId(com.kwad.sdk.core.response.a.a.D(cb)).setVideoUrl(com.kwad.sdk.core.response.a.a.E(cb)).setVideoDuration(com.kwad.sdk.core.response.a.a.F(cb) * 1000).setErrorMsg(str).toJson());
    }

    public static void a(boolean z, String str) {
        KSLoggerReporter.j(new RewardWebViewInfo().setPageType(str).setEvent("webview_init").setSceneId(z ? "ad_reward" : "ad_fullscreen").toJson());
    }

    public static void a(boolean z, String str, String str2) {
        KSLoggerReporter.j(new RewardWebViewInfo().setPageType(str).setEvent("webview_load_url").setSceneId(z ? "ad_reward" : "ad_fullscreen").setUrl(str2).toJson());
    }

    public static void a(boolean z, String str, String str2, long j) {
        KSLoggerReporter.j(new RewardWebViewInfo().setPageType(str).setEvent("webview_load_finish").setSceneId(z ? "ad_reward" : "ad_fullscreen").setDurationMs(j).setUrl(str2).toJson());
    }

    public static void a(boolean z, String str, String str2, long j, int i) {
        KSLoggerReporter.j(new RewardWebViewInfo().setPageType(str).setEvent("webview_timeout").setSceneId(z ? "ad_reward" : "ad_fullscreen").setDurationMs(j).setTimeType(i).setUrl(str2).toJson());
    }

    private static boolean a(long... jArr) {
        int length = jArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return false;
            }
            if (jArr[i2] >= 60000) {
                return true;
            }
            i = i2 + 1;
        }
    }

    public static void b(boolean z, AdTemplate adTemplate, int i, long j) {
        adTemplate.setDownloadFinishTime(SystemClock.elapsedRealtime());
        AdInfo cb = d.cb(adTemplate);
        long loadDataTime = adTemplate.getLoadDataTime() - j;
        long downloadFinishTime = adTemplate.getDownloadFinishTime() - adTemplate.getLoadDataTime();
        long downloadFinishTime2 = adTemplate.getDownloadFinishTime() - j;
        int i2 = 1;
        long j2 = loadDataTime;
        long j3 = downloadFinishTime;
        long j4 = downloadFinishTime2;
        if (a(loadDataTime, downloadFinishTime, downloadFinishTime2)) {
            j2 = -1;
            j3 = -1;
            j4 = -1;
        }
        RewardMonitorInfo loadStatus = new RewardMonitorInfo(adTemplate.posId).setLoadStatus(3);
        if (adTemplate.isLoadFromCache()) {
            i2 = 2;
        }
        KSLoggerReporter.a(z, loadStatus.setLoadType(i2).setAdCount(i).setLoadDataDuration(j2).setDownloadDuration(j3).setTotalDuration(j4).setDownloadType(adTemplate.getDownloadType()).setDownloadSize(adTemplate.getDownloadSize()).setCreativeId(com.kwad.sdk.core.response.a.a.D(cb)).setVideoUrl(com.kwad.sdk.core.response.a.a.E(cb)).setVideoDuration(com.kwad.sdk.core.response.a.a.F(cb) * 1000).toJson(), com.kwai.adclient.kscommerciallogger.model.a.aEg);
    }

    public static void b(boolean z, AdTemplate adTemplate, long j) {
        long elapsedRealtime;
        if (j == 0 || adTemplate.getLoadDataTime() <= 0 || adTemplate.getDownloadFinishTime() <= 0) {
            return;
        }
        int i = 1;
        if (j(j)) {
            elapsedRealtime = -1;
        } else {
            elapsedRealtime = SystemClock.elapsedRealtime() - j;
            if (a(elapsedRealtime)) {
                elapsedRealtime = -1;
            }
        }
        AdInfo cb = d.cb(adTemplate);
        RewardMonitorInfo pageStatus = new RewardMonitorInfo(adTemplate.posId).setPageStatus(2);
        if (adTemplate.isLoadFromCache()) {
            i = 2;
        }
        KSLoggerReporter.b(z, pageStatus.setLoadType(i).setRenderDuration(elapsedRealtime).setDownloadType(adTemplate.getDownloadType()).setDownloadSize(adTemplate.getDownloadSize()).setCreativeId(com.kwad.sdk.core.response.a.a.D(cb)).setVideoUrl(com.kwad.sdk.core.response.a.a.E(cb)).setVideoDuration(com.kwad.sdk.core.response.a.a.F(cb) * 1000).toJson());
    }

    private static boolean j(long j) {
        return j == -1;
    }
}
