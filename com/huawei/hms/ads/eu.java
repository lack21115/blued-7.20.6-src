package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.beans.metadata.MetaData;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.c;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/eu.class */
public class eu implements ev {
    private static long V;

    private Map<String, String> Code(AdContentData adContentData) {
        HashMap hashMap = new HashMap();
        if (adContentData != null) {
            if (adContentData.Z() == null) {
                return hashMap;
            }
            MetaData Z = adContentData.Z();
            String L = Z.L();
            String D = Z.D();
            if (L != null) {
                if (D == null) {
                    return hashMap;
                }
                hashMap.put("appId", L);
                hashMap.put(com.huawei.openalliance.ad.uriaction.i.V, D);
            }
        }
        return hashMap;
    }

    private void Code(final Context context, final com.huawei.openalliance.ad.inter.data.d dVar) {
        long Code = com.huawei.openalliance.ad.utils.v.Code();
        ge.V("DownloadChecker", "trigger action list lastTime:%s curTime:%s", Long.valueOf(V), Long.valueOf(Code));
        if (Code - V < 500) {
            ge.V("DownloadChecker", "trigger action list too frequently");
            return;
        }
        V = Code;
        com.huawei.openalliance.ad.utils.ba.Code(new Runnable() { // from class: com.huawei.hms.ads.eu.1
            @Override // java.lang.Runnable
            public void run() {
                eu.this.Code(dVar, context);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(com.huawei.openalliance.ad.inter.data.d dVar, Context context) {
        if (dVar == null || context == null) {
            return;
        }
        if (dVar instanceof com.huawei.openalliance.ad.inter.data.n) {
            ge.V("DownloadChecker", "native trigger action list result:%s", Boolean.valueOf(((com.huawei.openalliance.ad.inter.data.n) dVar).B(context, null)));
        } else if (!(dVar instanceof c)) {
            ge.V("DownloadChecker", "not baseAd no need trigger action list");
        } else {
            AdContentData l = dVar.l();
            ge.V("DownloadChecker", "trigger action list result:%s", Boolean.valueOf(com.huawei.openalliance.ad.uriaction.r.Code(context, l, Code(l)).Code()));
        }
    }

    @Override // com.huawei.hms.ads.ev
    public boolean Code(Context context, com.huawei.openalliance.ad.inter.data.d dVar, boolean z) {
        if (context == null || dVar == null) {
            return false;
        }
        int y = dVar.y();
        ge.Code("DownloadChecker", "api control flag:%s", Integer.valueOf(y));
        if (y != 0) {
            if (y != 1) {
                if (y != 2) {
                    ge.I("DownloadChecker", "invalid apiDownloadFlag value!");
                    return false;
                }
                return false;
            } else if (z) {
                Code(context, dVar);
                return false;
            } else {
                return false;
            }
        }
        return true;
    }
}
