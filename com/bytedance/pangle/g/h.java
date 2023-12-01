package com.bytedance.pangle.g;

import java.nio.ByteBuffer;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/pangle/g/h.class */
final class h implements k {

    /* renamed from: a  reason: collision with root package name */
    private final ByteBuffer f21419a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(ByteBuffer byteBuffer) {
        this.f21419a = byteBuffer.slice();
    }

    @Override // com.bytedance.pangle.g.k
    public final long a() {
        return this.f21419a.capacity();
    }

    @Override // com.bytedance.pangle.g.k
    public final void a(j jVar, long j, int i) {
        ByteBuffer slice;
        synchronized (this.f21419a) {
            this.f21419a.position(0);
            int i2 = (int) j;
            this.f21419a.limit(i + i2);
            this.f21419a.position(i2);
            slice = this.f21419a.slice();
        }
        jVar.a(slice);
    }
}
