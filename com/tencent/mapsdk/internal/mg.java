package com.tencent.mapsdk.internal;

import android.graphics.Bitmap;
import com.tencent.mapsdk.internal.za;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/mg.class */
public class mg extends v9 {
    private static za.e i = new za.e(256, 256, Bitmap.Config.ARGB_8888);

    public mg() {
        a(i);
    }

    public mg(byte[] bArr) {
        super(bArr);
        a(i);
    }

    @Override // com.tencent.mapsdk.internal.v9
    public boolean h() {
        Bitmap bitmap = this.b;
        boolean z = false;
        if (bitmap != null && !bitmap.isRecycled() && this.f24374a.get() <= 0) {
            this.b.recycle();
            ra.g("BD").a("tileBitmap recycle out");
        }
        this.f24375c = null;
        Bitmap bitmap2 = this.b;
        if (bitmap2 == null || bitmap2.isRecycled()) {
            z = true;
        }
        return z;
    }
}
