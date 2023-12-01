package com.sensetime.stmobile;

import android.content.res.AssetManager;
import com.sensetime.stmobile.model.STAnimationTarget;
import com.sensetime.stmobile.model.STBoneTransform;
import com.sensetime.stmobile.model.STColor;
import com.sensetime.stmobile.model.STHumanAction;
import com.sensetime.stmobile.model.STPCController;
import com.sensetime.stmobile.model.STTransform;

/* loaded from: source-8303388-dex2jar.jar:com/sensetime/stmobile/STMobilePinchAvatarNative.class */
public class STMobilePinchAvatarNative {
    public static final int AVATAR_FEATURE_IDX_COUNT = 6;
    public static final int ST_MOBILE_GENAVATAR_ENABLE_RENDER = 1;
    public static final int ST_MOBILE_GENAVATAR_NONE = 0;
    private long nativeAvatarHandle;

    static {
        System.loadLibrary("st_mobile");
        System.loadLibrary("stmobile_jni");
    }

    public native int activeAvatar(int i);

    public native int addAsset(String str, int[] iArr);

    public native int addAssetFromAssetFile(String str, AssetManager assetManager, int[] iArr);

    public native int addAvatar(String str, int[] iArr);

    public native int addAvatarFromBuffer(String str, AssetManager assetManager, int[] iArr);

    public native int addFeature(String str, int[] iArr);

    public native int addFeatureFromAssetFile(String str, AssetManager assetManager, int[] iArr);

    public native int addMakeUp(String str, int[] iArr);

    public native int addMakeUpFromAssetFile(String str, AssetManager assetManager, int[] iArr);

    public native int autoPinchFace(int i, int i2, int i3, STHumanAction sTHumanAction, boolean z);

    public native STTransform[] calcStandardPose(int i, int i2, int i3, STHumanAction sTHumanAction, float f);

    public native int changeAnimation(int i, float f);

    public native int changeAssetColor(int i, STColor[] sTColorArr, int i2);

    public native int changeFeatureColor(int i, STColor sTColor);

    public native int changeMakeUpColor(int i, STColor sTColor);

    public native int changeSkinColor(STColor sTColor);

    public native int clearFeatures();

    public native int clearMakeUps();

    public native int cloneAvatar(int i, int[] iArr);

    public native int createInstance(int i);

    public native void destroyInstance();

    public native int exportPinchConfig(String str);

    public native int exportPinchConfigToBuffer(byte[] bArr, int i);

    public native int freezeFeatureDynamicBone(int i);

    public native int genFace(byte[] bArr, int i, int i2, int i3, int i4, STHumanAction sTHumanAction, boolean z, int i5);

    public native int genPinchFaceBlendShapeCount();

    public native int genPinchFaceBoneCount();

    public native int getActivedAvatarId(int[] iArr);

    public native int getAnimationClipCount();

    public native int getAutoPinchResult(int i, int i2, int i3, STHumanAction sTHumanAction, boolean z, int i4, STBoneTransform[] sTBoneTransformArr, int i5, float[] fArr, int i6, int[] iArr);

    public native long getDetectConfig();

    public native int getDisplayMode();

    public native int getEyebrowType();

    public native int getFaceExpression(int i, int i2, int i3, STHumanAction sTHumanAction, float[] fArr);

    public native int getFaceFeatures(int i);

    public native int getFacingMode();

    public native int getPinchConfigBufferLength(int[] iArr, int i);

    public native int loadAnimationClip(String str, int[] iArr);

    public native int loadAnimationClipFromAssetsFile(String str, AssetManager assetManager, int[] iArr);

    public native int loadBasePackage(String str, int[] iArr);

    public native int loadBasePackageFromAssetFile(String str, AssetManager assetManager, int[] iArr);

    public native int loadGenfaceConfig(String str, String str2, String str3);

    public native int loadGenfaceConfigFromBuffer(AssetManager assetManager, String str, String str2, String str3);

    public native int loadPinchConfig(String str);

    public native int loadPinchConfigFromAsset(String str, AssetManager assetManager, int i);

    public native int loadPinchConfigFromBuffer(byte[] bArr, int i, int i2);

    public native int lockFaceFittingCamera(boolean z);

    public native int playAnimationStack(STAnimationTarget[] sTAnimationTargetArr);

    public native int processTexture(STMobileHumanActionNative sTMobileHumanActionNative, int i, int i2, int i3, int i4, STHumanAction sTHumanAction, int i5);

    public native int processTexture2(long j, long j2, int i, int i2, int i3, int i4, int i5);

    public native int removeAllAsset();

    public native int removeAsset(int i);

    public native int removeAvatar(int i);

    public native int removeBackground(int i);

    public native int removeFeature(int i);

    public native int removeMakeUp(int i);

    public native void resetBodyPose();

    public native int resetFacePose(int i);

    public native int resetGenFace(int i);

    public native int rotate(float f);

    public native int rotateAvatar(float f);

    public native int scaleAvatar(float[] fArr);

    public native int setAvatarVisiable(boolean z);

    public native int setBackgroundColor(STColor sTColor);

    public native int setBackgroundFromBuffer(byte[] bArr, int i, int[] iArr);

    public native int setBackgroundFromPath(String str, int[] iArr);

    public native int setCameraLookAt(float[] fArr, float[] fArr2, float[] fArr3, float f);

    public native int setCameraOrthogonal(float f, float f2, float f3, float f4, float f5, float f6);

    public native int setCameraPerspective(float f, float f2, float f3, float f4);

    public native int setDisplayMode(int i);

    public native int setFacingMode(int i);

    public native int setFeatureVisiable(int i, boolean z);

    public native int setFittingScale(int i, float f);

    public native int setUpbodyIkEnabled(boolean z);

    public native void stopAnimation();

    public native int translateAvatar(float[] fArr);

    public native int unloadAnimationClip(int i);

    public native int unloadGenfaceConfig();

    public native int updateBoneControllerInfo(STPCController[] sTPCControllerArr, int i);
}
