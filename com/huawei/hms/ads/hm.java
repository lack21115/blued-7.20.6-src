package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.AppInfo;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/hm.class */
public class hm extends hl {
    private static final String Z = "AppNotificationDelete";

    @Override // com.huawei.hms.ads.hl
    protected void Code(Context context, AppInfo appInfo, AdContentData adContentData, int i) {
        if (adContentData == null) {
            ge.V(Z, "contentRecord is empty");
        } else {
            hn.Code(context, adContentData);
        }
    }
}
