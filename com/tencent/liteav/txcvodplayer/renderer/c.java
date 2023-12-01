package com.tencent.liteav.txcvodplayer.renderer;

import android.graphics.SurfaceTexture;
import android.opengl.GLES11Ext;
import android.os.Looper;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videobase.frame.PixelFrame;
import com.tencent.liteav.videobase.frame.l;
import com.tencent.liteav.videobase.utils.OpenGlUtils;
import com.tencent.liteav.videobase.utils.Rotation;
import com.tencent.liteav.videobase.videobase.DisplayTarget;
import com.tencent.ugc.UGCTransitionRules;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/txcvodplayer/renderer/c.class */
public final class c implements SurfaceTexture.OnFrameAvailableListener {

    /* renamed from: a  reason: collision with root package name */
    public com.tencent.liteav.base.util.b f36564a;
    protected com.tencent.liteav.videobase.b.e b;

    /* renamed from: c  reason: collision with root package name */
    private com.tencent.liteav.videoconsumer.renderer.g f36565c;
    private DisplayTarget d;
    private SurfaceTexture g;
    private PixelFrame i;
    private l j;
    private com.tencent.liteav.videobase.frame.j k;
    private com.tencent.liteav.videobase.frame.e l;
    private final a p;
    private GLConstants.GLScaleType e = GLConstants.GLScaleType.FIT_CENTER;
    private Rotation f = Rotation.NORMAL;
    private int h = -1;
    private final float[] m = new float[16];
    private int n = UGCTransitionRules.DEFAULT_IMAGE_WIDTH;
    private int o = 1280;

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/txcvodplayer/renderer/c$a.class */
    public interface a {
        void a(SurfaceTexture surfaceTexture);

        void a(PixelFrame pixelFrame);

        void e();
    }

    public c(a aVar) {
        this.p = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(c cVar) {
        if (cVar.b == null) {
            cVar.b = new com.tencent.liteav.videobase.b.e();
            if (cVar.j == null) {
                cVar.j = new l();
            }
            try {
                cVar.b.a(null, null, 128, 128);
                cVar.b.a();
                cVar.h = OpenGlUtils.generateTextureOES();
                SurfaceTexture surfaceTexture = new SurfaceTexture(cVar.h);
                cVar.g = surfaceTexture;
                surfaceTexture.setDefaultBufferSize(cVar.n, cVar.o);
                cVar.g.setOnFrameAvailableListener(cVar);
                PixelFrame pixelFrame = new PixelFrame();
                cVar.i = pixelFrame;
                pixelFrame.setWidth(cVar.n);
                cVar.i.setHeight(cVar.o);
                cVar.i.setPixelBufferType(GLConstants.PixelBufferType.TEXTURE_OES);
                cVar.i.setPixelFormatType(GLConstants.PixelFormatType.RGBA);
                cVar.i.setRotation(Rotation.NORMAL);
                cVar.i.setGLContext(cVar.b.d());
                cVar.i.setTextureId(cVar.h);
                cVar.l = new com.tencent.liteav.videobase.frame.e();
                if (cVar.p != null) {
                    cVar.p.a(cVar.g);
                }
            } catch (com.tencent.liteav.videobase.b.g e) {
                LiteavLog.e("VodRenderer", "initializeEGL failed.", e);
                cVar.b = null;
            }
        }
        cVar.f36565c = new com.tencent.liteav.videoconsumer.renderer.g(cVar.f36564a.getLooper(), new com.tencent.liteav.videobase.videobase.f());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(c cVar, int i, int i2) {
        if (cVar.n == i && cVar.o == i2) {
            return;
        }
        LiteavLog.i("VodRenderer", "setVideoSize: %d*%d", Integer.valueOf(i), Integer.valueOf(i2));
        cVar.n = i;
        cVar.o = i2;
        cVar.i.setWidth(i);
        cVar.i.setHeight(cVar.o);
        com.tencent.liteav.videobase.frame.j jVar = cVar.k;
        if (jVar != null) {
            jVar.a();
            cVar.k = null;
        }
        com.tencent.liteav.videobase.frame.e eVar = cVar.l;
        if (eVar != null) {
            eVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(c cVar, SurfaceTexture surfaceTexture) {
        l lVar;
        SurfaceTexture surfaceTexture2 = cVar.g;
        if (surfaceTexture2 == null || surfaceTexture != surfaceTexture2) {
            LiteavLog.i("VodRenderer", "mSurfaceTexture= " + cVar.g + " ,surfaceTexture= " + surfaceTexture);
        } else if (cVar.b()) {
            if (cVar.l == null || (lVar = cVar.j) == null) {
                LiteavLog.w("VodRenderer", "onCaptureFrameAvailable mGLTexturePool:" + cVar.l + " mTextureHolderPool:" + cVar.j);
                return;
            }
            l.b bVar = null;
            try {
                bVar = lVar.a();
            } catch (InterruptedException e) {
            }
            try {
                cVar.g.updateTexImage();
                cVar.g.getTransformMatrix(cVar.m);
                cVar.i.setMatrix(cVar.m);
            } catch (Exception e2) {
                LiteavLog.w("VodRenderer", "updateTexImage exception: ".concat(String.valueOf(e2)));
            }
            bVar.a(GLES11Ext.GL_TEXTURE_EXTERNAL_OES, cVar.h, cVar.i.getWidth(), cVar.i.getHeight());
            PixelFrame a2 = bVar.a(cVar.i.getGLContext());
            a2.setMatrix(cVar.m);
            if (cVar.k == null) {
                cVar.k = new com.tencent.liteav.videobase.frame.j(cVar.n, cVar.o);
            }
            OpenGlUtils.glViewport(0, 0, cVar.n, cVar.o);
            com.tencent.liteav.videobase.frame.d a3 = cVar.l.a(cVar.n, cVar.o);
            cVar.k.a(a2, GLConstants.GLScaleType.CENTER_CROP, a3);
            PixelFrame a4 = a3.a(cVar.b.d());
            a3.release();
            a aVar = cVar.p;
            if (aVar != null) {
                aVar.a(a4);
            }
            com.tencent.liteav.videoconsumer.renderer.g gVar = cVar.f36565c;
            if (gVar != null) {
                gVar.renderFrame(a4);
            }
            bVar.release();
            a2.release();
            a4.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(c cVar, GLConstants.GLScaleType gLScaleType) {
        LiteavLog.i("VodRenderer", "setScaleType ".concat(String.valueOf(gLScaleType)));
        cVar.e = gLScaleType;
        com.tencent.liteav.videoconsumer.renderer.g gVar = cVar.f36565c;
        if (gVar != null) {
            gVar.setScaleType(gLScaleType);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(c cVar, Rotation rotation) {
        LiteavLog.i("VodRenderer", "setRenderRotation ".concat(String.valueOf(rotation)));
        cVar.f = rotation;
        com.tencent.liteav.videoconsumer.renderer.g gVar = cVar.f36565c;
        if (gVar != null) {
            gVar.setRenderRotation(rotation);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(c cVar, DisplayTarget displayTarget) {
        LiteavLog.i("VodRenderer", "setDisplayTarget: ".concat(String.valueOf(displayTarget)));
        cVar.d = displayTarget;
        com.tencent.liteav.videoconsumer.renderer.g gVar = cVar.f36565c;
        if (gVar != null) {
            gVar.setDisplayView(displayTarget, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(c cVar, boolean z) {
        LiteavLog.i("VodRenderer", "Stop");
        com.tencent.liteav.videoconsumer.renderer.g gVar = cVar.f36565c;
        if (gVar != null) {
            gVar.stop(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(c cVar) {
        LiteavLog.i("VodRenderer", "Start");
        com.tencent.liteav.videoconsumer.renderer.g gVar = cVar.f36565c;
        if (gVar != null) {
            gVar.setDisplayView(cVar.d, true);
            cVar.f36565c.setRenderRotation(cVar.f);
            cVar.f36565c.setScaleType(cVar.e);
            cVar.f36565c.start(null);
        }
    }

    private boolean b() {
        com.tencent.liteav.videobase.b.e eVar = this.b;
        if (eVar == null) {
            LiteavLog.e("VodRenderer", "makeCurrent on mEGLCore is null");
            return false;
        }
        try {
            eVar.a();
            return true;
        } catch (com.tencent.liteav.videobase.b.g e) {
            LiteavLog.e("VodRenderer", "make current failed.", e);
            return false;
        }
    }

    static /* synthetic */ com.tencent.liteav.videoconsumer.renderer.g d(c cVar) {
        cVar.f36565c = null;
        return null;
    }

    static /* synthetic */ DisplayTarget e(c cVar) {
        cVar.d = null;
        return null;
    }

    static /* synthetic */ com.tencent.liteav.base.util.b g(c cVar) {
        cVar.f36564a = null;
        return null;
    }

    protected final void a() {
        if (this.b == null) {
            return;
        }
        l lVar = this.j;
        if (lVar != null) {
            lVar.b();
            this.j = null;
        }
        try {
            this.b.a();
            if (this.p != null) {
                this.p.e();
            }
            if (this.g != null) {
                this.g.release();
                this.g = null;
            }
            OpenGlUtils.deleteTexture(this.h);
            this.h = -1;
            if (this.k != null) {
                this.k.a();
                this.k = null;
            }
            if (this.l != null) {
                this.l.a();
                this.l.b();
                this.l = null;
            }
        } catch (com.tencent.liteav.videobase.b.g e) {
            LiteavLog.e("VodRenderer", "EGLCore destroy failed.", e);
        }
        com.tencent.liteav.videobase.b.e.a(this.b);
        this.b = null;
    }

    public final void a(GLConstants.GLScaleType gLScaleType) {
        a(h.a(this, gLScaleType), "setScaleType");
    }

    public final void a(Rotation rotation) {
        a(i.a(this, rotation), "setRenderRotation");
    }

    public final void a(Runnable runnable, String str) {
        com.tencent.liteav.base.util.b bVar = this.f36564a;
        if (bVar == null) {
            LiteavLog.w("VodRenderer", "ignore runnable: ".concat(String.valueOf(str)));
        } else if (bVar.getLooper() != Looper.myLooper()) {
            bVar.post(runnable);
        } else {
            runnable.run();
        }
    }

    public final void a(boolean z) {
        a(e.a(this, z), "Stop");
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
        a(k.a(this, surfaceTexture), "onFrameAvailable");
    }
}
