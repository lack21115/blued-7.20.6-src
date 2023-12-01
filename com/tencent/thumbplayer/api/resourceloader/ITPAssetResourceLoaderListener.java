package com.tencent.thumbplayer.api.resourceloader;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/api/resourceloader/ITPAssetResourceLoaderListener.class */
public interface ITPAssetResourceLoaderListener {
    void didCancelLoadingRequest(ITPAssetResourceLoadingRequest iTPAssetResourceLoadingRequest);

    void fillInContentInformation(TPAssetResourceLoadingContentInformationRequest tPAssetResourceLoadingContentInformationRequest);

    boolean shouldWaitForLoadingOfRequestedResource(ITPAssetResourceLoadingRequest iTPAssetResourceLoadingRequest);
}
