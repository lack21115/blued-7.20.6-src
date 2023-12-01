package com.huawei.openalliance.ad.inter.data;

import com.huawei.hms.ads.AdvertiserInfo;
import com.huawei.openalliance.ad.beans.metadata.MediaFile;
import com.huawei.openalliance.ad.beans.metadata.MetaData;
import com.huawei.openalliance.ad.constant.ax;
import com.huawei.openalliance.ad.utils.aa;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/inter/data/p.class */
public class p extends c implements h, Comparable {
    private r B;
    private boolean F;
    private boolean S;
    private boolean Z;

    public p(AdContentData adContentData) {
        super(adContentData);
        this.Z = false;
        this.S = false;
        this.F = false;
    }

    public boolean B() {
        return this.S;
    }

    public int C() {
        if (this.Code != null) {
            return this.Code.A();
        }
        return 0;
    }

    public String Code() {
        MetaData k = k();
        if (k != null) {
            return k.D();
        }
        return null;
    }

    public void Code(boolean z) {
        this.Z = z;
    }

    public boolean I() {
        r rVar = this.B;
        if (rVar != null) {
            return ax.V.equals(rVar.b()) || ax.B.equals(this.B.b()) || ax.I.equals(this.B.b()) || ax.Z.equals(this.B.b());
        }
        return false;
    }

    public boolean Q() {
        return this.F;
    }

    @Override // com.huawei.openalliance.ad.inter.data.h
    public r S() {
        MetaData k;
        MediaFile e;
        if (this.B == null && (k = k()) != null && (e = k.e()) != null) {
            this.B = new r(e, k.h());
        }
        return this.B;
    }

    public boolean V() {
        r rVar = this.B;
        return rVar != null && "video/mp4".equals(rVar.b());
    }

    public void Z(boolean z) {
        this.F = z;
    }

    public boolean Z() {
        return this.Z;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        return ((obj instanceof p) && ((p) obj).C() <= C()) ? 1 : -1;
    }

    public boolean k_() {
        if (this.Code != null) {
            return !aa.Code(this.Code.aG());
        }
        return false;
    }

    public List<AdvertiserInfo> n() {
        if (this.Code == null || !k_()) {
            return null;
        }
        return this.Code.aG();
    }
}
