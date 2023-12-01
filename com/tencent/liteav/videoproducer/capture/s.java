package com.tencent.liteav.videoproducer.capture;

import android.os.Handler;
import android.os.Looper;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videobase.frame.PixelFrame;
import com.tencent.liteav.videobase.videobase.IVideoReporter;
import com.tencent.liteav.videoproducer.capture.CaptureSourceInterface;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/capture/s.class */
public final class s implements CaptureSourceInterface {

    /* renamed from: a  reason: collision with root package name */
    final IVideoReporter f36942a;
    protected final Handler b;

    /* renamed from: c  reason: collision with root package name */
    CaptureSourceInterface.a f36943c;
    CameraCaptureParams f;
    boolean d = true;
    boolean e = false;
    final CaptureSourceInterface.a g = new AnonymousClass1();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.liteav.videoproducer.capture.s$1  reason: invalid class name */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/capture/s$1.class */
    public final class AnonymousClass1 implements CaptureSourceInterface.a {
        AnonymousClass1() {
        }

        @Override // com.tencent.liteav.videoproducer.capture.CaptureSourceInterface.a
        public final void a() {
            s.this.a(ac.a(this));
        }

        @Override // com.tencent.liteav.videoproducer.capture.CaptureSourceInterface.a
        public final void a(CaptureSourceInterface captureSourceInterface, PixelFrame pixelFrame) {
            if (pixelFrame != null) {
                pixelFrame.retain();
            }
            s.this.a(ab.a(this, pixelFrame));
        }

        @Override // com.tencent.liteav.videoproducer.capture.CaptureSourceInterface.a
        public final void a(boolean z) {
            s.this.a(aa.a(this, z));
        }

        @Override // com.tencent.liteav.videoproducer.capture.CaptureSourceInterface.a
        public final void b(boolean z) {
        }

        @Override // com.tencent.liteav.videoproducer.capture.CaptureSourceInterface.a
        public final void c(boolean z) {
            if (s.this.f36943c != null) {
                s.this.f36943c.c(z);
            }
        }

        @Override // com.tencent.liteav.videoproducer.capture.CaptureSourceInterface.a
        public final void d(boolean z) {
            if (s.this.f36943c != null) {
                s.this.f36943c.d(z);
            }
        }
    }

    public s(IVideoReporter iVideoReporter, Looper looper) {
        this.f36942a = iVideoReporter;
        this.b = new com.tencent.liteav.base.util.b(looper);
    }

    public final void a(float f) {
        LiteavLog.i("CameraCapturer", "setZoom: ".concat(String.valueOf(f)));
        a(v.a(f));
    }

    public final void a(int i, int i2) {
        a(u.a(i, i2));
    }

    protected final void a(Runnable runnable) {
        if (this.b != null) {
            if (Looper.myLooper() == this.b.getLooper()) {
                runnable.run();
            } else {
                this.b.post(runnable);
            }
        }
    }

    @Override // com.tencent.liteav.videoproducer.capture.CaptureSourceInterface
    public final void pause() {
        LiteavLog.i("CameraCapturer", com.anythink.expressad.foundation.d.c.cb);
        a(z.a(this));
    }

    @Override // com.tencent.liteav.videoproducer.capture.CaptureSourceInterface
    public final void resume() {
        LiteavLog.i("CameraCapturer", "resume");
        a(t.a(this));
    }

    @Override // com.tencent.liteav.videoproducer.capture.CaptureSourceInterface
    public final void start(Object obj, CaptureSourceInterface.CaptureParams captureParams, CaptureSourceInterface.a aVar) {
        LiteavLog.i("CameraCapturer", "Start: ");
        a(w.a(this, captureParams, aVar, obj));
    }

    @Override // com.tencent.liteav.videoproducer.capture.CaptureSourceInterface
    public final void stop() {
        LiteavLog.i("CameraCapturer", "Stop");
        a(x.a(this));
    }

    @Override // com.tencent.liteav.videoproducer.capture.CaptureSourceInterface
    public final void updateParams(CaptureSourceInterface.CaptureParams captureParams) {
        LiteavLog.i("CameraCapturer", "updateParams");
        a(y.a(this, captureParams));
    }
}
