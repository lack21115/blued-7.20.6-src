package com.opos.exoplayer.core.f.b;

import com.opos.exoplayer.core.i.m;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/f/b/a.class */
public final class a extends com.opos.exoplayer.core.f.c {

    /* renamed from: a  reason: collision with root package name */
    private final b f25346a;

    public a(List<byte[]> list) {
        super("DvbDecoder");
        m mVar = new m(list.get(0));
        this.f25346a = new b(mVar.h(), mVar.h());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.opos.exoplayer.core.f.c
    /* renamed from: b */
    public c a(byte[] bArr, int i, boolean z) {
        if (z) {
            this.f25346a.a();
        }
        return new c(this.f25346a.a(bArr, i));
    }
}
