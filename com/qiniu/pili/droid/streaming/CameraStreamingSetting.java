package com.qiniu.pili.droid.streaming;

import a.a.a.a.a.b.b;
import a.a.a.a.a.e.e;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/streaming/CameraStreamingSetting.class */
public class CameraStreamingSetting {
    public static final String FOCUS_MODE_AUTO = "auto";
    public static final String FOCUS_MODE_CONTINUOUS_PICTURE = "continuous-picture";
    public static final String FOCUS_MODE_CONTINUOUS_VIDEO = "continuous-video";
    public int b;

    /* renamed from: c  reason: collision with root package name */
    public int f27817c;
    public boolean d;
    public boolean g;
    public PREVIEW_SIZE_LEVEL h;
    public PREVIEW_SIZE_RATIO i;
    public boolean j;
    public boolean p;
    public boolean q;
    public int u;

    /* renamed from: a  reason: collision with root package name */
    public FaceBeautySetting f27816a = new FaceBeautySetting(1.0f, 0.5f, 0.5f);
    public CAMERA_FACING_ID k = CAMERA_FACING_ID.CAMERA_FACING_BACK;
    public boolean l = false;
    public boolean m = false;
    public String n = "continuous-video";
    public int o = 3000;
    public VIDEO_FILTER_TYPE r = VIDEO_FILTER_TYPE.VIDEO_FILTER_NONE;
    public boolean s = false;
    public boolean t = false;
    public int v = -1;
    public boolean w = true;
    public int e = -1;
    public int f = -1;

    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/streaming/CameraStreamingSetting$CAMERA_FACING_ID.class */
    public enum CAMERA_FACING_ID {
        CAMERA_FACING_BACK,
        CAMERA_FACING_FRONT,
        CAMERA_FACING_3RD
    }

    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/streaming/CameraStreamingSetting$FaceBeautySetting.class */
    public static final class FaceBeautySetting {
        public float beautyLevel;
        public float redden;
        public float whiten;

        public FaceBeautySetting(float f, float f2, float f3) {
            this.beautyLevel = f;
            this.redden = f3;
            this.whiten = f2;
        }

        public String toString() {
            return "[" + this.beautyLevel + "," + this.whiten + "," + this.redden + "]";
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/streaming/CameraStreamingSetting$PREVIEW_SIZE_LEVEL.class */
    public enum PREVIEW_SIZE_LEVEL {
        SMALL,
        MEDIUM,
        LARGE
    }

    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/streaming/CameraStreamingSetting$PREVIEW_SIZE_RATIO.class */
    public enum PREVIEW_SIZE_RATIO {
        RATIO_4_3,
        RATIO_16_9
    }

    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/streaming/CameraStreamingSetting$VIDEO_FILTER_TYPE.class */
    public enum VIDEO_FILTER_TYPE {
        VIDEO_FILTER_NONE,
        VIDEO_FILTER_BEAUTY
    }

    public static int getNumberOfCameras() {
        return b.a().d();
    }

    public static boolean hasCameraFacing(CAMERA_FACING_ID camera_facing_id) {
        b.a();
        return b.a(camera_facing_id.ordinal());
    }

    public CameraStreamingSetting a(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            throw new RuntimeException("Illegal width or height!!!");
        }
        this.b = i;
        this.f27817c = i2;
        return this;
    }

    public CameraStreamingSetting a(boolean z) {
        this.d = z;
        return this;
    }

    public void a(int i) {
        this.u = i;
    }

    public void a(PREVIEW_SIZE_RATIO preview_size_ratio) {
        this.i = preview_size_ratio;
    }

    public boolean a() {
        return this.m;
    }

    public int b() {
        return this.f27817c;
    }

    public CameraStreamingSetting b(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            throw new RuntimeException("Illegal width or height!!!");
        }
        this.e = i;
        this.f = i2;
        return this;
    }

    public void b(int i) {
        this.v = i;
    }

    public int c() {
        return this.b;
    }

    public boolean d() {
        return this.d;
    }

    public boolean e() {
        return this.s;
    }

    public boolean f() {
        return this.t;
    }

    public boolean g() {
        return this.l;
    }

    public int getCameraDisplayOrientation() {
        return this.u;
    }

    public CAMERA_FACING_ID getCameraFacingId() {
        return this.k;
    }

    public int getCameraPreviewHeight() {
        return this.f;
    }

    public int getCameraPreviewWidth() {
        return this.e;
    }

    public FaceBeautySetting getFaceBeautySetting() {
        return this.f27816a;
    }

    public String getFocusMode() {
        return this.n;
    }

    public PREVIEW_SIZE_LEVEL getPrvSizeLevel() {
        return this.h;
    }

    public PREVIEW_SIZE_RATIO getPrvSizeRatio() {
        return this.i;
    }

    public int getReqCameraId() {
        return this.k.ordinal();
    }

    public int getResetTouchFocusDelay() {
        return this.o;
    }

    public int getStreamingPreviewCallbackFormat() {
        return this.v;
    }

    public VIDEO_FILTER_TYPE getVideoFilterType() {
        return this.r;
    }

    public boolean isCAFEnabled() {
        return this.g;
    }

    public boolean isFrontCameraMirror() {
        return this.p;
    }

    public boolean isFrontCameraPreviewMirror() {
        return this.q;
    }

    public boolean isPreviewAdaptToEncodingSize() {
        return this.w;
    }

    public boolean isPreviewSizeOptimize() {
        return this.j;
    }

    public CameraStreamingSetting setBuiltInFaceBeautyEnabled(boolean z) {
        this.s = z && SharedLibraryNameHelper.d(true);
        return this;
    }

    public CameraStreamingSetting setCameraFacingId(CAMERA_FACING_ID camera_facing_id) {
        this.k = camera_facing_id;
        return this;
    }

    public CameraStreamingSetting setCameraId(int i) {
        if (i == 0) {
            this.k = CAMERA_FACING_ID.CAMERA_FACING_BACK;
            return this;
        } else if (i == 1) {
            this.k = CAMERA_FACING_ID.CAMERA_FACING_FRONT;
            return this;
        } else {
            this.k = CAMERA_FACING_ID.CAMERA_FACING_3RD;
            return this;
        }
    }

    public CameraStreamingSetting setCameraPrvSizeLevel(PREVIEW_SIZE_LEVEL preview_size_level) {
        this.h = preview_size_level;
        return this;
    }

    public CameraStreamingSetting setCameraPrvSizeRatio(PREVIEW_SIZE_RATIO preview_size_ratio) {
        this.i = preview_size_ratio;
        if (preview_size_ratio != null) {
            this.l = true;
        }
        return this;
    }

    public CameraStreamingSetting setCaptureCameraFrameOnly(boolean z) {
        this.t = z;
        return this;
    }

    public CameraStreamingSetting setContinuousFocusModeEnabled(boolean z) {
        this.g = z;
        return this;
    }

    public CameraStreamingSetting setFaceBeautySetting(FaceBeautySetting faceBeautySetting) {
        this.f27816a = faceBeautySetting;
        return this;
    }

    public CameraStreamingSetting setFocusMode(String str) {
        this.n = str;
        this.g = "continuous-picture".equals(str) || "continuous-video".equals(str);
        e eVar = e.f1361c;
        eVar.d("CameraStreamingSetting", "ContinuousFocusModeEnabled had been forced to:" + this.g);
        return this;
    }

    public CameraStreamingSetting setFrontCameraMirror(boolean z) {
        this.p = z;
        return this;
    }

    public CameraStreamingSetting setFrontCameraPreviewMirror(boolean z) {
        this.q = z;
        return this;
    }

    public CameraStreamingSetting setPreviewAdaptToEncodingSize(boolean z) {
        this.w = z;
        return this;
    }

    public CameraStreamingSetting setPreviewSizeOptimize(boolean z) {
        this.j = z;
        return this;
    }

    public CameraStreamingSetting setRecordingHint(boolean z) {
        this.m = z;
        return this;
    }

    public CameraStreamingSetting setResetTouchFocusDelayInMs(int i) {
        this.o = i;
        return this;
    }

    public CameraStreamingSetting setVideoFilter(VIDEO_FILTER_TYPE video_filter_type) {
        if (video_filter_type != null) {
            this.r = video_filter_type;
            return this;
        }
        this.r = VIDEO_FILTER_TYPE.VIDEO_FILTER_NONE;
        return this;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("PrvSizeLevel", this.h);
            jSONObject.put("PrvSizeRatio", this.i);
            jSONObject.put("BuiltInFBEnabled", this.s);
            jSONObject.put("FBSetting", this.f27816a.toString());
            jSONObject.put("VideoFilterType", this.r);
            jSONObject.put("CameraFacingId", this.k);
            jSONObject.put("ContinuousFocusMode", this.g);
            jSONObject.put("PreviewSizeOptimize", this.j);
            jSONObject.put("RecordingHint", this.m);
            jSONObject.put("FocusMode", this.n);
            jSONObject.put("EncodingMirror", this.p);
            jSONObject.put("PreviewMirror", this.q);
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return e.toString();
        }
    }
}
