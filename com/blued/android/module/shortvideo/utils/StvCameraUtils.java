package com.blued.android.module.shortvideo.utils;

import android.hardware.Camera;
import com.qiniu.pili.droid.shortvideo.PLCameraSetting;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/utils/StvCameraUtils.class */
public class StvCameraUtils {
    public static int a(PLCameraSetting.CAMERA_FACING_ID camera_facing_id) {
        return camera_facing_id.ordinal() % b();
    }

    public static PLCameraSetting.CAMERA_FACING_ID a() {
        int ordinal = PLCameraSetting.CAMERA_FACING_ID.CAMERA_FACING_FRONT.ordinal();
        int b = b();
        if (b != 0) {
            ordinal = PLCameraSetting.CAMERA_FACING_ID.CAMERA_FACING_FRONT.ordinal() % b;
        }
        return ordinal == PLCameraSetting.CAMERA_FACING_ID.CAMERA_FACING_FRONT.ordinal() ? PLCameraSetting.CAMERA_FACING_ID.CAMERA_FACING_FRONT : PLCameraSetting.CAMERA_FACING_ID.CAMERA_FACING_BACK;
    }

    public static PLCameraSetting.CAMERA_FACING_ID a(int i) {
        return i % b() == PLCameraSetting.CAMERA_FACING_ID.CAMERA_FACING_FRONT.ordinal() ? PLCameraSetting.CAMERA_FACING_ID.CAMERA_FACING_FRONT : PLCameraSetting.CAMERA_FACING_ID.CAMERA_FACING_BACK;
    }

    public static int b() {
        return Camera.getNumberOfCameras();
    }
}
