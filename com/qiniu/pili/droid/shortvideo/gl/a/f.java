package com.qiniu.pili.droid.shortvideo.gl.a;

import android.view.Surface;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/gl/a/f.class */
public class f extends e {
    private Surface b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f27693c;

    public f(d dVar, Surface surface, boolean z) {
        super(dVar);
        a(surface);
        this.b = surface;
        this.f27693c = z;
    }

    public void d() {
        a();
        Surface surface = this.b;
        if (surface != null) {
            if (this.f27693c) {
                surface.release();
            }
            this.b = null;
        }
    }
}
