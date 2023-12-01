package com.tencent.liteav.videoproducer.capture.b;

import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.MeteringRectangle;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Range;
import android.util.Size;
import android.view.Surface;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.h;
import com.tencent.liteav.base.util.j;
import com.tencent.liteav.base.util.n;
import com.tencent.liteav.base.util.q;
import com.tencent.liteav.videobase.utils.Rotation;
import com.tencent.liteav.videoproducer.capture.ad;
import com.tencent.liteav.videoproducer.capture.ae;
import com.tencent.liteav.videoproducer.capture.af;
import com.tencent.liteav.videoproducer.producer.ServerVideoProducerConfig;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/capture/b/a.class */
public final class a implements ad {

    /* renamed from: c  reason: collision with root package name */
    private static boolean f36893c;
    private final j g;
    private CaptureRequest l;
    private CaptureRequest.Builder m;
    private n n;
    private SurfaceTexture p;
    private CountDownLatch w;
    private CountDownLatch x;
    private ae y;
    private static final HashMap<String, CameraCharacteristics> b = new HashMap<>();
    private static String d = "";
    private static String e = "";
    private final Handler f = new Handler(Looper.getMainLooper());
    private final AtomicBoolean h = new AtomicBoolean(false);
    private final AtomicReference<CameraDevice> i = new AtomicReference<>();
    private final AtomicBoolean j = new AtomicBoolean(false);
    private final AtomicReference<CameraCaptureSession> k = new AtomicReference<>();
    private Rotation o = Rotation.NORMAL;
    private boolean q = true;
    private boolean r = true;
    private boolean s = true;
    private int t = -1;
    private EnumC0940a u = EnumC0940a.IDLE;
    private boolean v = false;

    /* renamed from: a  reason: collision with root package name */
    public boolean f36894a = false;
    private float z = 0.0f;
    private final CameraDevice.StateCallback A = new CameraDevice.StateCallback() { // from class: com.tencent.liteav.videoproducer.capture.b.a.1
        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public final void onClosed(CameraDevice cameraDevice) {
            LiteavLog.i("Camera2Controller", "CameraDevice onClosed");
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public final void onDisconnected(CameraDevice cameraDevice) {
            LiteavLog.e("Camera2Controller", "CameraDevice onDisconnected!");
            a.this.a(false, cameraDevice);
            a.b(a.this);
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public final void onError(CameraDevice cameraDevice, int i) {
            LiteavLog.e("Camera2Controller", "CameraDevice onError, error:".concat(String.valueOf(i)));
            a.this.a(false, cameraDevice);
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public final void onOpened(CameraDevice cameraDevice) {
            LiteavLog.i("Camera2Controller", "CameraDevice onOpen!");
            a.this.a(true, cameraDevice);
        }
    };
    private final CameraCaptureSession.StateCallback B = new CameraCaptureSession.StateCallback() { // from class: com.tencent.liteav.videoproducer.capture.b.a.2
        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public final void onConfigureFailed(CameraCaptureSession cameraCaptureSession) {
            LiteavLog.e("Camera2Controller", "CameraCaptureSession onConfigureFailed!");
            a.this.a(false, cameraCaptureSession);
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public final void onConfigured(CameraCaptureSession cameraCaptureSession) {
            LiteavLog.i("Camera2Controller", "CameraCaptureSession onConfigured!");
            a.this.a(true, cameraCaptureSession);
        }
    };
    private final CameraManager.AvailabilityCallback C = new CameraManager.AvailabilityCallback() { // from class: com.tencent.liteav.videoproducer.capture.b.a.3
        public final void onCameraAccessPrioritiesChanged() {
            super.onCameraAccessPrioritiesChanged();
        }

        @Override // android.hardware.camera2.CameraManager.AvailabilityCallback
        public final void onCameraAvailable(String str) {
            super.onCameraAvailable(str);
            LiteavLog.i("Camera2Controller", "onCameraAvailable: ".concat(String.valueOf(str)));
            if (!a.this.o() && a.d(a.this.q).equals(str) && a.this.h.get()) {
                LiteavLog.w("Camera2Controller", "Current camera is available, it could be interrupted by system app.");
                a aVar = a.this;
                aVar.a(false, (CameraDevice) aVar.i.get());
                a.b(a.this);
            }
        }

        @Override // android.hardware.camera2.CameraManager.AvailabilityCallback
        public final void onCameraUnavailable(String str) {
            super.onCameraUnavailable(str);
            LiteavLog.i("Camera2Controller", "onCameraUnavailable: ".concat(String.valueOf(str)));
        }
    };
    private final CameraCaptureSession.CaptureCallback D = new AnonymousClass4();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.liteav.videoproducer.capture.b.a$4  reason: invalid class name */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/capture/b/a$4.class */
    public final class AnonymousClass4 extends CameraCaptureSession.CaptureCallback {
        AnonymousClass4() {
        }

        private void a(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, boolean z) {
            if (a.this.o()) {
                return;
            }
            a.g(a.this);
            try {
                a.this.m.set(CaptureRequest.CONTROL_AF_TRIGGER, 0);
                a.this.m.set(CaptureRequest.CONTROL_AF_MODE, 3);
                cameraCaptureSession.setRepeatingRequest(captureRequest, null, null);
                if (captureRequest.getTag() instanceof a) {
                    a.a((a) captureRequest.getTag(), z);
                }
            } catch (Exception e) {
                LiteavLog.e("Camera2Controller", "mAfCaptureCallback exception:".concat(String.valueOf(e)));
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ void a(AnonymousClass4 anonymousClass4, CaptureRequest captureRequest, CameraCaptureSession cameraCaptureSession) {
            if (a(captureRequest)) {
                anonymousClass4.a(cameraCaptureSession, captureRequest, false);
            } else {
                a.g(a.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ void a(AnonymousClass4 anonymousClass4, TotalCaptureResult totalCaptureResult, CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest) {
            if (!a(captureRequest)) {
                a.g(a.this);
                return;
            }
            Integer num = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AF_STATE);
            if (num == null) {
                LiteavLog.e("Camera2Controller", "handleCaptureCompleted get afState fail");
                anonymousClass4.a(cameraCaptureSession, captureRequest, false);
            } else if (4 == num.intValue() || 5 == num.intValue()) {
                anonymousClass4.a(cameraCaptureSession, captureRequest, true);
            }
        }

        private static boolean a(CaptureRequest captureRequest) {
            return (captureRequest.getTag() instanceof a) && !((a) captureRequest.getTag()).f36894a;
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public final void onCaptureCompleted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
            a.this.g.a(d.a(this, totalCaptureResult, cameraCaptureSession, captureRequest));
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public final void onCaptureFailed(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, CaptureFailure captureFailure) {
            LiteavLog.e("Camera2Controller", "onCaptureFailed failure reason:" + captureFailure.getReason());
            a.this.g.a(e.a(this, captureRequest, cameraCaptureSession));
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public final void onCaptureProgressed(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, CaptureResult captureResult) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.liteav.videoproducer.capture.b.a$a  reason: collision with other inner class name */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/capture/b/a$a.class */
    public enum EnumC0940a {
        IDLE,
        PREVIEWING
    }

    public a(j jVar) {
        this.g = jVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int a(int[] iArr, int[] iArr2) {
        return iArr[1] - iArr2[1];
    }

    private Range<Integer> a(int i) {
        int[] iArr;
        LiteavLog.i("Camera2Controller", "preferred fps: ".concat(String.valueOf(i)));
        Range<Integer> range = new Range<>(Integer.valueOf(i), Integer.valueOf(i));
        List<int[]> n = n();
        if (com.tencent.liteav.videobase.utils.c.a(n)) {
            return range;
        }
        Collections.sort(n, c.a());
        Iterator<int[]> it = n.iterator();
        while (true) {
            iArr = null;
            if (!it.hasNext()) {
                break;
            }
            iArr = it.next();
            if (iArr[0] <= i && i <= iArr[1]) {
                break;
            }
        }
        Range<Integer> range2 = range;
        if (iArr != null) {
            range2 = range;
            if (iArr.length >= 2) {
                range2 = new Range<>(Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1]));
            }
        }
        return range2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(a aVar) {
        if (aVar.o()) {
            LiteavLog.e("Camera2Controller", "onCameraError, but camera is invalid, do not send camera error.");
            return;
        }
        ae aeVar = aVar.y;
        if (aeVar != null) {
            aeVar.onCameraError(aVar);
        }
    }

    static /* synthetic */ void a(a aVar, boolean z) {
        LiteavLog.i("Camera2Controller", "onFocusCallback success:".concat(String.valueOf(z)));
        aVar.f36894a = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, CameraCaptureSession cameraCaptureSession) {
        CountDownLatch countDownLatch = this.x;
        this.j.set(z);
        this.k.set(cameraCaptureSession);
        if (countDownLatch != null) {
            countDownLatch.countDown();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, CameraDevice cameraDevice) {
        CountDownLatch countDownLatch = this.w;
        this.h.set(z);
        this.i.set(cameraDevice);
        if (countDownLatch != null) {
            countDownLatch.countDown();
        }
    }

    private boolean a(SurfaceTexture surfaceTexture) {
        CameraDevice cameraDevice;
        try {
            cameraDevice = this.i.get();
        } catch (Exception e2) {
            LiteavLog.e("Camera2Controller", "startPreview exception", e2);
            a(false, (CameraCaptureSession) null);
        }
        if (cameraDevice == null || surfaceTexture == null) {
            throw new IOException("startPreview cameraDevice null!");
        }
        j();
        this.p.setDefaultBufferSize(this.n.f36340a, this.n.b);
        Surface surface = new Surface(this.p);
        CaptureRequest.Builder createCaptureRequest = cameraDevice.createCaptureRequest(3);
        this.m = createCaptureRequest;
        createCaptureRequest.addTarget(surface);
        List<Surface> singletonList = Collections.singletonList(surface);
        this.x = new CountDownLatch(1);
        cameraDevice.createCaptureSession(singletonList, this.B, this.f);
        this.x.await();
        return this.j.get();
    }

    static /* synthetic */ void b(a aVar) {
        aVar.g.a(b.a(aVar));
    }

    private boolean b(int i, int i2) {
        String d2 = d(this.q);
        if (i() == null) {
            LiteavLog.e("Camera2Controller", "openCamera fail getCameraCharacteristics null");
            return false;
        }
        this.o = Rotation.a(((Integer) i().get(CameraCharacteristics.SENSOR_ORIENTATION)).intValue());
        this.n = af.a(m(), this.o, i, i2);
        StringBuilder sb = new StringBuilder("openCamera ");
        sb.append(this.q ? "front camera" : "back camera");
        sb.append(" mPreviewSize ");
        sb.append(this.n);
        sb.append(" mCameraRotation ");
        sb.append(this.o);
        sb.append(" mIsCameraSupportAutoFocus ");
        sb.append(this.s);
        LiteavLog.i("Camera2Controller", sb.toString());
        try {
            this.w = new CountDownLatch(1);
            ((CameraManager) ContextUtils.getApplicationContext().getSystemService("camera")).openCamera(d2, this.A, this.f);
            this.w.await();
        } catch (Exception e2) {
            LiteavLog.e("Camera2Controller", "openCamera exception:".concat(String.valueOf(e2)));
            a(false, (CameraDevice) null);
        }
        return this.h.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String d(boolean z) {
        return z ? !TextUtils.isEmpty(e) ? e : d : !TextUtils.isEmpty(d) ? d : e;
    }

    private void e(boolean z) {
        if (this.m == null) {
            return;
        }
        int i = z ? 1 : 3;
        this.m.set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(i));
        LiteavLog.i("Camera2Controller", "setFocusMode to ".concat(String.valueOf(i)));
    }

    static /* synthetic */ boolean g(a aVar) {
        aVar.v = false;
        return false;
    }

    private CameraCharacteristics i() {
        String d2 = d(this.q);
        if (TextUtils.isEmpty(d2)) {
            return null;
        }
        return b.get(d2);
    }

    private void j() {
        CameraCaptureSession andSet = this.k.getAndSet(null);
        if (andSet != null) {
            andSet.close();
        }
    }

    private void k() {
        CameraDevice andSet = this.i.getAndSet(null);
        if (andSet != null) {
            andSet.close();
        }
        ((CameraManager) ContextUtils.getApplicationContext().getSystemService("camera")).unregisterAvailabilityCallback(this.C);
    }

    private void l() {
        CaptureRequest.Builder builder;
        CameraCaptureSession cameraCaptureSession = this.k.get();
        if (cameraCaptureSession == null || (builder = this.m) == null) {
            return;
        }
        try {
            cameraCaptureSession.setRepeatingRequest(builder.build(), null, null);
        } catch (Exception e2) {
            LiteavLog.e("Camera2Controller", "updatePreview exception:".concat(String.valueOf(e2)));
        }
    }

    private List<n> m() {
        if (i() == null) {
            LiteavLog.e("Camera2Controller", "getPreviewSizes error, Characteristics is null");
            return null;
        }
        StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) i().get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
        if (streamConfigurationMap == null) {
            LiteavLog.e("Camera2Controller", "getPreviewSizes map null");
            return null;
        }
        Size[] outputSizes = streamConfigurationMap.getOutputSizes(SurfaceTexture.class);
        if (outputSizes == null) {
            LiteavLog.e("Camera2Controller", "getPreviewSizes choices is null");
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int length = outputSizes.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return arrayList;
            }
            Size size = outputSizes[i2];
            arrayList.add(new n(size.getWidth(), size.getHeight()));
            i = i2 + 1;
        }
    }

    private List<int[]> n() {
        if (i() == null) {
            LiteavLog.e("Camera2Controller", "getPreviewFps error, Characteristics: ", i());
            return null;
        }
        Range[] rangeArr = (Range[]) i().get(CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES);
        ArrayList arrayList = new ArrayList();
        if (rangeArr != null) {
            int length = rangeArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                Range range = rangeArr[i2];
                arrayList.add(new int[]{((Integer) range.getLower()).intValue(), ((Integer) range.getUpper()).intValue()});
                i = i2 + 1;
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean o() {
        return i() == null || this.m == null || this.u != EnumC0940a.PREVIEWING;
    }

    @Override // com.tencent.liteav.videoproducer.capture.ad
    public final void a() {
        CountDownLatch countDownLatch = this.w;
        if (countDownLatch != null) {
            countDownLatch.countDown();
        }
        this.w = null;
        CountDownLatch countDownLatch2 = this.x;
        if (countDownLatch2 != null) {
            countDownLatch2.countDown();
        }
        this.x = null;
        j();
        k();
        this.l = null;
        this.f36894a = false;
        this.p = null;
        this.t = -1;
        this.u = EnumC0940a.IDLE;
        LiteavLog.i("Camera2Controller", "stopCapture success");
    }

    @Override // com.tencent.liteav.videoproducer.capture.ad
    public final void a(float f) {
        this.z = f;
        CaptureRequest.Builder builder = this.m;
        if (builder == null) {
            LiteavLog.e("Camera2Controller", "setZoom fail, scale:" + f + " mPreviewBuilder is null.");
            return;
        }
        CaptureRequest.Key<Rect> key = CaptureRequest.SCALER_CROP_REGION;
        Rect rect = (Rect) i().get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
        float floatValue = ((Float) i().get(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM)).floatValue();
        float f2 = floatValue - 1.0f;
        float a2 = (h.a(f, 0.0f, 1.0f) * f2) + 1.0f;
        int width = (int) (rect.width() / floatValue);
        int height = (int) (rect.height() / floatValue);
        int width2 = rect.width();
        int height2 = rect.height();
        float f3 = width2 - width;
        float f4 = a2 - 1.0f;
        int i = (int) (((f3 * f4) / f2) / 2.0f);
        int i2 = (int) ((((height2 - height) * f4) / f2) / 2.0f);
        Rect rect2 = new Rect(i, i2, rect.width() - i, rect.height() - i2);
        LiteavLog.i("Camera2Controller", "calculateZoomRect calculatedZoomLevel:" + a2 + " rect:" + rect + " newRect2:" + rect2);
        builder.set(key, rect2);
        l();
    }

    @Override // com.tencent.liteav.videoproducer.capture.ad
    public final void a(int i, int i2) {
        double d2;
        double d3;
        double d4;
        double d5;
        double d6;
        double d7;
        double d8;
        if (this.r && this.s) {
            if (o() || this.v) {
                LiteavLog.e("Camera2Controller", "autoFocus not preview, mCameraStatus:" + this.u + " mIsAutoFocusing:" + this.v);
                return;
            }
            CameraCaptureSession cameraCaptureSession = this.k.get();
            if (cameraCaptureSession == null) {
                LiteavLog.e("Camera2Controller", "CameraCaptureSession get fail");
            } else if (i < 0 || i >= this.n.f36340a || i2 < 0 || i2 >= this.n.b) {
                LiteavLog.w("Camera2Controller", "Start auto focus at (%d, %d) invalid ", Integer.valueOf(i), Integer.valueOf(i2));
            } else {
                LiteavLog.i("Camera2Controller", "Start auto focus at (%d, %d)", Integer.valueOf(i), Integer.valueOf(i2));
                double d9 = i;
                double d10 = i2;
                int i3 = this.n.f36340a;
                int i4 = this.n.b;
                if (this.o == Rotation.ROTATION_90 || this.o == Rotation.ROTATION_270) {
                    i3 = this.n.b;
                    i4 = this.n.f36340a;
                }
                n a2 = q.a(ContextUtils.getApplicationContext());
                double d11 = 0.0d;
                if (a2.f36340a * i4 > a2.b * i3) {
                    d2 = (a2.f36340a * 1.0d) / i3;
                    d4 = (i4 - (a2.b / d2)) / 2.0d;
                    d3 = 0.0d;
                } else {
                    d2 = (a2.b * 1.0d) / i4;
                    d3 = (i3 - (a2.f36340a / d2)) / 2.0d;
                    d4 = 0.0d;
                }
                double d12 = (d9 / d2) + d3;
                double d13 = (d10 / d2) + d4;
                if (this.o == Rotation.ROTATION_90) {
                    d5 = d13;
                    d6 = this.n.b - d12;
                } else {
                    d5 = d12;
                    d6 = d13;
                    if (this.o == Rotation.ROTATION_270) {
                        d6 = d12;
                        d5 = this.n.f36340a - d13;
                    }
                }
                Rect rect = (Rect) this.l.get(CaptureRequest.SCALER_CROP_REGION);
                Rect rect2 = rect;
                if (rect == null) {
                    LiteavLog.e("Camera2Controller", "getMeteringRect can't get crop region");
                    rect2 = (Rect) i().get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
                }
                int width = rect2.width();
                int height = rect2.height();
                if (this.n.b * width > this.n.f36340a * height) {
                    d7 = (height * 1.0d) / this.n.b;
                    d11 = (width - (this.n.f36340a * d7)) / 2.0d;
                    d8 = 0.0d;
                } else {
                    d7 = (width * 1.0d) / this.n.f36340a;
                    d8 = (height - (this.n.b * d7)) / 2.0d;
                }
                double d14 = (d5 * d7) + d11 + rect2.left;
                double d15 = (d6 * d7) + d8 + rect2.top;
                Rect rect3 = new Rect();
                rect3.left = h.a((int) (d14 - (rect2.width() * 0.05d)), 0, rect2.width());
                rect3.right = h.a((int) (d14 + (rect2.width() * 0.05d)), 0, rect2.width());
                rect3.top = h.a((int) (d15 - (rect2.height() * 0.05d)), 0, rect2.height());
                rect3.bottom = h.a((int) (d15 + (rect2.height() * 0.05d)), 0, rect2.height());
                try {
                    this.m.set(CaptureRequest.CONTROL_AF_REGIONS, new MeteringRectangle[]{new MeteringRectangle(rect3, 1000)});
                    this.m.set(CaptureRequest.CONTROL_AE_REGIONS, new MeteringRectangle[]{new MeteringRectangle(rect3, 1000)});
                    this.m.set(CaptureRequest.CONTROL_AF_MODE, 1);
                    this.m.set(CaptureRequest.CONTROL_AF_TRIGGER, 1);
                    this.m.set(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, 1);
                    this.v = true;
                    this.f36894a = false;
                    this.m.setTag(this);
                    cameraCaptureSession.setRepeatingRequest(this.m.build(), this.D, this.f);
                } catch (Exception e2) {
                    LiteavLog.e("Camera2Controller", "startAutoFocusAtPosition exception:".concat(String.valueOf(e2)));
                }
            }
        }
    }

    @Override // com.tencent.liteav.videoproducer.capture.ad
    public final void a(ServerVideoProducerConfig serverVideoProducerConfig) {
    }

    @Override // com.tencent.liteav.videoproducer.capture.ad
    public final void a(boolean z) {
        if (o()) {
            LiteavLog.e("Camera2Controller", "turnOnTorch error mCameraStatus:" + this.u);
            return;
        }
        boolean z2 = true;
        if (z && this.t != 2) {
            this.t = 2;
        } else if (z) {
            z2 = false;
        } else {
            this.t = 0;
        }
        LiteavLog.i("Camera2Controller", "turnOnTorch:" + z + ", mode:" + this.t + ", updateView:" + z2);
        if (z2) {
            this.m.set(CaptureRequest.FLASH_MODE, Integer.valueOf(this.t));
            l();
        }
    }

    @Override // com.tencent.liteav.videoproducer.capture.ad
    public final boolean a(int i, int i2, boolean z) {
        n a2 = af.a(m(), this.o, i, i2);
        boolean z2 = a2.b() <= this.n.b();
        if (z && Math.abs(a2.c() - this.n.c()) > 0.001d) {
            z2 = false;
        }
        LiteavLog.i("Camera2Controller", "isCurrentPreviewSizeAspectRatioMatch:".concat(String.valueOf(z2)));
        return z2;
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01c9  */
    @Override // com.tencent.liteav.videoproducer.capture.ad
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean a(com.tencent.liteav.videoproducer.capture.CameraCaptureParams r5, android.graphics.SurfaceTexture r6, com.tencent.liteav.videoproducer.capture.ae r7) {
        /*
            Method dump skipped, instructions count: 587
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.videoproducer.capture.b.a.a(com.tencent.liteav.videoproducer.capture.CameraCaptureParams, android.graphics.SurfaceTexture, com.tencent.liteav.videoproducer.capture.ae):boolean");
    }

    @Override // com.tencent.liteav.videoproducer.capture.ad
    public final Rotation b() {
        return this.o;
    }

    @Override // com.tencent.liteav.videoproducer.capture.ad
    public final void b(float f) {
        if (o()) {
            LiteavLog.e("Camera2Controller", "setExposureCompensation fail, value:" + f + " mCameraStatus:" + this.u);
            return;
        }
        Range range = (Range) i().get(CameraCharacteristics.CONTROL_AE_COMPENSATION_RANGE);
        int intValue = ((Integer) range.getLower()).intValue();
        int intValue2 = ((Integer) range.getUpper()).intValue();
        if (intValue == 0 && intValue2 == 0) {
            LiteavLog.i("Camera2Controller", "camera doesn't support exposure compensation");
            return;
        }
        this.m.set(CaptureRequest.CONTROL_AE_EXPOSURE_COMPENSATION, Integer.valueOf(h.a(((int) (((intValue2 - intValue) * (h.a(f, -1.0f, 1.0f) + 1.0f)) / 2.0f)) + intValue, intValue, intValue2)));
        l();
    }

    @Override // com.tencent.liteav.videoproducer.capture.ad
    public final void b(boolean z) {
        this.r = z;
        e(z);
    }

    @Override // com.tencent.liteav.videoproducer.capture.ad
    public final int c() {
        return 100;
    }

    @Override // com.tencent.liteav.videoproducer.capture.ad
    public final n d() {
        return this.n;
    }

    @Override // com.tencent.liteav.videoproducer.capture.ad
    public final boolean e() {
        return i() != null && ((Float) i().get(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM)).floatValue() > 0.0f;
    }

    @Override // com.tencent.liteav.videoproducer.capture.ad
    public final boolean f() {
        return i() != null && ((Boolean) i().get(CameraCharacteristics.FLASH_INFO_AVAILABLE)).booleanValue();
    }

    @Override // com.tencent.liteav.videoproducer.capture.ad
    public final boolean g() {
        return i() != null && ((Integer) i().get(CameraCharacteristics.STATISTICS_INFO_MAX_FACE_COUNT)).intValue() > 0;
    }

    @Override // com.tencent.liteav.videoproducer.capture.ad
    public final boolean h() {
        return i() != null && ((Integer) i().get(CameraCharacteristics.CONTROL_MAX_REGIONS_AF)).intValue() > 0;
    }
}
