package com.sensetime.stmobile;

import android.content.res.AssetManager;
import com.sensetime.stmobile.model.STImage;
import com.sensetime.stmobile.model.STMobile106;

/* loaded from: source-8303388-dex2jar.jar:com/sensetime/stmobile/STMobileFaceVerifyNative.class */
public class STMobileFaceVerifyNative {
    private long STMobileFaceVerifyNativeHandle;

    static {
        System.loadLibrary("st_mobile");
        System.loadLibrary("stmobile_jni");
    }

    public native int createInstance(String str);

    public native int createInstanceFromAssetFile(String str, AssetManager assetManager);

    public native void destroyInstance();

    public native byte[] getFeature(STImage sTImage, STMobile106 sTMobile106);

    public native float getFeaturesCompareScore(byte[] bArr, byte[] bArr2);
}
