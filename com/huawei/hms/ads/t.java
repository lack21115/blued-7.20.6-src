package com.huawei.hms.ads;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import java.lang.ref.WeakReference;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/t.class */
public class t extends Image {
    private static final String Code = t.class.getSimpleName();
    private double B;
    private int C;
    private String D;
    private boolean F;
    private com.huawei.openalliance.ad.inter.data.k I;
    private int S;
    private WeakReference<Drawable> V;
    private Uri Z;

    public t() {
    }

    public t(com.huawei.openalliance.ad.inter.data.k kVar, boolean z) {
        this.I = kVar;
        this.F = z;
        if (kVar != null) {
            if (!TextUtils.isEmpty(kVar.Z())) {
                this.Z = Uri.parse(kVar.Z());
            }
            this.C = kVar.C();
            int B = kVar.B();
            this.S = B;
            if (B > 0) {
                this.B = (this.C * 1.0d) / B;
            }
        }
    }

    public void Code(Drawable drawable) {
        this.V = new WeakReference<>(drawable);
    }

    public void Code(String str) {
        this.D = str;
    }

    @Override // com.huawei.hms.ads.Image
    public Drawable getDrawable() {
        Drawable drawable = null;
        if (this.F) {
            return null;
        }
        WeakReference<Drawable> weakReference = this.V;
        if (weakReference != null) {
            drawable = weakReference.get();
        }
        if (drawable != null) {
            return drawable;
        }
        m mVar = new m(this.I);
        mVar.Code(this.D);
        return mVar;
    }

    @Override // com.huawei.hms.ads.Image
    public int getHeight() {
        return this.S;
    }

    @Override // com.huawei.hms.ads.Image
    public double getScale() {
        return this.B;
    }

    @Override // com.huawei.hms.ads.Image
    public Uri getUri() {
        return this.Z;
    }

    @Override // com.huawei.hms.ads.Image
    public int getWidth() {
        return this.C;
    }
}
