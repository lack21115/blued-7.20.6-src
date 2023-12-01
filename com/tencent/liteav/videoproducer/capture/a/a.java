package com.tencent.liteav.videoproducer.capture.a;

import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.h;
import com.tencent.liteav.base.util.n;
import com.tencent.liteav.videobase.utils.Rotation;
import com.tencent.liteav.videoproducer.capture.ad;
import com.tencent.liteav.videoproducer.capture.ae;
import com.tencent.liteav.videoproducer.capture.af;
import com.tencent.liteav.videoproducer.producer.ServerVideoProducerConfig;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/capture/a/a.class */
public final class a implements Camera.ErrorCallback, ad {
    private Camera b;
    private SurfaceTexture d;
    private n e;
    private boolean f;
    private boolean g;
    private ae j;
    private float l;

    /* renamed from: a  reason: collision with root package name */
    private boolean f23161a = true;

    /* renamed from: c  reason: collision with root package name */
    private Rotation f23162c = Rotation.NORMAL;
    private boolean h = true;
    private int i = 0;
    private boolean k = false;
    private boolean m = false;
    private float n = 0.0f;
    private ServerVideoProducerConfig o = null;
    private final Camera.AutoFocusCallback p = b.a();

    private int a(int i) {
        Camera.Parameters i2 = i();
        if (i2 == null) {
            return 1;
        }
        List<Integer> supportedPreviewFrameRates = i2.getSupportedPreviewFrameRates();
        if (supportedPreviewFrameRates == null || supportedPreviewFrameRates.isEmpty()) {
            LiteavLog.e("CameraController", "supported preview frame rates is empty");
            return 1;
        }
        int intValue = supportedPreviewFrameRates.get(0).intValue();
        for (Integer num : supportedPreviewFrameRates) {
            int intValue2 = num.intValue();
            if (Math.abs(i - intValue2) < Math.abs(i - intValue)) {
                intValue = intValue2;
            }
        }
        LiteavLog.i("CameraController", "best matched frame rate: %d", Integer.valueOf(intValue));
        return intValue;
    }

    private static int a(Camera.Parameters parameters, float f) {
        int minExposureCompensation = parameters.getMinExposureCompensation();
        int maxExposureCompensation = parameters.getMaxExposureCompensation();
        if (minExposureCompensation == 0 && maxExposureCompensation == 0) {
            LiteavLog.i("CameraController", "camera doesn't support exposure compensation");
            return minExposureCompensation;
        }
        com.tencent.liteav.base.a.a.a();
        return h.a((int) (h.a(f, -1.0f, 1.0f) * maxExposureCompensation), minExposureCompensation, maxExposureCompensation);
    }

    private static int a(boolean z, Camera.CameraInfo cameraInfo) {
        int i;
        int i2;
        int i3;
        int i4 = 0;
        int i5 = -1;
        int i6 = -1;
        while (true) {
            i = i6;
            if (i4 >= Camera.getNumberOfCameras()) {
                break;
            }
            Camera.getCameraInfo(i4, cameraInfo);
            LiteavLog.i("CameraController", "get camera info, index: " + i4 + ", facing: " + cameraInfo.facing);
            if (i5 == -1 && cameraInfo.facing == 1) {
                i2 = i4;
                i3 = i;
            } else {
                i2 = i5;
                i3 = i;
                if (i == -1) {
                    i2 = i5;
                    i3 = i;
                    if (cameraInfo.facing == 0) {
                        i3 = i4;
                        i2 = i5;
                    }
                }
            }
            i4++;
            i5 = i2;
            i6 = i3;
        }
        if (!z ? i != -1 : i5 == -1) {
            i5 = i;
        }
        Camera.getCameraInfo(i5, cameraInfo);
        return i5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int a(int[] iArr, int[] iArr2) {
        return iArr[1] - iArr2[1];
    }

    private Rect a(float f, float f2, float f3) {
        int i = (int) (f3 * 200.0f);
        int i2 = (int) (((f / this.e.f22649a) * 2000.0f) - 1000.0f);
        int i3 = (int) (((f2 / this.e.b) * 2000.0f) - 1000.0f);
        int i4 = i / 2;
        int a2 = h.a(i2 - i4, -1000, 1000);
        int a3 = h.a(a2 + i, -1000, 1000);
        int a4 = h.a(i3 - i4, -1000, 1000);
        return new Rect(a2, a4, a3, h.a(i + a4, -1000, 1000));
    }

    private static n a(Camera.Parameters parameters, Rotation rotation, int i, int i2) {
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        ArrayList arrayList = new ArrayList();
        if (supportedPreviewSizes != null) {
            for (Camera.Size size : supportedPreviewSizes) {
                arrayList.add(new n(size.width, size.height));
            }
        }
        return af.a(arrayList, rotation, i, i2);
    }

    private static void a(Camera.Parameters parameters, boolean z) {
        List<String> supportedFocusModes = parameters.getSupportedFocusModes();
        if (supportedFocusModes == null) {
            return;
        }
        if (z && supportedFocusModes.contains("auto")) {
            parameters.setFocusMode("auto");
            LiteavLog.i("CameraController", "set focus mode to auto");
        } else if (supportedFocusModes.contains("continuous-video")) {
            parameters.setFocusMode("continuous-video");
            LiteavLog.i("CameraController", "set focus mode to continuous-video");
        }
    }

    private static int[] a(Camera.Parameters parameters, int i) {
        int[] iArr;
        int i2 = i * 1000;
        LiteavLog.i("CameraController", "preferred fps: ".concat(String.valueOf(i2)));
        List<int[]> supportedPreviewFpsRange = parameters.getSupportedPreviewFpsRange();
        int[] iArr2 = null;
        if (supportedPreviewFpsRange != null) {
            if (supportedPreviewFpsRange.size() <= 0) {
                return null;
            }
            Collections.sort(supportedPreviewFpsRange, c.a());
            Iterator<int[]> it = supportedPreviewFpsRange.iterator();
            while (true) {
                iArr = null;
                if (!it.hasNext()) {
                    break;
                }
                iArr = it.next();
                LiteavLog.i("CameraController", "supported fps range: " + iArr[0] + "->" + iArr[1]);
                if (iArr[0] <= i2 && i2 <= iArr[1]) {
                    break;
                }
            }
            iArr2 = iArr;
            if (iArr != null) {
                LiteavLog.i("CameraController", "choosed fps range: " + iArr[0] + "->" + iArr[1]);
                iArr2 = iArr;
            }
        }
        return iArr2;
    }

    private Camera.Parameters i() {
        try {
            if (this.b != null) {
                return this.b.getParameters();
            }
            return null;
        } catch (Exception e) {
            LiteavLog.e("CameraController", "getCameraParameters failed.", e);
            return null;
        }
    }

    @Override // com.tencent.liteav.videoproducer.capture.ad
    public final void a() {
        Camera camera = this.b;
        if (camera != null) {
            camera.setErrorCallback(null);
            this.b.stopPreview();
            this.b.release();
            this.b = null;
        }
        this.d = null;
    }

    @Override // com.tencent.liteav.videoproducer.capture.ad
    public final void a(float f) {
        this.n = f;
        this.m = true;
        if (this.b == null) {
            return;
        }
        this.m = false;
        Camera.Parameters i = i();
        if (i == null) {
            return;
        }
        if (i.getMaxZoom() <= 0 || !i.isZoomSupported()) {
            LiteavLog.i("CameraController", "camera doesn't support zoom!");
            return;
        }
        int maxZoom = i.getMaxZoom();
        try {
            i.setZoom(h.a(Math.round(f * maxZoom), 0, maxZoom));
            this.b.setParameters(i);
        } catch (Exception e) {
            LiteavLog.e("CameraController", "set zoom failed.", e);
        }
    }

    @Override // com.tencent.liteav.videoproducer.capture.ad
    public final void a(int i, int i2) {
        if (this.h) {
            if (i < 0 || i >= this.e.f22649a || i2 < 0 || i2 >= this.e.b) {
                LiteavLog.w("CameraController", "Start auto focus at (%d, %d) invalid ", Integer.valueOf(i), Integer.valueOf(i2));
                return;
            }
            LiteavLog.i("CameraController", "Start auto focus at (%d, %d)", Integer.valueOf(i), Integer.valueOf(i2));
            try {
                this.b.cancelAutoFocus();
                Camera.Parameters i3 = i();
                if (i3 == null) {
                    return;
                }
                if (this.f) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new Camera.Area(a(i, i2, 2.0f), 1000));
                    i3.setFocusAreas(arrayList);
                }
                if (this.g) {
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(new Camera.Area(a(i, i2, 3.0f), 1000));
                    i3.setMeteringAreas(arrayList2);
                }
                try {
                    this.b.setParameters(i3);
                    this.b.autoFocus(this.p);
                } catch (Exception e) {
                    LiteavLog.e("CameraController", "auto focus failed.", e);
                }
            } catch (Exception e2) {
                LiteavLog.e("CameraController", "cancel auto focus failed.", e2);
            }
        }
    }

    @Override // com.tencent.liteav.videoproducer.capture.ad
    public final void a(ServerVideoProducerConfig serverVideoProducerConfig) {
        this.o = serverVideoProducerConfig;
    }

    @Override // com.tencent.liteav.videoproducer.capture.ad
    public final void a(boolean z) {
        List<String> supportedFlashModes;
        if (this.b == null) {
            return;
        }
        String str = z ? "torch" : "off";
        Camera.Parameters i = i();
        if (i == null || (supportedFlashModes = i.getSupportedFlashModes()) == null || !supportedFlashModes.contains(str)) {
            return;
        }
        try {
            i.setFlashMode(str);
            this.b.setParameters(i);
        } catch (Exception e) {
            LiteavLog.e("CameraController", "enable torch failed.", e);
        }
    }

    @Override // com.tencent.liteav.videoproducer.capture.ad
    public final boolean a(int i, int i2, boolean z) {
        boolean z2;
        boolean z3 = true;
        if (this.b != null) {
            Camera.Parameters i3 = i();
            if (i3 == null) {
                return true;
            }
            n a2 = a(i3, this.f23162c, i, i2);
            if (a2 != null) {
                if (a2.f22649a * a2.b > this.e.b * this.e.f22649a) {
                    z3 = false;
                }
                z2 = (!z || Math.abs(a2.c() - this.e.c()) <= 0.001d) ? z3 : false;
                LiteavLog.i("CameraController", "isCurrentPreviewSizeAspectRatioMatch : ".concat(String.valueOf(z2)));
                return z2;
            }
        }
        z2 = true;
        LiteavLog.i("CameraController", "isCurrentPreviewSizeAspectRatioMatch : ".concat(String.valueOf(z2)));
        return z2;
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x01ba A[Catch: Exception -> 0x0210, TRY_LEAVE, TryCatch #0 {Exception -> 0x0210, blocks: (B:6:0x000d, B:8:0x0014, B:10:0x001e, B:12:0x0053, B:14:0x0064, B:17:0x0086, B:21:0x00c5, B:25:0x00d8, B:27:0x00ed, B:29:0x0103, B:31:0x010a, B:33:0x0124, B:35:0x012a, B:37:0x013c, B:39:0x016f, B:43:0x01a6, B:45:0x01b3, B:47:0x01ba, B:50:0x01e2, B:48:0x01d3, B:40:0x0188, B:42:0x0197, B:15:0x0079, B:52:0x0205, B:53:0x020f), top: B:59:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x01d3 A[Catch: Exception -> 0x0210, TRY_ENTER, TryCatch #0 {Exception -> 0x0210, blocks: (B:6:0x000d, B:8:0x0014, B:10:0x001e, B:12:0x0053, B:14:0x0064, B:17:0x0086, B:21:0x00c5, B:25:0x00d8, B:27:0x00ed, B:29:0x0103, B:31:0x010a, B:33:0x0124, B:35:0x012a, B:37:0x013c, B:39:0x016f, B:43:0x01a6, B:45:0x01b3, B:47:0x01ba, B:50:0x01e2, B:48:0x01d3, B:40:0x0188, B:42:0x0197, B:15:0x0079, B:52:0x0205, B:53:0x020f), top: B:59:0x0006 }] */
    @Override // com.tencent.liteav.videoproducer.capture.ad
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean a(com.tencent.liteav.videoproducer.capture.CameraCaptureParams r8, android.graphics.SurfaceTexture r9, com.tencent.liteav.videoproducer.capture.ae r10) {
        /*
            Method dump skipped, instructions count: 558
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.videoproducer.capture.a.a.a(com.tencent.liteav.videoproducer.capture.CameraCaptureParams, android.graphics.SurfaceTexture, com.tencent.liteav.videoproducer.capture.ae):boolean");
    }

    @Override // com.tencent.liteav.videoproducer.capture.ad
    public final Rotation b() {
        return this.f23162c;
    }

    @Override // com.tencent.liteav.videoproducer.capture.ad
    public final void b(float f) {
        this.l = f;
        this.k = true;
        if (this.b == null) {
            return;
        }
        this.k = false;
        Camera.Parameters i = i();
        if (i == null) {
            return;
        }
        i.setExposureCompensation(a(i, f));
        try {
            this.b.setParameters(i);
        } catch (Exception e) {
            LiteavLog.e("CameraController", "set exposure compensation failed.", e);
        }
    }

    @Override // com.tencent.liteav.videoproducer.capture.ad
    public final void b(boolean z) {
        Camera.Parameters i;
        this.h = z;
        if (this.b == null || (i = i()) == null) {
            return;
        }
        a(i, z);
    }

    @Override // com.tencent.liteav.videoproducer.capture.ad
    public final int c() {
        int i = this.i;
        if (i != 0) {
            return i;
        }
        if (this.b != null) {
            Camera.Parameters i2 = i();
            if (i2 == null) {
                return this.i;
            }
            if (i2.getMaxZoom() > 0 && i2.isZoomSupported()) {
                this.i = i2.getMaxZoom();
            }
        }
        return this.i;
    }

    @Override // com.tencent.liteav.videoproducer.capture.ad
    public final n d() {
        return this.e;
    }

    @Override // com.tencent.liteav.videoproducer.capture.ad
    public final boolean e() {
        Camera.Parameters i;
        return this.b != null && (i = i()) != null && i.getMaxZoom() > 0 && i.isZoomSupported();
    }

    @Override // com.tencent.liteav.videoproducer.capture.ad
    public final boolean f() {
        Camera.Parameters i;
        List<String> supportedFlashModes;
        return (this.b == null || (i = i()) == null || (supportedFlashModes = i.getSupportedFlashModes()) == null || !supportedFlashModes.contains("torch")) ? false : true;
    }

    @Override // com.tencent.liteav.videoproducer.capture.ad
    public final boolean g() {
        Camera.Parameters i;
        return (this.b == null || (i = i()) == null || i.getMaxNumDetectedFaces() <= 0) ? false : true;
    }

    @Override // com.tencent.liteav.videoproducer.capture.ad
    public final boolean h() {
        return this.f;
    }

    @Override // android.hardware.Camera.ErrorCallback
    public final void onError(int i, Camera camera) {
        ae aeVar;
        if ((i == 1 || i == 2 || i == 100) && (aeVar = this.j) != null) {
            aeVar.onCameraError(this);
        }
    }
}
