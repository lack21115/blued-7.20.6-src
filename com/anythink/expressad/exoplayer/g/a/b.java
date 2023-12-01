package com.anythink.expressad.exoplayer.g.a;

import com.anythink.expressad.exoplayer.g.e;
import com.anythink.expressad.exoplayer.k.af;
import com.anythink.expressad.exoplayer.k.s;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/g/a/b.class */
public final class b implements com.anythink.expressad.exoplayer.g.b {
    @Override // com.anythink.expressad.exoplayer.g.b
    public final com.anythink.expressad.exoplayer.g.a a(e eVar) {
        ByteBuffer byteBuffer = eVar.e;
        byte[] array = byteBuffer.array();
        int limit = byteBuffer.limit();
        s sVar = new s(array, limit);
        String p = sVar.p();
        String p2 = sVar.p();
        long h = sVar.h();
        return new com.anythink.expressad.exoplayer.g.a(new a(p, p2, af.a(sVar.h(), 1000L, h), sVar.h(), Arrays.copyOfRange(array, sVar.c(), limit), af.a(sVar.h(), 1000000L, h)));
    }
}
