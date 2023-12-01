package com.blued.android.module.external_sense_library.manager;

import android.app.Activity;
import android.content.Context;
import android.opengl.GLES20;
import android.text.TextUtils;
import com.blued.android.module.external_sense_library.glutils.GlUtil;
import com.blued.android.module.external_sense_library.utils.Accelerometer;
import com.blued.android.module.external_sense_library.utils.AppLogger;
import com.blued.android.module.external_sense_library.utils.LogUtils;
import com.sensetime.stmobile.STMobileHumanActionNative;
import com.sensetime.stmobile.model.STHumanAction;
import java.nio.ByteBuffer;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/external_sense_library/manager/SenseTimeQiniuEditVideoManager.class */
public class SenseTimeQiniuEditVideoManager extends SenseTimeBaseManager {
    private static final String DRAW_FRAME_TAG = "Blued_Sense_DrawFrame";
    private static final String TAG = "Blued_Sense_SenseTimeManager";
    private volatile boolean mCameraChanging;

    public SenseTimeQiniuEditVideoManager(Context context) {
        this(context, true);
    }

    public SenseTimeQiniuEditVideoManager(Context context, boolean z) {
        super(context, z);
        this.mCameraChanging = false;
        init();
    }

    private STHumanAction checkHumanActionDetect() {
        if (!this.mIsCreateHumanActionHandleSucceeded || this.mCameraChanging || this.mImageData == null || this.mImageData.length <= 0) {
            return null;
        }
        synchronized (this.mImageDataLock) {
            if (this.mNv21ImageData == null || this.mNv21ImageData.length != ((this.mImageHeight * this.mImageWidth) * 3) / 2) {
                this.mNv21ImageData = new byte[((this.mImageHeight * this.mImageWidth) * 3) / 2];
            }
            if (this.mImageData != null && this.mNv21ImageData.length >= this.mImageData.length) {
                System.arraycopy((Object) this.mImageData, 0, (Object) this.mNv21ImageData, 0, this.mImageData.length);
            }
        }
        if (((this.mImageHeight * this.mImageWidth) * 3) / 2 > this.mNv21ImageData.length) {
            return null;
        }
        return STHumanAction.humanActionRotateAndMirror(humanActionDetect(this.mNv21ImageData), this.mImageWidth, this.mImageHeight, this.mCameraID, this.mImageRotation, Accelerometer.c());
    }

    @Override // com.blued.android.module.external_sense_library.contract.ISenseTimeProcessor
    public void adjustViewPort(int i, int i2) {
        AppLogger a2 = AppLogger.a();
        a2.a("Blued_Sense_SenseTimeManageradjustViewPort() | width:" + i + " height:" + i2, new Object[0]);
        if (this.mSurfaceWidth == i && this.mSurfaceHeight == i2) {
            return;
        }
        this.mSurfaceWidth = i;
        this.mSurfaceHeight = i2;
    }

    @Override // com.blued.android.module.external_sense_library.manager.SenseTimeBaseManager
    protected void checkTextureOutId() {
        if (this.mBeautifyTextureId == null) {
            this.mBeautifyTextureId = new int[1];
            GlUtil.a(this.mTexHeight, this.mTexWidth, this.mBeautifyTextureId, 3553);
        }
        if (this.mStickerTextureOutId == null) {
            this.mStickerTextureOutId = new int[1];
            GlUtil.a(this.mTexHeight, this.mTexWidth, this.mStickerTextureOutId, 3553);
        }
    }

    @Override // com.blued.android.module.external_sense_library.contract.ISenseTimeProcessor
    public int drawFrame(int i, int i2, int i3, boolean z) {
        checkTexture(i2, i3);
        this.mInputTextureId = i;
        if (this.mRGBABuffer == null) {
            this.mRGBABuffer = ByteBuffer.allocate(this.mTexWidth * this.mTexHeight * 4);
        }
        this.mRGBABuffer.rewind();
        GLES20.glReadPixels(0, 0, this.mTexWidth, this.mTexHeight, 6408, 5121, this.mRGBABuffer);
        if (this.mOutputBuffer == null) {
            this.mOutputBuffer = new byte[((i2 * i3) * 3) / 2];
        } else {
            int i4 = ((i2 * i3) * 3) / 2;
            if (this.mOutputBuffer.length != i4) {
                this.mOutputBuffer = new byte[i4];
            }
        }
        this.mInputTextureId = onProcessTexture(this.mInputTextureId, this.mTexHeight, this.mTexWidth, getCurrentOrientation(), null);
        GLES20.glDisable(2929);
        return this.mInputTextureId;
    }

    @Override // com.blued.android.module.external_sense_library.manager.SenseTimeBaseManager, com.blued.android.module.external_sense_library.contract.ISenseTimeProcessor
    public void enableBeautify(boolean z) {
    }

    @Override // com.blued.android.module.external_sense_library.manager.SenseTimeBaseManager, com.blued.android.module.external_sense_library.contract.ISenseTimeProcessor
    public void enableSticker(boolean z) {
    }

    @Override // com.blued.android.module.external_sense_library.manager.SenseTimeBaseManager
    protected int getCurrentOrientation() {
        int c2 = Accelerometer.c();
        int i = c2 - 1;
        int i2 = i;
        if (i < 0) {
            i2 = c2 ^ 3;
        }
        return i2;
    }

    @Override // com.blued.android.module.external_sense_library.contract.ISenseTimeProcessor
    public void handlePreviewFrame(byte[] bArr, int i, int i2, int i3) {
        this.mImageWidth = i2;
        this.mImageHeight = i;
        this.mImageRotation = i3;
        AppLogger a2 = AppLogger.a();
        a2.a("Blued_Sense_SenseTimeManager@@@ data:" + bArr.length + " | width:" + i + " | height:" + i2 + " | rotation:" + i3, new Object[0]);
        synchronized (this.mImageDataLock) {
            if (this.mImageData == null || this.mImageData.length != ((this.mImageHeight * this.mImageWidth) * 3) / 2) {
                this.mImageData = new byte[((this.mImageWidth * this.mImageHeight) * 3) / 2];
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

    protected STHumanAction humanActionDetect(byte[] bArr) {
        LogUtils.b(TAG, "humanActionDetect() mImageHeight:" + this.mImageHeight + " | mImageWidth:" + this.mImageWidth, new Object[0]);
        StringBuilder sb = new StringBuilder();
        sb.append("humanActionDetect() getHumanActionOrientation():");
        sb.append(getHumanActionOrientation());
        LogUtils.b(TAG, sb.toString(), new Object[0]);
        return this.mSTHumanActionNative.humanActionDetect(bArr, 3, this.mDetectConfig, getHumanActionOrientation(), this.mImageHeight, this.mImageWidth);
    }

    @Override // com.blued.android.module.external_sense_library.manager.SenseTimeBaseManager, com.blued.android.module.external_sense_library.contract.ISenseTimeProcessor
    public void onDestroy() {
        LogUtils.c(TAG, "onDestroy()", new Object[0]);
        this.isActive = false;
        destorySTNative();
        if (this.isUseSensor && this.mStickerMaps != null) {
            this.mStickerMaps.clear();
            this.mStickerMaps = null;
        }
        if (this.mContext == null || ((Activity) this.mContext).isFinishing()) {
            StickerDataManager.clearData();
        }
    }

    @Override // com.blued.android.module.external_sense_library.contract.ISenseTimeProcessor
    public void onPause() {
        LogUtils.c(TAG, "onPause()", new Object[0]);
        synchronized (this.mImageDataLock) {
            if (this.mImageData != null) {
                this.mImageData = new byte[0];
            }
        }
        this.mIsPaused = true;
        if (!this.isUseSensor || this.mSensorManager == null) {
            return;
        }
        this.mSensorManager.unregisterListener(this);
    }

    @Override // com.blued.android.module.external_sense_library.contract.ISenseTimeProcessor
    public void onResume() {
        LogUtils.c(TAG, "onResume()", new Object[0]);
        this.mIsPaused = false;
        if (this.isUseSensor) {
            registerSensorListener();
        }
    }

    @Override // com.blued.android.module.external_sense_library.contract.ISenseTimeProcessor
    public void onStart() {
        LogUtils.c(TAG, "onStart()", new Object[0]);
        this.isActive = true;
        if (!this.isUseSensor || this.mAccelerometer == null) {
            return;
        }
        this.mAccelerometer.a();
    }

    @Override // com.blued.android.module.external_sense_library.contract.ISenseTimeProcessor
    public void onStop() {
        LogUtils.c(TAG, "onStop()", new Object[0]);
        if (!this.isUseSensor || this.mAccelerometer == null) {
            return;
        }
        this.mAccelerometer.b();
    }

    @Override // com.blued.android.module.external_sense_library.contract.ISenseTimeProcessor
    public void onSurfaceCreated() {
        LogUtils.c(TAG, "onSurfaceCreated()", new Object[0]);
        initFilter();
    }

    @Override // com.blued.android.module.external_sense_library.contract.ISenseTimeProcessor
    public void onSurfaceDestroyed() {
        LogUtils.c(TAG, "onSurfaceDestroyed()", new Object[0]);
        deleteInternalTextures();
        onDestroySenseNative();
    }

    @Override // com.blued.android.module.external_sense_library.manager.SenseTimeBaseManager, com.blued.android.module.external_sense_library.contract.ISenseTimeProcessor
    public void setCameraFacing(boolean z) {
    }

    @Override // com.blued.android.module.external_sense_library.manager.SenseTimeBaseManager
    protected void setHumanActionDetectConfig(boolean z, long j) {
        if (!this.mNeedSticker || this.mCurrentStickerModel == null || TextUtils.isEmpty(this.mCurrentStickerModel.localPath)) {
            j = 0;
        }
        if (z) {
            this.mDetectConfig = j | 1 | 4 | STMobileHumanActionNative.ST_MOBILE_HAND_DETECT_FULL;
        } else {
            this.mDetectConfig = j;
        }
    }

    @Override // com.blued.android.module.external_sense_library.manager.SenseTimeBaseManager, com.blued.android.module.external_sense_library.contract.ISenseTimeProcessor
    public void switchCamera() {
    }
}
