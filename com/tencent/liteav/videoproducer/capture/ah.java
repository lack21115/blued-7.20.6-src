package com.tencent.liteav.videoproducer.capture;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Looper;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videobase.frame.PixelFrame;
import com.tencent.liteav.videobase.utils.f;
import com.tencent.liteav.videobase.videobase.IVideoReporter;
import com.tencent.liteav.videoproducer.capture.CaptureSourceInterface;
import com.tencent.liteav.videoproducer.capture.VirtualCamera;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/capture/ah.class */
public final class ah implements CaptureSourceInterface {

    /* renamed from: a  reason: collision with root package name */
    VirtualCamera f36864a;
    VirtualCamera.VirtualCameraParams b;

    /* renamed from: c  reason: collision with root package name */
    public CaptureSourceInterface f36865c;
    CaptureSourceInterface.CaptureParams d;
    CaptureSourceInterface.a e;
    final Looper f;
    final Context g;
    final IVideoReporter h;
    Object i;
    private final com.tencent.liteav.base.util.b o;
    boolean j = false;
    a k = a.STOPED;
    boolean l = false;
    final CaptureSourceInterface.a n = new AnonymousClass1();
    final com.tencent.liteav.videobase.utils.f m = new com.tencent.liteav.videobase.utils.f("CaptureController", 1000, new f.a(this) { // from class: com.tencent.liteav.videoproducer.capture.ai

        /* renamed from: a  reason: collision with root package name */
        private final ah f36869a;

        /* JADX INFO: Access modifiers changed from: package-private */
        {
            this.f36869a = this;
        }

        @Override // com.tencent.liteav.videobase.utils.f.a
        public final void a(double d) {
            this.f36869a.h.updateStatus(com.tencent.liteav.videobase.videobase.i.b, Double.valueOf(d));
        }
    });

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.liteav.videoproducer.capture.ah$1  reason: invalid class name */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/capture/ah$1.class */
    public final class AnonymousClass1 implements CaptureSourceInterface.a {
        AnonymousClass1() {
        }

        @Override // com.tencent.liteav.videoproducer.capture.CaptureSourceInterface.a
        public final void a() {
            if (ah.this.e != null) {
                ah.this.e.a();
            }
        }

        @Override // com.tencent.liteav.videoproducer.capture.CaptureSourceInterface.a
        public final void a(CaptureSourceInterface captureSourceInterface, PixelFrame pixelFrame) {
            if (!ah.this.l) {
                ah.this.l = true;
                LiteavLog.i("CaptureController", "CaptureController received first frame.");
            }
            if (pixelFrame != null) {
                ah.this.a(ap.a(this));
            }
            if (ah.this.e != null) {
                ah.this.e.a(ah.this, pixelFrame);
            }
        }

        @Override // com.tencent.liteav.videoproducer.capture.CaptureSourceInterface.a
        public final void a(boolean z) {
            if (ah.this.e != null) {
                ah.this.e.a(z);
            }
        }

        @Override // com.tencent.liteav.videoproducer.capture.CaptureSourceInterface.a
        public final void b(boolean z) {
            if (ah.this.e != null) {
                ah.this.e.b(z);
            }
        }

        @Override // com.tencent.liteav.videoproducer.capture.CaptureSourceInterface.a
        public final void c(boolean z) {
            if (ah.this.e != null) {
                ah.this.e.c(z);
            }
        }

        @Override // com.tencent.liteav.videoproducer.capture.CaptureSourceInterface.a
        public final void d(boolean z) {
            if (ah.this.e != null) {
                ah.this.e.d(z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/capture/ah$a.class */
    public enum a {
        STOPED,
        STARTED,
        PAUSED
    }

    public ah(Context context, Looper looper, IVideoReporter iVideoReporter) {
        this.g = context.getApplicationContext();
        this.f = looper;
        this.h = iVideoReporter;
        this.o = new com.tencent.liteav.base.util.b(this.f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(ah ahVar) {
        if (ahVar.k != a.STARTED) {
            LiteavLog.w("CaptureController", "pause capture but mStatus is " + ahVar.k);
            return;
        }
        ahVar.k = a.PAUSED;
        CaptureSourceInterface captureSourceInterface = ahVar.f36865c;
        if (captureSourceInterface != null) {
            captureSourceInterface.pause();
        }
        if (!ahVar.j) {
            ahVar.m.b();
            return;
        }
        if (ahVar.b == null) {
            ahVar.a(null, 5, ahVar.d.f36846c, ahVar.d.d);
        } else {
            ahVar.f36864a = new VirtualCamera(ahVar.f, ahVar.h);
        }
        VirtualCamera virtualCamera = ahVar.f36864a;
        if (virtualCamera != null) {
            virtualCamera.start(ahVar.i, ahVar.b, ahVar.n);
        }
    }

    public final void a(Bitmap bitmap, int i, int i2, int i3) {
        LiteavLog.i("CaptureController", "setVirtualCameraParams fps = " + i + ",width=" + i2 + ",height=" + i3 + ",bm=" + bitmap);
        a(aj.a(this, bitmap, i, i3, i2));
    }

    protected final void a(Runnable runnable) {
        if (Looper.myLooper() == this.o.getLooper()) {
            runnable.run();
        } else {
            this.o.post(runnable);
        }
    }

    @Override // com.tencent.liteav.videoproducer.capture.CaptureSourceInterface
    public final void pause() {
        LiteavLog.i("CaptureController", com.anythink.expressad.foundation.d.c.cb);
        a(al.a(this));
    }

    @Override // com.tencent.liteav.videoproducer.capture.CaptureSourceInterface
    public final void resume() {
        LiteavLog.i("CaptureController", "resume");
        a(am.a(this));
    }

    @Override // com.tencent.liteav.videoproducer.capture.CaptureSourceInterface
    public final void start(Object obj, CaptureSourceInterface.CaptureParams captureParams, CaptureSourceInterface.a aVar) {
        LiteavLog.i("CaptureController", "Start params = " + captureParams.toString() + ", glContext=" + obj);
        a(ak.a(this, captureParams, aVar, obj));
    }

    @Override // com.tencent.liteav.videoproducer.capture.CaptureSourceInterface
    public final void stop() {
        LiteavLog.i("CaptureController", "Stop");
        a(an.a(this));
    }

    @Override // com.tencent.liteav.videoproducer.capture.CaptureSourceInterface
    public final void updateParams(CaptureSourceInterface.CaptureParams captureParams) {
        a(ao.a(this, captureParams));
    }
}
