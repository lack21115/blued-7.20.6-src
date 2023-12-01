package com.tencent.thumbplayer.api.proxy;

import java.util.ArrayList;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/api/proxy/ITPPreloadProxy.class */
public interface ITPPreloadProxy {

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/api/proxy/ITPPreloadProxy$IPreloadListener.class */
    public interface IPreloadListener {
        void onPrepareDownloadProgressUpdate(int i, int i2, long j, long j2);

        void onPrepareError();

        void onPrepareSuccess();
    }

    String getPlayErrorCodeStr(int i);

    boolean isAvailable();

    void pushEvent(int i);

    void setPreloadListener(IPreloadListener iPreloadListener);

    int startClipPreload(String str, ArrayList<TPDownloadParamData> arrayList);

    int startPreload(String str, TPDownloadParamData tPDownloadParamData);

    int startPreload(String str, TPDownloadParamData tPDownloadParamData, Map<String, String> map);

    void stopPreload(int i);
}
