package com.huawei.openalliance.ad.inter.data;

import com.huawei.openalliance.ad.beans.metadata.MetaData;
import com.huawei.openalliance.ad.beans.metadata.VideoInfo;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/inter/data/a.class */
public class a extends c implements e {
    private static final String I = "AwardAd";
    private static final long Z = 30424300;
    private VideoInfo B;
    private boolean C;
    private RewardItem F;
    private boolean S;

    public a(AdContentData adContentData) {
        super(adContentData);
        this.C = false;
        if (adContentData.G() == null || adContentData.H() == 0) {
            return;
        }
        this.F = new RewardItem(adContentData.G(), adContentData.H());
    }

    private VideoInfo Code() {
        MetaData k;
        if (this.B == null && (k = k()) != null) {
            this.B = k.V();
        }
        return this.B;
    }

    @Override // com.huawei.openalliance.ad.inter.data.e
    public RewardItem B() {
        return this.F;
    }

    public boolean C() {
        return this.S;
    }

    public void Code(RewardItem rewardItem) {
        this.F = rewardItem;
    }

    public void Code(boolean z) {
        this.S = z;
    }

    public void V(boolean z) {
        this.C = z;
    }

    public boolean V() {
        if (this.Code != null) {
            this.B = this.Code.p();
        }
        return this.B != null;
    }

    @Override // com.huawei.openalliance.ad.inter.data.e
    public boolean Z() {
        return this.C;
    }
}
