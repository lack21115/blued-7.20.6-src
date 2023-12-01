package com.kwad.components.ad.reward.check;

import com.kwad.sdk.core.report.KSLoggerReporter;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/check/a.class */
public final class a {
    public static void a(AdTemplate adTemplate, int i, long j, int i2, String str) {
        KSLoggerReporter.i(new RewardCheckMonitorInfo(adTemplate.posId).setRequestStatus(2).setCheckType(i).setEnviType(0).setDataLoadInterval(j).setCode(i2).setErrorMsg(str).setCreativeId(com.kwad.sdk.core.response.a.a.D(d.cb(adTemplate))).toJson());
    }

    public static void c(AdTemplate adTemplate, int i) {
        KSLoggerReporter.i(new RewardCheckMonitorInfo(adTemplate.posId).setRequestStatus(1).setCheckType(i).setEnviType(0).setCreativeId(com.kwad.sdk.core.response.a.a.D(d.cb(adTemplate))).toJson());
    }
}
