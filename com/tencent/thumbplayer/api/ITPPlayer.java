package com.tencent.thumbplayer.api;

import android.content.res.AssetFileDescriptor;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.tencent.thumbplayer.adapter.strategy.utils.TPNativeKeyMap;
import com.tencent.thumbplayer.api.ITPPlayerListener;
import com.tencent.thumbplayer.api.composition.ITPMediaAsset;
import com.tencent.thumbplayer.api.proxy.ITPPlayerProxy;
import com.tencent.thumbplayer.api.proxy.TPDownloadParamData;
import com.tencent.thumbplayer.api.report.ITPBusinessReportManager;
import com.tencent.thumbplayer.api.reportv2.ITPExtendReportController;
import com.tencent.thumbplayer.api.resourceloader.ITPAssetResourceLoaderListener;
import com.tencent.thumbplayer.api.richmedia.ITPRichMediaSynchronizer;
import com.tencent.thumbplayer.e.b;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/api/ITPPlayer.class */
public interface ITPPlayer {
    public static final String TP_MIMETYPE_TEXT_SUBRIP = "text/x-subrip";
    public static final String TP_MIMETYPE_TEXT_VTT = "text/vtt";
    public static final int TP_PLAYER_LOOPBACK_ENDPOSITION_DEFAULT = -1;
    public static final int TP_PLAYER_LOOPBACK_STARTPOSITION_DEFAULT = 0;
    @TPNativeKeyMap.MapSeekMode(3)
    public static final int TP_PLAYER_SEEK_MODE_ACCURATE_POSITION = 3;
    @TPNativeKeyMap.MapSeekMode(1)
    public static final int TP_PLAYER_SEEK_MODE_FREVIOUS_KFRAME = 1;
    @TPNativeKeyMap.MapSeekMode(4)
    public static final int TP_PLAYER_SEEK_MODE_NEXT_CLIP = 4;
    @TPNativeKeyMap.MapSeekMode(2)
    public static final int TP_PLAYER_SEEK_MODE_NEXT_KFRAME = 2;
    @TPNativeKeyMap.MapSwitchDefMode(3)
    public static final int TP_PLAYER_SWITCH_DEF_AFTER_ALL_RESOURCE_CONSUME = 3;
    @TPNativeKeyMap.MapSwitchDefMode(0)
    public static final int TP_PLAYER_SWITCH_DEF_DEFAULT = 0;
    @TPNativeKeyMap.MapSwitchDefMode(2)
    public static final int TP_PLAYER_SWITCH_DEF_FAST_WITH_KEEP_NO_BUFFERING = 2;
    @TPNativeKeyMap.MapSwitchDefMode(1)
    public static final int TP_PLAYER_SWITCH_DEF_IMMEDIATELY = 1;

    void addAudioTrackSource(String str, String str2);

    void addAudioTrackSource(String str, String str2, TPDownloadParamData tPDownloadParamData);

    void addSubtitleSource(String str, String str2, String str3);

    void addSubtitleSource(String str, String str2, String str3, TPDownloadParamData tPDownloadParamData);

    void captureVideo(TPCaptureParams tPCaptureParams, TPCaptureCallBack tPCaptureCallBack);

    void deselectTrack(int i, long j);

    void enableTPAssetResourceLoader(ITPAssetResourceLoaderListener iTPAssetResourceLoaderListener, Looper looper);

    int getBufferPercent();

    long getCurrentPositionMs();

    int getCurrentState();

    long getDurationMs();

    ITPExtendReportController getExtendReportController();

    long getPlayableDurationMs();

    ITPPlayerProxy getPlayerProxy();

    int getPlayerType();

    TPProgramInfo[] getProgramInfo();

    long getPropertyLong(int i);

    String getPropertyString(int i);

    ITPBusinessReportManager getReportManager();

    TPTrackInfo[] getTrackInfo();

    int getVideoHeight();

    int getVideoWidth();

    void pause();

    void pauseDownload();

    void prepareAsync();

    void release();

    void reset();

    void resumeDownload();

    void seekTo(int i);

    void seekTo(int i, int i2);

    void selectProgram(int i, long j);

    void selectTrack(int i, long j);

    void setAudioGainRatio(float f);

    void setAudioNormalizeVolumeParams(String str);

    void setDataSource(AssetFileDescriptor assetFileDescriptor);

    void setDataSource(ParcelFileDescriptor parcelFileDescriptor);

    void setDataSource(ITPMediaAsset iTPMediaAsset);

    void setDataSource(String str);

    void setDataSource(String str, Map<String, String> map);

    void setLoopback(boolean z);

    void setLoopback(boolean z, long j, long j2);

    void setOnAudioFrameOutputListener(ITPPlayerListener.IOnAudioFrameOutputListener iOnAudioFrameOutputListener);

    void setOnAudioProcessFrameOutputListener(ITPPlayerListener.IOnAudioProcessFrameOutputListener iOnAudioProcessFrameOutputListener);

    void setOnCompletionListener(ITPPlayerListener.IOnCompletionListener iOnCompletionListener);

    void setOnDemuxerListener(ITPPlayerListener.IOnDemuxerListener iOnDemuxerListener);

    void setOnDetailInfoListener(ITPPlayerListener.IOnDetailInfoListener iOnDetailInfoListener);

    void setOnErrorListener(ITPPlayerListener.IOnErrorListener iOnErrorListener);

    void setOnInfoListener(ITPPlayerListener.IOnInfoListener iOnInfoListener);

    void setOnPlayerStateChangeListener(ITPPlayerListener.IOnStateChangeListener iOnStateChangeListener);

    void setOnPreparedListener(ITPPlayerListener.IOnPreparedListener iOnPreparedListener);

    void setOnSeekCompleteListener(ITPPlayerListener.IOnSeekCompleteListener iOnSeekCompleteListener);

    void setOnStopAsyncCompleteListener(ITPPlayerListener.IOnStopAsyncCompleteListener iOnStopAsyncCompleteListener);

    void setOnSubtitleDataListener(ITPPlayerListener.IOnSubtitleDataListener iOnSubtitleDataListener);

    void setOnSubtitleFrameOutListener(ITPPlayerListener.IOnSubtitleFrameOutListener iOnSubtitleFrameOutListener);

    void setOnVideoFrameOutListener(ITPPlayerListener.IOnVideoFrameOutListener iOnVideoFrameOutListener);

    void setOnVideoProcessFrameOutputListener(ITPPlayerListener.IOnVideoProcessFrameOutputListener iOnVideoProcessFrameOutputListener);

    void setOnVideoSizeChangedListener(ITPPlayerListener.IOnVideoSizeChangedListener iOnVideoSizeChangedListener);

    void setOutputMute(boolean z);

    void setPlaySpeedRatio(float f);

    void setPlayerOptionalParam(TPOptionalParam tPOptionalParam);

    void setRichMediaSynchronizer(ITPRichMediaSynchronizer iTPRichMediaSynchronizer);

    void setSurface(Surface surface);

    void setSurfaceHolder(SurfaceHolder surfaceHolder);

    void setVideoInfo(TPVideoInfo tPVideoInfo);

    void start();

    void stop();

    void stopAsync();

    void switchDefinition(ITPMediaAsset iTPMediaAsset, long j, TPVideoInfo tPVideoInfo);

    void switchDefinition(ITPMediaAsset iTPMediaAsset, long j, TPVideoInfo tPVideoInfo, int i);

    void switchDefinition(String str, long j, TPVideoInfo tPVideoInfo);

    void switchDefinition(String str, long j, TPVideoInfo tPVideoInfo, int i);

    void switchDefinition(String str, long j, TPVideoInfo tPVideoInfo, Map<String, String> map);

    void switchDefinition(String str, long j, TPVideoInfo tPVideoInfo, Map<String, String> map, int i);

    void updateLoggerContext(b bVar);

    void updateTaskInfo(String str, Object obj);
}
