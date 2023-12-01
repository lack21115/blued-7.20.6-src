package com.huawei.hms.ads;

import com.huawei.openalliance.ad.inter.data.AdContentData;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/ic.class */
public class ic {
    public static id Code(AdContentData adContentData) {
        if (adContentData == null) {
            return new ib();
        }
        if (adContentData.p() != null || (adContentData.q() != null && "video/mp4".equals(adContentData.q().Code()))) {
            if (ig.C()) {
                return new ig();
            }
        } else if (hy.Code()) {
            return new hy();
        }
        return new ib();
    }
}
