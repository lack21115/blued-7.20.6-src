package com.qiniu.pili.droid.shortvideo.a.a;

import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.Build;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/a/a/a.class */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private Camera f27508a;

    /* renamed from: c  reason: collision with root package name */
    private int f27509c = 0;
    private boolean d = false;
    private Camera.CameraInfo b = new Camera.CameraInfo();

    /* renamed from: com.qiniu.pili.droid.shortvideo.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/a/a/a$a.class */
    static class C0741a {

        /* renamed from: a  reason: collision with root package name */
        public static final a f27510a = new a();
    }

    public static a a() {
        return C0741a.f27510a;
    }

    private static boolean a(int i, Camera.CameraInfo cameraInfo) {
        try {
            Camera.getCameraInfo(i, cameraInfo);
            return true;
        } catch (Exception e) {
            com.qiniu.pili.droid.shortvideo.f.e.f.d(e.getMessage());
            return false;
        }
    }

    public static int b() {
        return Camera.getNumberOfCameras();
    }

    private void b(Camera.Parameters parameters) {
        if (parameters == null) {
            com.qiniu.pili.droid.shortvideo.f.e.f.d("CameraDevice", "initializeCapabilities params is null");
        } else {
            this.d = parameters.getSupportedFocusModes().contains("continuous-picture");
        }
    }

    public static boolean e(int i) {
        if (Build.VERSION.SDK_INT < 9) {
            return false;
        }
        int numberOfCameras = Camera.getNumberOfCameras();
        if (numberOfCameras > 2 && i == 2) {
            return true;
        }
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= numberOfCameras) {
                return false;
            }
            if (a(i3, cameraInfo) && i == cameraInfo.facing) {
                return true;
            }
            i2 = i3 + 1;
        }
    }

    private int f(int i) {
        int numberOfCameras = Camera.getNumberOfCameras();
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= numberOfCameras) {
                return -1;
            }
            if (a(i3, cameraInfo) && cameraInfo.facing == i) {
                return i3;
            }
            i2 = i3 + 1;
        }
    }

    public void a(SurfaceTexture surfaceTexture) {
        synchronized (this) {
            if (this.f27508a == null) {
                com.qiniu.pili.droid.shortvideo.f.e.f.d("CameraDevice", "setPreviewTexture failed, camera == null");
                return;
            }
            if (Build.VERSION.SDK_INT >= 11) {
                try {
                    this.f27508a.setPreviewTexture(surfaceTexture);
                } catch (Exception e) {
                    e.printStackTrace();
                    com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.f;
                    eVar.d("CameraDevice", "setPreviewTexture failed " + e.getMessage());
                }
            }
        }
    }

    public void a(Camera.AutoFocusCallback autoFocusCallback) {
        synchronized (this) {
            if (this.f27508a == null) {
                com.qiniu.pili.droid.shortvideo.f.e.f.d("CameraDevice", "autoFocus failed, camera == null");
                return;
            }
            try {
                this.f27508a.autoFocus(autoFocusCallback);
            } catch (RuntimeException e) {
                e.printStackTrace();
                com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.f;
                eVar.e("CameraDevice", "autoFocus failed: " + e.getMessage());
            }
        }
    }

    public void a(Camera.AutoFocusMoveCallback autoFocusMoveCallback) {
        synchronized (this) {
            if (this.f27508a == null) {
                com.qiniu.pili.droid.shortvideo.f.e.f.d("CameraDevice", "setAutoFocusMoveCallback failed, camera == null");
                return;
            }
            try {
                this.f27508a.setAutoFocusMoveCallback(autoFocusMoveCallback);
            } catch (RuntimeException e) {
                e.printStackTrace();
                com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.f;
                eVar.e("CameraDevice", "setAutoFocusMoveCallback failed: " + e.getMessage());
            }
        }
    }

    public void a(Camera.Parameters parameters) {
        synchronized (this) {
            if (this.f27508a == null) {
                com.qiniu.pili.droid.shortvideo.f.e.f.d("CameraDevice", "setParameters failed, camera == null");
                return;
            }
            try {
                this.f27508a.setParameters(parameters);
            } catch (RuntimeException e) {
                e.printStackTrace();
                com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.f;
                eVar.e("CameraDevice", "setParameters failed: " + e.getMessage());
            }
        }
    }

    public void a(Camera.PreviewCallback previewCallback) {
        synchronized (this) {
            if (this.f27508a == null) {
                com.qiniu.pili.droid.shortvideo.f.e.f.d("CameraDevice", "setPreviewCallbackWithBuffer failed, camera == null");
                return;
            }
            try {
                this.f27508a.setPreviewCallbackWithBuffer(previewCallback);
            } catch (RuntimeException e) {
                e.printStackTrace();
                com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.f;
                eVar.e("CameraDevice", "setPreviewCallbackWithBuffer failed: " + e.getMessage());
            }
        }
    }

    public void a(byte[] bArr) {
        synchronized (this) {
            if (this.f27508a == null) {
                com.qiniu.pili.droid.shortvideo.f.e.f.d("CameraDevice", "addCallbackBuffer failed, camera == null");
            } else {
                this.f27508a.addCallbackBuffer(bArr);
            }
        }
    }

    public boolean a(int i) {
        boolean z;
        synchronized (this) {
            int f = f(i);
            if (f == -1) {
                com.qiniu.pili.droid.shortvideo.f.e.f.e("CameraDevice", "can not find the camera by faceID : " + i);
                return false;
            }
            try {
                f();
                Camera open = Camera.open(f);
                this.f27508a = open;
                z = false;
                if (open != null) {
                    z = false;
                    if (open.getParameters() != null) {
                        z = true;
                    }
                }
            } catch (Exception e) {
                this.f27508a = null;
                com.qiniu.pili.droid.shortvideo.f.e.f.e("CameraDevice", "failed to open camera " + f + " faceID is " + i + " : " + e.getMessage());
                z = false;
            }
            if (z) {
                a(f, this.b);
                b(k());
                com.qiniu.pili.droid.shortvideo.f.e.f.c("CameraDevice", "open camera " + f + " success, faceID is " + i);
            }
            return z;
        }
    }

    public void b(int i) {
        synchronized (this) {
            if (this.f27508a == null) {
                com.qiniu.pili.droid.shortvideo.f.e.f.d("CameraDevice", "setDisplayOrientation failed, camera == null");
                return;
            }
            try {
                this.f27508a.setDisplayOrientation(i);
                this.f27509c = i;
                com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.f;
                eVar.c("CameraDevice", "setDisplayOrientation: " + i);
            } catch (RuntimeException e) {
                e.printStackTrace();
                com.qiniu.pili.droid.shortvideo.f.e eVar2 = com.qiniu.pili.droid.shortvideo.f.e.f;
                eVar2.e("CameraDevice", "setDisplayOrientation failed: " + e.getMessage());
            }
        }
    }

    public Camera.CameraInfo c() {
        return this.b;
    }

    public void c(int i) {
        synchronized (this) {
            if (this.f27508a == null) {
                com.qiniu.pili.droid.shortvideo.f.e.f.d("CameraDevice", "setExposureCompensation failed, camera == null");
                return;
            }
            try {
            } catch (RuntimeException e) {
                e.printStackTrace();
                com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.f;
                eVar.e("CameraDevice", "setExposureCompensation failed: " + e.getMessage());
            }
            if (!this.f27508a.getParameters().isAutoExposureLockSupported()) {
                com.qiniu.pili.droid.shortvideo.f.e.f.d("CameraDevice", "setExposureCompensation failed, AutoExposureLock is unsupported");
                return;
            }
            this.f27508a.getParameters().setAutoExposureLock(false);
            Camera.Parameters parameters = this.f27508a.getParameters();
            parameters.setExposureCompensation(i);
            this.f27508a.setParameters(parameters);
            com.qiniu.pili.droid.shortvideo.f.e eVar2 = com.qiniu.pili.droid.shortvideo.f.e.f;
            eVar2.c("CameraDevice", "setExposure:" + i + " Current exposure: " + this.f27508a.getParameters().getExposureCompensation());
        }
    }

    public void d(int i) {
        synchronized (this) {
            if (this.f27508a == null) {
                com.qiniu.pili.droid.shortvideo.f.e.f.d("CameraDevice", "setZoom failed, camera == null");
                return;
            }
            try {
                Camera.Parameters parameters = this.f27508a.getParameters();
                if (i < 0 || i > parameters.getMaxZoom()) {
                    com.qiniu.pili.droid.shortvideo.f.e.f.d("CameraDevice", "zoom index out of valid range.");
                } else {
                    com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.f;
                    eVar.c("CameraDevice", "set zoom:" + i + ", current zoom: " + parameters.getZoom());
                    parameters.setZoom(i);
                    this.f27508a.setParameters(parameters);
                }
            } catch (RuntimeException e) {
                e.printStackTrace();
                com.qiniu.pili.droid.shortvideo.f.e eVar2 = com.qiniu.pili.droid.shortvideo.f.e.f;
                eVar2.e("CameraDevice", "setZoom failed: " + e.getMessage());
            }
        }
    }

    public boolean d() {
        boolean z;
        synchronized (this) {
            z = this.f27508a != null;
        }
        return z;
    }

    public void e() {
        synchronized (this) {
            if (this.f27508a == null) {
                com.qiniu.pili.droid.shortvideo.f.e.f.d("CameraDevice", "cancelAutoFocus failed, camera == null");
                return;
            }
            try {
                this.f27508a.cancelAutoFocus();
            } catch (RuntimeException e) {
                e.printStackTrace();
                com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.f;
                eVar.e("CameraDevice", "cancelAutoFocus failed: " + e.getMessage());
            }
        }
    }

    public void f() {
        synchronized (this) {
            if (this.f27508a != null) {
                this.f27508a.release();
                this.f27508a = null;
                com.qiniu.pili.droid.shortvideo.f.e.f.c("CameraDevice", "release camera success");
            }
        }
    }

    public int g() {
        Camera.Parameters k = k();
        if (k == null) {
            return 0;
        }
        return k.getPreviewSize().width;
    }

    public int h() {
        Camera.Parameters k = k();
        if (k == null) {
            return 0;
        }
        return k.getPreviewSize().height;
    }

    public int i() {
        return this.f27509c;
    }

    public boolean j() {
        return this.b.facing == 1;
    }

    public Camera.Parameters k() {
        synchronized (this) {
            Camera.Parameters parameters = null;
            if (this.f27508a == null) {
                com.qiniu.pili.droid.shortvideo.f.e.f.d("CameraDevice", "getParameters failed, camera == null");
                return null;
            }
            try {
                parameters = this.f27508a.getParameters();
            } catch (RuntimeException e) {
                e.printStackTrace();
                com.qiniu.pili.droid.shortvideo.f.e.f.e("CameraDevice", "getParameters failed: " + e.getMessage());
            }
            return parameters;
        }
    }

    public List<int[]> l() {
        Camera.Parameters k = k();
        if (k == null) {
            return null;
        }
        try {
            return k.getSupportedPreviewFpsRange();
        } catch (StringIndexOutOfBoundsException e) {
            e.printStackTrace();
            com.qiniu.pili.droid.shortvideo.f.e.f.e("CameraDevice", "getSupportedPreviewFpsRange() failed");
            return null;
        }
    }

    public int m() {
        synchronized (this) {
            if (this.f27508a == null) {
                com.qiniu.pili.droid.shortvideo.f.e.f.d("CameraDevice", "getMaxExposureCompensation failed, camera == null");
                return 0;
            }
            try {
                return this.f27508a.getParameters().getMaxExposureCompensation();
            } catch (RuntimeException e) {
                e.printStackTrace();
                com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.f;
                eVar.e("CameraDevice", "getMaxExposureCompensation failed: " + e.getMessage());
                return 0;
            }
        }
    }

    public int n() {
        synchronized (this) {
            if (this.f27508a == null) {
                com.qiniu.pili.droid.shortvideo.f.e.f.d("CameraDevice", "getMinExposureCompensation failed, camera == null");
                return 0;
            }
            try {
                return this.f27508a.getParameters().getMinExposureCompensation();
            } catch (RuntimeException e) {
                e.printStackTrace();
                com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.f;
                eVar.e("CameraDevice", "getMinExposureCompensation failed: " + e.getMessage());
                return 0;
            }
        }
    }

    public List<Integer> o() {
        synchronized (this) {
            if (this.f27508a == null || !this.f27508a.getParameters().isZoomSupported()) {
                com.qiniu.pili.droid.shortvideo.f.e.f.d("CameraDevice", "getZoomRatios failed, camera == null or zoom not supported");
                return null;
            }
            try {
                return this.f27508a.getParameters().getZoomRatios();
            } catch (RuntimeException e) {
                e.printStackTrace();
                com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.f;
                eVar.e("CameraDevice", "getZoomRatios failed: " + e.getMessage());
                return null;
            }
        }
    }

    public void p() {
        synchronized (this) {
            if (this.f27508a == null) {
                com.qiniu.pili.droid.shortvideo.f.e.f.d("CameraDevice", "startPreview failed, camera == null");
                return;
            }
            try {
                this.f27508a.startPreview();
                com.qiniu.pili.droid.shortvideo.f.e.f.c("CameraDevice", "startPreview");
            } catch (RuntimeException e) {
                e.printStackTrace();
                com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.f;
                eVar.e("CameraDevice", "startPreview failed: " + e.getMessage());
            }
        }
    }

    public void q() {
        synchronized (this) {
            if (this.f27508a == null) {
                com.qiniu.pili.droid.shortvideo.f.e.f.d("CameraDevice", "stopPreview failed, camera == null");
                return;
            }
            try {
                this.f27508a.stopPreview();
                com.qiniu.pili.droid.shortvideo.f.e.f.c("CameraDevice", "stopPreview");
            } catch (RuntimeException e) {
                e.printStackTrace();
                com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.f;
                eVar.e("CameraDevice", "stopPreview failed: " + e.getMessage());
            }
        }
    }
}
