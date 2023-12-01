package com.kwad.sdk;

import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.commercial.model.SDKInitMsg;
import com.kwad.sdk.core.report.KSLoggerReporter;
import com.kwad.sdk.utils.aw;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/f.class */
public final class f {
    private static int Yu;

    public static void F(long j) {
        long currentTimeMillis = j > 0 ? System.currentTimeMillis() - j : -1L;
        Yu++;
        final long j2 = currentTimeMillis;
        com.kwad.sdk.utils.g.execute(new aw() { // from class: com.kwad.sdk.f.1
            @Override // com.kwad.sdk.utils.aw
            public final void doTask() {
                KSLoggerReporter.a(ILoggerReporter.Category.APM_LOG, com.kwai.adclient.kscommerciallogger.model.a.aEe, new SDKInitMsg().setLaunchIntervalTime(j2).setInitCount(f.Yu).setInitStatus(0).toJson());
            }
        });
    }

    public static void G(long j) {
        long j2 = j;
        if (j > 10000) {
            j2 = -1;
        }
        final long j3 = j2;
        com.kwad.sdk.utils.g.execute(new aw() { // from class: com.kwad.sdk.f.2
            @Override // com.kwad.sdk.utils.aw
            public final void doTask() {
                KSLoggerReporter.a(ILoggerReporter.Category.APM_LOG, com.kwai.adclient.kscommerciallogger.model.a.aEe, new SDKInitMsg().setTotalDurationTime(j3).setInitCount(f.Yu).setInitStatus(1).toJson());
            }
        });
    }

    public static void a(final com.kwai.adclient.kscommerciallogger.model.d dVar, final String str) {
        com.kwad.sdk.utils.g.execute(new aw() { // from class: com.kwad.sdk.f.3
            @Override // com.kwad.sdk.utils.aw
            public final void doTask() {
                KSLoggerReporter.a(ILoggerReporter.Category.ERROR_LOG, com.kwai.adclient.kscommerciallogger.model.d.this, new SDKInitMsg().setInitCount(f.Yu).setErrorReason(str).setInitStatus(2).toJson());
            }
        });
    }
}
