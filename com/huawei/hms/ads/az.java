package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/az.class */
public class az extends af {
    private static final String Z = "JsbRegisterAppStatusProxy";

    public az() {
        super(ai.v);
    }

    @Override // com.huawei.hms.ads.af, com.huawei.hms.ads.ac
    public void execute(final Context context, String str, RemoteCallResultCallback<String> remoteCallResultCallback) {
        Code(context, str, false, new ab() { // from class: com.huawei.hms.ads.az.1
            @Override // com.huawei.hms.ads.ab
            public void Code(AdContentData adContentData) {
                if (adContentData != null) {
                    com.huawei.hms.ads.jsb.a.Code(context).Code(adContentData.S(), adContentData.u());
                }
            }
        });
    }
}
