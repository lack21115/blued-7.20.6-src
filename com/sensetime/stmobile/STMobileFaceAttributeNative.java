package com.sensetime.stmobile;

import android.content.res.AssetManager;
import com.sensetime.stmobile.model.STFaceAttribute;
import com.sensetime.stmobile.model.STMobile106;
import com.sensetime.stmobile.model.STMobileFaceInfo;

/* loaded from: source-8303388-dex2jar.jar:com/sensetime/stmobile/STMobileFaceAttributeNative.class */
public class STMobileFaceAttributeNative {
    private long nativeHandle;

    static {
        System.loadLibrary("st_mobile");
        System.loadLibrary("stmobile_jni");
    }

    public native int createInstance(String str);

    public native int createInstanceFromAssetFile(String str, AssetManager assetManager);

    public native void destroyInstance();

    public native int detect(byte[] bArr, int i, int i2, int i3, STMobile106[] sTMobile106Arr, STFaceAttribute[] sTFaceAttributeArr);

    public native int detect2(byte[] bArr, int i, int i2, int i3, STMobileFaceInfo[] sTMobileFaceInfoArr, STFaceAttribute[] sTFaceAttributeArr);

    public native int detect_ext(byte[] bArr, int i, int i2, int i3, STMobile106[] sTMobile106Arr, float[][] fArr);

    public native int detect_ext2(byte[] bArr, int i, int i2, int i3, STMobileFaceInfo[] sTMobileFaceInfoArr, float[][] fArr);
}
