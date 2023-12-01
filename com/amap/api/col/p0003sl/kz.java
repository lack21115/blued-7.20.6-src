package com.amap.api.col.p0003sl;

import android.content.Context;

/* renamed from: com.amap.api.col.3sl.kz  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/kz.class */
public final class kz extends ky {

    /* renamed from: a  reason: collision with root package name */
    private Context f5293a;
    private boolean b;

    public kz(Context context, boolean z) {
        this.b = false;
        this.f5293a = context;
        this.b = z;
    }

    @Override // com.amap.api.col.p0003sl.ky
    protected final boolean c() {
        return hs.o(this.f5293a) == 1 || this.b;
    }
}
