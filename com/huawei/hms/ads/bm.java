package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/bm.class */
public class bm extends be {
    private static final String Z = "JsbReportShowStartEvent";

    public bm() {
        super(ai.k);
    }

    @Override // com.huawei.hms.ads.af, com.huawei.hms.ads.ac
    public void execute(final Context context, String str, final RemoteCallResultCallback<String> remoteCallResultCallback) {
        ge.Code(Z, "start");
        Code(context, str, new ab() { // from class: com.huawei.hms.ads.bm.1
            @Override // com.huawei.hms.ads.ab
            public void Code(AdContentData adContentData) {
                ko.Code(context, adContentData);
                bm.this.V(remoteCallResultCallback, true);
            }
        });
    }
}
