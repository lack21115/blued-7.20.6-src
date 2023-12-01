package com.sensetime.stmobile;

import android.content.Context;
import android.content.res.AssetManager;
import com.sensetime.stmobile.model.STAnimalFace;
import com.sensetime.stmobile.model.STCondition;
import com.sensetime.stmobile.model.STHumanAction;
import com.sensetime.stmobile.model.STStickerInputParams;
import com.sensetime.stmobile.model.STTransParam;
import com.sensetime.stmobile.sticker_module_types.STModuleInfo;

/* loaded from: source-8303388-dex2jar.jar:com/sensetime/stmobile/STMobileStickerNative.class */
public class STMobileStickerNative {
    public static final int ST_INPUT_PARAM_CAMERA_QUATERNION = 1;
    public static final int ST_INPUT_PARAM_NONE = 0;
    public static final int ST_MOBILE_BROW_JUMP = 32;
    public static final int ST_MOBILE_EYE_BLINK = 2;
    public static final int ST_MOBILE_HEAD_PITCH = 16;
    public static final int ST_MOBILE_HEAD_YAW = 8;
    public static final int ST_MOBILE_MOUTH_AH = 4;
    private static final String TAG = STMobileStickerNative.class.getSimpleName();
    private static ItemCallback mCallback;
    private STSoundPlay mSoundPlay;
    private STStickerEvent mStickerEvent;
    private long nativeStickerHandle;

    /* loaded from: source-8303388-dex2jar.jar:com/sensetime/stmobile/STMobileStickerNative$ItemCallback.class */
    public interface ItemCallback {
        void processTextureCallback(String str, RenderStatus renderStatus);
    }

    /* loaded from: source-8303388-dex2jar.jar:com/sensetime/stmobile/STMobileStickerNative$RenderStatus.class */
    enum RenderStatus {
        ST_MATERIAL_BEGIN_RENDER(0),
        ST_MATERIAL_RENDERING(1),
        ST_MATERIAL_NO_RENDERING(2);
        
        private final int status;

        RenderStatus(int i) {
            this.status = i;
        }

        public static RenderStatus fromStatus(int i) {
            RenderStatus[] values = values();
            int length = values.length;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= length) {
                    return null;
                }
                RenderStatus renderStatus = values[i3];
                if (renderStatus.getStatus() == i) {
                    return renderStatus;
                }
                i2 = i3 + 1;
            }
        }

        public int getStatus() {
            return this.status;
        }
    }

    static {
        System.loadLibrary("st_mobile");
        System.loadLibrary("stmobile_jni");
    }

    private native int createInstanceNative();

    private native void destroyInstanceNative();

    public static void item_callback(String str, int i) {
        ItemCallback itemCallback = mCallback;
        if (itemCallback != null) {
            itemCallback.processTextureCallback(str, RenderStatus.fromStatus(i));
        }
    }

    public static void setCallback(ItemCallback itemCallback) {
        mCallback = itemCallback;
    }

    public native int addModuleTransition(int i, int i2, STCondition[] sTConditionArr, STTransParam[] sTTransParamArr, int[] iArr);

    public native int addSticker(String str);

    public native int addStickerFromAssetsFile(String str, AssetManager assetManager);

    public native int changeSticker(String str);

    public native int changeStickerFromAssetsFile(String str, AssetManager assetManager);

    public native int clearModuleTransition(int i);

    public int createInstance(Context context) {
        if (context != null) {
            this.mSoundPlay = STSoundPlay.getInstance(context);
        }
        int createInstanceNative = createInstanceNative();
        if (createInstanceNative == 0) {
            STStickerEvent.createInstance();
            this.mStickerEvent = STStickerEvent.getInstance();
        }
        return createInstanceNative;
    }

    public native int createModule(int i, int i2, int i3);

    public native int createSticker(int i);

    public void destroyInstance() {
        destroyInstanceNative();
        STSoundPlay sTSoundPlay = this.mSoundPlay;
        if (sTSoundPlay != null) {
            sTSoundPlay.release();
            this.mSoundPlay = null;
        }
    }

    public native long getAnimalDetectConfig();

    public native STModuleInfo[] getModules();

    public native int getNeededInputParams();

    public native int[] getPackageIds();

    public native int getParamInt(int i, int i2);

    public native long getTriggerAction();

    public native int moveModuleToPackage(int i, int i2);

    public native int processTexture(int i, STHumanAction sTHumanAction, int i2, int i3, int i4, int i5, boolean z, STStickerInputParams sTStickerInputParams, int i6);

    public native int processTextureAndOutputBuffer(int i, STHumanAction sTHumanAction, int i2, int i3, int i4, int i5, boolean z, STStickerInputParams sTStickerInputParams, int i6, int i7, byte[] bArr);

    public native int processTextureAndOutputBufferNative(int i, long j, int i2, int i3, int i4, int i5, boolean z, STStickerInputParams sTStickerInputParams, int i6, int i7, byte[] bArr);

    public native int processTextureBoth(int i, STHumanAction sTHumanAction, int i2, int i3, int i4, int i5, boolean z, STStickerInputParams sTStickerInputParams, STAnimalFace[] sTAnimalFaceArr, int i6, int i7);

    public native int processTextureBothNative(int i, long j, int i2, int i3, int i4, int i5, boolean z, STStickerInputParams sTStickerInputParams, STAnimalFace[] sTAnimalFaceArr, int i6, int i7);

    public native int processTextureNative(int i, long j, int i2, int i3, int i4, int i5, boolean z, STStickerInputParams sTStickerInputParams, int i6);

    public native void removeAllStickers();

    public native int removeModule(int i);

    public native int removeSticker(int i);

    public native int removeTransition(int i);

    public native int setMaxMemory(int i);

    public native int setParamBool(int i, int i2, boolean z);

    public native int setParamFloat(int i, int i2, boolean z);

    public native int setParamInt(int i, int i2, int i3);

    public native int setParamLong(int i, int i2, long j);

    public native int setParamStr(int i, int i2, String str);

    public native int setPerformanceHint(int i);

    public native int setSoundPlayDone(String str);

    public native int setWaitingMaterialLoaded(boolean z);

    public native int updateInternalMask(STHumanAction sTHumanAction, STHumanAction sTHumanAction2, int i, int i2, int i3);

    public native int updateInternalMaskNative(long j, long j2, int i, int i2, int i3);
}
