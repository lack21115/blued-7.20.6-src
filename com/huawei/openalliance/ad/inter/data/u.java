package com.huawei.openalliance.ad.inter.data;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.ads.dt;
import com.huawei.hms.ads.ge;
import com.huawei.hms.ads.km;
import com.huawei.hms.ads.reward.RewardVerifyConfig;
import com.huawei.openalliance.ad.beans.metadata.AdSource;
import com.huawei.openalliance.ad.beans.metadata.MetaData;
import com.huawei.openalliance.ad.utils.au;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/inter/data/u.class */
public class u implements j {
    private static final String Code = "UnifyAd";
    private MetaData I;
    private AdContentData V;
    private AppInfo Z;

    public u(AdContentData adContentData) {
        this.V = adContentData;
        this.I = adContentData.Z();
    }

    @Override // com.huawei.openalliance.ad.inter.data.j
    public int Code() {
        AdContentData adContentData = this.V;
        if (adContentData == null) {
            return 0;
        }
        return adContentData.Code();
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public void Code(Context context) {
        if (this.V == null) {
            return;
        }
        V(context);
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public void Code(RewardVerifyConfig rewardVerifyConfig) {
        AdContentData adContentData = this.V;
        if (adContentData == null || rewardVerifyConfig == null) {
            return;
        }
        adContentData.p(rewardVerifyConfig.getData());
        this.V.q(rewardVerifyConfig.getUserId());
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public String D() {
        AdContentData adContentData = this.V;
        if (adContentData == null) {
            return null;
        }
        return adContentData.S();
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public String F() {
        MetaData metaData = this.I;
        if (metaData != null) {
            return au.V(metaData.Code());
        }
        return null;
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public RewardVerifyConfig H() {
        if (this.V != null) {
            RewardVerifyConfig.Builder builder = new RewardVerifyConfig.Builder();
            builder.setData(this.V.ao());
            builder.setUserId(this.V.ap());
            return builder.build();
        }
        return null;
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public String K() {
        MetaData metaData = this.I;
        String str = null;
        if (metaData != null) {
            AdSource Code2 = AdSource.Code(metaData.i());
            str = null;
            if (Code2 != null) {
                str = au.V(Code2.Code());
            }
        }
        return str;
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public String L() {
        MetaData metaData = this.I;
        if (metaData != null) {
            return metaData.d();
        }
        return null;
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public String M() {
        MetaData metaData = this.I;
        String str = null;
        if (metaData != null) {
            AdSource Code2 = AdSource.Code(metaData.i());
            str = null;
            if (Code2 != null) {
                str = au.V(Code2.V());
            }
        }
        return str;
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public String O() {
        AdContentData adContentData = this.V;
        if (adContentData == null) {
            return null;
        }
        return adContentData.aB();
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public String P() {
        AdContentData adContentData = this.V;
        if (adContentData == null) {
            return null;
        }
        return adContentData.aC();
    }

    public String V() {
        AdContentData adContentData = this.V;
        if (adContentData != null) {
            return adContentData.r();
        }
        return null;
    }

    public void V(Context context) {
        String str;
        if (dt.Code(context).V()) {
            str = "china rom should not call gotoWhyThisAdPage method";
        } else if (context != null) {
            String h = h();
            String str2 = h;
            if (TextUtils.isEmpty(h)) {
                str2 = g();
            }
            com.huawei.openalliance.ad.utils.v.Code(context, str2);
            return;
        } else {
            str = "context is null not call gotoWhyThisAdPage method";
        }
        ge.I(Code, str);
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public int a() {
        AdContentData adContentData = this.V;
        if (adContentData == null) {
            return 0;
        }
        return adContentData.h();
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public String b() {
        AdContentData adContentData = this.V;
        if (adContentData == null) {
            return null;
        }
        return adContentData.F();
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public String c() {
        MetaData metaData = this.I;
        if (metaData != null) {
            return au.V(metaData.F());
        }
        return null;
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public long d() {
        AdContentData adContentData = this.V;
        if (adContentData == null) {
            return 0L;
        }
        return adContentData.a();
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public long e() {
        AdContentData adContentData = this.V;
        if (adContentData == null) {
            return 0L;
        }
        return adContentData.L();
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public boolean f() {
        AdContentData adContentData = this.V;
        return adContentData == null || adContentData.L() < System.currentTimeMillis();
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public String g() {
        AdContentData adContentData = this.V;
        if (adContentData == null) {
            return null;
        }
        return adContentData.W();
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public String h() {
        AdContentData adContentData = this.V;
        if (adContentData == null) {
            return null;
        }
        return adContentData.X();
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public String i() {
        AdContentData adContentData = this.V;
        if (adContentData == null) {
            return null;
        }
        return adContentData.Y();
    }

    @Override // com.huawei.openalliance.ad.inter.data.j, com.huawei.openalliance.ad.inter.data.d
    public AdContentData l() {
        return this.V;
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public String m() {
        return this.V.C();
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public long r() {
        MetaData metaData = this.I;
        if (metaData != null) {
            return metaData.C();
        }
        return 500L;
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public int s() {
        MetaData metaData = this.I;
        if (metaData != null) {
            return metaData.S();
        }
        return 50;
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public AppInfo v() {
        AppInfo appInfo = this.Z;
        if (appInfo != null) {
            return appInfo;
        }
        AdContentData adContentData = this.V;
        if (adContentData == null) {
            return null;
        }
        AppInfo u = adContentData.u();
        this.Z = u;
        return u;
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public boolean x() {
        boolean Z = km.Z(V());
        if (!Z) {
            ge.V(Code, "native ad is not in whiteList, api call event report is not allowed.");
        }
        return Z;
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public int y() {
        return km.a(V());
    }
}
