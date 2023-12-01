package com.tencent.thumbplayer.api.resourceloader;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/api/resourceloader/ITPAssetResourceLoadingDataRequest.class */
public interface ITPAssetResourceLoadingDataRequest {
    long getCurrentOffset();

    long getRequestedLength();

    long getRequestedOffset();

    void notifyDataReady(long j, long j2);

    void respondWithData(byte[] bArr);
}
