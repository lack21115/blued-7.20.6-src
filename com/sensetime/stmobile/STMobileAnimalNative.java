package com.sensetime.stmobile;

import android.content.res.AssetManager;
import com.sensetime.stmobile.model.STAnimalFace;

/* loaded from: source-8303388-dex2jar.jar:com/sensetime/stmobile/STMobileAnimalNative.class */
public class STMobileAnimalNative {
    public static final int ST_MOBILE_CAT_DETECT = 1;
    public static final int ST_MOBILE_DETECT_MODE_IMAGE = 262144;
    public static final int ST_MOBILE_DETECT_MODE_VIDEO = 131072;
    public static final int ST_MOBILE_DOG_DETECT = 16;
    private static final String TAG = STMobileAnimalNative.class.getSimpleName();
    private long nativeAnimalHandle;

    static {
        System.loadLibrary("st_mobile");
        System.loadLibrary("stmobile_jni");
    }

    public static native STAnimalFace[] animalMirror(int i, STAnimalFace[] sTAnimalFaceArr, int i2);

    public static native STAnimalFace[] animalResize(float f, STAnimalFace[] sTAnimalFaceArr, int i);

    public static native STAnimalFace[] animalRotate(int i, int i2, int i3, STAnimalFace[] sTAnimalFaceArr, int i4);

    public native int addSubModel(String str);

    public native int addSubModelFromAssetFile(String str, AssetManager assetManager);

    public native STAnimalFace[] animalDetect(byte[] bArr, int i, int i2, int i3, int i4, int i5);

    public native int createInstance(String str, int i);

    public native int createInstanceFromAssetFile(String str, int i, AssetManager assetManager);

    public native void destroyInstance();

    public native int reset();

    public native int setParam(int i, float f);
}
