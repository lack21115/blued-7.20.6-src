package com.opos.exoplayer.core.drm;

import android.os.Looper;
import com.opos.exoplayer.core.drm.c;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/drm/b.class */
public interface b<T extends c> {
    a<T> a(Looper looper, DrmInitData drmInitData);

    void a(a<T> aVar);

    boolean a(DrmInitData drmInitData);
}
