package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/bd.class */
public class bd extends af {
    private static final String Z = "JsbUnregisterAppStatusProxy";

    public bd() {
        super(ai.w);
    }

    @Override // com.huawei.hms.ads.af, com.huawei.hms.ads.ac
    public void execute(final Context context, String str, RemoteCallResultCallback<String> remoteCallResultCallback) {
        Code(context, str, false, new ab() { // from class: com.huawei.hms.ads.bd.1
            @Override // com.huawei.hms.ads.ab
            public void Code(AdContentData adContentData) {
                if (adContentData == null || adContentData.u() == null) {
                    return;
                }
                com.huawei.hms.ads.jsb.a.Code(context).Code(adContentData.S());
            }
        });
    }
}
