package com.soft.blued.utils.third;

import android.app.Activity;
import android.content.Context;
import android.provider.Settings;
import android.util.Log;
import android.view.WindowManager;
import com.baidu.aip.FaceSDKManager;
import com.baidu.idl.facesdk.FaceTracker;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/utils/third/BaiduFaceDetectUtils.class */
public class BaiduFaceDetectUtils {
    public static int a(Activity activity) {
        try {
            return Settings.System.getInt(activity.getContentResolver(), Settings.System.SCREEN_BRIGHTNESS);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static void a(Activity activity, int i) {
        WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
        attributes.screenBrightness = Float.valueOf(i).floatValue() * 0.003921569f;
        Log.d("lxy", "set  lp.screenBrightness == " + attributes.screenBrightness);
        activity.getWindow().setAttributes(attributes);
    }

    public static void a(Context context) {
        FaceSDKManager.getInstance().init(context, "Blued-China-face-android", "idl-license.face-android");
        b(context);
    }

    private static void b(Context context) {
        FaceTracker faceTracker = FaceSDKManager.getInstance().getFaceTracker(context);
        faceTracker.set_blur_thr(0.7f);
        faceTracker.set_illum_thr(40.0f);
        faceTracker.set_cropFaceSize(400);
        faceTracker.set_eulur_angle_thr(10, 10, 10);
        faceTracker.set_min_face_size(200);
        faceTracker.set_notFace_thr(0.6f);
        faceTracker.set_occlu_thr(0.5f);
        faceTracker.set_isCheckQuality(true);
        faceTracker.set_isVerifyLive(false);
    }
}
