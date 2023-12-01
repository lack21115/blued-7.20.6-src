package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.hms.ads.consent.inter.Consent;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/an.class */
public class an extends af {
    private static final int B = 1;
    private static final int Z = 0;

    public an() {
        super(ai.u);
    }

    @Override // com.huawei.hms.ads.af, com.huawei.hms.ads.ac
    public void execute(Context context, String str, RemoteCallResultCallback<String> remoteCallResultCallback) {
        boolean z = false;
        if (new JSONObject(str).optInt(com.huawei.openalliance.ad.constant.ao.Q, 0) == 1) {
            z = true;
        }
        Consent.getInstance(context).setUnderAgeOfPromise(z);
        V(remoteCallResultCallback, true);
    }
}
