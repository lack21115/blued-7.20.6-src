package com.tencent.thumbplayer.api.resourceloader;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/api/resourceloader/ITPAssetResourceLoadingRequest.class */
public interface ITPAssetResourceLoadingRequest {
    void finishLoading();

    TPAssetResourceLoadingContentInformationRequest getContentInformation();

    ITPAssetResourceLoadingDataRequest getLoadingDataRequest();

    boolean isCancelled();

    boolean isFinished();
}
