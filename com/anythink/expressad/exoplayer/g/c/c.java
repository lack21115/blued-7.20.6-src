package com.anythink.expressad.exoplayer.g.c;

import com.anythink.expressad.exoplayer.g.a;
import com.anythink.expressad.exoplayer.k.ac;
import com.anythink.expressad.exoplayer.k.r;
import com.anythink.expressad.exoplayer.k.s;
import java.nio.ByteBuffer;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/g/c/c.class */
public final class c implements com.anythink.expressad.exoplayer.g.b {

    /* renamed from: a  reason: collision with root package name */
    private static final int f4527a = 0;
    private static final int b = 4;

    /* renamed from: c  reason: collision with root package name */
    private static final int f4528c = 5;
    private static final int d = 6;
    private static final int e = 255;
    private final s f = new s();
    private final r g = new r();
    private ac h;

    @Override // com.anythink.expressad.exoplayer.g.b
    public final com.anythink.expressad.exoplayer.g.a a(com.anythink.expressad.exoplayer.g.e eVar) {
        if (this.h == null || eVar.g != this.h.a()) {
            ac acVar = new ac(eVar.f);
            this.h = acVar;
            acVar.b(eVar.f - eVar.g);
        }
        ByteBuffer byteBuffer = eVar.e;
        byte[] array = byteBuffer.array();
        int limit = byteBuffer.limit();
        this.f.a(array, limit);
        this.g.a(array, limit);
        this.g.b(39);
        long c2 = (this.g.c(1) << 32) | this.g.c(32);
        this.g.b(20);
        int c3 = this.g.c(12);
        int c4 = this.g.c(8);
        a.InterfaceC0058a interfaceC0058a = null;
        this.f.d(14);
        if (c4 == 0) {
            interfaceC0058a = new e();
        } else if (c4 == 255) {
            interfaceC0058a = a.a(this.f, c3, c2);
        } else if (c4 == 4) {
            interfaceC0058a = f.a(this.f);
        } else if (c4 == 5) {
            interfaceC0058a = d.a(this.f, c2, this.h);
        } else if (c4 == 6) {
            interfaceC0058a = g.a(this.f, c2, this.h);
        }
        return interfaceC0058a == null ? new com.anythink.expressad.exoplayer.g.a(new a.InterfaceC0058a[0]) : new com.anythink.expressad.exoplayer.g.a(interfaceC0058a);
    }
}
