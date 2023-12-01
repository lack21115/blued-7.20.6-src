package com.tencent.thumbplayer.api;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/api/ITPPlayerListener.class */
public class ITPPlayerListener {

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/api/ITPPlayerListener$IOnAudioFrameOutputListener.class */
    public interface IOnAudioFrameOutputListener {
        void onAudioFrameOut(ITPPlayer iTPPlayer, TPAudioFrameBuffer tPAudioFrameBuffer);
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/api/ITPPlayerListener$IOnAudioProcessFrameOutputListener.class */
    public interface IOnAudioProcessFrameOutputListener {
        TPPostProcessFrameBuffer onAudioProcessFrameOut(ITPPlayer iTPPlayer, TPPostProcessFrameBuffer tPPostProcessFrameBuffer);
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/api/ITPPlayerListener$IOnCompletionListener.class */
    public interface IOnCompletionListener {
        void onCompletion(ITPPlayer iTPPlayer);
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/api/ITPPlayerListener$IOnDemuxerListener.class */
    public interface IOnDemuxerListener {
        TPRemoteSdpInfo onSdpExchange(ITPPlayer iTPPlayer, String str, int i);
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/api/ITPPlayerListener$IOnDetailInfoListener.class */
    public interface IOnDetailInfoListener {
        void onDetailInfo(ITPPlayer iTPPlayer, TPPlayerDetailInfo tPPlayerDetailInfo);
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/api/ITPPlayerListener$IOnErrorListener.class */
    public interface IOnErrorListener {
        void onError(ITPPlayer iTPPlayer, int i, int i2, long j, long j2);
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/api/ITPPlayerListener$IOnInfoListener.class */
    public interface IOnInfoListener {
        void onInfo(ITPPlayer iTPPlayer, int i, long j, long j2, Object obj);
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/api/ITPPlayerListener$IOnPreparedListener.class */
    public interface IOnPreparedListener {
        void onPrepared(ITPPlayer iTPPlayer);
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/api/ITPPlayerListener$IOnSeekCompleteListener.class */
    public interface IOnSeekCompleteListener {
        void onSeekComplete(ITPPlayer iTPPlayer);
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/api/ITPPlayerListener$IOnStateChangeListener.class */
    public interface IOnStateChangeListener {
        void onStateChange(int i, int i2);
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/api/ITPPlayerListener$IOnStopAsyncCompleteListener.class */
    public interface IOnStopAsyncCompleteListener {
        void onStopAsyncComplete(ITPPlayer iTPPlayer);
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/api/ITPPlayerListener$IOnSubtitleDataListener.class */
    public interface IOnSubtitleDataListener {
        void onSubtitleData(ITPPlayer iTPPlayer, TPSubtitleData tPSubtitleData);
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/api/ITPPlayerListener$IOnSubtitleFrameOutListener.class */
    public interface IOnSubtitleFrameOutListener {
        void onSubtitleFrameOut(ITPPlayer iTPPlayer, TPSubtitleFrameBuffer tPSubtitleFrameBuffer);
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/api/ITPPlayerListener$IOnVideoFrameOutListener.class */
    public interface IOnVideoFrameOutListener {
        void onVideoFrameOut(ITPPlayer iTPPlayer, TPVideoFrameBuffer tPVideoFrameBuffer);
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/api/ITPPlayerListener$IOnVideoProcessFrameOutputListener.class */
    public interface IOnVideoProcessFrameOutputListener {
        TPPostProcessFrameBuffer onVideoProcessFrameOut(ITPPlayer iTPPlayer, TPPostProcessFrameBuffer tPPostProcessFrameBuffer);
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/api/ITPPlayerListener$IOnVideoSizeChangedListener.class */
    public interface IOnVideoSizeChangedListener {
        void onVideoSizeChanged(ITPPlayer iTPPlayer, long j, long j2);
    }
}
