package com.huawei.openalliance.ad.uriaction;

import android.content.Context;
import com.huawei.hms.ads.ge;
import com.huawei.hms.ads.ko;
import com.huawei.openalliance.ad.beans.metadata.ApkInfo;
import com.huawei.openalliance.ad.beans.metadata.MetaData;
import com.huawei.openalliance.ad.inter.data.AdContentData;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/uriaction/c.class */
public class c extends q {
    private static final String Code = "AppEnterAction";

    public c(Context context, AdContentData adContentData) {
        super(context, adContentData);
    }

    @Override // com.huawei.openalliance.ad.uriaction.q
    public boolean Code() {
        ApkInfo c2;
        ge.V(Code, "handle app enter action");
        MetaData Z = this.Z.Z();
        if ((Z == null || (c2 = Z.c()) == null) ? false : com.huawei.openalliance.ad.utils.e.I(this.I, c2.Code())) {
            Code("app");
            ko.Code(this.I, this.Z, (Integer) 1);
            return true;
        }
        return V();
    }
}
