package com.kwad.sdk.f.kwai;

import android.text.TextUtils;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.kwad.sdk.utils.bb;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/f/kwai/b.class */
public class b extends com.kwad.sdk.core.response.kwai.a {
    public String atm;
    public String atn;
    public String ato;
    public long atp;
    public String atq;
    public boolean atr;
    public int loadType;
    public int packageType;
    public String packageUrl;
    public String version;

    public final long Az() {
        return this.atp;
    }

    public final void aa(long j) {
        this.atp = j;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return bb.isEquals(this.atm, bVar.atm) && bb.isEquals(this.atq, bVar.atq) && bb.isEquals(this.version, bVar.version);
    }

    public int hashCode() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.atm);
        sb.append(BridgeUtil.UNDERLINE_STR);
        sb.append(this.atq);
        sb.append(BridgeUtil.UNDERLINE_STR);
        sb.append(this.version);
        return TextUtils.isEmpty(sb.toString()) ? super.hashCode() : sb.toString().hashCode();
    }

    public final boolean isValid() {
        return (TextUtils.isEmpty(this.atm) || TextUtils.isEmpty(this.packageUrl) || TextUtils.isEmpty(this.version) || TextUtils.isEmpty(this.atn)) ? false : true;
    }

    @Override // com.kwad.sdk.core.response.kwai.a
    public String toString() {
        return "PackageInfoBean{packageId='" + this.atm + "', zipFileName='" + this.atn + "', zipPath='" + this.ato + "', startDownloadTime=" + this.atp + ", packageUrl='" + this.packageUrl + "', version='" + this.version + "', checksum='" + this.atq + "', loadType=" + this.loadType + ", packageType=" + this.packageType + ", isPublic=" + this.atr + '}';
    }
}
