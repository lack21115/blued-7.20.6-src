package com.huawei.openalliance.ad.uriaction;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hag.abilitykit.api.KitSdkManager;
import com.huawei.hag.abilitykit.dispatch.callback.StartAbilityCallBack;
import com.huawei.hms.ads.ge;
import com.huawei.hms.ads.ko;
import com.huawei.openalliance.ad.constant.ac;
import com.huawei.openalliance.ad.constant.s;
import com.huawei.openalliance.ad.constant.t;
import com.huawei.openalliance.ad.fadata.PPSAbilityDataContent;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.uriaction.RequestMsgBuilder;
import com.huawei.openalliance.ad.utils.z;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/uriaction/e.class */
public class e extends q {
    private static final String Code = "FeatureAbilityAction";

    public e(Context context, AdContentData adContentData) {
        super(context, adContentData);
    }

    @Override // com.huawei.openalliance.ad.uriaction.q
    public boolean Code() {
        try {
            ge.V(Code, "handle Feature ability action");
            if (!com.huawei.openalliance.ad.utils.q.V()) {
                ge.V(Code, "UnSupport HAG!");
                return V();
            }
            if (this.Z != null && !TextUtils.isEmpty(this.Z.aB())) {
                ge.Code(Code, "AbilityDetailInfo is %s", this.Z.aB());
                ge.Code(Code, "HwChannelID is %s", this.Z.aC());
                PPSAbilityDataContent pPSAbilityDataContent = (PPSAbilityDataContent) z.V(this.Z.aB(), PPSAbilityDataContent.class, new Class[0]);
                if (pPSAbilityDataContent == null) {
                    ge.V(Code, "abilityDataContent is not json!");
                    return V();
                }
                pPSAbilityDataContent.Code(new FaParams(this.I.getPackageName(), this.Z.aC()).I());
                KitSdkManager.getInstance().startAbilityByAbilityInfo(this.I, z.V(new RequestMsgBuilder.a().Code(this.I.getPackageName()).V(t.cA).Code(pPSAbilityDataContent).Code()), new StartAbilityCallBack() { // from class: com.huawei.openalliance.ad.uriaction.e.1
                    public void onFailed(int i, String str) {
                        ge.V(e.Code, "start ability failed, retErrCode is %s, errMsg is %s", Integer.valueOf(i), str);
                        ko.Code(e.this.I, e.this.Z, ac.d, (Integer) 1, Integer.valueOf(i));
                        if (e.this.B != null) {
                            e.this.B.Code(-1);
                        }
                        e.this.V();
                    }

                    public void onSuccess(int i) {
                        ge.V(e.Code, "start ability success, retCode is %s", Integer.valueOf(i));
                        ko.Code(e.this.I, e.this.Z, ac.f22939c, (Integer) 1, (Integer) null);
                    }
                });
                Code(s.I);
                return true;
            }
            ge.V(Code, "parameters is empty!");
            return V();
        } catch (Throwable th) {
            ge.I(Code, "handle uri exception: %s", th.getClass().getSimpleName());
            return V();
        }
    }
}
