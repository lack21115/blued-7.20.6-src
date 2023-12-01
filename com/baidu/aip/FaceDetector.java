package com.baidu.aip;

import android.content.Context;
import com.baidu.idl.facesdk.FaceInfo;
import com.baidu.idl.facesdk.FaceSDK;
import com.baidu.idl.facesdk.FaceTracker;

/* loaded from: source-8756600-dex2jar.jar:com/baidu/aip/FaceDetector.class */
public class FaceDetector {
    public static final float DEFAULT_BLURRINESS_THRESHOLD = 0.3f;
    public static final int DEFAULT_HEAD_ANGLE = 45;
    public static final float DEFAULT_ILLUMINATION_THRESHOLD = 40.0f;
    public static final int DEFAULT_MIN_FACE_SIZE = 80;
    public static final float DEFAULT_NOT_FACE_THRESHOLD = 0.8f;
    public static final float DEFAULT_OCCULTATION_THRESHOLD = 0.5f;
    private static FaceDetector sInstance;
    private FaceTracker mFaceTracker;
    public static final int DETECT_CODE_OK = FaceTracker.ErrCode.OK.ordinal();
    public static final int DETECT_CODE_PITCH_OUT_OF_DOWN_MAX_RANGE = FaceTracker.ErrCode.PITCH_OUT_OF_DOWN_MAX_RANGE.ordinal();
    public static final int DETECT_CODE_PITCH_OUT_OF_UP_MAX_RANGE = FaceTracker.ErrCode.PITCH_OUT_OF_UP_MAX_RANGE.ordinal();
    public static final int DETECT_CODE_YAW_OUT_OF_LEFT_MAX_RANGE = FaceTracker.ErrCode.YAW_OUT_OF_LEFT_MAX_RANGE.ordinal();
    public static final int DETECT_CODE_YAW_OUT_OF_RIGHT_MAX_RANGE = FaceTracker.ErrCode.YAW_OUT_OF_RIGHT_MAX_RANGE.ordinal();
    public static final int DETECT_CODE_POOR_ILLUMINATION = FaceTracker.ErrCode.POOR_ILLUMINATION.ordinal();
    public static final int DETECT_CODE_FACE_NOT_DETECTED = FaceTracker.ErrCode.NO_FACE_DETECTED.ordinal();
    public static final int DETECT_CODE_NO_FACE_DETECTED = FaceTracker.ErrCode.NO_FACE_DETECTED.ordinal();

    private FaceDetector(Context context, String str, String str2) {
        FaceTracker faceTracker = FaceSDKManager.getInstance().getFaceTracker(context);
        this.mFaceTracker = faceTracker;
        faceTracker.set_isFineAlign(false);
        this.mFaceTracker.set_isVerifyLive(false);
        this.mFaceTracker.set_isCheckQuality(false);
        this.mFaceTracker.set_notFace_thr(0.8f);
        this.mFaceTracker.set_min_face_size(80);
        this.mFaceTracker.set_cropFaceSize(80);
        this.mFaceTracker.set_illum_thr(40.0f);
        this.mFaceTracker.set_blur_thr(0.3f);
        this.mFaceTracker.set_occlu_thr(0.5f);
        this.mFaceTracker.set_max_reg_img_num(1);
        this.mFaceTracker.set_eulur_angle_thr(45, 45, 45);
        FaceSDK.setNumberOfThreads(4);
    }

    public static FaceDetector getInstance() {
        return sInstance;
    }

    public static void init(Context context, String str, String str2) {
        if (sInstance == null) {
            sInstance = new FaceDetector(context, str, str2);
        }
    }

    public static void yuvToARGB(byte[] bArr, int i, int i2, int[] iArr, int i3, int i4) {
        FaceSDK.getARGBFromYUVimg(bArr, iArr, i, i2, i3, i4);
    }

    public void clearTrackedFaces() {
        this.mFaceTracker.clearTrackedFaces();
    }

    public int detect(ImageFrame imageFrame) {
        return detect(imageFrame.getArgb(), imageFrame.getWidth(), imageFrame.getHeight());
    }

    public int detect(int[] iArr, int i, int i2) {
        return this.mFaceTracker.prepare_max_face_data_for_verify(iArr, i2, i, FaceSDK.ImgType.ARGB.ordinal(), FaceTracker.ActionType.RECOGNIZE.ordinal());
    }

    public FaceInfo getTrackedFace() {
        FaceInfo[] faceInfoArr = this.mFaceTracker.get_TrackedFaceInfo();
        if (faceInfoArr == null || faceInfoArr.length <= 0) {
            return null;
        }
        return this.mFaceTracker.get_TrackedFaceInfo()[0];
    }

    public FaceInfo[] getTrackedFaces() {
        return this.mFaceTracker.get_TrackedFaceInfo();
    }

    public void setBlurrinessThreshold(float f) {
        this.mFaceTracker.set_blur_thr(f);
    }

    public void setCheckQuality(boolean z) {
        this.mFaceTracker.set_isCheckQuality(z);
    }

    public void setDetectInterval(int i) {
        this.mFaceTracker.set_detection_frame_interval(i);
    }

    public void setEulerAngleThreshold(int i, int i2, int i3) {
        this.mFaceTracker.set_eulur_angle_thr(i, i2, i3);
    }

    public void setIlluminationThreshold(float f) {
        this.mFaceTracker.set_illum_thr(f);
    }

    public void setMinFaceSize(int i) {
        this.mFaceTracker.set_min_face_size(i);
    }

    public void setNotFaceThreshold(float f) {
        this.mFaceTracker.set_notFace_thr(f);
    }

    public void setNumberOfThreads(int i) {
        FaceSDK.setNumberOfThreads(i);
    }

    public void setOcclulationThreshold(float f) {
        this.mFaceTracker.set_occlu_thr(f);
    }

    public void setTrackInterval(int i) {
        this.mFaceTracker.set_intervalTime(i);
    }
}
