package com.kwad.sdk.core.report;

import com.kwad.sdk.service.ServiceProvider;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/report/e.class */
public final class e {
    public double aii;
    public double aij;
    public String aik = "3.3.40";

    private static double sM() {
        com.kwad.sdk.service.kwai.f fVar = (com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class);
        if (fVar != null) {
            return fVar.sM();
        }
        return 0.0d;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0095  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(java.lang.String r5, org.json.JSONObject r6, java.lang.String r7) {
        /*
            r4 = this;
            r0 = r6
            java.lang.String r1 = "minSDKVersion"
            boolean r0 = r0.has(r1)
            if (r0 == 0) goto L13
            r0 = r4
            r1 = r6
            java.lang.String r2 = "minSDKVersion"
            java.lang.String r1 = r1.optString(r2)
            r0.aik = r1
        L13:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            java.lang.String r2 = "ratio"
            r1.<init>(r2)
            r10 = r0
            r0 = r10
            r1 = r7
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r10
            java.lang.String r0 = r0.toString()
            r10 = r0
            java.lang.String r0 = "ad_client_error_log"
            r1 = r5
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L5c
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            java.lang.String r2 = "ratioRE"
            r1.<init>(r2)
            r5 = r0
            r0 = r5
            r1 = r7
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r5
            java.lang.String r0 = r0.toString()
            r5 = r0
            r0 = r6
            r1 = r5
            boolean r0 = r0.has(r1)
            if (r0 == 0) goto L5c
            r0 = r6
            r1 = r5
            double r0 = r0.optDouble(r1)
            r8 = r0
            goto L64
        L5c:
            r0 = r6
            r1 = r10
            double r0 = r0.optDouble(r1)
            r8 = r0
        L64:
            r0 = r4
            r1 = r8
            r0.aii = r1
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            java.lang.String r2 = "ratioApmRL"
            r1.<init>(r2)
            r5 = r0
            r0 = r5
            r1 = r7
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r5
            java.lang.String r0 = r0.toString()
            r5 = r0
            r0 = r6
            r1 = r5
            boolean r0 = r0.has(r1)
            if (r0 == 0) goto L95
            r0 = r6
            r1 = r5
            double r0 = r0.optDouble(r1)
            r8 = r0
        L8e:
            r0 = r4
            r1 = r8
            r0.aij = r1
            return
        L95:
            double r0 = sM()
            r8 = r0
            goto L8e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.report.e.a(java.lang.String, org.json.JSONObject, java.lang.String):void");
    }
}
