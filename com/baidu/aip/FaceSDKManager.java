package com.baidu.aip;

import android.content.Context;
import com.baidu.idl.facesdk.FaceRecognize;
import com.baidu.idl.facesdk.FaceSDK;
import com.baidu.idl.facesdk.FaceTracker;

/* loaded from: source-8756600-dex2jar.jar:com/baidu/aip/FaceSDKManager.class */
public class FaceSDKManager {
    private FaceRecognize faceRecognize;
    private FaceTracker faceTracker;

    /* loaded from: source-8756600-dex2jar.jar:com/baidu/aip/FaceSDKManager$HolderClass.class */
    static class HolderClass {
        private static final FaceSDKManager instance = new FaceSDKManager();

        private HolderClass() {
        }
    }

    private FaceSDKManager() {
    }

    public static FaceSDKManager getInstance() {
        return HolderClass.instance;
    }

    public FaceRecognize getFaceRecognize(Context context) {
        if (this.faceRecognize == null) {
            this.faceRecognize = new FaceRecognize(context);
        }
        return this.faceRecognize;
    }

    public FaceTracker getFaceTracker(Context context) {
        FaceTracker faceTracker = this.faceTracker;
        if (faceTracker == null) {
            FaceTracker faceTracker2 = new FaceTracker(context);
            this.faceTracker = faceTracker2;
            faceTracker2.set_isFineAlign(false);
            this.faceTracker.set_isFineAlign(false);
            this.faceTracker.set_isVerifyLive(true);
            this.faceTracker.set_DetectMethodType(1);
            this.faceTracker.set_isCheckQuality(true);
            this.faceTracker.set_notFace_thr(0.6f);
            this.faceTracker.set_min_face_size(200);
            this.faceTracker.set_cropFaceSize(400);
            this.faceTracker.set_illum_thr(40.0f);
            this.faceTracker.set_blur_thr(0.7f);
            this.faceTracker.set_occlu_thr(0.5f);
            this.faceTracker.set_max_reg_img_num(1);
            this.faceTracker.set_eulur_angle_thr(10, 10, 10);
            this.faceTracker.set_track_by_detection_interval(800);
            return this.faceTracker;
        }
        return faceTracker;
    }

    public void init(Context context, String str, String str2) {
        FaceSDK.initLicense(context, str, str2, true);
        FaceSDK.initModel(context);
        getFaceTracker(context);
        getFaceRecognize(context);
    }
}
