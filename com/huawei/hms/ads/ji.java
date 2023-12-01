package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.hms.ads.hi;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/ji.class */
public abstract class ji<V extends hi> extends hg<V> implements kj<V> {
    protected Context V;

    protected abstract String B();

    @Override // com.huawei.hms.ads.kj
    public void Code() {
        ko.Code(this.V, this.Code, com.huawei.openalliance.ad.constant.ac.B, (Long) null, (Long) null, (Integer) null, (Integer) null);
    }

    @Override // com.huawei.hms.ads.kj
    public void Code(long j, long j2, long j3) {
        if (j == 0 || j >= j3) {
            return;
        }
        long j4 = 0;
        if (j2 != 0) {
            j4 = 0;
            if (j2 < j3) {
                j4 = j3 - j2;
            }
        }
        eh.Code(this.V, this.Code, j3 - j, j4);
    }

    @Override // com.huawei.hms.ads.kj
    public void Code(long j, long j2, long j3, long j4) {
        ko.Code(this.V, this.Code, com.huawei.openalliance.ad.constant.ac.Z, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf((int) j3), Integer.valueOf((int) j4));
    }

    @Override // com.huawei.hms.ads.kj
    public void V() {
        ko.Code(this.V, this.Code, com.huawei.openalliance.ad.constant.ac.S, (Long) null, (Long) null, (Integer) null, (Integer) null);
    }

    @Override // com.huawei.hms.ads.kj
    public void V(long j, long j2, long j3, long j4) {
        ko.Code(this.V, this.Code, com.huawei.openalliance.ad.constant.ac.C, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf((int) j3), Integer.valueOf((int) j4));
    }
}
