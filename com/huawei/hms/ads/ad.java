package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.beans.metadata.MetaData;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.ad.utils.b;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/ad.class */
public class ad extends af {
    private static final String Z = "JsbAdClick";

    public ad() {
        super(ai.C);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(com.huawei.openalliance.ad.uriaction.q qVar, Context context, AdContentData adContentData, com.huawei.openalliance.ad.inter.data.m mVar) {
        ko.Code(context, adContentData, (String) null, 0, 0, qVar.I(), 12, b.Code(context), mVar);
    }

    @Override // com.huawei.hms.ads.af, com.huawei.hms.ads.ac
    public void execute(final Context context, final String str, final RemoteCallResultCallback<String> remoteCallResultCallback) {
        ge.Code(Z, "start");
        final int optInt = new JSONObject(str).optInt("adType", -1);
        Code(context, str, true, new ab() { // from class: com.huawei.hms.ads.ad.1
            @Override // com.huawei.hms.ads.ab
            public void Code(AdContentData adContentData) {
                int i;
                if (adContentData != null) {
                    MetaData Z2 = adContentData.Z();
                    if (Z2 != null) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("appId", Z2.L());
                        hashMap.put(com.huawei.openalliance.ad.uriaction.i.V, Z2.D());
                        if (optInt == 3 && adContentData.p() != null) {
                            com.huawei.openalliance.ad.inter.data.v vVar = new com.huawei.openalliance.ad.inter.data.v(adContentData.p());
                            hashMap.put(com.huawei.openalliance.ad.constant.at.m, adContentData.B());
                            hashMap.put(com.huawei.openalliance.ad.constant.at.n, String.valueOf(adContentData.z()));
                            hashMap.put(com.huawei.openalliance.ad.constant.at.q, adContentData.y() ? fw.Code : "false");
                            hashMap.put(com.huawei.openalliance.ad.constant.at.p, vVar.a());
                        }
                        com.huawei.openalliance.ad.uriaction.q Code = com.huawei.openalliance.ad.uriaction.r.Code(ad.this.Code(context), adContentData, hashMap);
                        if (!Code.Code()) {
                            ge.Code(ad.Z, "fail open land page");
                            i = 3003;
                        } else if (ad.this.Code(adContentData)) {
                            ad adVar = ad.this;
                            adVar.Code(Code, context, adContentData, adVar.C(str));
                        } else {
                            ge.V(ad.Z, "ad is not in whitelist");
                            i = 3004;
                        }
                    }
                    i = 1000;
                } else {
                    ge.Code(ad.Z, "ad not exist");
                    i = 3002;
                }
                af.Code(remoteCallResultCallback, ad.this.Code, i, null, true);
            }
        });
    }
}
