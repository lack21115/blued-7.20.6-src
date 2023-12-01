package com.amap.api.col.p0003sl;

import android.content.Context;
import android.text.TextUtils;

/* renamed from: com.amap.api.col.3sl.kx  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/kx.class */
public final class kx extends ky {
    protected int a;
    protected long b;
    private String d;
    private Context e;

    public kx(Context context, int i, String str, ky kyVar) {
        super(kyVar);
        this.a = i;
        this.d = str;
        this.e = context;
    }

    @Override // com.amap.api.col.p0003sl.ky
    protected final boolean c() {
        long j = 0;
        if (this.b == 0) {
            String a = iu.a(this.e, this.d);
            if (!TextUtils.isEmpty(a)) {
                j = Long.parseLong(a);
            }
            this.b = j;
        }
        return System.currentTimeMillis() - this.b >= ((long) this.a);
    }

    @Override // com.amap.api.col.p0003sl.ky
    public final void c_(boolean z) {
        super.c_(z);
        if (z) {
            String str = this.d;
            long currentTimeMillis = System.currentTimeMillis();
            this.b = currentTimeMillis;
            iu.a(this.e, str, String.valueOf(currentTimeMillis));
        }
    }
}
