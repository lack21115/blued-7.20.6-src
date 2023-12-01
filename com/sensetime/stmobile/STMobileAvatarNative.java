package com.sensetime.stmobile;

import android.content.res.AssetManager;
import com.sensetime.stmobile.model.STMobileFaceInfo;

/* loaded from: source-8303388-dex2jar.jar:com/sensetime/stmobile/STMobileAvatarNative.class */
public class STMobileAvatarNative {
    private long nativeAvatarHandle;

    static {
        System.loadLibrary("st_mobile");
        System.loadLibrary("stmobile_jni");
    }

    public native int avatarExpressionDetect(int i, int i2, int i3, STMobileFaceInfo sTMobileFaceInfo, float[] fArr);

    public native int createInstance(String str);

    public native int createInstanceFromAssetFile(String str, AssetManager assetManager);

    public native void destroyInstance();

    public native long getAvatarDetectConfig();
}
