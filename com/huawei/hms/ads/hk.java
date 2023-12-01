package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.AppInfo;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/hk.class */
public class hk extends hl {
    private static final String Z = "AppNotificationActivate";

    @Override // com.huawei.hms.ads.hl
    protected void Code(Context context, AppInfo appInfo, AdContentData adContentData, int i) {
        if (adContentData == null || appInfo == null) {
            ge.V(Z, "contentRecord is empty");
            return;
        }
        new com.huawei.openalliance.ad.download.app.h().Code(context, appInfo, adContentData, Integer.valueOf(i), false);
        hn.V(context, adContentData);
    }
}
