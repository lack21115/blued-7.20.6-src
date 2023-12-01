package com.amap.api.col.p0003sl;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* renamed from: com.amap.api.col.3sl.lf  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/lf.class */
public abstract class lf {
    lh a;
    private ByteBuffer b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public lf(int i) {
        ByteBuffer allocate = ByteBuffer.allocate(i);
        this.b = allocate;
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        this.a = new lh(this.b);
    }

    public final lf a() {
        this.a.a(this.b);
        return this;
    }
}
