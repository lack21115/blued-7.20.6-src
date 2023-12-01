package com.blued.android.module.external_sense_library.manager;

import android.content.Context;
import android.opengl.GLES20;
import com.blued.android.module.external_sense_library.gl.TextureProcessor;
import com.blued.android.module.external_sense_library.glutils.GlUtil;
import com.blued.android.module.external_sense_library.glutils.STUtils;
import com.blued.android.module.external_sense_library.utils.Accelerometer;
import com.blued.android.module.external_sense_library.utils.LogUtils;
import com.sensetime.stmobile.STCommonNative;
import com.sensetime.stmobile.STMobileHumanActionNative;
import com.sensetime.stmobile.model.STHumanAction;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/external_sense_library/manager/SenseTimeZegoFlashManger.class */
public class SenseTimeZegoFlashManger extends SenseTimeBaseManager {
    byte[] mNV21Data;

    public SenseTimeZegoFlashManger(Context context, boolean z) {
        super(context, z);
        init(false, STMobileHumanActionNative.ST_MOBILE_HUMAN_ACTION_DEFAULT_CONFIG_IMAGE);
    }

    private STHumanAction checkHumanActionDetectWithRGBA() {
        if (this.mIsCreateHumanActionHandleSucceeded) {
            if (this.mCameraChanging || this.mImageData == null || this.mImageData.length < this.mImageHeight * this.mImageWidth * 4) {
                LogUtils.c("Blued_Sense_SenseTimeManager", "checkHumanActionDetect() | mCameraChanging || mImageData == null || mImageData.length != mImageHeight * mImageWidth * 3 / 2", new Object[0]);
                return null;
            }
            synchronized (this.mImageDataLock) {
                if (this.mNV21Data == null || this.mNV21Data.length != ((this.mImageHeight * this.mImageWidth) * 3) / 2) {
                    this.mNV21Data = new byte[((this.mImageHeight * this.mImageWidth) * 3) / 2];
                }
                STCommonNative.stColorConvert(this.mImageData, this.mNV21Data, this.mImageWidth, this.mImageHeight, 42);
            }
            LogUtils.b("Blued_Sense_SenseTimeManager", "humanActionDetect() mImageHeight:" + this.mImageHeight + " | mImageWidth:" + this.mImageWidth, new Object[0]);
            StringBuilder sb = new StringBuilder();
            sb.append("humanActionDetect() getCurrentOrientation():");
            sb.append(getCurrentOrientation());
            LogUtils.b("Blued_Sense_SenseTimeManager", sb.toString(), new Object[0]);
            LogUtils.b("Blued_Sense_SenseTimeManager", "mDetectConfig: " + this.mDetectConfig, new Object[0]);
            LogUtils.b("Blued_Sense_SenseTimeManager", "detect imageData: " + this.mImageData.length, new Object[0]);
            return this.mSTHumanActionNative.humanActionDetect(this.mNV21Data, 3, this.mDetectConfig, getCurrentOrientation(), this.mImageWidth, this.mImageHeight);
        }
        return null;
    }

    @Override // com.blued.android.module.external_sense_library.contract.ISenseTimeProcessor
    public void adjustViewPort(int i, int i2) {
        com.blued.android.framework.utils.LogUtils.c("Blued_Sense_SenseTimeManager", "Blued_Sense_SenseTimeManageradjustViewPort() | width:" + i + " height:" + i2);
        if (this.mSurfaceWidth == i && this.mSurfaceHeight == i2) {
            return;
        }
        this.mSurfaceWidth = i;
        this.mSurfaceHeight = i2;
        if (this.mTextureProcessor == null) {
            this.mTextureProcessor = new TextureProcessor(0);
            this.mTextureProcessor.a();
        }
        this.mTextureProcessor.a(i, i2);
    }

    @Override // com.blued.android.module.external_sense_library.manager.SenseTimeBaseManager
    protected void checkTextureOutId() {
        if (this.mBeautifyTextureId == null) {
            this.mBeautifyTextureId = new int[1];
            GlUtil.a(this.mTexWidth, this.mTexHeight, this.mBeautifyTextureId, 3553);
        }
        if (this.mStickerTextureOutId == null) {
            this.mStickerTextureOutId = new int[1];
            GlUtil.a(this.mTexWidth, this.mTexHeight, this.mStickerTextureOutId, 3553);
        }
        if (this.mFilterTextureOutId == null) {
            this.mFilterTextureOutId = new int[1];
            GlUtil.a(this.mTexWidth, this.mTexHeight, this.mFilterTextureOutId, 3553);
        }
    }

    @Override // com.blued.android.module.external_sense_library.contract.ISenseTimeProcessor
    public int drawFrame(int i, int i2, int i3, boolean z) {
        checkTexture(i2, i3);
        this.mInputTextureId = i;
        if (this.mInputTextureId == 0) {
            return i;
        }
        if (this.mNeedBeautify || this.mNeedSticker || this.mNeedFaceAttribute) {
            STHumanAction checkHumanActionDetectWithRGBA = checkHumanActionDetectWithRGBA();
            if (checkHumanActionDetectWithRGBA == null) {
                LogUtils.c("Blued_Sense_SenseTimeManager", "checkHumanActionDetect() humanAction == null", new Object[0]);
                return i;
            }
            if (this.result == 0) {
                checkHumanActionDetectWithRGBA = this.mHumanActionBeautyOutput;
            }
            if (this.mCameraChanging) {
                return this.mInputTextureId;
            }
            this.mInputTextureId = onProcessTexture(this.mInputTextureId, this.mTexWidth, this.mTexHeight, getCurrentOrientation(), checkHumanActionDetectWithRGBA);
        }
        if (this.mOutputBuffer == null) {
            this.mOutputBuffer = new byte[i2 * i3 * 4];
        } else {
            int i4 = i2 * i3 * 4;
            if (this.mOutputBuffer.length != i4) {
                this.mOutputBuffer = new byte[i4];
            }
        }
        GLES20.glDisable(2929);
        return this.mInputTextureId;
    }

    @Override // com.blued.android.module.external_sense_library.manager.SenseTimeBaseManager, com.blued.android.module.external_sense_library.contract.ISenseTimeProcessor
    public void enableBeautify(boolean z) {
        this.mNeedBeautify = z;
        setHumanActionDetectConfig(this.mNeedBeautify | this.mNeedFaceAttribute, getStickerTriggerAction());
        setHumanActionDetectConfig(this.mNeedBeautify, getStickerTriggerAction());
    }

    @Override // com.blued.android.module.external_sense_library.manager.SenseTimeBaseManager
    protected int getCurrentOrientation() {
        Accelerometer.c();
        return 2;
    }

    @Override // com.blued.android.module.external_sense_library.manager.SenseTimeBaseManager
    protected byte[] getImgeData() {
        return this.mNV21Data;
    }

    @Override // com.blued.android.module.external_sense_library.contract.ISenseTimeProcessor
    public void handlePreviewFrame(byte[] bArr, int i, int i2, int i3) {
        this.mImageWidth = i;
        this.mImageHeight = i2;
        this.mImageRotation = i3;
        LogUtils.c("Blued_Sense_SenseTimeManager", "Blued_Sense_SenseTimeManager@@@ data:" + bArr.length + " | width:" + i + " | height:" + i2 + " | rotation:" + i3, new Object[0]);
        synchronized (this.mImageDataLock) {
            if (this.mImageData == null || this.mImageData.length != this.mImageHeight * this.mImageWidth * 4) {
                this.mImageData = new byte[this.mImageHeight * this.mImageWidth * 4];
            }
            if (bArr.length <= this.mImageData.length) {
                System.arraycopy((Object) bArr, 0, (Object) this.mImageData, 0, bArr.length);
            }
        }
        if (this.mNeedObject) {
            this.mProcessImageHandler.removeMessages(100);
            this.mProcessImageHandler.sendEmptyMessage(100);
        }
    }

    @Override // com.blued.android.module.external_sense_library.manager.SenseTimeBaseManager, com.blued.android.module.external_sense_library.contract.ISenseTimeProcessor
    public void onDestroy() {
        this.isActive = false;
        destorySTNative();
    }

    @Override // com.blued.android.module.external_sense_library.contract.ISenseTimeProcessor
    public void onPause() {
        LogUtils.c("Blued_Sense_SenseTimeManager", "onPause()", new Object[0]);
        synchronized (this.mImageDataLock) {
            this.mImageData = new byte[0];
        }
        this.mIsPaused = true;
    }

    @Override // com.blued.android.module.external_sense_library.contract.ISenseTimeProcessor
    public void onResume() {
        LogUtils.c("Blued_Sense_SenseTimeManager", "onResume()", new Object[0]);
        this.mIsPaused = false;
    }

    @Override // com.blued.android.module.external_sense_library.contract.ISenseTimeProcessor
    public void onStart() {
        LogUtils.c("Blued_Sense_SenseTimeManager", "onStart()", new Object[0]);
        this.isActive = true;
    }

    @Override // com.blued.android.module.external_sense_library.contract.ISenseTimeProcessor
    public void onStop() {
        LogUtils.c("Blued_Sense_SenseTimeManager", "onStop()", new Object[0]);
    }

    @Override // com.blued.android.module.external_sense_library.contract.ISenseTimeProcessor
    public void onSurfaceCreated() {
        initBeauty();
        initSticker();
        initFilter();
    }

    @Override // com.blued.android.module.external_sense_library.contract.ISenseTimeProcessor
    public void onSurfaceDestroyed() {
        deleteInternalTextures();
        onDestroySenseNative();
    }

    @Override // com.blued.android.module.external_sense_library.manager.SenseTimeBaseManager
    protected void setHumanActionDetectConfig(boolean z, long j) {
        if (z) {
            this.mDetectConfig = j | 1;
        } else {
            this.mDetectConfig = j;
        }
    }

    @Override // com.blued.android.module.external_sense_library.manager.SenseTimeBaseManager, com.blued.android.module.external_sense_library.contract.ISenseTimeProcessor
    public void setObjectTrackRect() {
        super.setObjectTrackRect();
        this.mTargetRect = STUtils.a(getIndexRect(), this.mSurfaceWidth, this.mSurfaceHeight, this.mImageWidth, this.mImageHeight);
    }
}
