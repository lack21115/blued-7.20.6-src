package com.kwad.components.ad.feed.monitor;

import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.core.report.KSLoggerReporter;
import com.kwad.sdk.core.report.o;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;
import com.kwai.adclient.kscommerciallogger.model.SubBusinessType;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/feed/monitor/a.class */
public final class a {
    public static void a(int i, long j) {
        c(new FeedPageInfo().setStatus(6).setAdNum(i).setLoadDataDuration(j).toJson());
    }

    public static void a(AdTemplate adTemplate, int i) {
        c(new FeedPageInfo().setStatus(7).setType(adTemplate.type).setMaterialType(com.kwad.sdk.core.response.a.a.aW(d.cb(adTemplate))).setRenderType(i).setExpectedRenderType(2).toJson());
    }

    public static void a(AdTemplate adTemplate, int i, int i2, String str, String str2, long j) {
        boolean z = true;
        if (i2 == 1 && adTemplate.mHasReportVideoLoad) {
            return;
        }
        if (i2 == 1) {
            adTemplate.mHasReportVideoLoad = true;
        }
        JSONObject json = new FeedPageInfo().setStatus(3).setType(adTemplate.type).setLoadStatus(i).setResourceLoadDuration(j).setMaterialType(i2).setMaterialUrl(str).setErrorMsg(str2).toJson();
        if (i != 2) {
            z = false;
        }
        a(json, z);
    }

    public static void a(AdTemplate adTemplate, int i, long j) {
        c(new FeedPageInfo().setStatus(8).setType(adTemplate.type).setMaterialType(com.kwad.sdk.core.response.a.a.aW(d.cb(adTemplate))).setRenderType(i).setConvertDuration(j).toJson());
    }

    public static void a(AdTemplate adTemplate, int i, long j, String str) {
        AdInfo cb = d.cb(adTemplate);
        a(new FeedPageInfo().setStatus(5).setType(adTemplate.type).setMaterialType(com.kwad.sdk.core.response.a.a.aW(cb)).setRenderType(i).setExpectedRenderType(2).setErrorMsg(str).setRenderDuration(j).setExtMsg(cb.adStyleInfo.feedAdInfo.toString()).toJson(), i != 2);
    }

    public static void a(String str, long j, int i) {
        KSLoggerReporter.j(new FeedWebViewInfo().setEvent("webview_timeout").setSceneId("ad_feed").setTimeType(i).setDurationMs(j).setUrl(str).toJson());
    }

    private static void a(JSONObject jSONObject, boolean z) {
        KSLoggerReporter.a(new o.a().cE(z ? ILoggerReporter.Category.ERROR_LOG : ILoggerReporter.Category.APM_LOG).b(BusinessType.AD_FEED).a(SubBusinessType.OTHER).a(com.kwai.adclient.kscommerciallogger.model.a.aEg).cF("ad_sdk_feed_load").A(jSONObject).xa());
    }

    public static void bg() {
        KSLoggerReporter.j(new FeedWebViewInfo().setEvent("ad_show").setSceneId("ad_feed").toJson());
    }

    public static void bh() {
        KSLoggerReporter.j(new FeedWebViewInfo().setEvent("webview_init").setSceneId("ad_feed").toJson());
    }

    public static void c(String str, long j) {
        KSLoggerReporter.j(new FeedWebViewInfo().setEvent("webview_load_finish").setSceneId("ad_feed").setDurationMs(j).setUrl(str).toJson());
    }

    private static void c(JSONObject jSONObject) {
        a(jSONObject, false);
    }

    public static void d(int i, String str) {
        a(new FeedPageInfo().setStatus(9).setErrorCode(i).setErrorMsg(str).toJson(), true);
    }

    public static void s(String str) {
        KSLoggerReporter.j(new FeedWebViewInfo().setEvent("webview_load_url").setSceneId("ad_feed").setUrl(str).toJson());
    }

    public static void w(int i) {
        c(new FeedPageInfo().setStatus(1).setAdNum(i).toJson());
    }

    public static void x(int i) {
        c(new FeedPageInfo().setStatus(2).setAdNum(i).toJson());
    }
}
