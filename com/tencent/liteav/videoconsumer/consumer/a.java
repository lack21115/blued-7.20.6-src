package com.tencent.liteav.videoconsumer.consumer;

import android.os.Looper;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videobase.base.TakeSnapshotListener;
import com.tencent.liteav.videobase.frame.PixelFrame;
import com.tencent.liteav.videobase.utils.Rotation;
import com.tencent.liteav.videobase.videobase.DisplayTarget;
import com.tencent.liteav.videobase.videobase.e;
import com.tencent.liteav.videoconsumer.renderer.VideoRenderInterface;
import com.tencent.liteav.videoconsumer.renderer.VideoRenderListener;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videoconsumer/consumer/a.class */
public final class a extends VideoRenderInterface implements e.a {

    /* renamed from: a  reason: collision with root package name */
    private final com.tencent.liteav.base.util.b f22998a;
    private com.tencent.liteav.videobase.videobase.e g;
    private VideoRenderListener h;
    private com.tencent.liteav.videobase.frame.j i;
    private com.tencent.liteav.videobase.frame.e j;
    private Object m;
    private com.tencent.liteav.videobase.b.e b = null;

    /* renamed from: c  reason: collision with root package name */
    private volatile boolean f22999c = false;
    private boolean d = false;
    private GLConstants.PixelFormatType e = GLConstants.PixelFormatType.RGBA;
    private GLConstants.PixelBufferType f = GLConstants.PixelBufferType.TEXTURE_2D;
    private int k = 0;
    private int l = 0;
    private Rotation n = Rotation.NORMAL;
    private boolean o = false;
    private boolean p = false;

    public a(Looper looper) {
        this.f22998a = new com.tencent.liteav.base.util.b(looper);
    }

    private void a() {
        com.tencent.liteav.videobase.b.e eVar = this.b;
        if (eVar == null) {
            return;
        }
        try {
            eVar.a();
        } catch (com.tencent.liteav.videobase.b.g e) {
            LiteavLog.e("CustomRenderProcess", "uninitializedEGL makeCurrent error " + e.toString());
        }
        LiteavLog.i("CustomRenderProcess", "egl uninitializedEGL");
        com.tencent.liteav.videobase.frame.j jVar = this.i;
        if (jVar != null) {
            jVar.a();
            this.i = null;
        }
        com.tencent.liteav.videobase.frame.e eVar2 = this.j;
        if (eVar2 != null) {
            eVar2.a();
            this.j.b();
            this.j = null;
        }
        com.tencent.liteav.videobase.videobase.e eVar3 = this.g;
        if (eVar3 != null) {
            eVar3.a(0, this);
            this.g.a();
            this.g = null;
        }
        com.tencent.liteav.videobase.b.e.a(this.b);
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(a aVar) {
        if (!aVar.f22999c) {
            LiteavLog.w("CustomRenderProcess", "renderer is not started!");
            return;
        }
        aVar.f22999c = false;
        aVar.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(a aVar, GLConstants.PixelFormatType pixelFormatType, GLConstants.PixelBufferType pixelBufferType) {
        aVar.d = true;
        aVar.e = pixelFormatType;
        aVar.f = pixelBufferType;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(a aVar, PixelFrame pixelFrame) {
        if (aVar.h != null) {
            PixelFrame pixelFrame2 = new PixelFrame(pixelFrame);
            pixelFrame2.setRotation(Rotation.NORMAL);
            aVar.h.onRenderFrame(pixelFrame2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(a aVar, VideoRenderListener videoRenderListener) {
        if (aVar.f22999c) {
            LiteavLog.w("CustomRenderProcess", "renderer is started!");
            return;
        }
        aVar.h = videoRenderListener;
        aVar.f22999c = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(a aVar, boolean z) {
        if (aVar.p != z) {
            LiteavLog.i("CustomRenderProcess", "setVerticalMirror ".concat(String.valueOf(z)));
        }
        aVar.p = z;
    }

    private boolean a(Runnable runnable) {
        if (Looper.myLooper() == this.f22998a.getLooper()) {
            runnable.run();
            return true;
        } else if (this.f22998a.getLooper().getThread().isAlive()) {
            return this.f22998a.post(runnable);
        } else {
            LiteavLog.w("CustomRenderProcess", "runOnRenderThread: thread is dead!");
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(a aVar, PixelFrame pixelFrame) {
        PixelFrame pixelFrame2 = new PixelFrame(pixelFrame);
        pixelFrame2.setRotation(Rotation.a((pixelFrame2.getRotation().mValue + aVar.n.mValue) % 360));
        if (aVar.o) {
            pixelFrame2.setMirrorHorizontal(!pixelFrame2.isMirrorHorizontal());
        }
        if (aVar.p) {
            pixelFrame2.setMirrorVertical(!pixelFrame2.isMirrorVertical());
        }
        if (aVar.n == Rotation.ROTATION_90 || aVar.n == Rotation.ROTATION_270) {
            int width = pixelFrame2.getWidth();
            pixelFrame2.setWidth(pixelFrame2.getHeight());
            pixelFrame2.setHeight(width);
        }
        Object gLContext = pixelFrame2.getGLContext();
        if (((gLContext == null || gLContext == aVar.m) && aVar.b != null && aVar.l == pixelFrame2.getHeight() && aVar.k == pixelFrame2.getWidth()) ? false : true) {
            if (aVar.k != pixelFrame2.getWidth() || aVar.l != pixelFrame2.getHeight()) {
                aVar.k = pixelFrame2.getWidth();
                aVar.l = pixelFrame2.getHeight();
            }
            aVar.a();
            int i = aVar.k;
            int i2 = aVar.l;
            Object gLContext2 = pixelFrame2.getGLContext();
            if (aVar.b != null) {
                LiteavLog.w("CustomRenderProcess", "egl is initialized!");
            } else {
                try {
                    LiteavLog.i("CustomRenderProcess", "egl init %d*%d", Integer.valueOf(i), Integer.valueOf(i2));
                    com.tencent.liteav.videobase.b.e eVar = new com.tencent.liteav.videobase.b.e();
                    aVar.b = eVar;
                    eVar.a(gLContext2, null, i, i2);
                    aVar.b.a();
                } catch (com.tencent.liteav.videobase.b.g e) {
                    LiteavLog.e("CustomRenderProcess", "egl initialize failed.", e);
                    aVar.b = null;
                }
                if (aVar.b != null) {
                    aVar.m = gLContext2;
                    if (aVar.i == null) {
                        aVar.i = new com.tencent.liteav.videobase.frame.j(i, i2);
                    }
                    aVar.j = new com.tencent.liteav.videobase.frame.e();
                    if (aVar.g == null) {
                        com.tencent.liteav.videobase.videobase.e eVar2 = new com.tencent.liteav.videobase.videobase.e();
                        aVar.g = eVar2;
                        eVar2.a(new com.tencent.liteav.videobase.videobase.a(aVar.k, aVar.l), aVar.f, aVar.e, 0, aVar);
                        aVar.g.a(aVar.j);
                    }
                }
            }
        }
        com.tencent.liteav.videobase.b.e eVar3 = aVar.b;
        if (eVar3 != null) {
            try {
                eVar3.a();
            } catch (com.tencent.liteav.videobase.b.g e2) {
                LiteavLog.e("CustomRenderProcess", "customRenderFrame makeCurrent error " + e2.toString());
            }
            if (aVar.d) {
                aVar.d = false;
                aVar.g.a(0, aVar);
                aVar.g.a(new com.tencent.liteav.videobase.videobase.a(aVar.k, aVar.l), aVar.f, aVar.e, 0, aVar);
            }
            com.tencent.liteav.videobase.frame.d a2 = aVar.j.a(aVar.k, aVar.l);
            GLConstants.GLScaleType gLScaleType = GLConstants.GLScaleType.CENTER_CROP;
            PixelFrame pixelFrame3 = new PixelFrame(pixelFrame2);
            if (a2 == null) {
                pixelFrame3.setMirrorVertical(true ^ pixelFrame3.isMirrorVertical());
                if (pixelFrame3.getRotation() != Rotation.NORMAL && pixelFrame3.getRotation() != Rotation.ROTATION_180) {
                    pixelFrame3.setRotation(Rotation.a((pixelFrame3.getRotation().mValue + Rotation.ROTATION_180.mValue) % 360));
                }
            }
            com.tencent.liteav.videobase.frame.j jVar = aVar.i;
            if (jVar != null) {
                jVar.a(pixelFrame3, gLScaleType, a2);
            }
            com.tencent.liteav.videobase.videobase.e eVar4 = aVar.g;
            if (eVar4 != null) {
                eVar4.a(pixelFrame2.getTimestamp(), a2);
            }
            a2.release();
        }
        pixelFrame.release();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(a aVar, boolean z) {
        if (aVar.o != z) {
            LiteavLog.i("CustomRenderProcess", "setHorizontalMirror ".concat(String.valueOf(z)));
        }
        aVar.o = z;
    }

    public final void a(GLConstants.PixelFormatType pixelFormatType, GLConstants.PixelBufferType pixelBufferType) {
        a(b.a(this, pixelFormatType, pixelBufferType));
    }

    @Override // com.tencent.liteav.videobase.videobase.e.a
    public final void onFrameConverted(int i, PixelFrame pixelFrame) {
        a(i.a(this, pixelFrame));
    }

    @Override // com.tencent.liteav.videoconsumer.renderer.VideoRenderInterface
    public final void renderFrame(PixelFrame pixelFrame) {
        if (pixelFrame == null) {
            LiteavLog.w("CustomRenderProcess", "renderFrame: pixelFrame is null.");
            return;
        }
        pixelFrame.retain();
        if (a(h.a(this, pixelFrame))) {
            return;
        }
        pixelFrame.release();
    }

    @Override // com.tencent.liteav.videoconsumer.renderer.VideoRenderInterface
    public final void setDisplayView(DisplayTarget displayTarget, boolean z) {
        LiteavLog.i("CustomRenderProcess", "setDisplayView not support");
    }

    @Override // com.tencent.liteav.videoconsumer.renderer.VideoRenderInterface
    public final void setHorizontalMirror(boolean z) {
        a(f.a(this, z));
    }

    @Override // com.tencent.liteav.videoconsumer.renderer.VideoRenderInterface
    public final void setRenderRotation(Rotation rotation) {
        LiteavLog.i("CustomRenderProcess", "setRenderRotation ".concat(String.valueOf(rotation)));
        a(e.a(this, rotation));
    }

    @Override // com.tencent.liteav.videoconsumer.renderer.VideoRenderInterface
    public final void setScaleType(GLConstants.GLScaleType gLScaleType) {
        LiteavLog.i("CustomRenderProcess", "setScaleType " + gLScaleType + " not support");
    }

    @Override // com.tencent.liteav.videoconsumer.renderer.VideoRenderInterface
    public final void setVerticalMirror(boolean z) {
        a(g.a(this, z));
    }

    @Override // com.tencent.liteav.videoconsumer.renderer.VideoRenderInterface
    public final void start(VideoRenderListener videoRenderListener) {
        LiteavLog.i("CustomRenderProcess", "Start");
        a(c.a(this, videoRenderListener));
    }

    @Override // com.tencent.liteav.videoconsumer.renderer.VideoRenderInterface
    public final void stop(boolean z) {
        LiteavLog.i("CustomRenderProcess", "Stop");
        a(d.a(this));
    }

    @Override // com.tencent.liteav.videoconsumer.renderer.VideoRenderInterface
    public final void takeSnapshot(TakeSnapshotListener takeSnapshotListener) {
        if (takeSnapshotListener != null) {
            takeSnapshotListener.onComplete(null);
        }
    }
}
