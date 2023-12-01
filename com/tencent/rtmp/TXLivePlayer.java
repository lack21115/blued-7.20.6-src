package com.tencent.rtmp;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.Surface;
import com.tencent.liteav.base.util.o;
import com.tencent.liteav.live.TXLivePlayerJni;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.ugc.TXRecordCommon;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/rtmp/TXLivePlayer.class */
public class TXLivePlayer {
    public static final int PLAY_TYPE_LIVE_FLV = 1;
    public static final int PLAY_TYPE_LIVE_RTMP = 0;
    public static final int PLAY_TYPE_LIVE_RTMP_ACC = 5;
    public static final int PLAY_TYPE_LOCAL_VIDEO = 6;
    public static final int PLAY_TYPE_VOD_FLV = 2;
    public static final int PLAY_TYPE_VOD_HLS = 3;
    public static final int PLAY_TYPE_VOD_MP4 = 4;
    public static final String TAG = "TXLivePlayer";
    private a mImpl;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/rtmp/TXLivePlayer$ITXAudioRawDataListener.class */
    public interface ITXAudioRawDataListener {
        void onAudioInfoChanged(int i, int i2, int i3);

        void onPcmDataAvailable(byte[] bArr, long j);
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/rtmp/TXLivePlayer$ITXAudioVolumeEvaluationListener.class */
    public interface ITXAudioVolumeEvaluationListener {
        void onAudioVolumeEvaluationNotify(int i);
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/rtmp/TXLivePlayer$ITXLivePlayVideoRenderListener.class */
    public interface ITXLivePlayVideoRenderListener {
        void onRenderVideoFrame(TXLiteAVTexture tXLiteAVTexture);
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/rtmp/TXLivePlayer$ITXSnapshotListener.class */
    public interface ITXSnapshotListener {
        void onSnapshot(Bitmap bitmap);
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/rtmp/TXLivePlayer$ITXVideoRawDataListener.class */
    public interface ITXVideoRawDataListener {
        void onVideoRawDataAvailable(byte[] bArr, int i, int i2, int i3);
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/rtmp/TXLivePlayer$TXLiteAVTexture.class */
    public static class TXLiteAVTexture {
        public Object eglContext;
        public int height;
        public int textureId;
        public int width;
    }

    static {
        o.a();
    }

    public TXLivePlayer(Context context) {
        this.mImpl = new TXLivePlayerJni(context);
    }

    public boolean addVideoRawData(byte[] bArr) {
        return this.mImpl.addVideoRawData(bArr);
    }

    public void callExperimentalAPI(String str) {
        this.mImpl.callExperimentalAPI(str);
    }

    public void enableAudioVolumeEvaluation(int i) {
        this.mImpl.enableAudioVolumeEvaluation(i);
    }

    public boolean enableHardwareDecode(boolean z) {
        return this.mImpl.enableHardwareDecode(z);
    }

    public long getCurrentRenderPts() {
        return this.mImpl.getCurrentRenderPts();
    }

    public boolean isPlaying() {
        return this.mImpl.isPlaying();
    }

    public void pause() {
        this.mImpl.pause();
    }

    public int prepareLiveSeek(String str, int i) {
        return this.mImpl.prepareLiveSeek(str, i);
    }

    public void resume() {
        this.mImpl.resume();
    }

    public int resumeLive() {
        return this.mImpl.resumeLive();
    }

    public void seek(int i) {
        this.mImpl.seek(i);
    }

    public void setAudioRawDataListener(ITXAudioRawDataListener iTXAudioRawDataListener) {
        this.mImpl.setAudioRawDataListener(iTXAudioRawDataListener);
    }

    public void setAudioRoute(int i) {
        this.mImpl.setAudioRoute(i);
    }

    public void setAudioVolumeEvaluationListener(ITXAudioVolumeEvaluationListener iTXAudioVolumeEvaluationListener) {
        this.mImpl.setAudioVolumeEvaluationListener(iTXAudioVolumeEvaluationListener);
    }

    public void setAutoPlay(boolean z) {
        this.mImpl.setAutoPlay(z);
    }

    public void setConfig(TXLivePlayConfig tXLivePlayConfig) {
        this.mImpl.setConfig(tXLivePlayConfig);
    }

    public void setMute(boolean z) {
        this.mImpl.setMute(z);
    }

    public void setPlayListener(ITXLivePlayListener iTXLivePlayListener) {
        this.mImpl.setPlayListener(iTXLivePlayListener);
    }

    public void setPlayerView(TXCloudVideoView tXCloudVideoView) {
        this.mImpl.setPlayerView(tXCloudVideoView);
    }

    public void setRate(float f) {
        this.mImpl.setRate(f);
    }

    public void setRenderMode(int i) {
        this.mImpl.setRenderMode(i);
    }

    public void setRenderRotation(int i) {
        this.mImpl.setRenderRotation(i);
    }

    public void setSurface(Surface surface) {
        this.mImpl.setSurface(surface);
    }

    public void setSurfaceSize(int i, int i2) {
        this.mImpl.setSurfaceSize(i, i2);
    }

    public void setVideoRawDataListener(ITXVideoRawDataListener iTXVideoRawDataListener) {
        this.mImpl.setVideoRawDataListener(iTXVideoRawDataListener);
    }

    public void setVideoRecordListener(TXRecordCommon.ITXVideoRecordListener iTXVideoRecordListener) {
        this.mImpl.setVideoRecordListener(iTXVideoRecordListener);
    }

    public int setVideoRenderListener(ITXLivePlayVideoRenderListener iTXLivePlayVideoRenderListener, Object obj) {
        return this.mImpl.setVideoRenderListener(iTXLivePlayVideoRenderListener, obj);
    }

    public void setVolume(int i) {
        this.mImpl.setVolume(i);
    }

    public void showDebugView(boolean z) {
        this.mImpl.showDebugView(z);
    }

    public void snapshot(ITXSnapshotListener iTXSnapshotListener) {
        this.mImpl.snapshot(iTXSnapshotListener);
    }

    public int startPlay(String str, int i) {
        return this.mImpl.startPlay(str, i);
    }

    public int startRecord(int i) {
        return this.mImpl.startRecord(i);
    }

    public int stopPlay(boolean z) {
        return this.mImpl.stopPlay(z);
    }

    public int stopRecord() {
        return this.mImpl.stopRecord();
    }

    public int switchStream(String str) {
        return this.mImpl.switchStream(str);
    }
}
