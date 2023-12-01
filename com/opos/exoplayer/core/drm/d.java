package com.opos.exoplayer.core.drm;

import android.media.MediaCrypto;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/drm/d.class */
public final class d implements c {

    /* renamed from: a  reason: collision with root package name */
    private final MediaCrypto f11583a;
    private final boolean b;

    public MediaCrypto a() {
        return this.f11583a;
    }

    public boolean a(String str) {
        return !this.b && this.f11583a.requiresSecureDecoderComponent(str);
    }
}
