package com.kwad.sdk.crash.report;

import com.kwad.sdk.crash.report.ReportEvent;
import com.kwad.sdk.crash.report.request.b;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/crash/report/h.class */
public final class h {
    public static void R(String str, String str2) {
        a(S(str, str2));
    }

    private static ReportEvent S(String str, String str2) {
        ReportEvent reportEvent = new ReportEvent();
        reportEvent.clientTimeStamp = System.currentTimeMillis();
        reportEvent.timeZone = Calendar.getInstance().getTimeZone().getID();
        reportEvent.statPackage = new ReportEvent.StatPackage();
        ReportEvent.CustomStatEvent customStatEvent = new ReportEvent.CustomStatEvent();
        customStatEvent.key = str;
        customStatEvent.value = str2;
        reportEvent.statPackage.customStatEvent = customStatEvent;
        return reportEvent;
    }

    private static void a(ReportEvent reportEvent) {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(reportEvent);
        try {
            com.kwad.sdk.crash.report.request.b.a(arrayList, null);
        } catch (Throwable th) {
        }
    }

    public static void a(String str, List<String> list, b.a aVar) {
        if (list.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (String str2 : list) {
            arrayList.add(S(str, str2));
        }
        a(arrayList, aVar);
    }

    private static void a(List<ReportEvent> list, b.a aVar) {
        try {
            com.kwad.sdk.crash.report.request.b.a(list, null, aVar);
        } catch (Throwable th) {
        }
    }
}
