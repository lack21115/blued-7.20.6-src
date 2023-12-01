package com.kwad.sdk.core.report;

import android.text.TextUtils;
import com.kwad.sdk.core.report.KSLoggerReporter;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.ReportResultData;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/report/x.class */
public abstract class x extends com.kwad.sdk.core.network.a<y> {
    private ReportResultData ajU;

    private ReportResultData a(com.kwad.sdk.core.network.c cVar) {
        if (this.ajU == null) {
            this.ajU = new ReportResultData() { // from class: com.kwad.sdk.core.report.ReportNetwork$1
                @Override // com.kwad.sdk.core.network.BaseResultData, com.kwad.sdk.core.b
                public void parseJson(JSONObject jSONObject) {
                    super.parseJson(jSONObject);
                }
            };
        }
        if (cVar != null) {
            try {
                this.ajU.parseJson(new JSONObject(cVar.agf));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return this.ajU;
    }

    private void a(y yVar) {
        try {
            List<String> xm = yVar.xm();
            for (String str : xm) {
                com.kwad.sdk.core.network.c doGetWithoutResponse = com.kwad.sdk.b.rZ().doGetWithoutResponse(str, null);
                if (!isValidUrl(str) || doGetWithoutResponse.code != 200) {
                    KSLoggerReporter.ReportClient.RESPONE_MONITOR.buildNormalApmReporter().cC("response_biz_error_track").J("trackUrlError", str).aF(yVar.getAdTemplate()).report();
                }
            }
            a(yVar.getAdTemplate(), xm);
        } catch (Exception e) {
            com.kwad.sdk.core.d.b.printStackTrace(e);
        }
    }

    private static void a(AdTemplate adTemplate, List<String> list) {
        if (adTemplate.mTrackUrlReported || list == null || list.isEmpty()) {
            return;
        }
        adTemplate.mTrackUrlReported = true;
        q qVar = new q(10217L, adTemplate);
        qVar.ajx = com.kwad.sdk.utils.t.toJsonArray(list);
        h.a2(qVar);
    }

    private static void a(String str, int i, AdTemplate adTemplate, com.kwad.sdk.core.network.c cVar) {
        if (TextUtils.isEmpty(str) || str.contains(" ") || !str.startsWith("http") || cVar.code != 200) {
            KSLoggerReporter.ReportClient.RESPONE_MONITOR.buildNormalApmReporter().cC("response_biz_error_track").J(i == 1 ? "showUrlError" : i == 2 ? "clickUrlError" : "convertUrlError", str).aF(adTemplate).report();
        }
    }

    private static boolean isValidUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            URI uri = new URI(str);
            if (uri.getHost() == null) {
                return false;
            }
            return uri.getScheme().equalsIgnoreCase("http") || uri.getScheme().equalsIgnoreCase("https");
        } catch (URISyntaxException e) {
            return false;
        }
    }

    @Override // com.kwad.sdk.core.network.a
    public void fetch() {
        super.fetch();
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00b8  */
    @Override // com.kwad.sdk.core.network.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void fetchImpl() {
        /*
            Method dump skipped, instructions count: 286
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.report.x.fetchImpl():void");
    }

    @Override // com.kwad.sdk.core.network.a
    public /* bridge */ /* synthetic */ void onResponse(y yVar, com.kwad.sdk.core.network.c cVar) {
    }
}
