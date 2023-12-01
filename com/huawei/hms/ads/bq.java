package com.huawei.hms.ads;

import com.huawei.hms.ads.nativead.DislikeAdReason;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/bq.class */
public class bq implements DislikeAdReason {
    private String Code;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bq(String str) {
        this.Code = str;
    }

    @Override // com.huawei.hms.ads.nativead.DislikeAdReason
    public String getDescription() {
        return this.Code;
    }
}
