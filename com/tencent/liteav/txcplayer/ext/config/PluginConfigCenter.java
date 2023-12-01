package com.tencent.liteav.txcplayer.ext.config;

import com.tencent.liteav.txcplayer.ext.host.EngineConst;
import com.tencent.liteav.txcplayer.ext.host.PluginInfo;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/txcplayer/ext/config/PluginConfigCenter.class */
public class PluginConfigCenter {
    private static final int[] sPluginIds = {2};
    private static final String[] sPluginName = {EngineConst.PluginName.MONET_PLUGIN_NAME};
    private static final int[] sPluginVersion = {1};
    private static final String[] sPluginClazzName = {EngineConst.PluginClazzName.MONET_PLUGIN_CLAZZ_NAME};
    private static final boolean[] sIsCorePlugin = {true};

    public static void loadPluginConfig(List<PluginInfo> list) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= sPluginIds.length) {
                return;
            }
            PluginInfo pluginInfo = new PluginInfo();
            pluginInfo.mPluginId = sPluginIds[i2];
            pluginInfo.mPluginName = sPluginName[i2];
            pluginInfo.mPluginVersion = sPluginVersion[i2];
            pluginInfo.mPluginClazzName = sPluginClazzName[i2];
            pluginInfo.mIsCorePlugin = sIsCorePlugin[i2];
            list.add(pluginInfo);
            i = i2 + 1;
        }
    }
}
