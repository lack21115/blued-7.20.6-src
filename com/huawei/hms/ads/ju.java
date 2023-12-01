package com.huawei.hms.ads;

import android.content.Context;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/ju.class */
public class ju extends hg<lp> implements kh<lp> {
    private lu B;
    private fk I;
    private jv Z;

    public ju(Context context, lp lpVar) {
        Code((ju) lpVar);
        this.I = fk.Code(context);
    }

    private void Code(boolean z) {
        if (z) {
            jj jjVar = new jj(this.I, this.B);
            this.Z = jjVar;
            jjVar.Code();
        }
    }

    @Override // com.huawei.hms.ads.kh
    public void Code(int i, boolean z) {
        ge.V("SloganPresenter", "show image");
        if (i <= 0) {
            Code(z);
            return;
        }
        I().Code(i);
        if (z) {
            jk jkVar = new jk(this.I, this.B);
            this.Z = jkVar;
            jkVar.V();
        }
    }

    @Override // com.huawei.hms.ads.kh
    public void Code(lu luVar) {
        this.B = luVar;
    }
}
