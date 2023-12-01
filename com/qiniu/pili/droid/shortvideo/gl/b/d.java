package com.qiniu.pili.droid.shortvideo.gl.b;

import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.view.Surface;
import android.view.View;
import com.qiniu.pili.droid.shortvideo.PLDisplayMode;
import com.qiniu.pili.droid.shortvideo.gl.c.e;
import java.nio.ByteBuffer;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/gl/b/d.class */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private View f14017a;
    private SurfaceTexture b;

    /* renamed from: c  reason: collision with root package name */
    private Surface f14018c;
    private com.qiniu.pili.droid.shortvideo.gl.c.a d;
    private e e;
    private int f;
    private float[] g = new float[16];
    private int h;

    private void g() {
        int i = this.h;
        if (i != 0) {
            GLES20.glDeleteTextures(1, new int[]{i}, 0);
            this.h = 0;
        }
    }

    public void a() {
        SurfaceTexture surfaceTexture = this.b;
        if (surfaceTexture != null) {
            surfaceTexture.updateTexImage();
        }
    }

    public void a(View view, int i, int i2) {
        c();
        this.f14017a = view;
        com.qiniu.pili.droid.shortvideo.gl.c.a aVar = new com.qiniu.pili.droid.shortvideo.gl.c.a();
        this.d = aVar;
        aVar.a(view.getWidth(), view.getHeight());
        this.d.b();
        e eVar = new e();
        this.e = eVar;
        eVar.a(i, i2);
        this.e.a(view.getWidth(), view.getHeight(), PLDisplayMode.FIT);
        this.h = com.qiniu.pili.droid.shortvideo.f.d.a((ByteBuffer) null, i, i2, 6408);
        this.f = com.qiniu.pili.droid.shortvideo.f.d.c();
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.f);
        this.b = surfaceTexture;
        surfaceTexture.setDefaultBufferSize(view.getWidth(), view.getHeight());
        this.f14018c = new Surface(this.b);
    }

    public void a(float[] fArr) {
        this.b.getTransformMatrix(fArr);
    }

    public void b() {
        Canvas f = f();
        if (f != null) {
            f.drawColor(0, PorterDuff.Mode.CLEAR);
            this.f14017a.draw(f);
            this.f14018c.unlockCanvasAndPost(f);
        }
    }

    public void c() {
        Surface surface = this.f14018c;
        if (surface != null) {
            surface.release();
        }
        SurfaceTexture surfaceTexture = this.b;
        if (surfaceTexture != null) {
            surfaceTexture.release();
        }
        com.qiniu.pili.droid.shortvideo.gl.c.a aVar = this.d;
        if (aVar != null) {
            aVar.f();
        }
        e eVar = this.e;
        if (eVar != null) {
            eVar.f();
        }
        this.f14018c = null;
        this.b = null;
        this.d = null;
        this.e = null;
        g();
    }

    public long d() {
        SurfaceTexture surfaceTexture = this.b;
        if (surfaceTexture == null) {
            return 0L;
        }
        return surfaceTexture.getTimestamp();
    }

    public int e() {
        int i = this.f;
        a(this.g);
        float alpha = this.f14017a.getAlpha();
        com.qiniu.pili.droid.shortvideo.gl.c.a aVar = this.d;
        if (aVar != null) {
            i = this.e.a(aVar.b(this.f, this.g), alpha, null, this.h, true);
        }
        return i;
    }

    public Canvas f() {
        Surface surface = this.f14018c;
        if (surface != null) {
            try {
                return surface.lockCanvas(null);
            } catch (Exception e) {
                com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.j;
                eVar.e("ViewRenderer", "error while rendering view to gl: " + e);
                return null;
            }
        }
        return null;
    }
}
