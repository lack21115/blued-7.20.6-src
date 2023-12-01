package com.kwad.sdk.core.webview.a.b;

import android.provider.Downloads;
import android.text.TextUtils;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.commercial.model.HybridLoadMsg;
import com.kwad.sdk.core.report.KSLoggerReporter;
import com.kwad.sdk.utils.t;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/webview/a/b/b.class */
public final class b {
    public static final Map<String, JSONObject> aqb = new HashMap();
    public static boolean aqc = true;

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/webview/a/b/b$a.class */
    public static final class a {
        public String msg;
    }

    public static void O(String str, String str2) {
        JSONObject dl = dl(str);
        t.putValue(dl, "c_" + str2, System.currentTimeMillis());
    }

    private static void P(String str, String str2) {
        a(str, str2, 1, "");
    }

    public static void Q(String str, String str2) {
        a(str, "", 2, str2);
    }

    public static void a(com.kwad.sdk.f.kwai.b bVar, int i) {
        KSLoggerReporter.a(ILoggerReporter.Category.APM_LOG, new HybridLoadMsg().setSceneId(bVar.atm).setH5Version(bVar.version).setLoadType(bVar.loadType).setState(i).setPackageUrl(bVar.packageUrl).setInterval(String.valueOf(System.currentTimeMillis() - bVar.Az())));
    }

    public static void a(com.kwad.sdk.f.kwai.b bVar, int i, int i2, String str) {
        KSLoggerReporter.a(ILoggerReporter.Category.ERROR_LOG, new HybridLoadMsg().setSceneId(bVar.atm).setH5Version(bVar.version).setLoadType(bVar.loadType).setState(0).setPackageUrl(bVar.packageUrl).setFailState(i2).setInterval(String.valueOf(System.currentTimeMillis() - bVar.Az())).setFailReason(str));
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x004c, code lost:
        if (r0 < 0) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(java.lang.String r5, java.lang.String r6, int r7, java.lang.String r8) {
        /*
            java.util.Map<java.lang.String, org.json.JSONObject> r0 = com.kwad.sdk.core.webview.a.b.b.aqb
            r1 = r6
            java.lang.Object r0 = r0.get(r1)
            org.json.JSONObject r0 = (org.json.JSONObject) r0
            r14 = r0
            r0 = r14
            if (r0 != 0) goto L1b
            r0 = -3
            r9 = r0
            goto L54
        L1b:
            r0 = r14
            java.lang.String r1 = "c_loadUrl"
            long r0 = r0.optLong(r1)
            r9 = r0
            r0 = r9
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 > 0) goto L33
            r0 = -2
            r9 = r0
            goto L54
        L33:
            long r0 = java.lang.System.currentTimeMillis()
            r1 = r9
            long r0 = r0 - r1
            r11 = r0
            r0 = r11
            r1 = 100000(0x186a0, double:4.94066E-319)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 > 0) goto L4f
            r0 = r11
            r9 = r0
            r0 = r11
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L54
        L4f:
            r0 = -1
            r9 = r0
        L54:
            r0 = r7
            r1 = 2
            if (r0 != r1) goto L60
            java.lang.String r0 = "ad_client_error_log"
            r13 = r0
            goto L64
        L60:
            java.lang.String r0 = "ad_client_apm_log"
            r13 = r0
        L64:
            r0 = r14
            if (r0 == 0) goto L73
            r0 = r14
            java.lang.String r0 = r0.toString()
            r14 = r0
            goto L77
        L73:
            java.lang.String r0 = ""
            r14 = r0
        L77:
            r0 = r13
            com.kwad.sdk.commercial.model.WebViewLoadMsg r1 = new com.kwad.sdk.commercial.model.WebViewLoadMsg
            r2 = r1
            r2.<init>()
            r2 = r5
            com.kwad.sdk.commercial.model.WebViewLoadMsg r1 = r1.setUrl(r2)
            r2 = r7
            com.kwad.sdk.commercial.model.WebViewLoadMsg r1 = r1.setState(r2)
            r2 = r14
            com.kwad.sdk.commercial.model.WebViewLoadMsg r1 = r1.setCostTime(r2)
            r2 = r9
            java.lang.String r2 = java.lang.String.valueOf(r2)
            com.kwad.sdk.commercial.model.WebViewLoadMsg r1 = r1.setInterval(r2)
            r2 = r8
            com.kwad.sdk.commercial.model.WebViewLoadMsg r1 = r1.setFailReason(r2)
            com.kwad.sdk.core.report.KSLoggerReporter.a(r0, r1)
            r0 = r6
            dm(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.webview.a.b.b.a(java.lang.String, java.lang.String, int, java.lang.String):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0021, code lost:
        if (r9 < 0) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(java.lang.String r5, java.lang.String r6, int r7, java.lang.String r8, long r9) {
        /*
            r0 = r7
            r1 = 2
            if (r0 != r1) goto Lc
            java.lang.String r0 = "ad_client_error_log"
            r13 = r0
            goto L10
        Lc:
            java.lang.String r0 = "ad_client_apm_log"
            r13 = r0
        L10:
            r0 = r9
            r1 = 60000(0xea60, double:2.9644E-319)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 > 0) goto L24
            r0 = r9
            r11 = r0
            r0 = r9
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L29
        L24:
            r0 = -1
            r11 = r0
        L29:
            r0 = r13
            com.kwad.sdk.commercial.model.HybridLoadMsg r1 = new com.kwad.sdk.commercial.model.HybridLoadMsg
            r2 = r1
            r2.<init>()
            r2 = r6
            com.kwad.sdk.commercial.model.HybridLoadMsg r1 = r1.setSceneId(r2)
            r2 = r5
            com.kwad.sdk.commercial.model.HybridLoadMsg r1 = r1.setUrl(r2)
            r2 = r7
            com.kwad.sdk.commercial.model.HybridLoadMsg r1 = r1.setState(r2)
            r2 = r11
            java.lang.String r2 = java.lang.String.valueOf(r2)
            com.kwad.sdk.commercial.model.HybridLoadMsg r1 = r1.setInterval(r2)
            r2 = r8
            com.kwad.sdk.commercial.model.HybridLoadMsg r1 = r1.setFailReason(r2)
            com.kwad.sdk.core.report.KSLoggerReporter.b(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.webview.a.b.b.a(java.lang.String, java.lang.String, int, java.lang.String, long):void");
    }

    public static void a(String str, String str2, String str3, String str4) {
        JSONObject dl = dl(str2);
        t.putValue(dl, "c_" + str3, System.currentTimeMillis());
        if (str3.equals("pageStatus")) {
            try {
                if (TextUtils.isEmpty(str4)) {
                    return;
                }
                JSONObject jSONObject = new JSONObject(str4);
                int optInt = jSONObject.optInt("status");
                String optString = jSONObject.optString(Downloads.Impl.COLUMN_ERROR_MSG, "");
                String optString2 = jSONObject.optString("webViewCostParams", "");
                if (!TextUtils.isEmpty(optString2)) {
                    JSONObject jSONObject2 = new JSONObject(optString2);
                    Iterator<String> keys = jSONObject2.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        dl.put(next, jSONObject2.opt(next));
                    }
                }
                if (!TextUtils.isEmpty(str)) {
                    if (optInt == 1) {
                        P(str, str2);
                    } else {
                        Q(str, optString);
                    }
                }
            } catch (Exception e) {
                com.kwad.sdk.core.d.b.printStackTrace(e);
            } finally {
                dm(str2);
            }
        }
    }

    public static void b(String str, String str2, String str3) {
        String str4 = str3;
        if (str3.contains("/")) {
            str4 = str3.substring(str3.lastIndexOf("/") + 1);
        }
        JSONObject dl = dl(str);
        t.putValue(dl, "c_responseStart_" + str2 + "_" + str4, System.currentTimeMillis());
    }

    public static void c(String str, String str2, String str3) {
        String str4 = str3;
        if (str3.contains("/")) {
            str4 = str3.substring(str3.lastIndexOf("/") + 1);
        }
        JSONObject dl = dl(str);
        t.putValue(dl, "c_responseEnd_" + str2 + "_" + str4, System.currentTimeMillis());
    }

    private static JSONObject dl(String str) {
        JSONObject jSONObject = aqb.get(str);
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
            aqb.put(str, jSONObject2);
        }
        return jSONObject2;
    }

    private static void dm(String str) {
        aqb.remove(str);
    }

    public static void dn(String str) {
        JSONObject dl = dl(str);
        long zb = com.kwad.sdk.core.webview.a.a.za().zb();
        long currentTimeMillis = zb <= 0 ? -1L : System.currentTimeMillis() - zb;
        t.putValue(dl, "c_loadUrl", System.currentTimeMillis());
        t.putValue(dl, "c_init_interval", currentTimeMillis);
        t.putValue(dl, "c_init_state", aqc ? 1 : 2);
        aqc = false;
    }
}
