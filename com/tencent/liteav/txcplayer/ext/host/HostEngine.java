package com.tencent.liteav.txcplayer.ext.host;

import android.content.Context;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.txcplayer.ext.service.RenderProcessService;
import java.util.Map;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/txcplayer/ext/host/HostEngine.class */
public class HostEngine {
    public static final String TAG = "HostEngine";
    private static HostEngine mInstance;
    private Context mAppContext;
    private boolean mIsInit = false;

    private HostEngine() {
    }

    public static HostEngine getInstance() {
        if (mInstance == null) {
            synchronized (HostEngine.class) {
                try {
                    if (mInstance == null) {
                        mInstance = new HostEngine();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return mInstance;
    }

    public boolean checkAndLoadPlugin(int i) {
        LiteavLog.i(TAG, "[checkAndLoadPlugin], pluginId=".concat(String.valueOf(i)));
        return PluginManager.getInstance().checkAndLoadPlugin(i);
    }

    public Context getAppContext() {
        return this.mAppContext;
    }

    public void handleSyncRequestHandleByHost(int i, Map<String, Object> map, Map<String, Object> map2) {
        LiteavLog.w(TAG, "[handleSyncRequestHandleByHost], functionId=" + i + " ,inParams=" + map + " ,outParams=" + map2);
        if (i != 1) {
            return;
        }
        int vodLicenseFeature = RenderProcessService.getInstance().getVodLicenseFeature();
        if (map2 != null) {
            map2.put("KEY_RET_PARAM1", Integer.valueOf(vodLicenseFeature));
        }
    }

    public void init(Context context) {
        synchronized (this) {
            LiteavLog.d(TAG, "[init], appContext=" + context + " ,mIsInit=" + this.mIsInit);
            if (this.mIsInit) {
                return;
            }
            this.mAppContext = context;
            onCreate();
            this.mIsInit = true;
        }
    }

    public void onCreate() {
        LiteavLog.d(TAG, "[onCreate]");
        PluginManager.getInstance().loadPlugin();
    }

    public void onDestroy() {
        LiteavLog.d(TAG, "[onDestroy]");
        PluginManager.getInstance().unLoadPlugin();
    }

    public void sendAsyncRequestToPlugin(int i, int i2, Map<String, Object> map, PluginCallback pluginCallback) {
        IPluginBase pluginInstance = PluginManager.getInstance().getPluginInstance(i);
        if (pluginInstance != null) {
            pluginInstance.handleAsyncRequest(i, i2, map, pluginCallback);
            return;
        }
        LiteavLog.w(TAG, "[sendAsyncRequestToPlugin], destPluginId=" + i + " is not loaded");
    }

    public void sendSyncRequestHandleByHost(int i, Map<String, Object> map, Map<String, Object> map2) {
        handleSyncRequestHandleByHost(i, map, map2);
    }

    public void sendSyncRequestToPlugin(int i, int i2, Map<String, Object> map, Map<String, Object> map2) {
        IPluginBase pluginInstance = PluginManager.getInstance().getPluginInstance(i);
        if (pluginInstance != null) {
            pluginInstance.handleSyncRequest(i, i2, map, map2);
            return;
        }
        LiteavLog.w(TAG, "[sendSyncRequestToPlugin], destPluginId=" + i + " is not loaded");
    }
}
