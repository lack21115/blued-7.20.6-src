package com.sensetime.stmobile;

import com.sensetime.stmobile.model.STClassifierResult;
import com.sensetime.stmobile.model.STImage;

/* loaded from: source-8303388-dex2jar.jar:com/sensetime/stmobile/STMobileClassifyNative.class */
public class STMobileClassifyNative {
    private static final String TAG = STMobileClassifyNative.class.getSimpleName();
    private long nativeClassifyHandle;

    static {
        System.loadLibrary("st_mobile");
        System.loadLibrary("stmobile_jni");
    }

    public native STClassifierResult[] classify(STImage sTImage, int i);

    public native int createInstance(String str, String str2, String str3);

    public native void destroyInstance();
}
