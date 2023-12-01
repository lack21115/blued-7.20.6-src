package com.huawei.hms.ads;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/aj.class */
class aj extends af {
    private static final int B = -1;
    private static final int Z = 0;

    public aj() {
        super(ai.s);
    }

    @Override // com.huawei.hms.ads.af, com.huawei.hms.ads.ac
    public void execute(final Context context, String str, final RemoteCallResultCallback<String> remoteCallResultCallback) {
        if (dt.Code(context).V()) {
            Code(remoteCallResultCallback, this.Code, 3005, null, true);
        } else {
            Code(context, str, new ab() { // from class: com.huawei.hms.ads.aj.1
                @Override // com.huawei.hms.ads.ab
                public void Code(AdContentData adContentData) {
                    String str2;
                    if (adContentData == null) {
                        af.Code(remoteCallResultCallback, aj.this.Code, 3002, null, true);
                        return;
                    }
                    String X = adContentData.X();
                    if (TextUtils.isEmpty(X)) {
                        str2 = adContentData.W();
                    } else {
                        str2 = X;
                        if (TextUtils.isEmpty(X)) {
                            str2 = com.huawei.openalliance.ad.constant.t.al;
                        }
                    }
                    af.Code(remoteCallResultCallback, aj.this.Code, 1000, Integer.valueOf(com.huawei.openalliance.ad.utils.v.Code(context, str2) ? 0 : -1), true);
                }
            });
        }
    }
}
