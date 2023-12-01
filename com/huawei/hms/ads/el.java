package com.huawei.hms.ads;

import android.content.Context;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/el.class */
public class el extends ek {
    private fk Code;

    public el(Context context) {
        this.Code = fk.Code(context);
    }

    @Override // com.huawei.hms.ads.ek
    public boolean Code() {
        if (this.Code.h() >= com.huawei.openalliance.ad.utils.v.Code()) {
            return true;
        }
        return V();
    }
}
