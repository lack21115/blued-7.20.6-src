package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.beans.inner.SourceParam;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.utils.b;
import java.util.HashMap;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/em.class */
public class em extends hg<com.huawei.openalliance.ad.augreality.views.a> implements en<com.huawei.openalliance.ad.augreality.views.a> {
    private static final String V = em.class.getName();
    private Context I;

    public em(Context context, com.huawei.openalliance.ad.augreality.views.a aVar) {
        this.I = context;
        Code((em) aVar);
    }

    private void V(com.huawei.openalliance.ad.inter.data.k kVar, com.huawei.openalliance.ad.utils.aj ajVar) {
        if (kVar == null) {
            ge.I(V, "loadImage imageInfo is null");
            ajVar.Code();
            return;
        }
        SourceParam sourceParam = new SourceParam();
        sourceParam.I(kVar.Z());
        sourceParam.Code(52428800L);
        sourceParam.V(kVar.I());
        sourceParam.V(kVar.S());
        sourceParam.I(true);
        String str = null;
        if (this.Code != null) {
            str = this.Code.S();
        }
        com.huawei.openalliance.ad.utils.y.Code(this.I, sourceParam, str, ajVar);
    }

    private void V(String str) {
        if (this.Code == null) {
            return;
        }
        ko.Code(this.I, this.Code, (String) null, 0, 0, str, 1, b.Code(I()), (com.huawei.openalliance.ad.inter.data.m) null);
    }

    @Override // com.huawei.hms.ads.en
    public void Code(AdContentData adContentData) {
        if (adContentData == null) {
            return;
        }
        this.Code = adContentData;
    }

    @Override // com.huawei.hms.ads.en
    public void Code(com.huawei.openalliance.ad.inter.data.k kVar, com.huawei.openalliance.ad.utils.aj ajVar) {
        String str = V;
        ge.V(str, "checkArImageHashAndLoad " + kVar);
        if (kVar == null) {
            ge.I(V, "checkArImageHashAndLoad imageInfo is null");
        } else {
            V(kVar, ajVar);
        }
    }

    @Override // com.huawei.hms.ads.en
    public boolean Code() {
        com.huawei.openalliance.ad.uriaction.q Code = com.huawei.openalliance.ad.uriaction.r.Code(this.I, this.Code, new HashMap(0));
        if (Code.Code()) {
            V(Code.I());
            return true;
        }
        return true;
    }

    @Override // com.huawei.hms.ads.en
    public boolean V() {
        return false;
    }
}
