package com.huawei.hms.ads;

import android.opengl.EGL14;
import android.opengl.EGLSurface;
import android.view.Surface;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/ff.class */
public class ff {
    private final fe Code;
    private EGLSurface V;

    public ff(fe feVar, Surface surface) {
        this.Code = feVar;
        this.V = feVar.Code(surface);
    }

    public void B() {
        this.Code.Code(this.V);
        this.V = EGL14.EGL_NO_SURFACE;
    }

    public int Code() {
        return this.Code.Code(this.V, 12375);
    }

    public void I() {
        this.Code.V(this.V);
    }

    public int V() {
        return this.Code.Code(this.V, 12374);
    }

    public void Z() {
        this.Code.I(this.V);
    }
}
