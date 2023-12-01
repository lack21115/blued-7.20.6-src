package com.huawei.hms.ads;

import java.util.concurrent.Callable;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/jk.class */
public class jk extends jv {
    public jk(fk fkVar, lu luVar) {
        super(fkVar, luVar);
    }

    @Override // com.huawei.hms.ads.jv
    public void V() {
        long longValue = ((Long) com.huawei.openalliance.ad.utils.aw.Code(new Callable<Long>() { // from class: com.huawei.hms.ads.jk.1
            @Override // java.util.concurrent.Callable
            /* renamed from: Code */
            public Long call() {
                return Long.valueOf(jk.this.Code.b());
            }
        }, 300L)).longValue();
        int intValue = ((Integer) com.huawei.openalliance.ad.utils.aw.Code(new Callable<Integer>() { // from class: com.huawei.hms.ads.jk.2
            @Override // java.util.concurrent.Callable
            /* renamed from: Code */
            public Integer call() {
                return Integer.valueOf(jk.this.Code.a());
            }
        }, 2000)).intValue();
        V(longValue);
        Code(intValue);
    }
}
