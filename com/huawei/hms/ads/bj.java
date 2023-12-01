package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/bj.class */
public class bj extends be {
    private static final String Z = "JsbReportPlayResumeEvent";

    public bj() {
        super(ai.j);
    }

    @Override // com.huawei.hms.ads.af, com.huawei.hms.ads.ac
    public void execute(final Context context, String str, final RemoteCallResultCallback<String> remoteCallResultCallback) {
        ge.Code(Z, "start");
        Code(context, str, new ab() { // from class: com.huawei.hms.ads.bj.1
            @Override // com.huawei.hms.ads.ab
            public void Code(AdContentData adContentData) {
                ko.Code(context, adContentData, com.huawei.openalliance.ad.constant.ac.S, (Long) null, (Long) null, (Integer) null, (Integer) null);
                bj.this.V(remoteCallResultCallback, true);
            }
        });
    }
}
