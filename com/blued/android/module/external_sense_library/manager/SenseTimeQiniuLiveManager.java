package com.blued.android.module.external_sense_library.manager;

import android.app.Activity;
import android.content.Context;
import android.opengl.GLES20;
import android.text.TextUtils;
import com.blued.android.module.external_sense_library.contract.IGetBufferCallback;
import com.blued.android.module.external_sense_library.display.STGLRender;
import com.blued.android.module.external_sense_library.gl.TextureProcessor;
import com.blued.android.module.external_sense_library.glutils.GlUtil;
import com.blued.android.module.external_sense_library.utils.Accelerometer;
import com.blued.android.module.external_sense_library.utils.AppLogger;
import com.blued.android.module.external_sense_library.utils.LogUtils;
import com.sensetime.stmobile.model.STHumanAction;
import javax.microedition.khronos.opengles.GL10;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/external_sense_library/manager/SenseTimeQiniuLiveManager.class */
public class SenseTimeQiniuLiveManager extends SenseTimeBaseManager {
    private static final String DRAW_FRAME_TAG = "Blued_Sense_DrawFrame";
    private static final String TAG = "Blued_Sense_SenseTimeManager";
    private volatile boolean mCameraChanging;

    public SenseTimeQiniuLiveManager(Context context) {
        this(context, true);
    }

    public SenseTimeQiniuLiveManager(Context context, boolean z) {
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
        AppLogger a = AppLogger.a();
        a.a("Blued_Sense_SenseTimeManageradjustViewPort() | width:" + i + " height:" + i2, new Object[0]);
        if (this.mSurfaceWidth == i && this.mSurfaceHeight == i2) {
            return;
        }
        this.mSurfaceWidth = i;
        this.mSurfaceHeight = i2;
        if (this.mSTGLRender != null) {
            this.mSTGLRender.init(i, i2);
        }
        this.mTextureProcessorFront.a(this.mSurfaceWidth, this.mSurfaceHeight);
        this.mTextureProcessorBack.a(this.mSurfaceWidth, this.mSurfaceHeight);
    }

    @Override // com.blued.android.module.external_sense_library.manager.SenseTimeBaseManager
    protected void checkTextureOutId() {
        if (this.mBeautifyTextureId == null) {
            this.mBeautifyTextureId = new int[1];
            GlUtil.a(this.mTexHeight, this.mTexWidth, this.mBeautifyTextureId, GL10.GL_TEXTURE_2D);
        }
        if (this.mStickerTextureOutId == null) {
            this.mStickerTextureOutId = new int[1];
            GlUtil.a(this.mTexHeight, this.mTexWidth, this.mStickerTextureOutId, GL10.GL_TEXTURE_2D);
        }
    }

    @Override // com.blued.android.module.external_sense_library.contract.ISenseTimeProcessor
    public int drawFrame(int i, int i2, int i3, boolean z) {
        checkTexture(i2, i3);
        System.currentTimeMillis();
        this.mInputTextureId = this.mSTGLRender.preProcess(i, null);
        if (this.mInputTextureId == 0) {
            return i;
        }
        if (this.mNeedBeautify || this.mNeedSticker || this.mNeedFaceAttribute) {
            STHumanAction checkHumanActionDetect = checkHumanActionDetect();
            if (checkHumanActionDetect == null) {
                LogUtils.c(DRAW_FRAME_TAG, "checkHumanActionDetect() humanAction == null", new Object[0]);
                long currentTimeMillis = System.currentTimeMillis();
                if (this.mCameraID == 1) {
                    if (this.mTextureProcessorFront != null) {
                        this.mInputTextureId = this.mTextureProcessorFront.a(this.mInputTextureId, (IGetBufferCallback) null);
                        LogUtils.c(DRAW_FRAME_TAG, "mTextureProcessorFront.draw() | cost time: " + (System.currentTimeMillis() - currentTimeMillis), new Object[0]);
                    }
                } else if (this.mTextureProcessorBack != null) {
                    this.mInputTextureId = this.mTextureProcessorBack.a(this.mInputTextureId);
                    LogUtils.c(DRAW_FRAME_TAG, "mTextureProcessorBack.draw() | cost time: " + (System.currentTimeMillis() - currentTimeMillis), new Object[0]);
                }
                return this.mInputTextureId;
            }
            int currentOrientation = getCurrentOrientation();
            LogUtils.b(TAG, "shortVideoDrawFrame() getCurrentOrientation():" + getCurrentOrientation(), new Object[0]);
            if (this.result == 0) {
                checkHumanActionDetect = this.mHumanActionBeautyOutput;
            }
            if (this.mCameraChanging) {
                return this.mInputTextureId;
            }
            this.mInputTextureId = onProcessTexture(this.mInputTextureId, this.mTexHeight, this.mTexWidth, currentOrientation, checkHumanActionDetect);
        }
        if (this.mOutputBuffer == null) {
            this.mOutputBuffer = new byte[((i2 * i3) * 3) / 2];
        } else {
            int i4 = ((i2 * i3) * 3) / 2;
            if (this.mOutputBuffer.length != i4) {
                this.mOutputBuffer = new byte[i4];
            }
        }
        if (this.mCameraID == 1) {
            if (this.mTextureProcessorFront != null) {
                this.mInputTextureId = this.mTextureProcessorFront.a(this.mInputTextureId);
            }
        } else if (this.mTextureProcessorBack != null) {
            this.mInputTextureId = this.mTextureProcessorBack.a(this.mInputTextureId);
        }
        if (!this.mNeedFilter && this.mTextureProcessor != null) {
            this.mTextureProcessor.a(i2, i3);
            this.mTextureProcessor.a(this.mInputTextureId, this);
        }
        if (this.mOutputBuffer == null) {
            this.mOutputBuffer = new byte[((i2 * i3) * 3) / 2];
        } else {
            int i5 = ((i2 * i3) * 3) / 2;
            if (this.mOutputBuffer.length != i5) {
                this.mOutputBuffer = new byte[i5];
            }
        }
        GLES20.glDisable(GL10.GL_DEPTH_TEST);
        return this.mInputTextureId;
    }

    @Override // com.blued.android.module.external_sense_library.manager.SenseTimeBaseManager, com.blued.android.module.external_sense_library.contract.ISenseTimeProcessor
    public void enableBeautify(boolean z) {
        this.mNeedBeautify = z;
        setHumanActionDetectConfig(this.mNeedBeautify | this.mNeedFaceAttribute, getStickerTriggerAction());
    }

    @Override // com.blued.android.module.external_sense_library.manager.SenseTimeBaseManager
    protected int getCurrentOrientation() {
        int c = Accelerometer.c();
        int i = c - 1;
        int i2 = i;
        if (i < 0) {
            i2 = c ^ 3;
        }
        return i2;
    }

    @Override // com.blued.android.module.external_sense_library.contract.ISenseTimeProcessor
    public void handlePreviewFrame(byte[] bArr, int i, int i2, int i3) {
        this.mImageWidth = i2;
        this.mImageHeight = i;
        this.mImageRotation = i3;
        AppLogger a = AppLogger.a();
        a.a("Blued_Sense_SenseTimeManager@@@ data:" + bArr.length + " | width:" + i + " | height:" + i2 + " | rotation:" + i3, new Object[0]);
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
        if (this.mStickerMaps != null) {
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
        this.mSurfaceWidth = 0;
        this.mSurfaceHeight = 0;
        if (this.mSTGLRender != null) {
            this.mSTGLRender.destroy();
            this.mSTGLRender = null;
        }
        deleteInternalTextures();
        this.mRGBABuffer = null;
        if (this.mTextureProcessorFront != null) {
            this.mTextureProcessorFront.b();
            this.mTextureProcessorFront = null;
        }
        if (this.mTextureProcessorBack != null) {
            this.mTextureProcessorBack.b();
            this.mTextureProcessorBack = null;
        }
        if (this.mTextureProcessor != null) {
            this.mTextureProcessor.b();
            this.mTextureProcessor = null;
        }
        this.mSTGLRender = new STGLRender();
        this.mSTGLRender.adjustTextureBuffer(0, isFlipHorizontal(), false);
        if (this.mTextureProcessorFront == null) {
            this.mTextureProcessorFront = new TextureProcessor(2);
            this.mTextureProcessorFront.a();
        }
        if (this.mTextureProcessorBack == null) {
            this.mTextureProcessorBack = new TextureProcessor(1);
            this.mTextureProcessorBack.a();
        }
        if (this.mTextureProcessor == null) {
            this.mTextureProcessor = new TextureProcessor(0);
            this.mTextureProcessor.a();
        }
        initBeauty();
        initSticker();
        initFilter();
    }

    @Override // com.blued.android.module.external_sense_library.contract.ISenseTimeProcessor
    public void onSurfaceDestroyed() {
        LogUtils.c(TAG, "onSurfaceDestroyed()", new Object[0]);
        deleteInternalTextures();
        onDestroySenseNative();
        this.mSurfaceWidth = 0;
        this.mSurfaceHeight = 0;
        if (this.mSTGLRender != null) {
            this.mSTGLRender.destroy();
        }
        if (this.mTextureProcessorFront != null) {
            this.mTextureProcessorFront.b();
            this.mTextureProcessorFront = null;
        }
        if (this.mTextureProcessorBack != null) {
            this.mTextureProcessorBack.b();
            this.mTextureProcessorBack = null;
        }
        if (this.mTextureProcessor != null) {
            this.mTextureProcessor.b();
            this.mTextureProcessor = null;
        }
    }

    @Override // com.blued.android.module.external_sense_library.manager.SenseTimeBaseManager
    protected void setHumanActionDetectConfig(boolean z, long j) {
        if (!this.mNeedSticker || this.mCurrentStickerModel == null || TextUtils.isEmpty(this.mCurrentStickerModel.localPath)) {
            j = 0;
        }
        if (z) {
            this.mDetectConfig = j | 1 | 4 | 71468272516864L;
        } else {
            this.mDetectConfig = j;
        }
    }
}
