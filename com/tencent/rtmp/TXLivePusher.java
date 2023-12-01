package com.tencent.rtmp;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.Surface;
import com.tencent.liteav.audio.TXAudioEffectManager;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.o;
import com.tencent.liteav.beauty.TXBeautyManager;
import com.tencent.liteav.live.TXLivePusherJni;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.ugc.TXRecordCommon;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/rtmp/TXLivePusher.class */
public class TXLivePusher implements b {
    public static final int RGB_BGRA = 4;
    public static final int RGB_RGBA = 5;
    private static final String TAG = "TXLivePusher";
    public static final int YUV_420P = 3;
    public static final int YUV_420SP = 1;
    public static final int YUV_420YpCbCr = 2;
    private b mImpl;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/rtmp/TXLivePusher$AudioCustomProcessListener.class */
    public interface AudioCustomProcessListener {
        void onRecordPcmData(byte[] bArr, long j, int i, int i2, int i3);

        void onRecordRawPcmData(byte[] bArr, long j, int i, int i2, int i3, boolean z);
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/rtmp/TXLivePusher$ITXAudioVolumeEvaluationListener.class */
    public interface ITXAudioVolumeEvaluationListener {
        void onAudioVolumeEvaluationNotify(int i);
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/rtmp/TXLivePusher$ITXSnapshotListener.class */
    public interface ITXSnapshotListener {
        void onSnapshot(Bitmap bitmap);
    }

    @Deprecated
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/rtmp/TXLivePusher$OnBGMNotify.class */
    public interface OnBGMNotify {
        void onBGMComplete(int i);

        void onBGMProgress(long j, long j2);

        void onBGMStart();
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/rtmp/TXLivePusher$VideoCustomProcessListener.class */
    public interface VideoCustomProcessListener {
        void onDetectFacePoints(float[] fArr);

        int onTextureCustomProcess(int i, int i2, int i3);

        void onTextureDestoryed();
    }

    static {
        o.a();
    }

    public TXLivePusher(Context context) {
        this.mImpl = new TXLivePusherJni(context);
        LiteavLog.i(TAG, "Create instance:" + this.mImpl.toString());
    }

    @Override // com.tencent.rtmp.b
    public void callExperimentalAPI(String str) {
        synchronized (this) {
            if (this.mImpl == null) {
                return;
            }
            this.mImpl.callExperimentalAPI(str);
        }
    }

    @Override // com.tencent.rtmp.b
    public void enableAudioVolumeEvaluation(int i) {
        synchronized (this) {
            if (this.mImpl == null) {
                return;
            }
            this.mImpl.enableAudioVolumeEvaluation(i);
        }
    }

    @Override // com.tencent.rtmp.b
    public TXAudioEffectManager getAudioEffectManager() {
        synchronized (this) {
            if (this.mImpl == null) {
                return null;
            }
            return this.mImpl.getAudioEffectManager();
        }
    }

    @Override // com.tencent.rtmp.b
    public TXBeautyManager getBeautyManager() {
        synchronized (this) {
            if (this.mImpl == null) {
                return null;
            }
            return this.mImpl.getBeautyManager();
        }
    }

    @Override // com.tencent.rtmp.b
    public TXLivePushConfig getConfig() {
        synchronized (this) {
            if (this.mImpl == null) {
                return new TXLivePushConfig();
            }
            return this.mImpl.getConfig();
        }
    }

    @Override // com.tencent.rtmp.b
    public int getMaxZoom() {
        synchronized (this) {
            if (this.mImpl == null) {
                return 0;
            }
            return this.mImpl.getMaxZoom();
        }
    }

    @Override // com.tencent.rtmp.b
    @Deprecated
    public int getMusicDuration(String str) {
        synchronized (this) {
            if (this.mImpl == null) {
                return 0;
            }
            return this.mImpl.getMusicDuration(str);
        }
    }

    @Override // com.tencent.rtmp.b
    public boolean isPushing() {
        synchronized (this) {
            if (this.mImpl == null) {
                return false;
            }
            return this.mImpl.isPushing();
        }
    }

    @Override // com.tencent.rtmp.b
    public void onLogRecord(String str) {
        synchronized (this) {
            if (this.mImpl == null) {
                return;
            }
            this.mImpl.onLogRecord(str);
        }
    }

    @Override // com.tencent.rtmp.b
    @Deprecated
    public boolean pauseBGM() {
        synchronized (this) {
            if (this.mImpl == null) {
                return false;
            }
            return this.mImpl.pauseBGM();
        }
    }

    @Override // com.tencent.rtmp.b
    public void pausePusher() {
        synchronized (this) {
            if (this.mImpl == null) {
                return;
            }
            this.mImpl.pausePusher();
        }
    }

    @Override // com.tencent.rtmp.b
    @Deprecated
    public boolean playBGM(String str) {
        synchronized (this) {
            if (this.mImpl == null) {
                return false;
            }
            return this.mImpl.playBGM(str);
        }
    }

    @Override // com.tencent.rtmp.b
    public void release() {
        synchronized (this) {
            if (this.mImpl == null) {
                return;
            }
            this.mImpl.release();
            LiteavLog.i(TAG, "Release instance:" + this.mImpl.toString());
            this.mImpl = null;
        }
    }

    @Override // com.tencent.rtmp.b
    @Deprecated
    public boolean resumeBGM() {
        synchronized (this) {
            if (this.mImpl == null) {
                return false;
            }
            return this.mImpl.resumeBGM();
        }
    }

    @Override // com.tencent.rtmp.b
    public void resumePusher() {
        synchronized (this) {
            if (this.mImpl == null) {
                return;
            }
            this.mImpl.resumePusher();
        }
    }

    @Override // com.tencent.rtmp.b
    public void sendCustomPCMData(byte[] bArr) {
        synchronized (this) {
            if (this.mImpl == null) {
                return;
            }
            this.mImpl.sendCustomPCMData(bArr);
        }
    }

    @Override // com.tencent.rtmp.b
    public int sendCustomVideoData(byte[] bArr, int i, int i2, int i3) {
        synchronized (this) {
            if (this.mImpl == null) {
                return -1;
            }
            return this.mImpl.sendCustomVideoData(bArr, i, i2, i3);
        }
    }

    @Override // com.tencent.rtmp.b
    public int sendCustomVideoTexture(int i, int i2, int i3) {
        synchronized (this) {
            if (this.mImpl == null) {
                return -1;
            }
            return this.mImpl.sendCustomVideoTexture(i, i2, i3);
        }
    }

    @Override // com.tencent.rtmp.b
    @Deprecated
    public void sendMessage(byte[] bArr) {
        synchronized (this) {
            if (this.mImpl == null) {
                return;
            }
            this.mImpl.sendMessage(bArr);
        }
    }

    @Override // com.tencent.rtmp.b
    public boolean sendMessageEx(byte[] bArr) {
        synchronized (this) {
            if (this.mImpl == null) {
                return false;
            }
            return this.mImpl.sendMessageEx(bArr);
        }
    }

    @Override // com.tencent.rtmp.b
    public void setAudioProcessListener(AudioCustomProcessListener audioCustomProcessListener) {
        synchronized (this) {
            if (this.mImpl == null) {
                return;
            }
            this.mImpl.setAudioProcessListener(audioCustomProcessListener);
        }
    }

    @Override // com.tencent.rtmp.b
    public void setAudioVolumeEvaluationListener(ITXAudioVolumeEvaluationListener iTXAudioVolumeEvaluationListener) {
        synchronized (this) {
            if (this.mImpl == null) {
                return;
            }
            this.mImpl.setAudioVolumeEvaluationListener(iTXAudioVolumeEvaluationListener);
        }
    }

    @Override // com.tencent.rtmp.b
    @Deprecated
    public void setBGMNofify(OnBGMNotify onBGMNotify) {
        synchronized (this) {
            if (this.mImpl == null) {
                return;
            }
            this.mImpl.setBGMNofify(onBGMNotify);
        }
    }

    @Override // com.tencent.rtmp.b
    @Deprecated
    public void setBGMPitch(float f) {
        synchronized (this) {
            if (this.mImpl == null) {
                return;
            }
            this.mImpl.setBGMPitch(f);
        }
    }

    @Override // com.tencent.rtmp.b
    @Deprecated
    public boolean setBGMPosition(int i) {
        synchronized (this) {
            if (this.mImpl == null) {
                return false;
            }
            return this.mImpl.setBGMPosition(i);
        }
    }

    @Override // com.tencent.rtmp.b
    @Deprecated
    public boolean setBGMVolume(float f) {
        synchronized (this) {
            if (this.mImpl == null) {
                return false;
            }
            return this.mImpl.setBGMVolume(f);
        }
    }

    @Override // com.tencent.rtmp.b
    public boolean setBeautyFilter(int i, int i2, int i3, int i4) {
        synchronized (this) {
            if (this.mImpl == null) {
                return false;
            }
            return this.mImpl.setBeautyFilter(i, i2, i3, i4);
        }
    }

    @Override // com.tencent.rtmp.b
    @Deprecated
    public void setChinLevel(int i) {
        synchronized (this) {
            if (this.mImpl == null) {
                return;
            }
            this.mImpl.setChinLevel(i);
        }
    }

    @Override // com.tencent.rtmp.b
    public void setConfig(TXLivePushConfig tXLivePushConfig) {
        synchronized (this) {
            if (this.mImpl == null) {
                return;
            }
            this.mImpl.setConfig(tXLivePushConfig);
        }
    }

    @Override // com.tencent.rtmp.b
    public void setExposureCompensation(float f) {
        synchronized (this) {
            if (this.mImpl == null) {
                return;
            }
            this.mImpl.setExposureCompensation(f);
        }
    }

    @Override // com.tencent.rtmp.b
    @Deprecated
    public void setEyeScaleLevel(int i) {
        synchronized (this) {
            if (this.mImpl == null) {
                return;
            }
            this.mImpl.setEyeScaleLevel(i);
        }
    }

    @Override // com.tencent.rtmp.b
    @Deprecated
    public void setFaceShortLevel(int i) {
        synchronized (this) {
            if (this.mImpl == null) {
                return;
            }
            this.mImpl.setFaceShortLevel(i);
        }
    }

    @Override // com.tencent.rtmp.b
    @Deprecated
    public void setFaceSlimLevel(int i) {
        synchronized (this) {
            if (this.mImpl == null) {
                return;
            }
            this.mImpl.setFaceSlimLevel(i);
        }
    }

    @Override // com.tencent.rtmp.b
    @Deprecated
    public void setFaceVLevel(int i) {
        synchronized (this) {
            if (this.mImpl == null) {
                return;
            }
            this.mImpl.setFaceVLevel(i);
        }
    }

    @Override // com.tencent.rtmp.b
    @Deprecated
    public void setFilter(Bitmap bitmap) {
        synchronized (this) {
            if (this.mImpl == null) {
                return;
            }
            this.mImpl.setFilter(bitmap);
        }
    }

    @Override // com.tencent.rtmp.b
    public void setFocusPosition(float f, float f2) {
        synchronized (this) {
            if (this.mImpl == null) {
                return;
            }
            this.mImpl.setFocusPosition(f, f2);
        }
    }

    @Override // com.tencent.rtmp.b
    @Deprecated
    public boolean setGreenScreenFile(String str) {
        synchronized (this) {
            if (this.mImpl == null) {
                return false;
            }
            return this.mImpl.setGreenScreenFile(str);
        }
    }

    @Override // com.tencent.rtmp.b
    @Deprecated
    public boolean setMicVolume(float f) {
        synchronized (this) {
            if (this.mImpl == null) {
                return false;
            }
            return this.mImpl.setMicVolume(f);
        }
    }

    @Override // com.tencent.rtmp.b
    public boolean setMirror(boolean z) {
        synchronized (this) {
            if (this.mImpl == null) {
                return false;
            }
            return this.mImpl.setMirror(z);
        }
    }

    @Override // com.tencent.rtmp.b
    @Deprecated
    public void setMotionMute(boolean z) {
        synchronized (this) {
            if (this.mImpl == null) {
                return;
            }
            this.mImpl.setMotionMute(z);
        }
    }

    @Override // com.tencent.rtmp.b
    @Deprecated
    public void setMotionTmpl(String str) {
        synchronized (this) {
            if (this.mImpl == null) {
                return;
            }
            this.mImpl.setMotionTmpl(str);
        }
    }

    @Override // com.tencent.rtmp.b
    public void setMute(boolean z) {
        synchronized (this) {
            if (this.mImpl == null) {
                return;
            }
            this.mImpl.setMute(z);
        }
    }

    @Override // com.tencent.rtmp.b
    @Deprecated
    public void setNoseSlimLevel(int i) {
        synchronized (this) {
            if (this.mImpl == null) {
                return;
            }
            this.mImpl.setNoseSlimLevel(i);
        }
    }

    @Override // com.tencent.rtmp.b
    public void setPushListener(ITXLivePushListener iTXLivePushListener) {
        synchronized (this) {
            if (this.mImpl == null) {
                return;
            }
            this.mImpl.setPushListener(iTXLivePushListener);
        }
    }

    @Override // com.tencent.rtmp.b
    public void setRenderRotation(int i) {
        synchronized (this) {
            if (this.mImpl == null) {
                return;
            }
            this.mImpl.setRenderRotation(i);
        }
    }

    @Override // com.tencent.rtmp.b
    @Deprecated
    public void setReverb(int i) {
        synchronized (this) {
            if (this.mImpl == null) {
                return;
            }
            this.mImpl.setReverb(i);
        }
    }

    @Override // com.tencent.rtmp.b
    @Deprecated
    public void setSpecialRatio(float f) {
        synchronized (this) {
            if (this.mImpl == null) {
                return;
            }
            this.mImpl.setSpecialRatio(f);
        }
    }

    @Override // com.tencent.rtmp.b
    public void setSurface(Surface surface) {
        synchronized (this) {
            if (this.mImpl == null) {
                return;
            }
            this.mImpl.setSurface(surface);
        }
    }

    @Override // com.tencent.rtmp.b
    public void setSurfaceSize(int i, int i2) {
        synchronized (this) {
            if (this.mImpl == null) {
                return;
            }
            this.mImpl.setSurfaceSize(i, i2);
        }
    }

    @Override // com.tencent.rtmp.b
    public void setVideoProcessListener(VideoCustomProcessListener videoCustomProcessListener) {
        synchronized (this) {
            if (this.mImpl == null) {
                return;
            }
            this.mImpl.setVideoProcessListener(videoCustomProcessListener);
        }
    }

    @Override // com.tencent.rtmp.b
    public void setVideoQuality(int i, boolean z, boolean z2) {
        synchronized (this) {
            if (this.mImpl == null) {
                return;
            }
            this.mImpl.setVideoQuality(i, z, z2);
        }
    }

    @Override // com.tencent.rtmp.b
    public void setVideoRecordListener(TXRecordCommon.ITXVideoRecordListener iTXVideoRecordListener) {
        synchronized (this) {
            if (this.mImpl == null) {
                return;
            }
            this.mImpl.setVideoRecordListener(iTXVideoRecordListener);
        }
    }

    @Override // com.tencent.rtmp.b
    @Deprecated
    public void setVoiceChangerType(int i) {
        synchronized (this) {
            if (this.mImpl == null) {
                return;
            }
            this.mImpl.setVoiceChangerType(i);
        }
    }

    @Override // com.tencent.rtmp.b
    public boolean setZoom(int i) {
        synchronized (this) {
            if (this.mImpl == null) {
                return false;
            }
            return this.mImpl.setZoom(i);
        }
    }

    @Override // com.tencent.rtmp.b
    public void snapshot(ITXSnapshotListener iTXSnapshotListener) {
        synchronized (this) {
            if (this.mImpl == null) {
                return;
            }
            this.mImpl.snapshot(iTXSnapshotListener);
        }
    }

    @Override // com.tencent.rtmp.b
    public void startCameraPreview(TXCloudVideoView tXCloudVideoView) {
        synchronized (this) {
            if (this.mImpl == null) {
                return;
            }
            this.mImpl.startCameraPreview(tXCloudVideoView);
        }
    }

    @Override // com.tencent.rtmp.b
    public int startPusher(String str) {
        synchronized (this) {
            if (this.mImpl == null) {
                return -1;
            }
            return this.mImpl.startPusher(str);
        }
    }

    @Override // com.tencent.rtmp.b
    public int startRecord(String str) {
        synchronized (this) {
            if (this.mImpl == null) {
                return -3;
            }
            return this.mImpl.startRecord(str);
        }
    }

    @Override // com.tencent.rtmp.b
    public void startScreenCapture() {
        synchronized (this) {
            if (this.mImpl == null) {
                return;
            }
            this.mImpl.startScreenCapture();
        }
    }

    @Override // com.tencent.rtmp.b
    @Deprecated
    public boolean stopBGM() {
        synchronized (this) {
            if (this.mImpl == null) {
                return false;
            }
            return this.mImpl.stopBGM();
        }
    }

    @Override // com.tencent.rtmp.b
    public void stopCameraPreview(boolean z) {
        synchronized (this) {
            if (this.mImpl == null) {
                return;
            }
            this.mImpl.stopCameraPreview(z);
        }
    }

    @Override // com.tencent.rtmp.b
    public void stopPusher() {
        synchronized (this) {
            if (this.mImpl == null) {
                return;
            }
            this.mImpl.stopPusher();
        }
    }

    @Override // com.tencent.rtmp.b
    public void stopRecord() {
        synchronized (this) {
            if (this.mImpl == null) {
                return;
            }
            this.mImpl.stopRecord();
        }
    }

    @Override // com.tencent.rtmp.b
    public void stopScreenCapture() {
        synchronized (this) {
            if (this.mImpl == null) {
                return;
            }
            this.mImpl.stopScreenCapture();
        }
    }

    @Override // com.tencent.rtmp.b
    public void switchCamera() {
        synchronized (this) {
            if (this.mImpl == null) {
                return;
            }
            this.mImpl.switchCamera();
        }
    }

    @Override // com.tencent.rtmp.b
    public boolean turnOnFlashLight(boolean z) {
        synchronized (this) {
            if (this.mImpl == null) {
                return false;
            }
            return this.mImpl.turnOnFlashLight(z);
        }
    }
}
