package com.kwad.sdk.crash.report;

import com.kwad.sdk.core.report.q;
import com.kwad.sdk.crash.model.message.ExceptionMessage;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/crash/report/a.class */
public final class a {
    public static void b(ExceptionMessage exceptionMessage) {
        q qVar = new q(10211L);
        qVar.errorMsg = exceptionMessage.getReportMsg();
        com.kwad.sdk.core.report.h.a2(qVar);
    }
}
