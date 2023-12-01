package com.tencent.rtmp;

import android.graphics.Bitmap;
import android.view.Surface;
import com.tencent.liteav.audio.TXAudioEffectManager;
import com.tencent.liteav.beauty.TXBeautyManager;
import com.tencent.rtmp.TXLivePusher;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.ugc.TXRecordCommon;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/rtmp/b.class */
public interface b {
    void callExperimentalAPI(String str);

    void enableAudioVolumeEvaluation(int i);

    TXAudioEffectManager getAudioEffectManager();

    TXBeautyManager getBeautyManager();

    TXLivePushConfig getConfig();

    int getMaxZoom();

    @Deprecated
    int getMusicDuration(String str);

    boolean isPushing();

    void onLogRecord(String str);

    @Deprecated
    boolean pauseBGM();

    void pausePusher();

    @Deprecated
    boolean playBGM(String str);

    void release();

    @Deprecated
    boolean resumeBGM();

    void resumePusher();

    void sendCustomPCMData(byte[] bArr);

    int sendCustomVideoData(byte[] bArr, int i, int i2, int i3);

    int sendCustomVideoTexture(int i, int i2, int i3);

    @Deprecated
    void sendMessage(byte[] bArr);

    boolean sendMessageEx(byte[] bArr);

    void setAudioProcessListener(TXLivePusher.AudioCustomProcessListener audioCustomProcessListener);

    void setAudioVolumeEvaluationListener(TXLivePusher.ITXAudioVolumeEvaluationListener iTXAudioVolumeEvaluationListener);

    @Deprecated
    void setBGMNofify(TXLivePusher.OnBGMNotify onBGMNotify);

    @Deprecated
    void setBGMPitch(float f);

    @Deprecated
    boolean setBGMPosition(int i);

    @Deprecated
    boolean setBGMVolume(float f);

    boolean setBeautyFilter(int i, int i2, int i3, int i4);

    @Deprecated
    void setChinLevel(int i);

    void setConfig(TXLivePushConfig tXLivePushConfig);

    void setExposureCompensation(float f);

    @Deprecated
    void setEyeScaleLevel(int i);

    @Deprecated
    void setFaceShortLevel(int i);

    @Deprecated
    void setFaceSlimLevel(int i);

    @Deprecated
    void setFaceVLevel(int i);

    @Deprecated
    void setFilter(Bitmap bitmap);

    void setFocusPosition(float f, float f2);

    @Deprecated
    boolean setGreenScreenFile(String str);

    @Deprecated
    boolean setMicVolume(float f);

    boolean setMirror(boolean z);

    @Deprecated
    void setMotionMute(boolean z);

    @Deprecated
    void setMotionTmpl(String str);

    void setMute(boolean z);

    @Deprecated
    void setNoseSlimLevel(int i);

    void setPushListener(ITXLivePushListener iTXLivePushListener);

    void setRenderRotation(int i);

    @Deprecated
    void setReverb(int i);

    @Deprecated
    void setSpecialRatio(float f);

    void setSurface(Surface surface);

    void setSurfaceSize(int i, int i2);

    void setVideoProcessListener(TXLivePusher.VideoCustomProcessListener videoCustomProcessListener);

    void setVideoQuality(int i, boolean z, boolean z2);

    void setVideoRecordListener(TXRecordCommon.ITXVideoRecordListener iTXVideoRecordListener);

    @Deprecated
    void setVoiceChangerType(int i);

    boolean setZoom(int i);

    void snapshot(TXLivePusher.ITXSnapshotListener iTXSnapshotListener);

    void startCameraPreview(TXCloudVideoView tXCloudVideoView);

    int startPusher(String str);

    int startRecord(String str);

    void startScreenCapture();

    @Deprecated
    boolean stopBGM();

    void stopCameraPreview(boolean z);

    void stopPusher();

    void stopRecord();

    void stopScreenCapture();

    void switchCamera();

    boolean turnOnFlashLight(boolean z);
}
