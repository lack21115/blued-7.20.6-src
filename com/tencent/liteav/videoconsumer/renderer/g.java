package com.tencent.liteav.videoconsumer.renderer;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.os.Looper;
import android.view.Surface;
import com.tencent.liteav.base.util.CommonUtil;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videobase.base.TakeSnapshotListener;
import com.tencent.liteav.videobase.frame.PixelFrame;
import com.tencent.liteav.videobase.utils.OpenGlUtils;
import com.tencent.liteav.videobase.utils.Rotation;
import com.tencent.liteav.videobase.videobase.DisplayTarget;
import com.tencent.liteav.videobase.videobase.IVideoReporter;
import com.tencent.liteav.videobase.videobase.h;
import com.tencent.liteav.videoconsumer.renderer.a;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videoconsumer/renderer/g.class */
public final class g extends VideoRenderInterface implements a.InterfaceC0769a {

    /* renamed from: a  reason: collision with root package name */
    private final com.tencent.liteav.base.util.b f23134a;
    private final IVideoReporter b;
    private DisplayTarget d;
    private Object h;
    private com.tencent.liteav.videobase.frame.j k;
    private com.tencent.liteav.videobase.frame.e m;
    private TakeSnapshotListener t;
    private ExecutorService u;
    private VideoRenderListener v;
    private Surface e = null;
    private final com.tencent.liteav.base.util.n f = new com.tencent.liteav.base.util.n();
    private boolean g = false;
    private com.tencent.liteav.videobase.b.e i = null;
    private final com.tencent.liteav.videobase.frame.c j = new com.tencent.liteav.videobase.frame.c();
    private final com.tencent.liteav.videobase.utils.j l = new com.tencent.liteav.videobase.utils.j(1);
    private GLConstants.GLScaleType n = GLConstants.GLScaleType.FIT_CENTER;
    private Rotation o = Rotation.NORMAL;
    private boolean p = false;
    private boolean q = false;
    private volatile boolean r = false;
    private boolean s = false;
    private boolean w = false;

    /* renamed from: c  reason: collision with root package name */
    private final a f23135c = new a(this);

    public g(Looper looper, IVideoReporter iVideoReporter) {
        this.f23134a = new com.tencent.liteav.base.util.b(looper);
        this.b = iVideoReporter;
    }

    private void a(PixelFrame pixelFrame) {
        VideoRenderListener videoRenderListener = this.v;
        if (videoRenderListener != null) {
            videoRenderListener.onRenderFrame(pixelFrame);
        }
    }

    private void a(PixelFrame pixelFrame, com.tencent.liteav.videobase.frame.d dVar, boolean z, boolean z2, Rotation rotation, GLConstants.GLScaleType gLScaleType) {
        PixelFrame pixelFrame2 = new PixelFrame(pixelFrame);
        pixelFrame2.setRotation(Rotation.a((pixelFrame.getRotation().mValue + rotation.mValue) % 360));
        if (z) {
            pixelFrame2.setMirrorHorizontal(!pixelFrame2.isMirrorHorizontal());
        }
        if (z2) {
            pixelFrame2.setMirrorVertical(!pixelFrame2.isMirrorVertical());
        }
        if (rotation == Rotation.ROTATION_90 || rotation == Rotation.ROTATION_270) {
            int width = pixelFrame2.getWidth();
            pixelFrame2.setWidth(pixelFrame2.getHeight());
            pixelFrame2.setHeight(width);
        }
        if (dVar == null) {
            pixelFrame2.setMirrorVertical(!pixelFrame2.isMirrorVertical());
            if (pixelFrame2.getRotation() != Rotation.NORMAL && pixelFrame2.getRotation() != Rotation.ROTATION_180) {
                pixelFrame2.setRotation(Rotation.a((pixelFrame2.getRotation().mValue + Rotation.ROTATION_180.mValue) % 360));
            }
        }
        this.k.a(pixelFrame2, gLScaleType, dVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(g gVar) {
        LiteavLog.i("VideoRenderer", "onSurfaceDestroy " + gVar.e);
        gVar.b(null, 0, 0, gVar.g);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(g gVar, Surface surface, int i, int i2, boolean z) {
        LiteavLog.i("VideoRenderer", "setDisplaySurface %s size: %dx%d, old_surface: %s", surface, Integer.valueOf(i), Integer.valueOf(i2), gVar.e);
        if (gVar.e == surface && i == gVar.f.f22649a && i2 == gVar.f.b) {
            LiteavLog.d("VideoRenderer", "setDisplaySurface same surface!");
            return;
        }
        gVar.b(surface, i, i2, gVar.g);
        gVar.g = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(g gVar, GLConstants.GLScaleType gLScaleType) {
        LiteavLog.i("VideoRenderer", "setScaleType ".concat(String.valueOf(gLScaleType)));
        gVar.n = gLScaleType;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(g gVar, TakeSnapshotListener takeSnapshotListener) {
        LiteavLog.i("VideoRenderer", "takeSnapshot ");
        gVar.t = takeSnapshotListener;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(g gVar, Rotation rotation) {
        LiteavLog.i("VideoRenderer", "setRenderRotation ".concat(String.valueOf(rotation)));
        gVar.o = rotation;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(g gVar, DisplayTarget displayTarget, boolean z) {
        DisplayTarget displayTarget2;
        LiteavLog.i("VideoRenderer", "setDisplayView=" + displayTarget + ",clearLastImage=" + z);
        boolean equals = CommonUtil.equals(gVar.d, displayTarget);
        if (!equals) {
            gVar.w = true;
        }
        if (z && !equals && (displayTarget2 = gVar.d) != null) {
            displayTarget2.hideAll();
        }
        gVar.d = displayTarget;
        if (displayTarget != null) {
            displayTarget.showAll();
        }
        gVar.f23135c.a(displayTarget);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(g gVar, VideoRenderListener videoRenderListener) {
        LiteavLog.i("VideoRenderer", "Start");
        if (gVar.r) {
            LiteavLog.w("VideoRenderer", "renderer is started!");
            return;
        }
        gVar.r = true;
        gVar.v = videoRenderListener;
        gVar.u = new ThreadPoolExecutor(0, 1, 5L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        DisplayTarget displayTarget = gVar.d;
        if (displayTarget != null) {
            gVar.setDisplayView(displayTarget, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(g gVar, boolean z) {
        if (gVar.q != z) {
            LiteavLog.i("VideoRenderer", "setVerticalMirror ".concat(String.valueOf(z)));
        }
        gVar.q = z;
    }

    private void a(Runnable runnable) {
        if (Looper.myLooper() == this.f23134a.getLooper()) {
            runnable.run();
        } else {
            this.f23134a.post(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(ByteBuffer byteBuffer, int i, int i2, TakeSnapshotListener takeSnapshotListener) {
        byteBuffer.position(0);
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        createBitmap.copyPixelsFromBuffer(byteBuffer);
        takeSnapshotListener.onComplete(createBitmap);
    }

    private void b() {
        if (this.i == null) {
            return;
        }
        Surface surface = this.e;
        LiteavLog.i("VideoRenderer", "uninitializeEGL %d %d*%d", Integer.valueOf(surface != null ? surface.hashCode() : 0), Integer.valueOf(this.f.f22649a), Integer.valueOf(this.f.b));
        try {
            this.i.a();
        } catch (com.tencent.liteav.videobase.b.g e) {
            LiteavLog.e("VideoRenderer", "uninitializeEGL EGLCore makeCurrent failed.".concat(String.valueOf(e)));
        }
        com.tencent.liteav.videobase.frame.j jVar = this.k;
        if (jVar != null) {
            jVar.a();
            this.k = null;
        }
        this.j.d();
        com.tencent.liteav.videobase.frame.e eVar = this.m;
        if (eVar != null) {
            eVar.a();
            this.m.b();
            this.m = null;
        }
        com.tencent.liteav.videobase.b.e.a(this.i);
        this.i = null;
    }

    private void b(Surface surface, int i, int i2, boolean z) {
        Surface surface2;
        b();
        if (z && (surface2 = this.e) != null) {
            surface2.release();
        }
        this.e = surface;
        this.f.b = i2;
        this.f.f22649a = i;
        if (this.e != null) {
            this.b.updateStatus(com.tencent.liteav.videobase.videobase.i.STATUS_VIDEO_RENDER_RESOLUTION, Integer.valueOf((i << 16) | i2));
        }
        VideoRenderListener videoRenderListener = this.v;
        if (videoRenderListener != null) {
            videoRenderListener.onRenderTargetSizeChanged(i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(g gVar) {
        PixelFrame a2 = gVar.l.a();
        if (a2 == null) {
            LiteavLog.d("VideoRenderer", "renderFrameInternal pixelFrame is null!");
            return;
        }
        if (gVar.i == null || !CommonUtil.equals(gVar.h, a2.getGLContext())) {
            gVar.b();
            Object gLContext = a2.getGLContext();
            if (gVar.e != null) {
                try {
                    LiteavLog.i("VideoRenderer", "initializeEGL surface = " + gVar.e + " ,mSurfaceSize = " + gVar.f);
                    com.tencent.liteav.videobase.b.e eVar = new com.tencent.liteav.videobase.b.e();
                    gVar.i = eVar;
                    eVar.a(gLContext, gVar.e, gVar.f.f22649a, gVar.f.b);
                    gVar.h = gLContext;
                    gVar.i.a();
                    if (gVar.k == null) {
                        gVar.k = new com.tencent.liteav.videobase.frame.j(gVar.f.f22649a, gVar.f.b);
                    }
                    if (gVar.m == null) {
                        gVar.m = new com.tencent.liteav.videobase.frame.e();
                    }
                    gVar.j.a();
                } catch (com.tencent.liteav.videobase.b.g e) {
                    LiteavLog.e("VideoRenderer", "initializeEGL failed.", e);
                    gVar.i = null;
                    IVideoReporter iVideoReporter = gVar.b;
                    h.c cVar = h.c.WARNING_VIDEO_RENDER_EGL_CORE_CREATE_FAILED;
                    iVideoReporter.notifyWarning(cVar, "VideoRender: create EGLCore fail:" + e.toString(), new Object[0]);
                }
            }
        }
        com.tencent.liteav.videobase.b.e eVar2 = gVar.i;
        if (eVar2 == null) {
            gVar.a(a2);
            a2.release();
            return;
        }
        try {
            eVar2.a();
        } catch (com.tencent.liteav.videobase.b.g e2) {
            LiteavLog.e("VideoRenderer", "EGLCore makeCurrent failed.".concat(String.valueOf(e2)));
        }
        OpenGlUtils.glViewport(0, 0, gVar.f.f22649a, gVar.f.b);
        if (gVar.t == null) {
            gVar.a(a2, null, gVar.p, gVar.q, gVar.o, gVar.n);
        } else {
            com.tencent.liteav.videobase.frame.d a3 = gVar.m.a(gVar.f.f22649a, gVar.f.b);
            if (a3 == null) {
                gVar.a(a2);
                LiteavLog.w("VideoRenderer", "get FrameBuffer from pool return null!");
                a2.release();
                return;
            }
            gVar.j.a(a3.a());
            gVar.a(a2, a3, gVar.p, gVar.q, gVar.o, gVar.n);
            if (gVar.f.f22649a == 0 || gVar.f.b == 0) {
                LiteavLog.w("VideoRenderer", "snapshot when surface height or width is zero!");
            } else {
                gVar.j.b();
                int i = gVar.f.f22649a;
                int i2 = gVar.f.b;
                TakeSnapshotListener takeSnapshotListener = gVar.t;
                if (takeSnapshotListener != null && gVar.u != null) {
                    gVar.t = null;
                    ByteBuffer order = ByteBuffer.allocateDirect(i * i2 * 4).order(ByteOrder.nativeOrder());
                    order.position(0);
                    GLES20.glReadPixels(0, 0, i, i2, 6408, 5121, order);
                    try {
                        gVar.u.execute(i.a(order, i, i2, takeSnapshotListener));
                    } catch (Exception e3) {
                        LiteavLog.w("VideoRenderer", "mExecutorService execute exception: " + e3.toString());
                    }
                }
                OpenGlUtils.bindFramebuffer(36160, 0);
            }
            gVar.j.c();
            PixelFrame pixelFrame = new PixelFrame(a2);
            pixelFrame.setPixelBufferType(GLConstants.PixelBufferType.TEXTURE_2D);
            pixelFrame.setPixelFormatType(GLConstants.PixelFormatType.RGBA);
            pixelFrame.setTextureId(a3.a());
            gVar.a(pixelFrame, null, false, false, Rotation.NORMAL, GLConstants.GLScaleType.FILL);
            a3.release();
        }
        try {
            gVar.i.c();
        } catch (com.tencent.liteav.videobase.b.g e4) {
            LiteavLog.e("VideoRenderer", "EGLCore swapBuffers failed.".concat(String.valueOf(e4)));
            IVideoReporter iVideoReporter2 = gVar.b;
            h.c cVar2 = h.c.WARNING_VIDEO_RENDER_SWAP_BUFFER;
            iVideoReporter2.notifyWarning(cVar2, "VideoRender: swapBuffer error:" + e4.toString(), new Object[0]);
        }
        gVar.a(a2);
        if (gVar.w) {
            gVar.b.notifyEvent(h.b.EVT_VIDEO_RENDER_FIRST_FRAME_ON_VIEW, null, new Object[0]);
            gVar.w = false;
        }
        a2.release();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(g gVar, boolean z) {
        if (gVar.p != z) {
            LiteavLog.i("VideoRenderer", "setHorizontalMirror ".concat(String.valueOf(z)));
        }
        gVar.p = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void c(g gVar, boolean z) {
        Surface surface;
        LiteavLog.i("VideoRenderer", "Stop");
        if (!gVar.r) {
            LiteavLog.w("VideoRenderer", "renderer is not started!");
            return;
        }
        gVar.r = false;
        gVar.t = null;
        gVar.f23135c.a((DisplayTarget) null);
        DisplayTarget displayTarget = gVar.d;
        if (displayTarget != null && z) {
            displayTarget.hideAll();
        }
        gVar.l.b();
        gVar.b();
        if (gVar.g && (surface = gVar.e) != null) {
            surface.release();
            gVar.g = false;
        }
        gVar.e = null;
        com.tencent.liteav.base.util.n nVar = gVar.f;
        nVar.b = 0;
        nVar.f22649a = 0;
        ExecutorService executorService = gVar.u;
        if (executorService != null) {
            executorService.shutdown();
            gVar.u = null;
        }
        gVar.s = false;
    }

    @Override // com.tencent.liteav.videoconsumer.renderer.a.InterfaceC0769a
    public final void a() {
        this.f23134a.a(k.a(this));
    }

    @Override // com.tencent.liteav.videoconsumer.renderer.a.InterfaceC0769a
    public final void a(Surface surface, int i, int i2, boolean z) {
        a(j.a(this, surface, i, i2, z));
    }

    @Override // com.tencent.liteav.videoconsumer.renderer.VideoRenderInterface
    public final void renderFrame(PixelFrame pixelFrame) {
        if (this.r) {
            if (pixelFrame == null) {
                LiteavLog.w("VideoRenderer", "renderFrame pixelFrame is null!");
                return;
            }
            if (!this.s) {
                this.s = true;
                LiteavLog.d("VideoRenderer", "VideoRender receive first frame!");
            }
            this.l.a(pixelFrame);
            a(s.a(this));
        }
    }

    @Override // com.tencent.liteav.videoconsumer.renderer.VideoRenderInterface
    public final void setDisplayView(DisplayTarget displayTarget, boolean z) {
        a(m.a(this, displayTarget, z));
    }

    @Override // com.tencent.liteav.videoconsumer.renderer.VideoRenderInterface
    public final void setHorizontalMirror(boolean z) {
        a(q.a(this, z));
    }

    @Override // com.tencent.liteav.videoconsumer.renderer.VideoRenderInterface
    public final void setRenderRotation(Rotation rotation) {
        a(p.a(this, rotation));
    }

    @Override // com.tencent.liteav.videoconsumer.renderer.VideoRenderInterface
    public final void setScaleType(GLConstants.GLScaleType gLScaleType) {
        a(o.a(this, gLScaleType));
    }

    @Override // com.tencent.liteav.videoconsumer.renderer.VideoRenderInterface
    public final void setVerticalMirror(boolean z) {
        a(r.a(this, z));
    }

    @Override // com.tencent.liteav.videoconsumer.renderer.VideoRenderInterface
    public final void start(VideoRenderListener videoRenderListener) {
        a(h.a(this, videoRenderListener));
    }

    @Override // com.tencent.liteav.videoconsumer.renderer.VideoRenderInterface
    public final void stop(boolean z) {
        a(l.a(this, z));
    }

    @Override // com.tencent.liteav.videoconsumer.renderer.VideoRenderInterface
    public final void takeSnapshot(TakeSnapshotListener takeSnapshotListener) {
        a(n.a(this, takeSnapshotListener));
    }
}
