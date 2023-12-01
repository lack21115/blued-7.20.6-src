package com.tencent.liteav.txcplayer.ext.host;

import android.content.Context;
import java.util.Map;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/txcplayer/ext/host/IPluginBase.class */
public interface IPluginBase {
    PluginInfo getPluginInfo();

    void handleAsyncRequest(int i, int i2, Map<String, Object> map, PluginCallback pluginCallback);

    void handleSyncRequest(int i, int i2, Map<String, Object> map, Map<String, Object> map2);

    void onCreate(Context context);

    void onDestroy();
}
