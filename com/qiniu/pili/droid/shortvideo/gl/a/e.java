package com.qiniu.pili.droid.shortvideo.gl.a;

import android.util.Log;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/gl/a/e.class */
public class e {
    private static int e = 12375;
    private static int f = 12374;

    /* renamed from: a  reason: collision with root package name */
    protected d f14003a;
    private Object b = null;

    /* renamed from: c  reason: collision with root package name */
    private int f14004c = -1;
    private int d = -1;

    /* JADX INFO: Access modifiers changed from: protected */
    public e(d dVar) {
        this.f14003a = dVar;
    }

    public void a() {
        this.f14003a.a(this.b);
        this.b = null;
        this.d = -1;
        this.f14004c = -1;
    }

    public void a(long j) {
        this.f14003a.a(this.b, j);
    }

    public void a(Object obj) {
        if (this.b != null) {
            throw new IllegalStateException("surface already created");
        }
        this.b = this.f14003a.b(obj);
    }

    public void b() {
        this.f14003a.c(this.b);
    }

    public boolean c() {
        boolean d = this.f14003a.d(this.b);
        if (!d) {
            Log.d("EglSurfaceBase", "WARNING: swapBuffers() failed");
        }
        return d;
    }
}
