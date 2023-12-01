package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/bb.class */
public class bb extends ap {
    public bb() {
        super(ai.F);
    }

    @Override // com.huawei.hms.ads.af, com.huawei.hms.ads.ac
    public void execute(final Context context, final String str, final RemoteCallResultCallback<String> remoteCallResultCallback) {
        Code(context, str, new ab() { // from class: com.huawei.hms.ads.bb.1
            @Override // com.huawei.hms.ads.ab
            public void Code(AdContentData adContentData) {
                final int[] iArr = {-1};
                if (adContentData != null) {
                    final com.huawei.openalliance.ad.inter.data.u uVar = new com.huawei.openalliance.ad.inter.data.u(adContentData);
                    com.huawei.openalliance.ad.utils.ba.Code(new Runnable() { // from class: com.huawei.hms.ads.bb.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            iArr[0] = bb.this.V(context, str).Z(context, uVar);
                        }
                    });
                }
                af.Code(remoteCallResultCallback, bb.this.Code, 1000, Integer.toString(iArr[0]), true);
            }
        });
    }
}
