package com.huawei.hms.ads;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.ads.jsb.inner.data.JsbCallBackData;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.RewardItem;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/fv.class */
public class fv extends af {

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/fv$a.class */
    static class a implements com.huawei.openalliance.ad.inter.listeners.f {
        RewardItem Code;
        private RemoteCallResultCallback<String> I;
        private String V;

        a(RemoteCallResultCallback<String> remoteCallResultCallback, String str, RewardItem rewardItem) {
            this.Code = rewardItem;
            this.I = remoteCallResultCallback;
            this.V = str;
        }

        @Override // com.huawei.openalliance.ad.inter.listeners.f
        public void B() {
            af.Code(this.I, this.V, 1000, new JsbCallBackData(this.Code, false, ag.Z));
        }

        @Override // com.huawei.openalliance.ad.inter.listeners.f
        public void Code() {
            af.Code(this.I, this.V, 1000, new JsbCallBackData(null, false, ag.I));
        }

        @Override // com.huawei.openalliance.ad.inter.listeners.f
        public void Code(int i, int i2) {
            af.Code(this.I, this.V, 1000, new JsbCallBackData(null, false, ag.B));
        }

        @Override // com.huawei.openalliance.ad.inter.listeners.f
        public void I() {
            af.Code(this.I, this.V, 1000, new JsbCallBackData(null, false, ag.S));
        }

        @Override // com.huawei.openalliance.ad.inter.listeners.f
        public void V() {
            af.Code(this.I, this.V, 1000, new JsbCallBackData(null, false, ag.C));
        }

        @Override // com.huawei.openalliance.ad.inter.listeners.f
        public void Z() {
            af.Code(this.I, this.V, 1000, new JsbCallBackData(null, false, ag.V));
        }
    }

    public fv() {
        super(ai.h);
    }

    @Override // com.huawei.hms.ads.af, com.huawei.hms.ads.ac
    public void execute(final Context context, final String str, final RemoteCallResultCallback<String> remoteCallResultCallback) {
        Code(context, str, true, new ab() { // from class: com.huawei.hms.ads.fv.1
            @Override // com.huawei.hms.ads.ab
            public void Code(AdContentData adContentData) {
                if (adContentData == null) {
                    ge.Code("JsbStartRewardAdActivity", "adContentData is null, start activity failed");
                    af.Code(remoteCallResultCallback, fv.this.Code, 3002, null, true);
                    return;
                }
                com.huawei.openalliance.ad.inter.data.s sVar = new com.huawei.openalliance.ad.inter.data.s(adContentData);
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    String optString = jSONObject.optString(com.huawei.openalliance.ad.constant.ao.t);
                    String optString2 = jSONObject.optString(com.huawei.openalliance.ad.constant.ao.q);
                    boolean optBoolean = jSONObject.optBoolean(com.huawei.openalliance.ad.constant.ao.au, false);
                    int optInt = jSONObject.optInt("audioFocusType", 1);
                    if (!TextUtils.isEmpty(optString)) {
                        sVar.Code(optString);
                    }
                    if (!TextUtils.isEmpty(optString2)) {
                        sVar.V(optString2);
                    }
                    if (optInt == 1 || optInt == 2 || optInt == 0) {
                        sVar.Code(optInt);
                    }
                    sVar.a_(optBoolean);
                } catch (Throwable th) {
                    ge.Code("JsbStartRewardAdActivity", "content parse error");
                }
                sVar.Code(fv.this.Code(context), new a(remoteCallResultCallback, fv.this.Code, sVar.B()));
                fv.this.V(remoteCallResultCallback, false);
            }
        });
    }
}
