package com.sensetime.stmobile;

/* loaded from: source-8303388-dex2jar.jar:com/sensetime/stmobile/STCommonNative.class */
public class STCommonNative {
    public static final int ST_DYNAMIC_GESTURE_TYPE_FOREFINGER_CLICK = 1;
    public static final int ST_DYNAMIC_GESTURE_TYPE_FOREFINGER_ROTATION_ANTICLOCKWISE = 3;
    public static final int ST_DYNAMIC_GESTURE_TYPE_FOREFINGER_ROTATION_CLOCKWISE = 2;
    public static final int ST_DYNAMIC_GESTURE_TYPE_HOLD_ON = 0;
    public static final int ST_DYNAMIC_GESTURE_TYPE_INVALID = -1;
    public static final int ST_DYNAMIC_GESTURE_TYPE_MAX_NUM = 7;
    public static final int ST_DYNAMIC_GESTURE_TYPE_PALM_FAN = 4;
    public static final int ST_DYNAMIC_GESTURE_TYPE_PALM_MOVING_LEFT_AND_RIGHT = 5;
    public static final int ST_DYNAMIC_GESTURE_TYPE_PALM_MOVING_UP_AND_DOWN = 6;
    public static final int ST_MOBILE_HUMAN_ACTION_MAX_FACE_COUNT = 10;
    public static final int ST_MOBILE_TRACKING_ENABLE_DEBOUNCE = 16;
    public static final int ST_MOBILE_TRACKING_ENABLE_FACE_ACTION = 32;
    public static final int ST_MOBILE_TRACKING_MULTI_THREAD = 0;
    public static final int ST_MOBILE_TRACKING_SINGLE_THREAD = 65536;
    public static final int ST_PIX_FMT_BGR888 = 5;
    public static final int ST_PIX_FMT_BGRA8888 = 4;
    public static final int ST_PIX_FMT_GRAY8 = 0;
    public static final int ST_PIX_FMT_NV12 = 2;
    public static final int ST_PIX_FMT_NV21 = 3;
    public static final int ST_PIX_FMT_RGBA8888 = 6;
    public static final int ST_PIX_FMT_YUV420P = 1;

    static {
        System.loadLibrary("st_mobile");
        System.loadLibrary("stmobile_jni");
    }

    public static native int stColorConvert(byte[] bArr, byte[] bArr2, int i, int i2, int i3);

    public static native int stImageRotate(byte[] bArr, byte[] bArr2, int i, int i2, int i3, int i4);

    public native void setBrowjumpThreshold(float f);

    public native void setEyeblinkThreshold(float f);

    public native void setHeadpitchThreshold(float f);

    public native void setHeadposeThreshold(float f);

    public native void setHeadyawThreshold(float f);

    public native void setMouthahThreshold(float f);

    public native void setSmoothThreshold(float f);
}
