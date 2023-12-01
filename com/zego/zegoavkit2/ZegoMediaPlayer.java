package com.zego.zegoavkit2;

import android.net.Uri;
import java.nio.ByteBuffer;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/zego/zegoavkit2/ZegoMediaPlayer.class */
public final class ZegoMediaPlayer {
    public static final int PlayerTypeAux = 1;
    public static final int PlayerTypePlayer = 0;
    private int mPlayerIndex;

    /* loaded from: source-8829756-dex2jar.jar:com/zego/zegoavkit2/ZegoMediaPlayer$AudioChannel.class */
    public static final class AudioChannel {
        public static final int All = 3;
        public static final int Left = 1;
        public static final int Right = 2;
    }

    /* loaded from: source-8829756-dex2jar.jar:com/zego/zegoavkit2/ZegoMediaPlayer$AudioTrackMode.class */
    public static final class AudioTrackMode {
        public static final int Multiple = 1;
        public static final int Normal = 0;
    }

    /* loaded from: source-8829756-dex2jar.jar:com/zego/zegoavkit2/ZegoMediaPlayer$CacheStat.class */
    public static class CacheStat {
        public int time = 0;
        public int size = 0;
    }

    /* loaded from: source-8829756-dex2jar.jar:com/zego/zegoavkit2/ZegoMediaPlayer$ErrorCode.class */
    public static final class ErrorCode {
        public static final int ErrorCodec = -3;
        public static final int ErrorDemux = -5;
        public static final int ErrorFile = -1;
        public static final int ErrorPath = -2;
        public static final int FrameDrop = -6;
        public static final int LoadTimeout = -7;
        public static final int NoSupportStream = -4;
        public static final int OK = 0;
    }

    /* loaded from: source-8829756-dex2jar.jar:com/zego/zegoavkit2/ZegoMediaPlayer$PlayerIndex.class */
    public static final class PlayerIndex {
        public static final int First = 0;
        public static final int Fourth = 3;
        public static final int Second = 1;
        public static final int Third = 2;
    }

    /* loaded from: source-8829756-dex2jar.jar:com/zego/zegoavkit2/ZegoMediaPlayer$PlayerViewMode.class */
    public static final class PlayerViewMode {
        public static final int ScaleAspectFill = 1;
        public static final int ScaleAspectFit = 0;
        public static final int ScaleToFill = 2;
    }

    private native void clearViewNative(int i);

    private native void enableAccurateSeekNative(boolean z, int i);

    private native void enableAudioPlayCallbackNative(boolean z, int i);

    private native void enableBlockDataCallbackNative(boolean z, int i, int i2);

    private native void enableEventCallbackNative(boolean z, int i);

    private native void enableMediaSideInfoCallbackNative(boolean z, int i);

    private native void enableRepeatModeNative(boolean z, int i);

    private native void enableVideoPlayCallbackNative(boolean z, int i, int i2);

    private native void enableZegoMediaPlayerFileReaderNative(boolean z, int i);

    private native long getAudioStreamCountNative(int i);

    private native long getCurrentDurationNative(int i);

    private native long getDurationNative(int i);

    private native String getMetaDataValueNative(String str, int i);

    private native boolean getOnlineResourceCacheStatNative(CacheStat cacheStat, int i);

    private native int getPlayVolumeNative(int i);

    private native int getPublishVolumeNative(int i);

    private native void initNative(int i, int i2);

    private native void loadCopyrightedMusicNative(String str, long j, int i);

    private native void loadNative(String str, long j, int i);

    private native void loadNative2(ByteBuffer byteBuffer, int i, long j, int i2);

    private native void muteLocalNative(boolean z, int i);

    private native void pauseNative(int i);

    private native boolean requireHWDecoderNative(int i);

    private native void resumeNative(int i);

    private native void seekToNative(long j, int i);

    private native void setAccurateSeekTimeoutNative(long j, int i);

    private native void setActiveAudioChannelNative(int i, int i2);

    private native void setAudioChannelKeyShiftNative(int i, float f, int i2);

    private native void setAudioPublishStreamNative(long j, int i);

    private native long setAudioStreamNative(long j, int i);

    private native void setAudioTrackModeNative(int i, int i2);

    private native void setBackgroundColorNative(int i, int i2);

    private native void setBufferThresholdNative(int i, int i2);

    private native void setHttpHeadersNative(Map<String, String> map, int i);

    private native void setLoadResourceTimeoutNative(int i, int i2);

    private native void setLoopCountNative(int i, int i2);

    private native void setOnlineResourceCacheNative(int i, int i2, int i3);

    private native void setPlaySpeedNative(float f, int i);

    private native void setPlayVolumeNative(int i, int i2);

    private native void setPlayerTypeNative(int i, int i2);

    private native boolean setProcessIntervalNative(long j, int i);

    private native void setPublishVolumeNative(int i, int i2);

    private native void setViewModeNative(int i, int i2);

    private native void setViewNative(Object obj, int i);

    private native void setVolumeNative(int i, int i2);

    private native void startCopyrightedMusicNative(String str, long j, int i);

    private native void startNative(String str, boolean z, long j, int i);

    private native void startNative2(String str, long j, int i);

    private native void startNative3(ByteBuffer byteBuffer, int i, long j, int i2);

    private native void stopNative(int i);

    private native void takeSnapshotNative(int i);

    private native void uninitNative(int i);

    public void clearView() {
        clearViewNative(this.mPlayerIndex);
    }

    public void enableAccurateSeek(boolean z) {
        enableAccurateSeekNative(z, this.mPlayerIndex);
    }

    @Deprecated
    public void enableRepeatMode(boolean z) {
        enableRepeatModeNative(z, this.mPlayerIndex);
    }

    public long getAudioStreamCount() {
        return getAudioStreamCountNative(this.mPlayerIndex);
    }

    public long getCurrentDuration() {
        return getCurrentDurationNative(this.mPlayerIndex);
    }

    public long getDuration() {
        return getDurationNative(this.mPlayerIndex);
    }

    public String getMetaDataValue(String str) {
        return getMetaDataValueNative(str, this.mPlayerIndex);
    }

    public boolean getOnlineResourceCacheStat(CacheStat cacheStat) {
        return getOnlineResourceCacheStatNative(cacheStat, this.mPlayerIndex);
    }

    public int getPlayVolume() {
        return getPlayVolumeNative(this.mPlayerIndex);
    }

    public int getPublishVolume() {
        return getPublishVolumeNative(this.mPlayerIndex);
    }

    @Deprecated
    public void init(int i) {
        this.mPlayerIndex = 0;
        init(i, 0);
    }

    public void init(int i, int i2) {
        this.mPlayerIndex = i2;
        initNative(i, i2);
    }

    public void load(Uri uri) {
        load(uri, 0L);
    }

    public void load(Uri uri, long j) {
        loadNative(uri != null ? uri.toString() : "", j, this.mPlayerIndex);
    }

    public void load(String str) {
        load(str, 0L);
    }

    public void load(String str, long j) {
        loadNative(str, j, this.mPlayerIndex);
    }

    public void load(ByteBuffer byteBuffer, long j) {
        if (byteBuffer == null) {
            return;
        }
        loadNative2(byteBuffer, byteBuffer.limit(), j, this.mPlayerIndex);
    }

    public void loadCopyrightedMusic(String str, long j) {
        loadCopyrightedMusicNative(str, j, this.mPlayerIndex);
    }

    public void muteLocal(boolean z) {
        muteLocalNative(z, this.mPlayerIndex);
    }

    public void pause() {
        pauseNative(this.mPlayerIndex);
    }

    public boolean requireHWDecoder() {
        return requireHWDecoderNative(this.mPlayerIndex);
    }

    public void resume() {
        resumeNative(this.mPlayerIndex);
    }

    public void seekTo(long j) {
        seekToNative(j, this.mPlayerIndex);
    }

    public void setAccurateSeekTimeout(long j) {
        setAccurateSeekTimeoutNative(j, this.mPlayerIndex);
    }

    public void setActiveAudioChannel(int i) {
        setActiveAudioChannelNative(i, this.mPlayerIndex);
    }

    public void setAudioChannelKeyShift(int i, float f) {
        setAudioChannelKeyShiftNative(i, f, this.mPlayerIndex);
    }

    public void setAudioPlayCallback(IZegoMediaPlayerAudioPlayCallback iZegoMediaPlayerAudioPlayCallback) {
        ZegoMediaPlayerCallbackBridge.setAudioDataCallback(iZegoMediaPlayerAudioPlayCallback, this.mPlayerIndex);
        enableAudioPlayCallbackNative(iZegoMediaPlayerAudioPlayCallback != null, this.mPlayerIndex);
    }

    public void setAudioPublishStream(long j) {
        setAudioPublishStreamNative(j, this.mPlayerIndex);
    }

    public long setAudioStream(long j) {
        return setAudioStreamNative(j, this.mPlayerIndex);
    }

    public void setAudioTrackMode(int i) {
        setAudioTrackModeNative(i, this.mPlayerIndex);
    }

    public void setBackgroundColor(int i) {
        setBackgroundColorNative(i, this.mPlayerIndex);
    }

    public void setBlockDataCallback(IZegoMediaPlayerBlockDataCallback iZegoMediaPlayerBlockDataCallback, int i) {
        ZegoMediaPlayerCallbackBridge.setBlockDataCallback(iZegoMediaPlayerBlockDataCallback, this.mPlayerIndex);
        enableBlockDataCallbackNative(iZegoMediaPlayerBlockDataCallback != null, i, this.mPlayerIndex);
    }

    public void setBufferThreshold(int i) {
        setBufferThresholdNative(i, this.mPlayerIndex);
    }

    public void setEventWithIndexCallback(IZegoMediaPlayerWithIndexCallback iZegoMediaPlayerWithIndexCallback) {
        ZegoMediaPlayerCallbackBridge.setEventWithIndexCallback(iZegoMediaPlayerWithIndexCallback, this.mPlayerIndex);
        enableEventCallbackNative(iZegoMediaPlayerWithIndexCallback != null, this.mPlayerIndex);
    }

    public void setHttpHeaders(Map<String, String> map) {
        setHttpHeadersNative(map, this.mPlayerIndex);
    }

    public void setLoadResourceTimeout(int i) {
        setLoadResourceTimeoutNative(i, this.mPlayerIndex);
    }

    public void setLoopCount(int i) {
        setLoopCountNative(i, this.mPlayerIndex);
    }

    public void setMediaPlayerFileReader(ZegoMediaPlayerFileReader zegoMediaPlayerFileReader) {
        ZegoMediaPlayerCallbackBridge.setMediaPlayerFileReader(zegoMediaPlayerFileReader, this.mPlayerIndex);
        enableZegoMediaPlayerFileReaderNative(zegoMediaPlayerFileReader != null, this.mPlayerIndex);
    }

    public void setMediaSideInfoCallback(IZegoMediaPlayerMediaSideInfoCallback iZegoMediaPlayerMediaSideInfoCallback) {
        ZegoMediaPlayerCallbackBridge.setMediaSideInfoCallback(iZegoMediaPlayerMediaSideInfoCallback, this.mPlayerIndex);
        enableMediaSideInfoCallbackNative(iZegoMediaPlayerMediaSideInfoCallback != null, this.mPlayerIndex);
    }

    public void setOnlineResourceCache(int i, int i2) {
        setOnlineResourceCacheNative(i, i2, this.mPlayerIndex);
    }

    public void setPlaySpeed(float f) {
        setPlaySpeedNative(f, this.mPlayerIndex);
    }

    public void setPlayVolume(int i) {
        setPlayVolumeNative(i, this.mPlayerIndex);
    }

    public void setPlayerType(int i) {
        setPlayerTypeNative(i, this.mPlayerIndex);
    }

    public boolean setProcessInterval(long j) {
        return setProcessIntervalNative(j, this.mPlayerIndex);
    }

    public void setPublishVolume(int i) {
        setPublishVolumeNative(i, this.mPlayerIndex);
    }

    public void setVideoPlayWithIndexCallback(IZegoMediaPlayerVideoPlayWithIndexCallback iZegoMediaPlayerVideoPlayWithIndexCallback, int i) {
        ZegoMediaPlayerCallbackBridge.setVideoDataWithIndexCallback(iZegoMediaPlayerVideoPlayWithIndexCallback, this.mPlayerIndex);
        enableVideoPlayCallbackNative(iZegoMediaPlayerVideoPlayWithIndexCallback != null, i, this.mPlayerIndex);
    }

    public void setVideoPlayWithIndexCallback2(IZegoMediaPlayerVideoPlayWithIndexCallback2 iZegoMediaPlayerVideoPlayWithIndexCallback2, int i) {
        ZegoMediaPlayerCallbackBridge.setVideoDataWithIndexCallback2(iZegoMediaPlayerVideoPlayWithIndexCallback2, this.mPlayerIndex);
        enableVideoPlayCallbackNative(iZegoMediaPlayerVideoPlayWithIndexCallback2 != null, i, this.mPlayerIndex);
    }

    public void setView(Object obj) {
        setViewNative(obj, this.mPlayerIndex);
    }

    public void setViewMode(int i) {
        setViewModeNative(i, this.mPlayerIndex);
    }

    public void setVolume(int i) {
        setVolumeNative(i, this.mPlayerIndex);
    }

    public void start(Uri uri, long j) {
        startNative2(uri != null ? uri.toString() : "", j, this.mPlayerIndex);
    }

    public void start(String str, long j) {
        startNative2(str, j, this.mPlayerIndex);
    }

    @Deprecated
    public void start(String str, boolean z) {
        start(str, z, 0L);
    }

    @Deprecated
    public void start(String str, boolean z, long j) {
        startNative(str, z, j, this.mPlayerIndex);
    }

    public void start(ByteBuffer byteBuffer, long j) {
        if (byteBuffer == null) {
            return;
        }
        startNative3(byteBuffer, byteBuffer.limit(), j, this.mPlayerIndex);
    }

    public void startCopyrightedMusic(String str, long j) {
        startCopyrightedMusicNative(str, j, this.mPlayerIndex);
    }

    public void stop() {
        stopNative(this.mPlayerIndex);
    }

    public void takeSnapshot() {
        takeSnapshotNative(this.mPlayerIndex);
    }

    public void uninit() {
        setEventWithIndexCallback(null);
        setMediaPlayerFileReader(null);
        setVideoPlayWithIndexCallback(null, 0);
        setVideoPlayWithIndexCallback2(null, 0);
        setAudioPlayCallback(null);
        ZegoMediaPlayerCallbackBridge.removeVideoDataBuffer(this.mPlayerIndex);
        uninitNative(this.mPlayerIndex);
    }
}
