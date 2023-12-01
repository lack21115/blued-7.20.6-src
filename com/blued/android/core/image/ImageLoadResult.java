package com.blued.android.core.image;

import com.blued.android.core.net.IRequestHost;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/image/ImageLoadResult.class */
public class ImageLoadResult {

    /* renamed from: a  reason: collision with root package name */
    private IRequestHost f9500a;

    public ImageLoadResult(IRequestHost iRequestHost) {
        this.f9500a = iRequestHost;
    }

    public void a() {
    }

    public void a(int i, Exception exc) {
    }

    public void b() {
    }

    public boolean c() {
        IRequestHost iRequestHost = this.f9500a;
        if (iRequestHost != null) {
            return iRequestHost.isActive();
        }
        return true;
    }
}
