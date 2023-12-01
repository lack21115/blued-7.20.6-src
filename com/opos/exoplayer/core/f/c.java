package com.opos.exoplayer.core.f;

import java.nio.ByteBuffer;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/f/c.class */
public abstract class c extends com.opos.exoplayer.core.b.g<h, i, f> implements e {

    /* renamed from: a  reason: collision with root package name */
    private final String f25365a;

    public c(String str) {
        super(new h[2], new i[2]);
        this.f25365a = str;
        a(1024);
    }

    protected abstract d a(byte[] bArr, int i, boolean z);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.opos.exoplayer.core.b.g
    public final f a(h hVar, i iVar, boolean z) {
        try {
            ByteBuffer byteBuffer = hVar.b;
            iVar.a(hVar.f25074c, a(byteBuffer.array(), byteBuffer.limit(), z), hVar.d);
            iVar.c(Integer.MIN_VALUE);
            return null;
        } catch (f e) {
            return e;
        }
    }

    @Override // com.opos.exoplayer.core.f.e
    public void a(long j) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.opos.exoplayer.core.b.g
    public final void a(i iVar) {
        super.a((c) iVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.opos.exoplayer.core.b.g
    /* renamed from: b */
    public final f a(Throwable th) {
        return new f("Unexpected decode error", th);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.opos.exoplayer.core.b.g
    /* renamed from: i */
    public final h g() {
        return new h();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.opos.exoplayer.core.b.g
    /* renamed from: j */
    public final i h() {
        return new l(this);
    }
}
