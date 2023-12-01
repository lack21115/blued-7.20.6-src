package com.tencent.liteav.videoproducer.capture;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.media.projection.MediaProjection;
import android.opengl.GLES11Ext;
import android.opengl.Matrix;
import android.os.Looper;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.Surface;
import android.view.WindowManager;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.TimeUtil;
import com.tencent.liteav.base.util.r;
import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videobase.frame.PixelFrame;
import com.tencent.liteav.videobase.frame.l;
import com.tencent.liteav.videobase.utils.OpenGlUtils;
import com.tencent.liteav.videobase.videobase.IVideoReporter;
import com.tencent.liteav.videobase.videobase.h;
import com.tencent.liteav.videoproducer.capture.CaptureSourceInterface;
import com.tencent.liteav.videoproducer.capture.bd;
import com.tencent.ugc.UGCTransitionRules;
import java.util.Locale;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/capture/ScreenCapturer.class */
public final class ScreenCapturer extends ar implements SurfaceTexture.OnFrameAvailableListener, r.a, bd.b {
    protected com.tencent.liteav.videobase.frame.l f;
    private final Context g;
    private final IVideoReporter h;
    private final com.tencent.liteav.base.util.b i;
    private int j;
    private int k;
    private ScreenCaptureParams l;
    private int m;
    private SurfaceTexture n;
    private Surface o;
    private PixelFrame p;
    private com.tencent.liteav.videobase.frame.j q;
    private int r;
    private int s;
    private boolean t;
    private com.tencent.liteav.videobase.utils.g u;
    private com.tencent.liteav.base.util.r v;
    private boolean w;
    private MediaProjection x;
    private boolean y;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/capture/ScreenCapturer$ScreenCaptureParams.class */
    public static class ScreenCaptureParams extends CaptureSourceInterface.CaptureParams {

        /* renamed from: a  reason: collision with root package name */
        public boolean f23158a;
        public MediaProjection f;

        public ScreenCaptureParams() {
        }

        public ScreenCaptureParams(ScreenCaptureParams screenCaptureParams) {
            super(screenCaptureParams);
            this.f23158a = screenCaptureParams.f23158a;
            this.f = screenCaptureParams.f;
        }

        @Override // com.tencent.liteav.videoproducer.capture.CaptureSourceInterface.CaptureParams
        public boolean equals(Object obj) {
            if (obj instanceof ScreenCaptureParams) {
                ScreenCaptureParams screenCaptureParams = (ScreenCaptureParams) obj;
                return super.equals(obj) && this.f23158a == screenCaptureParams.f23158a && this.f == screenCaptureParams.f;
            }
            return false;
        }

        @Override // com.tencent.liteav.videoproducer.capture.CaptureSourceInterface.CaptureParams
        public String toString() {
            return String.format(Locale.ENGLISH, "%s, autoRotate: %b, mediaProjcetion: %s", super.toString(), Boolean.valueOf(this.f23158a), this.f);
        }
    }

    public ScreenCapturer(Context context, Looper looper, IVideoReporter iVideoReporter) {
        super(looper, iVideoReporter);
        this.j = UGCTransitionRules.DEFAULT_IMAGE_WIDTH;
        this.k = 1080;
        this.m = -1;
        this.r = 0;
        this.s = 0;
        this.t = false;
        this.w = false;
        this.y = true;
        this.g = context;
        this.h = iVideoReporter;
        this.i = new com.tencent.liteav.base.util.b(Looper.getMainLooper());
        try {
            WindowManager windowManager = (WindowManager) this.g.getSystemService(Context.WINDOW_SERVICE);
            if (windowManager != null) {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
                this.j = displayMetrics.widthPixels;
                this.k = displayMetrics.heightPixels;
                LiteavLog.i("ScreenCapturer", "DeviceScreen:[width:%d][height:%d]", Integer.valueOf(this.j), Integer.valueOf(this.k));
            }
        } catch (Exception e) {
            LiteavLog.e("ScreenCapturer", "get screen resolution failed.", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(ScreenCapturer screenCapturer) {
        LiteavLog.e("ScreenCapturer", "capture error");
        if (screenCapturer.d != null) {
            screenCapturer.d.a();
        }
        screenCapturer.h.notifyEvent(h.b.EVT_VIDEO_CAPTURE_SCREEN_CAPTURE_INTERRUPTED, "screen capture has been interrupted", new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(ScreenCapturer screenCapturer, CaptureSourceInterface.CaptureParams captureParams) {
        ScreenCaptureParams screenCaptureParams = screenCapturer.l;
        if (screenCaptureParams != null && screenCaptureParams.equals(captureParams)) {
            LiteavLog.i("ScreenCapturer", "updateParams %s is the same ", captureParams);
            return;
        }
        LiteavLog.i("ScreenCapturer", "updateParams %s", captureParams);
        ScreenCaptureParams screenCaptureParams2 = new ScreenCaptureParams((ScreenCaptureParams) captureParams);
        screenCapturer.l = screenCaptureParams2;
        if (screenCapturer.n == null) {
            LiteavLog.e("ScreenCapturer", "capturer not started");
            return;
        }
        screenCapturer.x = screenCaptureParams2.f;
        screenCapturer.g();
        screenCapturer.f();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(ScreenCapturer screenCapturer, boolean z) {
        LiteavLog.d("ScreenCapturer", "display orientation changed, isPortrait: %b", Boolean.valueOf(z));
        if (screenCapturer.y || !screenCapturer.l.f23158a) {
            return;
        }
        screenCapturer.g();
        screenCapturer.f();
        if (screenCapturer.d != null) {
            screenCapturer.d.b(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(ScreenCapturer screenCapturer, boolean z, boolean z2) {
        LiteavLog.i("ScreenCapturer", "on Start finish, success: %b, isPermissionDenied: %b", Boolean.valueOf(z), Boolean.valueOf(z2));
        screenCapturer.a(z);
        if (z) {
            if (screenCapturer.w) {
                return;
            }
            screenCapturer.w = true;
            IVideoReporter iVideoReporter = screenCapturer.h;
            h.b bVar = h.b.EVT_VIDEO_CAPTURE_SCREEN_CAPTURE_START_SUCCESS;
            iVideoReporter.notifyEvent(bVar, "Start screen capture success params:" + screenCapturer.l, new Object[0]);
        } else if (z2) {
            IVideoReporter iVideoReporter2 = screenCapturer.h;
            h.a aVar = h.a.ERR_VIDEO_CAPTURE_SCREEN_UNAUTHORIZED;
            iVideoReporter2.notifyError(aVar, "permission denied, Start screen capture failed, params:" + screenCapturer.l, new Object[0]);
        } else {
            IVideoReporter iVideoReporter3 = screenCapturer.h;
            h.a aVar2 = h.a.ERR_VIDEO_CAPTURE_SCREEN_CAPTURE_START_FAILED;
            iVideoReporter3.notifyError(aVar2, "Start screen capture failed, params:" + screenCapturer.l, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(ScreenCapturer screenCapturer) {
        if (screenCapturer.n == null) {
            return;
        }
        screenCapturer.u = new com.tencent.liteav.videobase.utils.g(screenCapturer.l.b);
        com.tencent.liteav.base.util.r rVar = new com.tencent.liteav.base.util.r(screenCapturer.f23189a.getLooper(), screenCapturer);
        screenCapturer.v = rVar;
        rVar.a(0, 5);
        screenCapturer.n.setOnFrameAvailableListener(null);
        screenCapturer.q = new com.tencent.liteav.videobase.frame.j(screenCapturer.r, screenCapturer.s);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void c(ScreenCapturer screenCapturer) {
        LiteavLog.i("ScreenCapturer", "resume capture");
        if (screenCapturer.t) {
            screenCapturer.h.notifyEvent(h.b.EVT_VIDEO_CAPTURE_SCREEN_CAPTURE_RESUME, "screen capture has been resumed", new Object[0]);
        }
        screenCapturer.t = false;
        com.tencent.liteav.videobase.utils.g gVar = screenCapturer.u;
        if (gVar != null) {
            gVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void d(ScreenCapturer screenCapturer) {
        LiteavLog.i("ScreenCapturer", "pause capture");
        if (!screenCapturer.t) {
            screenCapturer.h.notifyEvent(h.b.EVT_VIDEO_CAPTURE_SCREEN_CAPTURE_INTERRUPTED, "screen capture has been interrupted", new Object[0]);
        }
        screenCapturer.t = true;
    }

    private void f() {
        if (this.f == null) {
            this.f = new com.tencent.liteav.videobase.frame.l();
        }
        if (this.j == 0 || this.k == 0) {
            this.j = this.l.f23155c;
            this.k = this.l.d;
        }
        int i = this.j;
        int i2 = this.k;
        if (this.l.f23158a) {
            int rotation = ((WindowManager) this.g.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getRotation();
            if (rotation == 0 || rotation == 2) {
                i = Math.min(this.j, this.k);
                i2 = Math.max(this.j, this.k);
            } else {
                i = Math.max(this.j, this.k);
                i2 = Math.min(this.j, this.k);
            }
        }
        this.m = OpenGlUtils.generateTextureOES();
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.m);
        this.n = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(this);
        this.n.setDefaultBufferSize(i, i2);
        this.o = new Surface(this.n);
        bd.a(this.g).a(this.o, i, i2, this.x, this);
        LiteavLog.i("ScreenCapturer", "Start virtual display, size: %dx%d", Integer.valueOf(i), Integer.valueOf(i2));
        this.s = i2;
        this.r = i;
        PixelFrame pixelFrame = new PixelFrame();
        this.p = pixelFrame;
        pixelFrame.setPixelFormatType(GLConstants.PixelFormatType.RGBA);
        this.p.setPixelBufferType(GLConstants.PixelBufferType.TEXTURE_OES);
        this.p.setTextureId(this.m);
        this.p.setWidth(i);
        this.p.setHeight(i2);
        this.p.setMatrix(new float[16]);
    }

    private void g() {
        this.x = null;
        bd.a(this.g).a(this.o);
        Surface surface = this.o;
        if (surface != null) {
            surface.release();
            this.o = null;
        }
        if (!c()) {
            LiteavLog.w("ScreenCapturer", "makeCurrent error!");
            d();
            return;
        }
        com.tencent.liteav.videobase.frame.l lVar = this.f;
        if (lVar != null) {
            lVar.b();
            this.f = null;
        }
        com.tencent.liteav.videobase.frame.j jVar = this.q;
        if (jVar != null) {
            jVar.a();
            this.q = null;
        }
        SurfaceTexture surfaceTexture = this.n;
        if (surfaceTexture != null) {
            surfaceTexture.setOnFrameAvailableListener(null);
            this.n.release();
            this.n = null;
        }
        OpenGlUtils.deleteTexture(this.m);
        this.m = -1;
        com.tencent.liteav.base.util.r rVar = this.v;
        if (rVar != null) {
            rVar.a();
            this.v = null;
        }
    }

    @Override // com.tencent.liteav.videoproducer.capture.ar
    protected final void a(CaptureSourceInterface.CaptureParams captureParams) {
        if (!this.y) {
            LiteavLog.e("ScreenCapturer", "Start capture %s, capturer already started", captureParams);
        } else if (this.f23190c == null) {
            LiteavLog.e("ScreenCapturer", "Start capture %s, mEGLCore is null", captureParams);
            a(false);
        } else {
            LiteavLog.i("ScreenCapturer", "Start capture %s", captureParams);
            ScreenCaptureParams screenCaptureParams = new ScreenCaptureParams((ScreenCaptureParams) captureParams);
            this.l = screenCaptureParams;
            this.x = screenCaptureParams.f;
            if (c()) {
                f();
                this.y = false;
                return;
            }
            IVideoReporter iVideoReporter = this.h;
            h.a aVar = h.a.ERR_VIDEO_CAPTURE_SCREEN_CAPTURE_START_FAILED;
            iVideoReporter.notifyError(aVar, "Start screen capture failed, params:" + this.l, new Object[0]);
            a(false);
        }
    }

    @Override // com.tencent.liteav.videoproducer.capture.bd.b
    public final void a(boolean z, boolean z2) {
        a(ba.a(this, z, z2));
    }

    @Override // com.tencent.liteav.base.util.r.a
    public final void a_() {
        boolean z;
        float f;
        float f2;
        float f3;
        float f4;
        if (this.n == null || this.t) {
            return;
        }
        if (!c()) {
            d();
            return;
        }
        com.tencent.liteav.videobase.utils.g gVar = this.u;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (gVar.f22967a == 0) {
            z = true;
        } else {
            z = true;
            if (gVar.b != -1) {
                z = elapsedRealtime - gVar.b >= ((gVar.f22968c + 1) * 1000) / ((long) gVar.f22967a);
            }
        }
        if (z) {
            com.tencent.liteav.videobase.utils.g gVar2 = this.u;
            if (gVar2.b == -1) {
                gVar2.b = SystemClock.elapsedRealtime();
            }
            gVar2.f22968c++;
            if (this.f == null || this.l == null || this.f23190c == null) {
                LiteavLog.w("ScreenCapturer", "onScreenFrameAvailable mTextureHolderPool = " + this.f + ", mCaptureParams = " + this.l + ", mEGLCore = " + this.f23190c);
                return;
            }
            l.b bVar = null;
            try {
                bVar = this.f.a();
            } catch (InterruptedException e) {
                LiteavLog.w("ScreenCapturer", "textureholderpool obtain interrupted.");
            }
            if (this.l.e == null || this.l.e.isEmpty()) {
                f = 1.0f;
                f2 = 0.0f;
                f3 = 0.0f;
                f4 = 1.0f;
            } else {
                Rect rect = this.l.e;
                f2 = (rect.left * 1.0f) / this.r;
                f3 = (rect.top * 1.0f) / this.s;
                int min = Math.min(this.r - rect.left, rect.width());
                f4 = (min * 1.0f) / this.r;
                f = (Math.min(this.s - rect.top, rect.height()) * 1.0f) / this.s;
            }
            bVar.a(GLES11Ext.GL_TEXTURE_EXTERNAL_OES, this.m, this.r, this.s);
            PixelFrame a2 = bVar.a(this.f23190c.d());
            if (a2.getMatrix() == null) {
                a2.setMatrix(new float[16]);
            }
            this.n.updateTexImage();
            this.n.getTransformMatrix(a2.getMatrix());
            a2.setTimestamp(TimeUtil.c());
            if (!com.tencent.liteav.videobase.utils.e.a(f2, 0.0f) || !com.tencent.liteav.videobase.utils.e.a(f3, 0.0f)) {
                Matrix.translateM(a2.getMatrix(), 0, f2, f3, 0.0f);
            }
            if (!com.tencent.liteav.videobase.utils.e.a(f4, 1.0f) || !com.tencent.liteav.videobase.utils.e.a(f, 1.0f)) {
                Matrix.scaleM(a2.getMatrix(), 0, f4, f, 1.0f);
            }
            if (this.d != null) {
                this.d.a(this, a2);
            }
            bVar.release();
            a2.release();
        }
    }

    @Override // com.tencent.liteav.videoproducer.capture.ar
    protected final void b() {
        if (this.y) {
            LiteavLog.i("ScreenCapturer", "Stop capture, capturer already stopped");
            return;
        }
        LiteavLog.i("ScreenCapturer", "Stop capture");
        g();
        this.h.notifyEvent(h.b.EVT_VIDEO_CAPTURE_SCREEN_CAPTURE_STOP_SUCCESS, "Stop screen capture success", new Object[0]);
        this.y = true;
    }

    @Override // com.tencent.liteav.videoproducer.capture.bd.b
    public final void b(boolean z) {
        a(bc.a(this, z));
    }

    @Override // com.tencent.liteav.videoproducer.capture.bd.b
    public final void e() {
        a(bb.a(this));
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
        a(az.a(this));
    }

    @Override // com.tencent.liteav.videoproducer.capture.CaptureSourceInterface
    public final void pause() {
        a(ax.a(this));
    }

    @Override // com.tencent.liteav.videoproducer.capture.CaptureSourceInterface
    public final void resume() {
        a(ay.a(this));
    }

    @Override // com.tencent.liteav.videoproducer.capture.CaptureSourceInterface
    public final void updateParams(CaptureSourceInterface.CaptureParams captureParams) {
        a(aw.a(this, captureParams));
    }
}
