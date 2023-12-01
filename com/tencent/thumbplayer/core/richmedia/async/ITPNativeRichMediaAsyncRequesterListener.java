package com.tencent.thumbplayer.core.richmedia.async;

import com.tencent.thumbplayer.core.richmedia.TPNativeRichMediaFeatureData;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/core/richmedia/async/ITPNativeRichMediaAsyncRequesterListener.class */
public interface ITPNativeRichMediaAsyncRequesterListener {
    void onFeatureDataRequestFailure(ITPNativeRichMediaAsyncRequester iTPNativeRichMediaAsyncRequester, int i, int i2, int i3);

    void onFeatureDataRequestSuccess(ITPNativeRichMediaAsyncRequester iTPNativeRichMediaAsyncRequester, int i, int i2, TPNativeRichMediaFeatureData tPNativeRichMediaFeatureData);

    void onRequesterError(ITPNativeRichMediaAsyncRequester iTPNativeRichMediaAsyncRequester, int i);

    void onRequesterPrepared(ITPNativeRichMediaAsyncRequester iTPNativeRichMediaAsyncRequester);
}
