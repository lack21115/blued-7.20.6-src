package com.kwad.components.core.d.b;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.kwad.components.core.d.b.a;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.core.report.KSLoggerReporter;
import com.kwad.sdk.core.report.y;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.ak;
import com.kwad.sdk.utils.bi;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/d/b/d.class */
public final class d extends com.kwad.sdk.core.download.kwai.b {
    private static boolean Ji = false;
    private static final b Jj = new b() { // from class: com.kwad.components.core.d.b.d.2
        long Jm;

        @Override // com.kwad.sdk.core.b.d, com.kwad.sdk.core.b.c
        public final void onBackToBackground() {
            super.onBackToBackground();
            this.Jm = System.currentTimeMillis();
        }

        @Override // com.kwad.sdk.core.b.d, com.kwad.sdk.core.b.c
        public final void onBackToForeground() {
            super.onBackToForeground();
            if (this.Jm != 0) {
                com.kwad.sdk.core.report.a.j(getAdTemplate(), System.currentTimeMillis() - this.Jm);
            }
            com.kwad.sdk.core.b.b.vS();
            com.kwad.sdk.core.b.b.b(d.Jj);
            setAdTemplate(null);
            this.Jm = 0L;
        }
    };

    private static String a(a.C0349a c0349a, AdInfo adInfo, String str) {
        String str2;
        if (com.kwad.sdk.core.response.a.a.ba(adInfo)) {
            String mM = (c0349a.jG() == null || c0349a.jG().getCurrentShowShopItemInfo() == null) ? c0349a.mM() : c0349a.jG().getCurrentShowShopItemInfo().itemId;
            if (TextUtils.isEmpty(mM)) {
                return (str.contains("__itemId__") || str.contains("__simpleItemId__")) ? com.kwad.sdk.core.response.a.a.cs(adInfo) : str;
            }
            try {
                str2 = String.valueOf(com.kwad.components.core.d.kwai.a.am(mM));
            } catch (Throwable th) {
                str2 = mM;
            }
            return str.replaceAll("__itemId__", mM).replaceAll("__simpleItemId__", str2);
        }
        return str;
    }

    public static String a(a.C0349a c0349a, AdTemplate adTemplate) {
        AdInfo cb = com.kwad.sdk.core.response.a.d.cb(adTemplate);
        for (AdInfo.AdConversionInfo.DeeplinkItemInfo deeplinkItemInfo : cb.adConversionInfo.deeplinkConf) {
            boolean contains = deeplinkItemInfo.areaConf.contains(Integer.valueOf(c0349a.de()));
            boolean contains2 = deeplinkItemInfo.sceneConf.contains(Integer.valueOf(c0349a.mO()));
            if ((contains && contains2) || ((contains && deeplinkItemInfo.sceneConf.size() == 0) || (contains2 && deeplinkItemInfo.areaConf.size() == 0))) {
                if (!TextUtils.isEmpty(deeplinkItemInfo.url)) {
                    return deeplinkItemInfo.url + cb.adConversionInfo.deeplinkExtra;
                }
            }
        }
        return com.kwad.sdk.core.response.a.a.cs(cb);
    }

    private static String a(String str, int i, String str2) {
        return TextUtils.isEmpty(str2) ? str : (i == 0 || i == 3) ? g(str, str2) : str;
    }

    private static String a(String str, Context context, SceneImpl sceneImpl) {
        String str2 = "";
        if (sceneImpl != null) {
            int i = 0;
            if (!ak.ah(context, "com.smile.gifmaker") && ak.ah(context, "com.kuaishou.nebula")) {
                i = 3;
            }
            String backUrl = sceneImpl.getBackUrl();
            if (TextUtils.isEmpty(backUrl)) {
                backUrl = "";
            }
            str2 = a(str, i, backUrl);
        }
        return str2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0033, code lost:
        if (com.kwad.sdk.core.response.a.a.co(r6) != false) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String a(java.lang.String r4, com.kwad.components.core.d.b.a.C0349a r5, com.kwad.sdk.core.response.model.AdInfo r6) {
        /*
            r0 = r5
            com.kwad.sdk.core.response.model.AdTemplate r0 = r0.getAdTemplate()
            r8 = r0
            r0 = r4
            r7 = r0
            r0 = r6
            boolean r0 = com.kwad.sdk.core.response.a.a.bb(r0)
            if (r0 == 0) goto L16
            r0 = r5
            r1 = r6
            r2 = r4
            java.lang.String r0 = b(r0, r1, r2)
            r7 = r0
        L16:
            r0 = r7
            r4 = r0
            r0 = r6
            boolean r0 = com.kwad.sdk.core.response.a.a.cq(r0)
            if (r0 == 0) goto L26
            r0 = r5
            r1 = r6
            r2 = r7
            java.lang.String r0 = a(r0, r1, r2)
            r4 = r0
        L26:
            r0 = r6
            boolean r0 = com.kwad.sdk.core.response.a.a.ci(r0)
            if (r0 != 0) goto L36
            r0 = r4
            r7 = r0
            r0 = r6
            boolean r0 = com.kwad.sdk.core.response.a.a.co(r0)
            if (r0 == 0) goto L4e
        L36:
            r0 = r4
            r7 = r0
            r0 = r8
            com.kwad.sdk.internal.api.SceneImpl r0 = r0.mAdScene
            if (r0 == 0) goto L4e
            r0 = r4
            r1 = r5
            android.content.Context r1 = r1.getContext()
            r2 = r8
            com.kwad.sdk.internal.api.SceneImpl r2 = r2.mAdScene
            java.lang.String r0 = a(r0, r1, r2)
            r7 = r0
        L4e:
            r0 = r7
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.core.d.b.d.a(java.lang.String, com.kwad.components.core.d.b.a$a, com.kwad.sdk.core.response.model.AdInfo):java.lang.String");
    }

    private static JSONObject ar(String str) {
        try {
            return new JSONObject(Uri.parse(str).getQueryParameter("universeClientInfo"));
        } catch (Throwable th) {
            return null;
        }
    }

    public static void aw(boolean z) {
        com.kwad.sdk.core.report.a.ahR = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void ax(boolean z) {
        Ji = z;
    }

    public static int b(a.C0349a c0349a, int i) {
        Context context = c0349a.getContext();
        AdTemplate adTemplate = c0349a.getAdTemplate();
        if (adTemplate == null || context == null) {
            return 0;
        }
        Jj.setAdTemplate(adTemplate);
        com.kwad.sdk.core.b.b.vS();
        com.kwad.sdk.core.b.b.a(Jj);
        String a2 = a(a(c0349a, adTemplate), c0349a, com.kwad.sdk.core.response.a.d.cb(adTemplate));
        com.kwad.sdk.core.report.a.ahQ = ar(a2);
        int g = g(context, a2);
        if (g != 1) {
            if (g == -1) {
                com.kwad.sdk.core.report.a.b(adTemplate, "", i, (y.b) null);
            }
            return g;
        }
        BusinessType businessType = null;
        if (c0349a.getAdTemplate() != null) {
            businessType = null;
            if (c0349a.getAdTemplate().mAdScene != null) {
                businessType = KSLoggerReporter.bv(c0349a.getAdTemplate().mAdScene.getAdStyle());
            }
        }
        KSLoggerReporter.ReportClient.CONVERT_DPLINK.buildMethodCheck(businessType, "dplinkSuccess");
        com.kwad.sdk.core.report.a.a(adTemplate, "", i, c0349a.getClientParams());
        e(adTemplate, i);
        return g;
    }

    private static String b(a.C0349a c0349a, AdInfo adInfo, String str) {
        long j = c0349a.getAdTemplate().getmCurPlayTime();
        long j2 = j;
        if (j > 0) {
            j2 = Math.max(j - com.kwad.sdk.core.response.a.a.bc(adInfo), 0L);
        }
        return Uri.parse(str).buildUpon().appendQueryParameter("playStartTime", String.valueOf(j2)).toString();
    }

    private static void e(final AdTemplate adTemplate, final int i) {
        if (nr()) {
            return;
        }
        ax(true);
        int uo = com.kwad.sdk.core.config.d.uo();
        com.kwad.sdk.core.config.d.up();
        int abs = Math.abs(uo);
        if (abs > 0) {
            bi.a(new Runnable() { // from class: com.kwad.components.core.d.b.d.1
                @Override // java.lang.Runnable
                public final void run() {
                    d.ax(false);
                    com.kwad.sdk.core.b.b.vS();
                    if (com.kwad.sdk.core.b.b.isAppOnForeground()) {
                        return;
                    }
                    com.kwad.sdk.core.report.a.a(AdTemplate.this, "", i);
                    AdTemplate adTemplate2 = AdTemplate.this;
                    BusinessType businessType = null;
                    if (adTemplate2 != null) {
                        businessType = null;
                        if (adTemplate2.mAdScene != null) {
                            businessType = KSLoggerReporter.bv(AdTemplate.this.mAdScene.getAdStyle());
                        }
                    }
                    KSLoggerReporter.ReportClient.CONVERT_DPLINK.buildMethodCheck(businessType, "trueDplinkSuccess");
                }
            }, null, abs * 1000);
        } else {
            ax(false);
        }
    }

    private static String g(String str, String str2) {
        Uri.Builder buildUpon = Uri.parse(str).buildUpon();
        Uri.Builder appendQueryParameter = buildUpon.appendQueryParameter("returnBack", "liveunion_" + KsAdSDKImpl.get().getAppId());
        String str3 = str2;
        if (TextUtils.isEmpty(str2)) {
            str3 = "0";
        }
        return appendQueryParameter.appendQueryParameter("back_url", str3).toString();
    }

    private static boolean nr() {
        return Ji;
    }
}
