package com.tencent.thumbplayer.api.composition;

import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/api/composition/ITPMediaComposition.class */
public interface ITPMediaComposition extends ITPMediaAsset {
    ITPMediaTrack addAVTrack();

    ITPMediaTrack addAudioTrack();

    ITPMediaTrack addVideoTrack();

    List<ITPMediaTrack> getAllAVTracks();

    List<ITPMediaTrack> getAllAudioTracks();

    List<ITPMediaTrack> getAllVideoTracks();

    long getDurationMs();

    void release();

    boolean removeAVTrack(ITPMediaTrack iTPMediaTrack);

    boolean removeAudioTrack(ITPMediaTrack iTPMediaTrack);

    boolean removeVideoTrack(ITPMediaTrack iTPMediaTrack);
}
