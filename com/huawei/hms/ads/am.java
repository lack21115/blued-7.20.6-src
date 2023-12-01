package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.hms.ads.consent.bean.AdProvider;
import com.huawei.hms.ads.consent.constant.ConsentStatus;
import com.huawei.hms.ads.consent.inter.Consent;
import com.huawei.hms.ads.consent.inter.ConsentUpdateListener;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.ad.utils.aa;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/am.class */
public class am extends af {
    public am() {
        super(ai.s);
    }

    @Override // com.huawei.hms.ads.af, com.huawei.hms.ads.ac
    public void execute(Context context, String str, final RemoteCallResultCallback<String> remoteCallResultCallback) {
        Consent.getInstance(context).requestConsentUpdate(new ConsentUpdateListener() { // from class: com.huawei.hms.ads.am.1
            public void onFail(String str2) {
                af.Code(remoteCallResultCallback, am.this.Code, 3006, str2, true);
            }

            public void onSuccess(ConsentStatus consentStatus, boolean z, List<AdProvider> list) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(com.huawei.openalliance.ad.constant.ao.P, consentStatus.getValue());
                    jSONObject.put(com.huawei.openalliance.ad.constant.ao.R, z);
                    JSONArray jSONArray = new JSONArray();
                    if (!aa.Code(list)) {
                        for (AdProvider adProvider : list) {
                            JSONObject jSONObject2 = new JSONObject();
                            if (adProvider != null) {
                                jSONObject2.put("id", adProvider.getId());
                                jSONObject2.put("name", adProvider.getName());
                                jSONObject2.put(com.huawei.openalliance.ad.constant.ao.ab, adProvider.getServiceArea());
                                jSONObject2.put(com.huawei.openalliance.ad.constant.ao.ac, adProvider.getPrivacyPolicyUrl());
                            }
                            jSONArray.put(jSONObject2);
                        }
                    }
                    jSONObject.put(com.huawei.openalliance.ad.constant.ao.T, jSONArray);
                    af.Code(remoteCallResultCallback, am.this.Code, 1000, jSONObject.toString(), true);
                } catch (Throwable th) {
                    af.Code(remoteCallResultCallback, am.this.Code, 3006, "consent info is null", true);
                }
            }
        });
    }
}
