package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.hms.ads.kn;
import com.huawei.openalliance.ad.beans.inner.AnalysisEventReport;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.utils.b;
import java.util.HashMap;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/jr.class */
public class jr extends hg<lg> implements ke<lg> {
    private Context I;
    private com.huawei.openalliance.ad.inter.data.p Z;

    public jr(Context context, lg lgVar) {
        this.I = context;
        Code((jr) lgVar);
    }

    private void Code(com.huawei.openalliance.ad.uriaction.q qVar, com.huawei.openalliance.ad.inter.data.m mVar) {
        ko.Code(this.I, this.Code, 0, 0, qVar.I(), mVar, b.Code(I()), com.huawei.openalliance.ad.utils.ay.Code(I()));
    }

    @Override // com.huawei.hms.ads.ke
    public void Code() {
        ko.Code(this.I, this.Code, 0, 0, (List<String>) null);
    }

    @Override // com.huawei.hms.ads.ke
    public void Code(long j, int i) {
        ko.Code(this.I, this.Code, j, i);
    }

    @Override // com.huawei.hms.ads.ke
    public void Code(long j, int i, Integer num) {
        kn.a aVar = new kn.a();
        if (num != null) {
            aVar.V(Long.valueOf(com.huawei.openalliance.ad.utils.v.Code()));
        }
        aVar.Code(Long.valueOf(j)).Code(Integer.valueOf(i)).V(num).Code(b.Code(I()));
        ko.Code(this.I, this.Code, aVar.Code());
    }

    @Override // com.huawei.hms.ads.ke
    public void Code(com.huawei.openalliance.ad.inter.data.m mVar) {
        com.huawei.openalliance.ad.inter.data.p pVar = this.Z;
        if (pVar == null) {
            return;
        }
        pVar.Code(true);
        ge.Code("PlacementAdPresenter", "begin to deal click");
        HashMap hashMap = new HashMap();
        hashMap.put("appId", this.Z.t());
        hashMap.put(com.huawei.openalliance.ad.uriaction.i.V, this.Z.Code());
        com.huawei.openalliance.ad.uriaction.q Code = com.huawei.openalliance.ad.uriaction.r.Code(this.I, this.Code, hashMap);
        if (Code.Code()) {
            Code(Code, mVar);
        }
    }

    @Override // com.huawei.hms.ads.ke
    public void Code(com.huawei.openalliance.ad.inter.data.p pVar) {
        this.Z = pVar;
        this.Code = pVar != null ? pVar.l() : null;
    }

    @Override // com.huawei.hms.ads.ke
    public void Code(String str, int i, int i2, com.huawei.openalliance.ad.inter.data.p pVar) {
        AdContentData l = pVar.l();
        AnalysisEventReport analysisEventReport = new AnalysisEventReport();
        analysisEventReport.Code(str);
        analysisEventReport.Code(i);
        analysisEventReport.V(i2);
        analysisEventReport.Code(l);
        if (l != null) {
            analysisEventReport.S(l.az());
            analysisEventReport.F(l.C());
            analysisEventReport.C(l.S());
            analysisEventReport.I(l.aA());
        }
        com.huawei.openalliance.ad.ipc.g.V(this.I).Code("rptPlacePlayErr", com.huawei.openalliance.ad.utils.z.V(analysisEventReport), null, null);
    }

    @Override // com.huawei.hms.ads.ke
    public void Code(boolean z) {
        ko.Code(this.I, this.Code, z);
    }

    @Override // com.huawei.hms.ads.ke
    public void V() {
        ko.Code(this.I, this.Code);
    }
}
