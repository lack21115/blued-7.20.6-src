package com.huawei.hms.ads;

import android.content.Context;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/g.class */
public class g {
    private Context I;
    private com.huawei.openalliance.ad.inter.data.n V;

    public g(Context context, com.huawei.openalliance.ad.inter.data.n nVar) {
        this.V = nVar;
        this.I = context;
    }

    public void Code() {
        com.huawei.openalliance.ad.inter.data.n nVar = this.V;
        if (nVar != null) {
            ko.Code(this.I, nVar.l());
        }
    }

    public void Code(long j, int i) {
        com.huawei.openalliance.ad.inter.data.n nVar = this.V;
        if (nVar != null) {
            ko.Code(this.I, nVar.l(), j, i);
        }
    }

    public void Code(Long l, Integer num, Integer num2, String str) {
        com.huawei.openalliance.ad.inter.data.n nVar = this.V;
        if (nVar != null) {
            ko.Code(this.I, nVar.l(), l, num, num2, str);
        }
    }

    public void Code(String str) {
        com.huawei.openalliance.ad.inter.data.n nVar = this.V;
        if (nVar == null) {
            ge.V("AdEventProcessor", " native ad is empty");
        } else {
            ko.Code(this.I, nVar.l(), 0, 0, (String) null, str);
        }
    }

    public void Code(String str, String str2) {
        com.huawei.openalliance.ad.inter.data.n nVar = this.V;
        if (nVar != null) {
            ko.Code(this.I, nVar.l(), 0, 0, str, str2);
        }
    }

    public void Code(List<String> list) {
        com.huawei.openalliance.ad.inter.data.n nVar = this.V;
        if (nVar != null) {
            ko.Code(this.I, nVar.l(), 0, 0, list);
        }
    }

    public void V(List<String> list) {
        com.huawei.openalliance.ad.inter.data.n nVar = this.V;
        if (nVar != null) {
            ko.Code(this.I, nVar.l(), 0, 0, list);
        }
    }
}
