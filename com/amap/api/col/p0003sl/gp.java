package com.amap.api.col.p0003sl;

import android.content.Context;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.amap.api.col.3sl.gp  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/gp.class */
public abstract class gp<T, V> extends ex<T, V> {
    public gp(Context context, T t) {
        super(context, t);
    }

    public final T f() {
        return this.b;
    }

    @Override // com.amap.api.col.p0003sl.kb
    public String getURL() {
        return fd.a() + "/weather/weatherInfo?";
    }
}
