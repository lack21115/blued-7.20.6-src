package com.sensetime.stmobile;

import android.content.res.AssetManager;
import com.sensetime.stmobile.model.STAttributeFaceFeature;
import com.sensetime.stmobile.model.STMobileFaceInfo;

/* loaded from: source-8303388-dex2jar.jar:com/sensetime/stmobile/STMobileAttributeFaceFeatureNative.class */
public class STMobileAttributeFaceFeatureNative {
    private static final String TAG = STMobileAttributeFaceFeatureNative.class.getSimpleName();
    private long nativeAttributeFaceFeatureHandle;

    static {
        System.loadLibrary("st_mobile");
        System.loadLibrary("stmobile_jni");
    }

    public native int addSubModel(String str);

    public native int addSubModelFromAssetFile(String str, AssetManager assetManager);

    public native int createInstance(String str);

    public native int createInstanceFromAssetFile(String str, AssetManager assetManager);

    public native int createInstanceWithSubModels(String[] strArr, int i);

    public native void destroyInstance();

    public native STAttributeFaceFeature faceFeaturesDetect(STMobileFaceInfo sTMobileFaceInfo, int i, int i2, byte[] bArr, int i3, long j, int i4, int i5, int i6);

    public native int removeSubModelByConfig(int i);
}
