package com.tencent.thumbplayer.api.composition;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/api/composition/ITPMediaTrackClip.class */
public interface ITPMediaTrackClip extends ITPMediaAsset {
    ITPMediaTrackClip clone(int i);

    int getClipId();

    long getEndTimeMs();

    String getFilePath();

    long getOriginalDurationMs();

    long getStartPositionMs();

    long getStartTimeMs();

    void setCutTimeRange(long j, long j2);

    void setOriginalDurationMs(long j);

    void setStartPositionMs(long j);
}
