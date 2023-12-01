package com.tencent.thumbplayer.core.richmedia.async;

import com.tencent.thumbplayer.core.richmedia.TPNativeRichMediaFeature;
import com.tencent.thumbplayer.core.richmedia.TPNativeTimeRange;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/core/richmedia/async/ITPNativeRichMediaAsyncRequester.class */
public interface ITPNativeRichMediaAsyncRequester {
    void cancelRequest(int i);

    TPNativeRichMediaFeature[] getFeatures();

    void prepareAsync();

    void release();

    int requestFeatureDataAsyncAtTimeMs(int i, long j);

    int requestFeatureDataAsyncAtTimeMsArray(int i, long[] jArr);

    int requestFeatureDataAsyncAtTimeRange(int i, TPNativeTimeRange tPNativeTimeRange);

    int requestFeatureDataAsyncAtTimeRanges(int i, TPNativeTimeRange[] tPNativeTimeRangeArr);

    void setRequesterListener(ITPNativeRichMediaAsyncRequesterListener iTPNativeRichMediaAsyncRequesterListener);

    void setRichMediaSource(String str);
}
