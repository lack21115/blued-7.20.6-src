package com.anythink.expressad.exoplayer.d;

import android.media.MediaCrypto;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/d/k.class */
public final class k implements i {

    /* renamed from: a  reason: collision with root package name */
    private final MediaCrypto f4424a;
    private final boolean b;

    private k(MediaCrypto mediaCrypto) {
        this(mediaCrypto, false);
    }

    public k(MediaCrypto mediaCrypto, boolean z) {
        this.f4424a = (MediaCrypto) com.anythink.expressad.exoplayer.k.a.a(mediaCrypto);
        this.b = z;
    }

    public final MediaCrypto a() {
        return this.f4424a;
    }

    @Override // com.anythink.expressad.exoplayer.d.i
    public final boolean a(String str) {
        return !this.b && this.f4424a.requiresSecureDecoderComponent(str);
    }
}
