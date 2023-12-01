package com.tencent.liteav.videoproducer.capture;

import android.os.Handler;
import android.os.Looper;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videobase.videobase.IVideoReporter;
import com.tencent.liteav.videobase.videobase.h;
import com.tencent.liteav.videoproducer.capture.CaptureSourceInterface;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/capture/ar.class */
public abstract class ar implements CaptureSourceInterface {

    /* renamed from: a  reason: collision with root package name */
    protected final Handler f23189a;
    protected final IVideoReporter b;

    /* renamed from: c  reason: collision with root package name */
    protected com.tencent.liteav.videobase.b.e f23190c;
    protected CaptureSourceInterface.a d;
    protected com.tencent.liteav.videobase.frame.e e;

    public ar(Looper looper, IVideoReporter iVideoReporter) {
        this.f23189a = new com.tencent.liteav.base.util.b(looper);
        this.b = iVideoReporter;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(ar arVar) {
        arVar.b();
        com.tencent.liteav.videobase.b.e eVar = arVar.f23190c;
        if (eVar != null) {
            try {
                eVar.a();
                if (arVar.e != null) {
                    arVar.e.b();
                    arVar.e = null;
                }
            } catch (com.tencent.liteav.videobase.b.g e) {
                LiteavLog.e("GLCapturerSource", "EGLCore destroy failed.", e);
            }
            com.tencent.liteav.videobase.b.e.a(arVar.f23190c);
            arVar.f23190c = null;
        }
        arVar.d = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(ar arVar, CaptureSourceInterface.a aVar, Object obj, CaptureSourceInterface.CaptureParams captureParams) {
        if (arVar.f23190c != null) {
            LiteavLog.e("GLCapturerSource", "capture source has already started!");
            return;
        }
        arVar.d = aVar;
        com.tencent.liteav.videobase.b.e eVar = new com.tencent.liteav.videobase.b.e();
        arVar.f23190c = eVar;
        try {
            eVar.a(obj, null, 128, 128);
            arVar.f23190c.a();
            arVar.e = new com.tencent.liteav.videobase.frame.e();
        } catch (com.tencent.liteav.videobase.b.g e) {
            LiteavLog.e("GLCapturerSource", "initializeEGL failed.", e);
            IVideoReporter iVideoReporter = arVar.b;
            h.a aVar2 = h.a.ERR_VIDEO_CAPTURE_EGL_CORE_CREATE_FAILED;
            iVideoReporter.notifyError(aVar2, "create EGLCore failed, errorCode:" + e.mErrorCode, new Object[0]);
            arVar.f23190c = null;
        }
        arVar.a(captureParams);
    }

    protected abstract void a(CaptureSourceInterface.CaptureParams captureParams);

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(Runnable runnable) {
        if (this.f23189a.getLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            this.f23189a.post(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(boolean z) {
        CaptureSourceInterface.a aVar = this.d;
        if (aVar != null) {
            aVar.a(z);
        }
    }

    protected abstract void b();

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean c() {
        com.tencent.liteav.videobase.b.e eVar = this.f23190c;
        if (eVar == null) {
            LiteavLog.e("GLCapturerSource", "makeCurrent on mEGLCore is null");
            return false;
        }
        try {
            eVar.a();
            return true;
        } catch (com.tencent.liteav.videobase.b.g e) {
            LiteavLog.e("GLCapturerSource", "make current failed.", e);
            IVideoReporter iVideoReporter = this.b;
            h.a aVar = h.a.ERR_VIDEO_CAPTURE_OPENGL_ERROR;
            iVideoReporter.notifyError(aVar, "OpenGL report error, errorCode:" + e.mErrorCode, new Object[0]);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void d() {
        CaptureSourceInterface.a aVar = this.d;
        if (aVar != null) {
            aVar.a();
        }
    }

    @Override // com.tencent.liteav.videoproducer.capture.CaptureSourceInterface
    public void start(Object obj, CaptureSourceInterface.CaptureParams captureParams, CaptureSourceInterface.a aVar) {
        a(as.a(this, aVar, obj, captureParams));
    }

    @Override // com.tencent.liteav.videoproducer.capture.CaptureSourceInterface
    public void stop() {
        a(at.a(this));
    }
}
