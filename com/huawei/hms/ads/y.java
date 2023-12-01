package com.huawei.hms.ads;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.ads.instreamad.InstreamAdLoadListener;
import com.huawei.openalliance.ad.inter.HiAd;
import com.huawei.openalliance.ad.inter.o;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/y.class */
public class y implements x, com.huawei.openalliance.ad.inter.listeners.n {
    private InstreamAdLoadListener B;
    private int C;
    private boolean D = false;
    private o.a F;
    private Context I;
    private int L;
    private int S;
    private String V;
    private com.huawei.openalliance.ad.inter.o Z;

    public y(Context context, String str) {
        this.V = str;
        Context applicationContext = context.getApplicationContext();
        this.I = applicationContext;
        this.F = new o.a(applicationContext);
        this.L = com.huawei.openalliance.ad.utils.l.I(context);
    }

    private void V(AdParam adParam) {
        o.a aVar;
        if (adParam == null || (aVar = this.F) == null) {
            return;
        }
        aVar.Code(dr.Code(adParam.V())).Code(new String[]{this.V}).Code(this.L).Code(false).V(true);
        com.huawei.openalliance.ad.inter.o Code = this.F.Code();
        this.Z = Code;
        Code.V(adParam.getTargetingContentUrl());
        this.Z.V(adParam.getGender());
        this.Z.Code(adParam.getKeywords());
        this.Z.I(adParam.I());
        this.Z.Code(adParam.C());
        HiAd.getInstance(this.I).setCountryCode(adParam.Z());
    }

    private void Z(int i) {
        InstreamAdLoadListener instreamAdLoadListener = this.B;
        if (instreamAdLoadListener != null) {
            instreamAdLoadListener.onAdFailed(i);
        }
    }

    @Override // com.huawei.hms.ads.x
    public void Code(int i) {
        this.C = i;
    }

    @Override // com.huawei.hms.ads.x
    public void Code(AdParam adParam) {
        String str;
        if (TextUtils.isEmpty(this.V)) {
            Z(1);
            str = "ad unit id is invalid.";
        } else if (this.C <= 0) {
            Z(1);
            str = "totalDuration is invalid.";
        } else if (!this.D) {
            j.Code().Code(this.I);
            V(adParam);
            com.huawei.openalliance.ad.inter.o oVar = this.Z;
            if (oVar != null) {
                this.D = true;
                oVar.Code(this, this.C, this.S);
                return;
            }
            return;
        } else {
            Z(4);
            str = "ad is loading.";
        }
        ge.V("InstreamAdLoadMediator", str);
    }

    @Override // com.huawei.hms.ads.x
    public void Code(InstreamAdLoadListener instreamAdLoadListener) {
        this.B = instreamAdLoadListener;
    }

    @Override // com.huawei.openalliance.ad.inter.listeners.n
    public void Code(Map<String, List<com.huawei.openalliance.ad.inter.data.h>> map) {
        this.D = false;
        if (!map.keySet().contains(this.V)) {
            Z(3);
            return;
        }
        List<com.huawei.openalliance.ad.inter.data.h> list = map.get(this.V);
        if (list == null || list.size() <= 0) {
            Z(3);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (com.huawei.openalliance.ad.inter.data.h hVar : list) {
            arrayList.add(new w(this.I, hVar));
        }
        InstreamAdLoadListener instreamAdLoadListener = this.B;
        if (instreamAdLoadListener != null) {
            instreamAdLoadListener.onAdLoaded(arrayList);
        }
    }

    @Override // com.huawei.hms.ads.x
    public boolean Code() {
        return this.D;
    }

    @Override // com.huawei.openalliance.ad.inter.listeners.n
    public void I(int i) {
        Z(dq.Code(i));
        this.D = false;
    }

    @Override // com.huawei.hms.ads.x
    public void V(int i) {
        this.S = i;
    }
}
