package com.tencent.thumbplayer.core.downloadproxy.api;

import android.content.Context;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/core/downloadproxy/api/ITPDownloadProxy.class */
public interface ITPDownloadProxy {
    int checkResourceStatus(String str, String str2, int i);

    int clearCache(String str, String str2, int i);

    int deinit();

    String getClipPlayUrl(int i, int i2, int i3);

    String getNativeInfo(int i);

    String getPlayErrorCodeStr(int i);

    String getPlayUrl(int i, int i2);

    long getResourceSize(String str, String str2);

    int init(Context context, TPDLProxyInitParam tPDLProxyInitParam);

    int pauseDownload(int i);

    void pushEvent(int i);

    int removeStorageCache(String str);

    int resumeDownload(int i);

    boolean setClipInfo(int i, int i2, String str, TPDownloadParam tPDownloadParam);

    void setLogListener(ITPDLProxyLogListener iTPDLProxyLogListener);

    void setMaxStorageSizeMB(long j);

    void setPlayState(int i, int i2);

    void setUserData(String str, Object obj);

    int startClipOfflineDownload(String str, int i, ITPOfflineDownloadListener iTPOfflineDownloadListener);

    int startClipPlay(String str, int i, ITPPlayListener iTPPlayListener);

    int startClipPreload(String str, int i, ITPPreLoadListener iTPPreLoadListener);

    int startOfflineDownload(String str, TPDownloadParam tPDownloadParam, ITPOfflineDownloadListener iTPOfflineDownloadListener);

    int startPlay(String str, TPDownloadParam tPDownloadParam, ITPPlayListener iTPPlayListener);

    int startPreload(String str, TPDownloadParam tPDownloadParam, ITPPreLoadListener iTPPreLoadListener);

    void startTask(int i);

    void stopOfflineDownload(int i);

    void stopPlay(int i);

    void stopPreload(int i);

    void updateStoragePath(String str);

    void updateTaskInfo(int i, String str, Object obj);
}
