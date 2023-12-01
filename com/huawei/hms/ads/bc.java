package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/bc.class */
public class bc extends ap {
    public bc() {
        super(ai.S);
    }

    @Override // com.huawei.hms.ads.af, com.huawei.hms.ads.ac
    public void execute(final Context context, final String str, final RemoteCallResultCallback<String> remoteCallResultCallback) {
        Code(context, str, true, new ab() { // from class: com.huawei.hms.ads.bc.1
            @Override // com.huawei.hms.ads.ab
            public void Code(AdContentData adContentData) {
                RemoteCallResultCallback remoteCallResultCallback2;
                String str2;
                int i;
                if (adContentData != null) {
                    final com.huawei.openalliance.ad.inter.data.u uVar = new com.huawei.openalliance.ad.inter.data.u(adContentData);
                    if (bc.this.Code(adContentData)) {
                        com.huawei.openalliance.ad.utils.ba.Code(new Runnable() { // from class: com.huawei.hms.ads.bc.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                af.Code(remoteCallResultCallback, bc.this.Code, 1000, Integer.valueOf(bc.this.V(context, str).Code(context, uVar)), true);
                            }
                        });
                        return;
                    }
                    remoteCallResultCallback2 = remoteCallResultCallback;
                    str2 = bc.this.Code;
                    i = 3004;
                } else {
                    remoteCallResultCallback2 = remoteCallResultCallback;
                    str2 = bc.this.Code;
                    i = 3002;
                }
                af.Code(remoteCallResultCallback2, str2, i, null, true);
            }
        });
    }
}
