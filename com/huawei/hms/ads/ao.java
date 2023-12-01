package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.hms.ads.consent.constant.ConsentStatus;
import com.huawei.hms.ads.consent.inter.Consent;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/ao.class */
public class ao extends af {
    public ao() {
        super(ai.t);
    }

    @Override // com.huawei.hms.ads.af, com.huawei.hms.ads.ac
    public void execute(Context context, String str, RemoteCallResultCallback<String> remoteCallResultCallback) {
        JSONObject jSONObject = new JSONObject(str);
        ConsentStatus consentStatus = ConsentStatus.UNKNOWN;
        Consent.getInstance(context).setConsentStatus(ConsentStatus.forValue(jSONObject.optInt(com.huawei.openalliance.ad.constant.ao.P, ConsentStatus.UNKNOWN.getValue())));
        V(remoteCallResultCallback, true);
    }
}
