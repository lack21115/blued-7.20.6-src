package com.tencent.liteav.live;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Surface;
import com.tencent.liteav.audio.TXAudioEffectManager;
import com.tencent.liteav.audio.TXAudioEffectManagerImpl;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.beauty.TXBeautyManager;
import com.tencent.liteav.beauty.TXBeautyManagerImpl;
import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videobase.frame.PixelFrame;
import com.tencent.liteav.videobase.videobase.DisplayTarget;
import com.tencent.rtmp.ITXLivePushListener;
import com.tencent.rtmp.TXLivePushConfig;
import com.tencent.rtmp.TXLivePusher;
import com.tencent.rtmp.b;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.ugc.TXRecordCommon;
import java.lang.ref.WeakReference;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLContext;

@JNINamespace("liteav")
/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/live/TXLivePusherJni.class */
public class TXLivePusherJni implements ITXLivePushListener, TXLivePusher.AudioCustomProcessListener, TXLivePusher.ITXAudioVolumeEvaluationListener, TXLivePusher.ITXSnapshotListener, TXLivePusher.OnBGMNotify, TXLivePusher.VideoCustomProcessListener, b, TXCloudVideoView.b {
    private TXLivePusher.AudioCustomProcessListener mAudioCustomProcessListener;
    private TXAudioEffectManager mAudioEffectManager;
    private TXBeautyManager mBeautyManager;
    private TXLivePushConfig mConfig;
    private TXLivePusher.ITXAudioVolumeEvaluationListener mITXAudioVolumeEvaluationListener;
    private ITXLivePushListener mITXLivePushListener;
    private TXLivePusher.ITXSnapshotListener mITXSnapshotListener;
    private TXRecordCommon.ITXVideoRecordListener mITXVideoRecordListener;
    private long mNativeTXLivePusherJni;
    private TXLivePusher.OnBGMNotify mOnBGMNotify;
    private Surface mSurface;
    private TXLivePusher.VideoCustomProcessListener mVideoCustomProcessListener;
    private int mVideoQuality = -1;
    private int mSurfaceWidth = -1;
    private int mSurfaceHeight = -1;

    public TXLivePusherJni(Context context) {
        this.mNativeTXLivePusherJni = 0L;
        ContextUtils.initApplicationContext(context.getApplicationContext());
        ContextUtils.setDataDirectorySuffix("liteav");
        this.mConfig = new TXLivePushConfig();
        long nativeCreate = nativeCreate(new WeakReference(this));
        this.mNativeTXLivePusherJni = nativeCreate;
        this.mAudioEffectManager = new TXAudioEffectManagerImpl(nativeCreateAudioEffectManager(nativeCreate));
        this.mBeautyManager = new TXBeautyManagerImpl(nativeCreateBeautyManager(this.mNativeTXLivePusherJni));
    }

    private static native void nativeCallExperimentalAPI(long j, String str);

    private static native long nativeCreate(WeakReference<TXLivePusherJni> weakReference);

    private static native long nativeCreateAudioEffectManager(long j);

    private static native long nativeCreateBeautyManager(long j);

    private static native void nativeDestroy(long j);

    private static native void nativeEnableAudioVolumeEvaluation(long j, int i);

    private static native int nativeGetMaxZoom(long j);

    private static native int nativeGetMusicDuration(long j, String str);

    private static native boolean nativeIsPushing(long j);

    private static native void nativeOnLogRecord(long j, String str);

    private static native boolean nativePauseBGM(long j);

    private static native void nativePausePusher(long j);

    private static native boolean nativePlayBGM(long j, String str);

    private static native boolean nativeResumeBGM(long j);

    private static native void nativeResumePusher(long j);

    private static native void nativeSendCustomPCMData(long j, byte[] bArr);

    private static native void nativeSendCustomVideoFrame(long j, PixelFrame pixelFrame);

    private static native void nativeSendMessage(long j, byte[] bArr);

    private static native boolean nativeSendMessageEx(long j, byte[] bArr);

    private static native void nativeSetAudioConfig(long j, int i, int i2, int i3, boolean z, boolean z2);

    private static native void nativeSetBGMPitch(long j, float f);

    private static native boolean nativeSetBGMPosition(long j, int i);

    private static native boolean nativeSetBGMVolume(long j, float f);

    private static native boolean nativeSetBeautyFilter(long j, int i, int i2, int i3, int i4);

    private static native void nativeSetCaptureConfig(long j, int i, int i2, Bitmap bitmap, int i3, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, int i4);

    private static native void nativeSetEncoderConfig(long j, int i, int i2, boolean z, int i3, int i4, int i5, int i6, int i7, boolean z2, int i8, boolean z3);

    private static native void nativeSetExposureCompensation(long j, float f);

    private static native void nativeSetFilter(long j, Bitmap bitmap);

    private static native void nativeSetFocusPosition(long j, float f, float f2);

    private static native boolean nativeSetMicVolume(long j, float f);

    private static native boolean nativeSetMirror(long j, boolean z);

    private static native void nativeSetMute(long j, boolean z);

    private static native void nativeSetNetworkConfig(long j, int i, boolean z, int i2, int i3, int i4);

    private static native void nativeSetRenderRotation(long j, int i);

    private static native void nativeSetReverb(long j, int i);

    private static native void nativeSetSpecialRatio(long j, float f);

    private static native void nativeSetView(long j, DisplayTarget displayTarget);

    private static native void nativeSetVoiceChangerType(long j, int i);

    private static native void nativeSetWaterMark(long j, Bitmap bitmap, float f, float f2, float f3);

    private static native boolean nativeSetZoom(long j, int i);

    private static native void nativeShowDebugView(long j, boolean z);

    private static native void nativeSnapshot(long j);

    private static native void nativeStartCamera(long j);

    private static native int nativeStartPusher(long j, String str);

    private static native int nativeStartRecord(long j, String str);

    private static native void nativeStartScreenCapture(long j);

    private static native boolean nativeStopBGM(long j);

    private static native void nativeStopCameraPreview(long j, boolean z);

    private static native void nativeStopPusher(long j);

    private static native void nativeStopRecord(long j);

    private static native void nativeStopScreenCapture(long j);

    private static native void nativeSwitchCamera(long j);

    private static native boolean nativeTurnOnFlashLight(long j, boolean z);

    public static TXLivePusherJni weakToStrongReference(WeakReference<TXLivePusherJni> weakReference) {
        return weakReference.get();
    }

    @Override // com.tencent.rtmp.b
    public void callExperimentalAPI(String str) {
        nativeCallExperimentalAPI(this.mNativeTXLivePusherJni, str);
    }

    @Override // com.tencent.rtmp.b
    public void enableAudioVolumeEvaluation(int i) {
        nativeEnableAudioVolumeEvaluation(this.mNativeTXLivePusherJni, i);
    }

    protected void finalize() throws Throwable {
        super.finalize();
        release();
    }

    @Override // com.tencent.rtmp.b
    public TXAudioEffectManager getAudioEffectManager() {
        return this.mAudioEffectManager;
    }

    @Override // com.tencent.rtmp.b
    public TXBeautyManager getBeautyManager() {
        return this.mBeautyManager;
    }

    @Override // com.tencent.rtmp.b
    public TXLivePushConfig getConfig() {
        return this.mConfig;
    }

    @Override // com.tencent.rtmp.b
    public int getMaxZoom() {
        return nativeGetMaxZoom(this.mNativeTXLivePusherJni);
    }

    @Override // com.tencent.rtmp.b
    public int getMusicDuration(String str) {
        return nativeGetMusicDuration(this.mNativeTXLivePusherJni, str);
    }

    @Override // com.tencent.rtmp.b
    public boolean isPushing() {
        return nativeIsPushing(this.mNativeTXLivePusherJni);
    }

    @Override // com.tencent.rtmp.TXLivePusher.ITXAudioVolumeEvaluationListener
    public void onAudioVolumeEvaluationNotify(int i) {
        TXLivePusher.ITXAudioVolumeEvaluationListener iTXAudioVolumeEvaluationListener = this.mITXAudioVolumeEvaluationListener;
        if (iTXAudioVolumeEvaluationListener != null) {
            iTXAudioVolumeEvaluationListener.onAudioVolumeEvaluationNotify(i);
        }
    }

    @Override // com.tencent.rtmp.TXLivePusher.OnBGMNotify
    public void onBGMComplete(int i) {
        TXLivePusher.OnBGMNotify onBGMNotify = this.mOnBGMNotify;
        if (onBGMNotify != null) {
            onBGMNotify.onBGMComplete(i);
        }
    }

    @Override // com.tencent.rtmp.TXLivePusher.OnBGMNotify
    public void onBGMProgress(long j, long j2) {
        TXLivePusher.OnBGMNotify onBGMNotify = this.mOnBGMNotify;
        if (onBGMNotify != null) {
            onBGMNotify.onBGMProgress(j, j2);
        }
    }

    @Override // com.tencent.rtmp.TXLivePusher.OnBGMNotify
    public void onBGMStart() {
        TXLivePusher.OnBGMNotify onBGMNotify = this.mOnBGMNotify;
        if (onBGMNotify != null) {
            onBGMNotify.onBGMStart();
        }
    }

    public boolean onCustomPreprocessFrame(PixelFrame pixelFrame, PixelFrame pixelFrame2) {
        int onTextureCustomProcess = onTextureCustomProcess(pixelFrame.getTextureId(), pixelFrame.getWidth(), pixelFrame.getHeight());
        if (onTextureCustomProcess != -1) {
            pixelFrame2.setTextureId(onTextureCustomProcess);
            return true;
        }
        return false;
    }

    @Override // com.tencent.rtmp.TXLivePusher.VideoCustomProcessListener
    public void onDetectFacePoints(float[] fArr) {
        TXLivePusher.VideoCustomProcessListener videoCustomProcessListener = this.mVideoCustomProcessListener;
        if (videoCustomProcessListener != null) {
            videoCustomProcessListener.onDetectFacePoints(fArr);
        }
    }

    @Override // com.tencent.rtmp.b
    public void onLogRecord(String str) {
        nativeOnLogRecord(this.mNativeTXLivePusherJni, str);
    }

    public byte[] onNativeRecordPcmData(byte[] bArr, long j, int i, int i2, int i3) {
        onRecordPcmData(bArr, j, i, i2, i3);
        return bArr;
    }

    public byte[] onNativeRecordRawPcmData(byte[] bArr, long j, int i, int i2, int i3, boolean z) {
        onRecordRawPcmData(bArr, j, i, i2, i3, z);
        return bArr;
    }

    @Override // com.tencent.rtmp.ITXLivePushListener
    public void onNetStatus(Bundle bundle) {
        ITXLivePushListener iTXLivePushListener = this.mITXLivePushListener;
        if (iTXLivePushListener != null) {
            iTXLivePushListener.onNetStatus(bundle);
        }
    }

    @Override // com.tencent.rtmp.ITXLivePushListener
    public void onPushEvent(int i, Bundle bundle) {
        ITXLivePushListener iTXLivePushListener = this.mITXLivePushListener;
        if (iTXLivePushListener != null) {
            iTXLivePushListener.onPushEvent(i, bundle);
        }
    }

    public void onRecordComplete(int i, String str, String str2, String str3) {
        TXRecordCommon.ITXVideoRecordListener iTXVideoRecordListener = this.mITXVideoRecordListener;
        if (iTXVideoRecordListener != null) {
            TXRecordCommon.TXRecordResult tXRecordResult = new TXRecordCommon.TXRecordResult();
            if (i == 0) {
                tXRecordResult.retCode = 0;
            } else {
                tXRecordResult.retCode = -1;
            }
            tXRecordResult.descMsg = str;
            tXRecordResult.videoPath = str2;
            tXRecordResult.coverPath = str3;
            iTXVideoRecordListener.onRecordComplete(tXRecordResult);
        }
    }

    public void onRecordEvent(int i, Bundle bundle) {
        TXRecordCommon.ITXVideoRecordListener iTXVideoRecordListener = this.mITXVideoRecordListener;
        if (iTXVideoRecordListener != null) {
            iTXVideoRecordListener.onRecordEvent(i, bundle);
        }
    }

    @Override // com.tencent.rtmp.TXLivePusher.AudioCustomProcessListener
    public void onRecordPcmData(byte[] bArr, long j, int i, int i2, int i3) {
        TXLivePusher.AudioCustomProcessListener audioCustomProcessListener = this.mAudioCustomProcessListener;
        if (audioCustomProcessListener != null) {
            audioCustomProcessListener.onRecordPcmData(bArr, j, i, i2, i3);
        }
    }

    public void onRecordProgress(long j) {
        TXRecordCommon.ITXVideoRecordListener iTXVideoRecordListener = this.mITXVideoRecordListener;
        if (iTXVideoRecordListener != null) {
            iTXVideoRecordListener.onRecordProgress(j);
        }
    }

    @Override // com.tencent.rtmp.TXLivePusher.AudioCustomProcessListener
    public void onRecordRawPcmData(byte[] bArr, long j, int i, int i2, int i3, boolean z) {
        TXLivePusher.AudioCustomProcessListener audioCustomProcessListener = this.mAudioCustomProcessListener;
        if (audioCustomProcessListener != null) {
            audioCustomProcessListener.onRecordRawPcmData(bArr, j, i, i2, i3, z);
        }
    }

    @Override // com.tencent.rtmp.ui.TXCloudVideoView.b
    public void onShowLog(boolean z) {
        nativeShowDebugView(this.mNativeTXLivePusherJni, z);
    }

    @Override // com.tencent.rtmp.TXLivePusher.ITXSnapshotListener
    public void onSnapshot(Bitmap bitmap) {
        TXLivePusher.ITXSnapshotListener iTXSnapshotListener = this.mITXSnapshotListener;
        if (iTXSnapshotListener != null) {
            iTXSnapshotListener.onSnapshot(bitmap);
        }
    }

    @Override // com.tencent.rtmp.TXLivePusher.VideoCustomProcessListener
    public int onTextureCustomProcess(int i, int i2, int i3) {
        TXLivePusher.VideoCustomProcessListener videoCustomProcessListener = this.mVideoCustomProcessListener;
        if (videoCustomProcessListener != null) {
            return videoCustomProcessListener.onTextureCustomProcess(i, i2, i3);
        }
        return -1;
    }

    @Override // com.tencent.rtmp.TXLivePusher.VideoCustomProcessListener
    public void onTextureDestoryed() {
        TXLivePusher.VideoCustomProcessListener videoCustomProcessListener = this.mVideoCustomProcessListener;
        if (videoCustomProcessListener != null) {
            videoCustomProcessListener.onTextureDestoryed();
        }
    }

    @Override // com.tencent.rtmp.b
    public boolean pauseBGM() {
        return nativePauseBGM(this.mNativeTXLivePusherJni);
    }

    @Override // com.tencent.rtmp.b
    public void pausePusher() {
        nativePausePusher(this.mNativeTXLivePusherJni);
    }

    @Override // com.tencent.rtmp.b
    public boolean playBGM(String str) {
        return nativePlayBGM(this.mNativeTXLivePusherJni, str);
    }

    @Override // com.tencent.rtmp.b
    public void release() {
        long j = this.mNativeTXLivePusherJni;
        if (j != 0) {
            nativeDestroy(j);
            this.mNativeTXLivePusherJni = 0L;
        }
    }

    @Override // com.tencent.rtmp.b
    public boolean resumeBGM() {
        return nativeResumeBGM(this.mNativeTXLivePusherJni);
    }

    @Override // com.tencent.rtmp.b
    public void resumePusher() {
        nativeResumePusher(this.mNativeTXLivePusherJni);
    }

    @Override // com.tencent.rtmp.b
    public void sendCustomPCMData(byte[] bArr) {
        nativeSendCustomPCMData(this.mNativeTXLivePusherJni, bArr);
    }

    @Override // com.tencent.rtmp.b
    public int sendCustomVideoData(byte[] bArr, int i, int i2, int i3) {
        PixelFrame pixelFrame = new PixelFrame();
        if (i == 3) {
            pixelFrame.setPixelFormatType(GLConstants.PixelFormatType.I420);
        } else if (i != 5) {
            return -3;
        } else {
            pixelFrame.setPixelFormatType(GLConstants.PixelFormatType.RGBA);
        }
        pixelFrame.setPixelBufferType(GLConstants.PixelBufferType.BYTE_ARRAY);
        pixelFrame.setData(bArr);
        pixelFrame.setWidth(i2);
        pixelFrame.setHeight(i3);
        nativeSendCustomVideoFrame(this.mNativeTXLivePusherJni, pixelFrame);
        return 0;
    }

    @Override // com.tencent.rtmp.b
    public int sendCustomVideoTexture(int i, int i2, int i3) {
        EGLContext eGLContext;
        PixelFrame pixelFrame = new PixelFrame();
        EGL10 egl10 = (EGL10) EGLContext.getEGL();
        if (egl10 != null) {
            eGLContext = egl10.eglGetCurrentContext();
            pixelFrame.setGLContext(eGLContext);
        } else {
            eGLContext = null;
        }
        if (eGLContext == null) {
            return -1;
        }
        pixelFrame.setPixelFormatType(GLConstants.PixelFormatType.RGBA);
        pixelFrame.setPixelBufferType(GLConstants.PixelBufferType.TEXTURE_2D);
        pixelFrame.setTextureId(i);
        pixelFrame.setWidth(i2);
        pixelFrame.setHeight(i3);
        nativeSendCustomVideoFrame(this.mNativeTXLivePusherJni, pixelFrame);
        return 0;
    }

    @Override // com.tencent.rtmp.b
    public void sendMessage(byte[] bArr) {
        nativeSendMessage(this.mNativeTXLivePusherJni, bArr);
    }

    @Override // com.tencent.rtmp.b
    public boolean sendMessageEx(byte[] bArr) {
        return nativeSendMessageEx(this.mNativeTXLivePusherJni, bArr);
    }

    @Override // com.tencent.rtmp.b
    public void setAudioProcessListener(TXLivePusher.AudioCustomProcessListener audioCustomProcessListener) {
        this.mAudioCustomProcessListener = audioCustomProcessListener;
    }

    @Override // com.tencent.rtmp.b
    public void setAudioVolumeEvaluationListener(TXLivePusher.ITXAudioVolumeEvaluationListener iTXAudioVolumeEvaluationListener) {
        this.mITXAudioVolumeEvaluationListener = iTXAudioVolumeEvaluationListener;
    }

    @Override // com.tencent.rtmp.b
    public void setBGMNofify(TXLivePusher.OnBGMNotify onBGMNotify) {
        this.mOnBGMNotify = onBGMNotify;
    }

    @Override // com.tencent.rtmp.b
    public void setBGMPitch(float f) {
        nativeSetBGMPitch(this.mNativeTXLivePusherJni, f);
    }

    @Override // com.tencent.rtmp.b
    public boolean setBGMPosition(int i) {
        return nativeSetBGMPosition(this.mNativeTXLivePusherJni, i);
    }

    @Override // com.tencent.rtmp.b
    public boolean setBGMVolume(float f) {
        return nativeSetBGMVolume(this.mNativeTXLivePusherJni, f);
    }

    @Override // com.tencent.rtmp.b
    public boolean setBeautyFilter(int i, int i2, int i3, int i4) {
        return nativeSetBeautyFilter(this.mNativeTXLivePusherJni, i, i2, i3, i4);
    }

    @Override // com.tencent.rtmp.b
    public void setChinLevel(int i) {
        this.mBeautyManager.setChinLevel(i);
    }

    @Override // com.tencent.rtmp.b
    public void setConfig(TXLivePushConfig tXLivePushConfig) {
        if (tXLivePushConfig == null) {
            return;
        }
        this.mConfig = tXLivePushConfig;
        nativeSetCaptureConfig(this.mNativeTXLivePusherJni, tXLivePushConfig.mCustomModeType, this.mConfig.mLocalVideoMirrorType, this.mConfig.mPauseImg, this.mConfig.mPauseFps, this.mConfig.mFrontCamera, this.mConfig.mTouchFocus, this.mConfig.mEnableZoom, this.mConfig.mEnableScreenCaptureAutoRotate, this.mConfig.mEnableHighResolutionCapture, this.mConfig.mPauseFlag);
        nativeSetEncoderConfig(this.mNativeTXLivePusherJni, this.mConfig.mHomeOrientation, this.mConfig.mVideoResolution.ordinal(), this.mConfig.mAutoAdjustBitrate, this.mConfig.mVideoBitrate, this.mConfig.mMaxVideoBitrate, this.mConfig.mMinVideoBitrate, this.mConfig.mVideoEncodeGop, this.mConfig.mVideoFPS, this.mConfig.mVideoEncoderXMirror, this.mConfig.mHardwareAccel, this.mConfig.mEnableVideoHardEncoderMainProfile);
        nativeSetWaterMark(this.mNativeTXLivePusherJni, this.mConfig.mWatermark, this.mConfig.mWatermarkXF, this.mConfig.mWatermarkYF, this.mConfig.mWatermarkWidth);
        nativeSetAudioConfig(this.mNativeTXLivePusherJni, this.mConfig.mAudioChannels, this.mConfig.mAudioSample, this.mConfig.mVolumeType, this.mConfig.mEnableAudioPreview, this.mConfig.mEnableAns);
        nativeSetNetworkConfig(this.mNativeTXLivePusherJni, this.mConfig.mAutoAdjustStrategy, this.mConfig.mEnablePureAudioPush, this.mConfig.mConnectRetryCount, this.mConfig.mConnectRetryInterval, this.mConfig.mRtmpChannelType);
    }

    @Override // com.tencent.rtmp.b
    public void setExposureCompensation(float f) {
        nativeSetExposureCompensation(this.mNativeTXLivePusherJni, f);
    }

    @Override // com.tencent.rtmp.b
    public void setEyeScaleLevel(int i) {
        this.mBeautyManager.setEyeScaleLevel(i);
    }

    @Override // com.tencent.rtmp.b
    public void setFaceShortLevel(int i) {
        this.mBeautyManager.setFaceShortLevel(i);
    }

    @Override // com.tencent.rtmp.b
    public void setFaceSlimLevel(int i) {
        this.mBeautyManager.setFaceSlimLevel(i);
    }

    @Override // com.tencent.rtmp.b
    public void setFaceVLevel(int i) {
        this.mBeautyManager.setFaceVLevel(i);
    }

    @Override // com.tencent.rtmp.b
    public void setFilter(Bitmap bitmap) {
        nativeSetFilter(this.mNativeTXLivePusherJni, bitmap);
    }

    @Override // com.tencent.rtmp.b
    public void setFocusPosition(float f, float f2) {
        nativeSetFocusPosition(this.mNativeTXLivePusherJni, f, f2);
    }

    @Override // com.tencent.rtmp.b
    public boolean setGreenScreenFile(String str) {
        return this.mBeautyManager.setGreenScreenFile(str) != 0;
    }

    @Override // com.tencent.rtmp.b
    public boolean setMicVolume(float f) {
        return nativeSetMicVolume(this.mNativeTXLivePusherJni, f);
    }

    @Override // com.tencent.rtmp.b
    public boolean setMirror(boolean z) {
        return nativeSetMirror(this.mNativeTXLivePusherJni, z);
    }

    @Override // com.tencent.rtmp.b
    public void setMotionMute(boolean z) {
        this.mBeautyManager.setMotionMute(z);
    }

    @Override // com.tencent.rtmp.b
    public void setMotionTmpl(String str) {
        this.mBeautyManager.setMotionTmpl(str);
    }

    @Override // com.tencent.rtmp.b
    public void setMute(boolean z) {
        nativeSetMute(this.mNativeTXLivePusherJni, z);
    }

    @Override // com.tencent.rtmp.b
    public void setNoseSlimLevel(int i) {
        this.mBeautyManager.setNoseSlimLevel(i);
    }

    @Override // com.tencent.rtmp.b
    public void setPushListener(ITXLivePushListener iTXLivePushListener) {
        this.mITXLivePushListener = iTXLivePushListener;
    }

    @Override // com.tencent.rtmp.b
    public void setRenderRotation(int i) {
        nativeSetRenderRotation(this.mNativeTXLivePusherJni, i);
    }

    @Override // com.tencent.rtmp.b
    public void setReverb(int i) {
        nativeSetReverb(this.mNativeTXLivePusherJni, i);
    }

    @Override // com.tencent.rtmp.b
    public void setSpecialRatio(float f) {
        nativeSetSpecialRatio(this.mNativeTXLivePusherJni, f);
    }

    @Override // com.tencent.rtmp.b
    public void setSurface(Surface surface) {
        int i;
        if (surface == null) {
            return;
        }
        this.mSurface = surface;
        int i2 = this.mSurfaceWidth;
        if (i2 < 0 || (i = this.mSurfaceHeight) < 0) {
            return;
        }
        nativeSetView(this.mNativeTXLivePusherJni, new DisplayTarget(surface, i2, i));
    }

    @Override // com.tencent.rtmp.b
    public void setSurfaceSize(int i, int i2) {
        if (i < 0 || i2 < 0) {
            return;
        }
        this.mSurfaceWidth = i;
        this.mSurfaceHeight = i2;
        Surface surface = this.mSurface;
        if (surface != null) {
            nativeSetView(this.mNativeTXLivePusherJni, new DisplayTarget(surface, i, i2));
        }
    }

    @Override // com.tencent.rtmp.b
    public void setVideoProcessListener(TXLivePusher.VideoCustomProcessListener videoCustomProcessListener) {
        this.mVideoCustomProcessListener = videoCustomProcessListener;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    @Override // com.tencent.rtmp.b
    public void setVideoQuality(int i, boolean z, boolean z2) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    @Override // com.tencent.rtmp.b
    public void setVideoRecordListener(TXRecordCommon.ITXVideoRecordListener iTXVideoRecordListener) {
        this.mITXVideoRecordListener = iTXVideoRecordListener;
    }

    @Override // com.tencent.rtmp.b
    public void setVoiceChangerType(int i) {
        nativeSetVoiceChangerType(this.mNativeTXLivePusherJni, i);
    }

    @Override // com.tencent.rtmp.b
    public boolean setZoom(int i) {
        return nativeSetZoom(this.mNativeTXLivePusherJni, i);
    }

    @Override // com.tencent.rtmp.b
    public void snapshot(TXLivePusher.ITXSnapshotListener iTXSnapshotListener) {
        this.mITXSnapshotListener = iTXSnapshotListener;
        nativeSnapshot(this.mNativeTXLivePusherJni);
    }

    @Override // com.tencent.rtmp.b
    public void startCameraPreview(TXCloudVideoView tXCloudVideoView) {
        if (tXCloudVideoView != null) {
            a.a(tXCloudVideoView, new WeakReference(this));
            nativeShowDebugView(this.mNativeTXLivePusherJni, a.a(tXCloudVideoView));
        }
        nativeSetView(this.mNativeTXLivePusherJni, new DisplayTarget(tXCloudVideoView));
        nativeStartCamera(this.mNativeTXLivePusherJni);
    }

    @Override // com.tencent.rtmp.b
    public int startPusher(String str) {
        return nativeStartPusher(this.mNativeTXLivePusherJni, str);
    }

    @Override // com.tencent.rtmp.b
    public int startRecord(String str) {
        return nativeStartRecord(this.mNativeTXLivePusherJni, str);
    }

    @Override // com.tencent.rtmp.b
    public void startScreenCapture() {
        nativeStartScreenCapture(this.mNativeTXLivePusherJni);
    }

    @Override // com.tencent.rtmp.b
    public boolean stopBGM() {
        return nativeStopBGM(this.mNativeTXLivePusherJni);
    }

    @Override // com.tencent.rtmp.b
    public void stopCameraPreview(boolean z) {
        nativeStopCameraPreview(this.mNativeTXLivePusherJni, z);
    }

    @Override // com.tencent.rtmp.b
    public void stopPusher() {
        nativeStopPusher(this.mNativeTXLivePusherJni);
    }

    @Override // com.tencent.rtmp.b
    public void stopRecord() {
        nativeStopRecord(this.mNativeTXLivePusherJni);
    }

    @Override // com.tencent.rtmp.b
    public void stopScreenCapture() {
        nativeStopScreenCapture(this.mNativeTXLivePusherJni);
    }

    @Override // com.tencent.rtmp.b
    public void switchCamera() {
        TXLivePushConfig tXLivePushConfig = this.mConfig;
        tXLivePushConfig.setFrontCamera(!tXLivePushConfig.mFrontCamera);
        nativeSwitchCamera(this.mNativeTXLivePusherJni);
    }

    @Override // com.tencent.rtmp.b
    public boolean turnOnFlashLight(boolean z) {
        return nativeTurnOnFlashLight(this.mNativeTXLivePusherJni, z);
    }
}
