package com.kwad.sdk.core.response.a;

import android.text.TextUtils;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.service.ServiceProvider;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/response/a/d.class */
public final class d {
    public static AdTemplate a(List<AdTemplate> list, long j, int i) {
        if (j < 0 || list == null) {
            return null;
        }
        for (AdTemplate adTemplate : list) {
            if (b(adTemplate, j, i)) {
                return adTemplate;
            }
        }
        return null;
    }

    public static boolean b(AdTemplate adTemplate, long j, int i) {
        long cl = cl(adTemplate);
        return i > 0 ? cl == j && bV(adTemplate) == i : cl == j;
    }

    public static boolean bT(AdTemplate adTemplate) {
        return (adTemplate.realShowType != 2 || adTemplate.adInfoList.isEmpty() || adTemplate.adInfoList.get(0) == null) ? false : true;
    }

    public static long bU(AdTemplate adTemplate) {
        return adTemplate.posId;
    }

    public static int bV(AdTemplate adTemplate) {
        return adTemplate.adStyle;
    }

    @Deprecated
    public static int bW(AdTemplate adTemplate) {
        if (adTemplate == null || adTemplate.mAdScene == null) {
            return 0;
        }
        return adTemplate.mAdScene.getAdStyle();
    }

    public static int bX(AdTemplate adTemplate) {
        return adTemplate.contentType;
    }

    public static long bY(AdTemplate adTemplate) {
        return adTemplate.llsid;
    }

    public static String bZ(AdTemplate adTemplate) {
        return adTemplate.extra;
    }

    public static String ca(AdTemplate adTemplate) {
        return adTemplate.impAdExtra;
    }

    public static AdInfo cb(AdTemplate adTemplate) {
        AdInfo adInfo = adTemplate.adInfoList.size() > 0 ? adTemplate.adInfoList.get(0) : null;
        AdInfo adInfo2 = adInfo;
        if (adInfo == null) {
            com.kwad.sdk.core.d.b.e("AdTemplateHelper", "adInfo in null");
            adInfo2 = new AdInfo();
        }
        return adInfo2;
    }

    public static PhotoInfo cc(AdTemplate adTemplate) {
        return adTemplate.photoInfo;
    }

    public static String cd(AdTemplate adTemplate) {
        return bT(adTemplate) ? a.E(cb(adTemplate)) : f.a(cc(adTemplate));
    }

    public static String ce(AdTemplate adTemplate) {
        return cb(adTemplate).adConversionInfo.appDownloadUrl;
    }

    public static String cf(AdTemplate adTemplate) {
        e xx = xx();
        String xy = xx == null ? "" : xx.xy();
        return TextUtils.isEmpty(xy) ? xy : a.P(cb(adTemplate));
    }

    public static String cg(AdTemplate adTemplate) {
        if (bT(adTemplate)) {
            return a.bM(cb(adTemplate));
        }
        e xx = xx();
        return xx == null ? "" : xx.xz();
    }

    public static long ch(AdTemplate adTemplate) {
        if (bT(adTemplate)) {
            return a.S(cb(adTemplate));
        }
        e xx = xx();
        return xx == null ? adTemplate.hashCode() : xx.xA();
    }

    public static int ci(AdTemplate adTemplate) {
        e xx = xx();
        if (xx == null) {
            return 0;
        }
        return xx.xB();
    }

    public static int cj(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return -1;
        }
        return cb(adTemplate).adBaseInfo.taskType;
    }

    public static String ck(AdTemplate adTemplate) {
        return bT(adTemplate) ? a.ch(cb(adTemplate)) : f.c(cc(adTemplate));
    }

    public static long cl(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return 0L;
        }
        return cb(adTemplate).adBaseInfo.creativeId;
    }

    public static boolean cm(AdTemplate adTemplate) {
        return cb(adTemplate).adConversionInfo.blockCallbackIfSpam && adTemplate.mCheatingFlow;
    }

    public static boolean cn(AdTemplate adTemplate) {
        return co(adTemplate) || cp(adTemplate);
    }

    public static boolean co(AdTemplate adTemplate) {
        int h = h(adTemplate, true);
        return h == 1 || h == 2;
    }

    public static boolean cp(AdTemplate adTemplate) {
        int h = h(adTemplate, false);
        return h == 1 || h == 2;
    }

    public static int cq(AdTemplate adTemplate) {
        return cb(adTemplate).adBaseInfo.ecpm;
    }

    public static boolean cr(AdTemplate adTemplate) {
        AdInfo cb = cb(adTemplate);
        return cb.adStyleConfInfo.adPushDownloadJumpType == 0 && bV(adTemplate) == 17 && a.ax(cb);
    }

    public static boolean g(AdTemplate adTemplate, boolean z) {
        if (adTemplate == null) {
            return false;
        }
        AdInfo cb = cb(adTemplate);
        return a.ax(cb) && !a.cv(cb) && !z && cj(adTemplate) == 2;
    }

    public static int h(AdTemplate adTemplate, boolean z) {
        AdInfo cb = cb(adTemplate);
        if (bV(adTemplate) == 3) {
            AdMatrixInfo.AdDataV2 adDataV2 = cb.adMatrixInfo.adDataV2;
            int i = z ? adDataV2.actionBarInfo.cardType : adDataV2.endCardInfo.cardType;
            if (i == 5) {
                return 1;
            }
            return i == 6 ? 2 : -1;
        }
        return cb.adBaseInfo.mABParams.playableStyle;
    }

    public static boolean p(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return false;
        }
        AdInfo cb = cb(adTemplate);
        return (a.ax(cb) || a.cv(cb) || cj(adTemplate) != 3) ? false : true;
    }

    private static e xx() {
        com.kwad.sdk.service.kwai.e eVar = (com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class);
        if (eVar != null) {
            return eVar.rK();
        }
        return null;
    }
}
