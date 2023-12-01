package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/ax.class */
public class ax extends ap {
    public ax() {
        super(ai.b);
    }

    @Override // com.huawei.hms.ads.af, com.huawei.hms.ads.ac
    public void execute(final Context context, String str, final RemoteCallResultCallback<String> remoteCallResultCallback) {
        Code(context, str, new ab() { // from class: com.huawei.hms.ads.ax.1
            @Override // com.huawei.hms.ads.ab
            public void Code(AdContentData adContentData) {
                int i;
                if (adContentData != null) {
                    i = com.huawei.hms.ads.jsb.a.Code(context).Code().F(context, new com.huawei.openalliance.ad.inter.data.u(adContentData));
                } else {
                    i = 0;
                }
                af.Code(remoteCallResultCallback, ax.this.Code, 1000, Integer.valueOf(i), true);
            }
        });
    }
}
