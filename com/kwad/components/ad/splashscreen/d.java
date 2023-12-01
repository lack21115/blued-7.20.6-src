package com.kwad.components.ad.splashscreen;

import android.text.TextUtils;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/splashscreen/d.class */
public final class d {
    public static int BC;
    private String BD;
    private int BE = 2;
    private String title;

    private void Z(int i) {
        this.BE = i;
    }

    private void Z(String str) {
        this.BD = str;
    }

    public static d a(AdTemplate adTemplate, AdInfo adInfo, com.kwad.components.core.d.b.c cVar, int i) {
        String str;
        d dVar = new d();
        BC = i;
        if (adInfo != null && cVar != null) {
            if (i == 1) {
                dVar.setTitle(com.kwad.sdk.core.response.a.b.cN(adInfo));
            } else if (i != 4) {
                if (com.kwad.sdk.core.response.a.a.ax(adInfo)) {
                    int nb = cVar.nb();
                    str = "或点击" + a(adTemplate, adInfo, nb);
                } else {
                    String a2 = com.kwad.sdk.core.config.d.a(com.kwad.components.ad.splashscreen.a.a.BR);
                    String str2 = a2;
                    if (TextUtils.isEmpty(a2)) {
                        str2 = "点击跳转详情页或第三方应用";
                    }
                    str = "或" + str2;
                }
                dVar.Z(str);
            }
            str = a(adInfo, cVar);
            dVar.Z(str);
        }
        dVar.Z(com.kwad.sdk.core.response.a.b.cW(adInfo));
        return dVar;
    }

    public static String a(AdInfo adInfo, int i) {
        AdMatrixInfo.DownloadTexts b = b(adInfo, BC);
        return i != 8 ? i != 12 ? b.adActionDescription : b.openAppLabel : b.installAppLabel;
    }

    private static String a(AdInfo adInfo, com.kwad.components.core.d.b.c cVar) {
        if (com.kwad.sdk.core.response.a.a.ax(adInfo)) {
            int nb = cVar.nb();
            AdMatrixInfo.DownloadTexts b = b(adInfo, BC);
            return nb != 8 ? nb != 12 ? b.adActionDescription : b.openAppLabel : b.installAppLabel;
        }
        String d = d(adInfo, BC);
        String str = d;
        if (TextUtils.isEmpty(d)) {
            str = "点击跳转详情页或第三方应用";
        }
        return str;
    }

    public static String a(AdTemplate adTemplate, AdInfo adInfo, int i) {
        return i != 8 ? i != 12 ? com.kwad.sdk.core.response.a.a.aw(adInfo) : com.kwad.sdk.core.response.a.a.T(adInfo) : com.kwad.sdk.core.response.a.a.aH(adTemplate);
    }

    private static AdMatrixInfo.DownloadTexts b(AdInfo adInfo, int i) {
        if (i == 1) {
            return com.kwad.sdk.core.response.a.b.cL(adInfo) != null ? com.kwad.sdk.core.response.a.b.cL(adInfo) : new AdMatrixInfo.DownloadTexts();
        }
        if (i == 4 && com.kwad.sdk.core.response.a.b.cQ(adInfo) != null) {
            return com.kwad.sdk.core.response.a.b.cQ(adInfo);
        }
        return new AdMatrixInfo.DownloadTexts();
    }

    public static String c(AdInfo adInfo, int i) {
        AdMatrixInfo.DownloadTexts cM = com.kwad.sdk.core.response.a.b.cM(adInfo) != null ? com.kwad.sdk.core.response.a.b.cM(adInfo) : new AdMatrixInfo.DownloadTexts();
        return i != 8 ? i != 12 ? cM.adActionDescription : cM.openAppLabel : cM.installAppLabel;
    }

    private static String d(AdInfo adInfo, int i) {
        return i == 1 ? com.kwad.sdk.core.response.a.b.cP(adInfo) != null ? com.kwad.sdk.core.response.a.b.cP(adInfo) : "" : (i != 4 || com.kwad.sdk.core.response.a.b.cR(adInfo) == null) ? "" : com.kwad.sdk.core.response.a.b.cR(adInfo);
    }

    private void setTitle(String str) {
        this.title = str;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String kq() {
        return this.BD;
    }

    public final int kr() {
        return this.BE;
    }
}
