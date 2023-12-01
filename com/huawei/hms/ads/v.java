package com.huawei.hms.ads;

import android.net.Uri;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/v.class */
public class v extends Video {
    private Uri Code;
    private int I;
    private Float V;

    public v(com.huawei.openalliance.ad.inter.data.v vVar) {
        if (vVar != null) {
            this.Code = Uri.parse(vVar.V());
            this.V = vVar.g();
            this.I = vVar.I();
        }
    }

    @Override // com.huawei.hms.ads.Video
    public float getAspectRatio() {
        Float f = this.V;
        if (f == null) {
            return 1.7777778f;
        }
        return f.floatValue();
    }

    @Override // com.huawei.hms.ads.Video
    public int getDuration() {
        return this.I;
    }

    @Override // com.huawei.hms.ads.Video
    public Uri getUri() {
        return this.Code;
    }
}
