package com.huawei.hms.ads;

import android.content.Context;
import android.view.View;
import com.huawei.hms.ads.kn;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.utils.b;
import com.huawei.openalliance.ad.views.PPSNativeView;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/bv.class */
public class bv implements bu<View> {
    private static final String Code = bv.class.getSimpleName();
    private com.huawei.openalliance.ad.inter.data.n B;
    private PPSNativeView.e C;
    private View I;
    private Context V;
    private AdContentData Z;

    public bv(Context context, View view) {
        this.V = context;
        Code(view);
    }

    private void Code(com.huawei.openalliance.ad.uriaction.q qVar) {
        ko.Code(this.V, this.Z, 0, 0, qVar.I(), b.Code(I()), com.huawei.openalliance.ad.utils.ay.Code(I()));
    }

    @Override // com.huawei.hms.ads.bu
    public void Code() {
        ko.Code(this.V, this.Z);
    }

    @Override // com.huawei.hms.ads.bu
    public void Code(long j, int i) {
        ko.Code(this.V, this.Z, j, i);
    }

    public void Code(View view) {
        this.I = view;
    }

    @Override // com.huawei.hms.ads.bu
    public void Code(com.huawei.openalliance.ad.inter.data.n nVar) {
        this.B = nVar;
        this.Z = nVar != null ? nVar.l() : null;
    }

    @Override // com.huawei.hms.ads.bu
    public void Code(PPSNativeView.e eVar) {
        this.C = eVar;
    }

    @Override // com.huawei.hms.ads.bu
    public void Code(Long l, Integer num, Integer num2, boolean z) {
        kn.a aVar = new kn.a();
        if (z) {
            aVar.V(Long.valueOf(com.huawei.openalliance.ad.utils.v.Code()));
        }
        aVar.Code(l).Code(num).V(num2).Code(b.Code(I()));
        ko.Code(this.V, this.Z, aVar.Code());
    }

    @Override // com.huawei.hms.ads.bu
    public void Code(String str) {
        AdContentData adContentData = this.Z;
        if (adContentData == null) {
            return;
        }
        adContentData.V(str);
    }

    @Override // com.huawei.hms.ads.bu
    public void Code(List<String> list) {
        ko.Code(this.V, this.Z, 0, 0, list);
    }

    public View I() {
        return this.I;
    }

    @Override // com.huawei.hms.ads.bu
    public boolean V() {
        com.huawei.openalliance.ad.inter.data.n nVar = this.B;
        if (nVar == null) {
            return false;
        }
        nVar.Code(true);
        ge.Code(Code, "deal click");
        com.huawei.openalliance.ad.uriaction.q Code2 = com.huawei.openalliance.ad.uriaction.r.Code(this.V, this.Z, this.B.ae());
        boolean Code3 = Code2.Code();
        if (Code3) {
            Code(Code2);
            PPSNativeView.e eVar = this.C;
            if (eVar != null) {
                eVar.V();
                this.C.I();
            }
        }
        return Code3;
    }
}
