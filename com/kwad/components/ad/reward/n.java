package com.kwad.components.ad.reward;

import com.kwad.components.ad.reward.model.RewardCallBackRespInfo;
import com.kwad.sdk.utils.bi;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/n.class */
public final class n {
    public static void a(final int i, final j jVar) {
        com.kwad.sdk.core.network.m<com.kwad.components.core.n.d, RewardCallBackRespInfo> mVar = new com.kwad.sdk.core.network.m<com.kwad.components.core.n.d, RewardCallBackRespInfo>() { // from class: com.kwad.components.ad.reward.n.1
            private static RewardCallBackRespInfo R(String str) {
                JSONObject jSONObject = new JSONObject(str);
                RewardCallBackRespInfo rewardCallBackRespInfo = new RewardCallBackRespInfo();
                rewardCallBackRespInfo.parseJson(jSONObject);
                return rewardCallBackRespInfo;
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.a
            /* renamed from: gq */
            public com.kwad.components.core.n.d createRequest() {
                return new com.kwad.components.core.n.d(i, jVar.mAdTemplate);
            }

            @Override // com.kwad.sdk.core.network.m
            public final /* synthetic */ RewardCallBackRespInfo parseData(String str) {
                return R(str);
            }
        };
        if (i == 1) {
            mVar.request(n(jVar));
        } else if (i == 2) {
            mVar.request(o(jVar));
        }
    }

    public static void a(j jVar, long j, long j2, long j3) {
        boolean p = p(jVar);
        long cB = p ? com.kwad.sdk.core.response.a.a.cB(com.kwad.sdk.core.response.a.d.cb(jVar.mAdTemplate)) : 0L;
        if (jVar.po || !p || !jVar.mCheckExposureResult || j <= ((j2 - 800) - j3) - cB || cB <= 0) {
            return;
        }
        if (com.kwad.sdk.core.response.a.a.cC(com.kwad.sdk.core.response.a.d.cb(jVar.mAdTemplate))) {
            jVar.pn = 1;
            a(2, jVar);
        } else {
            jVar.mAdOpenInteractionListener.onRewardVerify();
        }
        jVar.po = true;
    }

    private static com.kwad.sdk.core.network.p<com.kwad.components.core.n.d, RewardCallBackRespInfo> n(final j jVar) {
        return new com.kwad.sdk.core.network.p<com.kwad.components.core.n.d, RewardCallBackRespInfo>() { // from class: com.kwad.components.ad.reward.n.2
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
            /* renamed from: a */
            public void onStartRequest(com.kwad.components.core.n.d dVar) {
                dVar.Om = System.currentTimeMillis();
                com.kwad.components.ad.reward.check.a.c(j.this.mAdTemplate, 1);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
            /* renamed from: a */
            public void onError(com.kwad.components.core.n.d dVar, int i, String str) {
                super.onError(dVar, i, str);
                bi.postOnUiThread(new Runnable() { // from class: com.kwad.components.ad.reward.n.2.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        j.this.mCheckExposureResult = false;
                    }
                });
                com.kwad.components.ad.reward.check.a.a(j.this.mAdTemplate, 1, System.currentTimeMillis() - dVar.Om, i, str);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
            /* renamed from: a */
            public void onSuccess(com.kwad.components.core.n.d dVar, final RewardCallBackRespInfo rewardCallBackRespInfo) {
                bi.postOnUiThread(new Runnable() { // from class: com.kwad.components.ad.reward.n.2.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        j jVar2 = j.this;
                        boolean z = true;
                        if (rewardCallBackRespInfo.result != 1) {
                            z = false;
                        }
                        jVar2.mCheckExposureResult = z;
                    }
                });
                com.kwad.components.ad.reward.check.a.a(j.this.mAdTemplate, 1, System.currentTimeMillis() - dVar.Om, rewardCallBackRespInfo.result, rewardCallBackRespInfo.errorMsg);
            }
        };
    }

    private static com.kwad.sdk.core.network.p<com.kwad.components.core.n.d, RewardCallBackRespInfo> o(final j jVar) {
        return new com.kwad.sdk.core.network.p<com.kwad.components.core.n.d, RewardCallBackRespInfo>() { // from class: com.kwad.components.ad.reward.n.3
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
            /* renamed from: a */
            public void onStartRequest(com.kwad.components.core.n.d dVar) {
                dVar.Om = System.currentTimeMillis();
                com.kwad.components.ad.reward.check.a.c(j.this.mAdTemplate, 2);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
            /* renamed from: a */
            public void onError(com.kwad.components.core.n.d dVar, int i, String str) {
                super.onError(dVar, i, str);
                bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.reward.n.3.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        j.this.pn = 2;
                    }
                });
                com.kwad.components.ad.reward.check.a.a(j.this.mAdTemplate, 2, System.currentTimeMillis() - dVar.Om, i, str);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
            /* renamed from: a */
            public void onSuccess(com.kwad.components.core.n.d dVar, final RewardCallBackRespInfo rewardCallBackRespInfo) {
                bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.reward.n.3.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        j jVar2;
                        int i = 1;
                        if (rewardCallBackRespInfo.result == 1) {
                            jVar2 = j.this;
                        } else {
                            jVar2 = j.this;
                            i = 2;
                        }
                        jVar2.pn = i;
                        j.this.mAdOpenInteractionListener.onRewardVerify();
                    }
                });
                com.kwad.components.ad.reward.check.a.a(j.this.mAdTemplate, 2, System.currentTimeMillis() - dVar.Om, rewardCallBackRespInfo.result, rewardCallBackRespInfo.errorMsg);
            }
        };
    }

    private static boolean p(j jVar) {
        return !jVar.po && com.kwad.sdk.core.response.a.a.cD(com.kwad.sdk.core.response.a.d.cb(jVar.mAdTemplate));
    }
}
