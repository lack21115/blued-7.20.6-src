package com.tencent.liteav.videoproducer.capture;

import android.graphics.Bitmap;
import android.os.Looper;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.TimeUtil;
import com.tencent.liteav.base.util.r;
import com.tencent.liteav.videobase.frame.PixelFrame;
import com.tencent.liteav.videobase.utils.OpenGlUtils;
import com.tencent.liteav.videobase.videobase.IVideoReporter;
import com.tencent.liteav.videobase.videobase.h;
import com.tencent.liteav.videoproducer.capture.CaptureSourceInterface;
import java.util.Locale;
import java.util.Objects;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/capture/VirtualCamera.class */
public final class VirtualCamera extends ar {
    PixelFrame f;
    private com.tencent.liteav.base.util.r g;
    private VirtualCameraParams h;
    private boolean i;
    private boolean j;
    private final r.a k;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/capture/VirtualCamera$VirtualCameraParams.class */
    public static class VirtualCameraParams extends CaptureSourceInterface.CaptureParams {

        /* renamed from: a  reason: collision with root package name */
        public Bitmap f36851a;

        public VirtualCameraParams() {
        }

        public VirtualCameraParams(VirtualCameraParams virtualCameraParams) {
            super(virtualCameraParams);
            this.f36851a = virtualCameraParams.f36851a;
        }

        @Override // com.tencent.liteav.videoproducer.capture.CaptureSourceInterface.CaptureParams
        public boolean equals(Object obj) {
            if (obj instanceof VirtualCameraParams) {
                return super.equals(obj) && Objects.equals(this.f36851a, ((VirtualCameraParams) obj).f36851a);
            }
            return false;
        }

        @Override // com.tencent.liteav.videoproducer.capture.CaptureSourceInterface.CaptureParams
        public String toString() {
            Locale locale = Locale.ENGLISH;
            String captureParams = super.toString();
            int i = 0;
            boolean z = this.f36851a != null;
            Bitmap bitmap = this.f36851a;
            int width = bitmap != null ? bitmap.getWidth() : 0;
            Bitmap bitmap2 = this.f36851a;
            if (bitmap2 != null) {
                i = bitmap2.getHeight();
            }
            return String.format(locale, "%s, hasBitmap:%b, w*h:%d*%d", captureParams, Boolean.valueOf(z), Integer.valueOf(width), Integer.valueOf(i));
        }
    }

    public VirtualCamera(Looper looper, IVideoReporter iVideoReporter) {
        super(looper, iVideoReporter);
        this.i = true;
        this.j = false;
        this.k = new r.a() { // from class: com.tencent.liteav.videoproducer.capture.VirtualCamera.1
            @Override // com.tencent.liteav.base.util.r.a
            public final void a_() {
                CaptureSourceInterface.a aVar = VirtualCamera.this.d;
                if (aVar == null || !VirtualCamera.this.c()) {
                    return;
                }
                if (VirtualCamera.this.f != null) {
                    VirtualCamera.this.f.setTimestamp(TimeUtil.c());
                }
                VirtualCamera virtualCamera = VirtualCamera.this;
                aVar.a(virtualCamera, virtualCamera.f);
            }
        };
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x006b, code lost:
        if ((r0.getHeight() % 2) == 1) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a() {
        /*
            Method dump skipped, instructions count: 355
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.videoproducer.capture.VirtualCamera.a():void");
    }

    private void e() {
        LiteavLog.i("VirtualCameraImpl", "Stop virtual camera");
        com.tencent.liteav.base.util.r rVar = this.g;
        if (rVar != null) {
            rVar.a();
            this.g = null;
        }
        PixelFrame pixelFrame = this.f;
        if (pixelFrame != null) {
            OpenGlUtils.deleteTexture(pixelFrame.getTextureId());
            this.f = null;
        }
        this.i = true;
    }

    @Override // com.tencent.liteav.videoproducer.capture.ar
    protected final void a(CaptureSourceInterface.CaptureParams captureParams) {
        this.h = new VirtualCameraParams((VirtualCameraParams) captureParams);
        a();
        IVideoReporter iVideoReporter = this.b;
        h.b bVar = h.b.EVT_VIDEO_CAPTURE_VIRTUAL_CAMERA_START_SUCCESS;
        iVideoReporter.notifyEvent(bVar, "Start virtual camera success params:" + this.h, new Object[0]);
    }

    @Override // com.tencent.liteav.videoproducer.capture.ar
    protected final void b() {
        e();
        this.j = false;
        this.b.notifyEvent(h.b.EVT_VIDEO_CAPTURE_VIRTUAL_CAMERA_STOP_SUCCESS, "Stop virtual camera success", new Object[0]);
    }

    @Override // com.tencent.liteav.videoproducer.capture.CaptureSourceInterface
    public final void pause() {
        e();
    }

    @Override // com.tencent.liteav.videoproducer.capture.CaptureSourceInterface
    public final void resume() {
        a();
        if (this.j) {
            this.j = false;
            IVideoReporter iVideoReporter = this.b;
            h.b bVar = h.b.EVT_VIDEO_CAPTURE_VIRTUAL_CAMERA_SIZE_CHANGE_SUCCESS;
            iVideoReporter.notifyEvent(bVar, "Start virtual camera success params:" + this.h, new Object[0]);
        }
    }

    @Override // com.tencent.liteav.videoproducer.capture.CaptureSourceInterface
    public final void updateParams(CaptureSourceInterface.CaptureParams captureParams) {
        this.h = new VirtualCameraParams((VirtualCameraParams) captureParams);
        if (this.i) {
            this.j = true;
            return;
        }
        e();
        a();
        IVideoReporter iVideoReporter = this.b;
        h.b bVar = h.b.EVT_VIDEO_CAPTURE_VIRTUAL_CAMERA_SIZE_CHANGE_SUCCESS;
        iVideoReporter.notifyEvent(bVar, "Start virtual camera success params:" + this.h, new Object[0]);
    }
}
