package com.qiniu.pili.droid.shortvideo;

import com.qiniu.pili.droid.shortvideo.a.a.a;
import com.tencent.ugc.UGCTransitionRules;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/PLCameraSetting.class */
public class PLCameraSetting {
    private static final String CAM_FACING_ID = "cameraFacingId";
    private static final String CAM_PREVIEW_SIZE_LEVEL = "cameraPreviewSizeLevel";
    private static final String CAM_PREVIEW_SIZE_RATIO = "cameraPreviewSizeRatio";
    private static final int[] PREVIEW_SIZE_LEVEL_ARRAY = {120, 240, 360, 480, UGCTransitionRules.DEFAULT_IMAGE_WIDTH, 960, 1080, 1200};
    public static final String TAG = "PLCameraSetting";
    private CAMERA_FACING_ID mCameraFacingId = CAMERA_FACING_ID.CAMERA_FACING_BACK;
    private CAMERA_PREVIEW_SIZE_RATIO mPreviewSizeRatio = CAMERA_PREVIEW_SIZE_RATIO.RATIO_16_9;
    private CAMERA_PREVIEW_SIZE_LEVEL mPreviewSizeLevel = CAMERA_PREVIEW_SIZE_LEVEL.PREVIEW_SIZE_LEVEL_480P;

    /* renamed from: com.qiniu.pili.droid.shortvideo.PLCameraSetting$1  reason: invalid class name */
    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/PLCameraSetting$1.class */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f27491a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:7:0x0020 -> B:11:0x0014). Please submit an issue!!! */
        static {
            int[] iArr = new int[CAMERA_PREVIEW_SIZE_RATIO.values().length];
            f27491a = iArr;
            try {
                iArr[CAMERA_PREVIEW_SIZE_RATIO.RATIO_4_3.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f27491a[CAMERA_PREVIEW_SIZE_RATIO.RATIO_16_9.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/PLCameraSetting$CAMERA_FACING_ID.class */
    public enum CAMERA_FACING_ID {
        CAMERA_FACING_BACK,
        CAMERA_FACING_FRONT,
        CAMERA_FACING_3RD
    }

    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/PLCameraSetting$CAMERA_PREVIEW_SIZE_LEVEL.class */
    public enum CAMERA_PREVIEW_SIZE_LEVEL {
        PREVIEW_SIZE_LEVEL_120P,
        PREVIEW_SIZE_LEVEL_240P,
        PREVIEW_SIZE_LEVEL_360P,
        PREVIEW_SIZE_LEVEL_480P,
        PREVIEW_SIZE_LEVEL_720P,
        PREVIEW_SIZE_LEVEL_960P,
        PREVIEW_SIZE_LEVEL_1080P,
        PREVIEW_SIZE_LEVEL_1200P
    }

    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/PLCameraSetting$CAMERA_PREVIEW_SIZE_RATIO.class */
    public enum CAMERA_PREVIEW_SIZE_RATIO {
        RATIO_4_3,
        RATIO_16_9
    }

    public static int calcCameraPreviewSizeLevel(CAMERA_PREVIEW_SIZE_LEVEL camera_preview_size_level) {
        return PREVIEW_SIZE_LEVEL_ARRAY[camera_preview_size_level.ordinal()];
    }

    public static double calcCameraPreviewSizeRatio(CAMERA_PREVIEW_SIZE_RATIO camera_preview_size_ratio) {
        int i = AnonymousClass1.f27491a[camera_preview_size_ratio.ordinal()];
        if (i != 1) {
            if (i == 2) {
                return 1.7777777777777777d;
            }
            throw new IllegalArgumentException("cannot support ratio:" + camera_preview_size_ratio);
        }
        return 1.3333333333333333d;
    }

    public static PLCameraSetting fromJSON(JSONObject jSONObject) {
        PLCameraSetting pLCameraSetting = new PLCameraSetting();
        pLCameraSetting.setCameraId(CAMERA_FACING_ID.valueOf(jSONObject.optString(CAM_FACING_ID, CAMERA_FACING_ID.CAMERA_FACING_BACK.name())));
        pLCameraSetting.setCameraPreviewSizeRatio(CAMERA_PREVIEW_SIZE_RATIO.valueOf(jSONObject.optString(CAM_PREVIEW_SIZE_RATIO, CAMERA_PREVIEW_SIZE_RATIO.RATIO_16_9.name())));
        pLCameraSetting.setCameraPreviewSizeLevel(CAMERA_PREVIEW_SIZE_LEVEL.valueOf(jSONObject.optString(CAM_PREVIEW_SIZE_LEVEL, CAMERA_PREVIEW_SIZE_LEVEL.PREVIEW_SIZE_LEVEL_480P.name())));
        return pLCameraSetting;
    }

    public static boolean hasCameraFacing(CAMERA_FACING_ID camera_facing_id) {
        return a.e(camera_facing_id.ordinal());
    }

    public CAMERA_FACING_ID getCameraId() {
        return this.mCameraFacingId;
    }

    public CAMERA_PREVIEW_SIZE_LEVEL getCameraPreviewSizeLevel() {
        return this.mPreviewSizeLevel;
    }

    public CAMERA_PREVIEW_SIZE_RATIO getCameraPreviewSizeRatio() {
        return this.mPreviewSizeRatio;
    }

    public PLCameraSetting setCameraId(CAMERA_FACING_ID camera_facing_id) {
        this.mCameraFacingId = camera_facing_id;
        return this;
    }

    public PLCameraSetting setCameraPreviewSizeLevel(CAMERA_PREVIEW_SIZE_LEVEL camera_preview_size_level) {
        this.mPreviewSizeLevel = camera_preview_size_level;
        return this;
    }

    public PLCameraSetting setCameraPreviewSizeRatio(CAMERA_PREVIEW_SIZE_RATIO camera_preview_size_ratio) {
        this.mPreviewSizeRatio = camera_preview_size_ratio;
        return this;
    }

    public JSONObject toJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(CAM_FACING_ID, this.mCameraFacingId.name());
            jSONObject.put(CAM_PREVIEW_SIZE_RATIO, this.mPreviewSizeRatio.name());
            jSONObject.put(CAM_PREVIEW_SIZE_LEVEL, this.mPreviewSizeLevel.name());
            return jSONObject;
        } catch (JSONException e) {
            return null;
        }
    }
}
