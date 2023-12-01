package com.huawei.hms.ads;

import android.content.Context;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/dy.class */
public class dy extends dv {
    private static ee I;
    private static final byte[] Z = new byte[0];
    private com.huawei.openalliance.ad.utils.j B;

    private dy(Context context) {
        super(context);
        this.B = new com.huawei.openalliance.ad.utils.j(context);
    }

    private static ee I(Context context) {
        ee eeVar;
        synchronized (Z) {
            if (I == null) {
                I = new dy(context);
            }
            eeVar = I;
        }
        return eeVar;
    }

    public static ee V(Context context) {
        return I(context);
    }

    @Override // com.huawei.hms.ads.dv, com.huawei.hms.ads.ee
    public boolean Code() {
        return "CN".equalsIgnoreCase(this.B.Code());
    }

    @Override // com.huawei.hms.ads.dv, com.huawei.hms.ads.ee
    public boolean I() {
        return false;
    }

    @Override // com.huawei.hms.ads.dv, com.huawei.hms.ads.ee
    public boolean V() {
        return Code();
    }
}
