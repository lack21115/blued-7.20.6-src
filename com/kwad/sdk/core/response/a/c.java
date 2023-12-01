package com.kwad.sdk.core.response.a;

import com.kwad.sdk.core.response.model.AdStyleInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/response/a/c.class */
public final class c {
    public static long bN(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return 0L;
        }
        return bR(adTemplate).playDetailInfo.detailTopToolBarInfo.callButtonShowTime;
    }

    public static String bO(AdTemplate adTemplate) {
        return adTemplate == null ? "" : bR(adTemplate).playDetailInfo.detailTopToolBarInfo.callButtonDescription;
    }

    public static String bP(AdTemplate adTemplate) {
        return adTemplate == null ? "" : bR(adTemplate).playEndInfo.endTopToolBarInfo.callButtonDescription;
    }

    public static boolean bQ(AdTemplate adTemplate) {
        if (adTemplate != null && d.bT(adTemplate)) {
            return bR(adTemplate).slideClick;
        }
        return false;
    }

    private static AdStyleInfo bR(AdTemplate adTemplate) {
        return d.cb(adTemplate).adStyleInfo;
    }

    public static List<String> bS(AdTemplate adTemplate) {
        AdStyleInfo bR = bR(adTemplate);
        ArrayList arrayList = new ArrayList();
        try {
            for (AdStyleInfo.ExposeTagInfo exposeTagInfo : bR.extraDisplayInfo.exposeTagInfoList) {
                arrayList.add(exposeTagInfo.text);
            }
            return arrayList;
        } catch (Exception e) {
            return arrayList;
        }
    }
}
