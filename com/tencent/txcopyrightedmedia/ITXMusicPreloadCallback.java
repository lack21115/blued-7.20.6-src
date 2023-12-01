package com.tencent.txcopyrightedmedia;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/txcopyrightedmedia/ITXMusicPreloadCallback.class */
public interface ITXMusicPreloadCallback {
    void onPreloadComplete(String str, String str2, int i, String str3);

    void onPreloadProgress(String str, String str2, float f);

    void onPreloadStart(String str, String str2);
}
