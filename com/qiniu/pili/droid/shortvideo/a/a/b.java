package com.qiniu.pili.droid.shortvideo.a.a;

import android.content.Context;
import android.graphics.ImageFormat;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import com.qiniu.pili.droid.shortvideo.PLCameraParamSelectListener;
import com.qiniu.pili.droid.shortvideo.PLCameraPreviewListener;
import com.qiniu.pili.droid.shortvideo.PLCameraSetting;
import com.qiniu.pili.droid.shortvideo.PLFocusListener;
import com.qiniu.pili.droid.shortvideo.PLFourCC;
import com.qiniu.pili.droid.shortvideo.f.j;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/a/a/b.class */
public final class b implements SurfaceTexture.OnFrameAvailableListener, Camera.PreviewCallback {

    /* renamed from: a  reason: collision with root package name */
    private Context f27511a;
    private PLCameraPreviewListener b;

    /* renamed from: c  reason: collision with root package name */
    private PLCameraParamSelectListener f27512c;
    private PLCameraSetting d;
    private int e = -1;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private e k;
    private a l;
    private PLFocusListener m;
    private List<Float> n;

    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/a/a/b$a.class */
    public interface a {
        void a(int i, int i2, int i3, int i4);
    }

    public b(Context context, PLCameraSetting pLCameraSetting) {
        this.f = 1;
        this.f27511a = context;
        this.d = pLCameraSetting;
        this.f = pLCameraSetting.getCameraId().ordinal();
        com.qiniu.pili.droid.shortvideo.f.e.f.c("CameraManager", "CameraManager created !");
    }

    private static List<Camera.Size> a(List<Camera.Size> list) {
        if (list == null) {
            return null;
        }
        Collections.sort(list, new Comparator<Camera.Size>() { // from class: com.qiniu.pili.droid.shortvideo.a.a.b.1
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(Camera.Size size, Camera.Size size2) {
                return (size.width * size.height) - (size2.width * size2.height);
            }
        });
        return list;
    }

    private List<Camera.Size> a(List<Camera.Size> list, PLCameraSetting.CAMERA_PREVIEW_SIZE_RATIO camera_preview_size_ratio, PLCameraSetting.CAMERA_PREVIEW_SIZE_LEVEL camera_preview_size_level) {
        String str;
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        double calcCameraPreviewSizeRatio = PLCameraSetting.calcCameraPreviewSizeRatio(camera_preview_size_ratio);
        com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.f;
        eVar.c("CameraManager", "filterCameraPreviewSize targetRatio : " + calcCameraPreviewSizeRatio);
        Iterator<Camera.Size> it = list.iterator();
        while (it.hasNext()) {
            Camera.Size next = it.next();
            com.qiniu.pili.droid.shortvideo.f.e eVar2 = com.qiniu.pili.droid.shortvideo.f.e.f;
            eVar2.c("CameraManager", "size.width:" + next.width + ",size.height:" + next.height);
            if (Math.abs((next.width / next.height) - calcCameraPreviewSizeRatio) > 0.05d) {
                arrayList.add(next);
                it.remove();
            }
        }
        ArrayList arrayList2 = new ArrayList();
        int calcCameraPreviewSizeLevel = PLCameraSetting.calcCameraPreviewSizeLevel(camera_preview_size_level);
        com.qiniu.pili.droid.shortvideo.f.e eVar3 = com.qiniu.pili.droid.shortvideo.f.e.f;
        eVar3.c("CameraManager", "filterCameraPreviewSize targetLevel : " + calcCameraPreviewSizeLevel);
        Iterator<Camera.Size> it2 = list.iterator();
        while (it2.hasNext()) {
            Camera.Size next2 = it2.next();
            if (next2.height != calcCameraPreviewSizeLevel) {
                arrayList2.add(next2);
                it2.remove();
            }
        }
        if (list.isEmpty()) {
            list = arrayList2.isEmpty() ? arrayList : arrayList2;
            str = arrayList2.isEmpty() ? "after no filter" : "after ratio filter";
        } else {
            str = "after ratio and level filter";
        }
        for (Camera.Size size : list) {
            com.qiniu.pili.droid.shortvideo.f.e eVar4 = com.qiniu.pili.droid.shortvideo.f.e.f;
            eVar4.c("CameraManager", str + " size.w:" + size.width + ", size.h:" + size.height);
        }
        return list;
    }

    private boolean i() {
        PLCameraParamSelectListener pLCameraParamSelectListener;
        com.qiniu.pili.droid.shortvideo.f.e.f.c("CameraManager", "setupCamera +");
        if (!j.a(this.f27511a)) {
            com.qiniu.pili.droid.shortvideo.f.e.f.e("CameraManager", "failed, No camera hardware !");
            return false;
        } else if (com.qiniu.pili.droid.shortvideo.a.a.a.a().a(this.f)) {
            Camera.Parameters k = com.qiniu.pili.droid.shortvideo.a.a.a.a().k();
            if (k == null) {
                com.qiniu.pili.droid.shortvideo.f.e.f.e("CameraManager", "failed to get camera params");
                return false;
            }
            List<Integer> supportedPreviewFormats = k.getSupportedPreviewFormats();
            com.qiniu.pili.droid.shortvideo.f.e.f.c("CameraManager", "supported camera preview formats: " + supportedPreviewFormats.size());
            Iterator<Integer> it = supportedPreviewFormats.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().intValue() == 17) {
                        k.setPreviewFormat(17);
                        com.qiniu.pili.droid.shortvideo.f.e.f.c("CameraManager", "set camera preview format NV21");
                        this.e = PLFourCC.FOURCC_NV21;
                        break;
                    }
                } else {
                    break;
                }
            }
            List<int[]> l = com.qiniu.pili.droid.shortvideo.a.a.a.a().l();
            int[] onPreviewFpsSelected = (l == null || (pLCameraParamSelectListener = this.f27512c) == null) ? null : pLCameraParamSelectListener.onPreviewFpsSelected(l);
            if (onPreviewFpsSelected != null && onPreviewFpsSelected.length == 2) {
                k.setPreviewFpsRange(onPreviewFpsSelected[0], onPreviewFpsSelected[1]);
                com.qiniu.pili.droid.shortvideo.f.e.f.c("CameraManager", "set camera preview fps: " + onPreviewFpsSelected[0] + Constants.WAVE_SEPARATOR + onPreviewFpsSelected[1]);
            }
            List<Camera.Size> supportedPreviewSizes = k.getSupportedPreviewSizes();
            if (supportedPreviewSizes == null || supportedPreviewSizes.isEmpty()) {
                com.qiniu.pili.droid.shortvideo.f.e.f.e("CameraManager", "Could not get camera device preview sizes, setup camera failed!");
                return false;
            }
            List<Camera.Size> a2 = a(a(supportedPreviewSizes, this.d.getCameraPreviewSizeRatio(), this.d.getCameraPreviewSizeLevel()));
            if (a2 == null || a2.isEmpty()) {
                com.qiniu.pili.droid.shortvideo.f.e.f.e("CameraManager", "No camera device preview sizes available, setup camera failed!");
                return false;
            }
            PLCameraParamSelectListener pLCameraParamSelectListener2 = this.f27512c;
            Camera.Size onPreviewSizeSelected = pLCameraParamSelectListener2 != null ? pLCameraParamSelectListener2.onPreviewSizeSelected(a2) : null;
            Camera.Size size = onPreviewSizeSelected;
            if (onPreviewSizeSelected == null) {
                size = a2.get(a2.size() / 2);
            }
            k.setPreviewSize(size.width, size.height);
            com.qiniu.pili.droid.shortvideo.f.e.f.c("CameraManager", "set camera preview size: " + size.width + "x" + size.height);
            this.g = size.width;
            this.h = size.height;
            List<String> supportedFocusModes = k.getSupportedFocusModes();
            if (supportedFocusModes != null && !supportedFocusModes.isEmpty()) {
                PLCameraParamSelectListener pLCameraParamSelectListener3 = this.f27512c;
                String str = null;
                if (pLCameraParamSelectListener3 != null) {
                    str = pLCameraParamSelectListener3.onFocusModeSelected(supportedFocusModes);
                    if (!supportedFocusModes.contains(str)) {
                        com.qiniu.pili.droid.shortvideo.f.e.f.c("CameraManager", "no such focus mode exists in this camera");
                        str = null;
                    }
                }
                String str2 = str;
                if (str == null) {
                    str2 = supportedFocusModes.contains("continuous-video") ? "continuous-video" : supportedFocusModes.get(0);
                }
                k.setFocusMode(str2);
                com.qiniu.pili.droid.shortvideo.f.e.f.c("CameraManager", "set focus mode: " + str2);
            }
            int c2 = j.c(this.f27511a);
            Camera.CameraInfo c3 = com.qiniu.pili.droid.shortvideo.a.a.a.a().c();
            int i = this.f == 1 ? (360 - ((c3.orientation + c2) % 360)) % 360 : ((c3.orientation - c2) + 360) % 360;
            com.qiniu.pili.droid.shortvideo.a.a.a.a().b(i);
            com.qiniu.pili.droid.shortvideo.f.e.f.c("CameraManager", "set camera display orientation: " + i);
            com.qiniu.pili.droid.shortvideo.a.a.a.a().a(k);
            if (this.b != null) {
                int g = ((com.qiniu.pili.droid.shortvideo.a.a.a.a().g() * com.qiniu.pili.droid.shortvideo.a.a.a.a().h()) * ImageFormat.getBitsPerPixel(k.getPreviewFormat())) / 8;
                if (g == 0) {
                    com.qiniu.pili.droid.shortvideo.f.e.f.e("CameraManager", "previewBufferSize can not be 0!");
                    return false;
                }
                for (int i2 = 0; i2 < 2; i2++) {
                    com.qiniu.pili.droid.shortvideo.a.a.a.a().a(new byte[g]);
                }
                com.qiniu.pili.droid.shortvideo.a.a.a.a().a(this);
            }
            if (i == 90 || i == 270) {
                this.i = size.height;
                this.j = size.width;
            } else {
                this.i = size.width;
                this.j = size.height;
            }
            com.qiniu.pili.droid.shortvideo.f.e.f.c("CameraManager", "setupCamera -");
            return true;
        } else {
            return false;
        }
    }

    public void a() {
        com.qiniu.pili.droid.shortvideo.f.e.f.c("CameraManager", "pause +");
        com.qiniu.pili.droid.shortvideo.a.a.a.a().q();
        com.qiniu.pili.droid.shortvideo.a.a.a.a().f();
        com.qiniu.pili.droid.shortvideo.f.e.f.c("CameraManager", "pause -");
    }

    public void a(float f) {
        List<Float> list = this.n;
        if (list == null) {
            com.qiniu.pili.droid.shortvideo.f.e.f.d("CameraManager", "setZoom failed, must call getZooms first.");
            return;
        }
        int indexOf = list.indexOf(Float.valueOf(f));
        if (indexOf >= 0) {
            com.qiniu.pili.droid.shortvideo.a.a.a.a().d(indexOf);
        } else {
            com.qiniu.pili.droid.shortvideo.f.e.f.d("CameraManager", "setZoom failed, invalid value.");
        }
    }

    public void a(int i) {
        com.qiniu.pili.droid.shortvideo.a.a.a.a().c(i);
    }

    public void a(int i, int i2) {
        Camera.Parameters k = com.qiniu.pili.droid.shortvideo.a.a.a.a().k();
        if (k != null) {
            e eVar = new e(this.f27511a, k.getFocusMode(), i, i2);
            this.k = eVar;
            eVar.a(this.m);
        }
    }

    public void a(int i, int i2, int i3, int i4) {
        e eVar = this.k;
        if (eVar != null) {
            eVar.a(i, i2, i3, i4);
        }
    }

    public final void a(PLCameraParamSelectListener pLCameraParamSelectListener) {
        this.f27512c = pLCameraParamSelectListener;
    }

    public final void a(PLCameraPreviewListener pLCameraPreviewListener) {
        this.b = pLCameraPreviewListener;
    }

    public void a(PLCameraSetting.CAMERA_FACING_ID camera_facing_id) {
        com.qiniu.pili.droid.shortvideo.f.e.f.c("CameraManager", "switchCameraId +");
        if (com.qiniu.pili.droid.shortvideo.a.a.a.b() < 2) {
            com.qiniu.pili.droid.shortvideo.f.e.f.e("CameraManager", "failed to switch camera, the phone only has one camera !");
            return;
        }
        if (camera_facing_id == null) {
            com.qiniu.pili.droid.shortvideo.f.e.f.c("CameraManager", "switch to next camera");
            if (this.f == 0) {
                this.f = 1;
                camera_facing_id = PLCameraSetting.CAMERA_FACING_ID.CAMERA_FACING_FRONT;
            } else {
                this.f = 0;
                camera_facing_id = PLCameraSetting.CAMERA_FACING_ID.CAMERA_FACING_BACK;
            }
        } else {
            com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.f;
            eVar.c("CameraManager", "switch to specify camera with facing: " + camera_facing_id);
            if (camera_facing_id == PLCameraSetting.CAMERA_FACING_ID.CAMERA_FACING_BACK) {
                this.f = 0;
            } else if (camera_facing_id == PLCameraSetting.CAMERA_FACING_ID.CAMERA_FACING_FRONT) {
                this.f = 1;
            } else {
                this.f = 2;
            }
        }
        this.d.setCameraId(camera_facing_id);
        this.n = null;
        com.qiniu.pili.droid.shortvideo.f.e.f.c("CameraManager", "switchCameraId -");
    }

    public void a(PLFocusListener pLFocusListener) {
        this.m = pLFocusListener;
        e eVar = this.k;
        if (eVar != null) {
            eVar.a(pLFocusListener);
        }
    }

    public void a(a aVar) {
        this.l = aVar;
    }

    public boolean a(SurfaceTexture surfaceTexture) {
        com.qiniu.pili.droid.shortvideo.f.e.f.c("CameraManager", "resume +");
        if (i()) {
            surfaceTexture.setOnFrameAvailableListener(this);
            com.qiniu.pili.droid.shortvideo.a.a.a.a().a(surfaceTexture);
            com.qiniu.pili.droid.shortvideo.a.a.a.a().p();
            com.qiniu.pili.droid.shortvideo.f.e.f.c("CameraManager", "resume -");
            return true;
        }
        return false;
    }

    public void b() {
        com.qiniu.pili.droid.shortvideo.f.e.f.c("CameraManager", "destroy");
    }

    public boolean c() {
        com.qiniu.pili.droid.shortvideo.f.e.f.c("CameraManager", "turnLightOn");
        if (!com.qiniu.pili.droid.shortvideo.a.a.a.a().d()) {
            com.qiniu.pili.droid.shortvideo.f.e.f.d("CameraManager", "turnLightOn: camera not open !");
            return false;
        } else if (!com.qiniu.pili.droid.shortvideo.f.a.a().c()) {
            com.qiniu.pili.droid.shortvideo.f.e.f.d("CameraManager", "turnLightOn: torch not supported !");
            return false;
        } else {
            Camera.Parameters k = com.qiniu.pili.droid.shortvideo.a.a.a.a().k();
            if (k == null) {
                return false;
            }
            List<String> supportedFlashModes = k.getSupportedFlashModes();
            if (supportedFlashModes == null) {
                com.qiniu.pili.droid.shortvideo.f.e.f.e("CameraManager", "getSupportedFlashModes is null");
                return false;
            } else if ("torch".equals(k.getFlashMode())) {
                return true;
            } else {
                if (!supportedFlashModes.contains("torch")) {
                    com.qiniu.pili.droid.shortvideo.f.e.f.e("CameraManager", "FLASH_MODE_TORCH not supported");
                    return false;
                }
                if (com.qiniu.pili.droid.shortvideo.f.a.a().b()) {
                    k.setFocusMode(Camera.Parameters.FOCUS_MODE_MACRO);
                }
                k.setFlashMode("torch");
                com.qiniu.pili.droid.shortvideo.a.a.a.a().a(k);
                return true;
            }
        }
    }

    public boolean d() {
        com.qiniu.pili.droid.shortvideo.f.e.f.c("CameraManager", "turnLightOff");
        if (!com.qiniu.pili.droid.shortvideo.a.a.a.a().d()) {
            com.qiniu.pili.droid.shortvideo.f.e.f.d("CameraManager", "turnLightOff: camera not open !");
            return false;
        } else if (!com.qiniu.pili.droid.shortvideo.f.a.a().c()) {
            com.qiniu.pili.droid.shortvideo.f.e.f.d("CameraManager", "turnLightOff: torch not supported !");
            return false;
        } else {
            Camera.Parameters k = com.qiniu.pili.droid.shortvideo.a.a.a.a().k();
            if (k == null) {
                return false;
            }
            List<String> supportedFlashModes = k.getSupportedFlashModes();
            String flashMode = k.getFlashMode();
            if (supportedFlashModes == null) {
                com.qiniu.pili.droid.shortvideo.f.e.f.e("CameraManager", "getSupportedFlashModes is null");
                return false;
            } else if ("off".equals(flashMode)) {
                return true;
            } else {
                if (!supportedFlashModes.contains("off")) {
                    com.qiniu.pili.droid.shortvideo.f.e.f.e("CameraManager", "FLASH_MODE_OFF not supported");
                    return false;
                }
                if (com.qiniu.pili.droid.shortvideo.f.a.a().b()) {
                    k.setFocusMode("continuous-video");
                }
                k.setFlashMode("off");
                com.qiniu.pili.droid.shortvideo.a.a.a.a().a(k);
                return true;
            }
        }
    }

    public boolean e() {
        if (com.qiniu.pili.droid.shortvideo.f.a.a().c()) {
            Camera.Parameters k = com.qiniu.pili.droid.shortvideo.a.a.a.a().k();
            boolean z = false;
            if (k != null) {
                z = false;
                if (k.getSupportedFlashModes() != null) {
                    z = false;
                    if (k.getSupportedFlashModes().contains("torch")) {
                        z = true;
                    }
                }
            }
            return z;
        }
        return false;
    }

    public int f() {
        return com.qiniu.pili.droid.shortvideo.a.a.a.a().m();
    }

    public int g() {
        return com.qiniu.pili.droid.shortvideo.a.a.a.a().n();
    }

    public List<Float> h() {
        List<Integer> o = com.qiniu.pili.droid.shortvideo.a.a.a.a().o();
        if (o != null) {
            this.n = new ArrayList(o.size());
            for (Integer num : o) {
                this.n.add(Float.valueOf(num.intValue() / 100.0f));
            }
        } else {
            this.n = null;
        }
        com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.f;
        eVar.c("CameraManager", "get zoom values: " + this.n);
        return this.n;
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        com.qiniu.pili.droid.shortvideo.f.e.f.a("CameraManager", "onFrameAvailable");
        a aVar = this.l;
        if (aVar != null) {
            aVar.a(this.g, this.h, this.i, this.j);
        }
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        if (camera == null || bArr == null) {
            return;
        }
        int g = com.qiniu.pili.droid.shortvideo.a.a.a.a().g();
        int h = com.qiniu.pili.droid.shortvideo.a.a.a.a().h();
        if (this.b != null && g != 0 && h != 0) {
            this.b.onPreviewFrame(bArr, g, h, com.qiniu.pili.droid.shortvideo.a.a.a.a().j() ? (360 - com.qiniu.pili.droid.shortvideo.a.a.a.a().i()) % 360 : com.qiniu.pili.droid.shortvideo.a.a.a.a().i(), this.e, System.nanoTime());
        }
        camera.addCallbackBuffer(bArr);
    }
}
