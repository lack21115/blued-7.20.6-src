package com.anythink.expressad.foundation.g.a;

import android.graphics.Bitmap;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/foundation/g/a/g.class */
public final class g extends a<String, Bitmap> {
    private static Reference<Bitmap> a(Bitmap bitmap) {
        return new WeakReference(bitmap);
    }

    @Override // com.anythink.expressad.foundation.g.a.a
    protected final /* synthetic */ Reference<Bitmap> c(Bitmap bitmap) {
        return new WeakReference(bitmap);
    }
}
