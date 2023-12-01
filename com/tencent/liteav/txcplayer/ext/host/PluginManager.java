package com.tencent.liteav.txcplayer.ext.host;

import android.text.TextUtils;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.txcplayer.ext.config.PluginConfigCenter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/txcplayer/ext/host/PluginManager.class */
public class PluginManager {
    private static final String TAG = "HostEngine-PluginManager";
    private static PluginManager mInstance;
    private List<PluginInfo> mPluginConfigList;
    private ConcurrentHashMap<Integer, IPluginBase> mPluginMap = new ConcurrentHashMap<>();

    private PluginManager() {
    }

    private boolean _doLoadPlugin(PluginInfo pluginInfo) {
        int i = pluginInfo.mPluginId;
        if (this.mPluginMap.containsKey(Integer.valueOf(i))) {
            LiteavLog.w(TAG, "[loadPlugin], pluginId has been loaded!!, pluginId=".concat(String.valueOf(i)));
            return true;
        }
        IPluginBase createPluginInstance = createPluginInstance(i, pluginInfo.mPluginClazzName);
        if (createPluginInstance == null) {
            LiteavLog.w(TAG, "[loadPlugin], pluginId=" + i + " is not exist, do not load!!");
            return false;
        }
        createPluginInstance.onCreate(HostEngine.getInstance().getAppContext());
        this.mPluginMap.put(Integer.valueOf(i), createPluginInstance);
        LiteavLog.d(TAG, "[loadPlugin], succeed loading pluginId=" + i + " ,pluginClazzName=" + pluginInfo.mPluginClazzName);
        return true;
    }

    private IPluginBase createPluginInstance(int i, String str) {
        LiteavLog.i(TAG, "[createPluginInstance],pluginId|" + i + "|clazzName|" + str);
        IPluginBase iPluginBase = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            Class<?> cls = Class.forName(str);
            if (cls != null) {
                iPluginBase = (IPluginBase) cls.newInstance();
            }
            return iPluginBase;
        } catch (Exception e) {
            LiteavLog.w(TAG, "create pluginInstance exception, pluginId|" + i + "|clazzName|" + str + " is not install in dex!!");
            return null;
        }
    }

    private void doLoadPlugin() {
        for (PluginInfo pluginInfo : this.mPluginConfigList) {
            LiteavLog.d(TAG, "[loadPlugin], pluginId=" + pluginInfo.mPluginId + " ,pluginClazzName=" + pluginInfo.mPluginClazzName);
            if (pluginInfo.mIsCorePlugin) {
                _doLoadPlugin(pluginInfo);
            } else {
                LiteavLog.d(TAG, "[loadPlugin], pluginId=" + pluginInfo.mPluginId + " is not core plugin, do not load by default");
            }
        }
    }

    public static PluginManager getInstance() {
        if (mInstance == null) {
            synchronized (PluginManager.class) {
                try {
                    if (mInstance == null) {
                        mInstance = new PluginManager();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return mInstance;
    }

    private void loadPluginConfig() {
        if (this.mPluginConfigList == null) {
            this.mPluginConfigList = new ArrayList();
        }
        PluginConfigCenter.loadPluginConfig(this.mPluginConfigList);
    }

    public boolean checkAndLoadPlugin(int i) {
        PluginInfo pluginInfo;
        if (this.mPluginMap.containsKey(Integer.valueOf(i))) {
            return true;
        }
        Iterator<PluginInfo> it = this.mPluginConfigList.iterator();
        do {
            pluginInfo = null;
            if (!it.hasNext()) {
                break;
            }
            pluginInfo = it.next();
        } while (pluginInfo.mPluginId != i);
        if (pluginInfo != null) {
            return _doLoadPlugin(pluginInfo);
        }
        return false;
    }

    public IPluginBase getPluginInstance(int i) {
        return this.mPluginMap.get(Integer.valueOf(i));
    }

    public void loadPlugin() {
        loadPluginConfig();
        doLoadPlugin();
    }

    public void unLoadPlugin() {
        for (PluginInfo pluginInfo : this.mPluginConfigList) {
            int i = pluginInfo.mPluginId;
            LiteavLog.w(TAG, "[unLoadPlugin], unLoadPlugin=".concat(String.valueOf(i)));
            IPluginBase iPluginBase = this.mPluginMap.get(Integer.valueOf(i));
            if (iPluginBase != null) {
                iPluginBase.onDestroy();
                this.mPluginMap.remove(Integer.valueOf(i));
            }
        }
    }
}
