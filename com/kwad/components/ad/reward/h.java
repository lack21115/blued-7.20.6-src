package com.kwad.components.ad.reward;

import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.bw;
import com.kwad.sdk.core.network.BaseResultData;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/h.class */
public final class h {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/h$a.class */
    public static final class a {
        private static h oK = new h((byte) 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/h$b.class */
    public static final class b extends com.kwad.sdk.core.network.m<i, BaseResultData> {
        private AdTemplate adTemplate;
        private com.kwad.sdk.core.network.p<i, BaseResultData> oL = new com.kwad.sdk.core.network.p<i, BaseResultData>() { // from class: com.kwad.components.ad.reward.h.b.1
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
            /* renamed from: a */
            public void onError(i iVar, int i, String str) {
                super.onError(iVar, i, str);
                com.kwad.components.core.m.a.pb().c(b.this.adTemplate, 1, str);
                com.kwad.sdk.core.d.b.i("RewardCallbackVerifyHelper", "callbackUrlInfo verify failed");
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
            /* renamed from: a */
            public void onSuccess(i iVar, BaseResultData baseResultData) {
                super.onSuccess(iVar, baseResultData);
                com.kwad.components.core.m.a.pb().c(b.this.adTemplate, 0, bw.o);
                com.kwad.sdk.core.d.b.i("RewardCallbackVerifyHelper", "callbackUrlInfo verify success");
            }
        };

        public b(AdTemplate adTemplate) {
            this.adTemplate = adTemplate;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // com.kwad.sdk.core.network.a
        /* renamed from: fz */
        public i createRequest() {
            return new i(this.adTemplate);
        }

        public final void fy() {
            request(this.oL);
        }

        @Override // com.kwad.sdk.core.network.m
        public final BaseResultData parseData(String str) {
            BaseResultData baseResultData = new BaseResultData() { // from class: com.kwad.components.ad.reward.RewardCallbackVerifyHelper$ServerCallbackNetworking$2
            };
            if (!TextUtils.isEmpty(str)) {
                try {
                    baseResultData.parseJson(new JSONObject(str));
                    return baseResultData;
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.b.printStackTrace(th);
                }
            }
            return baseResultData;
        }
    }

    private h() {
    }

    /* synthetic */ h(byte b2) {
        this();
    }

    public static h fw() {
        return a.oK;
    }

    private static void n(AdTemplate adTemplate) {
        new b(adTemplate).fy();
    }

    public final void m(AdTemplate adTemplate) {
        com.kwad.sdk.core.d.b.d("RewardCallbackVerifyHelper", "handleRewardVerify");
        AdInfo cb = com.kwad.sdk.core.response.a.d.cb(adTemplate);
        if (TextUtils.isEmpty(com.kwad.sdk.core.response.a.a.bD(cb))) {
            q.b(adTemplate, cb);
        } else {
            n(adTemplate);
        }
    }
}
