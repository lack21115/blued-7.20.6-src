package com.kwad.sdk.crash.report.request;

import com.kwad.sdk.core.network.d;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import com.kwad.sdk.crash.report.ReportEvent;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/crash/report/request/a.class */
public final class a extends d {
    public a(List<ReportEvent> list) {
        ReportEvent.StatPackage statPackage;
        putBody("eventList", list);
        if (com.kwad.sdk.crash.utils.c.b(list) || list.get(0) == null || (statPackage = list.get(0).statPackage) == null || statPackage.customStatEvent == null || !"perf-block".equals(statPackage.customStatEvent.key)) {
            return;
        }
        putBody("versionForKeep", ExceptionMessage.getSdkCrashVersionName("3.3.40", 1));
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public final String getUrl() {
        return com.kwad.sdk.c.sj();
    }
}
