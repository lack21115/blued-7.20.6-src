package com.kwad.components.ad.splashscreen.monitor;

import com.kwad.sdk.core.report.KSLoggerReporter;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/splashscreen/monitor/a.class */
public final class a {
    public static void a(String str, long j, int i, String str2) {
        KSLoggerReporter.j(new SplashWebMonitorInfo().setEvent("webview_timeout").setSceneId("ad_splash").setDurationMs(j).setTimeType(i).setUrl(str).setErrorMsg(str2).toJson());
    }

    public static void aa(String str) {
        KSLoggerReporter.j(new SplashWebMonitorInfo().setEvent("webview_load_url").setSceneId("ad_splash").setUrl(str).toJson());
    }

    public static void d(String str, long j) {
        KSLoggerReporter.j(new SplashWebMonitorInfo().setEvent("webview_load_finish").setSceneId("ad_splash").setDurationMs(j).setUrl(str).toJson());
    }

    public static void kC() {
        KSLoggerReporter.j(new SplashWebMonitorInfo().setEvent("ad_show").setSceneId("ad_splash").toJson());
    }

    public static void kD() {
        KSLoggerReporter.j(new SplashWebMonitorInfo().setEvent("webview_init").setSceneId("ad_splash").toJson());
    }
}
