package com.kwad.sdk.ranger.a;

import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.core.d.b;
import com.kwad.sdk.core.report.KSLoggerReporter;
import com.kwad.sdk.core.report.o;
import com.kwad.sdk.ranger.a.kwai.d;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;
import com.kwai.adclient.kscommerciallogger.model.SubBusinessType;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/ranger/a/a.class */
public class a {
    public static final String TAG = "Ranger_" + a.class.getSimpleName();

    public static void a(d dVar) {
        JSONObject json = dVar.toJson();
        if (json == null) {
            return;
        }
        String str = TAG;
        b.d(str, "report Stats:" + json.toString());
        KSLoggerReporter.a(new o.a().cE(ILoggerReporter.Category.APM_LOG).b(BusinessType.OTHER).a(SubBusinessType.OTHER).a(com.kwai.adclient.kscommerciallogger.model.d.aEG).cF("ad_sdk_detect_info").A(json).xa());
    }
}
