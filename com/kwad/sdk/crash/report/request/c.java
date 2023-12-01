package com.kwad.sdk.crash.report.request;

import android.text.TextUtils;
import com.kwad.sdk.crash.d;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import com.kwad.sdk.crash.report.ReportEvent;
import com.kwad.sdk.crash.utils.e;
import java.util.Calendar;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/crash/report/request/c.class */
public final class c {
    public static ReportEvent d(ExceptionMessage exceptionMessage) {
        ReportEvent reportEvent = new ReportEvent();
        reportEvent.clientIncrementId = e.xj();
        reportEvent.clientTimeStamp = exceptionMessage.mCurrentTimeStamp;
        reportEvent.sessionId = dU(exceptionMessage.mCustomMsg);
        reportEvent.timeZone = Calendar.getInstance().getTimeZone().getID();
        reportEvent.statPackage = new ReportEvent.StatPackage();
        ReportEvent.ExceptionEvent exceptionEvent = new ReportEvent.ExceptionEvent();
        exceptionEvent.type = exceptionMessage.mExceptionType;
        exceptionEvent.message = exceptionMessage.toJson().toString();
        exceptionEvent.urlPackage = new ReportEvent.UrlPackage();
        reportEvent.statPackage.exceptionEvent = exceptionEvent;
        return reportEvent;
    }

    private static String dU(String str) {
        if (TextUtils.isEmpty(str) || "Unknown".equals(str)) {
            return "Unknown";
        }
        try {
            String optString = new JSONObject(str).optString(d.arf);
            return !TextUtils.isEmpty(optString) ? optString : "Unknown";
        } catch (Exception e) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e);
            return "Unknown";
        }
    }
}
