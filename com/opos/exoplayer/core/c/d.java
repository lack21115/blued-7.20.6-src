package com.opos.exoplayer.core.c;

import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.c.n;
import java.io.EOFException;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/c/d.class */
public final class d implements n {
    @Override // com.opos.exoplayer.core.c.n
    public int a(f fVar, int i, boolean z) {
        int a2 = fVar.a(i);
        if (a2 == -1) {
            if (z) {
                return -1;
            }
            throw new EOFException();
        }
        return a2;
    }

    @Override // com.opos.exoplayer.core.c.n
    public void a(long j, int i, int i2, int i3, n.a aVar) {
    }

    @Override // com.opos.exoplayer.core.c.n
    public void a(Format format) {
    }

    @Override // com.opos.exoplayer.core.c.n
    public void a(com.opos.exoplayer.core.i.m mVar, int i) {
        mVar.d(i);
    }
}
