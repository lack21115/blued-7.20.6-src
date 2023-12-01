package com.tencent.rtmp.downloader;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/rtmp/downloader/ITXVodPreloadListener.class */
public interface ITXVodPreloadListener {
    void onComplete(int i, String str);

    void onError(int i, String str, int i2, String str2);
}
