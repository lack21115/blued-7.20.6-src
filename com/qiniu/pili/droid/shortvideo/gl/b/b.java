package com.qiniu.pili.droid.shortvideo.gl.b;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import com.qiniu.pili.droid.shortvideo.PLDisplayMode;
import com.qiniu.pili.droid.shortvideo.PLFaceBeautySetting;
import com.qiniu.pili.droid.shortvideo.PLVideoFilterListener;
import com.qiniu.pili.droid.shortvideo.f.e;
import com.qiniu.pili.droid.shortvideo.gl.c.g;
import com.qiniu.pili.droid.shortvideo.gl.c.i;
import com.qiniu.pili.droid.shortvideo.gl.c.k;
import java.lang.ref.WeakReference;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/gl/b/b.class */
public class b implements GLSurfaceView.Renderer {

    /* renamed from: a  reason: collision with root package name */
    private WeakReference<GLSurfaceView> f27697a;
    private com.qiniu.pili.droid.beauty.a b;

    /* renamed from: c  reason: collision with root package name */
    private k f27698c;
    private com.qiniu.pili.droid.shortvideo.gl.c.a d;
    private i f;
    private SurfaceTexture g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private PLVideoFilterListener n;
    private PLDisplayMode o;
    private volatile boolean p;
    private volatile boolean q;
    private g e = new g();
    private float[] m = new float[16];

    public b(GLSurfaceView gLSurfaceView, PLFaceBeautySetting pLFaceBeautySetting, PLDisplayMode pLDisplayMode) {
        this.f27697a = new WeakReference<>(gLSurfaceView);
        gLSurfaceView.setEGLContextClientVersion(2);
        gLSurfaceView.setRenderer(this);
        gLSurfaceView.setRenderMode(0);
        this.b = new com.qiniu.pili.droid.beauty.a(gLSurfaceView.getContext(), pLFaceBeautySetting);
        this.o = pLDisplayMode;
    }

    public void a() {
        GLSurfaceView gLSurfaceView = this.f27697a.get();
        if (gLSurfaceView != null) {
            gLSurfaceView.onResume();
        }
    }

    public void a(float f, float f2) {
        this.e.c(f, f2);
    }

    public void a(int i) {
        this.e.b(i);
    }

    public void a(int i, int i2, int i3, int i4) {
        this.h = i;
        this.i = i2;
        this.j = i3;
        this.k = i4;
        GLSurfaceView gLSurfaceView = this.f27697a.get();
        if (gLSurfaceView != null) {
            gLSurfaceView.requestRender();
        }
    }

    public void a(PLFaceBeautySetting pLFaceBeautySetting) {
        this.b.a(pLFaceBeautySetting);
        GLES20.glGetError();
    }

    public final void a(PLVideoFilterListener pLVideoFilterListener) {
        this.n = pLVideoFilterListener;
    }

    public void a(boolean z) {
        this.p = z;
    }

    public void b() {
        GLSurfaceView gLSurfaceView = this.f27697a.get();
        if (gLSurfaceView != null) {
            gLSurfaceView.queueEvent(new Runnable() { // from class: com.qiniu.pili.droid.shortvideo.gl.b.b.1
                @Override // java.lang.Runnable
                public void run() {
                    b.this.b.b();
                    GLES20.glGetError();
                    if (b.this.g != null) {
                        b.this.g.release();
                    }
                    if (b.this.n != null) {
                        b.this.n.onSurfaceDestroy();
                    }
                }
            });
            gLSurfaceView.onPause();
        }
    }

    public void b(boolean z) {
        this.q = z;
    }

    public SurfaceTexture c() {
        return this.g;
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(GL10 gl10) {
        int b;
        int i;
        try {
            this.g.updateTexImage();
            this.g.getTransformMatrix(this.m);
            long timestamp = this.g.getTimestamp();
            e.j.b("PreviewRenderer", "onDrawFrame: " + timestamp);
            if (this.d == null) {
                int i2 = this.j;
                if (i2 == 0 || (i = this.k) == 0) {
                    e.j.c("PreviewRenderer", "waiting for first render() to set texture size");
                    return;
                }
                this.e.a(i2, i, this.o);
                com.qiniu.pili.droid.shortvideo.gl.c.a aVar = new com.qiniu.pili.droid.shortvideo.gl.c.a();
                this.d = aVar;
                aVar.b();
                this.d.a(this.j, this.k);
                k kVar = new k();
                this.f27698c = kVar;
                kVar.b();
                this.f27698c.a(this.j, this.k);
            }
            int i3 = 0;
            if (this.p) {
                PLVideoFilterListener pLVideoFilterListener = this.n;
                if (pLVideoFilterListener != null) {
                    i3 = pLVideoFilterListener.onDrawFrame(this.l, this.h, this.i, timestamp, this.m);
                }
            } else {
                if (this.b.a()) {
                    int onDrawFrame = this.b.onDrawFrame(this.l, this.h, this.i, timestamp, this.m);
                    GLES20.glGetError();
                    b = this.f27698c.b(onDrawFrame, this.m);
                } else {
                    b = this.d.b(this.l, this.m);
                }
                int i4 = b;
                if (this.q) {
                    if (this.f == null) {
                        i iVar = new i();
                        this.f = iVar;
                        iVar.a(this.h, this.i);
                        this.f.b();
                    }
                    i4 = this.f.a(b);
                }
                PLVideoFilterListener pLVideoFilterListener2 = this.n;
                i3 = pLVideoFilterListener2 != null ? pLVideoFilterListener2.onDrawFrame(i4, this.j, this.k, timestamp, com.qiniu.pili.droid.shortvideo.f.d.f) : i4;
            }
            this.e.b(i3);
        } catch (Exception e) {
            e.j.e("PreviewRenderer", "update surface texture failed !!!");
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        e eVar = e.j;
        eVar.c("PreviewRenderer", "onSurfaceChanged width:" + i + " height:" + i2);
        this.b.onSurfaceChanged(i, i2);
        GLES20.glGetError();
        this.e.a(i, i2);
        PLVideoFilterListener pLVideoFilterListener = this.n;
        if (pLVideoFilterListener != null) {
            pLVideoFilterListener.onSurfaceChanged(i, i2);
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        e.j.c("PreviewRenderer", "onSurfaceCreated");
        this.b.onSurfaceCreated();
        GLES20.glGetError();
        this.j = 0;
        this.k = 0;
        this.d = null;
        this.f27698c = null;
        this.f = null;
        this.l = com.qiniu.pili.droid.shortvideo.f.d.c();
        this.g = new SurfaceTexture(this.l);
        PLVideoFilterListener pLVideoFilterListener = this.n;
        if (pLVideoFilterListener != null) {
            pLVideoFilterListener.onSurfaceCreated();
        }
    }
}
