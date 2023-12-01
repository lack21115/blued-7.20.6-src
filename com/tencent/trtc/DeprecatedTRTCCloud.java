package com.tencent.trtc;

import android.graphics.Bitmap;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.trtc.TRTCCloud;
import com.tencent.trtc.TRTCCloudDef;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/trtc/DeprecatedTRTCCloud.class */
public abstract class DeprecatedTRTCCloud {
    @Deprecated
    public abstract int checkAudioCapabilitySupport(int i);

    public abstract void enableAudioEarMonitoring(boolean z);

    @Deprecated
    public abstract void enableAudioVolumeEvaluation(int i);

    @Deprecated
    public abstract void enableCustomVideoCapture(boolean z);

    @Deprecated
    public abstract boolean enableTorch(boolean z);

    @Deprecated
    public abstract int getBGMDuration(String str);

    @Deprecated
    public abstract boolean isCameraAutoFocusFaceModeSupported();

    @Deprecated
    public abstract boolean isCameraFocusPositionInPreviewSupported();

    @Deprecated
    public abstract boolean isCameraTorchSupported();

    @Deprecated
    public abstract boolean isCameraZoomSupported();

    @Deprecated
    public abstract void muteLocalVideo(boolean z);

    @Deprecated
    public abstract void muteRemoteVideoStream(String str, boolean z);

    @Deprecated
    public abstract void pauseAudioEffect(int i);

    @Deprecated
    public abstract void pauseBGM();

    @Deprecated
    public abstract void playAudioEffect(TRTCCloudDef.TRTCAudioEffectParam tRTCAudioEffectParam);

    @Deprecated
    public abstract void playBGM(String str, TRTCCloud.BGMNotify bGMNotify);

    @Deprecated
    public abstract void resumeAudioEffect(int i);

    @Deprecated
    public abstract void resumeBGM();

    @Deprecated
    public abstract void selectMotionTmpl(String str);

    @Deprecated
    public abstract void sendCustomVideoData(TRTCCloudDef.TRTCVideoFrame tRTCVideoFrame);

    @Deprecated
    public abstract void setAllAudioEffectsVolume(int i);

    @Deprecated
    public abstract void setAudioEffectVolume(int i, int i2);

    @Deprecated
    public abstract void setAudioQuality(int i);

    @Deprecated
    public abstract void setBGMPlayoutVolume(int i);

    @Deprecated
    public abstract int setBGMPosition(int i);

    @Deprecated
    public abstract void setBGMPublishVolume(int i);

    @Deprecated
    public abstract void setBGMVolume(int i);

    @Deprecated
    public abstract void setBeautyStyle(int i, int i2, int i3, int i4);

    @Deprecated
    public abstract void setChinLevel(int i);

    @Deprecated
    public abstract void setEyeScaleLevel(int i);

    @Deprecated
    public abstract void setFaceShortLevel(int i);

    @Deprecated
    public abstract void setFaceSlimLevel(int i);

    @Deprecated
    public abstract void setFaceVLevel(int i);

    @Deprecated
    public abstract void setFilter(Bitmap bitmap);

    @Deprecated
    public abstract void setFilterConcentration(float f);

    @Deprecated
    public abstract void setFocusPosition(int i, int i2);

    @Deprecated
    public abstract boolean setGreenScreenFile(String str);

    @Deprecated
    public abstract void setLocalViewFillMode(int i);

    @Deprecated
    public abstract void setLocalViewMirror(int i);

    @Deprecated
    public abstract void setLocalViewRotation(int i);

    @Deprecated
    public abstract void setMicVolumeOnMixing(int i);

    @Deprecated
    public abstract void setMotionMute(boolean z);

    @Deprecated
    public abstract void setNoseSlimLevel(int i);

    @Deprecated
    public abstract int setPriorRemoteVideoStreamType(int i);

    @Deprecated
    public abstract void setRemoteSubStreamViewFillMode(String str, int i);

    @Deprecated
    public abstract void setRemoteSubStreamViewRotation(String str, int i);

    @Deprecated
    public abstract void setRemoteViewFillMode(String str, int i);

    @Deprecated
    public abstract void setRemoteViewRotation(String str, int i);

    @Deprecated
    public abstract void setReverbType(int i);

    public abstract void setSystemVolumeType(int i);

    @Deprecated
    public abstract boolean setVoiceChangerType(int i);

    @Deprecated
    public abstract void setZoom(int i);

    @Deprecated
    public abstract void startLocalAudio();

    @Deprecated
    public abstract void startRemoteSubStreamView(String str, TXCloudVideoView tXCloudVideoView);

    @Deprecated
    public abstract void startRemoteView(String str, TXCloudVideoView tXCloudVideoView);

    @Deprecated
    public abstract void startScreenCapture(TRTCCloudDef.TRTCVideoEncParam tRTCVideoEncParam, TRTCCloudDef.TRTCScreenShareParams tRTCScreenShareParams);

    @Deprecated
    public abstract void startSpeedTest(int i, String str, String str2);

    @Deprecated
    public abstract void stopAllAudioEffects();

    @Deprecated
    public abstract void stopAudioEffect(int i);

    @Deprecated
    public abstract void stopBGM();

    @Deprecated
    public abstract void stopRemoteSubStreamView(String str);

    @Deprecated
    public abstract void stopRemoteView(String str);

    @Deprecated
    public abstract void switchCamera();
}
