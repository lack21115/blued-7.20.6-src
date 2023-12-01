package com.tencent.thumbplayer.api.richmedia;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/api/richmedia/ITPRichMediaSynchronizerListener.class */
public interface ITPRichMediaSynchronizerListener {
    void onDeselectFeatureSuccess(ITPRichMediaSynchronizer iTPRichMediaSynchronizer, int i);

    void onRichMediaError(ITPRichMediaSynchronizer iTPRichMediaSynchronizer, int i);

    void onRichMediaFeatureData(ITPRichMediaSynchronizer iTPRichMediaSynchronizer, int i, TPRichMediaFeatureData tPRichMediaFeatureData);

    void onRichMediaFeatureFailure(ITPRichMediaSynchronizer iTPRichMediaSynchronizer, int i, int i2);

    void onRichMediaInfo(ITPRichMediaSynchronizer iTPRichMediaSynchronizer, int i, long j, long j2, long j3, Object obj);

    void onRichMediaPrepared(ITPRichMediaSynchronizer iTPRichMediaSynchronizer);

    void onSelectFeatureSuccess(ITPRichMediaSynchronizer iTPRichMediaSynchronizer, int i);
}
