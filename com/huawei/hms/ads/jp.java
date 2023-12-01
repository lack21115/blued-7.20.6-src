package com.huawei.hms.ads;

import android.content.Context;
import android.view.View;
import com.huawei.hms.ads.kn;
import com.huawei.openalliance.ad.utils.b;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/jp.class */
public class jp extends hg<le> implements kb {
    private com.huawei.openalliance.ad.inter.data.l B;
    private com.huawei.openalliance.ad.inter.listeners.a C;
    private Context Z;
    private boolean S = false;
    private boolean F = false;

    public jp(Context context, le leVar) {
        this.Z = context.getApplicationContext();
        Code((jp) leVar);
    }

    private void Code(com.huawei.openalliance.ad.uriaction.q qVar, int i, com.huawei.openalliance.ad.inter.data.m mVar) {
        ko.Code(this.Z, this.Code, 0, 0, qVar.I(), i, mVar, b.Code(I()), com.huawei.openalliance.ad.utils.ay.Code(I()));
    }

    private void Code(Map<String, String> map) {
        com.huawei.openalliance.ad.inter.data.l lVar;
        if (map == null || map.isEmpty() || (lVar = this.B) == null || lVar.C() == null) {
            return;
        }
        int L = this.B.C().L();
        int i = L;
        if (Math.abs(this.B.C().I() - L) < 1000) {
            i = 0;
        }
        ge.V("PPSLinkedVideoViewPresenter", "buildLinkedAdConfig, duration: %s, set progress from LinkedSplash view:%s ", Integer.valueOf(this.B.C().I()), Integer.valueOf(i));
        map.put(com.huawei.openalliance.ad.constant.at.q, this.B.C().h() ? fw.Code : "false");
        map.put(com.huawei.openalliance.ad.constant.at.p, this.B.C().a());
        map.put(com.huawei.openalliance.ad.constant.at.o, String.valueOf(i));
        map.put(com.huawei.openalliance.ad.constant.at.r, this.B.T());
        map.put(com.huawei.openalliance.ad.constant.at.m, this.B.o());
        map.put(com.huawei.openalliance.ad.constant.at.n, String.valueOf(10));
    }

    private boolean D() {
        return this.S;
    }

    private void I(boolean z) {
        this.S = z;
    }

    @Override // com.huawei.hms.ads.kb
    public void C() {
        ko.Code(this.Z, this.Code, com.huawei.openalliance.ad.constant.ac.B, (Long) null, (Long) null, (Integer) null, (Integer) null);
    }

    @Override // com.huawei.hms.ads.hg, com.huawei.hms.ads.hh
    /* renamed from: Code */
    public le I() {
        return (le) super.I();
    }

    @Override // com.huawei.hms.ads.kb
    public void Code(long j, int i) {
        ko.Code(this.Z, this.Code, j, i);
    }

    @Override // com.huawei.hms.ads.kb
    public void Code(long j, long j2, long j3, long j4) {
        ko.Code(this.Z, this.Code, com.huawei.openalliance.ad.constant.ac.Z, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf((int) j3), Integer.valueOf((int) j4));
    }

    @Override // com.huawei.hms.ads.kb
    public void Code(com.huawei.openalliance.ad.inter.listeners.a aVar) {
        this.C = aVar;
    }

    @Override // com.huawei.hms.ads.kb
    public void Code(Long l, Integer num, Integer num2, boolean z) {
        if (D()) {
            ge.I("PPSLinkedVideoViewPresenter", "show event already reported before, ignore this");
            return;
        }
        com.huawei.openalliance.ad.inter.listeners.a aVar = this.C;
        if (aVar != null) {
            aVar.Code();
        }
        I(true);
        kn.a aVar2 = new kn.a();
        if (z) {
            aVar2.V(Long.valueOf(com.huawei.openalliance.ad.utils.v.Code()));
        }
        aVar2.Code(l).Code(num).V(num2).Code(b.Code(I()));
        ko.Code(this.Z, this.Code, aVar2.Code());
    }

    @Override // com.huawei.hms.ads.hg, com.huawei.hms.ads.kb
    public void Code(String str) {
        super.Code(str);
        I(false);
    }

    @Override // com.huawei.hms.ads.kb
    public void Code(boolean z) {
        ko.Code(this.Z, this.Code, z);
    }

    @Override // com.huawei.hms.ads.kb
    public boolean Code(int i, com.huawei.openalliance.ad.inter.data.m mVar) {
        com.huawei.openalliance.ad.inter.data.l lVar = this.B;
        if (lVar == null) {
            return false;
        }
        lVar.V(true);
        ge.V("PPSLinkedVideoViewPresenter", "begin to deal click");
        HashMap hashMap = new HashMap();
        hashMap.put("appId", this.B.ag());
        hashMap.put(com.huawei.openalliance.ad.uriaction.i.V, this.B.af());
        Code(hashMap);
        com.huawei.openalliance.ad.inter.listeners.a aVar = this.C;
        if (aVar != null) {
            aVar.V();
        }
        com.huawei.openalliance.ad.uriaction.q Code = com.huawei.openalliance.ad.uriaction.r.Code(I() instanceof View ? ((View) I()).getContext() : this.Z, this.Code, hashMap);
        boolean Code2 = Code.Code();
        if (Code2) {
            Code(Code, i, mVar);
        }
        com.huawei.openalliance.ad.inter.d.Code(this.Z).Code(false);
        return Code2;
    }

    @Override // com.huawei.hms.ads.kb
    public void S() {
        ko.Code(this.Z, this.Code, com.huawei.openalliance.ad.constant.ac.S, (Long) null, (Long) null, (Integer) null, (Integer) null);
    }

    @Override // com.huawei.hms.ads.kb
    public void V() {
        ko.Code(this.Z, this.Code);
    }

    @Override // com.huawei.hms.ads.kb
    public void V(long j, long j2, long j3, long j4) {
        ko.Code(this.Z, this.Code, com.huawei.openalliance.ad.constant.ac.C, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf((int) j3), Integer.valueOf((int) j4));
    }
}
