package com.tencent.rtmp;

import android.view.Surface;
import com.tencent.rtmp.TXLivePlayer;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.ugc.TXRecordCommon;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/rtmp/a.class */
public interface a {
    boolean addVideoRawData(byte[] bArr);

    void callExperimentalAPI(String str);

    void enableAudioVolumeEvaluation(int i);

    boolean enableHardwareDecode(boolean z);

    long getCurrentRenderPts();

    boolean isPlaying();

    void pause();

    int prepareLiveSeek(String str, int i);

    void resume();

    int resumeLive();

    void seek(int i);

    void setAudioRawDataListener(TXLivePlayer.ITXAudioRawDataListener iTXAudioRawDataListener);

    void setAudioRoute(int i);

    void setAudioVolumeEvaluationListener(TXLivePlayer.ITXAudioVolumeEvaluationListener iTXAudioVolumeEvaluationListener);

    void setAutoPlay(boolean z);

    void setConfig(TXLivePlayConfig tXLivePlayConfig);

    void setMute(boolean z);

    void setPlayListener(ITXLivePlayListener iTXLivePlayListener);

    void setPlayerView(TXCloudVideoView tXCloudVideoView);

    void setRate(float f);

    void setRenderMode(int i);

    void setRenderRotation(int i);

    void setSurface(Surface surface);

    void setSurfaceSize(int i, int i2);

    void setVideoRawDataListener(TXLivePlayer.ITXVideoRawDataListener iTXVideoRawDataListener);

    void setVideoRecordListener(TXRecordCommon.ITXVideoRecordListener iTXVideoRecordListener);

    int setVideoRenderListener(TXLivePlayer.ITXLivePlayVideoRenderListener iTXLivePlayVideoRenderListener, Object obj);

    void setVolume(int i);

    void showDebugView(boolean z);

    void snapshot(TXLivePlayer.ITXSnapshotListener iTXSnapshotListener);

    int startPlay(String str, int i);

    int startRecord(int i);

    int stopPlay(boolean z);

    int stopRecord();

    int switchStream(String str);
}
