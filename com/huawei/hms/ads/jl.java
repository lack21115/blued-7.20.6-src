package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.hms.ads.kn;
import com.huawei.openalliance.ad.utils.b;
import com.huawei.openalliance.ad.views.PPSNativeView;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/jl.class */
public class jl extends hg<lf> implements jy<lf> {
    private static final String V = jl.class.getSimpleName();
    private PPSNativeView.e B;
    private Context I;
    private com.huawei.openalliance.ad.inter.data.n Z;

    public jl(Context context, lf lfVar) {
        this.I = context;
        Code((jl) lfVar);
    }

    private void Code(com.huawei.openalliance.ad.uriaction.q qVar, com.huawei.openalliance.ad.inter.data.m mVar, Integer num) {
        ko.Code(this.I, this.Code, 0, 0, qVar.I(), num.intValue(), mVar, b.Code(I()), com.huawei.openalliance.ad.utils.ay.Code(I()));
    }

    @Override // com.huawei.hms.ads.jy
    public void Code() {
        ko.Code(this.I, this.Code);
    }

    @Override // com.huawei.hms.ads.jy
    public void Code(long j, int i) {
        ko.Code(this.I, this.Code, j, i);
    }

    @Override // com.huawei.hms.ads.jy
    public void Code(com.huawei.openalliance.ad.inter.data.n nVar) {
        this.Z = nVar;
        this.Code = nVar != null ? nVar.l() : null;
    }

    @Override // com.huawei.hms.ads.jy
    public void Code(PPSNativeView.e eVar) {
        this.B = eVar;
    }

    @Override // com.huawei.hms.ads.jy
    public void Code(Long l, Integer num, Integer num2, boolean z) {
        kn.a aVar = new kn.a();
        if (z) {
            aVar.V(Long.valueOf(com.huawei.openalliance.ad.utils.v.Code()));
        }
        aVar.Code(l).Code(num).V(num2).Code(b.Code(I()));
        ko.Code(this.I, this.Code, aVar.Code());
    }

    @Override // com.huawei.hms.ads.jy
    public void Code(List<String> list) {
        ko.Code(this.I, this.Code, 0, 0, list);
    }

    @Override // com.huawei.hms.ads.jy
    public boolean Code(com.huawei.openalliance.ad.inter.data.m mVar, Integer num) {
        com.huawei.openalliance.ad.inter.data.n nVar = this.Z;
        if (nVar == null) {
            return false;
        }
        nVar.Code(true);
        ge.Code(V, "deal click");
        com.huawei.openalliance.ad.uriaction.q Code = com.huawei.openalliance.ad.uriaction.r.Code(this.I, this.Code, this.Z.ae());
        boolean Code2 = Code.Code();
        if (Code2) {
            Code(Code, mVar, num);
            PPSNativeView.e eVar = this.B;
            if (eVar != null) {
                eVar.V();
                this.B.I();
            }
        }
        return Code2;
    }

    @Override // com.huawei.hms.ads.jy
    public void V() {
        ko.V(this.I, this.Code);
    }

    @Override // com.huawei.hms.ads.jy
    public void V(String str) {
        if (this.Code == null) {
            return;
        }
        this.Code.b(str);
    }
}
