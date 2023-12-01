package com.anythink.expressad.exoplayer.c;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/c/h.class */
public final class h extends f {

    /* renamed from: c  reason: collision with root package name */
    public ByteBuffer f7232c;
    private final g<?, h, ?> d;

    private h(g<?, h, ?> gVar) {
        this.d = gVar;
    }

    private ByteBuffer a(long j, int i) {
        this.f7228a = j;
        ByteBuffer byteBuffer = this.f7232c;
        if (byteBuffer == null || byteBuffer.capacity() < i) {
            this.f7232c = ByteBuffer.allocateDirect(i).order(ByteOrder.nativeOrder());
        }
        this.f7232c.position(0);
        this.f7232c.limit(i);
        return this.f7232c;
    }

    @Override // com.anythink.expressad.exoplayer.c.a
    public final void a() {
        super.a();
        ByteBuffer byteBuffer = this.f7232c;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
    }

    @Override // com.anythink.expressad.exoplayer.c.f
    public final void e() {
        this.d.a((g<?, h, ?>) this);
    }
}
